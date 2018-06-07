package com.google.android.gms.gcm;

import android.os.Bundle;
import com.fossil.bbo;

public class OneoffTask$a extends Task$a {
    private long bpp;
    private long bpq;

    public OneoffTask$a() {
        this.bpp = -1;
        this.bpq = -1;
        this.bpB = false;
    }

    public OneoffTask$a m14246L(Class<? extends bbo> cls) {
        this.bpz = cls.getName();
        return this;
    }

    protected void Mw() {
        super.Mw();
        if (this.bpp == -1 || this.bpq == -1) {
            throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
        } else if (this.bpp >= this.bpq) {
            throw new IllegalArgumentException("Window start must be shorter than window end.");
        }
    }

    public OneoffTask Mx() {
        Mw();
        return new OneoffTask(this, null);
    }

    public OneoffTask$a m14247c(long j, long j2) {
        this.bpp = j;
        this.bpq = j2;
        return this;
    }

    public OneoffTask$a dC(String str) {
        this.tag = str;
        return this;
    }

    public OneoffTask$a hJ(int i) {
        this.bpy = i;
        return this;
    }

    public OneoffTask$a m14248p(Bundle bundle) {
        this.extras = bundle;
        return this;
    }
}
