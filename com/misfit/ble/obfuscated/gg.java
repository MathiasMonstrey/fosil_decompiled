package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gg extends ew {
    private static final String TAG = LogUtils.m15475b(em.class);
    private short f1554if;
    public boolean mC;
    private long mD;
    private long mE;
    private long mF;
    private C4572a ns;

    public static class C4572a extends ey {
        public byte kT;
        public byte nt;
        public long nu;
    }

    public /* synthetic */ ey getResponse() {
        return df();
    }

    public C4572a df() {
        return this.ns;
    }

    public String getRequestName() {
        return "fileSettingPut";
    }

    public String getCharacteristicUUID() {
        return "3dda0007-957f-7d4a-34a6-74696673696d";
    }

    public boolean isWaitingForResponse() {
        return (this.mIsCompleted && this.mC) ? false : true;
    }

    public long cW() {
        return this.mD;
    }

    public void m15135a(short s, long j, long j2, long j3) {
        this.f1554if = s;
        this.mD = j;
        this.mE = j2;
        this.mF = j3;
        ByteBuffer allocate = ByteBuffer.allocate(15);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 17);
        allocate.putShort(1, s);
        allocate.putInt(3, hb.m15168g(j));
        allocate.putInt(7, hb.m15168g(j2));
        allocate.putInt(11, hb.m15168g(j3));
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        if (bArr.length < 4) {
            return (byte) 2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (wrap.getShort(2) != this.f1554if) {
            return (byte) 2;
        }
        if (this.ns == null) {
            return ew.validateResponse(bArr, (byte) 17);
        }
        if (this.ns.result == (byte) 0) {
            return ew.validateResponse(bArr, (byte) 18);
        }
        return this.ns.result;
    }

    public void handleResponse(String str, byte[] bArr) {
        if (this.mIsCompleted && this.mC) {
            LogUtils.m15479l(TAG, "Skip response: " + bArr);
        } else if (this.ns == null) {
            this.ns = m15133B(bArr);
            this.mIsCompleted = true;
        } else if (this.ns.result == (byte) 0) {
            C4572a C = m15134C(bArr);
            if (C != null) {
                this.ns = C;
                this.mC = true;
            }
        }
    }

    private C4572a m15133B(byte[] bArr) {
        C4572a c4572a = null;
        if (bArr.length == 4) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4572a = new C4572a();
            c4572a.kT = wrap.get(1);
            if (c4572a.kT == (byte) 0) {
                c4572a.result = (byte) 0;
            } else {
                c4572a.result = (byte) 1;
            }
        }
        return c4572a;
    }

    private C4572a m15134C(byte[] bArr) {
        C4572a c4572a = null;
        if (bArr.length == 9) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4572a = new C4572a();
            c4572a.kT = wrap.get(1);
            c4572a.nt = wrap.get(4);
            c4572a.nu = hb.m15169j(wrap.getInt(5));
            if (c4572a.kT == (byte) 0) {
                c4572a.result = (byte) 0;
            } else {
                c4572a.result = (byte) 1;
            }
        }
        return c4572a;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fileHandle", this.f1554if);
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
            if (this.ns != null) {
                jSONObject.put("status", this.ns.kT);
                jSONObject.put("actualByteWritten", this.ns.nu);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.FILE_SETTING_PUT;
    }
}
