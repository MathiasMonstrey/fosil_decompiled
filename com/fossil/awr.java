package com.fossil;

import android.util.Log;

public abstract class awr<TListener> {
    private /* synthetic */ awm bix;
    private TListener biy;
    private boolean biz = false;

    public awr(awm com_fossil_awm, TListener tListener) {
        this.bix = com_fossil_awm;
        this.biy = tListener;
    }

    public final void Lr() {
        synchronized (this) {
            Object obj = this.biy;
            if (this.biz) {
                String valueOf = String.valueOf(this);
                Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
            }
        }
        if (obj != null) {
            try {
                bP(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.biz = true;
        }
        unregister();
    }

    protected abstract void bP(TListener tListener);

    public final void iH() {
        synchronized (this) {
            this.biy = null;
        }
    }

    public final void unregister() {
        iH();
        synchronized (this.bix.bil) {
            this.bix.bil.remove(this);
        }
    }
}
