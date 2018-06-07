package com.fossil;

import java.io.IOException;

public final class bsl extends bcj<bsl> {
    private static volatile bsl[] bDD;
    public Integer bDE;
    public bsp[] bDF;
    public bsm[] bDG;

    public bsl() {
        this.bDE = null;
        this.bDF = bsp.Sn();
        this.bDG = bsm.Sl();
        this.bqp = null;
        this.bqy = -1;
    }

    public static bsl[] Sk() {
        if (bDD == null) {
            synchronized (bcn.bqx) {
                if (bDD == null) {
                    bDD = new bsl[0];
                }
            }
        }
        return bDD;
    }

    protected final int MR() {
        int i = 0;
        int MR = super.MR();
        if (this.bDE != null) {
            MR += bci.bM(1, this.bDE.intValue());
        }
        if (this.bDF != null && this.bDF.length > 0) {
            int i2 = MR;
            for (bco com_fossil_bco : this.bDF) {
                if (com_fossil_bco != null) {
                    i2 += bci.m4841b(2, com_fossil_bco);
                }
            }
            MR = i2;
        }
        if (this.bDG != null && this.bDG.length > 0) {
            while (i < this.bDG.length) {
                bco com_fossil_bco2 = this.bDG[i];
                if (com_fossil_bco2 != null) {
                    MR += bci.m4841b(3, com_fossil_bco2);
                }
                i++;
            }
        }
        return MR;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            int b;
            Object obj;
            switch (MF) {
                case 0:
                    break;
                case 8:
                    this.bDE = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 18:
                    b = bcr.m4872b(com_fossil_bch, 18);
                    MF = this.bDF == null ? 0 : this.bDF.length;
                    obj = new bsp[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bDF, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bsp();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bsp();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bDF = obj;
                    continue;
                case 26:
                    b = bcr.m4872b(com_fossil_bch, 26);
                    MF = this.bDG == null ? 0 : this.bDG.length;
                    obj = new bsm[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bDG, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bsm();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bsm();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bDG = obj;
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
        int i = 0;
        if (this.bDE != null) {
            com_fossil_bci.bL(1, this.bDE.intValue());
        }
        if (this.bDF != null && this.bDF.length > 0) {
            for (bco com_fossil_bco : this.bDF) {
                if (com_fossil_bco != null) {
                    com_fossil_bci.m4848a(2, com_fossil_bco);
                }
            }
        }
        if (this.bDG != null && this.bDG.length > 0) {
            while (i < this.bDG.length) {
                bco com_fossil_bco2 = this.bDG[i];
                if (com_fossil_bco2 != null) {
                    com_fossil_bci.m4848a(3, com_fossil_bco2);
                }
                i++;
            }
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsl)) {
            return false;
        }
        bsl com_fossil_bsl = (bsl) obj;
        if (this.bDE == null) {
            if (com_fossil_bsl.bDE != null) {
                return false;
            }
        } else if (!this.bDE.equals(com_fossil_bsl.bDE)) {
            return false;
        }
        return !bcn.equals(this.bDF, com_fossil_bsl.bDF) ? false : !bcn.equals(this.bDG, com_fossil_bsl.bDG) ? false : (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsl.bqp == null || com_fossil_bsl.bqp.isEmpty() : this.bqp.equals(com_fossil_bsl.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((this.bDE == null ? 0 : this.bDE.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + bcn.hashCode(this.bDF)) * 31) + bcn.hashCode(this.bDG)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
