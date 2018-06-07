package com.fossil;

public final class bcl implements Cloneable {
    private static final bcm bqr = new bcm();
    private boolean bqs;
    private int[] bqt;
    private bcm[] bqu;
    private int mSize;

    bcl() {
        this(10);
    }

    private bcl(int i) {
        this.bqs = false;
        int bj = bj(i);
        this.bqt = new int[bj];
        this.bqu = new bcm[bj];
        this.mSize = 0;
    }

    private static int bj(int i) {
        int i2 = i << 2;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    private final int hY(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.bqt[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    final void m4863a(int i, bcm com_fossil_bcm) {
        int hY = hY(i);
        if (hY >= 0) {
            this.bqu[hY] = com_fossil_bcm;
            return;
        }
        hY ^= -1;
        if (hY >= this.mSize || this.bqu[hY] != bqr) {
            if (this.mSize >= this.bqt.length) {
                int bj = bj(this.mSize + 1);
                Object obj = new int[bj];
                Object obj2 = new bcm[bj];
                System.arraycopy(this.bqt, 0, obj, 0, this.bqt.length);
                System.arraycopy(this.bqu, 0, obj2, 0, this.bqu.length);
                this.bqt = obj;
                this.bqu = obj2;
            }
            if (this.mSize - hY != 0) {
                System.arraycopy(this.bqt, hY, this.bqt, hY + 1, this.mSize - hY);
                System.arraycopy(this.bqu, hY, this.bqu, hY + 1, this.mSize - hY);
            }
            this.bqt[hY] = i;
            this.bqu[hY] = com_fossil_bcm;
            this.mSize++;
            return;
        }
        this.bqt[hY] = i;
        this.bqu[hY] = com_fossil_bcm;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        bcl com_fossil_bcl = new bcl(i);
        System.arraycopy(this.bqt, 0, com_fossil_bcl.bqt, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.bqu[i2] != null) {
                com_fossil_bcl.bqu[i2] = (bcm) this.bqu[i2].clone();
            }
        }
        com_fossil_bcl.mSize = i;
        return com_fossil_bcl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bcl)) {
            return false;
        }
        bcl com_fossil_bcl = (bcl) obj;
        if (this.mSize != com_fossil_bcl.mSize) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.bqt;
        int[] iArr2 = com_fossil_bcl.bqt;
        int i2 = this.mSize;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            bcm[] com_fossil_bcmArr = this.bqu;
            bcm[] com_fossil_bcmArr2 = com_fossil_bcl.bqu;
            i2 = this.mSize;
            for (i = 0; i < i2; i++) {
                if (!com_fossil_bcmArr[i].equals(com_fossil_bcmArr2[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final bcm hW(int i) {
        int hY = hY(i);
        return (hY < 0 || this.bqu[hY] == bqr) ? null : this.bqu[hY];
    }

    final bcm hX(int i) {
        return this.bqu[i];
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.bqt[i2]) * 31) + this.bqu[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    final int size() {
        return this.mSize;
    }
}
