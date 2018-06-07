package com.portfolio.platform.data.model;

import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "LandingPage")
public class LandingPage {
    public static final String COLUMN_BACKGROUND_URL = "background";
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    @cga("background")
    @DatabaseField(columnName = "background")
    private String backgroundUrl;
    @cga("createdAt")
    @DatabaseField(columnName = "createdAt")
    private String createdAt;
    @cga("id")
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @cga("type")
    @DatabaseField(columnName = "type")
    private String type;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private String updatedAt;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public void setBackgroundUrl(String str) {
        this.backgroundUrl = str;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
