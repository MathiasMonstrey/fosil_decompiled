package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.sam.HandPositions;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gk extends ew {
    private C4575a nA;

    public static class C4575a extends ey {
        public HandPositions nB;
    }

    public /* synthetic */ ey getResponse() {
        return di();
    }

    public C4575a di() {
        return this.nA;
    }

    public String getRequestName() {
        return "getCurrentHandPositions";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 1;
    }

    public byte bZ() {
        return (byte) -14;
    }

    public byte cc() {
        return (byte) 18;
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
        C4575a c4575a = new C4575a();
        c4575a.result = (byte) 0;
        if (bArr.length < 9) {
            c4575a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int d = hb.m15164d(wrap.getShort(3));
            c4575a.nB = new HandPositions(hb.m15164d(wrap.getShort(7)), hb.m15164d(wrap.getShort(5)), d);
        }
        this.nA = c4575a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.nA != null) {
                jSONObject.put(Constants.RESULT, this.nA.result);
                jSONObject.put("hourDegrees", this.nA.nB.getHourDegrees());
                jSONObject.put("minDegrees", this.nA.nB.getMinuteDegrees());
                jSONObject.put("subEyeDegrees", this.nA.nB.getSubEyeDegrees());
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_HAND_POSITION;
    }
}
