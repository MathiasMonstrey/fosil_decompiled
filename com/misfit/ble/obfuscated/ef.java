package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ef extends ew {
    private C4553a mn;

    public static class C4553a extends ey {
        public int mo;
        public short mp;
        public long timestamp;
    }

    public /* synthetic */ ey getResponse() {
        return cP();
    }

    public C4553a cP() {
        return this.mn;
    }

    public String getRequestName() {
        return "getTime";
    }

    public byte bZ() {
        return (byte) 4;
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        byte bZ = bZ();
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, bZ);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4553a c4553a = new C4553a();
        c4553a.result = (byte) 0;
        if (bArr.length < 10) {
            c4553a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4553a.timestamp = (long) wrap.getInt(2);
            c4553a.mo = wrap.getShort(6);
            c4553a.mp = wrap.getShort(8);
        }
        this.mn = c4553a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mn != null) {
                jSONObject.put(Constants.RESULT, this.mn.result);
                jSONObject.put("timestamp", this.mn.timestamp);
                jSONObject.put("partialSeconds", this.mn.mo);
                jSONObject.put("timezoneOffsetInMinutes", this.mn.mp);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_TIME;
    }
}
