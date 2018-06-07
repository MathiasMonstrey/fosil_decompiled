package com.jawbone.upplatformsdk.endpointModels.move;

import com.fossil.cga;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class HourlyEvent {
    @cga("calories")
    Float calories;
    @cga("distance")
    Integer distance;
    @cga("inactive_time")
    Integer inactiveTime;
    @cga("longest_active_time")
    Integer longestActiveTime;
    @cga("longest_idle_time")
    Integer longestIdleTime;
    @cga("steps")
    Integer steps;

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(Integer num) {
        this.distance = num;
    }

    public Float getCalories() {
        return this.calories;
    }

    public void setCalories(Float f) {
        this.calories = f;
    }

    public Integer getSteps() {
        return this.steps;
    }

    public void setSteps(Integer num) {
        this.steps = num;
    }

    public Integer getInactiveTime() {
        return this.inactiveTime;
    }

    public void setInactiveTime(Integer num) {
        this.inactiveTime = num;
    }

    public Integer getLongestActiveTime() {
        return this.longestActiveTime;
    }

    public void setLongestActiveTime(Integer num) {
        this.longestActiveTime = num;
    }

    public Integer getLongestIdleTime() {
        return this.longestIdleTime;
    }

    public void setLongestIdleTime(Integer num) {
        this.longestIdleTime = num;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
