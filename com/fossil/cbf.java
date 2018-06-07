package com.fossil;

public final class cbf implements cas {
    private cau bKU;
    private int bfw;

    public cbf(cas com_fossil_cas) {
        this.bfw = com_fossil_cas.getType();
        this.bKU = (cau) com_fossil_cas.TT().freeze();
    }

    public final cau TT() {
        return this.bKU;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int getType() {
        return this.bfw;
    }

    public final String toString() {
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(TT());
        return new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(valueOf).length()).append("DataEventEntity{ type=").append(str).append(", dataitem=").append(valueOf).append(" }").toString();
    }
}
