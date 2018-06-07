package com.fossil;

import java.io.IOException;

public final class bsx extends bcj<bsx> {
    public bsy[] bEx;

    public bsx() {
        this.bEx = bsy.St();
        this.bqp = null;
        this.bqy = -1;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.bEx != null && this.bEx.length > 0) {
            for (bco com_fossil_bco : this.bEx) {
                if (com_fossil_bco != null) {
                    MR += bci.m4841b(1, com_fossil_bco);
                }
            }
        }
        return MR;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 10:
                    int b = bcr.m4872b(com_fossil_bch, 10);
                    MF = this.bEx == null ? 0 : this.bEx.length;
                    Object obj = new bsy[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bEx, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bsy();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bsy();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bEx = obj;
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
        if (this.bEx != null && this.bEx.length > 0) {
            for (bco com_fossil_bco : this.bEx) {
                if (com_fossil_bco != null) {
                    com_fossil_bci.m4848a(1, com_fossil_bco);
                }
            }
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsx)) {
            return false;
        }
        bsx com_fossil_bsx = (bsx) obj;
        return !bcn.equals(this.bEx, com_fossil_bsx.bEx) ? false : (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsx.bqp == null || com_fossil_bsx.bqp.isEmpty() : this.bqp.equals(com_fossil_bsx.bqp);
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + bcn.hashCode(this.bEx)) * 31;
        int hashCode2 = (this.bqp == null || this.bqp.isEmpty()) ? 0 : this.bqp.hashCode();
        return hashCode2 + hashCode;
    }
}
