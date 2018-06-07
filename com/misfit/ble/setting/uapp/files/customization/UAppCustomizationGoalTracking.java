package com.misfit.ble.setting.uapp.files.customization;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.setting.uapp.files.customization.UAppCustomizationFrame.C4605a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class UAppCustomizationGoalTracking extends UAppCustomizationFrame {
    private byte bZ;

    public UAppCustomizationGoalTracking(byte b) {
        this.bZ = b;
    }

    public byte getGoalId() {
        return this.bZ;
    }

    protected short mo4891J() {
        return (short) 1;
    }

    protected byte[] mo4892K() {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(C4605a.CUSTOM_GOAL_TRACKING_ID_FRAME.getId());
        allocate.put((byte) 1);
        allocate.put(this.bZ);
        return allocate.array();
    }

    public JSONObject toJSONObject() {
        JSONObject toJSONObject = super.toJSONObject();
        try {
            toJSONObject.put("goalId", this.bZ);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return toJSONObject;
    }
}
