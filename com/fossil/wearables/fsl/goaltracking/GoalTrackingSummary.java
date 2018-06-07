package com.fossil.wearables.fsl.goaltracking;

import com.j256.ormlite.field.DatabaseField;

public class GoalTrackingSummary {
    public static final String COLUMN_AVERAGE = "average";
    public static final String COLUMN_BEST_STREAK = "bestStreak";
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_GOALS_MET = "goalsMet";
    public static final String COLUMN_GOAL_ID = "goalId";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TOTAL_DURATION = "totalDuration";
    public static final String COLUMN_UPDATED_AT = "updatedAt";
    @DatabaseField(columnName = "average")
    protected double average;
    @DatabaseField(columnName = "bestStreak")
    protected int bestStreak;
    @DatabaseField(columnName = "createdAt")
    protected long createdAt;
    @DatabaseField(columnName = "date")
    protected long date;
    @DatabaseField(columnName = "goalId", foreign = true, foreignAutoRefresh = true)
    protected GoalTracking goalTracking;
    @DatabaseField(columnName = "goalsMet")
    protected int goalsMet;
    @DatabaseField(columnName = "id", generatedId = true)
    protected long id;
    @DatabaseField(columnName = "totalDuration")
    protected int totalDuration;
    @DatabaseField(columnName = "updatedAt")
    protected long updatedAt;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public GoalTracking getGoalTracking() {
        return this.goalTracking;
    }

    public void setGoalTracking(GoalTracking goalTracking) {
        this.goalTracking = goalTracking;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public int getGoalsMet() {
        return this.goalsMet;
    }

    public void setGoalsMet(int i) {
        this.goalsMet = i;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public void setTotalDuration(int i) {
        this.totalDuration = i;
    }

    public double getAverage() {
        return this.average;
    }

    public void setAverage(double d) {
        this.average = d;
    }

    public int getBestStreak() {
        return this.bestStreak;
    }

    public void setBestStreak(int i) {
        this.bestStreak = i;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }
}
