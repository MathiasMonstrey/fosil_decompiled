package com.fossil;

import java.util.Arrays;

final class bcq {
    final byte[] bqz;
    final int tag;

    bcq(int i, byte[] bArr) {
        this.tag = i;
        this.bqz = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bcq)) {
            return false;
        }
        bcq com_fossil_bcq = (bcq) obj;
        return this.tag == com_fossil_bcq.tag && Arrays.equals(this.bqz, com_fossil_bcq.bqz);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.bqz);
    }
}
