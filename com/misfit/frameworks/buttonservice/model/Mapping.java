package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import com.misfit.frameworks.common.enums.Action.Apps;
import com.misfit.frameworks.common.enums.Gesture;

@DatabaseTable(tableName = "mapping")
public class Mapping implements Parcelable {
    public static final String COLUMN_ACTION = "action";
    public static final String COLUMN_DEVICE_FAMILY = "deviceFamily";
    public static final String COLUMN_DEVICE_ID = "deviceId";
    public static final String COLUMN_EXTRA_INFO = "extraInfo";
    public static final String COLUMN_GESTURE = "gesture";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_OBJECT_ID = "objectId";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final Creator<Mapping> CREATOR = new 1();
    private boolean isServiceCommand;
    @cga("action")
    @DatabaseField(columnName = "action")
    private int mAction;
    @DatabaseField(columnName = "deviceFamily")
    private String mDeviceFamily;
    @cga("deviceId")
    @DatabaseField(columnName = "deviceId")
    private String mDeviceId;
    @cga("extraInfo")
    @DatabaseField(columnName = "extraInfo")
    private String mExtraInfo;
    @cga("gesture")
    @DatabaseField(columnName = "gesture", persisterClass = GestureDataType.class)
    private Gesture mGesture;
    @DatabaseField(columnName = "id", id = true)
    private String mId;
    @cga("objectId")
    @DatabaseField(columnName = "objectId")
    private String mObjectId;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private String mUpdatedAt;

    public Mapping() {
        this.mExtraInfo = "";
    }

    public Mapping(Gesture gesture, int i) {
        this.mGesture = gesture;
        this.mAction = i;
    }

    public Mapping(Gesture gesture, int i, String str) {
        this(gesture, i);
        this.mExtraInfo = str;
    }

    protected Mapping(Parcel parcel) {
        this.mDeviceId = parcel.readString();
        this.mGesture = Gesture.fromInt(parcel.readInt());
        this.mAction = parcel.readInt();
        this.mExtraInfo = parcel.readString();
        this.mUpdatedAt = parcel.readString();
        this.mObjectId = parcel.readString();
        this.mId = parcel.readString();
        this.mDeviceFamily = parcel.readString();
        this.isServiceCommand = parcel.readByte() != (byte) 0;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
        this.mDeviceFamily = DeviceIdentityUtils.getDeviceFamily(str).name();
    }

    public void setGesture(Gesture gesture) {
        this.mGesture = gesture;
    }

    public Gesture getGesture() {
        return this.mGesture;
    }

    public void setAction(int i) {
        this.mAction = i;
    }

    public int getAction() {
        return this.mAction;
    }

    public void setExtraInfo(String str) {
        this.mExtraInfo = str;
    }

    public String getExtraInfo() {
        return this.mExtraInfo;
    }

    public String getUpdatedAt() {
        return this.mUpdatedAt;
    }

    public void setUpdatedAt(String str) {
        this.mUpdatedAt = str;
    }

    public String getObjectId() {
        return this.mObjectId;
    }

    public void setObjectId(String str) {
        this.mObjectId = str;
    }

    public String getId() {
        return this.mDeviceId.concat(this.mGesture.toString());
    }

    public void setId(String str) {
        this.mId = str;
    }

    public boolean isServiceCommand() {
        return this.isServiceCommand;
    }

    public void setIsServiceCommand(boolean z) {
        this.isServiceCommand = z;
    }

    public String getDeviceFamily() {
        return this.mDeviceFamily;
    }

    public void setDeviceFamily(String str) {
        this.mDeviceFamily = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDeviceId);
        parcel.writeInt(this.mGesture.getValue());
        parcel.writeInt(this.mAction);
        parcel.writeString(this.mExtraInfo);
        parcel.writeString(this.mUpdatedAt);
        parcel.writeString(this.mObjectId);
        parcel.writeString(this.mId);
        parcel.writeString(this.mDeviceFamily);
        parcel.writeByte((byte) (this.isServiceCommand ? 1 : 0));
    }

    public String toString() {
        return "Serial=" + getDeviceId() + ", deviceFamily=" + getDeviceFamily() + ", action=" + this.mAction + ", gesture=" + this.mGesture + ", extraInfo=" + this.mExtraInfo + "\n";
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null || !(obj instanceof Mapping)) {
            return false;
        }
        Mapping mapping = (Mapping) obj;
        Object deviceFamily = mapping.getDeviceFamily();
        Object deviceFamily2 = getDeviceFamily();
        boolean z2 = (TextUtils.isEmpty(deviceFamily) && TextUtils.isEmpty(deviceFamily2)) || (deviceFamily != null && deviceFamily.equalsIgnoreCase(deviceFamily2));
        if (mapping.getAction() != getAction() || mapping.getGesture() != getGesture() || !z2) {
            return false;
        }
        if (mapping.getAction() != Apps.RING_MY_PHONE) {
            return true;
        }
        if (mapping.getExtraInfo() != null) {
            return mapping.getExtraInfo().equalsIgnoreCase(getExtraInfo());
        }
        if (getExtraInfo() != null) {
            z = false;
        }
        return z;
    }

    public Mapping clone() {
        Mapping mapping = new Mapping();
        mapping.mDeviceId = this.mDeviceId;
        mapping.mGesture = this.mGesture;
        mapping.mAction = this.mAction;
        mapping.mExtraInfo = this.mExtraInfo;
        mapping.mUpdatedAt = this.mUpdatedAt;
        mapping.mObjectId = this.mObjectId;
        mapping.mDeviceFamily = this.mDeviceFamily;
        mapping.isServiceCommand = this.isServiceCommand;
        mapping.mId = this.mId;
        return mapping;
    }
}
