package com.misfit.ble.obfuscated;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class al {
    private C4440a db;
    private int dc;
    private C4443d dd;
    private C4444e de;
    private C4441b df;
    private C4442c dg;

    public enum C4440a {
        HOUR((byte) 1),
        MINUTE((byte) 2),
        SUB_EYE_01((byte) 4);
        
        private final byte ax;

        private C4440a(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum C4441b {
        CLOCKWISE((byte) 0),
        COUNTER_CLOCKWISE((byte) 1),
        SHORTEST_PATH((byte) 2);
        
        private final byte ax;

        private C4441b(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum C4442c {
        FULL((byte) 0),
        HALF((byte) 1),
        QUARTER((byte) 2),
        LINEAR((byte) 3),
        PARABOLIC((byte) 4),
        CUBIC((byte) 5);
        
        private final byte ax;

        private C4442c(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum C4443d {
        DISTANCE((byte) 0),
        POSITION((byte) 1);
        
        private final byte ax;

        private C4443d(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum C4444e {
        PRESET((byte) 0),
        FW_CALCULATION((byte) 1);
        
        private final byte ax;

        private C4444e(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public al(C4440a c4440a, int i, C4443d c4443d, C4444e c4444e, C4441b c4441b, C4442c c4442c) throws IllegalArgumentException {
        if (c4440a == null) {
            throw new IllegalArgumentException("handId must not be null.");
        } else if (c4443d == null) {
            throw new IllegalArgumentException("movingType must not be null.");
        } else if (c4444e == null) {
            throw new IllegalArgumentException("valueType must not be null.");
        } else if (c4441b == null) {
            throw new IllegalArgumentException("direction must not be null.");
        } else if (c4442c == null) {
            throw new IllegalArgumentException("speed must not be null.");
        } else {
            this.db = c4440a;
            this.dc = i;
            this.dd = c4443d;
            this.de = c4444e;
            this.df = c4441b;
            this.dg = c4442c;
        }
    }

    public C4440a m14693O() {
        return this.db;
    }

    public byte[] getData() {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put((byte) (((byte) (((byte) (((byte) (0 | ((byte) (this.df.getId() << 6)))) | ((byte) (this.dd.getId() << 5)))) | ((byte) (this.de.getId() << 4)))) | this.dg.getId()));
        allocate.putShort(hb.m15170k(this.dc));
        return allocate.array();
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("handId", this.db);
            jSONObject.put("targetValue", this.dc);
            jSONObject.put("movingType", this.dd);
            jSONObject.put("valueType", this.de);
            jSONObject.put("direction", this.df);
            jSONObject.put("speed", this.dg);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
