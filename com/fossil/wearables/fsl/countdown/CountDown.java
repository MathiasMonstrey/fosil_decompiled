package com.fossil.wearables.fsl.countdown;

import com.j256.ormlite.field.DatabaseField;
import java.util.Date;

public class CountDown {
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_DEVICE_MODEL = "deviceModel";
    public static final String COLUMN_ENDED_AT = "endedAt";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_SERIAL = "serial";
    public static final String COLUMN_SERVER_ID = "serverId";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_UPDATED_AT = "updatedAt";
    public static final String COLUMN_URI = "uri";
    @DatabaseField(columnName = "createdAt")
    protected long createdAt;
    @DatabaseField(columnName = "deviceModel")
    protected String deviceModel;
    @DatabaseField(columnName = "endedAt")
    protected long endedAt;
    @DatabaseField(columnName = "id", generatedId = true)
    protected long id;
    @DatabaseField(columnName = "name")
    protected String name;
    @DatabaseField(columnName = "note")
    protected String note;
    @DatabaseField(columnName = "serial")
    protected String serial;
    @DatabaseField(columnName = "serverId")
    protected String serverId;
    @DatabaseField(columnName = "status")
    protected int status;
    @DatabaseField(columnName = "type")
    protected int type;
    @DatabaseField(columnName = "updatedAt")
    protected long updatedAt;
    @DatabaseField(columnName = "uri")
    protected String uri;

    public CountDown(String str, CountDownType countDownType, String str2, String str3, long j, CountDownStatus countDownStatus, String str4) {
        this.name = str;
        this.endedAt = j;
        this.createdAt = System.currentTimeMillis();
        this.status = countDownStatus.getValue();
        this.note = str4;
        this.type = countDownType.getValue();
        this.serial = str2;
        this.deviceModel = str3;
        this.uri = CountDownUri.generateURI(this).toASCIIString();
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getUri() {
        return this.uri;
    }

    public CountDownStatus getStatus() {
        return CountDownStatus.fromInt(this.status);
    }

    public void setStatus(CountDownStatus countDownStatus) {
        this.status = countDownStatus.getValue();
    }

    public String getServerId() {
        return this.serverId;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public long getEndedAt() {
        return this.endedAt;
    }

    public void setEndedAt(long j) {
        this.endedAt = j;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setSerial(String str) {
        this.serial = str;
    }

    public String getSerial() {
        return this.serial;
    }

    public CountDownType getType() {
        return CountDownType.fromInt(this.type);
    }

    public void setType(CountDownType countDownType) {
        this.type = countDownType.getValue();
    }

    public String toString() {
        return "[CountDown: name=" + this.name + ", uri=" + this.uri + ", endedAt:" + new Date(this.endedAt) + "]";
    }
}
