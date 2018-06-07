package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.google.android.gms.internal.ado;
import java.io.IOException;

public final class bch {
    private int bqf;
    private int bqg;
    private int bqh;
    private int bqi;
    private int bqj;
    private int bqk = Integer.MAX_VALUE;
    private int bql;
    private int bqm = 64;
    private int bqn = 67108864;
    private final byte[] buffer;

    private bch(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.bqf = i;
        this.bqg = i + i2;
        this.bqi = i;
    }

    private final void MN() {
        this.bqg += this.bqh;
        int i = this.bqg;
        if (i > this.bqk) {
            this.bqh = i - this.bqk;
            this.bqg -= this.bqh;
            return;
        }
        this.bqh = 0;
    }

    private final byte MP() throws IOException {
        if (this.bqi == this.bqg) {
            throw ado.zzLQ();
        }
        byte[] bArr = this.buffer;
        int i = this.bqi;
        this.bqi = i + 1;
        return bArr[i];
    }

    public static bch m4834g(byte[] bArr, int i, int i2) {
        return new bch(bArr, 0, i2);
    }

    private final void hQ(int i) throws IOException {
        if (i < 0) {
            throw ado.zzLR();
        } else if (this.bqi + i > this.bqk) {
            hQ(this.bqk - this.bqi);
            throw ado.zzLQ();
        } else if (i <= this.bqg - this.bqi) {
            this.bqi += i;
        } else {
            throw ado.zzLQ();
        }
    }

    public final int MF() throws IOException {
        if (this.bqi == this.bqg) {
            this.bqj = 0;
            return 0;
        }
        this.bqj = MJ();
        if (this.bqj != 0) {
            return this.bqj;
        }
        throw new ado("Protocol message contained an invalid tag (zero).");
    }

    public final long MG() throws IOException {
        return MK();
    }

    public final int MH() throws IOException {
        return MJ();
    }

    public final boolean MI() throws IOException {
        return MJ() != 0;
    }

    public final int MJ() throws IOException {
        byte MP = MP();
        if (MP >= (byte) 0) {
            return MP;
        }
        int i = MP & 127;
        byte MP2 = MP();
        if (MP2 >= (byte) 0) {
            return i | (MP2 << 7);
        }
        i |= (MP2 & 127) << 7;
        MP2 = MP();
        if (MP2 >= (byte) 0) {
            return i | (MP2 << 14);
        }
        i |= (MP2 & 127) << 14;
        MP2 = MP();
        if (MP2 >= (byte) 0) {
            return i | (MP2 << 21);
        }
        i |= (MP2 & 127) << 21;
        MP2 = MP();
        i |= MP2 << 28;
        if (MP2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (MP() >= (byte) 0) {
                return i;
            }
        }
        throw ado.zzLS();
    }

    public final long MK() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte MP = MP();
            j |= ((long) (MP & 127)) << i;
            if ((MP & Allocation.USAGE_SHARED) == 0) {
                return j;
            }
        }
        throw ado.zzLS();
    }

    public final int ML() throws IOException {
        return (((MP() & 255) | ((MP() & 255) << 8)) | ((MP() & 255) << 16)) | ((MP() & 255) << 24);
    }

    public final long MM() throws IOException {
        byte MP = MP();
        byte MP2 = MP();
        return ((((((((((long) MP2) & 255) << 8) | (((long) MP) & 255)) | ((((long) MP()) & 255) << 16)) | ((((long) MP()) & 255) << 24)) | ((((long) MP()) & 255) << 32)) | ((((long) MP()) & 255) << 40)) | ((((long) MP()) & 255) << 48)) | ((((long) MP()) & 255) << 56);
    }

    public final int MO() {
        if (this.bqk == Integer.MAX_VALUE) {
            return -1;
        }
        return this.bqk - this.bqi;
    }

    public final void m4835a(bco com_fossil_bco) throws IOException {
        int MJ = MJ();
        if (this.bql >= this.bqm) {
            throw ado.zzLT();
        }
        MJ = hN(MJ);
        this.bql++;
        com_fossil_bco.mo1266a(this);
        hL(0);
        this.bql--;
        hO(MJ);
    }

    public final byte[] bJ(int i, int i2) {
        if (i2 == 0) {
            return bcr.bqL;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.bqf + i, obj, 0, i2);
        return obj;
    }

    final void bK(int i, int i2) {
        if (i > this.bqi - this.bqf) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.bqi - this.bqf));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.bqi = this.bqf + i;
            this.bqj = i2;
        }
    }

    public final int getPosition() {
        return this.bqi - this.bqf;
    }

    public final void hL(int i) throws ado {
        if (this.bqj != i) {
            throw new ado("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean hM(int i) throws IOException {
        switch (i & 7) {
            case 0:
                MJ();
                return true;
            case 1:
                MM();
                return true;
            case 2:
                hQ(MJ());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                ML();
                return true;
            default:
                throw new ado("Protocol message tag had invalid wire type.");
        }
        int MF;
        do {
            MF = MF();
            if (MF != 0) {
            }
            hL(((i >>> 3) << 3) | 4);
            return true;
        } while (hM(MF));
        hL(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int hN(int i) throws ado {
        if (i < 0) {
            throw ado.zzLR();
        }
        int i2 = this.bqi + i;
        int i3 = this.bqk;
        if (i2 > i3) {
            throw ado.zzLQ();
        }
        this.bqk = i2;
        MN();
        return i3;
    }

    public final void hO(int i) {
        this.bqk = i;
        MN();
    }

    public final void hP(int i) {
        bK(i, this.bqj);
    }

    public final byte[] readBytes() throws IOException {
        int MJ = MJ();
        if (MJ < 0) {
            throw ado.zzLR();
        } else if (MJ == 0) {
            return bcr.bqL;
        } else {
            if (MJ > this.bqg - this.bqi) {
                throw ado.zzLQ();
            }
            Object obj = new byte[MJ];
            System.arraycopy(this.buffer, this.bqi, obj, 0, MJ);
            this.bqi = MJ + this.bqi;
            return obj;
        }
    }

    public final String readString() throws IOException {
        int MJ = MJ();
        if (MJ < 0) {
            throw ado.zzLR();
        } else if (MJ > this.bqg - this.bqi) {
            throw ado.zzLQ();
        } else {
            String str = new String(this.buffer, this.bqi, MJ, bcn.UTF_8);
            this.bqi = MJ + this.bqi;
            return str;
        }
    }
}
