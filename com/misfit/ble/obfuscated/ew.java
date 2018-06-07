package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import org.json.JSONObject;

public class ew {
    public boolean mIsCompleted;
    public byte[] mRequestData;

    public String getRequestName() {
        return null;
    }

    public String getCharacteristicUUID() {
        return null;
    }

    public int getTimeOut() {
        return 3000;
    }

    public boolean getIsCompleted() {
        return this.mIsCompleted;
    }

    public byte[] getRequestData() {
        return this.mRequestData;
    }

    protected static byte validateResponse(byte[] bArr, byte b) {
        if (bArr.length > 0 && bArr[0] == b) {
            return (byte) 0;
        }
        return (byte) 2;
    }

    protected static byte validateResponse(byte[] bArr, byte b, byte b2) {
        byte validateResponse = validateResponse(bArr, b);
        if (validateResponse != (byte) 0 || (bArr.length > 1 && bArr[1] == b2)) {
            return validateResponse;
        }
        return (byte) 2;
    }

    protected static byte validateResponse(byte[] bArr, byte b, byte b2, byte b3) {
        byte validateResponse = validateResponse(bArr, b, b2);
        if (validateResponse != (byte) 0 || (bArr.length > 2 && bArr[2] == b3)) {
            return validateResponse;
        }
        return (byte) 2;
    }

    public void onRequestSent(int i) {
    }

    public void handleResponse(String str, byte[] bArr) {
    }

    public byte validateResponse(String str, byte[] bArr) {
        return (byte) 0;
    }

    public JSONObject getNameJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getRequestName());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getRequestDescriptionJSON() {
        return new JSONObject();
    }

    public JSONObject getResponseDescriptionJSON() {
        return new JSONObject();
    }

    public boolean isWaitingForResponse() {
        return !this.mIsCompleted;
    }

    public void cancel() {
        this.mIsCompleted = true;
    }

    public ey getResponse() {
        return null;
    }

    public Event getEventID() {
        return Event.UNKNOWN;
    }
}
