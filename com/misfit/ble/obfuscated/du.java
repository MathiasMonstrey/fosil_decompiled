package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class du extends ew {
    private C4540a lR;

    public static class C4540a extends ey {
        public boolean lS;
    }

    public /* synthetic */ ey getResponse() {
        return cE();
    }

    public C4540a cE() {
        return this.lR;
    }

    public String getRequestName() {
        return "getAdvDataState";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cw() {
        return (byte) 1;
    }

    public byte cc() {
        return (byte) 8;
    }

    public void ca() {
        byte cw = cw();
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cw);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4540a c4540a = new C4540a();
        c4540a.result = (byte) 0;
        if (bArr.length < 3) {
            c4540a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4540a.lS = hb.m15165d(wrap.get(2));
        }
        this.lR = c4540a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lR != null) {
                jSONObject.put(Constants.RESULT, this.lR.result);
                jSONObject.put("advDataState", this.lR.lS);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_EXTRA_ADVERTISING_DATA_STATE;
    }
}
