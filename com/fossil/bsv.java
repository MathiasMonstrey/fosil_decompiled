package com.fossil;

import java.io.IOException;

public final class bsv extends bcj<bsv> {
    private static volatile bsv[] bEr;
    public bsw[] bEs;
    public Long bEt;
    public Long bEu;
    public Integer count;
    public String name;

    public bsv() {
        this.bEs = bsw.Ss();
        this.name = null;
        this.bEt = null;
        this.bEu = null;
        this.count = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bsv[] Sr() {
        if (bEr == null) {
            synchronized (bcn.bqx) {
                if (bEr == null) {
                    bEr = new bsv[0];
                }
            }
        }
        return bEr;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.bEs != null && this.bEs.length > 0) {
            for (bco com_fossil_bco : this.bEs) {
                if (com_fossil_bco != null) {
                    MR += bci.m4841b(1, com_fossil_bco);
                }
            }
        }
        if (this.name != null) {
            MR += bci.m4845k(2, this.name);
        }
        if (this.bEt != null) {
            MR += bci.m4844j(3, this.bEt.longValue());
        }
        if (this.bEu != null) {
            MR += bci.m4844j(4, this.bEu.longValue());
        }
        return this.count != null ? MR + bci.bM(5, this.count.intValue()) : MR;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 10:
                    int b = bcr.m4872b(com_fossil_bch, 10);
                    MF = this.bEs == null ? 0 : this.bEs.length;
                    Object obj = new bsw[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bEs, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bsw();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bsw();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bEs = obj;
                    continue;
                case 18:
                    this.name = com_fossil_bch.readString();
                    continue;
                case 24:
                    this.bEt = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 32:
                    this.bEu = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 40:
                    this.count = Integer.valueOf(com_fossil_bch.MJ());
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
        if (this.bEs != null && this.bEs.length > 0) {
            for (bco com_fossil_bco : this.bEs) {
                if (com_fossil_bco != null) {
                    com_fossil_bci.m4848a(1, com_fossil_bco);
                }
            }
        }
        if (this.name != null) {
            com_fossil_bci.m4854j(2, this.name);
        }
        if (this.bEt != null) {
            com_fossil_bci.m4853i(3, this.bEt.longValue());
        }
        if (this.bEu != null) {
            com_fossil_bci.m4853i(4, this.bEu.longValue());
        }
        if (this.count != null) {
            com_fossil_bci.bL(5, this.count.intValue());
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsv)) {
            return false;
        }
        bsv com_fossil_bsv = (bsv) obj;
        if (!bcn.equals(this.bEs, com_fossil_bsv.bEs)) {
            return false;
        }
        if (this.name == null) {
            if (com_fossil_bsv.name != null) {
                return false;
            }
        } else if (!this.name.equals(com_fossil_bsv.name)) {
            return false;
        }
        if (this.bEt == null) {
            if (com_fossil_bsv.bEt != null) {
                return false;
            }
        } else if (!this.bEt.equals(com_fossil_bsv.bEt)) {
            return false;
        }
        if (this.bEu == null) {
            if (com_fossil_bsv.bEu != null) {
                return false;
            }
        } else if (!this.bEu.equals(com_fossil_bsv.bEu)) {
            return false;
        }
        if (this.count == null) {
            if (com_fossil_bsv.count != null) {
                return false;
            }
        } else if (!this.count.equals(com_fossil_bsv.count)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsv.bqp == null || com_fossil_bsv.bqp.isEmpty() : this.bqp.equals(com_fossil_bsv.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.count == null ? 0 : this.count.hashCode()) + (((this.bEu == null ? 0 : this.bEu.hashCode()) + (((this.bEt == null ? 0 : this.bEt.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + bcn.hashCode(this.bEs)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
