package com.fossil;

final class ets {
    ets dTA;
    ets dTB;
    boolean dTy;
    boolean dTz;
    final byte[] data;
    int limit;
    int pos;

    ets() {
        this.data = new byte[2048];
        this.dTz = true;
        this.dTy = false;
    }

    ets(ets com_fossil_ets) {
        this(com_fossil_ets.data, com_fossil_ets.pos, com_fossil_ets.limit);
        com_fossil_ets.dTy = true;
    }

    ets(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.dTz = false;
        this.dTy = true;
    }

    public ets aHG() {
        ets com_fossil_ets = this.dTA != this ? this.dTA : null;
        this.dTB.dTA = this.dTA;
        this.dTA.dTB = this.dTB;
        this.dTA = null;
        this.dTB = null;
        return com_fossil_ets;
    }

    public ets m11193a(ets com_fossil_ets) {
        com_fossil_ets.dTB = this;
        com_fossil_ets.dTA = this.dTA;
        this.dTA.dTB = com_fossil_ets;
        this.dTA = com_fossil_ets;
        return com_fossil_ets;
    }

    public ets py(int i) {
        if (i <= 0 || i > this.limit - this.pos) {
            throw new IllegalArgumentException();
        }
        ets com_fossil_ets = new ets(this);
        com_fossil_ets.limit = com_fossil_ets.pos + i;
        this.pos += i;
        this.dTB.m11193a(com_fossil_ets);
        return com_fossil_ets;
    }

    public void aHH() {
        if (this.dTB == this) {
            throw new IllegalStateException();
        } else if (this.dTB.dTz) {
            int i = this.limit - this.pos;
            if (i <= (this.dTB.dTy ? 0 : this.dTB.pos) + (2048 - this.dTB.limit)) {
                m11194a(this.dTB, i);
                aHG();
                ett.m11195b(this);
            }
        }
    }

    public void m11194a(ets com_fossil_ets, int i) {
        if (com_fossil_ets.dTz) {
            if (com_fossil_ets.limit + i > 2048) {
                if (com_fossil_ets.dTy) {
                    throw new IllegalArgumentException();
                } else if ((com_fossil_ets.limit + i) - com_fossil_ets.pos > 2048) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(com_fossil_ets.data, com_fossil_ets.pos, com_fossil_ets.data, 0, com_fossil_ets.limit - com_fossil_ets.pos);
                    com_fossil_ets.limit -= com_fossil_ets.pos;
                    com_fossil_ets.pos = 0;
                }
            }
            System.arraycopy(this.data, this.pos, com_fossil_ets.data, com_fossil_ets.limit, i);
            com_fossil_ets.limit += i;
            this.pos += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
