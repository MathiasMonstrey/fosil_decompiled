package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;

public class MisfitDeviceProfile implements Parcelable {
    public static final Creator<MisfitDeviceProfile> CREATOR = new C47161();
    protected String address;
    protected int batteryLevel;
    protected String deviceModel;
    protected String deviceSerial;
    protected String firmwareVersion;
    protected int gattState;
    protected int hidState;
    private short microAppMajorVersion;
    private short microAppMinorVersion;
    protected String productName;

    static class C47161 implements Creator<MisfitDeviceProfile> {
        C47161() {
        }

        public MisfitDeviceProfile createFromParcel(Parcel parcel) {
            return new MisfitDeviceProfile(parcel);
        }

        public MisfitDeviceProfile[] newArray(int i) {
            return new MisfitDeviceProfile[i];
        }
    }

    public MisfitDeviceProfile(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, short s, short s2) {
        this.address = str;
        this.productName = str2;
        this.deviceSerial = str3;
        this.deviceModel = str4;
        this.firmwareVersion = str5;
        this.batteryLevel = i;
        this.gattState = i2;
        this.hidState = i3;
        this.microAppMajorVersion = s;
        this.microAppMinorVersion = s2;
    }

    public MisfitDeviceProfile(Parcel parcel) {
        this.address = parcel.readString();
        this.productName = parcel.readString();
        this.deviceSerial = parcel.readString();
        this.deviceModel = parcel.readString();
        this.firmwareVersion = parcel.readString();
        this.batteryLevel = parcel.readInt();
        this.gattState = parcel.readInt();
        this.hidState = parcel.readInt();
        this.microAppMajorVersion = (short) parcel.readInt();
        this.microAppMinorVersion = (short) parcel.readInt();
    }

    public String getAddress() {
        return this.address;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getDeviceSerial() {
        return this.deviceSerial;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public void setBatteryLevel(int i) {
        this.batteryLevel = i;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public int getGattState() {
        return this.gattState;
    }

    public int getHidState() {
        return this.hidState;
    }

    public void setGattState(int i) {
        this.gattState = i;
    }

    public void setHidState(int i) {
        this.hidState = i;
    }

    public short getMicroAppMajorVersion() {
        return this.microAppMajorVersion;
    }

    public void setMicroAppMajorVersion(short s) {
        this.microAppMajorVersion = s;
    }

    public short getMicroAppMinorVersion() {
        return this.microAppMinorVersion;
    }

    public void setMicroAppMinorVersion(short s) {
        this.microAppMinorVersion = s;
    }

    public static MisfitDeviceProfile cloneFrom(BleAdapter bleAdapter) {
        String nameBySerial = DeviceIdentityUtils.getNameBySerial(bleAdapter.getSerial());
        String firmwareVersion = bleAdapter.getFirmwareVersion();
        return new MisfitDeviceProfile(bleAdapter.getMacAddress(), nameBySerial, bleAdapter.getSerial(), bleAdapter.getDeviceModel(), firmwareVersion, bleAdapter.getBatteryLevel(), bleAdapter.getGattState(), bleAdapter.getHidState(), bleAdapter.getMicroAppMajorVersion(), bleAdapter.getMicroAppMinorVersion());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.address);
        parcel.writeString(this.productName);
        parcel.writeString(this.deviceSerial);
        parcel.writeString(this.deviceModel);
        parcel.writeString(this.firmwareVersion);
        parcel.writeInt(this.batteryLevel);
        parcel.writeInt(this.gattState);
        parcel.writeInt(this.hidState);
        parcel.writeInt(this.microAppMajorVersion);
        parcel.writeInt(this.microAppMinorVersion);
    }

    public String toString() {
        return "[MisfitDeviceProfile: address=" + this.address + ", serial=" + this.deviceSerial + ", name=" + this.productName + ", deviceModel=" + this.deviceModel + ", firmware=" + this.firmwareVersion + ", majorVersion=" + this.microAppMajorVersion + ", minorVersion=" + this.microAppMinorVersion + "]";
    }
}
