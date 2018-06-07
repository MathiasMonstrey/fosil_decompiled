package com.fossil;

import java.io.IOException;

public final class bta extends bcj<bta> {
    private static volatile bta[] bFe;
    private Float bDw;
    public Double bDx;
    public Long bEw;
    public Long bFf;
    public String boy;
    public String name;

    public bta() {
        this.bFf = null;
        this.name = null;
        this.boy = null;
        this.bEw = null;
        this.bDw = null;
        this.bDx = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bta[] Su() {
        if (bFe == null) {
            synchronized (bcn.bqx) {
                if (bFe == null) {
                    bFe = new bta[0];
                }
            }
        }
        return bFe;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.bFf != null) {
            MR += bci.m4844j(1, this.bFf.longValue());
        }
        if (this.name != null) {
            MR += bci.m4845k(2, this.name);
        }
        if (this.boy != null) {
            MR += bci.m4845k(3, this.boy);
        }
        if (this.bEw != null) {
            MR += bci.m4844j(4, this.bEw.longValue());
        }
        if (this.bDw != null) {
            this.bDw.floatValue();
            MR += bci.hT(5) + 4;
        }
        if (this.bDx == null) {
            return MR;
        }
        this.bDx.doubleValue();
        return MR + (bci.hT(6) + 8);
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 8:
                    this.bFf = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 18:
                    this.name = com_fossil_bch.readString();
                    continue;
                case 26:
                    this.boy = com_fossil_bch.readString();
                    continue;
                case 32:
                    this.bEw = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 45:
                    this.bDw = Float.valueOf(Float.intBitsToFloat(com_fossil_bch.ML()));
                    continue;
                case 49:
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
        if (this.bFf != null) {
            com_fossil_bci.m4853i(1, this.bFf.longValue());
        }
        if (this.name != null) {
            com_fossil_bci.m4854j(2, this.name);
        }
        if (this.boy != null) {
            com_fossil_bci.m4854j(3, this.boy);
        }
        if (this.bEw != null) {
            com_fossil_bci.m4853i(4, this.bEw.longValue());
        }
        if (this.bDw != null) {
            com_fossil_bci.m4851g(5, this.bDw.floatValue());
        }
        if (this.bDx != null) {
            com_fossil_bci.m4847a(6, this.bDx.doubleValue());
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bta)) {
            return false;
        }
        bta com_fossil_bta = (bta) obj;
        if (this.bFf == null) {
            if (com_fossil_bta.bFf != null) {
                return false;
            }
        } else if (!this.bFf.equals(com_fossil_bta.bFf)) {
            return false;
        }
        if (this.name == null) {
            if (com_fossil_bta.name != null) {
                return false;
            }
        } else if (!this.name.equals(com_fossil_bta.name)) {
            return false;
        }
        if (this.boy == null) {
            if (com_fossil_bta.boy != null) {
                return false;
            }
        } else if (!this.boy.equals(com_fossil_bta.boy)) {
            return false;
        }
        if (this.bEw == null) {
            if (com_fossil_bta.bEw != null) {
                return false;
            }
        } else if (!this.bEw.equals(com_fossil_bta.bEw)) {
            return false;
        }
        if (this.bDw == null) {
            if (com_fossil_bta.bDw != null) {
                return false;
            }
        } else if (!this.bDw.equals(com_fossil_bta.bDw)) {
            return false;
        }
        if (this.bDx == null) {
            if (com_fossil_bta.bDx != null) {
                return false;
            }
        } else if (!this.bDx.equals(com_fossil_bta.bDx)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bta.bqp == null || com_fossil_bta.bqp.isEmpty() : this.bqp.equals(com_fossil_bta.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.bDx == null ? 0 : this.bDx.hashCode()) + (((this.bDw == null ? 0 : this.bDw.hashCode()) + (((this.bEw == null ? 0 : this.bEw.hashCode()) + (((this.boy == null ? 0 : this.boy.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.bFf == null ? 0 : this.bFf.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
