package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ee extends ew {
    private C4552a mm;

    public static class C4552a extends ey {
        public byte aF;
        public byte aH;
        public short aI;
        public short aJ;
    }

    public /* synthetic */ ey getResponse() {
        return cO();
    }

    public C4552a cO() {
        return this.mm;
    }

    public String getRequestName() {
        return "getSingleAlarmTime";
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
        return (byte) 14;
    }

    public byte ce() {
        return (byte) 2;
    }

    public void m15062b(byte b) {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cw());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, ce());
        allocate.put(4, b);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4552a c4552a = new C4552a();
        c4552a.result = (byte) 0;
        if (bArr.length < 8) {
            c4552a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4552a.aF = wrap.get(4);
            c4552a.aH = wrap.get(5);
            c4552a.aI = hb.m15163c(wrap.get(6));
            c4552a.aJ = hb.m15163c(wrap.get(7));
        }
        this.mm = c4552a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mm != null) {
                jSONObject.put(Constants.RESULT, this.mm.result);
                jSONObject.put("alarmDay", this.mm.aF);
                jSONObject.put("alarmType", this.mm.aH);
                jSONObject.put("alarmHour", this.mm.aI);
                jSONObject.put(Alarm.COLUMN_ALARM_MINUTE, this.mm.aJ);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_SINGLE_ALARM;
    }
}
