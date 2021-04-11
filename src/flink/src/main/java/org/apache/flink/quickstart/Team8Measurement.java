package org.apache.flink.quickstart;

import com.grpc.Measurement;

public class Team8Measurement {

    String city = "";
    Measurement measurement;
    String year; //too lazy to Enum it. Can either be "ThisYear" or "LastYear".
    int aqi = -1;
    boolean isLastMeasurementInBatch = false;

    public Team8Measurement(Measurement measurement, String year, boolean isLastMeasurementInBatch) {
        this.measurement = measurement;
        this.year = year;
        this.isLastMeasurementInBatch = isLastMeasurementInBatch;
    }

    public String toString()
    {
        return city + "\nAQI = " + this.aqi;

        //TODO: print everything.
    }
}
