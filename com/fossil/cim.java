package com.fossil;

import java.util.Calendar;

public class cim extends cig {
    cip cea;
    private long startTime = Calendar.getInstance().getTimeInMillis();

    public cim(float f) {
        super(f);
    }

    public cip YC() {
        return this.cea;
    }

    public void m6511a(cip com_fossil_cip) {
        this.cea = com_fossil_cip;
    }

    public long getStartTime() {
        return this.startTime;
    }
}
