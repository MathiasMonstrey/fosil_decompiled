package com.fossil;

import java.io.IOException;

public final class bsq extends bcj<bsq> {
    public Integer bEa;
    public String bEb;
    public Boolean bEc;
    public String[] bEd;

    public bsq() {
        this.bEa = null;
        this.bEb = null;
        this.bEc = null;
        this.bEd = bcr.bqJ;
        this.bqp = null;
        this.bqy = -1;
    }

    protected final int MR() {
        int i = 0;
        int MR = super.MR();
        if (this.bEa != null) {
            MR += bci.bM(1, this.bEa.intValue());
        }
        if (this.bEb != null) {
            MR += bci.m4845k(2, this.bEb);
        }
        if (this.bEc != null) {
            this.bEc.booleanValue();
            MR += bci.hT(3) + 1;
        }
        if (this.bEd == null || this.bEd.length <= 0) {
            return MR;
        }
        int i2 = 0;
        int i3 = 0;
        while (i < this.bEd.length) {
            String str = this.bEd[i];
            if (str != null) {
                i3++;
                i2 += bci.dF(str);
            }
            i++;
        }
        return (MR + i2) + (i3 * 1);
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            int position;
            switch (MF) {
                case 0:
                    break;
                case 8:
                    position = com_fossil_bch.getPosition();
                    int MJ = com_fossil_bch.MJ();
                    switch (MJ) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.bEa = Integer.valueOf(MJ);
                            break;
                        default:
                            com_fossil_bch.hP(position);
                            m4861a(com_fossil_bch, MF);
                            continue;
                    }
                case 18:
                    this.bEb = com_fossil_bch.readString();
                    continue;
                case 24:
                    this.bEc = Boolean.valueOf(com_fossil_bch.MI());
                    continue;
                case 34:
                    position = bcr.m4872b(com_fossil_bch, 34);
                    MF = this.bEd == null ? 0 : this.bEd.length;
                    Object obj = new String[(position + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bEd, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = com_fossil_bch.readString();
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = com_fossil_bch.readString();
                    this.bEd = obj;
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
        if (this.bEa != null) {
            com_fossil_bci.bL(1, this.bEa.intValue());
        }
        if (this.bEb != null) {
            com_fossil_bci.m4854j(2, this.bEb);
        }
        if (this.bEc != null) {
            com_fossil_bci.m4855r(3, this.bEc.booleanValue());
        }
        if (this.bEd != null && this.bEd.length > 0) {
            for (String str : this.bEd) {
                if (str != null) {
                    com_fossil_bci.m4854j(4, str);
                }
            }
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsq)) {
            return false;
        }
        bsq com_fossil_bsq = (bsq) obj;
        if (this.bEa == null) {
            if (com_fossil_bsq.bEa != null) {
                return false;
            }
        } else if (!this.bEa.equals(com_fossil_bsq.bEa)) {
            return false;
        }
        if (this.bEb == null) {
            if (com_fossil_bsq.bEb != null) {
                return false;
            }
        } else if (!this.bEb.equals(com_fossil_bsq.bEb)) {
            return false;
        }
        if (this.bEc == null) {
            if (com_fossil_bsq.bEc != null) {
                return false;
            }
        } else if (!this.bEc.equals(com_fossil_bsq.bEc)) {
            return false;
        }
        return !bcn.equals(this.bEd, com_fossil_bsq.bEd) ? false : (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsq.bqp == null || com_fossil_bsq.bqp.isEmpty() : this.bqp.equals(com_fossil_bsq.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.bEc == null ? 0 : this.bEc.hashCode()) + (((this.bEb == null ? 0 : this.bEb.hashCode()) + (((this.bEa == null ? 0 : this.bEa.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + bcn.hashCode(this.bEd)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
