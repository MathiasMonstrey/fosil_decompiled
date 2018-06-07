package com.fossil;

import com.fossil.C1547f.C3554a;

public class C1548a implements C1547f {
    private transient C3640h nV;

    public void m2794a(C3554a c3554a) {
        synchronized (this) {
            if (this.nV == null) {
                this.nV = new C3640h();
            }
        }
        this.nV.add(c3554a);
    }

    public void m2795b(C3554a c3554a) {
        synchronized (this) {
            if (this.nV == null) {
                return;
            }
            this.nV.remove(c3554a);
        }
    }

    public void ds() {
        synchronized (this) {
            if (this.nV == null) {
                return;
            }
            this.nV.m4765a(this, 0, null);
        }
    }

    public void m2796n(int i) {
        synchronized (this) {
            if (this.nV == null) {
                return;
            }
            this.nV.m4765a(this, i, null);
        }
    }
}
