package com.fossil;

public final class dwy extends dvm {
    private final dve dwf;
    private final etj dyk;

    public dwy(dve com_fossil_dve, etj com_fossil_etj) {
        this.dwf = com_fossil_dve;
        this.dyk = com_fossil_etj;
    }

    public dvh contentType() {
        String str = this.dwf.get("Content-Type");
        return str != null ? dvh.kJ(str) : null;
    }

    public long contentLength() {
        return dwx.m10240d(this.dwf);
    }

    public etj azH() {
        return this.dyk;
    }
}
