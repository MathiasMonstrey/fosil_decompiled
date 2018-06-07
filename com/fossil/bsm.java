package com.fossil;

import java.io.IOException;

public final class bsm extends bcj<bsm> {
    private static volatile bsm[] bDH;
    public Integer bDI;
    public String bDJ;
    public bsn[] bDK;
    private Boolean bDL;
    public bso bDM;

    public bsm() {
        this.bDI = null;
        this.bDJ = null;
        this.bDK = bsn.Sm();
        this.bDL = null;
        this.bDM = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bsm[] Sl() {
        if (bDH == null) {
            synchronized (bcn.bqx) {
                if (bDH == null) {
                    bDH = new bsm[0];
                }
            }
        }
        return bDH;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.bDI != null) {
            MR += bci.bM(1, this.bDI.intValue());
        }
        if (this.bDJ != null) {
            MR += bci.m4845k(2, this.bDJ);
        }
        if (this.bDK != null && this.bDK.length > 0) {
            int i = MR;
            for (bco com_fossil_bco : this.bDK) {
                if (com_fossil_bco != null) {
                    i += bci.m4841b(3, com_fossil_bco);
                }
            }
            MR = i;
        }
        if (this.bDL != null) {
            this.bDL.booleanValue();
            MR += bci.hT(4) + 1;
        }
        return this.bDM != null ? MR + bci.m4841b(5, this.bDM) : MR;
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
                    this.bDJ = com_fossil_bch.readString();
                    continue;
                case 26:
                    int b = bcr.m4872b(com_fossil_bch, 26);
                    MF = this.bDK == null ? 0 : this.bDK.length;
                    Object obj = new bsn[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bDK, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bsn();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bsn();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bDK = obj;
                    continue;
                case 32:
                    this.bDL = Boolean.valueOf(com_fossil_bch.MI());
                    continue;
                case 42:
                    if (this.bDM == null) {
                        this.bDM = new bso();
                    }
                    com_fossil_bch.m4835a(this.bDM);
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
        if (this.bDJ != null) {
            com_fossil_bci.m4854j(2, this.bDJ);
        }
        if (this.bDK != null && this.bDK.length > 0) {
            for (bco com_fossil_bco : this.bDK) {
                if (com_fossil_bco != null) {
                    com_fossil_bci.m4848a(3, com_fossil_bco);
                }
            }
        }
        if (this.bDL != null) {
            com_fossil_bci.m4855r(4, this.bDL.booleanValue());
        }
        if (this.bDM != null) {
            com_fossil_bci.m4848a(5, this.bDM);
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsm)) {
            return false;
        }
        bsm com_fossil_bsm = (bsm) obj;
        if (this.bDI == null) {
            if (com_fossil_bsm.bDI != null) {
                return false;
            }
        } else if (!this.bDI.equals(com_fossil_bsm.bDI)) {
            return false;
        }
        if (this.bDJ == null) {
            if (com_fossil_bsm.bDJ != null) {
                return false;
            }
        } else if (!this.bDJ.equals(com_fossil_bsm.bDJ)) {
            return false;
        }
        if (!bcn.equals(this.bDK, com_fossil_bsm.bDK)) {
            return false;
        }
        if (this.bDL == null) {
            if (com_fossil_bsm.bDL != null) {
                return false;
            }
        } else if (!this.bDL.equals(com_fossil_bsm.bDL)) {
            return false;
        }
        if (this.bDM == null) {
            if (com_fossil_bsm.bDM != null) {
                return false;
            }
        } else if (!this.bDM.equals(com_fossil_bsm.bDM)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsm.bqp == null || com_fossil_bsm.bqp.isEmpty() : this.bqp.equals(com_fossil_bsm.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.bDM == null ? 0 : this.bDM.hashCode()) + (((this.bDL == null ? 0 : this.bDL.hashCode()) + (((((this.bDJ == null ? 0 : this.bDJ.hashCode()) + (((this.bDI == null ? 0 : this.bDI.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + bcn.hashCode(this.bDK)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
