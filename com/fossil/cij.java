package com.fossil;

public class cij extends cih implements Comparable {
    private long cdT;
    private long cdU;
    private cik cdV;

    public cij(long j, long j2) {
        super(j + "_" + j2);
        this.cdU = j;
        this.cdT = j2;
    }

    public int compareTo(Object obj) {
        cij com_fossil_cij = (cij) obj;
        if (this.cdT > com_fossil_cij.Yw()) {
            return 1;
        }
        if (this.cdT == com_fossil_cij.Yw()) {
            return 0;
        }
        return -1;
    }

    public long Yw() {
        return this.cdT;
    }

    public void az(long j) {
        this.cdT = j;
    }

    public long Yx() {
        return this.cdU;
    }

    public void m6510a(cik com_fossil_cik) {
        this.cdV = com_fossil_cik;
    }
}
