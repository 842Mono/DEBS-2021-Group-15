package org.apache.flink.quickstart;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditEvent;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditsSource;

import java.util.Properties;

/**
 * Write Wikipedia Edit Events with non-null summary to a Kafka topic.
 * Make sure to start Kafka and create the topic before running this application!
 */
public class FilteredEventsToKafka {

    public static void main(String[] args) throws Exception {

        // Kafka producer properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");

        // set up streaming execution environment
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<WikipediaEditEvent> edits = env
                .addSource(new WikipediaEditsSource());

        // filter out events with negative byteDiff
       DataStream<String> filtered = edits.filter(new FilterFunction<WikipediaEditEvent>() {
           @Override
           public boolean filter(WikipediaEditEvent e) throws Exception {
               return e.getByteDiff() > 0;
           }
       }).map(new MapFunction<WikipediaEditEvent, String>() {
           @Override
           public String map(WikipediaEditEvent e) throws Exception {
               return e.toString();
           }
       });

        FlinkKafkaProducer<String> myKafkaProducer = new FlinkKafkaProducer<String>(
                "wiki-edits",         // target topic
                new SimpleStringSchema(),    // serialization schema
                properties);

        // write the filtered data to a Kafka sink
         filtered.addSink(myKafkaProducer);

        // run the pipeline
        env.execute("Filtered Events to Kafka");
    }
}