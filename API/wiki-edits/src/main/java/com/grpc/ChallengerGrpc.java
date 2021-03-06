package com.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: challenger.proto")
public final class ChallengerGrpc {

  private ChallengerGrpc() {}

  public static final String SERVICE_NAME = "Challenger.Challenger";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.BenchmarkConfiguration,
      com.grpc.Benchmark> getCreateNewBenchmarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createNewBenchmark",
      requestType = com.grpc.BenchmarkConfiguration.class,
      responseType = com.grpc.Benchmark.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.BenchmarkConfiguration,
      com.grpc.Benchmark> getCreateNewBenchmarkMethod() {
    io.grpc.MethodDescriptor<com.grpc.BenchmarkConfiguration, com.grpc.Benchmark> getCreateNewBenchmarkMethod;
    if ((getCreateNewBenchmarkMethod = ChallengerGrpc.getCreateNewBenchmarkMethod) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getCreateNewBenchmarkMethod = ChallengerGrpc.getCreateNewBenchmarkMethod) == null) {
          ChallengerGrpc.getCreateNewBenchmarkMethod = getCreateNewBenchmarkMethod = 
              io.grpc.MethodDescriptor.<com.grpc.BenchmarkConfiguration, com.grpc.Benchmark>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "createNewBenchmark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.BenchmarkConfiguration.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Benchmark.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("createNewBenchmark"))
                  .build();
          }
        }
     }
     return getCreateNewBenchmarkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.grpc.Locations> getGetLocationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLocations",
      requestType = com.grpc.Benchmark.class,
      responseType = com.grpc.Locations.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.grpc.Locations> getGetLocationsMethod() {
    io.grpc.MethodDescriptor<com.grpc.Benchmark, com.grpc.Locations> getGetLocationsMethod;
    if ((getGetLocationsMethod = ChallengerGrpc.getGetLocationsMethod) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getGetLocationsMethod = ChallengerGrpc.getGetLocationsMethod) == null) {
          ChallengerGrpc.getGetLocationsMethod = getGetLocationsMethod = 
              io.grpc.MethodDescriptor.<com.grpc.Benchmark, com.grpc.Locations>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "getLocations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Benchmark.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Locations.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("getLocations"))
                  .build();
          }
        }
     }
     return getGetLocationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.grpc.Ping> getInitializeLatencyMeasuringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "initializeLatencyMeasuring",
      requestType = com.grpc.Benchmark.class,
      responseType = com.grpc.Ping.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.grpc.Ping> getInitializeLatencyMeasuringMethod() {
    io.grpc.MethodDescriptor<com.grpc.Benchmark, com.grpc.Ping> getInitializeLatencyMeasuringMethod;
    if ((getInitializeLatencyMeasuringMethod = ChallengerGrpc.getInitializeLatencyMeasuringMethod) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getInitializeLatencyMeasuringMethod = ChallengerGrpc.getInitializeLatencyMeasuringMethod) == null) {
          ChallengerGrpc.getInitializeLatencyMeasuringMethod = getInitializeLatencyMeasuringMethod = 
              io.grpc.MethodDescriptor.<com.grpc.Benchmark, com.grpc.Ping>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "initializeLatencyMeasuring"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Benchmark.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Ping.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("initializeLatencyMeasuring"))
                  .build();
          }
        }
     }
     return getInitializeLatencyMeasuringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.Ping,
      com.grpc.Ping> getMeasureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "measure",
      requestType = com.grpc.Ping.class,
      responseType = com.grpc.Ping.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.Ping,
      com.grpc.Ping> getMeasureMethod() {
    io.grpc.MethodDescriptor<com.grpc.Ping, com.grpc.Ping> getMeasureMethod;
    if ((getMeasureMethod = ChallengerGrpc.getMeasureMethod) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getMeasureMethod = ChallengerGrpc.getMeasureMethod) == null) {
          ChallengerGrpc.getMeasureMethod = getMeasureMethod = 
              io.grpc.MethodDescriptor.<com.grpc.Ping, com.grpc.Ping>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "measure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Ping.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Ping.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("measure"))
                  .build();
          }
        }
     }
     return getMeasureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.Ping,
      com.google.protobuf.Empty> getEndMeasurementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "endMeasurement",
      requestType = com.grpc.Ping.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.Ping,
      com.google.protobuf.Empty> getEndMeasurementMethod() {
    io.grpc.MethodDescriptor<com.grpc.Ping, com.google.protobuf.Empty> getEndMeasurementMethod;
    if ((getEndMeasurementMethod = ChallengerGrpc.getEndMeasurementMethod) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getEndMeasurementMethod = ChallengerGrpc.getEndMeasurementMethod) == null) {
          ChallengerGrpc.getEndMeasurementMethod = getEndMeasurementMethod = 
              io.grpc.MethodDescriptor.<com.grpc.Ping, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "endMeasurement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Ping.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("endMeasurement"))
                  .build();
          }
        }
     }
     return getEndMeasurementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.google.protobuf.Empty> getStartBenchmarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "startBenchmark",
      requestType = com.grpc.Benchmark.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.google.protobuf.Empty> getStartBenchmarkMethod() {
    io.grpc.MethodDescriptor<com.grpc.Benchmark, com.google.protobuf.Empty> getStartBenchmarkMethod;
    if ((getStartBenchmarkMethod = ChallengerGrpc.getStartBenchmarkMethod) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getStartBenchmarkMethod = ChallengerGrpc.getStartBenchmarkMethod) == null) {
          ChallengerGrpc.getStartBenchmarkMethod = getStartBenchmarkMethod = 
              io.grpc.MethodDescriptor.<com.grpc.Benchmark, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "startBenchmark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Benchmark.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("startBenchmark"))
                  .build();
          }
        }
     }
     return getStartBenchmarkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.grpc.Batch> getNextBatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "nextBatch",
      requestType = com.grpc.Benchmark.class,
      responseType = com.grpc.Batch.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.grpc.Batch> getNextBatchMethod() {
    io.grpc.MethodDescriptor<com.grpc.Benchmark, com.grpc.Batch> getNextBatchMethod;
    if ((getNextBatchMethod = ChallengerGrpc.getNextBatchMethod) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getNextBatchMethod = ChallengerGrpc.getNextBatchMethod) == null) {
          ChallengerGrpc.getNextBatchMethod = getNextBatchMethod = 
              io.grpc.MethodDescriptor.<com.grpc.Benchmark, com.grpc.Batch>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "nextBatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Benchmark.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Batch.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("nextBatch"))
                  .build();
          }
        }
     }
     return getNextBatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.ResultQ1,
      com.google.protobuf.Empty> getResultQ1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "resultQ1",
      requestType = com.grpc.ResultQ1.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.ResultQ1,
      com.google.protobuf.Empty> getResultQ1Method() {
    io.grpc.MethodDescriptor<com.grpc.ResultQ1, com.google.protobuf.Empty> getResultQ1Method;
    if ((getResultQ1Method = ChallengerGrpc.getResultQ1Method) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getResultQ1Method = ChallengerGrpc.getResultQ1Method) == null) {
          ChallengerGrpc.getResultQ1Method = getResultQ1Method = 
              io.grpc.MethodDescriptor.<com.grpc.ResultQ1, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "resultQ1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ResultQ1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("resultQ1"))
                  .build();
          }
        }
     }
     return getResultQ1Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.ResultQ2,
      com.google.protobuf.Empty> getResultQ2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "resultQ2",
      requestType = com.grpc.ResultQ2.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.ResultQ2,
      com.google.protobuf.Empty> getResultQ2Method() {
    io.grpc.MethodDescriptor<com.grpc.ResultQ2, com.google.protobuf.Empty> getResultQ2Method;
    if ((getResultQ2Method = ChallengerGrpc.getResultQ2Method) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getResultQ2Method = ChallengerGrpc.getResultQ2Method) == null) {
          ChallengerGrpc.getResultQ2Method = getResultQ2Method = 
              io.grpc.MethodDescriptor.<com.grpc.ResultQ2, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "resultQ2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.ResultQ2.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("resultQ2"))
                  .build();
          }
        }
     }
     return getResultQ2Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.google.protobuf.Empty> getEndBenchmarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "endBenchmark",
      requestType = com.grpc.Benchmark.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.Benchmark,
      com.google.protobuf.Empty> getEndBenchmarkMethod() {
    io.grpc.MethodDescriptor<com.grpc.Benchmark, com.google.protobuf.Empty> getEndBenchmarkMethod;
    if ((getEndBenchmarkMethod = ChallengerGrpc.getEndBenchmarkMethod) == null) {
      synchronized (ChallengerGrpc.class) {
        if ((getEndBenchmarkMethod = ChallengerGrpc.getEndBenchmarkMethod) == null) {
          ChallengerGrpc.getEndBenchmarkMethod = getEndBenchmarkMethod = 
              io.grpc.MethodDescriptor.<com.grpc.Benchmark, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Challenger.Challenger", "endBenchmark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.Benchmark.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ChallengerMethodDescriptorSupplier("endBenchmark"))
                  .build();
          }
        }
     }
     return getEndBenchmarkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChallengerStub newStub(io.grpc.Channel channel) {
    return new ChallengerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChallengerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChallengerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChallengerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChallengerFutureStub(channel);
  }

  /**
   */
  public static abstract class ChallengerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Create a new Benchmark based on the configuration
     * </pre>
     */
    public void createNewBenchmark(com.grpc.BenchmarkConfiguration request,
        io.grpc.stub.StreamObserver<com.grpc.Benchmark> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateNewBenchmarkMethod(), responseObserver);
    }

    /**
     * <pre>
     *Get the polygons of all zip areas in germany based on the benchmarktype
     * </pre>
     */
    public void getLocations(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.grpc.Locations> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLocationsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Depending on your connectivity you have a latency and throughput.
     * Optionally, we try to account for this by first measuring it.
     * The payload of a Ping corresponds roughly to the payload of a batch and the returning Pong roughly the payload of a Result
     * This kind of measurement is just for development and experimentation (since it could be easily cheated ;-))
     * We do not consider that once you deploy your implementation on the VMs in our infrastructure
     * </pre>
     */
    public void initializeLatencyMeasuring(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.grpc.Ping> responseObserver) {
      asyncUnimplementedUnaryCall(getInitializeLatencyMeasuringMethod(), responseObserver);
    }

    /**
     */
    public void measure(com.grpc.Ping request,
        io.grpc.stub.StreamObserver<com.grpc.Ping> responseObserver) {
      asyncUnimplementedUnaryCall(getMeasureMethod(), responseObserver);
    }

    /**
     */
    public void endMeasurement(com.grpc.Ping request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getEndMeasurementMethod(), responseObserver);
    }

    /**
     * <pre>
     *This marks the starting point of the throughput measurements
     * </pre>
     */
    public void startBenchmark(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getStartBenchmarkMethod(), responseObserver);
    }

    /**
     * <pre>
     *get the next Batch
     * </pre>
     */
    public void nextBatch(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.grpc.Batch> responseObserver) {
      asyncUnimplementedUnaryCall(getNextBatchMethod(), responseObserver);
    }

    /**
     * <pre>
     *post the result
     * </pre>
     */
    public void resultQ1(com.grpc.ResultQ1 request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getResultQ1Method(), responseObserver);
    }

    /**
     */
    public void resultQ2(com.grpc.ResultQ2 request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getResultQ2Method(), responseObserver);
    }

    /**
     * <pre>
     *This marks the end of the throughput measurements
     * </pre>
     */
    public void endBenchmark(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getEndBenchmarkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateNewBenchmarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.BenchmarkConfiguration,
                com.grpc.Benchmark>(
                  this, METHODID_CREATE_NEW_BENCHMARK)))
          .addMethod(
            getGetLocationsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.Benchmark,
                com.grpc.Locations>(
                  this, METHODID_GET_LOCATIONS)))
          .addMethod(
            getInitializeLatencyMeasuringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.Benchmark,
                com.grpc.Ping>(
                  this, METHODID_INITIALIZE_LATENCY_MEASURING)))
          .addMethod(
            getMeasureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.Ping,
                com.grpc.Ping>(
                  this, METHODID_MEASURE)))
          .addMethod(
            getEndMeasurementMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.Ping,
                com.google.protobuf.Empty>(
                  this, METHODID_END_MEASUREMENT)))
          .addMethod(
            getStartBenchmarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.Benchmark,
                com.google.protobuf.Empty>(
                  this, METHODID_START_BENCHMARK)))
          .addMethod(
            getNextBatchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.Benchmark,
                com.grpc.Batch>(
                  this, METHODID_NEXT_BATCH)))
          .addMethod(
            getResultQ1Method(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.ResultQ1,
                com.google.protobuf.Empty>(
                  this, METHODID_RESULT_Q1)))
          .addMethod(
            getResultQ2Method(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.ResultQ2,
                com.google.protobuf.Empty>(
                  this, METHODID_RESULT_Q2)))
          .addMethod(
            getEndBenchmarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.Benchmark,
                com.google.protobuf.Empty>(
                  this, METHODID_END_BENCHMARK)))
          .build();
    }
  }

  /**
   */
  public static final class ChallengerStub extends io.grpc.stub.AbstractStub<ChallengerStub> {
    private ChallengerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChallengerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChallengerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChallengerStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create a new Benchmark based on the configuration
     * </pre>
     */
    public void createNewBenchmark(com.grpc.BenchmarkConfiguration request,
        io.grpc.stub.StreamObserver<com.grpc.Benchmark> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateNewBenchmarkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Get the polygons of all zip areas in germany based on the benchmarktype
     * </pre>
     */
    public void getLocations(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.grpc.Locations> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLocationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Depending on your connectivity you have a latency and throughput.
     * Optionally, we try to account for this by first measuring it.
     * The payload of a Ping corresponds roughly to the payload of a batch and the returning Pong roughly the payload of a Result
     * This kind of measurement is just for development and experimentation (since it could be easily cheated ;-))
     * We do not consider that once you deploy your implementation on the VMs in our infrastructure
     * </pre>
     */
    public void initializeLatencyMeasuring(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.grpc.Ping> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitializeLatencyMeasuringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void measure(com.grpc.Ping request,
        io.grpc.stub.StreamObserver<com.grpc.Ping> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMeasureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void endMeasurement(com.grpc.Ping request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEndMeasurementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *This marks the starting point of the throughput measurements
     * </pre>
     */
    public void startBenchmark(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartBenchmarkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *get the next Batch
     * </pre>
     */
    public void nextBatch(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.grpc.Batch> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNextBatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *post the result
     * </pre>
     */
    public void resultQ1(com.grpc.ResultQ1 request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResultQ1Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resultQ2(com.grpc.ResultQ2 request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResultQ2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *This marks the end of the throughput measurements
     * </pre>
     */
    public void endBenchmark(com.grpc.Benchmark request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEndBenchmarkMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChallengerBlockingStub extends io.grpc.stub.AbstractStub<ChallengerBlockingStub> {
    private ChallengerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChallengerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChallengerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChallengerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create a new Benchmark based on the configuration
     * </pre>
     */
    public com.grpc.Benchmark createNewBenchmark(com.grpc.BenchmarkConfiguration request) {
      return blockingUnaryCall(
          getChannel(), getCreateNewBenchmarkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Get the polygons of all zip areas in germany based on the benchmarktype
     * </pre>
     */
    public com.grpc.Locations getLocations(com.grpc.Benchmark request) {
      return blockingUnaryCall(
          getChannel(), getGetLocationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Depending on your connectivity you have a latency and throughput.
     * Optionally, we try to account for this by first measuring it.
     * The payload of a Ping corresponds roughly to the payload of a batch and the returning Pong roughly the payload of a Result
     * This kind of measurement is just for development and experimentation (since it could be easily cheated ;-))
     * We do not consider that once you deploy your implementation on the VMs in our infrastructure
     * </pre>
     */
    public com.grpc.Ping initializeLatencyMeasuring(com.grpc.Benchmark request) {
      return blockingUnaryCall(
          getChannel(), getInitializeLatencyMeasuringMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.Ping measure(com.grpc.Ping request) {
      return blockingUnaryCall(
          getChannel(), getMeasureMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty endMeasurement(com.grpc.Ping request) {
      return blockingUnaryCall(
          getChannel(), getEndMeasurementMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *This marks the starting point of the throughput measurements
     * </pre>
     */
    public com.google.protobuf.Empty startBenchmark(com.grpc.Benchmark request) {
      return blockingUnaryCall(
          getChannel(), getStartBenchmarkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *get the next Batch
     * </pre>
     */
    public com.grpc.Batch nextBatch(com.grpc.Benchmark request) {
      return blockingUnaryCall(
          getChannel(), getNextBatchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *post the result
     * </pre>
     */
    public com.google.protobuf.Empty resultQ1(com.grpc.ResultQ1 request) {
      return blockingUnaryCall(
          getChannel(), getResultQ1Method(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty resultQ2(com.grpc.ResultQ2 request) {
      return blockingUnaryCall(
          getChannel(), getResultQ2Method(), getCallOptions(), request);
    }

    /**
     * <pre>
     *This marks the end of the throughput measurements
     * </pre>
     */
    public com.google.protobuf.Empty endBenchmark(com.grpc.Benchmark request) {
      return blockingUnaryCall(
          getChannel(), getEndBenchmarkMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChallengerFutureStub extends io.grpc.stub.AbstractStub<ChallengerFutureStub> {
    private ChallengerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChallengerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChallengerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChallengerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create a new Benchmark based on the configuration
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.Benchmark> createNewBenchmark(
        com.grpc.BenchmarkConfiguration request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateNewBenchmarkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Get the polygons of all zip areas in germany based on the benchmarktype
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.Locations> getLocations(
        com.grpc.Benchmark request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLocationsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Depending on your connectivity you have a latency and throughput.
     * Optionally, we try to account for this by first measuring it.
     * The payload of a Ping corresponds roughly to the payload of a batch and the returning Pong roughly the payload of a Result
     * This kind of measurement is just for development and experimentation (since it could be easily cheated ;-))
     * We do not consider that once you deploy your implementation on the VMs in our infrastructure
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.Ping> initializeLatencyMeasuring(
        com.grpc.Benchmark request) {
      return futureUnaryCall(
          getChannel().newCall(getInitializeLatencyMeasuringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.Ping> measure(
        com.grpc.Ping request) {
      return futureUnaryCall(
          getChannel().newCall(getMeasureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> endMeasurement(
        com.grpc.Ping request) {
      return futureUnaryCall(
          getChannel().newCall(getEndMeasurementMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *This marks the starting point of the throughput measurements
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> startBenchmark(
        com.grpc.Benchmark request) {
      return futureUnaryCall(
          getChannel().newCall(getStartBenchmarkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *get the next Batch
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.Batch> nextBatch(
        com.grpc.Benchmark request) {
      return futureUnaryCall(
          getChannel().newCall(getNextBatchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *post the result
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> resultQ1(
        com.grpc.ResultQ1 request) {
      return futureUnaryCall(
          getChannel().newCall(getResultQ1Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> resultQ2(
        com.grpc.ResultQ2 request) {
      return futureUnaryCall(
          getChannel().newCall(getResultQ2Method(), getCallOptions()), request);
    }

    /**
     * <pre>
     *This marks the end of the throughput measurements
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> endBenchmark(
        com.grpc.Benchmark request) {
      return futureUnaryCall(
          getChannel().newCall(getEndBenchmarkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NEW_BENCHMARK = 0;
  private static final int METHODID_GET_LOCATIONS = 1;
  private static final int METHODID_INITIALIZE_LATENCY_MEASURING = 2;
  private static final int METHODID_MEASURE = 3;
  private static final int METHODID_END_MEASUREMENT = 4;
  private static final int METHODID_START_BENCHMARK = 5;
  private static final int METHODID_NEXT_BATCH = 6;
  private static final int METHODID_RESULT_Q1 = 7;
  private static final int METHODID_RESULT_Q2 = 8;
  private static final int METHODID_END_BENCHMARK = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChallengerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChallengerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_NEW_BENCHMARK:
          serviceImpl.createNewBenchmark((com.grpc.BenchmarkConfiguration) request,
              (io.grpc.stub.StreamObserver<com.grpc.Benchmark>) responseObserver);
          break;
        case METHODID_GET_LOCATIONS:
          serviceImpl.getLocations((com.grpc.Benchmark) request,
              (io.grpc.stub.StreamObserver<com.grpc.Locations>) responseObserver);
          break;
        case METHODID_INITIALIZE_LATENCY_MEASURING:
          serviceImpl.initializeLatencyMeasuring((com.grpc.Benchmark) request,
              (io.grpc.stub.StreamObserver<com.grpc.Ping>) responseObserver);
          break;
        case METHODID_MEASURE:
          serviceImpl.measure((com.grpc.Ping) request,
              (io.grpc.stub.StreamObserver<com.grpc.Ping>) responseObserver);
          break;
        case METHODID_END_MEASUREMENT:
          serviceImpl.endMeasurement((com.grpc.Ping) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_START_BENCHMARK:
          serviceImpl.startBenchmark((com.grpc.Benchmark) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_NEXT_BATCH:
          serviceImpl.nextBatch((com.grpc.Benchmark) request,
              (io.grpc.stub.StreamObserver<com.grpc.Batch>) responseObserver);
          break;
        case METHODID_RESULT_Q1:
          serviceImpl.resultQ1((com.grpc.ResultQ1) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESULT_Q2:
          serviceImpl.resultQ2((com.grpc.ResultQ2) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_END_BENCHMARK:
          serviceImpl.endBenchmark((com.grpc.Benchmark) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChallengerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChallengerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.ChallengerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Challenger");
    }
  }

  private static final class ChallengerFileDescriptorSupplier
      extends ChallengerBaseDescriptorSupplier {
    ChallengerFileDescriptorSupplier() {}
  }

  private static final class ChallengerMethodDescriptorSupplier
      extends ChallengerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChallengerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChallengerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChallengerFileDescriptorSupplier())
              .addMethod(getCreateNewBenchmarkMethod())
              .addMethod(getGetLocationsMethod())
              .addMethod(getInitializeLatencyMeasuringMethod())
              .addMethod(getMeasureMethod())
              .addMethod(getEndMeasurementMethod())
              .addMethod(getStartBenchmarkMethod())
              .addMethod(getNextBatchMethod())
              .addMethod(getResultQ1Method())
              .addMethod(getResultQ2Method())
              .addMethod(getEndBenchmarkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
