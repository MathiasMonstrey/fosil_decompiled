package com.fossil.wearables.fsl.history;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;

public class HistoryItem extends BaseModel {
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private Serializable data;
    @DatabaseField
    private long timestamp;
    @DatabaseField
    private String timezone;
    @DatabaseField
    private String type;

    public HistoryItem(String str, long j, String str2, Serializable serializable) {
        this.type = str;
        this.timestamp = j;
        this.timezone = str2;
        this.data = serializable;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Serializable getData() {
        return this.data;
    }

    public void setData(Serializable serializable) {
        this.data = serializable;
    }
}
