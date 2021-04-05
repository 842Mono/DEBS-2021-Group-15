// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: challenger.proto

package com.grpc;

/**
 * Protobuf type {@code Challenger.Batch}
 */
public  final class Batch extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Challenger.Batch)
    BatchOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Batch.newBuilder() to construct.
  private Batch(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Batch() {
    current_ = java.util.Collections.emptyList();
    lastyear_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Batch();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Batch(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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

            seqId_ = input.readInt64();
            break;
          }
          case 16: {

            last_ = input.readBool();
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              current_ = new java.util.ArrayList<com.grpc.Measurement>();
              mutable_bitField0_ |= 0x00000001;
            }
            current_.add(
                input.readMessage(com.grpc.Measurement.parser(), extensionRegistry));
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000002) != 0)) {
              lastyear_ = new java.util.ArrayList<com.grpc.Measurement>();
              mutable_bitField0_ |= 0x00000002;
            }
            lastyear_.add(
                input.readMessage(com.grpc.Measurement.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        current_ = java.util.Collections.unmodifiableList(current_);
      }
      if (((mutable_bitField0_ & 0x00000002) != 0)) {
        lastyear_ = java.util.Collections.unmodifiableList(lastyear_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.grpc.ChallengerProto.internal_static_Challenger_Batch_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.grpc.ChallengerProto.internal_static_Challenger_Batch_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.grpc.Batch.class, com.grpc.Batch.Builder.class);
  }

  public static final int SEQ_ID_FIELD_NUMBER = 1;
  private long seqId_;
  /**
   * <code>int64 seq_id = 1;</code>
   * @return The seqId.
   */
  public long getSeqId() {
    return seqId_;
  }

  public static final int LAST_FIELD_NUMBER = 2;
  private boolean last_;
  /**
   * <pre>
   *Set to true when it is the last batch
   * </pre>
   *
   * <code>bool last = 2;</code>
   * @return The last.
   */
  public boolean getLast() {
    return last_;
  }

  public static final int CURRENT_FIELD_NUMBER = 3;
  private java.util.List<com.grpc.Measurement> current_;
  /**
   * <code>repeated .Challenger.Measurement current = 3;</code>
   */
  public java.util.List<com.grpc.Measurement> getCurrentList() {
    return current_;
  }
  /**
   * <code>repeated .Challenger.Measurement current = 3;</code>
   */
  public java.util.List<? extends com.grpc.MeasurementOrBuilder> 
      getCurrentOrBuilderList() {
    return current_;
  }
  /**
   * <code>repeated .Challenger.Measurement current = 3;</code>
   */
  public int getCurrentCount() {
    return current_.size();
  }
  /**
   * <code>repeated .Challenger.Measurement current = 3;</code>
   */
  public com.grpc.Measurement getCurrent(int index) {
    return current_.get(index);
  }
  /**
   * <code>repeated .Challenger.Measurement current = 3;</code>
   */
  public com.grpc.MeasurementOrBuilder getCurrentOrBuilder(
      int index) {
    return current_.get(index);
  }

  public static final int LASTYEAR_FIELD_NUMBER = 4;
  private java.util.List<com.grpc.Measurement> lastyear_;
  /**
   * <code>repeated .Challenger.Measurement lastyear = 4;</code>
   */
  public java.util.List<com.grpc.Measurement> getLastyearList() {
    return lastyear_;
  }
  /**
   * <code>repeated .Challenger.Measurement lastyear = 4;</code>
   */
  public java.util.List<? extends com.grpc.MeasurementOrBuilder> 
      getLastyearOrBuilderList() {
    return lastyear_;
  }
  /**
   * <code>repeated .Challenger.Measurement lastyear = 4;</code>
   */
  public int getLastyearCount() {
    return lastyear_.size();
  }
  /**
   * <code>repeated .Challenger.Measurement lastyear = 4;</code>
   */
  public com.grpc.Measurement getLastyear(int index) {
    return lastyear_.get(index);
  }
  /**
   * <code>repeated .Challenger.Measurement lastyear = 4;</code>
   */
  public com.grpc.MeasurementOrBuilder getLastyearOrBuilder(
      int index) {
    return lastyear_.get(index);
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
    if (seqId_ != 0L) {
      output.writeInt64(1, seqId_);
    }
    if (last_ != false) {
      output.writeBool(2, last_);
    }
    for (int i = 0; i < current_.size(); i++) {
      output.writeMessage(3, current_.get(i));
    }
    for (int i = 0; i < lastyear_.size(); i++) {
      output.writeMessage(4, lastyear_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (seqId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, seqId_);
    }
    if (last_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, last_);
    }
    for (int i = 0; i < current_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, current_.get(i));
    }
    for (int i = 0; i < lastyear_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, lastyear_.get(i));
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
    if (!(obj instanceof com.grpc.Batch)) {
      return super.equals(obj);
    }
    com.grpc.Batch other = (com.grpc.Batch) obj;

    if (getSeqId()
        != other.getSeqId()) return false;
    if (getLast()
        != other.getLast()) return false;
    if (!getCurrentList()
        .equals(other.getCurrentList())) return false;
    if (!getLastyearList()
        .equals(other.getLastyearList())) return false;
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
    hash = (37 * hash) + SEQ_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSeqId());
    hash = (37 * hash) + LAST_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getLast());
    if (getCurrentCount() > 0) {
      hash = (37 * hash) + CURRENT_FIELD_NUMBER;
      hash = (53 * hash) + getCurrentList().hashCode();
    }
    if (getLastyearCount() > 0) {
      hash = (37 * hash) + LASTYEAR_FIELD_NUMBER;
      hash = (53 * hash) + getLastyearList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.grpc.Batch parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.Batch parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.Batch parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.Batch parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.Batch parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.Batch parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.Batch parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.Batch parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.Batch parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.grpc.Batch parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.Batch parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.Batch parseFrom(
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
  public static Builder newBuilder(com.grpc.Batch prototype) {
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
   * Protobuf type {@code Challenger.Batch}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Challenger.Batch)
      com.grpc.BatchOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.grpc.ChallengerProto.internal_static_Challenger_Batch_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.grpc.ChallengerProto.internal_static_Challenger_Batch_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.grpc.Batch.class, com.grpc.Batch.Builder.class);
    }

    // Construct using com.grpc.Batch.newBuilder()
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
        getCurrentFieldBuilder();
        getLastyearFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      seqId_ = 0L;

      last_ = false;

      if (currentBuilder_ == null) {
        current_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        currentBuilder_.clear();
      }
      if (lastyearBuilder_ == null) {
        lastyear_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        lastyearBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.grpc.ChallengerProto.internal_static_Challenger_Batch_descriptor;
    }

    @java.lang.Override
    public com.grpc.Batch getDefaultInstanceForType() {
      return com.grpc.Batch.getDefaultInstance();
    }

    @java.lang.Override
    public com.grpc.Batch build() {
      com.grpc.Batch result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.grpc.Batch buildPartial() {
      com.grpc.Batch result = new com.grpc.Batch(this);
      int from_bitField0_ = bitField0_;
      result.seqId_ = seqId_;
      result.last_ = last_;
      if (currentBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          current_ = java.util.Collections.unmodifiableList(current_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.current_ = current_;
      } else {
        result.current_ = currentBuilder_.build();
      }
      if (lastyearBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          lastyear_ = java.util.Collections.unmodifiableList(lastyear_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.lastyear_ = lastyear_;
      } else {
        result.lastyear_ = lastyearBuilder_.build();
      }
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
      if (other instanceof com.grpc.Batch) {
        return mergeFrom((com.grpc.Batch)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.grpc.Batch other) {
      if (other == com.grpc.Batch.getDefaultInstance()) return this;
      if (other.getSeqId() != 0L) {
        setSeqId(other.getSeqId());
      }
      if (other.getLast() != false) {
        setLast(other.getLast());
      }
      if (currentBuilder_ == null) {
        if (!other.current_.isEmpty()) {
          if (current_.isEmpty()) {
            current_ = other.current_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureCurrentIsMutable();
            current_.addAll(other.current_);
          }
          onChanged();
        }
      } else {
        if (!other.current_.isEmpty()) {
          if (currentBuilder_.isEmpty()) {
            currentBuilder_.dispose();
            currentBuilder_ = null;
            current_ = other.current_;
            bitField0_ = (bitField0_ & ~0x00000001);
            currentBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getCurrentFieldBuilder() : null;
          } else {
            currentBuilder_.addAllMessages(other.current_);
          }
        }
      }
      if (lastyearBuilder_ == null) {
        if (!other.lastyear_.isEmpty()) {
          if (lastyear_.isEmpty()) {
            lastyear_ = other.lastyear_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureLastyearIsMutable();
            lastyear_.addAll(other.lastyear_);
          }
          onChanged();
        }
      } else {
        if (!other.lastyear_.isEmpty()) {
          if (lastyearBuilder_.isEmpty()) {
            lastyearBuilder_.dispose();
            lastyearBuilder_ = null;
            lastyear_ = other.lastyear_;
            bitField0_ = (bitField0_ & ~0x00000002);
            lastyearBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getLastyearFieldBuilder() : null;
          } else {
            lastyearBuilder_.addAllMessages(other.lastyear_);
          }
        }
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
      com.grpc.Batch parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.grpc.Batch) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long seqId_ ;
    /**
     * <code>int64 seq_id = 1;</code>
     * @return The seqId.
     */
    public long getSeqId() {
      return seqId_;
    }
    /**
     * <code>int64 seq_id = 1;</code>
     * @param value The seqId to set.
     * @return This builder for chaining.
     */
    public Builder setSeqId(long value) {
      
      seqId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 seq_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSeqId() {
      
      seqId_ = 0L;
      onChanged();
      return this;
    }

    private boolean last_ ;
    /**
     * <pre>
     *Set to true when it is the last batch
     * </pre>
     *
     * <code>bool last = 2;</code>
     * @return The last.
     */
    public boolean getLast() {
      return last_;
    }
    /**
     * <pre>
     *Set to true when it is the last batch
     * </pre>
     *
     * <code>bool last = 2;</code>
     * @param value The last to set.
     * @return This builder for chaining.
     */
    public Builder setLast(boolean value) {
      
      last_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Set to true when it is the last batch
     * </pre>
     *
     * <code>bool last = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLast() {
      
      last_ = false;
      onChanged();
      return this;
    }

    private java.util.List<com.grpc.Measurement> current_ =
      java.util.Collections.emptyList();
    private void ensureCurrentIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        current_ = new java.util.ArrayList<com.grpc.Measurement>(current_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.grpc.Measurement, com.grpc.Measurement.Builder, com.grpc.MeasurementOrBuilder> currentBuilder_;

    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public java.util.List<com.grpc.Measurement> getCurrentList() {
      if (currentBuilder_ == null) {
        return java.util.Collections.unmodifiableList(current_);
      } else {
        return currentBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public int getCurrentCount() {
      if (currentBuilder_ == null) {
        return current_.size();
      } else {
        return currentBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public com.grpc.Measurement getCurrent(int index) {
      if (currentBuilder_ == null) {
        return current_.get(index);
      } else {
        return currentBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public Builder setCurrent(
        int index, com.grpc.Measurement value) {
      if (currentBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCurrentIsMutable();
        current_.set(index, value);
        onChanged();
      } else {
        currentBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public Builder setCurrent(
        int index, com.grpc.Measurement.Builder builderForValue) {
      if (currentBuilder_ == null) {
        ensureCurrentIsMutable();
        current_.set(index, builderForValue.build());
        onChanged();
      } else {
        currentBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public Builder addCurrent(com.grpc.Measurement value) {
      if (currentBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCurrentIsMutable();
        current_.add(value);
        onChanged();
      } else {
        currentBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public Builder addCurrent(
        int index, com.grpc.Measurement value) {
      if (currentBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCurrentIsMutable();
        current_.add(index, value);
        onChanged();
      } else {
        currentBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public Builder addCurrent(
        com.grpc.Measurement.Builder builderForValue) {
      if (currentBuilder_ == null) {
        ensureCurrentIsMutable();
        current_.add(builderForValue.build());
        onChanged();
      } else {
        currentBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public Builder addCurrent(
        int index, com.grpc.Measurement.Builder builderForValue) {
      if (currentBuilder_ == null) {
        ensureCurrentIsMutable();
        current_.add(index, builderForValue.build());
        onChanged();
      } else {
        currentBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public Builder addAllCurrent(
        java.lang.Iterable<? extends com.grpc.Measurement> values) {
      if (currentBuilder_ == null) {
        ensureCurrentIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, current_);
        onChanged();
      } else {
        currentBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public Builder clearCurrent() {
      if (currentBuilder_ == null) {
        current_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        currentBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public Builder removeCurrent(int index) {
      if (currentBuilder_ == null) {
        ensureCurrentIsMutable();
        current_.remove(index);
        onChanged();
      } else {
        currentBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public com.grpc.Measurement.Builder getCurrentBuilder(
        int index) {
      return getCurrentFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public com.grpc.MeasurementOrBuilder getCurrentOrBuilder(
        int index) {
      if (currentBuilder_ == null) {
        return current_.get(index);  } else {
        return currentBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public java.util.List<? extends com.grpc.MeasurementOrBuilder> 
         getCurrentOrBuilderList() {
      if (currentBuilder_ != null) {
        return currentBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(current_);
      }
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public com.grpc.Measurement.Builder addCurrentBuilder() {
      return getCurrentFieldBuilder().addBuilder(
          com.grpc.Measurement.getDefaultInstance());
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public com.grpc.Measurement.Builder addCurrentBuilder(
        int index) {
      return getCurrentFieldBuilder().addBuilder(
          index, com.grpc.Measurement.getDefaultInstance());
    }
    /**
     * <code>repeated .Challenger.Measurement current = 3;</code>
     */
    public java.util.List<com.grpc.Measurement.Builder> 
         getCurrentBuilderList() {
      return getCurrentFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.grpc.Measurement, com.grpc.Measurement.Builder, com.grpc.MeasurementOrBuilder> 
        getCurrentFieldBuilder() {
      if (currentBuilder_ == null) {
        currentBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.grpc.Measurement, com.grpc.Measurement.Builder, com.grpc.MeasurementOrBuilder>(
                current_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        current_ = null;
      }
      return currentBuilder_;
    }

    private java.util.List<com.grpc.Measurement> lastyear_ =
      java.util.Collections.emptyList();
    private void ensureLastyearIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        lastyear_ = new java.util.ArrayList<com.grpc.Measurement>(lastyear_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.grpc.Measurement, com.grpc.Measurement.Builder, com.grpc.MeasurementOrBuilder> lastyearBuilder_;

    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public java.util.List<com.grpc.Measurement> getLastyearList() {
      if (lastyearBuilder_ == null) {
        return java.util.Collections.unmodifiableList(lastyear_);
      } else {
        return lastyearBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public int getLastyearCount() {
      if (lastyearBuilder_ == null) {
        return lastyear_.size();
      } else {
        return lastyearBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public com.grpc.Measurement getLastyear(int index) {
      if (lastyearBuilder_ == null) {
        return lastyear_.get(index);
      } else {
        return lastyearBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public Builder setLastyear(
        int index, com.grpc.Measurement value) {
      if (lastyearBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLastyearIsMutable();
        lastyear_.set(index, value);
        onChanged();
      } else {
        lastyearBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public Builder setLastyear(
        int index, com.grpc.Measurement.Builder builderForValue) {
      if (lastyearBuilder_ == null) {
        ensureLastyearIsMutable();
        lastyear_.set(index, builderForValue.build());
        onChanged();
      } else {
        lastyearBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public Builder addLastyear(com.grpc.Measurement value) {
      if (lastyearBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLastyearIsMutable();
        lastyear_.add(value);
        onChanged();
      } else {
        lastyearBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public Builder addLastyear(
        int index, com.grpc.Measurement value) {
      if (lastyearBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLastyearIsMutable();
        lastyear_.add(index, value);
        onChanged();
      } else {
        lastyearBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public Builder addLastyear(
        com.grpc.Measurement.Builder builderForValue) {
      if (lastyearBuilder_ == null) {
        ensureLastyearIsMutable();
        lastyear_.add(builderForValue.build());
        onChanged();
      } else {
        lastyearBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public Builder addLastyear(
        int index, com.grpc.Measurement.Builder builderForValue) {
      if (lastyearBuilder_ == null) {
        ensureLastyearIsMutable();
        lastyear_.add(index, builderForValue.build());
        onChanged();
      } else {
        lastyearBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public Builder addAllLastyear(
        java.lang.Iterable<? extends com.grpc.Measurement> values) {
      if (lastyearBuilder_ == null) {
        ensureLastyearIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, lastyear_);
        onChanged();
      } else {
        lastyearBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public Builder clearLastyear() {
      if (lastyearBuilder_ == null) {
        lastyear_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        lastyearBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public Builder removeLastyear(int index) {
      if (lastyearBuilder_ == null) {
        ensureLastyearIsMutable();
        lastyear_.remove(index);
        onChanged();
      } else {
        lastyearBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public com.grpc.Measurement.Builder getLastyearBuilder(
        int index) {
      return getLastyearFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public com.grpc.MeasurementOrBuilder getLastyearOrBuilder(
        int index) {
      if (lastyearBuilder_ == null) {
        return lastyear_.get(index);  } else {
        return lastyearBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public java.util.List<? extends com.grpc.MeasurementOrBuilder> 
         getLastyearOrBuilderList() {
      if (lastyearBuilder_ != null) {
        return lastyearBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(lastyear_);
      }
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public com.grpc.Measurement.Builder addLastyearBuilder() {
      return getLastyearFieldBuilder().addBuilder(
          com.grpc.Measurement.getDefaultInstance());
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public com.grpc.Measurement.Builder addLastyearBuilder(
        int index) {
      return getLastyearFieldBuilder().addBuilder(
          index, com.grpc.Measurement.getDefaultInstance());
    }
    /**
     * <code>repeated .Challenger.Measurement lastyear = 4;</code>
     */
    public java.util.List<com.grpc.Measurement.Builder> 
         getLastyearBuilderList() {
      return getLastyearFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.grpc.Measurement, com.grpc.Measurement.Builder, com.grpc.MeasurementOrBuilder> 
        getLastyearFieldBuilder() {
      if (lastyearBuilder_ == null) {
        lastyearBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.grpc.Measurement, com.grpc.Measurement.Builder, com.grpc.MeasurementOrBuilder>(
                lastyear_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        lastyear_ = null;
      }
      return lastyearBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Challenger.Batch)
  }

  // @@protoc_insertion_point(class_scope:Challenger.Batch)
  private static final com.grpc.Batch DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.grpc.Batch();
  }

  public static com.grpc.Batch getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Batch>
      PARSER = new com.google.protobuf.AbstractParser<Batch>() {
    @java.lang.Override
    public Batch parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Batch(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Batch> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Batch> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.grpc.Batch getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
