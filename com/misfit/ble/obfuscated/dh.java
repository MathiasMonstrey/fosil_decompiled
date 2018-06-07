package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.dg.C4495a;
import com.misfit.ble.obfuscated.dg.C4527b;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dh extends dg {
    private static final String TAG = LogUtils.m15475b(dh.class);
    private int lg;
    private int mLength;

    public dh(C4495a c4495a) {
        super(c4495a);
    }

    public String getRequestName() {
        return "fileStreamingUserInputEvents_v1";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void mo4866c(short s) {
        m15050a(s, 0, 0);
    }

    private void m15050a(short s, int i, int i2) {
        this.kQ = s;
        this.lg = i;
        this.mLength = i2;
        ByteBuffer allocate = ByteBuffer.allocate(11);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.putShort(1, s);
        allocate.putInt(3, i);
        allocate.putInt(7, i2);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        if (this.lp != null) {
            return (byte) 0;
        }
        return ew.validateResponse(bArr, (byte) 2);
    }

    public void handleResponse(String str, byte[] bArr) {
        if (this.mIsCompleted) {
            LogUtils.m15479l(TAG, "Skip response: " + bArr);
        } else if (this.lp == null && str.equals("3dda0003-957f-7d4a-34a6-74696673696d")) {
            this.lp = m15052q(bArr);
            if (this.lp.result != (byte) 0) {
                this.mIsCompleted = true;
            } else {
                this.ih.bk();
            }
        } else {
            this.ih.onStreamingEventData(bArr);
        }
    }

    protected C4527b m15052q(byte[] bArr) {
        C4527b c4527b = new C4527b();
        c4527b.result = (byte) 0;
        c4527b.kT = (byte) 0;
        if (bArr.length < 4) {
            c4527b.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4527b.kU = wrap.getShort(1);
            c4527b.kT = wrap.get(3);
            if (!(c4527b.kU == this.kQ && (c4527b.kT == (byte) 0 || c4527b.kT == (byte) 4))) {
                c4527b.result = (byte) 1;
            }
        }
        return c4527b;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("handle", hb.m15164d(this.kQ));
            jSONObject.put(Constants.JSON_KEY_OFFSET, this.lg);
            jSONObject.put("length", this.mLength);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
