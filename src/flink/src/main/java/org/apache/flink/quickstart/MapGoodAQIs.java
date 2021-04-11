package org.apache.flink.quickstart;

import com.grpc.*;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


public class MapGoodAQIs implements MapFunction<Team8Measurement,Team8Measurement> {

		@Override
		public Team8Measurement map(Team8Measurement m) throws Exception {
			
			m.isGood = isGood(m);

			return m;
		}

		

		private boolean isGood(Team8Measurement m) {
			
			return (m.aqi < 50);
		}

	}