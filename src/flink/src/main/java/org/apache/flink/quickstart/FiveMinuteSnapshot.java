package org.apache.flink.quickstart;

public class FiveMinuteSnapshot {

    int averageAQIp1 = -1;
    int averageAQIp2 = -1;

    public FiveMinuteSnapshot(int aaqi1, int aaqi2)
    {
        this.averageAQIp1 = aaqi1;
        this.averageAQIp2 = aaqi2;
    }

    public String toString()
    {
        return averageAQIp1 + " " + averageAQIp2;
    }
}
