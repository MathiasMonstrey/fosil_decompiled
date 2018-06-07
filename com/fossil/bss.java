package com.fossil;

import java.io.IOException;

public final class bss extends bcj<bss> {
    public Long bEh;
    private Integer bEi;
    public bst[] bEj;
    public bsr[] bEk;
    public bsl[] bEl;
    public String bxq;

    public bss() {
        this.bEh = null;
        this.bxq = null;
        this.bEi = null;
        this.bEj = bst.Sp();
        this.bEk = bsr.So();
        this.bEl = bsl.Sk();
        this.bqp = null;
        this.bqy = -1;
    }

    protected final int MR() {
        int i;
        int i2 = 0;
        int MR = super.MR();
        if (this.bEh != null) {
            MR += bci.m4844j(1, this.bEh.longValue());
        }
        if (this.bxq != null) {
            MR += bci.m4845k(2, this.bxq);
        }
        if (this.bEi != null) {
            MR += bci.bM(3, this.bEi.intValue());
        }
        if (this.bEj != null && this.bEj.length > 0) {
            i = MR;
            for (bco com_fossil_bco : this.bEj) {
                if (com_fossil_bco != null) {
                    i += bci.m4841b(4, com_fossil_bco);
                }
            }
            MR = i;
        }
        if (this.bEk != null && this.bEk.length > 0) {
            i = MR;
            for (bco com_fossil_bco2 : this.bEk) {
                if (com_fossil_bco2 != null) {
                    i += bci.m4841b(5, com_fossil_bco2);
                }
            }
            MR = i;
        }
        if (this.bEl != null && this.bEl.length > 0) {
            while (i2 < this.bEl.length) {
                bco com_fossil_bco3 = this.bEl[i2];
                if (com_fossil_bco3 != null) {
                    MR += bci.m4841b(6, com_fossil_bco3);
                }
                i2++;
            }
        }
        return MR;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            int b;
            Object obj;
            switch (MF) {
                case 0:
                    break;
                case 8:
                    this.bEh = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 18:
                    this.bxq = com_fossil_bch.readString();
                    continue;
                case 24:
                    this.bEi = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 34:
                    b = bcr.m4872b(com_fossil_bch, 34);
                    MF = this.bEj == null ? 0 : this.bEj.length;
                    obj = new bst[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bEj, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bst();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bst();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bEj = obj;
                    continue;
                case 42:
                    b = bcr.m4872b(com_fossil_bch, 42);
                    MF = this.bEk == null ? 0 : this.bEk.length;
                    obj = new bsr[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bEk, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bsr();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bsr();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bEk = obj;
                    continue;
                case 50:
                    b = bcr.m4872b(com_fossil_bch, 50);
                    MF = this.bEl == null ? 0 : this.bEl.length;
                    obj = new bsl[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bEl, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bsl();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bsl();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bEl = obj;
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
        if (this.bEh != null) {
            com_fossil_bci.m4853i(1, this.bEh.longValue());
        }
        if (this.bxq != null) {
            com_fossil_bci.m4854j(2, this.bxq);
        }
        if (this.bEi != null) {
            com_fossil_bci.bL(3, this.bEi.intValue());
        }
        if (this.bEj != null && this.bEj.length > 0) {
            for (bco com_fossil_bco : this.bEj) {
                if (com_fossil_bco != null) {
                    com_fossil_bci.m4848a(4, com_fossil_bco);
                }
            }
        }
        if (this.bEk != null && this.bEk.length > 0) {
            for (bco com_fossil_bco2 : this.bEk) {
                if (com_fossil_bco2 != null) {
                    com_fossil_bci.m4848a(5, com_fossil_bco2);
                }
            }
        }
        if (this.bEl != null && this.bEl.length > 0) {
            while (i < this.bEl.length) {
                bco com_fossil_bco3 = this.bEl[i];
                if (com_fossil_bco3 != null) {
                    com_fossil_bci.m4848a(6, com_fossil_bco3);
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
        if (!(obj instanceof bss)) {
            return false;
        }
        bss com_fossil_bss = (bss) obj;
        if (this.bEh == null) {
            if (com_fossil_bss.bEh != null) {
                return false;
            }
        } else if (!this.bEh.equals(com_fossil_bss.bEh)) {
            return false;
        }
        if (this.bxq == null) {
            if (com_fossil_bss.bxq != null) {
                return false;
            }
        } else if (!this.bxq.equals(com_fossil_bss.bxq)) {
            return false;
        }
        if (this.bEi == null) {
            if (com_fossil_bss.bEi != null) {
                return false;
            }
        } else if (!this.bEi.equals(com_fossil_bss.bEi)) {
            return false;
        }
        return !bcn.equals(this.bEj, com_fossil_bss.bEj) ? false : !bcn.equals(this.bEk, com_fossil_bss.bEk) ? false : !bcn.equals(this.bEl, com_fossil_bss.bEl) ? false : (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bss.bqp == null || com_fossil_bss.bqp.isEmpty() : this.bqp.equals(com_fossil_bss.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.bEi == null ? 0 : this.bEi.hashCode()) + (((this.bxq == null ? 0 : this.bxq.hashCode()) + (((this.bEh == null ? 0 : this.bEh.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + bcn.hashCode(this.bEj)) * 31) + bcn.hashCode(this.bEk)) * 31) + bcn.hashCode(this.bEl)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
