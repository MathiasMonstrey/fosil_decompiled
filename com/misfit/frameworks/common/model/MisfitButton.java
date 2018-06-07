package com.misfit.frameworks.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class MisfitButton implements Parcelable {
    public static final Creator<MisfitButton> CREATOR = new C47331();
    private static final String KEY_MAPPINGS = "mappings";
    private static final String KEY_SERIAL = "serial";
    private static final String KEY_STATUS = "status";
    String mMappings;
    String mSerial;
    MisfitButtonState mStatus = MisfitButtonState.STATE_UNKNOWN;

    static class C47331 implements Creator<MisfitButton> {
        C47331() {
        }

        public MisfitButton createFromParcel(Parcel parcel) {
            return new MisfitButton(parcel);
        }

        public MisfitButton[] newArray(int i) {
            return new MisfitButton[i];
        }
    }

    MisfitButton(String str, MisfitButtonState misfitButtonState, String str2) {
        this.mSerial = str;
        this.mStatus = misfitButtonState;
        this.mMappings = str2;
    }

    MisfitButton(Parcel parcel) {
        this.mSerial = parcel.readString();
        this.mStatus = MisfitButtonState.getValue(parcel.readInt());
        this.mMappings = parcel.readString();
    }

    public String getSerial() {
        return this.mSerial;
    }

    public MisfitButtonState getState() {
        return this.mStatus;
    }

    public String getMappings() {
        return this.mMappings;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MisfitButton) && ((MisfitButton) obj).mSerial.equals(this.mSerial);
    }

    public int hashCode() {
        return this.mSerial.hashCode();
    }

    public String toString() {
        return this.mSerial + "-" + this.mStatus;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSerial);
        parcel.writeInt(this.mStatus.getId());
        if (this.mMappings != null) {
            parcel.writeString(this.mMappings.toString());
        }
    }

    public static MisfitButton fromJson(String str) {
        try {
            Log.i("fromJson", str);
            JSONObject jSONObject = new JSONObject(str);
            return new MisfitButton(jSONObject.getString("serial"), MisfitButtonState.getValue(jSONObject.getInt("status")), jSONObject.getString("mappings"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serial", this.mSerial);
            jSONObject.put("status", this.mStatus.getId());
            jSONObject.put("mappings", this.mMappings);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
