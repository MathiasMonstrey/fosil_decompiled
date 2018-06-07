package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction.C4606a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class af extends UAppInstruction {
    private static double ch = 10.0d;
    private double ci;

    public af(double d) {
        this.cp = C4606a.DELAY_INSTRUCTION;
        this.ci = d;
    }

    protected byte[] mo4806K() {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort(hb.m15170k((int) (this.ci * ch)));
        return allocate.array();
    }

    public JSONObject toJSONObject() {
        JSONObject toJSONObject = super.toJSONObject();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("delayInSecond", this.ci);
            toJSONObject.put("parameters", jSONObject);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return toJSONObject;
    }
}
