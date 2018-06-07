package com.fossil;

import java.io.IOException;

public final class bsz extends bcj<bsz> {
    public long[] bFc;
    public long[] bFd;

    public bsz() {
        this.bFc = bcr.bqF;
        this.bFd = bcr.bqF;
        this.bqp = null;
        this.bqy = -1;
    }

    protected final int MR() {
        int i;
        int i2;
        int i3 = 0;
        int MR = super.MR();
        if (this.bFc == null || this.bFc.length <= 0) {
            i = MR;
        } else {
            i2 = 0;
            for (long Q : this.bFc) {
                i2 += bci.m4837Q(Q);
            }
            i = (MR + i2) + (this.bFc.length * 1);
        }
        if (this.bFd == null || this.bFd.length <= 0) {
            return i;
        }
        i2 = 0;
        while (i3 < this.bFd.length) {
            i2 += bci.m4837Q(this.bFd[i3]);
            i3++;
        }
        return (i + i2) + (this.bFd.length * 1);
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            int b;
            Object obj;
            int hN;
            Object obj2;
            switch (MF) {
                case 0:
                    break;
                case 8:
                    b = bcr.m4872b(com_fossil_bch, 8);
                    MF = this.bFc == null ? 0 : this.bFc.length;
                    obj = new long[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bFc, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = com_fossil_bch.MK();
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = com_fossil_bch.MK();
                    this.bFc = obj;
                    continue;
                case 10:
                    hN = com_fossil_bch.hN(com_fossil_bch.MJ());
                    b = com_fossil_bch.getPosition();
                    MF = 0;
                    while (com_fossil_bch.MO() > 0) {
                        com_fossil_bch.MK();
                        MF++;
                    }
                    com_fossil_bch.hP(b);
                    b = this.bFc == null ? 0 : this.bFc.length;
                    obj2 = new long[(MF + b)];
                    if (b != 0) {
                        System.arraycopy(this.bFc, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = com_fossil_bch.MK();
                        b++;
                    }
                    this.bFc = obj2;
                    com_fossil_bch.hO(hN);
                    continue;
                case 16:
                    b = bcr.m4872b(com_fossil_bch, 16);
                    MF = this.bFd == null ? 0 : this.bFd.length;
                    obj = new long[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bFd, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = com_fossil_bch.MK();
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = com_fossil_bch.MK();
                    this.bFd = obj;
                    continue;
                case 18:
                    hN = com_fossil_bch.hN(com_fossil_bch.MJ());
                    b = com_fossil_bch.getPosition();
                    MF = 0;
                    while (com_fossil_bch.MO() > 0) {
                        com_fossil_bch.MK();
                        MF++;
                    }
                    com_fossil_bch.hP(b);
                    b = this.bFd == null ? 0 : this.bFd.length;
                    obj2 = new long[(MF + b)];
                    if (b != 0) {
                        System.arraycopy(this.bFd, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = com_fossil_bch.MK();
                        b++;
                    }
                    this.bFd = obj2;
                    com_fossil_bch.hO(hN);
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
        if (this.bFc != null && this.bFc.length > 0) {
            for (long h : this.bFc) {
                com_fossil_bci.m4852h(1, h);
            }
        }
        if (this.bFd != null && this.bFd.length > 0) {
            while (i < this.bFd.length) {
                com_fossil_bci.m4852h(2, this.bFd[i]);
                i++;
            }
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsz)) {
            return false;
        }
        bsz com_fossil_bsz = (bsz) obj;
        return !bcn.equals(this.bFc, com_fossil_bsz.bFc) ? false : !bcn.equals(this.bFd, com_fossil_bsz.bFd) ? false : (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsz.bqp == null || com_fossil_bsz.bqp.isEmpty() : this.bqp.equals(com_fossil_bsz.bqp);
    }

    public final int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + bcn.hashCode(this.bFc)) * 31) + bcn.hashCode(this.bFd)) * 31;
        int hashCode2 = (this.bqp == null || this.bqp.isEmpty()) ? 0 : this.bqp.hashCode();
        return hashCode2 + hashCode;
    }
}
