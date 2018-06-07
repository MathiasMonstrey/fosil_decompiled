package com.fossil;

import java.io.IOException;

public final class bsp extends bcj<bsp> {
    private static volatile bsp[] bDX;
    public Integer bDI;
    public String bDY;
    public bsn bDZ;

    public bsp() {
        this.bDI = null;
        this.bDY = null;
        this.bDZ = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bsp[] Sn() {
        if (bDX == null) {
            synchronized (bcn.bqx) {
                if (bDX == null) {
                    bDX = new bsp[0];
                }
            }
        }
        return bDX;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.bDI != null) {
            MR += bci.bM(1, this.bDI.intValue());
        }
        if (this.bDY != null) {
            MR += bci.m4845k(2, this.bDY);
        }
        return this.bDZ != null ? MR + bci.m4841b(3, this.bDZ) : MR;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 8:
                    this.bDI = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 18:
                    this.bDY = com_fossil_bch.readString();
                    continue;
                case 26:
                    if (this.bDZ == null) {
                        this.bDZ = new bsn();
                    }
                    com_fossil_bch.m4835a(this.bDZ);
                    continue;
                default:
                    if (!super.m4861a(com_fossil_bch, MF)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final void mo1264a(bci com_fossil_bci) throws IOException {
        if (this.bDI != null) {
            com_fossil_bci.bL(1, this.bDI.intValue());
        }
        if (this.bDY != null) {
            com_fossil_bci.m4854j(2, this.bDY);
        }
        if (this.bDZ != null) {
            com_fossil_bci.m4848a(3, this.bDZ);
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsp)) {
            return false;
        }
        bsp com_fossil_bsp = (bsp) obj;
        if (this.bDI == null) {
            if (com_fossil_bsp.bDI != null) {
                return false;
            }
        } else if (!this.bDI.equals(com_fossil_bsp.bDI)) {
            return false;
        }
        if (this.bDY == null) {
            if (com_fossil_bsp.bDY != null) {
                return false;
            }
        } else if (!this.bDY.equals(com_fossil_bsp.bDY)) {
            return false;
        }
        if (this.bDZ == null) {
            if (com_fossil_bsp.bDZ != null) {
                return false;
            }
        } else if (!this.bDZ.equals(com_fossil_bsp.bDZ)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsp.bqp == null || com_fossil_bsp.bqp.isEmpty() : this.bqp.equals(com_fossil_bsp.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.bDZ == null ? 0 : this.bDZ.hashCode()) + (((this.bDY == null ? 0 : this.bDY.hashCode()) + (((this.bDI == null ? 0 : this.bDI.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
