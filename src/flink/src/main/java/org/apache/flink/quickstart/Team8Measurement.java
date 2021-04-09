package org.apache.flink.quickstart;

import com.grpc.Measurement;

public class Team8Measurement {

    String city;
    Measurement measurement;
    String year; //too lazy to Enum it. Can either be "ThisYear" or "LastYear".

    public Team8Measurement(Measurement measurement, String year) {
        this.measurement = measurement;
        this.year = year;
    }

    public String toString()
    {
        return city;

        //TODO: print everything.
    }
}
