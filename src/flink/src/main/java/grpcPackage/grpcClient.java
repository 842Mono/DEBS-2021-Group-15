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

        // Create a configuration object to be passed into the first set of creating a benchmark
        BenchmarkConfiguration benchmarkConfig = BenchmarkConfiguration.newBuilder()
                .setToken("gppciibyukfkxidslfbdqofvnuzocnww")
                .setBatchSize(100)
                .setBenchmarkName("group-15")
                .setBenchmarkType("test")
                .addQueries(BenchmarkConfiguration.Query.Q1)
                .addQueries(BenchmarkConfiguration.Query.Q2)
                .build();

        // Initiate step one and send over the benchmarkConfig
        Benchmark benchmark = client.createNewBenchmark(benchmarkConfig);
        System.out.println("Benchmark ID: " + benchmark.getId());

        // Get locations
        System.out.println("Getting location data...");
        application.GlobalLocations = client.getLocations(benchmark);
        System.out.println("Location recieved!");



        // Start latency measuring
        System.out.println("Started latency adjustments");
        Ping ping = client.initializeLatencyMeasuring(benchmark);
        for (int i = 0; i < 10; i++){
            System.out.println("Ping...");
            client.measure(ping);
            System.out.println("Pong!");
        }
        client.endMeasurement(ping);
        System.out.println("Finished lantency adjustments");

        // Start benchmark, the race is on
        client.startBenchmark(benchmark);
        System.out.println("Bechmark Started!");

        //Process the events
        int cnt = 0;
        while(true) {
            Batch batch = client.nextBatch(benchmark);

            List<Measurement> currentYearMeasurements = batch.getCurrentList();
            List<Measurement> lastYearMeasurements = batch.getLastyearList();

            for(int i = 0; i < currentYearMeasurements.size(); ++i) {
                ctx.collect(new Team8Measurement(currentYearMeasurements.get(i), "ThisYear"));
            }
            for(int i = 0; i < lastYearMeasurements.size(); ++i)
            {
                ctx.collect(new Team8Measurement(lastYearMeasurements.get(i), "LastYear"));
            }



            if (batch.getLast()) { //Stop when we get the last batch
                System.out.println("Received lastbatch, finished!");
                break;
            }
        }

    }

    public void cancel() { System.out.println("CANCEL CALLED. TODO."); }


    //We can remove this.
    public static void FakeMain() { //(String[] args) {
        // Create channel to call to API servers
        ManagedChannel channel = ManagedChannelBuilder.forAddress("challenge.msrg.in.tum.de", 5023).usePlaintext().build();

        // Create a blocking stub because we need to make sure this response is recieved
        ChallengerBlockingStub client = ChallengerGrpc.newBlockingStub(channel)
                .withMaxInboundMessageSize(100 * 1024 * 1024)
                .withMaxOutboundMessageSize(100 * 1024 * 1024);

        // Create a configuration object to be passed into the first set of creating a benchmark
        BenchmarkConfiguration benchmarkConfig = BenchmarkConfiguration.newBuilder()
                .setToken("gppciibyukfkxidslfbdqofvnuzocnww")
                .setBatchSize(100)
                .setBenchmarkName("group-15")
                .setBenchmarkType("test")
                .addQueries(BenchmarkConfiguration.Query.Q1)
                .addQueries(BenchmarkConfiguration.Query.Q2)
                .build();

        // Initiate step one and send over the benchmarkConfig
        Benchmark benchmark = client.createNewBenchmark(benchmarkConfig);
        System.out.println("Benchmark ID: " + benchmark.getId());

        // Get locations
        System.out.println("Getting location data...");
        Locations locations = client.getLocations(benchmark);
        System.out.println("Location recieved!");

        // Start latency measuring
        System.out.println("Started latency adjustments");
        Ping ping = client.initializeLatencyMeasuring(benchmark);
        for (int i = 0; i < 10; i++){
            System.out.println("Ping...");
            client.measure(ping);
            System.out.println("Pong!");
        }
        client.endMeasurement(ping);
        System.out.println("Finished lantency adjustments");

        // Start benchmark, the race is on
        client.startBenchmark(benchmark);
        System.out.println("Bechmark Started!");

        //Process the events
        int cnt = 0;
        while(true) {
            Batch batch = client.nextBatch(benchmark);
            System.out.println("Processing batch #" + cnt);
            System.out.println(batch.getCurrentList());
            System.out.println(batch.getLastyearList());
            if (batch.getLast()) { //Stop when we get the last batch
                System.out.println("Received lastbatch, finished!");
                break;
            }

            //process the batch of events we have
            var topKImproved = calculateTopKImproved(batch);

            ResultQ1 q1Result = ResultQ1.newBuilder()
                    .setBenchmarkId(benchmark.getId())
                    .setBatchSeqId(batch.getSeqId()) //set the sequence number
                    .addAllTopkimproved(topKImproved)
                    .build();

            //return the result of Q1
            client.resultQ1(q1Result);

            var histogram = calculateHistogram(batch);
            ResultQ2 q2Result = ResultQ2.newBuilder()
                    .setBenchmarkId(benchmark.getId())
                    .setBatchSeqId(batch.getSeqId()) //set the sequence number
                    .addAllHistogram(histogram)
                    .build();

            client.resultQ2(q2Result);
            System.out.println("Processed batch #" + cnt);
            ++cnt;

            if(cnt > 100) {
                break;
            }
        }

        client.endBenchmark(benchmark);
        System.out.println("Ended Benchmark!");

    }
    private static List<TopKStreaks> calculateHistogram(Batch batch) {
        //TODO: improve implementation

        return new ArrayList<>();
    }

    private static List<TopKCities> calculateTopKImproved(Batch batch) {
        //TODO: improve this implementation

        return new ArrayList<>();
    }

}