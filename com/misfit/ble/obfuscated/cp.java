package com.misfit.ble.obfuscated;

import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class cp extends ew {
    private static final String TAG = LogUtils.m15475b(cp.class);
    private C4516a kP;
    private short kQ = (short) 256;
    private boolean kR = false;
    private boolean kS = false;

    public static class C4516a extends ey {
        public byte kT;
        public short kU;
        public byte[] kV;
    }

    public /* synthetic */ ey getResponse() {
        return cf();
    }

    public C4516a cf() {
        return this.kP;
    }

    public String getRequestName() {
        return "closeCurrentActivityFile";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(11);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.putShort(1, this.kQ);
        allocate.putInt(3, 0);
        allocate.putInt(7, 1);
        this.mRequestData = allocate.array();
    }

    public void handleResponse(String str, byte[] bArr) {
        boolean z = true;
        if (this.mIsCompleted) {
            LogUtils.m15479l(TAG, "Skip response: " + bArr);
            return;
        }
        if (str.equals("3dda0003-957f-7d4a-34a6-74696673696d")) {
            if (this.kP == null) {
                this.kP = m15020i(bArr);
                if (this.kP.result == (byte) 0) {
                    this.kS = true;
                } else {
                    this.mIsCompleted = true;
                }
            }
        } else if (str.equals("3dda0004-957f-7d4a-34a6-74696673696d")) {
            this.kP.kV = bArr;
            if (bArr.length > 0) {
                this.kR = true;
            } else {
                this.kP.result = (byte) 1;
                this.mIsCompleted = true;
            }
        }
        if (this.kP.result == (byte) 0) {
            if (!(this.kS && this.kR)) {
                z = false;
            }
            this.mIsCompleted = z;
        }
    }

    public byte validateResponse(String str, byte[] bArr) {
        if (this.kP != null) {
            return (byte) 0;
        }
        return ew.validateResponse(bArr, (byte) 2);
    }

    private C4516a m15020i(byte[] bArr) {
        C4516a c4516a = new C4516a();
        c4516a.result = (byte) 0;
        c4516a.kT = (byte) 0;
        if (bArr.length < 4) {
            c4516a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4516a.kU = wrap.getShort(1);
            c4516a.kT = wrap.get(3);
            if (!(c4516a.kU == this.kQ && c4516a.kT == (byte) 0)) {
                c4516a.result = (byte) 1;
            }
        }
        return c4516a;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("handle", hb.m15164d(this.kQ));
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.kP != null) {
                jSONObject.put(Constants.RESULT, this.kP.result);
                jSONObject.put("status", this.kP.kT);
                jSONObject.put("handle", this.kP.kU);
                jSONObject.put("rawData", hb.m15159E(this.kP.kV));
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
