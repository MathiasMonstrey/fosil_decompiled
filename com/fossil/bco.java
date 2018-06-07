package com.fossil;

import com.google.android.gms.internal.ado;
import java.io.IOException;

public abstract class bco {
    protected volatile int bqy = -1;

    public static final <T extends bco> T m4856a(T t, byte[] bArr) throws ado {
        return m4857a(t, bArr, 0, bArr.length);
    }

    private static <T extends bco> T m4857a(T t, byte[] bArr, int i, int i2) throws ado {
        try {
            bch g = bch.m4834g(bArr, 0, i2);
            t.mo1266a(g);
            g.hL(0);
            return t;
        } catch (ado e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    protected int MR() {
        return 0;
    }

    public bco MT() throws CloneNotSupportedException {
        return (bco) super.clone();
    }

    public final int MV() {
        if (this.bqy < 0) {
            MW();
        }
        return this.bqy;
    }

    public final int MW() {
        int MR = MR();
        this.bqy = MR;
        return MR;
    }

    public abstract bco mo1266a(bch com_fossil_bch) throws IOException;

    public void mo1264a(bci com_fossil_bci) throws IOException {
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return MT();
    }

    public String toString() {
        return bcp.m4871c(this);
    }
}
