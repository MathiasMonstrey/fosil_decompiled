package com.portfolio.platform.response.sleep;

public class MFSleepStatisticParse {
    private double averageSleepMinutes;
    private int bestDay;
    private int bestWeek;
    private String owner;
    private int totalDays;
    private int totalSleepMinutes;
    private int[] totalSleepStateDistInMinute;
    private int totalSleeps;

    public String getOwner() {
        return this.owner;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public int getTotalSleeps() {
        return this.totalSleeps;
    }

    public int getTotalSleepMinutes() {
        return this.totalSleepMinutes;
    }

    public int[] getTotalSleepStateDistInMinute() {
        return this.totalSleepStateDistInMinute;
    }

    public double getAverageSleepMinutes() {
        return this.averageSleepMinutes;
    }

    public int getBestDay() {
        return this.bestDay;
    }

    public int getBestWeek() {
        return this.bestWeek;
    }
}
