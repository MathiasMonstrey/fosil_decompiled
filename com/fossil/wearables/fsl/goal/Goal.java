package com.fossil.wearables.fsl.goal;

import android.text.TextUtils;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Goal extends BaseFeatureModel {
    @DatabaseField
    private String description;
    @DatabaseField
    private long endDate;
    @DatabaseField
    private long intervalDuration;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<GoalInterval> intervals;
    @DatabaseField
    private double latitude;
    @DatabaseField
    private double longitude;
    @DatabaseField
    private int reminderHour;
    @DatabaseField
    private int reminderMinute;
    @DatabaseField
    private long startDate;
    @DatabaseField
    private int targetValue;
    @DatabaseField
    private String type;

    public List<GoalInterval> getIntervals() {
        List<GoalInterval> arrayList = new ArrayList();
        if (this.intervals == null || this.intervals.size() <= 0) {
            return arrayList;
        }
        return new ArrayList(this.intervals);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
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

    public long getIntervalDuration() {
        return this.intervalDuration;
    }

    public void setIntervalDuration(long j) {
        this.intervalDuration = j;
    }

    public int getReminderHour() {
        return this.reminderHour;
    }

    public void setReminderHour(int i) {
        this.reminderHour = i;
    }

    public int getReminderMinute() {
        return this.reminderMinute;
    }

    public void setReminderMinute(int i) {
        this.reminderMinute = i;
    }

    public GoalType getType() {
        if (TextUtils.isEmpty(this.type)) {
            return null;
        }
        return GoalType.valueOf(this.type);
    }

    public void setType(GoalType goalType) {
        this.type = goalType.name();
    }

    public int getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(int i) {
        this.targetValue = i;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setTotalDuration(long j) {
        this.endDate = this.startDate + j;
    }

    public long getTotalDuration() {
        return this.endDate - this.startDate;
    }

    public long getIntervalCount() {
        if (this.intervalDuration != 0) {
            return getTotalDuration() / this.intervalDuration;
        }
        return 0;
    }

    public int getIntervalIndex(long j) {
        return (int) (Math.floor((double) (getTotalDuration() / (j - this.startDate))) - 1.0d);
    }

    public GoalInterval getInterval(int i) {
        GoalInterval goalInterval = new GoalInterval();
        goalInterval.setGoal(this);
        goalInterval.setIndex(i);
        if (this.intervals != null && this.intervals.size() > 0) {
            for (GoalInterval goalInterval2 : this.intervals) {
                if (goalInterval2.getIndex() == i) {
                    return goalInterval2;
                }
            }
        }
        return goalInterval;
    }

    private long getTotalTargetValue() {
        return ((long) this.targetValue) * getIntervalCount();
    }

    private long getTotalIntervalValue() {
        if (this.intervals == null || this.intervals.size() <= 0) {
            return 0;
        }
        long j = 0;
        for (GoalInterval value : this.intervals) {
            j = ((long) value.getValue()) + j;
        }
        return j;
    }

    public double getProgress() {
        return ((double) getTotalIntervalValue()) / ((double) getTotalTargetValue());
    }

    public boolean meetMyGoal() {
        if (Math.round(getProgress() * 100.0d) == 100) {
            return true;
        }
        return false;
    }

    public void printDebugInfo() {
        Log.i(this.TAG, "Goal name: " + getName() + "\n Total Duration (in days): " + TimeUnit.MILLISECONDS.toDays(getTotalDuration()) + "\n Interval Duration (in days): " + TimeUnit.MILLISECONDS.toDays(getIntervalDuration()) + "\n Interval Count: " + getIntervalCount() + "\n Target Value: " + getTargetValue() + "\n Total Target Value (interval count * target value): " + getTotalTargetValue() + "\n Total Interval Value (all interval values added up): " + getTotalIntervalValue() + "\n Overall Goal Progress: " + getProgress());
    }
}
