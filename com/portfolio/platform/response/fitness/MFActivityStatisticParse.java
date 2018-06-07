package com.portfolio.platform.response.fitness;

public class MFActivityStatisticParse {
    private double averageActivitySteps;
    private double bestDay;
    private double bestWeek;
    private String owner;
    private long totalActivities;
    private double totalCalories;
    private int totalDays;
    private double totalDistance;
    private int[] totalIntensityDistInStep;
    private double totalSteps;

    public String getOwner() {
        return this.owner;
    }

    public double getTotalDistance() {
        return this.totalDistance;
    }

    public double getTotalCalories() {
        return this.totalCalories;
    }

    public double getTotalSteps() {
        return this.totalSteps;
    }

    public long getTotalActivities() {
        return this.totalActivities;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public int[] getTotalIntensityDistInStep() {
        return this.totalIntensityDistInStep;
    }

    public double getBestDay() {
        return this.bestDay;
    }

    public double getBestWeek() {
        return this.bestWeek;
    }

    public double getAverageActivitySteps() {
        return this.averageActivitySteps;
    }
}
