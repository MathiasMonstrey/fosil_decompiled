package com.misfit.ble.setting.uapp.files.customization;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.C4594u;
import com.misfit.ble.obfuscated.hb;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public abstract class UAppCustomizationFrame {
    private C4594u bH = new C4594u((short) -1, (byte) -1, (byte) -1);

    public enum C4605a {
        CUSTOM_EVENT_MAPPING_FRAME((byte) 0),
        CUSTOM_KEY_CODES_MAPPING_FRAME((byte) 1),
        CUSTOM_GOAL_TRACKING_ID_FRAME((byte) 2);
        
        private static final Map<Byte, C4605a> aD = null;
        private final byte ax;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(C4605a.class).iterator();
            while (it.hasNext()) {
                C4605a c4605a = (C4605a) it.next();
                aD.put(Byte.valueOf(c4605a.getId()), c4605a);
            }
        }

        private C4605a(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    protected abstract short mo4891J();

    protected abstract byte[] mo4892K();

    protected UAppCustomizationFrame() {
    }

    public byte[] getData() throws IllegalArgumentException {
        short J = mo4891J();
        byte[] K = mo4892K();
        int length = K.length + 7;
        if (length > 2048) {
            throw new IllegalArgumentException("Customization frame data length exceeds 2048 bytes.");
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(this.bH.getData());
        allocate.putShort((short) length);
        allocate.put(hb.m15166e(J));
        allocate.put(K);
        return allocate.array();
    }

    public void m15247a(C4594u c4594u) throws IllegalArgumentException {
        if (c4594u == null) {
            throw new IllegalArgumentException("uAppHandle must not be null.");
        }
        this.bH = c4594u;
    }

    public C4594u m15244E() {
        return this.bH;
    }

    public boolean equals(Object obj) {
        if (obj instanceof UAppCustomizationFrame) {
            if (m15244E().equals(((UAppCustomizationFrame) obj).m15244E())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return m15244E().hashCode();
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uAppHandle", this.bH);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
