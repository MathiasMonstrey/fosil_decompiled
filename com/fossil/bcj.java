package com.fossil;

import java.io.IOException;

public abstract class bcj<M extends bcj<M>> extends bco {
    protected bcl bqp;

    protected int MR() {
        int i = 0;
        if (this.bqp == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.bqp.size()) {
            i2 += this.bqp.hX(i).MR();
            i++;
        }
        return i2;
    }

    public M MS() throws CloneNotSupportedException {
        bcj com_fossil_bcj = (bcj) super.MT();
        bcn.m4867a(this, com_fossil_bcj);
        return com_fossil_bcj;
    }

    public /* synthetic */ bco MT() throws CloneNotSupportedException {
        return (bcj) clone();
    }

    public void mo1264a(bci com_fossil_bci) throws IOException {
        if (this.bqp != null) {
            for (int i = 0; i < this.bqp.size(); i++) {
                this.bqp.hX(i).m4864a(com_fossil_bci);
            }
        }
    }

    protected final boolean m4861a(bch com_fossil_bch, int i) throws IOException {
        int position = com_fossil_bch.getPosition();
        if (!com_fossil_bch.hM(i)) {
            return false;
        }
        int i2 = i >>> 3;
        bcq com_fossil_bcq = new bcq(i, com_fossil_bch.bJ(position, com_fossil_bch.getPosition() - position));
        bcm com_fossil_bcm = null;
        if (this.bqp == null) {
            this.bqp = new bcl();
        } else {
            com_fossil_bcm = this.bqp.hW(i2);
        }
        if (com_fossil_bcm == null) {
            com_fossil_bcm = new bcm();
            this.bqp.m4863a(i2, com_fossil_bcm);
        }
        com_fossil_bcm.m4865a(com_fossil_bcq);
        return true;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return MS();
    }
}
