package com.fossil;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.view.ViewGroup;

public class cp extends dr {
    public cp(int i) {
        super(true);
        if (VERSION.SDK_INT >= 19) {
            if (i > 0) {
                this.Gc = new cr(this, i);
            } else {
                this.Gc = new cr(this);
            }
        } else if (i > 0) {
            this.Gc = new cq(this, i);
        } else {
            this.Gc = new cq(this);
        }
    }

    public cp() {
        this(-1);
    }

    public void mo1118b(dn dnVar) {
        this.Gc.mo1888b(dnVar);
    }

    public void mo1117a(dn dnVar) {
        this.Gc.mo1886a(dnVar);
    }

    public Animator mo1116a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
        return this.Gc.mo1884a(viewGroup, dnVar, dnVar2);
    }
}
