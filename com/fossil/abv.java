package com.fossil;

class abv {
    long aHA;
    private eoe aHB;

    public abv(eoe com_fossil_eoe) {
        if (com_fossil_eoe == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.aHB = com_fossil_eoe;
    }

    public boolean m2897A(long j) {
        return j - this.aHA >= 1000000 * this.aHB.aFM();
    }

    public void m2898B(long j) {
        this.aHA = j;
        this.aHB = this.aHB.aFN();
    }

    public void reset() {
        this.aHA = 0;
        this.aHB = this.aHB.aFO();
    }
}
