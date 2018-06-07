package com.fossil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class bcm implements Cloneable {
    private bck<?, ?> bqv;
    private List<bcq> bqw = new ArrayList();
    private Object value;

    bcm() {
    }

    private bcm MU() {
        bcm com_fossil_bcm = new bcm();
        try {
            com_fossil_bcm.bqv = this.bqv;
            if (this.bqw == null) {
                com_fossil_bcm.bqw = null;
            } else {
                com_fossil_bcm.bqw.addAll(this.bqw);
            }
            if (this.value != null) {
                if (this.value instanceof bco) {
                    com_fossil_bcm.value = (bco) ((bco) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    com_fossil_bcm.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    r4 = new byte[bArr.length][];
                    com_fossil_bcm.value = r4;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        r4[r2] = (byte[]) bArr[r2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    com_fossil_bcm.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    com_fossil_bcm.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    com_fossil_bcm.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    com_fossil_bcm.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    com_fossil_bcm.value = ((double[]) this.value).clone();
                } else if (this.value instanceof bco[]) {
                    bco[] com_fossil_bcoArr = (bco[]) this.value;
                    r4 = new bco[com_fossil_bcoArr.length];
                    com_fossil_bcm.value = r4;
                    for (r2 = 0; r2 < com_fossil_bcoArr.length; r2++) {
                        r4[r2] = (bco) com_fossil_bcoArr[r2].clone();
                    }
                }
            }
            return com_fossil_bcm;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[MR()];
        m4864a(bci.ad(bArr));
        return bArr;
    }

    final int MR() {
        if (this.value != null) {
            return this.bqv.bV(this.value);
        }
        int i = 0;
        for (bcq com_fossil_bcq : this.bqw) {
            i = (com_fossil_bcq.bqz.length + (bci.hV(com_fossil_bcq.tag) + 0)) + i;
        }
        return i;
    }

    final void m4864a(bci com_fossil_bci) throws IOException {
        if (this.value != null) {
            this.bqv.m4862a(this.value, com_fossil_bci);
            return;
        }
        for (bcq com_fossil_bcq : this.bqw) {
            com_fossil_bci.hU(com_fossil_bcq.tag);
            com_fossil_bci.af(com_fossil_bcq.bqz);
        }
    }

    final void m4865a(bcq com_fossil_bcq) {
        this.bqw.add(com_fossil_bcq);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return MU();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bcm)) {
            return false;
        }
        bcm com_fossil_bcm = (bcm) obj;
        if (this.value != null && com_fossil_bcm.value != null) {
            return this.bqv == com_fossil_bcm.bqv ? !this.bqv.bqq.isArray() ? this.value.equals(com_fossil_bcm.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) com_fossil_bcm.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) com_fossil_bcm.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) com_fossil_bcm.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) com_fossil_bcm.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) com_fossil_bcm.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) com_fossil_bcm.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) com_fossil_bcm.value) : false;
        } else {
            if (this.bqw != null && com_fossil_bcm.bqw != null) {
                return this.bqw.equals(com_fossil_bcm.bqw);
            }
            try {
                return Arrays.equals(toByteArray(), com_fossil_bcm.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
