package com.portfolio.platform.data.model;

import java.io.Serializable;
import java.util.Date;
import org.joda.time.DateTime;

public class FitnessDayData implements Serializable {
    private Date createdAt;
    private DateTime date;
    private int goalSteps;
    private String owner;
    private int totalActivities;
    private double totalCalories;
    private double totalDistance;
    private int[] totalIntensityDistInStep;
    private double totalSteps;
    private Date updatedAt;

    public double getTotalCalories() {
        return this.totalCalories;
    }

    public double getTotalSteps() {
        return this.totalSteps;
    }

    public double getTotalDistance() {
        return this.totalDistance;
    }

    public int getTotalActivities() {
        return this.totalActivities;
    }

    public DateTime getDate() {
        return this.date;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getGoalSteps() {
        return this.goalSteps;
    }

    public int[] getTotalIntensityDistInStep() {
        return this.totalIntensityDistInStep;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }
}
