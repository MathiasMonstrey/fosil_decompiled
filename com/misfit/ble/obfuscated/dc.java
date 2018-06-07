package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;

public class dc extends ew {
    private static final String TAG = LogUtils.m15475b(dc.class);
    private final byte gF = (byte) 0;
    private C4523a la;
    private ByteArrayBuffer lb = new ByteArrayBuffer(20);
    private boolean lc = false;
    private boolean ld = false;

    public static class C4523a extends ey {
        public byte kT;
        public short le;
    }

    public /* synthetic */ ey getResponse() {
        return cn();
    }

    public String getRequestName() {
        return "getLastProcessedFileHandle";
    }

    public C4523a cn() {
        return this.la;
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 24);
        this.mRequestData = allocate.array();
    }

    public void handleResponse(String str, byte[] bArr) {
        boolean z = true;
        if (this.mIsCompleted) {
            LogUtils.m15479l(TAG, "Skip response: " + bArr);
            return;
        }
        if (this.la == null) {
            this.la = m15046o(bArr);
            if (this.la.result != (byte) 0) {
                this.mIsCompleted = true;
            }
        } else if (str.equals("3dda0004-957f-7d4a-34a6-74696673696d")) {
            this.lb.append(bArr, 1, bArr.length - 1);
            if ((bArr[0] & -128) != 0) {
                ByteBuffer wrap = ByteBuffer.wrap(this.lb.buffer());
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                this.la.le = wrap.getShort();
                this.lc = true;
            }
        } else if (str.equals("3dda0003-957f-7d4a-34a6-74696673696d")) {
            if (bArr[0] == (byte) 8) {
                this.ld = true;
            } else {
                this.la.result = (byte) 1;
                this.mIsCompleted = true;
            }
        }
        if (this.la.result == (byte) 0) {
            if (!(this.ld && this.lc)) {
                z = false;
            }
            this.mIsCompleted = z;
        }
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.la != null) {
                jSONObject.put(Constants.RESULT, this.la.result);
                jSONObject.put("status", this.la.kT);
                jSONObject.put("fileHandle", this.la.le);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public byte validateResponse(String str, byte[] bArr) {
        if (this.la != null) {
            return (byte) 0;
        }
        return ew.validateResponse(bArr, (byte) 25);
    }

    private C4523a m15046o(byte[] bArr) {
        C4523a c4523a = new C4523a();
        c4523a.result = (byte) 0;
        c4523a.kT = (byte) 0;
        if (bArr.length <= 1) {
            c4523a.result = (byte) 1;
        } else {
            c4523a.kT = bArr[1];
            if (c4523a.kT != (byte) 0) {
                c4523a.result = (byte) 1;
            }
        }
        return c4523a;
    }

    public Event getEventID() {
        return Event.GET_LAST_PROCESSED_FILE_HANDLE;
    }
}
