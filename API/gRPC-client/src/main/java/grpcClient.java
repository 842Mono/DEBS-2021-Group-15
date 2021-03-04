import io.grpc.ManagedChannelBuilder;
import io.grpc.ManagedChannel;

import com.grpc.Benchmark;
import com.grpc.BenchmarkConfiguration;
import com.grpc.ChallengerGrpc;
import com.grpc.ChallengerGrpc.ChallengerBlockingStub;
public class grpcClient {

    public static void main(String[] args) {
        // Create channel to call to API servers
        ManagedChannel channel = ManagedChannelBuilder.forAddress("challenge.msrg.in.tum.de", 5023).usePlaintext().build();

        // Create a blocking stub because we need to make sure this response is recieved
        ChallengerBlockingStub userStub = ChallengerGrpc.newBlockingStub(channel);

        // Create a configuration object to be passed into the first set of creating a benchmark
        BenchmarkConfiguration benchmarkConfig = BenchmarkConfiguration.newBuilder()
            .setToken("gppciibyukfkxidslfbdqofvnuzocnww")
            .setBatchSize(100)
            .setBenchmarkName("group-15")
            .setBenchmarkType("test")
            .build();

        // Initiate step one and send over the benchmarkConfig
        Benchmark benchmark = userStub.createNewBenchmark(benchmarkConfig);
        System.out.println(benchmark.getId());
    }
}