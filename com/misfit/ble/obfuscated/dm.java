package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dm extends ew {
    private C4531a lw;

    public static class C4531a extends ey {
        public LED aK;
        public Vibe aL;
        public Sound aM;
        public short aN;
        public short aO;
        public short aP;
    }

    public /* synthetic */ ey getResponse() {
        return cv();
    }

    public C4531a cv() {
        return this.lw;
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
        return (byte) 5;
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
        C4531a c4531a = new C4531a();
        c4531a.result = (byte) 0;
        if (bArr.length < 10) {
            c4531a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4531a.aN = hb.m15163c(wrap.get(4));
            c4531a.aK = new LED(hb.m15163c(wrap.get(5)));
            c4531a.aL = new Vibe(hb.m15163c(wrap.get(6)));
            c4531a.aM = new Sound(hb.m15163c(wrap.get(7)));
            c4531a.aO = hb.m15163c(wrap.get(8));
            c4531a.aP = hb.m15163c(wrap.get(9));
        }
        this.lw = c4531a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lw != null) {
                jSONObject.put(Constants.RESULT, this.lw.result);
                jSONObject.put("smartAlarm", this.lw.aN);
                jSONObject.put("ledSequence", this.lw.aK.getValue());
                jSONObject.put("vibeSequence", this.lw.aL.getValue());
                jSONObject.put("soundSequence", this.lw.aM.getValue());
                jSONObject.put("minutePerSnooze", this.lw.aO);
                jSONObject.put("alarmDuration", this.lw.aP);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_ALARM_PARAMETERS;
    }
}
