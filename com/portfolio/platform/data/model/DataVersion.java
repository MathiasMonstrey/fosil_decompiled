package com.portfolio.platform.data.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "dataVersion")
public class DataVersion {
    public static final String COLUMN_DATA_VERSION = "dataVersion";
    public static final String COLUMN_DATA_VER_TIMESTAMP = "timestamp";
    @DatabaseField(columnName = "dataVersion", id = true)
    private String dataVersion;
    @DatabaseField(columnName = "timestamp")
    private long timestamp;

    public DataVersion(String str, long j) {
        this.dataVersion = str;
        this.timestamp = j;
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public void setDataVersion(String str) {
        this.dataVersion = str;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
