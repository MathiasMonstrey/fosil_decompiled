package com.fossil;

public class eoe {
    private final eoa aHx;
    private final int dOR;
    private final eod dOS;

    public eoe(eoa com_fossil_eoa, eod com_fossil_eod) {
        this(0, com_fossil_eoa, com_fossil_eod);
    }

    public eoe(int i, eoa com_fossil_eoa, eod com_fossil_eod) {
        this.dOR = i;
        this.aHx = com_fossil_eoa;
        this.dOS = com_fossil_eod;
    }

    public long aFM() {
        return this.aHx.eS(this.dOR);
    }

    public eoe aFN() {
        return new eoe(this.dOR + 1, this.aHx, this.dOS);
    }

    public eoe aFO() {
        return new eoe(this.aHx, this.dOS);
    }
}
