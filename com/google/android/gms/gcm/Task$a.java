package com.google.android.gms.gcm;

import android.os.Bundle;
import com.fossil.awa;
import com.fossil.bbm;
import com.fossil.bbx;

public abstract class Task$a {
    protected boolean bpA;
    protected boolean bpB;
    protected boolean bpC;
    protected bbx bpD = bbx.bpH;
    protected int bpy;
    protected String bpz;
    protected Bundle extras;
    protected String tag;

    protected void Mw() {
        awa.b(this.bpz != null, "Must provide an endpoint for this task by calling setService(ComponentName).");
        bbm.dz(this.tag);
        bbx com_fossil_bbx = this.bpD;
        if (com_fossil_bbx != null) {
            int My = com_fossil_bbx.My();
            if (My == 1 || My == 0) {
                int Mz = com_fossil_bbx.Mz();
                int MA = com_fossil_bbx.MA();
                if (My == 0 && Mz < 0) {
                    throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + Mz);
                } else if (My == 1 && Mz < 10) {
                    throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
                } else if (MA < Mz) {
                    throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + com_fossil_bbx.MA());
                }
            }
            throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + My);
        }
        if (this.bpB) {
            Task.q(this.extras);
        }
    }
}
