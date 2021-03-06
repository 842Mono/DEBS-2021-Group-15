// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: challenger.proto

package com.grpc;

/**
 * Protobuf type {@code Challenger.Ping}
 */
public  final class Ping extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Challenger.Ping)
    PingOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Ping.newBuilder() to construct.
  private Ping(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Ping() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Ping();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Ping(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            benchmarkId_ = input.readInt64();
            break;
          }
          case 16: {

            correlationId_ = input.readInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.grpc.ChallengerProto.internal_static_Challenger_Ping_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.grpc.ChallengerProto.internal_static_Challenger_Ping_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.grpc.Ping.class, com.grpc.Ping.Builder.class);
  }

  public static final int BENCHMARK_ID_FIELD_NUMBER = 1;
  private long benchmarkId_;
  /**
   * <code>int64 benchmark_id = 1;</code>
   * @return The benchmarkId.
   */
  public long getBenchmarkId() {
    return benchmarkId_;
  }

  public static final int CORRELATION_ID_FIELD_NUMBER = 2;
  private long correlationId_;
  /**
   * <code>int64 correlation_id = 2;</code>
   * @return The correlationId.
   */
  public long getCorrelationId() {
    return correlationId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (benchmarkId_ != 0L) {
      output.writeInt64(1, benchmarkId_);
    }
    if (correlationId_ != 0L) {
      output.writeInt64(2, correlationId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (benchmarkId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, benchmarkId_);
    }
    if (correlationId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, correlationId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.grpc.Ping)) {
      return super.equals(obj);
    }
    com.grpc.Ping other = (com.grpc.Ping) obj;

    if (getBenchmarkId()
        != other.getBenchmarkId()) return false;
    if (getCorrelationId()
        != other.getCorrelationId()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + BENCHMARK_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getBenchmarkId());
    hash = (37 * hash) + CORRELATION_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCorrelationId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.grpc.Ping parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.Ping parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.Ping parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.Ping parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.Ping parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.Ping parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.Ping parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.Ping parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.Ping parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.grpc.Ping parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.Ping parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.Ping parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.grpc.Ping prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Challenger.Ping}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Challenger.Ping)
      com.grpc.PingOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.grpc.ChallengerProto.internal_static_Challenger_Ping_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.grpc.ChallengerProto.internal_static_Challenger_Ping_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.grpc.Ping.class, com.grpc.Ping.Builder.class);
    }

    // Construct using com.grpc.Ping.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      benchmarkId_ = 0L;

      correlationId_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.grpc.ChallengerProto.internal_static_Challenger_Ping_descriptor;
    }

    @java.lang.Override
    public com.grpc.Ping getDefaultInstanceForType() {
      return com.grpc.Ping.getDefaultInstance();
    }

    @java.lang.Override
    public com.grpc.Ping build() {
      com.grpc.Ping result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.grpc.Ping buildPartial() {
      com.grpc.Ping result = new com.grpc.Ping(this);
      result.benchmarkId_ = benchmarkId_;
      result.correlationId_ = correlationId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.grpc.Ping) {
        return mergeFrom((com.grpc.Ping)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.grpc.Ping other) {
      if (other == com.grpc.Ping.getDefaultInstance()) return this;
      if (other.getBenchmarkId() != 0L) {
        setBenchmarkId(other.getBenchmarkId());
      }
      if (other.getCorrelationId() != 0L) {
        setCorrelationId(other.getCorrelationId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.grpc.Ping parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.grpc.Ping) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long benchmarkId_ ;
    /**
     * <code>int64 benchmark_id = 1;</code>
     * @return The benchmarkId.
     */
    public long getBenchmarkId() {
      return benchmarkId_;
    }
    /**
     * <code>int64 benchmark_id = 1;</code>
     * @param value The benchmarkId to set.
     * @return This builder for chaining.
     */
    public Builder setBenchmarkId(long value) {
      
      benchmarkId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 benchmark_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearBenchmarkId() {
      
      benchmarkId_ = 0L;
      onChanged();
      return this;
    }

    private long correlationId_ ;
    /**
     * <code>int64 correlation_id = 2;</code>
     * @return The correlationId.
     */
    public long getCorrelationId() {
      return correlationId_;
    }
    /**
     * <code>int64 correlation_id = 2;</code>
     * @param value The correlationId to set.
     * @return This builder for chaining.
     */
    public Builder setCorrelationId(long value) {
      
      correlationId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 correlation_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCorrelationId() {
      
      correlationId_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Challenger.Ping)
  }

  // @@protoc_insertion_point(class_scope:Challenger.Ping)
  private static final com.grpc.Ping DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.grpc.Ping();
  }

  public static com.grpc.Ping getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Ping>
      PARSER = new com.google.protobuf.AbstractParser<Ping>() {
    @java.lang.Override
    public Ping parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Ping(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Ping> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Ping> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.grpc.Ping getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

