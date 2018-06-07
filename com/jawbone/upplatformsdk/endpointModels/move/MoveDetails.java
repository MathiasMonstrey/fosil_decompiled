package com.jawbone.upplatformsdk.endpointModels.move;

import com.fossil.cga;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;
import java.util.Map;

public class MoveDetails {
    @cga("bg_calories")
    Float bgCalories;
    @cga("bmr_day")
    Float bmrDay;
    @cga("calories")
    Float calories;
    @cga("distance")
    Integer distance;
    @cga("hourly_totals")
    Map<String, HourlyEvent> hourlyTotals;
    @cga("inactive_time")
    Integer inactiveTime;
    @cga("km")
    String km;
    @cga("longest_active")
    Integer longestActive;
    @cga("longest_idle")
    Integer longestIdle;
    @cga("steps")
    Integer steps;
    @cga("sunrise")
    Long sunrise;
    @cga("sunset")
    Long sunset;
    @cga("tz")
    String timeZone;
    @cga("tzs")
    Map<Integer, String> tzs;
    @cga("wo_active_time")
    Integer woActiveTime;
    @cga("wo_calories")
    Float woCalories;
    @cga("wo_count")
    Integer woCount;
    @cga("wo_longest")
    Integer woLongest;
    @cga("wo_time")
    Integer woTime;

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(Integer num) {
        this.distance = num;
    }

    public String getKm() {
        return this.km;
    }

    public void setKm(String str) {
        this.km = str;
    }

    public Integer getSteps() {
        return this.steps;
    }

    public void setSteps(Integer num) {
        this.steps = num;
    }

    public Integer getLongestActive() {
        return this.longestActive;
    }

    public void setLongestActive(Integer num) {
        this.longestActive = num;
    }

    public Integer getInactiveTime() {
        return this.inactiveTime;
    }

    public void setInactiveTime(Integer num) {
        this.inactiveTime = num;
    }

    public Integer getLongestIdle() {
        return this.longestIdle;
    }

    public void setLongestIdle(Integer num) {
        this.longestIdle = num;
    }

    public Float getCalories() {
        return this.calories;
    }

    public void setCalories(Float f) {
        this.calories = f;
    }

    public Float getBmrDay() {
        return this.bmrDay;
    }

    public void setBmrDay(Float f) {
        this.bmrDay = f;
    }

    public Float getBgCalories() {
        return this.bgCalories;
    }

    public void setBgCalories(Float f) {
        this.bgCalories = f;
    }

    public Float getWoCalories() {
        return this.woCalories;
    }

    public void setWoCalories(Float f) {
        this.woCalories = f;
    }

    public Integer getWoTime() {
        return this.woTime;
    }

    public void setWoTime(Integer num) {
        this.woTime = num;
    }

    public Integer getWoActiveTime() {
        return this.woActiveTime;
    }

    public void setWoActiveTime(Integer num) {
        this.woActiveTime = num;
    }

    public Integer getWoCount() {
        return this.woCount;
    }

    public void setWoCount(Integer num) {
        this.woCount = num;
    }

    public Integer getWoLongest() {
        return this.woLongest;
    }

    public void setWoLongest(Integer num) {
        this.woLongest = num;
    }

    public Long getSunrise() {
        return this.sunrise;
    }

    public void setSunrise(Long l) {
        this.sunrise = l;
    }

    public Long getSunset() {
        return this.sunset;
    }

    public void setSunset(Long l) {
        this.sunset = l;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public Map<Integer, String> getTzs() {
        return this.tzs;
    }

    public void setTzs(Map<Integer, String> map) {
        this.tzs = map;
    }

    public Map<String, HourlyEvent> getHourlyTotals() {
        return this.hourlyTotals;
    }

    public void setHourlyTotals(Map<String, HourlyEvent> map) {
        this.hourlyTotals = map;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
