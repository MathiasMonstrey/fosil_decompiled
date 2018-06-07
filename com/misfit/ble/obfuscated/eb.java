package com.misfit.ble.obfuscated;

import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class eb extends ew {
    private C4549a mh;

    public static class C4549a extends ey {
        public boolean aQ;
        public short aR;
        public short aS;
        public short aT;
        public short aU;
        public LED lX;
        public Vibe lY;
        public Sound lZ;
        public short mi;
    }

    public /* synthetic */ ey getResponse() {
        return cL();
    }

    public C4549a cL() {
        return this.mh;
    }

    public String getRequestName() {
        return "getInactivityNudge";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte cw() {
        return (byte) 1;
    }

    public byte bZ() {
        return (byte) 3;
    }

    public byte cc() {
        return (byte) 3;
    }

    public byte ce() {
        return (byte) 1;
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
        C4549a c4549a = new C4549a();
        c4549a.result = (byte) 0;
        if (bArr.length < 13) {
            c4549a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4549a.aQ = hb.m15165d(wrap.get(4));
            c4549a.lX = new LED(hb.m15163c(wrap.get(5)));
            c4549a.lY = new Vibe(hb.m15163c(wrap.get(6)));
            c4549a.lZ = new Sound(hb.m15163c(wrap.get(7)));
            c4549a.aR = hb.m15163c(wrap.get(8));
            c4549a.aS = hb.m15163c(wrap.get(9));
            c4549a.aT = hb.m15163c(wrap.get(10));
            c4549a.aU = hb.m15163c(wrap.get(11));
            c4549a.mi = hb.m15163c(wrap.get(12));
        }
        this.mh = c4549a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mh != null) {
                jSONObject.put(Constants.RESULT, this.mh.result);
                jSONObject.put(BaseFeatureModel.COLUMN_ENABLED, this.mh.aQ);
                jSONObject.put("ledSequenceID", this.mh.lX.getValue());
                jSONObject.put("vibeSequenceID", this.mh.lY.getValue());
                jSONObject.put("soundSequenceID", this.mh.lZ.getValue());
                jSONObject.put("startHour", this.mh.aR);
                jSONObject.put("startMinute", this.mh.aS);
                jSONObject.put("endHour", this.mh.aT);
                jSONObject.put("endMinute", this.mh.aU);
                jSONObject.put("repeatIntervalMinutes", this.mh.mi);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_INACTIVITY_NUDGE;
    }
}
