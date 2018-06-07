package com.portfolio.platform.data.model;

import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;

public class Integration {
    public static final String COLUMN_ACTION = "action";
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_REACT_NUMBER = "reactNumber";
    public static final String COLUMN_REDIRECT_INTERNAL = "uriAndroid";
    public static final String COLUMN_REDIRECT_WEB = "urlWeb";
    public static final String COLUMN_SHORT_DESC = "shortDescription";
    public static final String COLUMN_SOURCE_TYPE = "sourceType";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    @cga("action")
    @DatabaseField(columnName = "action")
    private int action;
    @cga("createdAt")
    @DatabaseField(columnName = "createdAt")
    private String createdAt;
    @cga("id")
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @cga("image")
    @DatabaseField(columnName = "image")
    private String image;
    @cga("uriAndroid")
    @DatabaseField(columnName = "uriAndroid")
    private String internalRedirectUri;
    @cga("reactNumber")
    @DatabaseField(columnName = "reactNumber")
    private int reactNumber;
    @cga("shortDescription")
    @DatabaseField(columnName = "shortDescription")
    private String shortDescription;
    @cga("sourceType")
    @DatabaseField(columnName = "sourceType")
    private int sourceType;
    @cga("type")
    @DatabaseField(columnName = "type")
    private int type;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private String updatedAt;
    @cga("urlWeb")
    @DatabaseField(columnName = "urlWeb")
    private String webRedirectUrl;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(int i) {
        this.sourceType = i;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String str) {
        this.shortDescription = str;
    }

    public String getInternalRedirectUri() {
        return this.internalRedirectUri;
    }

    public void setInternalRedirectUri(String str) {
        this.internalRedirectUri = str;
    }

    public String getWebRedirectUrl() {
        return this.webRedirectUrl;
    }

    public void setWebRedirectUrl(String str) {
        this.webRedirectUrl = str;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
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

    public int getReactNumber() {
        return this.reactNumber;
    }

    public void setReactNumber(int i) {
        this.reactNumber = i;
    }
}
