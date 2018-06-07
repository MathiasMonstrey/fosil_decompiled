package com.portfolio.platform.data.model;

import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Widget")
public class Widget {
    public static final String COLUMN_BACKGROUND_URL = "iconUrl";
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ICON_URL = "backgroundUrl";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LAYOUT = "layout";
    public static final String COLUMN_REDIRECT_INTERNAL_URL = "redirectInternalUrl";
    public static final String COLUMN_REDIRECT_WEB_URL = "redirectWebUrl";
    public static final String COLUMN_TILE = "title";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final String COLUMN_WIDGET_TYPE = "type";
    @cga("background")
    @DatabaseField(columnName = "iconUrl")
    private String backgroundUrl;
    @cga("createdAt")
    @DatabaseField(columnName = "createdAt")
    private String createdAt;
    @cga("text")
    @DatabaseField(columnName = "description")
    private String description;
    @cga("icon")
    @DatabaseField(columnName = "backgroundUrl")
    private String iconUrl;
    @cga("id")
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @cga("layout")
    @DatabaseField(columnName = "layout")
    private int layoutType;
    @cga("uriAndroid")
    @DatabaseField(columnName = "redirectInternalUrl")
    private String redirectInternalUrl;
    @cga("urlWeb")
    @DatabaseField(columnName = "redirectWebUrl")
    private String redirectWebUrl;
    @cga("title")
    @DatabaseField(columnName = "title")
    private String title;
    @cga("type")
    @DatabaseField(columnName = "type")
    private int type;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private String updatedAt;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public void setBackgroundUrl(String str) {
        this.backgroundUrl = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getRedirectInternalUrl() {
        return this.redirectInternalUrl;
    }

    public void setRedirectInternalUrl(String str) {
        this.redirectInternalUrl = str;
    }

    public String getRedirectWebUrl() {
        return this.redirectWebUrl;
    }

    public void setRedirectWebUrl(String str) {
        this.redirectWebUrl = str;
    }

    public int getLayoutType() {
        return this.layoutType;
    }

    public void setLayoutType(int i) {
        this.layoutType = i;
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
}
