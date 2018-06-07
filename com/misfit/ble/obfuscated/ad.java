package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.UAppSystemVersion;
import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.Set;

public class ad extends C4436x {
    private Set<ae> ce;

    public ad(UAppSystemVersion uAppSystemVersion, Set<ae> set) throws IllegalArgumentException {
        if (uAppSystemVersion == null) {
            throw new IllegalArgumentException("uAppSystemVersion must not be null.");
        } else if (set == null) {
            throw new IllegalArgumentException("launchFrames must not be null.");
        } else {
            m14675a(uAppSystemVersion, (byte) 2);
            this.ce = new LinkedHashSet(set);
        }
    }

    public byte[] getData() throws IllegalArgumentException {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        try {
            allocate.put((byte) this.ce.size());
            for (ae data : this.ce) {
                allocate.put(data.getData());
            }
            int position = allocate.position();
            byte[] bArr = new byte[position];
            allocate.rewind();
            allocate.get(bArr, 0, position);
            return bArr;
        } catch (Exception e) {
            throw new IllegalArgumentException("Launch file data length exceeds 2048 bytes");
        }
    }
}
