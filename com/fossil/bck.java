package com.fossil;

public final class bck<M extends bcj<M>, T> {
    protected final Class<T> bqq;
    public final int tag;
    private int type;

    protected final void m4862a(Object obj, bci com_fossil_bci) {
        try {
            com_fossil_bci.hU(this.tag);
            switch (this.type) {
                case 10:
                    int i = this.tag >>> 3;
                    ((bco) obj).mo1264a(com_fossil_bci);
                    com_fossil_bci.bN(i, 4);
                    return;
                case 11:
                    com_fossil_bci.m4849b((bco) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected final int bV(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (bci.hT(i) << 1) + ((bco) obj).MW();
            case 11:
                return bci.m4841b(i, (bco) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bck)) {
            return false;
        }
        bck com_fossil_bck = (bck) obj;
        return this.type == com_fossil_bck.type && this.bqq == com_fossil_bck.bqq && this.tag == com_fossil_bck.tag;
    }

    public final int hashCode() {
        return (((((this.type + 1147) * 31) + this.bqq.hashCode()) * 31) + this.tag) * 31;
    }
}
