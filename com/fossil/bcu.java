package com.fossil;

import com.google.android.gms.internal.ado;
import java.io.IOException;

public final class bcu extends bcj<bcu> {
    public String[] bra;
    public int[] brb;
    public byte[][] brc;

    public bcu() {
        this.bra = bcr.bqJ;
        this.brb = bcr.bqE;
        this.brc = bcr.bqK;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bcu ah(byte[] bArr) throws ado {
        return (bcu) bco.m4856a(new bcu(), bArr);
    }

    protected final int MR() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int MR = super.MR();
        if (this.bra == null || this.bra.length <= 0) {
            i = MR;
        } else {
            i2 = 0;
            i3 = 0;
            for (String str : this.bra) {
                if (str != null) {
                    i3++;
                    i2 += bci.dF(str);
                }
            }
            i = (MR + i2) + (i3 * 1);
        }
        if (this.brb != null && this.brb.length > 0) {
            i3 = 0;
            for (int MR2 : this.brb) {
                i3 += bci.hR(MR2);
            }
            i = (i + i3) + (this.brb.length * 1);
        }
        if (this.brc == null || this.brc.length <= 0) {
            return i;
        }
        i2 = 0;
        i3 = 0;
        while (i4 < this.brc.length) {
            byte[] bArr = this.brc[i4];
            if (bArr != null) {
                i3++;
                i2 += bci.ae(bArr);
            }
            i4++;
        }
        return (i + i2) + (i3 * 1);
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            int b;
            Object obj;
            switch (MF) {
                case 0:
                    break;
                case 10:
                    b = bcr.m4872b(com_fossil_bch, 10);
                    MF = this.bra == null ? 0 : this.bra.length;
                    obj = new String[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bra, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = com_fossil_bch.readString();
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = com_fossil_bch.readString();
                    this.bra = obj;
                    continue;
                case 16:
                    b = bcr.m4872b(com_fossil_bch, 16);
                    MF = this.brb == null ? 0 : this.brb.length;
                    obj = new int[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.brb, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = com_fossil_bch.MJ();
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = com_fossil_bch.MJ();
                    this.brb = obj;
                    continue;
                case 18:
                    int hN = com_fossil_bch.hN(com_fossil_bch.MJ());
                    b = com_fossil_bch.getPosition();
                    MF = 0;
                    while (com_fossil_bch.MO() > 0) {
                        com_fossil_bch.MJ();
                        MF++;
                    }
                    com_fossil_bch.hP(b);
                    b = this.brb == null ? 0 : this.brb.length;
                    Object obj2 = new int[(MF + b)];
                    if (b != 0) {
                        System.arraycopy(this.brb, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = com_fossil_bch.MJ();
                        b++;
                    }
                    this.brb = obj2;
                    com_fossil_bch.hO(hN);
                    continue;
                case 26:
                    b = bcr.m4872b(com_fossil_bch, 26);
                    MF = this.brc == null ? 0 : this.brc.length;
                    obj = new byte[(b + MF)][];
                    if (MF != 0) {
                        System.arraycopy(this.brc, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = com_fossil_bch.readBytes();
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = com_fossil_bch.readBytes();
                    this.brc = obj;
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
        if (this.bra != null && this.bra.length > 0) {
            for (String str : this.bra) {
                if (str != null) {
                    com_fossil_bci.m4854j(1, str);
                }
            }
        }
        if (this.brb != null && this.brb.length > 0) {
            for (int bL : this.brb) {
                com_fossil_bci.bL(2, bL);
            }
        }
        if (this.brc != null && this.brc.length > 0) {
            while (i < this.brc.length) {
                byte[] bArr = this.brc[i];
                if (bArr != null) {
                    com_fossil_bci.m4850c(3, bArr);
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
        if (!(obj instanceof bcu)) {
            return false;
        }
        bcu com_fossil_bcu = (bcu) obj;
        return !bcn.equals(this.bra, com_fossil_bcu.bra) ? false : !bcn.equals(this.brb, com_fossil_bcu.brb) ? false : !bcn.m4868a(this.brc, com_fossil_bcu.brc) ? false : (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bcu.bqp == null || com_fossil_bcu.bqp.isEmpty() : this.bqp.equals(com_fossil_bcu.bqp);
    }

    public final int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + bcn.hashCode(this.bra)) * 31) + bcn.hashCode(this.brb)) * 31) + bcn.m4866a(this.brc)) * 31;
        int hashCode2 = (this.bqp == null || this.bqp.isEmpty()) ? 0 : this.bqp.hashCode();
        return hashCode2 + hashCode;
    }
}
