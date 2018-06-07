package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ex extends ew {
    private int mV;
    private C4562a mW;

    public static class C4562a extends ey {
        public byte kT;
        public double lM;
        public int lN;
        public int lO;
    }

    public /* synthetic */ ey getResponse() {
        return da();
    }

    public C4562a da() {
        return this.mW;
    }

    public String getRequestName() {
        return "requestConnectionPriority";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 10;
    }

    public void m15080i(int i) {
        this.mV = i;
    }

    public boolean m15079a(C4568q c4568q) {
        return c4568q.requestConnectionPriority(this.mV);
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4562a c4562a = new C4562a();
        c4562a.result = (byte) 0;
        if (bArr.length < 9) {
            c4562a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4562a.kT = wrap.get(2);
            c4562a.lM = ((double) wrap.getShort(3)) * 1.25d;
            c4562a.lN = wrap.getShort(5);
            c4562a.lO = wrap.getShort(7) * 10;
        }
        this.mW = c4562a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mW != null) {
                jSONObject.put(Constants.RESULT, this.mW.result);
                jSONObject.put("status", this.mW.kT);
                jSONObject.put("connectionInterval", this.mW.lM);
                jSONObject.put("connectionLatency", this.mW.lN);
                jSONObject.put("supervisionTimeout", this.mW.lO);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.REQUEST_CONNECTION_PRIORITY;
    }
}
