package com.fossil;

import java.io.IOException;

public final class bsu extends bcj<bsu> {
    private static volatile bsu[] bEn;
    public Integer bDE;
    public bsz bEo;
    public bsz bEp;
    public Boolean bEq;

    public bsu() {
        this.bDE = null;
        this.bEo = null;
        this.bEp = null;
        this.bEq = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bsu[] Sq() {
        if (bEn == null) {
            synchronized (bcn.bqx) {
                if (bEn == null) {
                    bEn = new bsu[0];
                }
            }
        }
        return bEn;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.bDE != null) {
            MR += bci.bM(1, this.bDE.intValue());
        }
        if (this.bEo != null) {
            MR += bci.m4841b(2, this.bEo);
        }
        if (this.bEp != null) {
            MR += bci.m4841b(3, this.bEp);
        }
        if (this.bEq == null) {
            return MR;
        }
        this.bEq.booleanValue();
        return MR + (bci.hT(4) + 1);
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 8:
                    this.bDE = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 18:
                    if (this.bEo == null) {
                        this.bEo = new bsz();
                    }
                    com_fossil_bch.m4835a(this.bEo);
                    continue;
                case 26:
                    if (this.bEp == null) {
                        this.bEp = new bsz();
                    }
                    com_fossil_bch.m4835a(this.bEp);
                    continue;
                case 32:
                    this.bEq = Boolean.valueOf(com_fossil_bch.MI());
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
        if (this.bDE != null) {
            com_fossil_bci.bL(1, this.bDE.intValue());
        }
        if (this.bEo != null) {
            com_fossil_bci.m4848a(2, this.bEo);
        }
        if (this.bEp != null) {
            com_fossil_bci.m4848a(3, this.bEp);
        }
        if (this.bEq != null) {
            com_fossil_bci.m4855r(4, this.bEq.booleanValue());
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsu)) {
            return false;
        }
        bsu com_fossil_bsu = (bsu) obj;
        if (this.bDE == null) {
            if (com_fossil_bsu.bDE != null) {
                return false;
            }
        } else if (!this.bDE.equals(com_fossil_bsu.bDE)) {
            return false;
        }
        if (this.bEo == null) {
            if (com_fossil_bsu.bEo != null) {
                return false;
            }
        } else if (!this.bEo.equals(com_fossil_bsu.bEo)) {
            return false;
        }
        if (this.bEp == null) {
            if (com_fossil_bsu.bEp != null) {
                return false;
            }
        } else if (!this.bEp.equals(com_fossil_bsu.bEp)) {
            return false;
        }
        if (this.bEq == null) {
            if (com_fossil_bsu.bEq != null) {
                return false;
            }
        } else if (!this.bEq.equals(com_fossil_bsu.bEq)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsu.bqp == null || com_fossil_bsu.bqp.isEmpty() : this.bqp.equals(com_fossil_bsu.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.bEq == null ? 0 : this.bEq.hashCode()) + (((this.bEp == null ? 0 : this.bEp.hashCode()) + (((this.bEo == null ? 0 : this.bEo.hashCode()) + (((this.bDE == null ? 0 : this.bDE.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
