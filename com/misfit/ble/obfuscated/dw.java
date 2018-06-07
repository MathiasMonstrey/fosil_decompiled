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

public class dw extends ew {
    private C4542a lW;

    public static class C4542a extends ey {
        public boolean aQ;
        public short aR;
        public short aS;
        public short aT;
        public short aU;
        public LED lX;
        public Vibe lY;
        public Sound lZ;
    }

    public /* synthetic */ ey getResponse() {
        return cG();
    }

    public C4542a cG() {
        return this.lW;
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
        return (byte) 4;
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
        C4542a c4542a = new C4542a();
        c4542a.result = (byte) 0;
        if (bArr.length < 12) {
            c4542a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4542a.aQ = hb.m15165d(wrap.get(4));
            c4542a.lX = new LED(hb.m15163c(wrap.get(5)));
            c4542a.lY = new Vibe(hb.m15163c(wrap.get(6)));
            c4542a.lZ = new Sound(hb.m15163c(wrap.get(7)));
            c4542a.aR = hb.m15163c(wrap.get(8));
            c4542a.aS = hb.m15163c(wrap.get(9));
            c4542a.aT = hb.m15163c(wrap.get(10));
            c4542a.aU = hb.m15163c(wrap.get(11));
        }
        this.lW = c4542a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lW != null) {
                jSONObject.put(Constants.RESULT, this.lW.result);
                jSONObject.put(BaseFeatureModel.COLUMN_ENABLED, this.lW.aQ);
                jSONObject.put("ledSequenceID", this.lW.lX.getValue());
                jSONObject.put("vibeSequenceID", this.lW.lY.getValue());
                jSONObject.put("soundSequenceID", this.lW.lZ.getValue());
                jSONObject.put("startHour", this.lW.aR);
                jSONObject.put("startMinute", this.lW.aS);
                jSONObject.put("endHour", this.lW.aT);
                jSONObject.put("endMinute", this.lW.aU);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_GOAL_HIT_NOTIFICATION;
    }
}
