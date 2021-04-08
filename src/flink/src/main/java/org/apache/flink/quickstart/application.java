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

import com.grpc.Measurement;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import grpcPackage.grpcClient;

import com.thanglequoc.aqicalculator.AQICalculator;
import com.thanglequoc.aqicalculator.AQIResult;
import com.thanglequoc.aqicalculator.Pollutant;
/**
 * A simple Flink program that processes the Wikipedia edits stream.
 **/
public class application {

	public static void main(String[] args) throws Exception {


		// set up the streaming execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		env.setParallelism(1); // use 1 processing tasks

		DataStream<Measurement> measurements = env.addSource(new grpcClient());

		measurements.print();

		env.execute("Print Measurements Stream");

		// Get AQI calculator
		AQICalculator aqicalc = AQICalculator.getAQICalculatorInstance();
		AQIResult result = aqicalc.getAQI(Pollutant.PM10, 50);
		AQIResult result2 = aqicalc.getAQI(Pollutant.PM25, 50);


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


}


