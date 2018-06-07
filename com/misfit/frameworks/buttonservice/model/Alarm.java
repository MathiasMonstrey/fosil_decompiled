package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;
import com.fossil.wearables.fsl.dial.ConfigItem;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.Arrays;
import java.util.Calendar;

@DatabaseTable(tableName = "alarm")
public class Alarm implements Parcelable, Comparable<Alarm> {
    public static final short ALARM_RING_DEFAULT_DURATION = (short) 1000;
    public static final short ALARM_SMART_MINS = (short) 10;
    public static final short ALARM_SNOOZE_MINS = (short) 5;
    public static final String COLUMN_ALARM_MINUTE = "alarmMinute";
    public static final String COLUMN_ALARM_TITLE = "alarmTitle";
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_DAYS = "days";
    public static final String COLUMN_IS_ACTIVE = "isActiveAlarm";
    public static final String COLUMN_IS_REPEAT_ALARM = "isRepeat";
    public static final String COLUMN_OBJECT_ID = "objectId";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final String COLUMN_URI = "uri";
    public static final Creator<Alarm> CREATOR = new 1();
    public static final String FORMAT_DATE_ISO = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String TABLE_NAME = "alarm";
    private static String uriSchemePrefix = "uri:fsl:alarm:";
    @cga("alarmMinute")
    @DatabaseField(columnName = "alarmMinute")
    private int alarmMinute;
    @cga("alarmTitle")
    @DatabaseField(columnName = "alarmTitle")
    private String alarmTitle;
    @cga("createdAt")
    @DatabaseField(columnName = "createdAt")
    private String createdAt;
    @cga("days")
    @DatabaseField(columnName = "days")
    private String days;
    @cga("isActiveAlarm")
    @DatabaseField(columnName = "isActiveAlarm")
    private boolean isActive;
    @cga("isRepeat")
    @DatabaseField(columnName = "isRepeat")
    private boolean isRepeat;
    private boolean isSynced;
    @cga("objectId")
    @DatabaseField(columnName = "objectId")
    private String objectId;
    @DatabaseField(columnName = "pinType")
    private int pinType;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private String updatedAt;
    @cga("uri")
    @DatabaseField(columnName = "uri", id = true)
    private String uri;

    public Alarm(String str, int i, boolean z, String str2, boolean z2) {
        this.alarmTitle = str;
        this.alarmMinute = i;
        this.isRepeat = z;
        this.createdAt = str2;
        this.updatedAt = str2;
        this.isActive = z2;
        this.uri = uriSchemePrefix + String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    public Alarm(String str, int i, boolean z, String str2, boolean z2, int[] iArr) {
        this.alarmTitle = str;
        this.alarmMinute = i;
        this.isRepeat = z;
        this.createdAt = str2;
        this.updatedAt = str2;
        this.isActive = z2;
        this.uri = uriSchemePrefix + String.valueOf(Calendar.getInstance().getTimeInMillis());
        this.days = Arrays.toString(iArr);
    }

    public Alarm() {
        this.uri = uriSchemePrefix + String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    protected Alarm(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.alarmTitle = parcel.readString();
        this.alarmMinute = parcel.readInt();
        this.isRepeat = parcel.readByte() != (byte) 0;
        this.createdAt = parcel.readString();
        this.objectId = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.isActive = z;
        this.updatedAt = parcel.readString();
        this.uri = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.isSynced = z2;
        this.days = parcel.readString();
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public String getAlarmTitle() {
        return this.alarmTitle;
    }

    public void setAlarmTitle(String str) {
        this.alarmTitle = str;
    }

    public int getAlarmMinute() {
        return this.alarmMinute;
    }

    public void setAlarmMinute(int i) {
        this.alarmMinute = i;
    }

    public boolean isRepeat() {
        return this.isRepeat;
    }

    public void setRepeat(boolean z) {
        this.isRepeat = z;
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

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public long getAlarmMillis() {
        return ((long) (this.alarmMinute * 60)) * 1000;
    }

    public String generateUri() {
        return uriSchemePrefix + String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    public boolean isSynced() {
        return this.isSynced;
    }

    public void setSynced(boolean z) {
        this.isSynced = z;
    }

    public int[] getDays() {
        int i = 0;
        int length = (this.days == null || this.days.contains("null")) ? 0 : this.days.length();
        if (length <= 0) {
            return null;
        }
        String[] split = this.days.substring(1, length - 1).split(",");
        int length2 = split.length;
        int[] iArr = new int[length2];
        while (i < length2) {
            try {
                iArr[i] = Integer.parseInt(split[i].trim());
                i++;
            } catch (NumberFormatException e) {
                MFLogger.m12671e(ConfigItem.VALUE_KEY_ALARM, ".getDays - ex=" + e.toString());
                return null;
            }
        }
        return iArr;
    }

    public void setDays(int[] iArr) {
        this.days = iArr != null ? Arrays.toString(iArr) : "";
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.alarmTitle);
        parcel.writeInt(this.alarmMinute);
        parcel.writeByte((byte) (this.isRepeat ? 1 : 0));
        parcel.writeString(this.createdAt);
        parcel.writeString(this.objectId);
        if (this.isActive) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.updatedAt);
        parcel.writeString(this.uri);
        if (!this.isSynced) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.days);
    }

    public boolean is(Alarm alarm) {
        return alarm != null && this.uri.equals(alarm.uri);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Alarm)) {
            return false;
        }
        Alarm alarm = (Alarm) obj;
        if (this.uri.equals(alarm.uri) && this.alarmTitle.equals(alarm.alarmTitle) && this.alarmMinute == alarm.alarmMinute && this.isActive == alarm.isActive && this.isRepeat == alarm.isRepeat && compareDays(getDays(), alarm.getDays())) {
            return true;
        }
        return false;
    }

    public Alarm clone() {
        Alarm alarm = new Alarm();
        alarm.alarmTitle = this.alarmTitle;
        alarm.alarmMinute = this.alarmMinute;
        alarm.isRepeat = this.isRepeat;
        alarm.createdAt = this.createdAt;
        alarm.objectId = this.objectId;
        alarm.isActive = this.isActive;
        alarm.updatedAt = this.updatedAt;
        alarm.uri = this.uri;
        alarm.isSynced = true;
        alarm.days = this.days;
        return alarm;
    }

    public void update(Alarm alarm) {
        this.alarmTitle = alarm.alarmTitle;
        this.alarmMinute = alarm.alarmMinute;
        this.isRepeat = alarm.isRepeat;
        this.createdAt = alarm.createdAt;
        this.isActive = alarm.isActive;
        this.updatedAt = alarm.updatedAt;
        this.isSynced = alarm.isSynced;
        this.days = alarm.days;
    }

    public int compareTo(Alarm alarm) {
        if (this.isActive && !alarm.isActive) {
            return -1;
        }
        if (!this.isActive && alarm.isActive) {
            return 1;
        }
        if (this.alarmMinute > alarm.alarmMinute) {
            return 1;
        }
        if (this.alarmMinute >= alarm.alarmMinute) {
            return 0;
        }
        return -1;
    }

    private boolean compareDays(int[] iArr, int[] iArr2) {
        if (iArr == null && iArr2 == null) {
            return true;
        }
        if ((iArr != null && iArr2 == null) || iArr == null || iArr.length != iArr2.length) {
            return false;
        }
        Arrays.sort(iArr);
        Arrays.sort(iArr2);
        return Arrays.equals(iArr, iArr2);
    }
}
