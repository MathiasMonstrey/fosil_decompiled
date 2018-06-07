package com.fossil;

import java.io.IOException;

public final class bsn extends bcj<bsn> {
    private static volatile bsn[] bDN;
    public bsq bDO;
    public bso bDP;
    public Boolean bDQ;
    public String bDR;

    public bsn() {
        this.bDO = null;
        this.bDP = null;
        this.bDQ = null;
        this.bDR = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bsn[] Sm() {
        if (bDN == null) {
            synchronized (bcn.bqx) {
                if (bDN == null) {
                    bDN = new bsn[0];
                }
            }
        }
        return bDN;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.bDO != null) {
            MR += bci.m4841b(1, this.bDO);
        }
        if (this.bDP != null) {
            MR += bci.m4841b(2, this.bDP);
        }
        if (this.bDQ != null) {
            this.bDQ.booleanValue();
            MR += bci.hT(3) + 1;
        }
        return this.bDR != null ? MR + bci.m4845k(4, this.bDR) : MR;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 10:
                    if (this.bDO == null) {
                        this.bDO = new bsq();
                    }
                    com_fossil_bch.m4835a(this.bDO);
                    continue;
                case 18:
                    if (this.bDP == null) {
                        this.bDP = new bso();
                    }
                    com_fossil_bch.m4835a(this.bDP);
                    continue;
                case 24:
                    this.bDQ = Boolean.valueOf(com_fossil_bch.MI());
                    continue;
                case 34:
                    this.bDR = com_fossil_bch.readString();
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
        if (this.bDO != null) {
            com_fossil_bci.m4848a(1, this.bDO);
        }
        if (this.bDP != null) {
            com_fossil_bci.m4848a(2, this.bDP);
        }
        if (this.bDQ != null) {
            com_fossil_bci.m4855r(3, this.bDQ.booleanValue());
        }
        if (this.bDR != null) {
            com_fossil_bci.m4854j(4, this.bDR);
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsn)) {
            return false;
        }
        bsn com_fossil_bsn = (bsn) obj;
        if (this.bDO == null) {
            if (com_fossil_bsn.bDO != null) {
                return false;
            }
        } else if (!this.bDO.equals(com_fossil_bsn.bDO)) {
            return false;
        }
        if (this.bDP == null) {
            if (com_fossil_bsn.bDP != null) {
                return false;
            }
        } else if (!this.bDP.equals(com_fossil_bsn.bDP)) {
            return false;
        }
        if (this.bDQ == null) {
            if (com_fossil_bsn.bDQ != null) {
                return false;
            }
        } else if (!this.bDQ.equals(com_fossil_bsn.bDQ)) {
            return false;
        }
        if (this.bDR == null) {
            if (com_fossil_bsn.bDR != null) {
                return false;
            }
        } else if (!this.bDR.equals(com_fossil_bsn.bDR)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsn.bqp == null || com_fossil_bsn.bqp.isEmpty() : this.bqp.equals(com_fossil_bsn.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.bDR == null ? 0 : this.bDR.hashCode()) + (((this.bDQ == null ? 0 : this.bDQ.hashCode()) + (((this.bDP == null ? 0 : this.bDP.hashCode()) + (((this.bDO == null ? 0 : this.bDO.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
