package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class em extends ew {
    private static final String TAG = LogUtils.m15475b(em.class);
    private short f1543if;
    private C4559a mB;
    public boolean mC;
    private long mD;
    private long mE;
    private long mF;

    public static class C4559a extends ey {
        public byte kT;
        public long mG;
    }

    public /* synthetic */ ey getResponse() {
        return cV();
    }

    public C4559a cV() {
        return this.mB;
    }

    public String getRequestName() {
        return "otaPut";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public boolean isWaitingForResponse() {
        return (this.mIsCompleted && this.mC) ? false : true;
    }

    public long cW() {
        return this.mD;
    }

    public long cX() {
        return this.mE;
    }

    public void m15069a(short s, long j, long j2, long j3) {
        this.f1543if = s;
        this.mD = j;
        this.mE = j2;
        this.mF = j3;
        ByteBuffer allocate = ByteBuffer.allocate(15);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 11);
        allocate.putShort(1, s);
        allocate.putInt(3, hb.m15168g(j));
        allocate.putInt(7, hb.m15168g(j2));
        allocate.putInt(11, hb.m15168g(j3));
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        if (this.mB == null) {
            return ew.validateResponse(bArr, (byte) 12);
        }
        if (this.mB.result == (byte) 0) {
            return ew.validateResponse(bArr, (byte) 15);
        }
        return this.mB.result;
    }

    public void handleResponse(String str, byte[] bArr) {
        if (this.mIsCompleted && this.mC) {
            LogUtils.m15479l(TAG, "Skip response: " + bArr);
            return;
        }
        if (this.mB == null) {
            this.mB = m15067u(bArr);
        } else if (this.mB.result == (byte) 0) {
            this.mB = m15068v(bArr);
            this.mC = true;
        }
        this.mIsCompleted = true;
    }

    private C4559a m15067u(byte[] bArr) {
        C4559a c4559a = new C4559a();
        c4559a.result = (byte) 0;
        c4559a.kT = (byte) 0;
        if (bArr.length < 4) {
            c4559a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            short s = wrap.getShort(1);
            c4559a.kT = wrap.get(3);
            if (!(s == this.f1543if && c4559a.kT == (byte) 0)) {
                c4559a.result = (byte) 1;
            }
        }
        return c4559a;
    }

    private C4559a m15068v(byte[] bArr) {
        C4559a c4559a = new C4559a();
        c4559a.result = (byte) 0;
        c4559a.kT = (byte) 0;
        if (bArr.length < 9) {
            c4559a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            short s = wrap.getShort(1);
            c4559a.kT = wrap.get(3);
            c4559a.mG = (long) wrap.getInt(5);
            if (!(s == this.f1543if && c4559a.kT == (byte) 0)) {
                c4559a.result = (byte) 1;
            }
        }
        return c4559a;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fileHandle", this.f1543if);
            jSONObject.put(Constants.JSON_KEY_OFFSET, this.mD);
            jSONObject.put("length", this.mE);
            jSONObject.put("totalLength", this.mF);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mB != null) {
                jSONObject.put(Constants.RESULT, this.mB.result);
                jSONObject.put("status", this.mB.kT);
                jSONObject.put("actualByteWritten", this.mB.mG);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.OTA_PUT;
    }
}
