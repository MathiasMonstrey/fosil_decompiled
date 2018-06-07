package com.misfit.ble.obfuscated;

import android.support.v8.renderscript.Allocation;

public class cj extends ci {
    public cj(byte[] bArr) {
        super(bArr, "3dda0007-957f-7d4a-34a6-74696673696d");
    }

    protected byte[] bY() {
        byte[] bArr = new byte[]{(byte) 18, (byte) (this.kM % 64)};
        if (this.kM == 0) {
            bArr[1] = (byte) (bArr[1] | 64);
        }
        if (this.kN.remaining() <= 18) {
            bArr[1] = (byte) (bArr[1] | Allocation.USAGE_SHARED);
        }
        return bArr;
    }

    public int bV() {
        return 2;
    }
}
