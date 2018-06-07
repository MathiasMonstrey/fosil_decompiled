package com.fossil.wearables.fsl.goaltracking;

import com.j256.ormlite.field.DatabaseField;

public class GoalPhase {
    public static final String COLUMN_END_DATE = "endDate";
    public static final String COLUMN_END_DAY = "endDay";
    public static final String COLUMN_GOAL_ID = "goalId";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_START_DATE = "startDate";
    public static final String COLUMN_START_DAY = "startDay";
    @DatabaseField(columnName = "endDate")
    protected long endDate;
    @DatabaseField(columnName = "endDay")
    protected String endDay;
    @DatabaseField(columnName = "goalId", foreign = true, foreignAutoRefresh = true)
    protected GoalTracking goal;
    @DatabaseField(columnName = "id", generatedId = true)
    protected long id;
    @DatabaseField(columnName = "startDate")
    protected long startDate;
    @DatabaseField(columnName = "startDay")
    protected String startDay;

    public GoalPhase(long j, long j2, String str, String str2, GoalTracking goalTracking) {
        this.startDate = j;
        this.endDate = j2;
        this.startDay = str;
        this.endDay = str2;
        this.goal = goalTracking;
    }

    public GoalTracking getGoalTracking() {
        return this.goal;
    }

    public void setGoalTracking(GoalTracking goalTracking) {
        this.goal = goalTracking;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public void setStartDate(long j) {
        this.startDate = j;
    }

    public long getEndDate() {
        return this.endDate;
    }

    public void setEndDate(long j) {
        this.endDate = j;
    }

    public String getStartDay() {
        return this.startDay;
    }

    public void setStartDay(String str) {
        this.startDay = str;
    }

    public String getEndDay() {
        return this.endDay;
    }

    public void setEndDay(String str) {
        this.endDay = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }
}
