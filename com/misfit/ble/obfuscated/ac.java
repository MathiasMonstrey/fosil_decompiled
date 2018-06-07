package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.setting.uapp.files.declaration.UAppDeclarationFrame;
import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.Set;

public class ac extends C4436x {
    private Set<UAppDeclarationFrame> ca;

    public ac(UAppSystemVersion uAppSystemVersion, Set<UAppDeclarationFrame> set) throws IllegalArgumentException {
        if (uAppSystemVersion == null) {
            throw new IllegalArgumentException("uAppSystemVersion must not be null.");
        } else if (set == null) {
            throw new IllegalArgumentException("declarationFrames must not be null.");
        } else {
            m14675a(uAppSystemVersion, (byte) 4);
            this.ca = new LinkedHashSet(set);
        }
    }

    public byte[] getData() throws IllegalArgumentException {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        try {
            allocate.put((byte) this.ca.size());
            for (UAppDeclarationFrame data : this.ca) {
                allocate.put(data.getData());
            }
            int position = allocate.position();
            byte[] bArr = new byte[position];
            allocate.rewind();
            allocate.get(bArr, 0, position);
            return bArr;
        } catch (Exception e) {
            throw new IllegalArgumentException("Declaration file data length exceeds 2048 bytes");
        }
    }
}
