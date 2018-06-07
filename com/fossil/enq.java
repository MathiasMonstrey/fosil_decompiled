package com.fossil;

import android.os.SystemClock;
import android.util.Log;

public class enq {
    private final String dOl;
    private long dOm;
    private final boolean disabled;
    private long duration;
    private final String tag;

    public enq(String str, String str2) {
        this.dOl = str;
        this.tag = str2;
        this.disabled = !Log.isLoggable(str2, 2);
    }

    public synchronized void aFE() {
        if (!this.disabled) {
            this.dOm = SystemClock.elapsedRealtime();
            this.duration = 0;
        }
    }

    public synchronized void aFF() {
        if (!this.disabled) {
            if (this.duration == 0) {
                this.duration = SystemClock.elapsedRealtime() - this.dOm;
                aFG();
            }
        }
    }

    private void aFG() {
        Log.v(this.tag, this.dOl + ": " + this.duration + "ms");
    }
}
