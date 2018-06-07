package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.UAppEnum$UAppSystemLevelEvent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class ae {
    private UAppEnum$UAppSystemLevelEvent cf;
    private LinkedHashSet<C4596v> cg;

    public ae(UAppEnum$UAppSystemLevelEvent uAppEnum$UAppSystemLevelEvent, LinkedHashSet<C4596v> linkedHashSet) throws IllegalArgumentException {
        if (uAppEnum$UAppSystemLevelEvent == null) {
            throw new IllegalArgumentException("event must not be null.");
        } else if (linkedHashSet == null) {
            throw new IllegalArgumentException("referenceFrames must not be null.");
        } else {
            this.cf = uAppEnum$UAppSystemLevelEvent;
            this.cg = new LinkedHashSet(linkedHashSet);
        }
    }

    public byte[] getData() throws IllegalArgumentException {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        try {
            allocate.put(this.cf.getId());
            allocate.put((byte) this.cg.size());
            Iterator it = this.cg.iterator();
            while (it.hasNext()) {
                allocate.put(((C4596v) it.next()).getData());
            }
            int position = allocate.position();
            byte[] bArr = new byte[position];
            allocate.rewind();
            allocate.get(bArr, 0, position);
            return bArr;
        } catch (Exception e) {
            throw new IllegalArgumentException("Launch frame data length exceeds 2048 bytes");
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ae)) {
            return false;
        }
        return this.cf.equals(((ae) obj).cf);
    }

    public int hashCode() {
        return this.cf.getId();
    }
}
