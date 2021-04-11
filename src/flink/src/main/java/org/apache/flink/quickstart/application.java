/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.quickstart;

import com.grpc.*;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import grpcPackage.grpcClient;

import com.thanglequoc.aqicalculator.AQICalculator;
import com.thanglequoc.aqicalculator.AQIResult;
import com.thanglequoc.aqicalculator.Pollutant;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.GlobalWindows;
import org.apache.flink.streaming.api.windowing.evictors.Evictor;
//import org.apache.flink.streaming.api.windowing.triggers.EventTimeTrigger;
import org.apache.flink.streaming.api.windowing.triggers.Trigger;
import org.apache.flink.streaming.api.windowing.triggers.TriggerResult;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.api.windowing.windows.Window;
import org.apache.flink.streaming.runtime.operators.windowing.TimestampedValue;
import org.apache.flink.util.Collector;

import org.apache.flink.streaming.api.windowing.time.Time;

import javax.xml.crypto.KeySelector;
import java.util.List;

import com.grpc.ChallengerGrpc.ChallengerBlockingStub;

// added by Snigdha
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.typeinfo.*;
import org.apache.flink.api.java.tuple.*;
import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.*;
import java.util.*;

/**
 * A simple Flink program that processes the Wikipedia edits stream.
 **/
public class application {

	public static Locations GlobalLocations;
	public static long benchId;
	public static long batchseq;
	public static ChallengerBlockingStub client;
	public static AQICalculator aqicalc = AQICalculator.getAQICalculatorInstance();

	public static int JustTesting = 0;

	public static void main(String[] args) throws Exception {


		// set up the streaming execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		int maxParal = env.getMaxParallelism();
		env.setParallelism(maxParal);

		DataStream<Team8Measurement> measurements = env.addSource(new grpcClient())
														.name("API")
														.broadcast();

//		measurements.print();
		// Set particular parallelism
		DataStream<Team8Measurement> calculateCityAndAqiAndFilter = measurements.map(new MapCityAndAqi())
																	.setParallelism(1)
																	.name("calculateCity")
																	.filter(m -> !m.city.equals("CITYERROR"))
																	.rebalance();

//		calculateCityAndAqiAndFilter.print();

		// Branches out a different operator, (since query 1 and 2 need to recieve data from the same data stream)
		//DataStream<Team8Measurement> calculateCityFilter = measurements.filter();

//		calculateCity.print();
		// Different parallelism splits

//		filterNoCity.print();

		KeyedStream<Team8Measurement, String> measurementsKeyedByCity = calculateCityAndAqiAndFilter.keyBy(m -> m.city);

//		measurementsKeyedByCity.process(new KeyedProcessFunction1()); //for testing

		DataStream<FiveMinuteSnapshot> keyedSnapshots = measurementsKeyedByCity.window(GlobalWindows.create())
								.trigger(new TriggerFiveMinutes())
								.evictor(new EvictFiveMinutes())
								.process(new MeasurementsToSnapshots())
								.name("Query 1");

		keyedSnapshots.print();

//		measurementsKeyedByCity.print();


//		org.apache.flink.api.java.functions.KeySelector<Team8Measurement, String> mkbcKeySelector = measurementsKeyedByCity.getKeySelector();

		// Testing to see if I can connect operators
//		calculateCity.shuffle();

		// query 2 implementation call
		calculateHistogram(calculateCityAndAqiAndFilter).print();

		env.execute("Print Measurements Stream");
	}

	private static class KeyedProcessFunction1 extends KeyedProcessFunction<String, Team8Measurement, Team8Measurement> {

		@Override
		public void processElement(Team8Measurement m, Context ctx, Collector<Team8Measurement> out) {
			if(ctx.getCurrentKey().equals("Essen"))
			{
//				System.out.println("-----------------------------------------------");
//				System.out.println(m);
//				System.out.println(m.measurement.getTimestamp());
				java.util.Date time=new java.util.Date((long)m.measurement.getTimestamp().getSeconds()*1000);
				System.out.println(time);
//				System.out.println("-----------------------------------------------");
			}
		}
	}

	private static class MapCityAndAqi implements MapFunction<Team8Measurement,Team8Measurement> {
		@Override
		public Team8Measurement map(Team8Measurement m) throws Exception {
			m.city = calculateCity(m);
			if(!m.city.equals("CITYERROR"))
				m.aqi = computeAQI(m.measurement, aqicalc);
			return m;
		}

		private String calculateCity(Team8Measurement m) {
			List<Location> locationsal = GlobalLocations.getLocationsList();
			for(int i = 0; i < locationsal.size(); ++i)
			{
				if(isInside(locationsal.get(i).getPolygonsList(), m.measurement.getLatitude(), m.measurement.getLongitude())) {
//					System.out.println(locationsal.get(i).getCity());
					return locationsal.get(i).getCity();
				}
			}
//			System.out.println("TEAM8 ERROR POINT WASN'T FOUND TO BE IN ANY OF THE POLYGONS."); We now know this is not an issue.
			return "CITYERROR";
		}

		// Code retrieved from the web and adapted from js to java.
		// Ray casting.
		private boolean isInside(List<Polygon> polygonList, double latitude, double longitude) {
			for(int k = 0; k < polygonList.size(); ++k)
			{
				Polygon polygon = polygonList.get(k);
				List<Point> vs = polygon.getPointsList();

				// Beginning of external code
				double y = latitude, x = longitude;


				var inside = false;
				for (int i = 0, j = vs.size() - 1; i < vs.size(); j = i++) {
					double xi = vs.get(i).getLongitude(), yi = vs.get(i).getLatitude();
					double xj = vs.get(j).getLongitude(), yj = vs.get(j).getLatitude();

					var intersect = ((yi > y) != (yj > y))
							&& (x < (xj - xi) * (y - yi) / (yj - yi) + xi);
					if (intersect) inside = !inside;
				}

				if(inside)
					return true;
				// End of external code

			}
			return false;
		}

		private int computeAQI(Measurement measurement, AQICalculator aqicalc) {

			float pm25 = measurement.getP1();
			float pm10 = measurement.getP2();

			int result25 = aqicalc.getAQI(Pollutant.PM10, (double) pm10).getAQI();
			int result10 = aqicalc.getAQI(Pollutant.PM25, (double) pm25).getAQI();

			if (result10 > result25){
				return result10;
			}
			else {
				return result25;
			}
		}

		private Boolean isGoodAQI(Measurement measurement, AQICalculator aqicalc) {
			int aqi = computeAQI(measurement, aqicalc);
			return aqi < 50;
		}
	}

//	filterNoCity = filterNoCity.map(new JustUsingMapToTest());
//	private static class JustUsingMapToTest implements MapFunction<Team8Measurement, Team8Measurement> {
//		@Override
//		public Team8Measurement map(Team8Measurement m) throws Exception {
//			System.out.println("TESTING1. CITY = " + m.city);
//			return m;
//		}
//	}



	private static class EvictFiveMinutes implements Evictor<Team8Measurement, GlobalWindow> {

		@Override
		public void evictBefore(Iterable<TimestampedValue<Team8Measurement>> events, int size, GlobalWindow window, EvictorContext ctx) {}

		@Override
		public void evictAfter(Iterable<TimestampedValue<Team8Measurement>> elements, int size, GlobalWindow window, Evictor.EvictorContext ctx) {





//			long firstStop = ConnectedCarEvent.earliestStopElement(elements);
//
//			// remove all events up to (and including) the first stop event (which is the event that triggered the window)
//			for (Iterator<TimestampedValue<ConnectedCarEvent>> iterator = elements.iterator(); iterator.hasNext(); ) {
//				TimestampedValue<ConnectedCarEvent> element = iterator.next();
//				if (element.getTimestamp() <= firstStop) {
//					iterator.remove();
//				}
//			}
		}
	}



	private static class TriggerFiveMinutes<W extends Window> extends Trigger<Object, W> {


		@Override
		public TriggerResult onElement(Object element, long timestamp, W window, TriggerContext ctx) throws Exception {
//			ReducingState<Long> count = ctx.getPartitionedState(stateDesc);
//			count.add(1L);
//			if (count.get() >= maxCount) {
//				count.clear();
//				return TriggerResult.FIRE_AND_PURGE;
//			}

			if(application.JustTesting++ % 100 == 0)
				return TriggerResult.FIRE;
			return TriggerResult.CONTINUE;
		}


		@Override
		public TriggerResult onProcessingTime(long time, W window, TriggerContext ctx) throws Exception {
//			return TriggerResult.FIRE_AND_PURGE;
			return TriggerResult.CONTINUE;
		}

		@Override
		public TriggerResult onEventTime(long time, W window, TriggerContext ctx) {
			return TriggerResult.CONTINUE;
		}

		@Override
		public void clear(W window, TriggerContext ctx) throws Exception {
//			ctx.getPartitionedState(stateDesc).clear();
		}
	}


	private static class MeasurementsToSnapshots extends ProcessWindowFunction<Team8Measurement, FiveMinuteSnapshot, String, TimeWindow> {

		@Override
		public void process(String key, Context context, Iterable<Team8Measurement> input, Collector<FiveMinuteSnapshot> out) {

//			long count = 0;
			int avgAqip1 = 0;
			int avgAqip2 = 0;
			for (Team8Measurement m: input) {
				avgAqip1 += m.measurement.getP1();
				avgAqip2 += m.measurement.getP2();
			}
			out.collect(new FiveMinuteSnapshot(avgAqip1,avgAqip2));
//			out.collect("Window: " + context.window() + "count: " + count);
		}
	}

	// Snigdha

	private static DataStream<List<TopKStreaks>> calculateHistogram(DataStream<Team8Measurement>  calculateCity) throws Exception {
    
    

		// filter measurements for current year
		DataStream<Team8Measurement> currentYearData = calculateCity.filter(m -> m.year.equals("ThisYear"));
		
		// sets attribute isGood of Team8Measurement for each measurement, true if good AQI value, false otherwise																											
       	DataStream<Team8Measurement> calculateGoodAQIs = currentYearData.map(new MapGoodAQIs());
       	
       	// key by city and calculate streaks of good AQI values for each city						
        DataStream<Tuple4<String, Long, Long, Long>> measurementsKeyedByCity = calculateGoodAQIs
			.keyBy(m -> m.city)
			.window(EventTimeSessionWindows.withGap(Time.minutes(10)))
			.process(new ProcessWindowFunction<Team8Measurement, Tuple4<String, Long, Long, Long>, String, TimeWindow>() {
                    
					private transient ValueState<Tuple2<Long, Long>> streak;

                    @Override
                    public void process(String key, Context c, Iterable<Team8Measurement> elements, 
                    							Collector<Tuple4<String, Long, Long, Long>> out) throws Exception {
                        
                        //first value is for start time of the streak. second value is for duration of the streak
				        Tuple2<Long, Long> currentStreak = streak.value();

				        //lastTimeStamp and firstTimeStamp needed for bucket lengths later on
				        long lastTimeStamp = 0L;
				        long firstTimeStamp = 0L;
                        
						for (Team8Measurement m : elements) {
							
							if (m.isGood) {
								if (currentStreak.f0 == 0) {
				              	  currentStreak.f0 = m.timestamp;
				            	}
				            	// revieved a good aqi value so update the duration 
				            	currentStreak.f1 = m.timestamp - currentStreak.f0;
				            }
							else {
								// we recieve a bad AQI value so reset start time and duration
								currentStreak.f0 = 0L;
				            	currentStreak.f1 = 0L;
							}

							lastTimeStamp = m.timestamp;
							if (firstTimeStamp == 0)
								firstTimeStamp = m.timestamp;
								
						}
                        // update the state
				        streak.update(currentStreak);

				        System.out.println("Last time " + lastTimeStamp );

                        if (currentStreak.f1 != 0) {

				                out.collect(new Tuple4<>(key, currentStreak.f1, firstTimeStamp, lastTimeStamp));
				                // streak.clear();
				        }

                    }


                    @Override
				    public void open(Configuration config) {
				        ValueStateDescriptor<Tuple2<Long, Long>> descriptor =
				                new ValueStateDescriptor<>(
				                        "streaks", // the state name
				                        TypeInformation.of(new TypeHint<Tuple2<Long, Long>>() {}), // type information
				                        Tuple2.of(0L, 0L)); // default value of the state, if nothing was set
				        streak = getRuntimeContext().getState(descriptor);
				    }

                });

			// assign cities to buckets based on streak length and output list of TopKStreaks
			DataStream<List<TopKStreaks>> results = 
					measurementsKeyedByCity
					.timeWindowAll(Time.minutes(10))
					.apply(new AllWindowFunction<Tuple4<String, Long, Long, Long>, 
									List<TopKStreaks>, TimeWindow>() {

						@Override
		                    public void apply(TimeWindow window, 
		                    				Iterable<Tuple4<String, Long, Long, Long>> elements, 
		                    				Collector<List<TopKStreaks>> out) throws Exception {

		                    	List<TopKStreaks> result = new ArrayList<TopKStreaks>();
						        int numBuckets = 14;
						        int maxSpan = 0;
						        int bucketWidth = 0;

						        int totalCities = 0;
						        long minTimestamp = Long.MAX_VALUE;
						        long maxTimestamp = 0L;

						        // first loop for getting the earliest and last timestamp of the batch and total cities
						        for (Tuple4<String, Long, Long, Long> m : elements) {

						        	if (m.f2 < minTimestamp)
						        		minTimestamp = m.f2;
						        	if (m.f3 > maxTimestamp)
						        		maxTimestamp = m.f3;
						        	totalCities++;

						        }

						        //get size of each bucket
						        maxSpan = (int)(maxTimestamp - minTimestamp);
						        bucketWidth = maxSpan / numBuckets;
						        if (bucketWidth * numBuckets < maxSpan) {
						        	bucketWidth++;
						        }

						        // System.out.println("MaxSpan " + maxSpan + " BucketWidth " + bucketWidth);

						        //array to keep track of number of cities belonging to each bucket
						        int[] counts = new int[numBuckets];

						        for (Tuple4<String, Long, Long, Long> m : elements) {
						        	// calculate which bucket this city belongs in
						        	int bucket = (int)(m.f1 / bucketWidth);
						        	counts[bucket]++;
						        }

						        //for each bucket, calculate percentage of cities in it and create a TopKStreaks object
						        for (int i = 0; i < counts.length; i++) {
						        	counts[i] = counts[i] * 100 * 1000 / totalCities;
						        	int bucket_from = (int) (i*bucketWidth);
						        	int bucket_to   = (int) (bucket_from + bucketWidth - 1);
						        	TopKStreaks item = TopKStreaks.newBuilder()
						        				.setBucketFrom(bucket_from)
						        				.setBucketTo(bucket_to)
						        				.setBucketPercent(counts[i])
						        				.build();
						        	result.add(item);
						        }

								ResultQ2 submitData = ResultQ2.newBuilder()
																.setBenchmarkId(benchId)
																.setBatchSeqId(batchseq)
																.addAllHistogram(result)
																.build();
								client.resultQ2(submitData);
						        out.collect(result);						        

		                    }
		                        
					});

					return results;

				}


	// End calculateHistogram

}


