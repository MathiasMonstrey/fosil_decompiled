package com.fossil;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Build.VERSION;
import android.view.ViewGroup;

public abstract class cw implements da {
    cz Gc;

    public cw() {
        this(false);
    }

    cw(boolean z) {
        if (!z) {
            if (VERSION.SDK_INT >= 23) {
                this.Gc = new cx();
            } else if (VERSION.SDK_INT >= 19) {
                this.Gc = new db();
            } else {
                this.Gc = new cy();
            }
            this.Gc.m7049a((da) this);
        }
    }

    public Animator mo1116a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
        return null;
    }

    public cw m4139i(long j) {
        this.Gc.mo1889j(j);
        return this;
    }

    public cw m4138a(TimeInterpolator timeInterpolator) {
        this.Gc.mo1887b(timeInterpolator);
        return this;
    }

    public String toString() {
        return this.Gc.toString();
    }
}
