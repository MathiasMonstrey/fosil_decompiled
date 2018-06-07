package com.fossil;

import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;

public class cka {
    private final ckd cnO;

    public static class C2129a<Q extends C2132b, R extends C2133c, E extends C2131a> {
        private ckb<Q, R, E> cnP;
        private C2130b<R, E> cnQ = new C2130b();
        private ckd cnR;
        private final Object mLocker = new Object();

        class C21271 implements C2126d<R, E> {
            final /* synthetic */ C2129a cnS;

            C21271(C2129a c2129a) {
                this.cnS = c2129a;
            }

            public /* synthetic */ void onError(Object obj) {
                m6870a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m6871a((C2133c) obj);
            }

            public void m6871a(R r) {
                this.cnS.cnQ.bO(true);
                this.cnS.cnQ.m6876b((C2133c) r);
                synchronized (this.cnS.mLocker) {
                    this.cnS.mLocker.notify();
                }
            }

            public void m6870a(E e) {
                this.cnS.cnQ.bO(false);
                this.cnS.cnQ.m6875b((C2131a) e);
                synchronized (this.cnS.mLocker) {
                    this.cnS.mLocker.notify();
                }
            }
        }

        class C21282 implements Runnable {
            final /* synthetic */ C2129a cnS;

            C21282(C2129a c2129a) {
                this.cnS = c2129a;
            }

            public void run() {
                this.cnS.cnP.run();
            }
        }

        public C2129a(ckb<Q, R, E> com_fossil_ckb_Q__R__E, ckd com_fossil_ckd) {
            this.cnP = com_fossil_ckb_Q__R__E;
            this.cnR = com_fossil_ckd;
        }

        public C2130b<R, E> abo() {
            if (this.cnP != null) {
                this.cnP.m6879a(new C21271(this));
                this.cnR.execute(new C21282(this));
                synchronized (this.mLocker) {
                    try {
                        this.mLocker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return this.cnQ;
        }
    }

    public static class C2130b<R extends C2133c, E extends C2131a> {
        private boolean cnT = false;
        private R cnU = null;
        private E cnV = null;

        public boolean Kb() {
            return this.cnT;
        }

        public void bO(boolean z) {
            this.cnT = z;
        }

        public R abp() {
            return this.cnU;
        }

        public void m6876b(R r) {
            this.cnU = r;
        }

        public void m6875b(E e) {
            this.cnV = e;
        }
    }

    public cka(ckd com_fossil_ckd) {
        this.cnO = com_fossil_ckd;
    }

    public <Q extends C2132b, R extends C2133c, E extends C2131a> C2129a<Q, R, E> m6877a(ckb<Q, R, E> com_fossil_ckb_Q__R__E, Q q) {
        com_fossil_ckb_Q__R__E.m6878a((C2132b) q);
        return new C2129a(com_fossil_ckb_Q__R__E, this.cnO);
    }
}
