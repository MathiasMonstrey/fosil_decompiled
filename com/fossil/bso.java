package com.fossil;

import java.io.IOException;

public final class bso extends bcj<bso> {
    public Integer bDS;
    public Boolean bDT;
    public String bDU;
    public String bDV;
    public String bDW;

    public bso() {
        this.bDS = null;
        this.bDT = null;
        this.bDU = null;
        this.bDV = null;
        this.bDW = null;
        this.bqp = null;
        this.bqy = -1;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.bDS != null) {
            MR += bci.bM(1, this.bDS.intValue());
        }
        if (this.bDT != null) {
            this.bDT.booleanValue();
            MR += bci.hT(2) + 1;
        }
        if (this.bDU != null) {
            MR += bci.m4845k(3, this.bDU);
        }
        if (this.bDV != null) {
            MR += bci.m4845k(4, this.bDV);
        }
        return this.bDW != null ? MR + bci.m4845k(5, this.bDW) : MR;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 8:
                    int position = com_fossil_bch.getPosition();
                    int MJ = com_fossil_bch.MJ();
                    switch (MJ) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.bDS = Integer.valueOf(MJ);
                            break;
                        default:
                            com_fossil_bch.hP(position);
                            m4861a(com_fossil_bch, MF);
                            continue;
                    }
                case 16:
                    this.bDT = Boolean.valueOf(com_fossil_bch.MI());
                    continue;
                case 26:
                    this.bDU = com_fossil_bch.readString();
                    continue;
                case 34:
                    this.bDV = com_fossil_bch.readString();
                    continue;
                case 42:
                    this.bDW = com_fossil_bch.readString();
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
        if (this.bDS != null) {
            com_fossil_bci.bL(1, this.bDS.intValue());
        }
        if (this.bDT != null) {
            com_fossil_bci.m4855r(2, this.bDT.booleanValue());
        }
        if (this.bDU != null) {
            com_fossil_bci.m4854j(3, this.bDU);
        }
        if (this.bDV != null) {
            com_fossil_bci.m4854j(4, this.bDV);
        }
        if (this.bDW != null) {
            com_fossil_bci.m4854j(5, this.bDW);
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bso)) {
            return false;
        }
        bso com_fossil_bso = (bso) obj;
        if (this.bDS == null) {
            if (com_fossil_bso.bDS != null) {
                return false;
            }
        } else if (!this.bDS.equals(com_fossil_bso.bDS)) {
            return false;
        }
        if (this.bDT == null) {
            if (com_fossil_bso.bDT != null) {
                return false;
            }
        } else if (!this.bDT.equals(com_fossil_bso.bDT)) {
            return false;
        }
        if (this.bDU == null) {
            if (com_fossil_bso.bDU != null) {
                return false;
            }
        } else if (!this.bDU.equals(com_fossil_bso.bDU)) {
            return false;
        }
        if (this.bDV == null) {
            if (com_fossil_bso.bDV != null) {
                return false;
            }
        } else if (!this.bDV.equals(com_fossil_bso.bDV)) {
            return false;
        }
        if (this.bDW == null) {
            if (com_fossil_bso.bDW != null) {
                return false;
            }
        } else if (!this.bDW.equals(com_fossil_bso.bDW)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bso.bqp == null || com_fossil_bso.bqp.isEmpty() : this.bqp.equals(com_fossil_bso.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.bDW == null ? 0 : this.bDW.hashCode()) + (((this.bDV == null ? 0 : this.bDV.hashCode()) + (((this.bDU == null ? 0 : this.bDU.hashCode()) + (((this.bDT == null ? 0 : this.bDT.hashCode()) + (((this.bDS == null ? 0 : this.bDS.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
