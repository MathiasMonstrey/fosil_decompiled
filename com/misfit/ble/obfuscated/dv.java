package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.flashlink.FlashButtonMode;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dv extends ew {
    private C4541a lT;

    public static class C4541a extends ey {
        public boolean lU;
        public FlashButtonMode lV;
    }

    public /* synthetic */ ey getResponse() {
        return cF();
    }

    public C4541a cF() {
        return this.lT;
    }

    public String getRequestName() {
        return "getFlashButtonMode";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 10;
    }

    public void ca() {
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        boolean z = false;
        C4541a c4541a = new C4541a();
        c4541a.result = (byte) 0;
        if (bArr.length < 4) {
            c4541a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            if (wrap.get(2) != (byte) 0) {
                z = true;
            }
            c4541a.lU = z;
            c4541a.lV = FlashButtonMode.get(hb.m15163c(wrap.get(3)));
        }
        this.lT = c4541a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lT != null) {
                jSONObject.put(Constants.RESULT, this.lT.result);
                jSONObject.put("flashButtonMode", this.lT.lV);
                jSONObject.put("activityTrackingEnabled", this.lT.lU);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_FLASH_BUTTON_MODE;
    }
}
