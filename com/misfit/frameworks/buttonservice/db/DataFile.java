package com.misfit.frameworks.buttonservice.db;

import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;

public class DataFile implements Serializable {
    public static final String COLUMN_DATA_FILE = "dataFile";
    public static final String COLUMN_KEY = "key";
    public static final String COLUMN_SERIAL = "serial";
    public static final String COLUMN_SYNC_TIME = "syncTime";
    @DatabaseField(columnName = "dataFile")
    protected String dataFile;
    @DatabaseField(columnName = "key", id = true)
    protected String key;
    @DatabaseField(columnName = "serial")
    protected String serial;
    @DatabaseField(columnName = "syncTime")
    protected long syncTime;

    public DataFile(String str, String str2, String str3, long j) {
        this.key = str;
        this.dataFile = str2;
        this.serial = str3;
        this.syncTime = j;
    }

    public String getKey() {
        return this.key;
    }

    public String getDataFile() {
        return this.dataFile;
    }

    public String getSerial() {
        return this.serial;
    }

    public long getSyncTime() {
        return this.syncTime;
    }
}
