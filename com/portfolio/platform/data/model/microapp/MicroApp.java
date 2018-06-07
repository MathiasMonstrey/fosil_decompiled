package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;
import com.fossil.wearables.fossil.R;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import java.util.UUID;

@DatabaseTable(tableName = "microApp")
public class MicroApp implements Parcelable {
    public static final String COLUMN_APP_ID = "appId";
    public static final String COLUMN_APP_SETTING = "appSetting";
    public static final String COLUMN_CREATE_AT = "createdAt";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ICON = "icon";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LIKE = "like";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PLATFORM = "platform";
    public static final String COLUMN_RELEASE_DATE = "releaseDate";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final Creator<MicroApp> CREATOR = new 1();
    @DatabaseField(columnName = "appId")
    private String appId;
    @DatabaseField(columnName = "appSetting")
    private String appSettings;
    @cga("createdAt")
    @DatabaseField(columnName = "createdAt")
    private long createAt;
    @cga("description")
    @DatabaseField(columnName = "description")
    private String description;
    @cga("icon")
    @DatabaseField(columnName = "icon")
    private String iconUrl;
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @cga("like")
    @DatabaseField(columnName = "like")
    private int like;
    @cga("name")
    @DatabaseField(columnName = "name")
    private String name;
    @cga("platform")
    @DatabaseField(columnName = "platform")
    private String platform;
    @cga("releaseDate")
    @DatabaseField(columnName = "releaseDate")
    private long releaseDate;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private long updateAt;

    public MicroApp() {
        this.id = UUID.randomUUID().toString();
        this.appId = MicroAppID.UAPP_UNKNOWN.getValue();
        this.description = "";
        this.name = "";
        this.iconUrl = "";
    }

    protected MicroApp(Parcel parcel) {
        this.id = UUID.randomUUID().toString();
        this.appId = parcel.readString();
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.platform = parcel.readString();
        this.like = parcel.readInt();
        this.appSettings = parcel.readString();
        this.iconUrl = parcel.readString();
        this.releaseDate = parcel.readLong();
        this.createAt = parcel.readLong();
        this.updateAt = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.platform);
        parcel.writeInt(this.like);
        parcel.writeString(this.appSettings);
        parcel.writeString(this.iconUrl);
        parcel.writeLong(this.releaseDate);
        parcel.writeLong(this.createAt);
        parcel.writeLong(this.updateAt);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public int getLike() {
        return this.like;
    }

    public void setLike(int i) {
        this.like = i;
    }

    public String getAppSettings() {
        return this.appSettings;
    }

    public void setAppSettings(String str) {
        this.appSettings = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public long getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(long j) {
        this.releaseDate = j;
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

    public int getDefaultIconId() {
        switch (2.$SwitchMap$com$misfit$frameworks$buttonservice$model$microapp$MicroAppInstruction$MicroAppID[MicroAppID.getMicroAppId(this.appId).ordinal()]) {
            case 2:
                return R.drawable.ic_shortcuts_photo;
            case 3:
                return R.drawable.ic_shortcuts_activity;
            case 4:
                return R.drawable.ic_shortcuts_alarm;
            case 5:
                return R.drawable.ic_shortcuts_lastalert;
            case 6:
                return R.drawable.ic_shortcuts_date;
            case 7:
                return R.drawable.ic_shortcuts_commute;
            case 8:
                return R.drawable.ic_shortcuts_goals;
            case 9:
                return R.drawable.ic_shortcuts_music;
            case 10:
                return R.drawable.ic_shortcuts_volumedown;
            case 11:
                return R.drawable.ic_shortcuts_volumeup;
            case 12:
                return R.drawable.ic_shortcuts_2tz;
            case 13:
                return R.drawable.ic_shortcuts_weather;
            case 14:
                return R.drawable.ic_shortcuts_ring;
            case 15:
                return R.drawable.ic_shortcuts_stopwatch;
            default:
                return R.drawable.ic_modetoggle;
        }
    }
}
