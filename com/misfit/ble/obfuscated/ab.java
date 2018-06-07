package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.setting.uapp.files.customization.UAppCustomizationFrame;
import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.Set;

public class ab extends C4436x {
    private Set<UAppCustomizationFrame> bU;

    public ab(UAppSystemVersion uAppSystemVersion, Set<UAppCustomizationFrame> set) throws IllegalArgumentException {
        if (uAppSystemVersion == null) {
            throw new IllegalArgumentException("uAppSystemVersion must not be null.");
        } else if (set == null) {
            throw new IllegalArgumentException("customizationFrames must not be null.");
        } else {
            m14675a(uAppSystemVersion, (byte) 6);
            this.bU = new LinkedHashSet(set);
        }
    }

    public byte[] getData() throws IllegalArgumentException {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        try {
            allocate.put((byte) this.bU.size());
            for (UAppCustomizationFrame data : this.bU) {
                allocate.put(data.getData());
            }
            int position = allocate.position();
            byte[] bArr = new byte[position];
            allocate.rewind();
            allocate.get(bArr, 0, position);
            return bArr;
        } catch (Exception e) {
            throw new IllegalArgumentException("Customization file data length exceeds 2048 bytes");
        }
    }
}
