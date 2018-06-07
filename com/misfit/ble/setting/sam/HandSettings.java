package com.misfit.ble.setting.sam;

import com.misfit.ble.obfuscated.C4462b;
import org.json.JSONObject;

public class HandSettings {
    private SAMEnum$HandID bm;
    private int bn;
    private SAMEnum$HandMovingDirection bo;
    private SAMEnum$HandMovingSpeed bp;

    public HandSettings(SAMEnum$HandID sAMEnum$HandID, int i, SAMEnum$HandMovingDirection sAMEnum$HandMovingDirection, SAMEnum$HandMovingSpeed sAMEnum$HandMovingSpeed) {
        this.bm = sAMEnum$HandID;
        this.bn = i;
        this.bo = sAMEnum$HandMovingDirection;
        this.bp = sAMEnum$HandMovingSpeed;
    }

    public SAMEnum$HandID getHandId() {
        return this.bm;
    }

    public int getDegrees() {
        return this.bn;
    }

    public SAMEnum$HandMovingDirection getDirection() {
        return this.bo;
    }

    public SAMEnum$HandMovingSpeed getSpeed() {
        return this.bp;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("handId", this.bm);
            jSONObject.put("degrees", this.bn);
            jSONObject.put("direction", this.bo);
            jSONObject.put("speed", this.bp);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
