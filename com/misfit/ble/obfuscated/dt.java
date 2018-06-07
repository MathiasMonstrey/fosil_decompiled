package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dt extends ew {
    private C4539a lP;

    public static class C4539a extends ey {
        public long lQ;
    }

    public /* synthetic */ ey getResponse() {
        return cD();
    }

    public C4539a cD() {
        return this.lP;
    }

    public String getRequestName() {
        return "getCurrentSteps";
    }

    public byte bZ() {
        return (byte) 17;
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        byte bZ = bZ();
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, bZ);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4539a c4539a = new C4539a();
        c4539a.result = (byte) 0;
        if (bArr.length < 6) {
            c4539a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4539a.lQ = hb.m15169j(wrap.getInt(2));
        }
        this.lP = c4539a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lP != null) {
                jSONObject.put(Constants.RESULT, this.lP.result);
                jSONObject.put("currentSteps", this.lP.lQ);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_CURRENT_STEPS;
    }
}
