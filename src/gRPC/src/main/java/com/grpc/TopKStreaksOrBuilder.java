// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: challenger.proto

package com.grpc;

public interface TopKStreaksOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Challenger.TopKStreaks)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *begin of the bucket
   * </pre>
   *
   * <code>int32 bucket_from = 1;</code>
   * @return The bucketFrom.
   */
  int getBucketFrom();

  /**
   * <pre>
   *end of the bucket
   * </pre>
   *
   * <code>int32 bucket_to = 2;</code>
   * @return The bucketTo.
   */
  int getBucketTo();

  /**
   * <pre>
   *round(float, 3) * 1000 as integer
   * </pre>
   *
   * <code>int32 bucket_percent = 3;</code>
   * @return The bucketPercent.
   */
  int getBucketPercent();
}