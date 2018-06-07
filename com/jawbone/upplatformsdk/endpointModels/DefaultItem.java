package com.jawbone.upplatformsdk.endpointModels;

import com.fossil.cga;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class DefaultItem {
    @cga("date")
    protected Integer date;
    @cga("time_completed")
    protected Long timeCompleted;
    @cga("time_created")
    protected Long timeCreated;
    @cga("title")
    protected String title;
    @cga("type")
    protected String type;
    @cga("xid")
    protected String xid;

    public String getXid() {
        return this.xid;
    }

    public void setXid(String str) {
        this.xid = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Long getTimeCreated() {
        return this.timeCreated;
    }

    public void setTimeCreated(Long l) {
        this.timeCreated = l;
    }

    public Long getTimeCompleted() {
        return this.timeCompleted;
    }

    public void setTimeCompleted(Long l) {
        this.timeCompleted = l;
    }

    public Integer getDate() {
        return this.date;
    }

    public void setDate(Integer num) {
        this.date = num;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
