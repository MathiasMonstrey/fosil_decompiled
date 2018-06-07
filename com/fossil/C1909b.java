package com.fossil;

import java.util.ArrayList;
import java.util.List;

public class C1909b<C, T, A> implements Cloneable {
    private List<C> nW = new ArrayList();
    private long nX = 0;
    private long[] nY;
    private int nZ;
    private final C1908a<C, T, A> oa;

    public static abstract class C1908a<C, T, A> {
        public abstract void mo3136a(C c, T t, int i, A a);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return dt();
    }

    public C1909b(C1908a<C, T, A> c1908a) {
        this.oa = c1908a;
    }

    public synchronized void m4765a(T t, int i, A a) {
        this.nZ++;
        m4762c(t, i, a);
        this.nZ--;
        if (this.nZ == 0) {
            if (this.nY != null) {
                for (int length = this.nY.length - 1; length >= 0; length--) {
                    long j = this.nY[length];
                    if (j != 0) {
                        m4758a((length + 1) * 64, j);
                        this.nY[length] = 0;
                    }
                }
            }
            if (this.nX != 0) {
                m4758a(0, this.nX);
                this.nX = 0;
            }
        }
    }

    private void m4761b(T t, int i, A a) {
        m4760a(t, i, a, 0, Math.min(64, this.nW.size()), this.nX);
    }

    private void m4762c(T t, int i, A a) {
        int size = this.nW.size();
        int length = this.nY == null ? -1 : this.nY.length - 1;
        m4759a(t, i, a, length);
        m4760a(t, i, a, (length + 2) * 64, size, 0);
    }

    private void m4759a(T t, int i, A a, int i2) {
        if (i2 < 0) {
            m4761b(t, i, a);
            return;
        }
        long j = this.nY[i2];
        int i3 = (i2 + 1) * 64;
        int min = Math.min(this.nW.size(), i3 + 64);
        m4759a(t, i, a, i2 - 1);
        m4760a(t, i, a, i3, min, j);
    }

    private void m4760a(T t, int i, A a, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.oa.mo3136a(this.nW.get(i2), t, i, a);
            }
            j2 <<= 1;
            i2++;
        }
    }

    public synchronized void add(C c) {
        if (c == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        int lastIndexOf = this.nW.lastIndexOf(c);
        if (lastIndexOf < 0 || m4763o(lastIndexOf)) {
            this.nW.add(c);
        }
    }

    private boolean m4763o(int i) {
        if (i < 64) {
            if (((1 << i) & this.nX) != 0) {
                return true;
            }
            return false;
        } else if (this.nY == null) {
            return false;
        } else {
            int i2 = (i / 64) - 1;
            if (i2 >= this.nY.length) {
                return false;
            }
            if ((this.nY[i2] & (1 << (i % 64))) == 0) {
                return false;
            }
            return true;
        }
    }

    private void m4758a(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = (i + 64) - 1; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.nW.remove(i2);
            }
            j2 >>>= 1;
        }
    }

    public synchronized void remove(C c) {
        if (this.nZ == 0) {
            this.nW.remove(c);
        } else {
            int lastIndexOf = this.nW.lastIndexOf(c);
            if (lastIndexOf >= 0) {
                m4764p(lastIndexOf);
            }
        }
    }

    private void m4764p(int i) {
        if (i < 64) {
            this.nX = (1 << i) | this.nX;
            return;
        }
        int i2 = (i / 64) - 1;
        if (this.nY == null) {
            this.nY = new long[(this.nW.size() / 64)];
        } else if (this.nY.length <= i2) {
            Object obj = new long[(this.nW.size() / 64)];
            System.arraycopy(this.nY, 0, obj, 0, this.nY.length);
            this.nY = obj;
        }
        long j = 1 << (i % 64);
        long[] jArr = this.nY;
        jArr[i2] = j | jArr[i2];
    }

    public synchronized C1909b<C, T, A> dt() {
        C1909b<C, T, A> c1909b;
        CloneNotSupportedException e;
        try {
            c1909b = (C1909b) super.clone();
            try {
                c1909b.nX = 0;
                c1909b.nY = null;
                c1909b.nZ = 0;
                c1909b.nW = new ArrayList();
                int size = this.nW.size();
                for (int i = 0; i < size; i++) {
                    if (!m4763o(i)) {
                        c1909b.nW.add(this.nW.get(i));
                    }
                }
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
                return c1909b;
            }
        } catch (CloneNotSupportedException e3) {
            CloneNotSupportedException cloneNotSupportedException = e3;
            c1909b = null;
            e = cloneNotSupportedException;
            e.printStackTrace();
            return c1909b;
        }
        return c1909b;
    }
}
