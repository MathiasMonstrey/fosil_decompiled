package com.misfit.frameworks.buttonservice.db;

import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;
import java.util.Date;

public class HardwareLog implements Serializable {
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LOG = "log";
    public static final String COLUMN_READ = "read";
    public static final String COLUMN_SERIAL = "serial";
    @DatabaseField(columnName = "date")
    protected Date date;
    @DatabaseField(columnName = "id", generatedId = true)
    protected long id;
    @DatabaseField(columnName = "log")
    protected String log;
    @DatabaseField(columnName = "read")
    protected boolean read;
    @DatabaseField(columnName = "serial")
    protected String serial;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String str) {
        this.serial = str;
    }

    public String getLog() {
        return this.log;
    }

    public void setLog(String str) {
        this.log = str;
    }

    public boolean isRead() {
        return this.read;
    }

    public void setRead(boolean z) {
        this.read = z;
    }
}
