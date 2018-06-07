package com.fossil;

import java.io.IOException;

public final class bsw extends bcj<bsw> {
    private static volatile bsw[] bEv;
    private Float bDw;
    public Double bDx;
    public Long bEw;
    public String boy;
    public String name;

    public bsw() {
        this.name = null;
        this.boy = null;
        this.bEw = null;
        this.bDw = null;
        this.bDx = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bsw[] Ss() {
        if (bEv == null) {
            synchronized (bcn.bqx) {
                if (bEv == null) {
                    bEv = new bsw[0];
                }
            }
        }
        return bEv;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.name != null) {
            MR += bci.m4845k(1, this.name);
        }
        if (this.boy != null) {
            MR += bci.m4845k(2, this.boy);
        }
        if (this.bEw != null) {
            MR += bci.m4844j(3, this.bEw.longValue());
        }
        if (this.bDw != null) {
            this.bDw.floatValue();
            MR += bci.hT(4) + 4;
        }
        if (this.bDx == null) {
            return MR;
        }
        this.bDx.doubleValue();
        return MR + (bci.hT(5) + 8);
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 10:
                    this.name = com_fossil_bch.readString();
                    continue;
                case 18:
                    this.boy = com_fossil_bch.readString();
                    continue;
                case 24:
                    this.bEw = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 37:
                    this.bDw = Float.valueOf(Float.intBitsToFloat(com_fossil_bch.ML()));
                    continue;
                case 41:
                    this.bDx = Double.valueOf(Double.longBitsToDouble(com_fossil_bch.MM()));
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
        if (this.name != null) {
            com_fossil_bci.m4854j(1, this.name);
        }
        if (this.boy != null) {
            com_fossil_bci.m4854j(2, this.boy);
        }
        if (this.bEw != null) {
            com_fossil_bci.m4853i(3, this.bEw.longValue());
        }
        if (this.bDw != null) {
            com_fossil_bci.m4851g(4, this.bDw.floatValue());
        }
        if (this.bDx != null) {
            com_fossil_bci.m4847a(5, this.bDx.doubleValue());
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsw)) {
            return false;
        }
        bsw com_fossil_bsw = (bsw) obj;
        if (this.name == null) {
            if (com_fossil_bsw.name != null) {
                return false;
            }
        } else if (!this.name.equals(com_fossil_bsw.name)) {
            return false;
        }
        if (this.boy == null) {
            if (com_fossil_bsw.boy != null) {
                return false;
            }
        } else if (!this.boy.equals(com_fossil_bsw.boy)) {
            return false;
        }
        if (this.bEw == null) {
            if (com_fossil_bsw.bEw != null) {
                return false;
            }
        } else if (!this.bEw.equals(com_fossil_bsw.bEw)) {
            return false;
        }
        if (this.bDw == null) {
            if (com_fossil_bsw.bDw != null) {
                return false;
            }
        } else if (!this.bDw.equals(com_fossil_bsw.bDw)) {
            return false;
        }
        if (this.bDx == null) {
            if (com_fossil_bsw.bDx != null) {
                return false;
            }
        } else if (!this.bDx.equals(com_fossil_bsw.bDx)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsw.bqp == null || com_fossil_bsw.bqp.isEmpty() : this.bqp.equals(com_fossil_bsw.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.bDx == null ? 0 : this.bDx.hashCode()) + (((this.bDw == null ? 0 : this.bDw.hashCode()) + (((this.bEw == null ? 0 : this.bEw.hashCode()) + (((this.boy == null ? 0 : this.boy.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
