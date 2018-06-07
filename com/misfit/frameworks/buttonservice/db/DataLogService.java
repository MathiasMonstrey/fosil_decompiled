package com.misfit.frameworks.buttonservice.db;

import com.j256.ormlite.field.DatabaseField;

public class DataLogService {
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_CREATE_AT = "createAt";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LOG_STYLE = "logStyle";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_UPDATE_AT = "updateAt";
    public static final int DEF_MF_LOG = 0;
    public static final int DEF_MF_OTA_LOG = 3;
    public static final int DEF_MF_SETUP_LOG = 2;
    public static final int DEF_MF_SYNC_LOG = 1;
    public static final int DEF_STATUS_MERGED = 2;
    public static final int DEF_STATUS_NOT_SENT = 0;
    public static final int DEF_STATUS_SENDING = 1;
    @DatabaseField(columnName = "content")
    private String content;
    @DatabaseField(columnName = "createAt")
    private long createAt;
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "logStyle")
    private int logStyle;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "updateAt")
    private long updateAt;

    public DataLogService(int i, int i2, String str, int i3, long j, long j2) {
        this.id = i;
        this.status = i2;
        this.content = str;
        this.logStyle = i3;
        this.createAt = j;
        this.updateAt = j2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public int getLogStyle() {
        return this.logStyle;
    }

    public void setLogStyle(int i) {
        this.logStyle = i;
    }

    public long getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(long j) {
        this.createAt = j;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(long j) {
        this.updateAt = j;
    }
}
