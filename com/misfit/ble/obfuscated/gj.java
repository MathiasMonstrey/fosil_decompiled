package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gj extends ew {
    private C4574a ny;

    public static class C4574a extends ey {
        public CountdownSettings nz;
    }

    public /* synthetic */ ey getResponse() {
        return dh();
    }

    public C4574a dh() {
        return this.ny;
    }

    public String getRequestName() {
        return "getCountDownSettings";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 1;
    }

    public byte bZ() {
        return (byte) 19;
    }

    public byte cc() {
        return (byte) 1;
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
        C4574a c4574a = new C4574a();
        c4574a.result = (byte) 0;
        if (bArr.length < 14) {
            c4574a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4574a.nz = new CountdownSettings(hb.m15169j(wrap.getInt(3)), hb.m15169j(wrap.getInt(7)), wrap.getShort(11), hb.m15163c(wrap.get(13)));
        }
        this.ny = c4574a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ny != null) {
                jSONObject.put(Constants.RESULT, this.ny.result);
                jSONObject.put("startTimeInUTCSecond", this.ny.nz.getStartTimeInUTCSeconds());
                jSONObject.put("endTimeInUTCSecond", this.ny.nz.getEndTimeInUTCSeconds());
                jSONObject.put("timezoneOffset", this.ny.nz.getTimezoneOffset());
                jSONObject.put("progress", this.ny.nz.getProgress());
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_COUNTDOWN_SETTINGS;
    }
}
