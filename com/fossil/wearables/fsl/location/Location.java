package com.fossil.wearables.fsl.location;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;

public class Location extends BaseModel {
    @DatabaseField
    private String address;
    @DatabaseField
    private String city;
    @DatabaseField(columnName = "location_group_id", foreign = true, foreignAutoRefresh = true)
    private LocationGroup group;
    @DatabaseField
    private double latitude;
    @DatabaseField
    private double longitude;
    @DatabaseField
    private String name;
    @DatabaseField
    private String note;
    @DatabaseField
    private String state;
    @DatabaseField
    private long timestamp;
    @DatabaseField
    private boolean verified;
    @DatabaseField
    private String zip;

    public String getNote() {
        return this.note;
    }

    public void setNote(String str) {
        this.note = str;
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

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String str) {
        this.zip = str;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public LocationGroup getGroup() {
        return this.group;
    }

    public void setGroup(LocationGroup locationGroup) {
        this.group = locationGroup;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setVerified(boolean z) {
        this.verified = z;
    }
}
