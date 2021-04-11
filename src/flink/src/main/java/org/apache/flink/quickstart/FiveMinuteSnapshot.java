package org.apache.flink.quickstart;

public class FiveMinuteSnapshot {

    double sumAQIp1ThisYear = 0;
    double sumAQIp2ThisYear = 0;
    int countForAverageThisYear = 0;

    double sumAQIp1LastYear = 0;
    double sumAQIp2LastYear = 0;
    int countForAverageLastYear = 0;
//    String city = "";
//    long timestamp;

    public FiveMinuteSnapshot()//(String city) //(double aaqi1, double aaqi2, String city) //, long timestamp)
    {
//        this.averageAQIp1 = aaqi1;
//        this.averageAQIp2 = aaqi2;
//        this.city = city;
//        this.timestamp = timestamp;
    }

    public double getAverageAQIp1ThisYear()
    {
        return sumAQIp1ThisYear / countForAverageThisYear;
    }

    public double getAverageAQIp2ThisYear()
    {
        return sumAQIp2ThisYear / countForAverageThisYear;
    }

    public double getAverageAQIp1LastYear()
    {
        return sumAQIp1LastYear / countForAverageLastYear;
    }

    public double getAverageAQIp2LastYear()
    {
        return sumAQIp2LastYear / countForAverageLastYear;
    }

    public String toString() {
        return "This year: " + this.getAverageAQIp1ThisYear() + " " + this.getAverageAQIp2ThisYear()
                + "\nLast year : " + this.getAverageAQIp1LastYear() + " " +  this.getAverageAQIp2LastYear();
    }
}
