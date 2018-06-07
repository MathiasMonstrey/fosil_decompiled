package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ge extends ew {
    private static final String TAG = LogUtils.m15475b(ge.class);
    private C4570a np;

    public static class C4570a extends ey {
        public byte kT;
        public short le;
    }

    public /* synthetic */ ey getResponse() {
        return dd();
    }

    public C4570a dd() {
        return this.np;
    }

    public String getRequestName() {
        return "fileSettingAbort";
    }

    public String getCharacteristicUUID() {
        return "3dda0007-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put(0, (byte) 20);
        this.mRequestData = allocate.array();
    }

    public boolean isWaitingForResponse() {
        return !this.mIsCompleted;
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 20);
    }

    public void handleResponse(String str, byte[] bArr) {
        if (this.mIsCompleted) {
            LogUtils.m15479l(TAG, "Skip response: " + bArr);
            return;
        }
        this.np = m15130z(bArr);
        this.mIsCompleted = true;
    }

    private C4570a m15130z(byte[] bArr) {
        C4570a c4570a = new C4570a();
        c4570a.result = (byte) 0;
        c4570a.kT = (byte) 0;
        if (bArr.length != 4) {
            c4570a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4570a.le = wrap.getShort(2);
            c4570a.kT = wrap.get(1);
            if (c4570a.kT != (byte) 0) {
                c4570a.result = (byte) 1;
            }
        }
        return c4570a;
    }

    public JSONObject getRequestDescriptionJSON() {
        return new JSONObject();
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.np != null) {
                jSONObject.put("fileHandle", hb.m15164d(this.np.le));
                jSONObject.put("status", this.np.kT);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.FILE_SETTING_ABORT;
    }
}
