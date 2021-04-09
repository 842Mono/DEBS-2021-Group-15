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

import java.util.List;

/**
 * A simple Flink program that processes the Wikipedia edits stream.
 **/
public class application {

	public static Locations GlobalLocations;

	public static void main(String[] args) throws Exception {


		// set up the streaming execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		env.setParallelism(8); // use 1 processing tasks

		AQICalculator aqicalc = AQICalculator.getAQICalculatorInstance();

		DataStream<Team8Measurement> measurements = env.addSource(new grpcClient());

//		measurements.print();
		// Set particular parallelism
		DataStream<Team8Measurement> calculateCity = measurements.map(new MapGetCity()).setParallelism(4);

		// Branches out a different operator, (since query 1 and 2 need to recieve data from the same data stream)
		DataStream<Team8Measurement> calculateCityFilter = measurements.filter();

//		calculateCity.print();
		// Different parallelism splits
		DataStream<Team8Measurement> filterNoCity = calculateCity.filter(m -> !m.city.equals("CITYERROR"));

//		filterNoCity.print();

		KeyedStream<Team8Measurement, String> measurementsKeyedByCity = filterNoCity.keyBy(m -> m.city);

		measurementsKeyedByCity.print();

		// Testing to see if I can connect operators
//		calculateCity.shuffle();

		env.execute("Print Measurements Stream");


		//old code. keeping it for now just for reference.

//		DataStream<WikipediaEditEvent> edits = env
//				.addSource(new WikipediaEditsSource());
//
//		// filter events with bytediff < 0
//		DataStream<WikipediaEditEvent> filtered = edits.filter(new MyFilterFunction());
//
//		DataStream<Tuple4<String, Long, Integer, String>> mappedEdits = filtered.map(new MyMapFunction());
//
//		mappedEdits.print();
//
//		// execute program
//		env.execute("Print Wikipedia Edits Stream");

//		grpcClient.FakeMain();
	}


	private static class MapGetCity implements MapFunction<Team8Measurement,Team8Measurement> {
		@Override
		public Team8Measurement map(Team8Measurement m) throws Exception {
			m.city = calculateCity(m);
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
			System.out.println("TEAM8 ERROR POINT WASN'T FOUND TO BE IN ANY OF THE POLYGONS.");
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

}


