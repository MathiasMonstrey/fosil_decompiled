package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;

public class ShineDevice extends Device implements Parcelable, Comparable {
    public static final Creator<ShineDevice> CREATOR = new C47171();

    static class C47171 implements Creator<ShineDevice> {
        C47171() {
        }

        public ShineDevice createFromParcel(Parcel parcel) {
            return new ShineDevice(parcel);
        }

        public ShineDevice[] newArray(int i) {
            return new ShineDevice[i];
        }
    }

    public ShineDevice(String str, String str2, String str3, int i) {
        super(str, str2, str3, i);
    }

    public static ShineDevice clone(com.misfit.ble.shine.ShineDevice shineDevice, int i) {
        return new ShineDevice(shineDevice.getSerialNumber(), shineDevice.getName(), shineDevice.getAddress(), i);
    }

    public boolean isSupportDeviceState(CommunicateMode communicateMode) {
        return communicateMode == CommunicateMode.SET_ALARM || communicateMode == CommunicateMode.GET_ALARM || communicateMode == CommunicateMode.CLEAR_ALARM || communicateMode == CommunicateMode.GET_SECOND_TIMEZONE || communicateMode == CommunicateMode.SET_SECOND_TIMEZONE || communicateMode == CommunicateMode.GET_COUNTDOWN || communicateMode == CommunicateMode.SET_COUNTDOWN;
    }

    protected ShineDevice(Parcel parcel) {
        this.serial = parcel.readString();
        this.name = parcel.readString();
        this.macAddress = parcel.readString();
        this.rssi = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.serial);
        parcel.writeString(this.name);
        parcel.writeString(this.macAddress);
        parcel.writeInt(this.rssi);
    }

    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof ShineDevice)) {
            return 1;
        }
        ShineDevice shineDevice = (ShineDevice) obj;
        if (shineDevice.getRssi() == getRssi()) {
            return 0;
        }
        if (shineDevice.getRssi() <= getRssi()) {
            return -1;
        }
        return 1;
    }
}
