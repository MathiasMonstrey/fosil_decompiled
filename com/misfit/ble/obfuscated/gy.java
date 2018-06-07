package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gy extends ew {
    private long mJ;
    private long mK;
    private long mL;
    private C4579a nT;

    public static class C4579a extends ey {
        public byte kT;
        public long mN;
    }

    public /* synthetic */ ey getResponse() {
        return dm();
    }

    public C4579a dm() {
        return this.nT;
    }

    public String getRequestName() {
        return "multipleAlarmsVerify";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void m15147a(long j, long j2, long j3) {
        this.mJ = j;
        this.mK = j2;
        this.mL = j3;
        ByteBuffer allocate = ByteBuffer.allocate(15);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 16);
        allocate.putShort(1, (short) -24160);
        allocate.putInt(3, hb.m15168g(j));
        allocate.putInt(7, hb.m15168g(j2));
        allocate.putInt(11, hb.m15168g(j3));
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 17);
    }

    public void handleResponse(String str, byte[] bArr) {
        this.nT = m15146D(bArr);
        this.mIsCompleted = true;
    }

    protected C4579a m15146D(byte[] bArr) {
        C4579a c4579a = new C4579a();
        c4579a.result = (byte) 0;
        c4579a.kT = (byte) 0;
        if (bArr.length < 8) {
            c4579a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            short s = wrap.getShort(1);
            c4579a.kT = wrap.get(3);
            c4579a.mN = hb.m15169j(wrap.getInt(4));
            if (!((short) -24160 == s && c4579a.kT == (byte) 0)) {
                c4579a.result = (byte) 1;
            }
        }
        return c4579a;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("segmentOffset", this.mJ);
            jSONObject.put("segmentLength", this.mK);
            jSONObject.put("totalFileLength", this.mL);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.nT != null) {
                jSONObject.put(Constants.RESULT, this.nT.result);
                jSONObject.put("status", this.nT.kT);
                jSONObject.put("segmentCRC", this.nT.mN);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.VERIFY_MULTIPLE_ALARMS;
    }
}
