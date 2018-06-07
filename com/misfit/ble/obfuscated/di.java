package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.dg.C4495a;
import com.misfit.ble.obfuscated.dg.C4527b;
import com.misfit.ble.util.LogUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class di extends dg {
    private static final String TAG = LogUtils.m15475b(di.class);

    public di(C4495a c4495a) {
        super(c4495a);
    }

    public String getRequestName() {
        return "fileStreamingUserInputEvents_v2";
    }

    public String getCharacteristicUUID() {
        return "3dda0006-957f-7d4a-34a6-74696673696d";
    }

    public void mo4866c(short s) {
        this.kQ = s;
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.putShort(1, s);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        byte b = (byte) (bArr[0] & 64);
        if (this.lp == null) {
            return ew.validateResponse(bArr, (byte) 66);
        }
        if (b == (byte) 0) {
            return (byte) 0;
        }
        return (byte) 2;
    }

    public void handleResponse(String str, byte[] bArr) {
        if (this.mIsCompleted) {
            LogUtils.m15479l(TAG, "Skip response: " + bArr);
            return;
        }
        this.lp = m15054q(bArr);
        if (this.lp.result == (byte) 0) {
            this.ih.bk();
        }
        this.mIsCompleted = true;
    }

    protected C4527b m15054q(byte[] bArr) {
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
            if (!(c4527b.kU == this.kQ && c4527b.kT == (byte) 0)) {
                c4527b.result = (byte) 1;
            }
        }
        return c4527b;
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
}
