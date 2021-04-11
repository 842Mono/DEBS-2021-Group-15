package grpcPackage;

import java.util.ArrayList;
import java.util.List;

import com.grpc.*;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ManagedChannel;

import com.grpc.ChallengerGrpc.ChallengerBlockingStub;
import org.apache.flink.quickstart.Team8Measurement;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

import org.apache.flink.quickstart.application;

public class grpcClient extends RichSourceFunction<Team8Measurement> { //<Data> {

    public void run(SourceContext<Team8Measurement> ctx){ //<Data> ctx) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("challenge.msrg.in.tum.de", 5023).usePlaintext().build();

        // Create a blocking stub because we need to make sure this response is recieved
        ChallengerBlockingStub client = ChallengerGrpc.newBlockingStub(channel)
                .withMaxInboundMessageSize(100 * 1024 * 1024)
                .withMaxOutboundMessageSize(100 * 1024 * 1024);
        application.client = client;

        // Create a configuration object to be passed into the first set of creating a benchmark
        BenchmarkConfiguration benchmarkConfig = BenchmarkConfiguration.newBuilder()
                .setToken("gppciibyukfkxidslfbdqofvnuzocnww")
//                .setBatchSize(100)
//                .setBatchSize(20000)
                .setBatchSize(10000)
                .setBenchmarkName("group-15")
                .setBenchmarkType("evaluation")
                .addQueries(BenchmarkConfiguration.Query.Q1)
                .addQueries(BenchmarkConfiguration.Query.Q2)
                .build();

        // Initiate step one and send over the benchmarkConfig
        Benchmark benchmark = client.createNewBenchmark(benchmarkConfig);
        System.out.println("Benchmark ID: " + benchmark.getId());
        application.benchId = benchmark.getId();

        // Get locations
        System.out.println("Getting location data...");
        application.GlobalLocations = client.getLocations(benchmark);
        System.out.println("Location recieved!");



        // Start latency measuring
        System.out.println("Started latency adjustments");
        Ping ping = client.initializeLatencyMeasuring(benchmark);
        for (int i = 0; i < 10; i++){
            client.measure(ping);
        }
        client.endMeasurement(ping);
        System.out.println("Finished lantency adjustments");

        // Start benchmark, the race is on
        client.startBenchmark(benchmark);
        System.out.println("Bechmark Started!");

        //Process the events
        while(true) {
            Batch batch = client.nextBatch(benchmark);
            application.batchseq = batch.getSeqId();
            List<Measurement> currentYearMeasurements = batch.getCurrentList();
            List<Measurement> lastYearMeasurements = batch.getLastyearList();

            for(int i = 0; i < currentYearMeasurements.size(); ++i) {
                ctx.collect(new Team8Measurement(currentYearMeasurements.get(i), "ThisYear", i == currentYearMeasurements.size() - 1));
            }
            for(int i = 0; i < lastYearMeasurements.size(); ++i)
            {
                ctx.collect(new Team8Measurement(lastYearMeasurements.get(i), "LastYear", i == lastYearMeasurements.size() - 1));
            }

            if (batch.getLast()) { //Stop when we get the last batch
                System.out.println("Received lastbatch, finished!");
                while (true) {
                    if (application.finished){
                        client.endBenchmark(benchmark);
                        break;
                    }
                }
            }
        }
    }

    public void cancel() { System.out.println("CANCEL CALLED. TODO."); }
}