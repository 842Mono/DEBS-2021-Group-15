// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: challenger.proto

package de.tum.i13.bandency;

public interface ResultQ2OrBuilder extends
    // @@protoc_insertion_point(interface_extends:Challenger.ResultQ2)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 benchmark_id = 1;</code>
   * @return The benchmarkId.
   */
  long getBenchmarkId();

  /**
   * <code>int64 batch_seq_id = 2;</code>
   * @return The batchSeqId.
   */
  long getBatchSeqId();

  /**
   * <code>repeated .Challenger.TopKStreaks histogram = 3;</code>
   */
  java.util.List<de.tum.i13.bandency.TopKStreaks> 
      getHistogramList();
  /**
   * <code>repeated .Challenger.TopKStreaks histogram = 3;</code>
   */
  de.tum.i13.bandency.TopKStreaks getHistogram(int index);
  /**
   * <code>repeated .Challenger.TopKStreaks histogram = 3;</code>
   */
  int getHistogramCount();
  /**
   * <code>repeated .Challenger.TopKStreaks histogram = 3;</code>
   */
  java.util.List<? extends de.tum.i13.bandency.TopKStreaksOrBuilder> 
      getHistogramOrBuilderList();
  /**
   * <code>repeated .Challenger.TopKStreaks histogram = 3;</code>
   */
  de.tum.i13.bandency.TopKStreaksOrBuilder getHistogramOrBuilder(
      int index);
}
