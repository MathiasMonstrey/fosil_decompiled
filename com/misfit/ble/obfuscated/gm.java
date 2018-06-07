package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.flashlink.EventMappingEnum.StopWatchSecondHand;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gm extends ew {
    private C4577a nE;

    public static class C4577a extends ey {
        public StopWatchSecondHand nF;
    }

    public /* synthetic */ ey getResponse() {
        return dk();
    }

    public C4577a dk() {
        return this.nE;
    }

    public String getRequestName() {
        return "getStopWatchSetting";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 1;
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 16;
    }

    public void ca() {
        byte cb = cb();
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        allocate.put(3, (byte) 9);
        allocate.put(4, (byte) 0);
        this.mRequestData = allocate.array();
    }

    public void handleResponse(String str, byte[] bArr) {
        C4577a c4577a = new C4577a();
        c4577a.result = ew.validateResponse(bArr, (byte) 3, bZ());
        if (c4577a.result == (byte) 0) {
            if (bArr.length < 6) {
                c4577a.result = (byte) 1;
            } else {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                c4577a.nF = StopWatchSecondHand.get(wrap.get(5));
            }
        }
        this.nE = c4577a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.nE != null) {
                jSONObject.put(Constants.RESULT, this.nE.result);
                jSONObject.put("stopWatchSecondHand", this.nE.nF);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_STOP_WATCH_SETTING;
    }
}
