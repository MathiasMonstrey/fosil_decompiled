package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dr extends ew {
    private C4537a lJ;

    public static class C4537a extends ey {
        public long lK;
    }

    public /* synthetic */ ey getResponse() {
        return cB();
    }

    public C4537a cB() {
        return this.lJ;
    }

    public String getRequestName() {
        return "getConnectionHeartbeatInterval";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, (byte) 12);
        allocate.put(2, (byte) -16);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, (byte) 12);
    }

    public void handleResponse(String str, byte[] bArr) {
        C4537a c4537a = new C4537a();
        c4537a.result = (byte) 0;
        if (bArr.length < 6) {
            c4537a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4537a.lK = (long) wrap.getInt(2);
        }
        this.lJ = c4537a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lJ != null) {
                jSONObject.put(Constants.RESULT, this.lJ.result);
                jSONObject.put("connectionHeartbeatInterval", this.lJ.lK);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_CONNECTION_HEARTBEAT_INTERVAL;
    }
}
