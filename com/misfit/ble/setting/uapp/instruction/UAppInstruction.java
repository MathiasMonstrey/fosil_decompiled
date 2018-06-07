package com.misfit.ble.setting.uapp.instruction;

import com.misfit.ble.obfuscated.C4462b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public abstract class UAppInstruction {
    protected final int co = 512;
    public C4606a cp;

    public enum C4606a {
        NULL_INSTRUCTION((byte) 0),
        TERMINATE_INSTRUCTION((byte) 1),
        SWITCH_ACTIVITY_INSTRUCTION((byte) 2),
        START_CRITICAL_INSTRUCTION((byte) 3),
        END_CRITICAL_INSTRUCTION((byte) 4),
        REMAP_INSTRUCTION((byte) 5),
        START_REPEAT_INSTRUCTION((byte) 6),
        END_REPEAT_INSTRUCTION((byte) 7),
        DELAY_INSTRUCTION((byte) 8),
        DO_ANIMATION_INSTRUCTION((byte) 9),
        BLE_STREAM_INSTRUCTION((byte) 11),
        HID_INSTRUCTION((byte) 12),
        GOAL_TRACKING_INSTRUCTION((byte) 13),
        TAG_IN_ACTIVITY_INSTRUCTION((byte) 14),
        TAG_OUT_ACTIVITY_INSTRUCTION((byte) 15),
        LEGACY_STREAM_INSTRUCTION((byte) 16),
        BOLT_CONTROL_INSTRUCTION((byte) 17),
        START_STANDARD_VIBE_INSTRUCTION((byte) 19);
        
        private final byte ax;

        private C4606a(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public byte[] m14681M() {
        byte[] K = mo4806K();
        if (K.length > 512) {
            return new byte[0];
        }
        short length = (short) K.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort((short) ((length << 7) | ((short) (this.cp.getId() | 0))));
        allocate.put(K);
        return allocate.array();
    }

    public byte[] mo4806K() {
        return new byte[0];
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("instructionType", this.cp);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
