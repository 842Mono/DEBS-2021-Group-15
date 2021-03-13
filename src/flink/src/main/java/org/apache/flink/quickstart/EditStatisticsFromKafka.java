package org.apache.flink.quickstart;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

/**
 * Write a Flink program that consumes events from the Kafka topic "wiki-edits",
 * computes the absolute number of byteDiff every 10s,
 * and prints the result to standard output.
 *
 * TIP: See the following Flink documentation pages:
 * - Kafka consumer: https://ci.apache.org/projects/flink/flink-docs-release-1.12/dev/connectors/kafka.html#kafka-consumer
 * - Windows: https://ci.apache.org/projects/flink/flink-docs-release-1.12/dev/stream/operators/windows.html
 */
public class EditStatisticsFromKafka {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "test");

        // set up streaming execution environment
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // create a Kafka consumer
        /**
        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>(...)

         **/

        // execute program
        env.execute("Consume events from Kafka");

    }
}