package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gn extends ew {
    private C4578a nG;

    public static class C4578a extends ey {
        public short nH;
    }

    public /* synthetic */ ey getResponse() {
        return dl();
    }

    public C4578a dl() {
        return this.nG;
    }

    public String getRequestName() {
        return "getVibeStrength";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 1;
    }

    public byte bZ() {
        return (byte) 15;
    }

    public byte cc() {
        return (byte) 8;
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
        C4578a c4578a = new C4578a();
        c4578a.result = (byte) 0;
        if (bArr.length < 4) {
            c4578a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4578a.nH = hb.m15163c(wrap.get(3));
        }
        this.nG = c4578a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.nG != null) {
                jSONObject.put(Constants.RESULT, this.nG.result);
                jSONObject.put("vibeStrength", this.nG.nH);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_VIBE_STRENGTH;
    }
}
