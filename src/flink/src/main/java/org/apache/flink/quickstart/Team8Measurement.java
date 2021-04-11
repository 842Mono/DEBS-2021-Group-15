package org.apache.flink.quickstart;

import com.grpc.Measurement;
import java.io.Serializable;

public class Team8Measurement implements Comparable<Team8Measurement>, Serializable {

    String city = "";
    Measurement measurement;
    String year; //too lazy to Enum it. Can either be "ThisYear" or "LastYear".
    int aqi = -1;
    boolean isLastMeasurementInBatch = false;
    boolean isGood = false;
    long timestamp;

    public Team8Measurement(Measurement measurement, String year, boolean isLastMeasurementInBatch) {
        this.measurement = measurement;
        this.year = year;
        this.isLastMeasurementInBatch = isLastMeasurementInBatch;
        this.timestamp = measurement.getTimestamp().getSeconds();
    }

    @Override
    public int compareTo(Team8Measurement other) {
        if (other == null) {
            return 1;
        }
        return Long.compare(this.timestamp, other.timestamp);
    }
    
    public String toString()
    {
        return city + "\nAQI = " + this.aqi;

        //TODO: print everything.
    }
}
