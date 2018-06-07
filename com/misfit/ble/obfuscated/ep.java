package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.json.JSONObject;

public class ep extends ew {
    private C4561a mI;
    private long mJ;
    private long mK;
    private long mL;
    private long mM;

    public static class C4561a extends ey {
        public byte kT;
        public long mN;
    }

    public /* synthetic */ ey getResponse() {
        return cZ();
    }

    public C4561a cZ() {
        return this.mI;
    }

    public String getRequestName() {
        return "otaVerifySegment";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void m15071a(byte[] bArr, long j, long j2, long j3) {
        this.mJ = j;
        this.mK = j2;
        this.mL = j3;
        ByteBuffer allocate = ByteBuffer.allocate(15);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 16);
        allocate.putShort(1, (short) 23131);
        allocate.putInt(3, hb.m15168g(j));
        allocate.putInt(7, hb.m15168g(j2));
        allocate.putInt(11, hb.m15168g(j3));
        this.mRequestData = allocate.array();
        byte[] copyOfRange = Arrays.copyOfRange(bArr, hb.m15168g(j), hb.m15168g(j2));
        this.mM = hd.m15176a(copyOfRange.length, copyOfRange);
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 17);
    }

    public void handleResponse(String str, byte[] bArr) {
        this.mI = m15072x(bArr);
        if (this.mI.result == (byte) 0 && this.mI.mN != this.mM) {
            this.mI.result = (byte) 3;
        }
        this.mIsCompleted = true;
    }

    protected C4561a m15072x(byte[] bArr) {
        C4561a c4561a = new C4561a();
        c4561a.result = (byte) 0;
        c4561a.kT = (byte) 0;
        if (bArr.length < 8) {
            c4561a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            short s = wrap.getShort(1);
            c4561a.kT = wrap.get(3);
            c4561a.mN = hb.m15169j(wrap.getInt(4));
            if (!((short) 23131 == s && c4561a.kT == (byte) 0)) {
                c4561a.result = (byte) 1;
            }
        }
        return c4561a;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("segmentOffset", this.mJ);
            jSONObject.put("segmentLength", this.mK);
            jSONObject.put("totalFileLength", this.mL);
            jSONObject.put("expectedCRC", this.mM);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mI != null) {
                jSONObject.put(Constants.RESULT, this.mI.result);
                jSONObject.put("status", this.mI.kT);
                jSONObject.put("segmentCRC", this.mI.mN);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.OTA_VERIFY_SEGMENT;
    }
}
