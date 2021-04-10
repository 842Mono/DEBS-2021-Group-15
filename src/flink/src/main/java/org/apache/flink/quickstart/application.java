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

/**
 * A simple Flink program that processes the Wikipedia edits stream.
 **/
public class application {

	public static Locations GlobalLocations;
	public static AQICalculator aqicalc = AQICalculator.getAQICalculatorInstance();

	public static int JustTesting = 0;

	public static void main(String[] args) throws Exception {


		// set up the streaming execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		env.setParallelism(1);

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

}


