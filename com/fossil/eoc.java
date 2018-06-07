package com.fossil;

public class eoc implements eoa {
    private final long dOP;
    private final int dOQ;

    public eoc(long j, int i) {
        this.dOP = j;
        this.dOQ = i;
    }

    public long eS(int i) {
        return (long) (((double) this.dOP) * Math.pow((double) this.dOQ, (double) i));
    }
}
