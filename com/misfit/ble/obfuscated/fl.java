package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fl extends ew {
    private int eI;
    private int eJ;
    private C4566a nc;
    private double nd;
    private double ne;

    public static class C4566a extends ey {
        public byte kT;
        public double lM;
        public int lN;
        public int lO;
    }

    public /* synthetic */ ey getResponse() {
        return dc();
    }

    public C4566a dc() {
        return this.nc;
    }

    public String getRequestName() {
        return "setConnectionParameter";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public int getTimeOut() {
        return MFNetworkReturnCode.REQUEST_NOT_FOUND;
    }

    public void m15095a(double d, double d2, int i, int i2) {
        this.nd = d;
        this.ne = d2;
        this.eI = i;
        this.eJ = i2;
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, (byte) 9);
        allocate.putShort(2, hb.m15170k((int) Math.ceil(this.nd / 1.25d)));
        allocate.putShort(4, hb.m15170k((int) Math.floor(this.ne / 1.25d)));
        allocate.putShort(6, hb.m15170k(this.eI));
        allocate.putShort(8, hb.m15170k((int) Math.ceil((((double) this.eJ) * 1.0d) / 10.0d)));
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, (byte) 10);
    }

    public void handleResponse(String str, byte[] bArr) {
        C4566a c4566a = new C4566a();
        c4566a.result = (byte) 0;
        if (bArr.length < 9) {
            c4566a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4566a.kT = wrap.get(2);
            c4566a.lM = (double) (((float) wrap.getShort(3)) * 1.25f);
            c4566a.lN = wrap.getShort(5);
            c4566a.lO = wrap.getShort(7) * 10;
            if (c4566a.kT != (byte) 0) {
                c4566a.result = (byte) 1;
            }
        }
        this.nc = c4566a;
        this.mIsCompleted = true;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("minConnectionInterval", this.nd);
            jSONObject.put("maxConnectionInterval", this.ne);
            jSONObject.put("connectionLatency", this.eI);
            jSONObject.put("supervisionTimeout", this.eJ);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.nc != null) {
                jSONObject.put(Constants.RESULT, this.nc.result);
                jSONObject.put("status", this.nc.kT);
                jSONObject.put("connectionInterval", this.nc.lM);
                jSONObject.put("connectionLatency", this.nc.lN);
                jSONObject.put("supervisionTimeout", this.nc.lO);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.SET_CONNECTION_PARAMETERS;
    }
}
