package com.fossil;

import java.util.Queue;

public class wo<A, B> {
    private final abi<C4202a<A>, B> aDG;

    static final class C4202a<A> {
        private static final Queue<C4202a<?>> aDI = abl.eR(0);
        private A ayf;
        private int height;
        private int width;

        static <A> C4202a<A> m14001e(A a, int i, int i2) {
            C4202a<A> c4202a = (C4202a) aDI.poll();
            if (c4202a == null) {
                c4202a = new C4202a();
            }
            c4202a.m14002f(a, i, i2);
            return c4202a;
        }

        private C4202a() {
        }

        private void m14002f(A a, int i, int i2) {
            this.ayf = a;
            this.width = i;
            this.height = i2;
        }

        public void release() {
            aDI.offer(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C4202a)) {
                return false;
            }
            C4202a c4202a = (C4202a) obj;
            if (this.width == c4202a.width && this.height == c4202a.height && this.ayf.equals(c4202a.ayf)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.ayf.hashCode();
        }
    }

    public wo() {
        this(250);
    }

    public wo(int i) {
        this.aDG = new abi<C4202a<A>, B>(this, i) {
            final /* synthetic */ wo aDH;

            protected /* synthetic */ void m14000h(Object obj, Object obj2) {
                m13999a((C4202a) obj, obj2);
            }

            protected void m13999a(C4202a<A> c4202a, B b) {
                c4202a.release();
            }
        };
    }

    public B m14004d(A a, int i, int i2) {
        C4202a e = C4202a.m14001e(a, i, i2);
        B b = this.aDG.get(e);
        e.release();
        return b;
    }

    public void m14003a(A a, int i, int i2, B b) {
        this.aDG.put(C4202a.m14001e(a, i, i2), b);
    }
}
