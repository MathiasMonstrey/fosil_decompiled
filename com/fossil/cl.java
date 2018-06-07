package com.fossil;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.view.ViewGroup;

public class cl extends cw {
    public cl() {
        super(true);
        if (VERSION.SDK_INT < 19) {
            this.Gc = new cm(this);
        } else {
            this.Gc = new cn(this);
        }
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
