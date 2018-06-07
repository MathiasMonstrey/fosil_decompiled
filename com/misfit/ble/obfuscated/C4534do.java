package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class C4534do extends ew {
    private C4533a lz;

    public static class C4533a extends ey {
        public LED lA;
        public Vibe lB;
        public Sound lC;
        public LED lD;
        public Vibe lE;
        public Sound lF;
    }

    public /* synthetic */ ey getResponse() {
        return cy();
    }

    public C4533a cy() {
        return this.lz;
    }

    public String getRequestName() {
        return "getCallTextNotification";
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
        C4533a c4533a = new C4533a();
        c4533a.result = (byte) 0;
        if (bArr.length < 10) {
            c4533a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4533a.lA = new LED(hb.m15163c(wrap.get(4)));
            c4533a.lB = new Vibe(hb.m15163c(wrap.get(5)));
            c4533a.lC = new Sound(hb.m15163c(wrap.get(6)));
            c4533a.lD = new LED(hb.m15163c(wrap.get(7)));
            c4533a.lE = new Vibe(hb.m15163c(wrap.get(8)));
            c4533a.lF = new Sound(hb.m15163c(wrap.get(9)));
        }
        this.lz = c4533a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lz != null) {
                jSONObject.put("callLedSequence", this.lz.lA.getValue());
                jSONObject.put("callVibeSequence", this.lz.lB.getValue());
                jSONObject.put("callSoundSequence", this.lz.lC.getValue());
                jSONObject.put("textLedSequence", this.lz.lD.getValue());
                jSONObject.put("textVibeSequence", this.lz.lE.getValue());
                jSONObject.put("textSoundSequence", this.lz.lF.getValue());
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_BLE_NOTIFICATION;
    }
}
