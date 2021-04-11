package org.apache.flink.quickstart;

import java.util.HashMap;
import java.util.Map;

public class SnapshotDictionary {
    Map<String, FiveMinuteSnapshot> dict;
    long timestamp;

    public SnapshotDictionary(long timestamp)
    {
        this.timestamp = timestamp;
        this.dict = new HashMap<String, FiveMinuteSnapshot>();
    }

    public String toString()
    {
        return "Timestamp = " + timestamp + "\nNumber of elements in dictionary = " + dict.size() + "\n";
    }
}
