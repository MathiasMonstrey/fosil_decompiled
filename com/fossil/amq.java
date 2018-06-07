package com.fossil;

public abstract class amq<T> {
    protected T aVV;
    protected C1709a<T> aVW;
    protected C1709a<T> aVX;
    protected int aVY;

    static final class C1709a<T> {
        final T aVZ;
        final int aWa;
        C1709a<T> aWb;

        public C1709a(T t, int i) {
            this.aVZ = t;
            this.aWa = i;
        }

        public T getData() {
            return this.aVZ;
        }

        public int m3892n(T t, int i) {
            System.arraycopy(this.aVZ, 0, t, i, this.aWa);
            return this.aWa + i;
        }

        public C1709a<T> Ht() {
            return this.aWb;
        }

        public void m3891a(C1709a<T> c1709a) {
            if (this.aWb != null) {
                throw new IllegalStateException();
            }
            this.aWb = c1709a;
        }
    }

    protected abstract T gV(int i);

    protected amq() {
    }

    public int Hq() {
        return this.aVY;
    }

    public T Hs() {
        Hr();
        return this.aVV == null ? gV(12) : this.aVV;
    }

    public final T m3834l(T t, int i) {
        int i2;
        C1709a c1709a = new C1709a(t, i);
        if (this.aVW == null) {
            this.aVX = c1709a;
            this.aVW = c1709a;
        } else {
            this.aVX.m3891a(c1709a);
            this.aVX = c1709a;
        }
        this.aVY += i;
        if (i < 16384) {
            i2 = i + i;
        } else {
            i2 = (i >> 2) + i;
        }
        return gV(i2);
    }

    public T m3835m(T t, int i) {
        int i2 = i + this.aVY;
        T gV = gV(i2);
        int i3 = 0;
        for (C1709a c1709a = this.aVW; c1709a != null; c1709a = c1709a.Ht()) {
            i3 = c1709a.m3892n(gV, i3);
        }
        System.arraycopy(t, 0, gV, i3, i);
        int i4 = i3 + i;
        if (i4 == i2) {
            return gV;
        }
        throw new IllegalStateException("Should have gotten " + i2 + " entries, got " + i4);
    }

    protected void Hr() {
        if (this.aVX != null) {
            this.aVV = this.aVX.getData();
        }
        this.aVX = null;
        this.aVW = null;
        this.aVY = 0;
    }
}
