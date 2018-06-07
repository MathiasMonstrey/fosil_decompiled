package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ds extends ew {
    private C4538a lL;

    public static class C4538a extends ey {
        public byte kT;
        public double lM;
        public int lN;
        public int lO;
    }

    public /* synthetic */ ey getResponse() {
        return cC();
    }

    public C4538a cC() {
        return this.lL;
    }

    public String getRequestName() {
        return "getConnectionParameter";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 10;
    }

    public void ca() {
        byte bZ = bZ();
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, bZ);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4538a c4538a = new C4538a();
        c4538a.result = (byte) 0;
        if (bArr.length < 9) {
            c4538a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4538a.kT = wrap.get(2);
            c4538a.lM = ((double) wrap.getShort(3)) * 1.25d;
            c4538a.lN = wrap.getShort(5);
            c4538a.lO = wrap.getShort(7) * 10;
        }
        this.lL = c4538a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lL != null) {
                jSONObject.put(Constants.RESULT, this.lL.result);
                jSONObject.put("status", this.lL.kT);
                jSONObject.put("connectionInterval", this.lL.lM);
                jSONObject.put("connectionLatency", this.lL.lN);
                jSONObject.put("supervisionTimeout", this.lL.lO);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_CONNECTION_PARAMETERS;
    }
}
