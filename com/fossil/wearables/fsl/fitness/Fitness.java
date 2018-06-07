package com.fossil.wearables.fsl.fitness;

import java.util.List;

public class Fitness {

    public static class Values {
        public double calories = 0.0d;
        public double distance = 0.0d;
        public double steps = 0.0d;
    }

    public static final Values addSamples(List<SampleDay> list) {
        Values values = new Values();
        for (SampleDay sampleDay : list) {
            values.steps += sampleDay.getSteps();
            values.calories += sampleDay.getCalories();
            values.distance += sampleDay.getDistance();
        }
        return values;
    }
}
