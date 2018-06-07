package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ed extends ew {
    private C4551a ml;

    public static class C4551a extends ey {
        public byte[] mPasscode = new byte[16];
    }

    public /* synthetic */ ey getResponse() {
        return cN();
    }

    public C4551a cN() {
        return this.ml;
    }

    public String getRequestName() {
        return "getPasscode";
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
        return (byte) 2;
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
        int i = 0;
        C4551a c4551a = new C4551a();
        c4551a.result = (byte) 0;
        if (bArr.length < 19) {
            c4551a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            while (i < 16) {
                c4551a.mPasscode[i] = wrap.get(i + 3);
                i++;
            }
        }
        this.ml = c4551a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ml != null) {
                jSONObject.put(Constants.RESULT, this.ml.result);
                jSONObject.put("passCode", hb.m15159E(this.ml.mPasscode));
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.BOLT_GET_PASSCODE;
    }
}
