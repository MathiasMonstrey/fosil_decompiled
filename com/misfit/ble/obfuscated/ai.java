package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction.C4606a;
import org.json.JSONObject;

public class ai extends UAppInstruction {
    private C4439a cJ;

    public enum C4439a {
        NO_VIBE((byte) 0),
        OPEN((byte) 1),
        ERROR((byte) 2),
        READY((byte) 3),
        START((byte) 4),
        STOP((byte) 5),
        RESET((byte) 6);
        
        private final byte ax;

        private C4439a(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public ai(C4439a c4439a) throws IllegalArgumentException {
        if (c4439a == null) {
            throw new IllegalArgumentException("standardVibeType must not be null.");
        }
        this.cp = C4606a.START_STANDARD_VIBE_INSTRUCTION;
        this.cJ = c4439a;
    }

    protected byte[] mo4806K() {
        return new byte[]{this.cJ.getId()};
    }

    public JSONObject toJSONObject() {
        JSONObject toJSONObject = super.toJSONObject();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("standardVibeType", this.cJ);
            toJSONObject.put("parameters", jSONObject);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return toJSONObject;
    }
}
