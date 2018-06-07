package com.misfit.ble.obfuscated;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class C4596v {
    private C4594u bH;
    private C4595a bI;

    public enum C4595a {
        OPEN_VIA_ACTIVITY_1((byte) 0);
        
        private static final Map<Byte, C4595a> aD = null;
        private final byte ax;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(C4595a.class).iterator();
            while (it.hasNext()) {
                C4595a c4595a = (C4595a) it.next();
                aD.put(Byte.valueOf(c4595a.getId()), c4595a);
            }
        }

        private C4595a(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public C4596v(C4594u c4594u) throws IllegalArgumentException {
        if (c4594u == null) {
            throw new IllegalArgumentException("uAppHandle must not be null.");
        }
        this.bH = c4594u;
        this.bI = C4595a.OPEN_VIA_ACTIVITY_1;
    }

    public byte[] getData() {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(this.bH.getData());
        allocate.put(this.bI.getId());
        return allocate.array();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C4596v) {
            C4596v c4596v = (C4596v) obj;
            if (this.bH.equals(c4596v.bH) && this.bI.equals(c4596v.bI)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.bH.hashCode();
    }
}
