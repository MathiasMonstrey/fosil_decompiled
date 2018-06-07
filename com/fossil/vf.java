package com.fossil;

import android.os.Looper;

class vf<Z> implements vh<Z> {
    private ul aBK;
    private final vh<Z> aBP;
    private C4151a aCc;
    private int aCd;
    private boolean aCe;
    private final boolean ayq;

    interface C4151a {
        void mo4198b(ul ulVar, vf<?> vfVar);
    }

    vf(vh<Z> vhVar, boolean z) {
        if (vhVar == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.aBP = vhVar;
        this.ayq = z;
    }

    void m13902a(ul ulVar, C4151a c4151a) {
        this.aBK = ulVar;
        this.aCc = c4151a;
    }

    boolean uV() {
        return this.ayq;
    }

    public Z get() {
        return this.aBP.get();
    }

    public int getSize() {
        return this.aBP.getSize();
    }

    public void recycle() {
        if (this.aCd > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (this.aCe) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else {
            this.aCe = true;
            this.aBP.recycle();
        }
    }

    void acquire() {
        if (this.aCe) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.aCd++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    void release() {
        if (this.aCd <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.aCd - 1;
            this.aCd = i;
            if (i == 0) {
                this.aCc.mo4198b(this.aBK, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }
}
