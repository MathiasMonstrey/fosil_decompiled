package com.fossil;

import java.io.IOException;

public final class bsr extends bcj<bsr> {
    private static volatile bsr[] bEe;
    public Boolean bEf;
    public Boolean bEg;
    public String name;

    public bsr() {
        this.name = null;
        this.bEf = null;
        this.bEg = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bsr[] So() {
        if (bEe == null) {
            synchronized (bcn.bqx) {
                if (bEe == null) {
                    bEe = new bsr[0];
                }
            }
        }
        return bEe;
    }

    protected final int MR() {
        int MR = super.MR();
        if (this.name != null) {
            MR += bci.m4845k(1, this.name);
        }
        if (this.bEf != null) {
            this.bEf.booleanValue();
            MR += bci.hT(2) + 1;
        }
        if (this.bEg == null) {
            return MR;
        }
        this.bEg.booleanValue();
        return MR + (bci.hT(3) + 1);
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            switch (MF) {
                case 0:
                    break;
                case 10:
                    this.name = com_fossil_bch.readString();
                    continue;
                case 16:
                    this.bEf = Boolean.valueOf(com_fossil_bch.MI());
                    continue;
                case 24:
                    this.bEg = Boolean.valueOf(com_fossil_bch.MI());
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
        if (this.name != null) {
            com_fossil_bci.m4854j(1, this.name);
        }
        if (this.bEf != null) {
            com_fossil_bci.m4855r(2, this.bEf.booleanValue());
        }
        if (this.bEg != null) {
            com_fossil_bci.m4855r(3, this.bEg.booleanValue());
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsr)) {
            return false;
        }
        bsr com_fossil_bsr = (bsr) obj;
        if (this.name == null) {
            if (com_fossil_bsr.name != null) {
                return false;
            }
        } else if (!this.name.equals(com_fossil_bsr.name)) {
            return false;
        }
        if (this.bEf == null) {
            if (com_fossil_bsr.bEf != null) {
                return false;
            }
        } else if (!this.bEf.equals(com_fossil_bsr.bEf)) {
            return false;
        }
        if (this.bEg == null) {
            if (com_fossil_bsr.bEg != null) {
                return false;
            }
        } else if (!this.bEg.equals(com_fossil_bsr.bEg)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsr.bqp == null || com_fossil_bsr.bqp.isEmpty() : this.bqp.equals(com_fossil_bsr.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.bEg == null ? 0 : this.bEg.hashCode()) + (((this.bEf == null ? 0 : this.bEf.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
