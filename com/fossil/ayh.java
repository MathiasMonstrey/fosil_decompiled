package com.fossil;

import java.util.Arrays;

final class ayh extends ayg {
    private final byte[] bjp;

    ayh(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.bjp = bArr;
    }

    final byte[] getBytes() {
        return this.bjp;
    }
}
