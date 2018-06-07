package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dp extends ew {
    private C4535a lG;

    public static class C4535a extends ey {
        public short aR;
        public short aS;
        public short aT;
        public short aU;
    }

    public /* synthetic */ ey getResponse() {
        return cz();
    }

    public C4535a cz() {
        return this.lG;
    }

    public String getRequestName() {
        return "getCallTextNotificationWindows";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cw() {
        return (byte) 1;
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 15;
    }

    public byte ce() {
        return (byte) 3;
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cw());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, ce());
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4535a c4535a = new C4535a();
        c4535a.result = (byte) 0;
        if (bArr.length < 8) {
            c4535a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4535a.aR = hb.m15163c(wrap.get(4));
            c4535a.aS = hb.m15163c(wrap.get(5));
            c4535a.aT = hb.m15163c(wrap.get(6));
            c4535a.aU = hb.m15163c(wrap.get(7));
        }
        this.lG = c4535a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lG != null) {
                jSONObject.put("startHour", this.lG.aR);
                jSONObject.put("startMinute", this.lG.aS);
                jSONObject.put("endHour", this.lG.aT);
                jSONObject.put("endMinute", this.lG.aU);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_BLE_NOTIFICATION_TIME_WINDOW;
    }
}
