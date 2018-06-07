package com.fossil;

import java.io.IOException;

public final class bst extends bcj<bst> {
    private static volatile bst[] bEm;
    public String key;
    public String value;

    public bst() {
        this.key = null;
        this.value = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bst[] Sp() {
        if (bEm == null) {
            synchronized (bcn.bqx) {
                if (bEm == null) {
                    bEm = new bst[0];
                }
            }
        }
        return bEm;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.key != null) {
            MR += bci.m4845k(1, this.key);
        }
        return this.value != null ? MR + bci.m4845k(2, this.value) : MR;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 10:
                    this.key = com_fossil_bch.readString();
                    continue;
                case 18:
                    this.value = com_fossil_bch.readString();
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
        if (this.key != null) {
            com_fossil_bci.m4854j(1, this.key);
        }
        if (this.value != null) {
            com_fossil_bci.m4854j(2, this.value);
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bst)) {
            return false;
        }
        bst com_fossil_bst = (bst) obj;
        if (this.key == null) {
            if (com_fossil_bst.key != null) {
                return false;
            }
        } else if (!this.key.equals(com_fossil_bst.key)) {
            return false;
        }
        if (this.value == null) {
            if (com_fossil_bst.value != null) {
                return false;
            }
        } else if (!this.value.equals(com_fossil_bst.value)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bst.bqp == null || com_fossil_bst.bqp.isEmpty() : this.bqp.equals(com_fossil_bst.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
