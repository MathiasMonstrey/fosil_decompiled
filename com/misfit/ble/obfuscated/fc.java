package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fc extends ew {
    private C4565a mX;

    public static class C4565a extends ey {
        public boolean mY;
    }

    public /* synthetic */ ey getResponse() {
        return db();
    }

    public C4565a db() {
        return this.mX;
    }

    public String getRequestName() {
        return "serialNumberGetLock";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 7;
    }

    public void ca() {
        byte bZ = bZ();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, bZ);
        allocate.put(2, (byte) 7);
        allocate.put(3, (byte) -88);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        boolean z = false;
        C4565a c4565a = new C4565a();
        c4565a.result = (byte) 0;
        if (bArr.length != 3) {
            c4565a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            if (wrap.get(2) != (byte) 0) {
                z = true;
            }
            c4565a.mY = z;
        }
        this.mX = c4565a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mX != null) {
                jSONObject.put(Constants.RESULT, this.mX.result);
                jSONObject.put("isLocked", this.mX.mY);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.SERIAL_NUMBER_GET_LOCK;
    }
}
