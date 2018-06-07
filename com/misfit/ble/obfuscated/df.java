package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class df extends ew {
    private static final String TAG = LogUtils.m15475b(df.class);
    private C4526a lo;

    public static class C4526a extends ey {
        public byte kT;
    }

    public /* synthetic */ ey getResponse() {
        return cq();
    }

    public String getRequestName() {
        return "setLastProcessedFileHandle";
    }

    public C4526a cq() {
        return this.lo;
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void m15048c(short s) {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 22);
        allocate.putShort(1, s);
        this.mRequestData = allocate.array();
    }

    public void handleResponse(String str, byte[] bArr) {
        C4526a c4526a = new C4526a();
        c4526a.result = ew.validateResponse(bArr, (byte) 23);
        if (c4526a.result == (byte) 0) {
            if (bArr.length < 2) {
                c4526a.result = (byte) 1;
            } else {
                c4526a.kT = bArr[1];
            }
        }
        this.lo = c4526a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lo != null) {
                jSONObject.put(Constants.RESULT, this.lo.result);
                jSONObject.put("status", this.lo.kT);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.SET_LAST_PROCESSED_FILE_HANDLE;
    }
}
