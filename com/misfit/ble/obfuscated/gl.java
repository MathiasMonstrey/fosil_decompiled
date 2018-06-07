package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gl extends ew {
    private C4576a nC;

    public static class C4576a extends ey {
        public short nD;
    }

    public /* synthetic */ ey getResponse() {
        return dj();
    }

    public C4576a dj() {
        return this.nC;
    }

    public String getRequestName() {
        return "getTimezoneOffsetDisplay";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 1;
    }

    public byte bZ() {
        return (byte) 18;
    }

    public byte cc() {
        return (byte) 1;
    }

    public void ca() {
        byte cb = cb();
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4576a c4576a = new C4576a();
        c4576a.result = (byte) 0;
        if (bArr.length < 5) {
            c4576a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4576a.nD = wrap.getShort(3);
        }
        this.nC = c4576a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.nC != null) {
                jSONObject.put(Constants.RESULT, this.nC.result);
                jSONObject.put("timezoneOffset", this.nC.nD);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_SECOND_TIMEZONE;
    }
}
