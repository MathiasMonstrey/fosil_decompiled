package com.fossil;

import com.google.android.gms.internal.ado;
import java.io.IOException;

public final class bct extends bco {
    public String bqN;
    public String bqO;
    public long bqP;
    public String bqQ;
    public long bqR;
    public long bqS;
    public String bqT;
    public String bqU;
    public String bqV;
    public String bqW;
    public String bqX;
    public int bqY;
    public bcs[] bqZ;

    public bct() {
        this.bqN = "";
        this.bqO = "";
        this.bqP = 0;
        this.bqQ = "";
        this.bqR = 0;
        this.bqS = 0;
        this.bqT = "";
        this.bqU = "";
        this.bqV = "";
        this.bqW = "";
        this.bqX = "";
        this.bqY = 0;
        this.bqZ = bcs.MX();
        this.bqy = -1;
    }

    public static bct ag(byte[] bArr) throws ado {
        return (bct) bco.m4856a(new bct(), bArr);
    }

    protected final int MR() {
        int MR = super.MR();
        if (!(this.bqN == null || this.bqN.equals(""))) {
            MR += bci.m4845k(1, this.bqN);
        }
        if (!(this.bqO == null || this.bqO.equals(""))) {
            MR += bci.m4845k(2, this.bqO);
        }
        if (this.bqP != 0) {
            MR += bci.m4844j(3, this.bqP);
        }
        if (!(this.bqQ == null || this.bqQ.equals(""))) {
            MR += bci.m4845k(4, this.bqQ);
        }
        if (this.bqR != 0) {
            MR += bci.m4844j(5, this.bqR);
        }
        if (this.bqS != 0) {
            MR += bci.m4844j(6, this.bqS);
        }
        if (!(this.bqT == null || this.bqT.equals(""))) {
            MR += bci.m4845k(7, this.bqT);
        }
        if (!(this.bqU == null || this.bqU.equals(""))) {
            MR += bci.m4845k(8, this.bqU);
        }
        if (!(this.bqV == null || this.bqV.equals(""))) {
            MR += bci.m4845k(9, this.bqV);
        }
        if (!(this.bqW == null || this.bqW.equals(""))) {
            MR += bci.m4845k(10, this.bqW);
        }
        if (!(this.bqX == null || this.bqX.equals(""))) {
            MR += bci.m4845k(11, this.bqX);
        }
        if (this.bqY != 0) {
            MR += bci.bM(12, this.bqY);
        }
        if (this.bqZ == null || this.bqZ.length <= 0) {
            return MR;
        }
        int i = MR;
        for (bco com_fossil_bco : this.bqZ) {
            if (com_fossil_bco != null) {
                i += bci.m4841b(13, com_fossil_bco);
            }
        }
        return i;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 10:
                    this.bqN = com_fossil_bch.readString();
                    continue;
                case 18:
                    this.bqO = com_fossil_bch.readString();
                    continue;
                case 24:
                    this.bqP = com_fossil_bch.MG();
                    continue;
                case 34:
                    this.bqQ = com_fossil_bch.readString();
                    continue;
                case 40:
                    this.bqR = com_fossil_bch.MG();
                    continue;
                case 48:
                    this.bqS = com_fossil_bch.MG();
                    continue;
                case 58:
                    this.bqT = com_fossil_bch.readString();
                    continue;
                case 66:
                    this.bqU = com_fossil_bch.readString();
                    continue;
                case 74:
                    this.bqV = com_fossil_bch.readString();
                    continue;
                case 82:
                    this.bqW = com_fossil_bch.readString();
                    continue;
                case 90:
                    this.bqX = com_fossil_bch.readString();
                    continue;
                case 96:
                    this.bqY = com_fossil_bch.MH();
                    continue;
                case 106:
                    int b = bcr.m4872b(com_fossil_bch, 106);
                    MF = this.bqZ == null ? 0 : this.bqZ.length;
                    Object obj = new bcs[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bqZ, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bcs();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bcs();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bqZ = obj;
                    continue;
                default:
                    if (!com_fossil_bch.hM(MF)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final void mo1264a(bci com_fossil_bci) throws IOException {
        if (!(this.bqN == null || this.bqN.equals(""))) {
            com_fossil_bci.m4854j(1, this.bqN);
        }
        if (!(this.bqO == null || this.bqO.equals(""))) {
            com_fossil_bci.m4854j(2, this.bqO);
        }
        if (this.bqP != 0) {
            com_fossil_bci.m4853i(3, this.bqP);
        }
        if (!(this.bqQ == null || this.bqQ.equals(""))) {
            com_fossil_bci.m4854j(4, this.bqQ);
        }
        if (this.bqR != 0) {
            com_fossil_bci.m4853i(5, this.bqR);
        }
        if (this.bqS != 0) {
            com_fossil_bci.m4853i(6, this.bqS);
        }
        if (!(this.bqT == null || this.bqT.equals(""))) {
            com_fossil_bci.m4854j(7, this.bqT);
        }
        if (!(this.bqU == null || this.bqU.equals(""))) {
            com_fossil_bci.m4854j(8, this.bqU);
        }
        if (!(this.bqV == null || this.bqV.equals(""))) {
            com_fossil_bci.m4854j(9, this.bqV);
        }
        if (!(this.bqW == null || this.bqW.equals(""))) {
            com_fossil_bci.m4854j(10, this.bqW);
        }
        if (!(this.bqX == null || this.bqX.equals(""))) {
            com_fossil_bci.m4854j(11, this.bqX);
        }
        if (this.bqY != 0) {
            com_fossil_bci.bL(12, this.bqY);
        }
        if (this.bqZ != null && this.bqZ.length > 0) {
            for (bco com_fossil_bco : this.bqZ) {
                if (com_fossil_bco != null) {
                    com_fossil_bci.m4848a(13, com_fossil_bco);
                }
            }
        }
        super.mo1264a(com_fossil_bci);
    }
}
