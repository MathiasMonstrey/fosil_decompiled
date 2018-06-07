package com.misfit.ble.setting.sam;

import com.misfit.ble.obfuscated.C4462b;
import org.json.JSONObject;

public class HandControl {
    private SAMEnum$HandID bh;
    private short bi;

    public HandControl(SAMEnum$HandID sAMEnum$HandID, short s) {
        this.bh = sAMEnum$HandID;
        this.bi = s;
    }

    public SAMEnum$HandID getHandID() {
        return this.bh;
    }

    public short getDegrees() {
        return this.bi;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("handId", this.bh);
            jSONObject.put("degrees", this.bi);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
