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
//import com.thanglequoc.aqicalculator.AQIResult;
import com.thanglequoc.aqicalculator.Pollutant;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
//import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.GlobalWindows;
//import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.evictors.Evictor;
//import org.apache.flink.streaming.api.windowing.triggers.EventTimeTrigger;
import org.apache.flink.streaming.api.windowing.triggers.Trigger;
import org.apache.flink.streaming.api.windowing.triggers.TriggerResult;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.api.windowing.windows.Window;
import org.apache.flink.streaming.runtime.operators.windowing.TimestampedValue;
import org.apache.flink.util.Collector;

//import org.apache.flink.streaming.api.windowing.time.Time;
//
//import javax.xml.crypto.KeySelector;
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.Period;
//import java.time.ZoneId;
import java.util.Iterator;
import java.util.List;

import com.grpc.ChallengerGrpc.ChallengerBlockingStub;

// added by Snigdha
//import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.typeinfo.*;
import org.apache.flink.api.java.tuple.*;
//import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
//import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.*;
import java.util.*;

public class application
{
	public static Locations GlobalLocations;
	public static long benchId;
	public static long batchseq;
	public static ChallengerBlockingStub client;
	public static Benchmark benchmark;
	public static AQICalculator aqicalc = AQICalculator.getAQICalculatorInstance();

	public static int TimeStampWatermark = 1585699500; // Wed Apr 01 2020 00:05:00 GMT+0000
	final public static int FirstEverTimeStamp = 1585699500;
	public static long currentYearLastMeasurementTimestamp = -1, lastYearLastMeasurementTimestamp = -1;

	public static boolean query1submittedLastBatch = false, query2submittedLastBatch = false;
//	public static int query2CloseTheStreamCount = 0;

	public static Map<String,TwoTimeStamps> query2TimeStamps = new HashMap<String,TwoTimeStamps>();

	public static void main(String[] args) throws Exception
	{
		// set up the streaming execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		env.setParallelism(24);
		grpcClient grpc = new grpcClient();
		DataStream<Team8Measurement> measurements = env.addSource(grpc)
														.name("API")
														.rebalance();

//		measurements.print();
		// Set particular parallelism
		DataStream<Team8Measurement> calculateCityAndFilter = measurements.map(new MapCity())
																	.name("calculateCity")
																	.filter(m -> !m.city.equals("CITYERROR"));

//		calculateCityAndAqiAndFilter.print();

		// Branches out a different operator, (since query 1 and 2 need to recieve data from the same data stream)
		//DataStream<Team8Measurement> calculateCityFilter = measurements.filter();

//		calculateCity.print();
		// Different parallelism splits

//		filterNoCity.print();

//		KeyedStream<Team8Measurement, String> measurementsKeyedByCity = calculateCityAndAqiAndFilter.keyBy(m -> m.city);

//		measurementsKeyedByCity.process(new KeyedProcessFunction1()); //for testing

		DataStream<SnapshotDictionary> snapshots = calculateCityAndFilter.windowAll(GlobalWindows.create())
								.trigger(new TriggerFiveMinutes())
								.evictor(new EvictFiveMinutes())
								.process(new MeasurementsToSnapshots())
								.name("Measurements to Snapshots");

//		snapshots.print();

		DataStream<SnapshotDictionary> calculateAqi = snapshots.map(new CalculateAqi());

		calculateAqi.windowAll(GlobalWindows.create())
								.trigger(new TriggerEveryElement())
								.evictor(new EvictLastElement5Days())
								.process(new SnapshotsToImprovement())
								.name("Query 1");

//		calculateAqi.print();

		calculateAqi.process(new SnapshotsToHistograms()).name("Query 2");
//				.windowAll(GlobalWindows.create())
//				.trigger(new TriggerEveryElement())
//				.evictor(new EvictLastElement7Days())
//				.process(new SnapshotsToHistograms())
//				.name("Query 2");

//		measurementsKeyedByCity.print();


//		org.apache.flink.api.java.functions.KeySelector<Team8Measurement, String> mkbcKeySelector = measurementsKeyedByCity.getKeySelector();

		// Testing to see if I can connect operators
//		calculateCity.shuffle();

		// query 2 implementation call
//		calculateHistogram(calculateAqi);

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
//				java.util.Date time=new java.util.Date((long)m.measurement.getTimestamp().getSeconds()*1000);
//				System.out.println(time);
//				System.out.println("-----------------------------------------------");
			}
		}
	}

	private static class MapCity implements MapFunction<Team8Measurement,Team8Measurement> {
		@Override
		public Team8Measurement map(Team8Measurement m) throws Exception {
			m.city = calculateCity(m);
//			if(!m.city.equals("CITYERROR"))
//				m.aqi = computeAQI(m.measurement, aqicalc);
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

		public int computeAQI(Measurement measurement, AQICalculator aqicalc) {
			/*
				float p1 = 4; //Particles < 10µm (particulate matter)
				float p2 = 5; //Particles < 2.5µm (ultrafine particles)
			*/
			float pm10 = measurement.getP1();
			float pm25 = measurement.getP2();

			int result10 = aqicalc.getAQI(Pollutant.PM10, (double) pm10).getAQI();
			int result25 = aqicalc.getAQI(Pollutant.PM25, (double) pm25).getAQI();

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
	private static class CalculateAqi implements MapFunction<SnapshotDictionary, SnapshotDictionary> {
		@Override
		public SnapshotDictionary map(SnapshotDictionary m) throws Exception {

			for (FiveMinuteSnapshot fms : m.dict.values())
			{
				Tuple2<Integer,Integer> t1 = computeAQIPointInputs1000(fms.getAverageAQIp1LastYear(), fms.getAverageAQIp2LastYear(), aqicalc);
				fms.aqiLastYearP1 = t1.f0;
				fms.aqiLastYearP2 = t1.f1;
				Tuple2<Integer,Integer> t2  = computeAQIPointInputs1000(fms.getAverageAQIp1ThisYear(), fms.getAverageAQIp2ThisYear(), aqicalc);
				fms.aqiThisYearP1 = t2.f0;
				fms.aqiThisYearP2 = t2.f1;
			}
			return m;
		}
	}
	// We have two functions doing the same thing.
	public static Tuple2<Integer,Integer> computeAQIPointInputs1000(double p1, double p2, AQICalculator aqicalc) {
		/*
			float p1 = 4; //Particles < 10µm (particulate matter)
			float p2 = 5; //Particles < 2.5µm (ultrafine particles)
		*/
		float pm10 = (float)p1; //measurement.getP1();
		float pm25 = (float)p2; //measurement.getP2();

		int result10 = aqicalc.getAQI(Pollutant.PM10, (double) pm10).getAQI() * 1000;
		int result25 = aqicalc.getAQI(Pollutant.PM25, (double) pm25).getAQI() * 1000;

		return new Tuple2<Integer,Integer>(result25,result10);
//		if (result10 > result25){
//			return result10;
//		}
//		else {
//			return result25;
//		}
	}

	//////////////////////////////////////////////////////BEGIN FIRST CUSTOM WINDOW//////////////////////////////////////////////////////

	private static class EvictFiveMinutes implements Evictor<Team8Measurement, GlobalWindow> {

		@Override
		public void evictBefore(Iterable<TimestampedValue<Team8Measurement>> events, int size, GlobalWindow window, EvictorContext ctx) {}

		@Override
		public void evictAfter(Iterable<TimestampedValue<Team8Measurement>> elements, int size, GlobalWindow window, Evictor.EvictorContext ctx) {


			for (Iterator<TimestampedValue<Team8Measurement>> iterator = elements.iterator(); iterator.hasNext(); ) {
				TimestampedValue<Team8Measurement> element = iterator.next();
				long timeLastYear = TimeStampWatermark - 31536000;

				long elementTime = element.getValue().measurement.getTimestamp().getSeconds();
				if( (elementTime <= (TimeStampWatermark - 86400) && elementTime > TimeStampWatermark - 31536000/2) || elementTime <= (timeLastYear - 86400)) // first <= should be just <?
				{
					System.out.println("Dropping : " + new java.util.Date(elementTime*1000));
					iterator.remove();
				}
			}

			if(currentYearLastMeasurementTimestamp > TimeStampWatermark + 300)
				TimeStampWatermark += 300;
			currentYearLastMeasurementTimestamp = -1;
			lastYearLastMeasurementTimestamp = -1;

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
	private static class TriggerFiveMinutes<W extends Window> extends Trigger<Team8Measurement, W> {

		@Override
		public TriggerResult onElement(Team8Measurement element, long timestamp, W window, TriggerContext ctx) throws Exception {
//			ReducingState<Long> count = ctx.getPartitionedState(stateDesc);
//			count.add(1L);
//			if (count.get() >= maxCount) {
//				count.clear();
//				return TriggerResult.FIRE_AND_PURGE;
//			}



//			System.out.println(element.measurement.getTimestamp().getSeconds());
//			java.util.Date time=new java.util.Date((long)element.measurement.getTimestamp().getSeconds()*1000);
//			System.out.println(time);

			long elementTime = element.measurement.getTimestamp().getSeconds();
			if(element.isLastMeasurementInBatch && element.year.equals("ThisYear"))
				currentYearLastMeasurementTimestamp = elementTime;
			if(element.isLastMeasurementInBatch && element.year.equals("LastYear"))
				lastYearLastMeasurementTimestamp = elementTime;
			if(currentYearLastMeasurementTimestamp != -1 && lastYearLastMeasurementTimestamp != -1)
			{
//				long copyCYLMTS = currentYearLastMeasurementTimestamp;
//				currentYearLastMeasurementTimestamp = -1;
//				lastYearLastMeasurementTimestamp = -1;
//				if(copyCYLMTS >= TimeStampWatermark)
				return TriggerResult.FIRE;
			}
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
//			the clear() method performs any action needed upon removal of the corresponding window.

//			ctx.getPartitionedState(stateDesc).clear();
		}
	}
	private static class MeasurementsToSnapshots extends ProcessAllWindowFunction<Team8Measurement, SnapshotDictionary, TimeWindow> { //String (third one)

		@Override //String key,
		public void process(Context context, Iterable<Team8Measurement> input, Collector<SnapshotDictionary> out)
		{
			//for testing
			long minTimestampTY = 158569950000L, maxTimestampTY = 0, minTimestampLY = 158569950000L, maxTimestampLY = 0; // the min values are just large values.

			SnapshotDictionary d = new SnapshotDictionary(TimeStampWatermark);

			long timeLastYear = TimeStampWatermark - 31536000;
			for (Team8Measurement m: input)
			{
				long msec = m.measurement.getTimestamp().getSeconds();

				if(!d.dict.containsKey(m.city))
					d.dict.put(m.city, new FiveMinuteSnapshot());
				if(m.year.equals("ThisYear") && msec <= TimeStampWatermark) // <= or <?
				{
					//for testing
					if(msec < minTimestampTY)
						minTimestampTY = msec;
					if(msec > maxTimestampTY)
						maxTimestampTY = msec;

					d.dict.get(m.city).sumAQIp1ThisYear += m.measurement.getP1();
					d.dict.get(m.city).sumAQIp2ThisYear  += m.measurement.getP2();
					d.dict.get(m.city).countForAverageThisYear += 1;

					if(d.dict.get(m.city).latestTimestamp < msec)
						d.dict.get(m.city).latestTimestamp = msec;
				}
				else if(m.year.equals("LastYear") && msec <= timeLastYear)
				{
					//for testing
					if(msec < minTimestampLY)
						minTimestampLY = msec;
					if(msec > maxTimestampLY)
						maxTimestampLY = msec;

					d.dict.get(m.city).sumAQIp1LastYear += m.measurement.getP1();
					d.dict.get(m.city).sumAQIp2LastYear  += m.measurement.getP2();
					d.dict.get(m.city).countForAverageLastYear += 1;
				}
			}

			System.out.println(d);
			java.util.Date time1=new java.util.Date(minTimestampTY*1000);
			System.out.println("min timestamp ThisYear: " + time1);
			java.util.Date time2=new java.util.Date(maxTimestampTY*1000);
			System.out.println("max timestamp ThisYear: " +time2);
			java.util.Date time3=new java.util.Date(minTimestampLY*1000);
			System.out.println("min timestamp LastYear: " + time3);
			java.util.Date time4=new java.util.Date(maxTimestampLY*1000);
			System.out.println("max timestamp LastYear: " +time4);
//			TimeStampWatermark += 300;
			out.collect(d);
//			out.collect(new FiveMinuteSnapshot(avgAqip1,avgAqip2, ));
//			out.collect("Window: " + context.window() + "count: " + count);


		}
	}

	//////////////////////////////////////////////////////END FIRST CUSTOM WINDOW//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////BEGIN SECOND CUSTOM WINDOW//////////////////////////////////////////////////////

	private static class EvictLastElement5Days implements Evictor<SnapshotDictionary, GlobalWindow> {

		@Override
		public void evictBefore(Iterable<TimestampedValue<SnapshotDictionary>> events, int size, GlobalWindow window, EvictorContext ctx) {}

		@Override
		public void evictAfter(Iterable<TimestampedValue<SnapshotDictionary>> elements, int size, GlobalWindow window, Evictor.EvictorContext ctx) {

			int count = 0;
			for (Iterator<TimestampedValue<SnapshotDictionary>> iterator = elements.iterator(); iterator.hasNext(); ) {

				TimestampedValue<SnapshotDictionary> element = iterator.next();
//				if(!iterator.hasNext())
				if(count > 1440)
					iterator.remove();
				++count;
			}
		}
	}
	private static class TriggerEveryElement<W extends Window> extends Trigger<SnapshotDictionary, W> {

		@Override
		public TriggerResult onElement(SnapshotDictionary element, long timestamp, W window, TriggerContext ctx) throws Exception {

			return TriggerResult.FIRE;

		}

		@Override
		public TriggerResult onProcessingTime(long time, W window, TriggerContext ctx) throws Exception {
			return TriggerResult.CONTINUE;
		}

		@Override
		public TriggerResult onEventTime(long time, W window, TriggerContext ctx) {
			return TriggerResult.CONTINUE;
		}

		@Override
		public void clear(W window, TriggerContext ctx) throws Exception { }
	}
	private static class SnapshotsToImprovement extends ProcessAllWindowFunction<SnapshotDictionary, Object, TimeWindow> {

		@Override
		public void close()
		{
			if(!query1submittedLastBatch)
			{
				System.out.println("ATTEMPTING TO END BENCHMARK");
				query1submittedLastBatch = true;

				if(query2submittedLastBatch) {
					System.out.println("Closing connection.");
					client.endBenchmark(benchmark);
				}
			}
		}

		@Override
		public void process(Context context, Iterable<SnapshotDictionary> input, Collector<Object> out) {

			Map<String,ImprovementScratchpad> scratch = new HashMap<String,ImprovementScratchpad>();
			boolean closeTheStream = false;
			long latestTimeStamp = 0;

			for (SnapshotDictionary m: input)
			{
				if(latestTimeStamp < m.timestamp)
					latestTimeStamp = m.timestamp;
				for (Map.Entry<String,FiveMinuteSnapshot> entry : m.dict.entrySet())
				{
					String k = entry.getKey();
					if (!scratch.containsKey(entry.getKey()))
						scratch.put(k, new ImprovementScratchpad(k));

					ImprovementScratchpad isp = scratch.get(k);
					FiveMinuteSnapshot fms = entry.getValue();
					isp.totalAqiThisYear += fms.getMaxAqiThisYear();
					isp.countAqiThisYear++;
					isp.totalAqiLastYear += fms.getMaxAqiLastYear();
					isp.countAqiLastYear++;
					isp.updateLatestAqiValues(m.timestamp, fms.aqiThisYearP1, fms.aqiThisYearP2);
					if(isp.latestTimeStamp < fms.latestTimestamp)
						isp.latestTimeStamp = fms.latestTimestamp;
				}
			}

			List<ImprovementScratchpad> sortedImprovements = new ArrayList<ImprovementScratchpad>(scratch.values());
			Collections.sort(sortedImprovements, Collections.reverseOrder());
			List<TopKCities> topkresult = new ArrayList<TopKCities>();
			int iterations;
			if (sortedImprovements.size() < 50) {
				iterations = sortedImprovements.size();
			}
			else {
				iterations = 50;
			}
			int position = 1;
			for (int i = 0; i < iterations; i++)
			{
				ImprovementScratchpad isp = sortedImprovements.get(i);

				if(isp.latestTimeStamp >= latestTimeStamp - 600)
				{
					TopKCities curCity = TopKCities.newBuilder()
							.setPosition(position++)
							.setCity(isp.city)
							.setAverageAQIImprovement(isp.getImprovement())
							.setCurrentAQIP1(isp.currentAqiP1)
							.setCurrentAQIP2(isp.currentAqiP2)
							.build();
					topkresult.add(curCity);
				}



//				client.resultQ1(new ResultQ1(benchId, batchseq, new TopKCities(i, isp.city, isp.getImprovement(), isp.currentAqiP1, isp.currentAqiP2)));
			}

			ResultQ1 submitData = ResultQ1.newBuilder()
											.setBenchmarkId(benchId)
											.setBatchSeqId(batchseq)
											.addAllTopkimproved(topkresult)
											.build();
			
			client.resultQ1(submitData);
			System.out.println("Submitted data for batch: " + batchseq);
			System.out.println(submitData.toString());

//			if(closeTheStream)
//			{
//
//			}
			out.collect(submitData);
		}
	}
	private static class ImprovementScratchpad implements Comparable<ImprovementScratchpad> {
		int totalAqiThisYear = 0, countAqiThisYear = 0,
			totalAqiLastYear = 0, countAqiLastYear = 0;

		int currentAqiP1, currentAqiP2;
		long timestampOfCurrentAqi;

		String city;

		long latestTimeStamp = 0;

		public ImprovementScratchpad(String city)
		{
			this.city = city;
		}

		public int getImprovement()
		{
			return (totalAqiLastYear / countAqiLastYear) - (totalAqiThisYear / countAqiThisYear);
		}

		public void updateLatestAqiValues(long timestamp, int p1, int p2)
		{
			if(timestamp > this.timestampOfCurrentAqi)
			{
				this.currentAqiP1 = p1;
				this.currentAqiP2 = p2;
			}
		}

		@Override
		public int compareTo(ImprovementScratchpad isp) {
			return (int)(this.getImprovement() - isp.getImprovement()); //might be flipped
		}
	}

	//////////////////////////////////////////////////////END SECOND CUSTOM WINDOW//////////////////////////////////////////////////////

	// Snigdha

	private static DataStream<List<TopKStreaks>> calculateHistogram(DataStream<SnapshotDictionary> input) throws Exception {

		// filter measurements for current year
//		DataStream<Team8Measurement> currentYearData = input.filter(m -> m.year.equals("ThisYear")).name("Current year filter");
		
		// sets attribute isGood of Team8Measurement for each measurement, true if good AQI value, false otherwise																											
//       	DataStream<Team8Measurement> calculateGoodAQIs = currentYearData.map(new MapGoodAQIs()).name("Good streak finder");
       	
       	// key by city and calculate streaks of good AQI values for each city						
        DataStream<Tuple4Wrapper> measurementsKeyedByCity = input//calculateGoodAQIs
//				.keyBy(m -> m.city)
				.windowAll(GlobalWindows.create())
//				.windowAll(EventTimeSessionWindows.withGap(Time.minutes(10)))
				.trigger(new TriggerEveryElement())
				.evictor(new EvictLastElement7Days())
				.process(new IntermediaryBetweenSnapshotsAndStreaks())
				.rescale();

			return null;
	}
	private static class Tuple4Wrapper {
		Tuple4<String, Long, Long, Long> tuple4;
		boolean closeTheStream = false;
		public int closeStreamCount = 0;

		public Tuple4Wrapper(Tuple4<String, Long, Long, Long> tuple4)
		{
			this.tuple4 = tuple4;
		}
	}

	// End calculateHistogram


	//////////////////////////////////////////////////////BEGIN THIRD CUSTOM not-a-WINDOW-actually//////////////////////////////////////////////////////

	private static class EvictLastElement7Days implements Evictor<SnapshotDictionary, GlobalWindow> {

		@Override
		public void evictBefore(Iterable<TimestampedValue<SnapshotDictionary>> events, int size, GlobalWindow window, EvictorContext ctx) {}

		@Override
		public void evictAfter(Iterable<TimestampedValue<SnapshotDictionary>> elements, int size, GlobalWindow window, Evictor.EvictorContext ctx) {

			int count = 0;
			for (Iterator<TimestampedValue<SnapshotDictionary>> iterator = elements.iterator(); iterator.hasNext(); ) {

				TimestampedValue<SnapshotDictionary> element = iterator.next();
//				if(!iterator.hasNext())
				if(count > 2016)
					iterator.remove();
				++count;
			}
		}
	}
	private static class IntermediaryBetweenSnapshotsAndStreaks extends ProcessAllWindowFunction<SnapshotDictionary, Tuple4Wrapper, TimeWindow> {

//		private transient ValueState<Tuple2<Long, Long>> streak;
		private transient ValueState<Map<String, Tuple2<Long, Long>>> streakMap;

		@Override //String key
		public void process(Context c, Iterable<SnapshotDictionary> elements,
							Collector<Tuple4Wrapper> out) throws Exception {

			boolean closeTheStream = false;

			//first value is for start time of the streak. second value is for duration of the streak
//			Tuple2<Long, Long> currentStreak = streak.value();
			Map<String, Tuple2<Long, Long>> csMap = streakMap.value();
			if(streakMap.value() == null) {
				csMap = new HashMap<String, Tuple2<Long, Long>>();
				streakMap.update(csMap);
			}

			//lastTimeStamp and firstTimeStamp needed for bucket lengths later on
//			long lastTimeStamp = 0L;
//			long firstTimeStamp = 0L;
			Map<String, Long> ltsMap = new HashMap<String, Long>();
			Map<String, Long> ftsMap = new HashMap<String, Long>();

			for (SnapshotDictionary m : elements)
			{
				closeTheStream |= m.closeTheStream;
				for (Map.Entry<String,FiveMinuteSnapshot> entry : m.dict.entrySet())
				{
					String key = entry.getKey();
					FiveMinuteSnapshot fms = entry.getValue();

					Tuple2<Long, Long> currentStreak = csMap.get(key);
					if(currentStreak == null)
						currentStreak = new Tuple2<Long,Long>(0L,0L);

					if (fms.getMaxAqiThisYear() < 50) {
						if (currentStreak.f0 == 0) {
							currentStreak.f0 = m.timestamp;
						}
						// revieved a good aqi value so update the duration
						currentStreak.f1 = m.timestamp - currentStreak.f0;
						csMap.put(key, currentStreak);
					}
					else {
						// we recieve a bad AQI value so reset start time and duration
						currentStreak.f0 = 0L;
						currentStreak.f1 = 0L;
						csMap.put(key, currentStreak);
					}

					ltsMap.put(key, m.timestamp);
					if (ftsMap.get(key) == null || ftsMap.get(key) == 0) //not sure how to convert this one
						ftsMap.put(key, m.timestamp);
				}

			}
			// update the state
//			streak.update(currentStreak);
			streakMap.update(csMap);

//			System.out.println("Last time " + lastTimeStamp );

			List<Tuple4Wrapper> toSecondFunction = new ArrayList<Tuple4Wrapper>();
			Tuple4Wrapper tfw = null;
			for (Map.Entry<String,Tuple2<Long, Long>> entryCurrentStreak : csMap.entrySet())
			{
				Tuple2<Long, Long> currentStreak = entryCurrentStreak.getValue();
				String key = entryCurrentStreak.getKey();
				if (currentStreak.f1 != 0){
					tfw = new Tuple4Wrapper(new Tuple4<>(key, currentStreak.f1, ftsMap.get(key), ltsMap.get(key)));
					//begin for closing the stream
//					tfw.closeTheStream = closeTheStream;
//					if(closeTheStream)
//						tfw.closeStreamCount = ++query2CloseTheStreamCount;
					//end for closing the stream
//					out.collect(tfw);
					toSecondFunction.add(tfw);
				// streak.clear();
				}
			}
			secondHalf(toSecondFunction);
		}

		@Override
		public void open(Configuration config) throws Exception {
			ValueStateDescriptor<Map<String,Tuple2<Long, Long>>> descriptor =
					new ValueStateDescriptor<>(
							"streaks", // the state name
							TypeInformation.of(new TypeHint<Map<String,Tuple2<Long, Long>>>() {})); //, // type information
//							new HashMap<String,Tuple2<Long,Long>>()); // default value of the state, if nothing was set
			streakMap = getRuntimeContext().getState(descriptor);
		}

		public void secondHalf(Iterable<Tuple4Wrapper> elements) {

				boolean closeTheStream = false;
				int closeTheStreamMax = 0;

				List<TopKStreaks> result = new ArrayList<TopKStreaks>();
				int numBuckets = 14;
				int maxSpan = 0;
				int bucketWidth = 0;

				int totalCities = 0;
				long minTimestamp = Long.MAX_VALUE;
				long maxTimestamp = 0L;

				// first loop for getting the earliest and last timestamp of the batch and total cities
				for (Tuple4Wrapper mWrapper : elements) {
					closeTheStream |= mWrapper.closeTheStream;
					if(closeTheStream)
						if(mWrapper.closeStreamCount > closeTheStreamMax)
							closeTheStreamMax = mWrapper.closeStreamCount;

					Tuple4<String, Long, Long, Long> m = mWrapper.tuple4;
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

				for (Tuple4Wrapper mWrapper : elements) {
					Tuple4<String, Long, Long, Long> m = mWrapper.tuple4;
					// check if city is active
					if (maxTimestamp - m.f3 <= (600)) {
						// calculate which bucket this city belongs in
						int bucket = (int)(m.f1 / bucketWidth);
						counts[bucket]++;
					} else {
						// if not active, don't include in the histogram
						totalCities--;
					}
				}

				//hack!
				if(totalCities == 0)
					totalCities = 1;

				//for each bucket, calculate percentage of cities in it and create a TopKStreaks object
				for (int i = 0; i < counts.length; i++) {
					counts[i] = counts[i] * 100 * 1000 / totalCities;
					int bucket_from = (int) (i*bucketWidth);
					int bucket_to   = (int) (bucket_from + bucketWidth - 1);
					System.out.println("Percentage = " + counts[i]);
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
				System.out.println("Submitted result 2 data: " + submitData.toString());

				if(closeTheStream) // && query2CloseTheStreamCount == closeTheStreamMax)
				{
//					System.out.println("ATTEMPTING TO TERMINATE BENCHMARK");
//					query2submittedLastBatch = true;
//					if(query1submittedLastBatch) {
//						System.out.println("Closing connection.");
//						client.endBenchmark(benchmark);
//					}

				}

//				out.collect(result);

		}

	}

	private static class SnapshotsToHistograms extends ProcessFunction<SnapshotDictionary, Object> {

		@Override
		public void close() throws Exception
		{
			if(!query2submittedLastBatch)
			{
				System.out.println("ATTEMPTING TO TERMINATE BENCHMARK");
				query2submittedLastBatch = true;

				if(query1submittedLastBatch) {
					System.out.println("Closing connection.");
					client.endBenchmark(benchmark);
				}
			}
		}

		@Override
		public void processElement(SnapshotDictionary input, Context context, Collector<Object> out) {

			boolean closeTheStream = false;
			List<TopKStreaks> result = new ArrayList<TopKStreaks>();

			for (Map.Entry<String,FiveMinuteSnapshot> entry : input.dict.entrySet())
			{
				String k = entry.getKey();
				FiveMinuteSnapshot v = entry.getValue();
				if (!query2TimeStamps.containsKey(k))
					query2TimeStamps.put(k, new TwoTimeStamps());

				query2TimeStamps.get(k).mostRecentTimeStamp = input.timestamp;
				if(v.getMaxAqiThisYear() < 50 * 1000) { //<=?
					if (query2TimeStamps.get(k).streakTimeStamp == -1) {
						query2TimeStamps.get(k).streakTimeStamp = input.timestamp;
					}
				}
				else
					query2TimeStamps.get(k).streakTimeStamp = -1L;
			}

			for(TwoTimeStamps tt : query2TimeStamps.values())
				if (input.timestamp - tt.mostRecentTimeStamp > 600)
					tt.streakTimeStamp = -1L;

			long histogramWidth = input.timestamp - FirstEverTimeStamp > 43200 ? 43200 : input.timestamp - FirstEverTimeStamp;
			if(histogramWidth == 0)
				histogramWidth = 1;

			ArrayList<Integer> lengthsInHalfDays = new ArrayList<Integer>();
			System.out.println("input.timestamp = " + input.timestamp);
			for (TwoTimeStamps tt : query2TimeStamps.values()) {
				long t = tt.streakTimeStamp;
				if (t == -1)
					lengthsInHalfDays.add(0);
				else {
//					System.out.println("input.timestamp = " + input.timestamp);
//					System.out.println("t = " + t);
//					System.out.println("(input.timestamp - t) = " + (input.timestamp - t));
//					System.out.println("(input.timestamp - t)/(2.5*60) = " + (input.timestamp - t)/(2.5*60));
					double y = Math.floor((input.timestamp - t) / histogramWidth);
//					System.out.println("y = " + y);
					double x = y > 13 ? 13 : y;
//					System.out.println("x = " + x);
					lengthsInHalfDays.add((int) x);
				}
			}

			Collections.sort(lengthsInHalfDays);
			int[] finalCounts = new int[14];

			for (int i = 0; i < 14 ; i++)
			{
				int count = 0;
				while(!lengthsInHalfDays.isEmpty() && lengthsInHalfDays.get(0) == i)
				{
					++count;
					lengthsInHalfDays.remove(0);
				}
				finalCounts[i] = count;
			}

			double histogramBiggestValue = 604800 * ((1.0*histogramWidth)/43200.0);
			for (int i = 0; i < 14 ; i++)
			{
				double beginningLimit = ((i*1.0)/(14.0))*histogramBiggestValue,
						endingLimit = (((i+1)*1.0)/(14.0))*histogramBiggestValue;
				System.out.println("beginningLimit = " + beginningLimit);
				System.out.println("endingLimit = " + endingLimit);
				System.out.println("Count = " + finalCounts[i]);
				System.out.println("Percentage = " + ((finalCounts[i]*1.0)/(query2TimeStamps.size()*1.0))*100);
				TopKStreaks item = TopKStreaks.newBuilder()
						.setBucketFrom((int)beginningLimit)
						.setBucketTo((int)endingLimit)
						.setBucketPercent((finalCounts[i]/query2TimeStamps.size())*100)
						.build();
				result.add(item);
			}

			ResultQ2 submitData = ResultQ2.newBuilder()
					.setBenchmarkId(benchId)
					.setBatchSeqId(batchseq)
					.addAllHistogram(result)
					.build();
			client.resultQ2(submitData);
			System.out.println("Submitted result 2 data: " + submitData.toString());

//			if(closeTheStream) // && query2CloseTheStreamCount == closeTheStreamMax)
//			{
//
//			}
			out.collect(submitData);
		}
	}
	public static class TwoTimeStamps { //just a more descriptive Tuple2 I guess.
		public long streakTimeStamp = -1L;
		public long mostRecentTimeStamp = -1L;
		public TwoTimeStamps() {
			this.streakTimeStamp = -1L;
			this.mostRecentTimeStamp = -1L;
		}
	}

	//////////////////////////////////////////////////////END SECOND CUSTOM not-a-WINDOW-actually//////////////////////////////////////////////////////

}


