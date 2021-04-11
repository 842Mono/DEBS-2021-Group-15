package org.apache.flink.quickstart;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.*;
import org.apache.flink.util.Collector;
import org.apache.flink.api.common.typeinfo.*;


public class GoodAQIStreaks extends RichFlatMapFunction<Team8Measurement, Tuple2<String, Long>> {

    /**
     * The ValueState handle. The first field is the count, the second field a running sum.
     */
    private transient ValueState<Tuple2<Long, Long>> streak;

    @Override
    public void flatMap(Team8Measurement input, Collector<Tuple2<String, Long>> out) throws Exception {

        // access the state value
        Tuple2<Long, Long> currentStreak = streak.value();

        if (input.isGood) {
            if (currentStreak.f0 == 0) {
                currentStreak.f0 = input.timestamp;
            } 
            currentStreak.f1 = input.timestamp - currentStreak.f0;

        } else {
            if (currentStreak.f1 != 0) {
                out.collect(new Tuple2<>(input.city, currentStreak.f1));
                // streak.clear();
            }
            currentStreak.f0 = 0L;
            currentStreak.f1 = 0L;
        }

       
        // update the state
        streak.update(currentStreak);
      
           
        
    }

    @Override
    public void open(Configuration config) {
        ValueStateDescriptor<Tuple2<Long, Long>> descriptor =
                new ValueStateDescriptor<>(
                        "streaks", // the state name
                        TypeInformation.of(new TypeHint<Tuple2<Long, Long>>() {}), // type information
                        Tuple2.of(0L, 0L)); // default value of the state, if nothing was set
        streak = getRuntimeContext().getState(descriptor);
    }
}
