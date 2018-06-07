package com.portfolio.platform.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cfy;
import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;

public class Explore implements Parcelable {
    public static final String COLUMN_BACKGROUND = "background";
    public static final String COLUMN_CREATE_AT = "createdAt";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ETAG = "_etag";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LOCAL_BACKGROUND = "COLUMN_LOCAL_BACKGROUND";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final Creator<Explore> CREATOR = new 1();
    @cga("background")
    @cfy
    @DatabaseField(columnName = "background")
    private String background;
    @cga("createdAt")
    @cfy
    @DatabaseField(columnName = "createdAt")
    private String createdAt;
    @cga("description")
    @cfy
    @DatabaseField(columnName = "description")
    private String description;
    @cga("_etag")
    @cfy
    @DatabaseField(columnName = "_etag")
    private String etag;
    @cga("id")
    @cfy
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @cfy
    @DatabaseField(columnName = "COLUMN_LOCAL_BACKGROUND")
    private int localBackground;
    @cga("title")
    @cfy
    @DatabaseField(columnName = "title")
    private String title;
    @cga("type")
    @cfy
    @DatabaseField(columnName = "type")
    private String type;
    @cga("updatedAt")
    @cfy
    @DatabaseField(columnName = "updatedAt")
    private String updatedAt;

    public Explore(String str, int i, String str2, String str3) {
        this.type = str;
        this.localBackground = i;
        this.title = str2;
        this.description = str3;
    }

    public int getLocalBackground() {
        return this.localBackground;
    }

    public void setLocalBackground(int i) {
        this.localBackground = i;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getBackground() {
        return this.background;
    }

    public void setBackground(String str) {
        this.background = str;
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

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    protected Explore(Parcel parcel) {
        this.id = parcel.readString();
        this.type = parcel.readString();
        this.background = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.etag = parcel.readString();
        this.createdAt = parcel.readString();
        this.updatedAt = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.background);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.etag);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.updatedAt);
    }
}
