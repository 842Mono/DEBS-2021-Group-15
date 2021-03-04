// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: challenger.proto

package de.tum.i13.bandency;

/**
 * Protobuf type {@code Challenger.Location}
 */
public  final class Location extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Challenger.Location)
    LocationOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Location.newBuilder() to construct.
  private Location(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Location() {
    zipcode_ = "";
    city_ = "";
    polygons_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Location();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Location(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            zipcode_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            city_ = s;
            break;
          }
          case 25: {

            qkm_ = input.readDouble();
            break;
          }
          case 32: {

            population_ = input.readInt32();
            break;
          }
          case 42: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              polygons_ = new java.util.ArrayList<de.tum.i13.bandency.Polygon>();
              mutable_bitField0_ |= 0x00000001;
            }
            polygons_.add(
                input.readMessage(de.tum.i13.bandency.Polygon.parser(), extensionRegistry));
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
        polygons_ = java.util.Collections.unmodifiableList(polygons_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return de.tum.i13.bandency.ChallengerProto.internal_static_Challenger_Location_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return de.tum.i13.bandency.ChallengerProto.internal_static_Challenger_Location_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            de.tum.i13.bandency.Location.class, de.tum.i13.bandency.Location.Builder.class);
  }

  public static final int ZIPCODE_FIELD_NUMBER = 1;
  private volatile java.lang.Object zipcode_;
  /**
   * <code>string zipcode = 1;</code>
   * @return The zipcode.
   */
  public java.lang.String getZipcode() {
    java.lang.Object ref = zipcode_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      zipcode_ = s;
      return s;
    }
  }
  /**
   * <code>string zipcode = 1;</code>
   * @return The bytes for zipcode.
   */
  public com.google.protobuf.ByteString
      getZipcodeBytes() {
    java.lang.Object ref = zipcode_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      zipcode_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CITY_FIELD_NUMBER = 2;
  private volatile java.lang.Object city_;
  /**
   * <code>string city = 2;</code>
   * @return The city.
   */
  public java.lang.String getCity() {
    java.lang.Object ref = city_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      city_ = s;
      return s;
    }
  }
  /**
   * <code>string city = 2;</code>
   * @return The bytes for city.
   */
  public com.google.protobuf.ByteString
      getCityBytes() {
    java.lang.Object ref = city_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      city_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int QKM_FIELD_NUMBER = 3;
  private double qkm_;
  /**
   * <code>double qkm = 3;</code>
   * @return The qkm.
   */
  public double getQkm() {
    return qkm_;
  }

  public static final int POPULATION_FIELD_NUMBER = 4;
  private int population_;
  /**
   * <code>int32 population = 4;</code>
   * @return The population.
   */
  public int getPopulation() {
    return population_;
  }

  public static final int POLYGONS_FIELD_NUMBER = 5;
  private java.util.List<de.tum.i13.bandency.Polygon> polygons_;
  /**
   * <code>repeated .Challenger.Polygon polygons = 5;</code>
   */
  public java.util.List<de.tum.i13.bandency.Polygon> getPolygonsList() {
    return polygons_;
  }
  /**
   * <code>repeated .Challenger.Polygon polygons = 5;</code>
   */
  public java.util.List<? extends de.tum.i13.bandency.PolygonOrBuilder> 
      getPolygonsOrBuilderList() {
    return polygons_;
  }
  /**
   * <code>repeated .Challenger.Polygon polygons = 5;</code>
   */
  public int getPolygonsCount() {
    return polygons_.size();
  }
  /**
   * <code>repeated .Challenger.Polygon polygons = 5;</code>
   */
  public de.tum.i13.bandency.Polygon getPolygons(int index) {
    return polygons_.get(index);
  }
  /**
   * <code>repeated .Challenger.Polygon polygons = 5;</code>
   */
  public de.tum.i13.bandency.PolygonOrBuilder getPolygonsOrBuilder(
      int index) {
    return polygons_.get(index);
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
    if (!getZipcodeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, zipcode_);
    }
    if (!getCityBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, city_);
    }
    if (qkm_ != 0D) {
      output.writeDouble(3, qkm_);
    }
    if (population_ != 0) {
      output.writeInt32(4, population_);
    }
    for (int i = 0; i < polygons_.size(); i++) {
      output.writeMessage(5, polygons_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getZipcodeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, zipcode_);
    }
    if (!getCityBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, city_);
    }
    if (qkm_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, qkm_);
    }
    if (population_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, population_);
    }
    for (int i = 0; i < polygons_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, polygons_.get(i));
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
    if (!(obj instanceof de.tum.i13.bandency.Location)) {
      return super.equals(obj);
    }
    de.tum.i13.bandency.Location other = (de.tum.i13.bandency.Location) obj;

    if (!getZipcode()
        .equals(other.getZipcode())) return false;
    if (!getCity()
        .equals(other.getCity())) return false;
    if (java.lang.Double.doubleToLongBits(getQkm())
        != java.lang.Double.doubleToLongBits(
            other.getQkm())) return false;
    if (getPopulation()
        != other.getPopulation()) return false;
    if (!getPolygonsList()
        .equals(other.getPolygonsList())) return false;
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
    hash = (37 * hash) + ZIPCODE_FIELD_NUMBER;
    hash = (53 * hash) + getZipcode().hashCode();
    hash = (37 * hash) + CITY_FIELD_NUMBER;
    hash = (53 * hash) + getCity().hashCode();
    hash = (37 * hash) + QKM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getQkm()));
    hash = (37 * hash) + POPULATION_FIELD_NUMBER;
    hash = (53 * hash) + getPopulation();
    if (getPolygonsCount() > 0) {
      hash = (37 * hash) + POLYGONS_FIELD_NUMBER;
      hash = (53 * hash) + getPolygonsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static de.tum.i13.bandency.Location parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.tum.i13.bandency.Location parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.tum.i13.bandency.Location parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.tum.i13.bandency.Location parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.tum.i13.bandency.Location parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.tum.i13.bandency.Location parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.tum.i13.bandency.Location parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static de.tum.i13.bandency.Location parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.tum.i13.bandency.Location parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static de.tum.i13.bandency.Location parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.tum.i13.bandency.Location parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static de.tum.i13.bandency.Location parseFrom(
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
  public static Builder newBuilder(de.tum.i13.bandency.Location prototype) {
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
   * Protobuf type {@code Challenger.Location}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Challenger.Location)
      de.tum.i13.bandency.LocationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.tum.i13.bandency.ChallengerProto.internal_static_Challenger_Location_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.tum.i13.bandency.ChallengerProto.internal_static_Challenger_Location_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.tum.i13.bandency.Location.class, de.tum.i13.bandency.Location.Builder.class);
    }

    // Construct using de.tum.i13.bandency.Location.newBuilder()
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
        getPolygonsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      zipcode_ = "";

      city_ = "";

      qkm_ = 0D;

      population_ = 0;

      if (polygonsBuilder_ == null) {
        polygons_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        polygonsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return de.tum.i13.bandency.ChallengerProto.internal_static_Challenger_Location_descriptor;
    }

    @java.lang.Override
    public de.tum.i13.bandency.Location getDefaultInstanceForType() {
      return de.tum.i13.bandency.Location.getDefaultInstance();
    }

    @java.lang.Override
    public de.tum.i13.bandency.Location build() {
      de.tum.i13.bandency.Location result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public de.tum.i13.bandency.Location buildPartial() {
      de.tum.i13.bandency.Location result = new de.tum.i13.bandency.Location(this);
      int from_bitField0_ = bitField0_;
      result.zipcode_ = zipcode_;
      result.city_ = city_;
      result.qkm_ = qkm_;
      result.population_ = population_;
      if (polygonsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          polygons_ = java.util.Collections.unmodifiableList(polygons_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.polygons_ = polygons_;
      } else {
        result.polygons_ = polygonsBuilder_.build();
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
      if (other instanceof de.tum.i13.bandency.Location) {
        return mergeFrom((de.tum.i13.bandency.Location)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(de.tum.i13.bandency.Location other) {
      if (other == de.tum.i13.bandency.Location.getDefaultInstance()) return this;
      if (!other.getZipcode().isEmpty()) {
        zipcode_ = other.zipcode_;
        onChanged();
      }
      if (!other.getCity().isEmpty()) {
        city_ = other.city_;
        onChanged();
      }
      if (other.getQkm() != 0D) {
        setQkm(other.getQkm());
      }
      if (other.getPopulation() != 0) {
        setPopulation(other.getPopulation());
      }
      if (polygonsBuilder_ == null) {
        if (!other.polygons_.isEmpty()) {
          if (polygons_.isEmpty()) {
            polygons_ = other.polygons_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePolygonsIsMutable();
            polygons_.addAll(other.polygons_);
          }
          onChanged();
        }
      } else {
        if (!other.polygons_.isEmpty()) {
          if (polygonsBuilder_.isEmpty()) {
            polygonsBuilder_.dispose();
            polygonsBuilder_ = null;
            polygons_ = other.polygons_;
            bitField0_ = (bitField0_ & ~0x00000001);
            polygonsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPolygonsFieldBuilder() : null;
          } else {
            polygonsBuilder_.addAllMessages(other.polygons_);
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
      de.tum.i13.bandency.Location parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (de.tum.i13.bandency.Location) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object zipcode_ = "";
    /**
     * <code>string zipcode = 1;</code>
     * @return The zipcode.
     */
    public java.lang.String getZipcode() {
      java.lang.Object ref = zipcode_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        zipcode_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string zipcode = 1;</code>
     * @return The bytes for zipcode.
     */
    public com.google.protobuf.ByteString
        getZipcodeBytes() {
      java.lang.Object ref = zipcode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        zipcode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string zipcode = 1;</code>
     * @param value The zipcode to set.
     * @return This builder for chaining.
     */
    public Builder setZipcode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      zipcode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string zipcode = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearZipcode() {
      
      zipcode_ = getDefaultInstance().getZipcode();
      onChanged();
      return this;
    }
    /**
     * <code>string zipcode = 1;</code>
     * @param value The bytes for zipcode to set.
     * @return This builder for chaining.
     */
    public Builder setZipcodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      zipcode_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object city_ = "";
    /**
     * <code>string city = 2;</code>
     * @return The city.
     */
    public java.lang.String getCity() {
      java.lang.Object ref = city_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        city_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string city = 2;</code>
     * @return The bytes for city.
     */
    public com.google.protobuf.ByteString
        getCityBytes() {
      java.lang.Object ref = city_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        city_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string city = 2;</code>
     * @param value The city to set.
     * @return This builder for chaining.
     */
    public Builder setCity(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      city_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string city = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCity() {
      
      city_ = getDefaultInstance().getCity();
      onChanged();
      return this;
    }
    /**
     * <code>string city = 2;</code>
     * @param value The bytes for city to set.
     * @return This builder for chaining.
     */
    public Builder setCityBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      city_ = value;
      onChanged();
      return this;
    }

    private double qkm_ ;
    /**
     * <code>double qkm = 3;</code>
     * @return The qkm.
     */
    public double getQkm() {
      return qkm_;
    }
    /**
     * <code>double qkm = 3;</code>
     * @param value The qkm to set.
     * @return This builder for chaining.
     */
    public Builder setQkm(double value) {
      
      qkm_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double qkm = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearQkm() {
      
      qkm_ = 0D;
      onChanged();
      return this;
    }

    private int population_ ;
    /**
     * <code>int32 population = 4;</code>
     * @return The population.
     */
    public int getPopulation() {
      return population_;
    }
    /**
     * <code>int32 population = 4;</code>
     * @param value The population to set.
     * @return This builder for chaining.
     */
    public Builder setPopulation(int value) {
      
      population_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 population = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPopulation() {
      
      population_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<de.tum.i13.bandency.Polygon> polygons_ =
      java.util.Collections.emptyList();
    private void ensurePolygonsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        polygons_ = new java.util.ArrayList<de.tum.i13.bandency.Polygon>(polygons_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        de.tum.i13.bandency.Polygon, de.tum.i13.bandency.Polygon.Builder, de.tum.i13.bandency.PolygonOrBuilder> polygonsBuilder_;

    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public java.util.List<de.tum.i13.bandency.Polygon> getPolygonsList() {
      if (polygonsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(polygons_);
      } else {
        return polygonsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public int getPolygonsCount() {
      if (polygonsBuilder_ == null) {
        return polygons_.size();
      } else {
        return polygonsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public de.tum.i13.bandency.Polygon getPolygons(int index) {
      if (polygonsBuilder_ == null) {
        return polygons_.get(index);
      } else {
        return polygonsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public Builder setPolygons(
        int index, de.tum.i13.bandency.Polygon value) {
      if (polygonsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePolygonsIsMutable();
        polygons_.set(index, value);
        onChanged();
      } else {
        polygonsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public Builder setPolygons(
        int index, de.tum.i13.bandency.Polygon.Builder builderForValue) {
      if (polygonsBuilder_ == null) {
        ensurePolygonsIsMutable();
        polygons_.set(index, builderForValue.build());
        onChanged();
      } else {
        polygonsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public Builder addPolygons(de.tum.i13.bandency.Polygon value) {
      if (polygonsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePolygonsIsMutable();
        polygons_.add(value);
        onChanged();
      } else {
        polygonsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public Builder addPolygons(
        int index, de.tum.i13.bandency.Polygon value) {
      if (polygonsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePolygonsIsMutable();
        polygons_.add(index, value);
        onChanged();
      } else {
        polygonsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public Builder addPolygons(
        de.tum.i13.bandency.Polygon.Builder builderForValue) {
      if (polygonsBuilder_ == null) {
        ensurePolygonsIsMutable();
        polygons_.add(builderForValue.build());
        onChanged();
      } else {
        polygonsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public Builder addPolygons(
        int index, de.tum.i13.bandency.Polygon.Builder builderForValue) {
      if (polygonsBuilder_ == null) {
        ensurePolygonsIsMutable();
        polygons_.add(index, builderForValue.build());
        onChanged();
      } else {
        polygonsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public Builder addAllPolygons(
        java.lang.Iterable<? extends de.tum.i13.bandency.Polygon> values) {
      if (polygonsBuilder_ == null) {
        ensurePolygonsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, polygons_);
        onChanged();
      } else {
        polygonsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public Builder clearPolygons() {
      if (polygonsBuilder_ == null) {
        polygons_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        polygonsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public Builder removePolygons(int index) {
      if (polygonsBuilder_ == null) {
        ensurePolygonsIsMutable();
        polygons_.remove(index);
        onChanged();
      } else {
        polygonsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public de.tum.i13.bandency.Polygon.Builder getPolygonsBuilder(
        int index) {
      return getPolygonsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public de.tum.i13.bandency.PolygonOrBuilder getPolygonsOrBuilder(
        int index) {
      if (polygonsBuilder_ == null) {
        return polygons_.get(index);  } else {
        return polygonsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public java.util.List<? extends de.tum.i13.bandency.PolygonOrBuilder> 
         getPolygonsOrBuilderList() {
      if (polygonsBuilder_ != null) {
        return polygonsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(polygons_);
      }
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public de.tum.i13.bandency.Polygon.Builder addPolygonsBuilder() {
      return getPolygonsFieldBuilder().addBuilder(
          de.tum.i13.bandency.Polygon.getDefaultInstance());
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public de.tum.i13.bandency.Polygon.Builder addPolygonsBuilder(
        int index) {
      return getPolygonsFieldBuilder().addBuilder(
          index, de.tum.i13.bandency.Polygon.getDefaultInstance());
    }
    /**
     * <code>repeated .Challenger.Polygon polygons = 5;</code>
     */
    public java.util.List<de.tum.i13.bandency.Polygon.Builder> 
         getPolygonsBuilderList() {
      return getPolygonsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        de.tum.i13.bandency.Polygon, de.tum.i13.bandency.Polygon.Builder, de.tum.i13.bandency.PolygonOrBuilder> 
        getPolygonsFieldBuilder() {
      if (polygonsBuilder_ == null) {
        polygonsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            de.tum.i13.bandency.Polygon, de.tum.i13.bandency.Polygon.Builder, de.tum.i13.bandency.PolygonOrBuilder>(
                polygons_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        polygons_ = null;
      }
      return polygonsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Challenger.Location)
  }

  // @@protoc_insertion_point(class_scope:Challenger.Location)
  private static final de.tum.i13.bandency.Location DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new de.tum.i13.bandency.Location();
  }

  public static de.tum.i13.bandency.Location getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Location>
      PARSER = new com.google.protobuf.AbstractParser<Location>() {
    @java.lang.Override
    public Location parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Location(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Location> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Location> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public de.tum.i13.bandency.Location getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

