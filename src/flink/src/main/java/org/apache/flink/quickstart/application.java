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
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.List;

/**
 * A simple Flink program that processes the Wikipedia edits stream.
 **/
public class application {

	public static Locations GlobalLocations;
	public static AQICalculator aqicalc = AQICalculator.getAQICalculatorInstance();

	public static int TimeStampWatermark = 1585699500; // Wed Apr 01 2020 00:05:00 GMT+0000
	public static long currentYearLastMeasurementTimestamp = -1, lastYearLastMeasurementTimestamp = -1;

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

//		KeyedStream<Team8Measurement, String> measurementsKeyedByCity = calculateCityAndAqiAndFilter.keyBy(m -> m.city);

//		measurementsKeyedByCity.process(new KeyedProcessFunction1()); //for testing

		DataStream<SnapshotDictionary> snapshots = calculateCityAndAqiAndFilter.windowAll(GlobalWindows.create())
								.trigger(new TriggerFiveMinutes())
								.evictor(new EvictFiveMinutes())
								.process(new MeasurementsToSnapshots());

		snapshots.print();


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

		public static LocalDate convertToLocalDateViaMilisecond(java.util.Date dateToConvert) {
			return Instant.ofEpochMilli(dateToConvert.getTime())
					.atZone(ZoneId.systemDefault())
					.toLocalDate();
		}

		@Override
		public TriggerResult onElement(Team8Measurement element, long timestamp, W window, TriggerContext ctx) throws Exception {
//			ReducingState<Long> count = ctx.getPartitionedState(stateDesc);
//			count.add(1L);
//			if (count.get() >= maxCount) {
//				count.clear();
//				return TriggerResult.FIRE_AND_PURGE;
//			}



//			System.out.println(element.measurement.getTimestamp().getSeconds());
			java.util.Date time=new java.util.Date((long)element.measurement.getTimestamp().getSeconds()*1000);
			System.out.println(time);

			long elementTime = element.measurement.getTimestamp().getSeconds();
			if(element.isLastMeasurementInBatch && element.year.equals("ThisYear"))
				currentYearLastMeasurementTimestamp = elementTime;
			if(element.isLastMeasurementInBatch && element.year.equals("LastYear"))
				lastYearLastMeasurementTimestamp = elementTime;
			if(currentYearLastMeasurementTimestamp != -1 && lastYearLastMeasurementTimestamp != -1)
			{
				long copyCYLMTS = currentYearLastMeasurementTimestamp;
				currentYearLastMeasurementTimestamp = -1;
				lastYearLastMeasurementTimestamp = -1;
				if(copyCYLMTS >= TimeStampWatermark)
					return TriggerResult.FIRE;
			}
			return TriggerResult.CONTINUE;



//			if(element.isLastMeasurementInBatch)
//			{
//				if(element.year.equals("ThisYear"))
//					currentYearLastMeasurementTimestamp = element.measurement.getTimestamp().getSeconds();
//				else // should always be last year
//					lastYearLastMeasurementTimestamp = element.measurement.getTimestamp().getSeconds();
//				if(currentYearLastMeasurementTimestamp != -1 && lastYearLastMeasurementTimestamp != -1)
//				{
//					if(currentYearLastMeasurementTimestamp >= TimeStampWatermark)
//					{
//
//					}
//				}
//			}
//			return TriggerResult.CONTINUE;
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
		public void process(Context context, Iterable<Team8Measurement> input, Collector<SnapshotDictionary> out) {

			//for testing
			long minTimestampTY = 158569950000L, maxTimestampTY = 0, minTimestampLY = 158569950000L, maxTimestampLY = 0 ;

			SnapshotDictionary d = new SnapshotDictionary(TimeStampWatermark);


			long timeLastYear = TimeStampWatermark - 31536000;
			for (Team8Measurement m: input) {
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
			System.out.println("mints TY: " + time1);
			java.util.Date time2=new java.util.Date(maxTimestampTY*1000);
			System.out.println("maxts TY: " +time2);
			java.util.Date time3=new java.util.Date(minTimestampLY*1000);
			System.out.println("mints LY: " + time3);
			java.util.Date time4=new java.util.Date(maxTimestampLY*1000);
			System.out.println("maxts LY: " +time4);
			TimeStampWatermark += 300;
			out.collect(d);
//			out.collect(new FiveMinuteSnapshot(avgAqip1,avgAqip2, ));
//			out.collect("Window: " + context.window() + "count: " + count);
		}
	}

}


