package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ea extends ew {
    private C4548a mg;

    public static class C4548a extends ey {
        public short mGroupId;
    }

    public /* synthetic */ ey getResponse() {
        return cK();
    }

    public C4548a cK() {
        return this.mg;
    }

    public String getRequestName() {
        return "getGroupId";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 1;
    }

    public byte bZ() {
        return (byte) 13;
    }

    public byte cc() {
        return (byte) 7;
    }

    public byte cd() {
        return (byte) 1;
    }

    public void ca() {
        byte cb = cb();
        byte bZ = bZ();
        byte cc = cc();
        byte cd = cd();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        allocate.put(3, cd);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4548a c4548a = new C4548a();
        c4548a.result = (byte) 0;
        if (bArr.length < 4) {
            c4548a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4548a.mGroupId = hb.m15163c(wrap.get(3));
        }
        this.mg = c4548a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mg != null) {
                jSONObject.put(Constants.RESULT, this.mg.result);
                jSONObject.put(Constants.GROUP_ID, this.mg.mGroupId);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.BOLT_GET_GROUP_ID;
    }
}
