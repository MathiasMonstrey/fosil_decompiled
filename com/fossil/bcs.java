package com.fossil;

import java.io.IOException;

public final class bcs extends bco {
    private static volatile bcs[] bqM;
    public String bqN;

    public bcs() {
        this.bqN = "";
        this.bqy = -1;
    }

    public static bcs[] MX() {
        if (bqM == null) {
            synchronized (bcn.bqx) {
                if (bqM == null) {
                    bqM = new bcs[0];
                }
            }
        }
        return bqM;
    }

    protected final int MR() {
        int MR = super.MR();
        return (this.bqN == null || this.bqN.equals("")) ? MR : MR + bci.m4845k(1, this.bqN);
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
        super.mo1264a(com_fossil_bci);
    }
}
