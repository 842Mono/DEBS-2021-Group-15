// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: challenger.proto

package com.grpc;

public interface PolygonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Challenger.Polygon)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Challenger.Point points = 1;</code>
   */
  java.util.List<com.grpc.Point> 
      getPointsList();
  /**
   * <code>repeated .Challenger.Point points = 1;</code>
   */
  com.grpc.Point getPoints(int index);
  /**
   * <code>repeated .Challenger.Point points = 1;</code>
   */
  int getPointsCount();
  /**
   * <code>repeated .Challenger.Point points = 1;</code>
   */
  java.util.List<? extends com.grpc.PointOrBuilder> 
      getPointsOrBuilderList();
  /**
   * <code>repeated .Challenger.Point points = 1;</code>
   */
  com.grpc.PointOrBuilder getPointsOrBuilder(
      int index);
}
