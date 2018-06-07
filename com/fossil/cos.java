package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "hourNotification")
public class cos implements Parcelable {
    public static final Creator<cos> CREATOR = new C22751();
    @DatabaseField(columnName = "extraId")
    private String cBs;
    @DatabaseField(columnName = "deviceFamily")
    private String cBt;
    @DatabaseField(columnName = "createdAt")
    private long createdAt;
    @DatabaseField(columnName = "hour")
    private int hour;
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @DatabaseField(columnName = "isVibrationOnly")
    private boolean isVibrationOnly;

    static class C22751 implements Creator<cos> {
        C22751() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7404C(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return jM(i);
        }

        public cos m7404C(Parcel parcel) {
            return new cos(parcel);
        }

        public cos[] jM(int i) {
            return new cos[i];
        }
    }

    public cos(int i, boolean z, String str, String str2) {
        this.hour = i;
        this.isVibrationOnly = z;
        this.cBs = str;
        this.cBt = str2;
        this.id = str + str2;
    }

    protected cos(Parcel parcel) {
        this.hour = parcel.readInt();
        this.isVibrationOnly = parcel.readByte() != (byte) 0;
        this.createdAt = parcel.readLong();
        this.cBs = parcel.readString();
        this.id = parcel.readString();
        this.cBt = parcel.readString();
    }

    public String getDeviceFamily() {
        return this.cBt;
    }

    public void setDeviceFamily(String str) {
        this.cBt = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int i) {
        this.hour = i;
    }

    public boolean isVibrationOnly() {
        return this.isVibrationOnly;
    }

    public void setVibrationOnly(boolean z) {
        this.isVibrationOnly = z;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public String aex() {
        return this.cBs;
    }

    public void hp(String str) {
        this.cBs = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hour);
        parcel.writeByte((byte) (this.isVibrationOnly ? 1 : 0));
        parcel.writeLong(this.createdAt);
        parcel.writeString(this.cBs);
        parcel.writeString(this.id);
        parcel.writeString(this.cBt);
    }
}
