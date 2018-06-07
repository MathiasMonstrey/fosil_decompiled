package com.fossil;

import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;

public class ckc {
    private final ckd cnO;

    static final class C2135a<R extends C2133c, E extends C2131a> implements C2126d<R, E> {
        private final C2126d<R, E> coa;
        private final ckc mUseCaseHandler;

        public /* synthetic */ void onError(Object obj) {
            m6881a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m6882a((C2133c) obj);
        }

        public C2135a(C2126d<R, E> c2126d, ckc com_fossil_ckc) {
            this.coa = c2126d;
            this.mUseCaseHandler = com_fossil_ckc;
        }

        public void m6882a(R r) {
            this.mUseCaseHandler.m6885a((C2133c) r, this.coa);
        }

        public void m6881a(E e) {
            this.mUseCaseHandler.m6883a((C2131a) e, this.coa);
        }
    }

    public ckc(ckd com_fossil_ckd) {
        this.cnO = com_fossil_ckd;
    }

    public <Q extends C2132b, R extends C2133c, E extends C2131a> void m6886a(final ckb<Q, R, E> com_fossil_ckb_Q__R__E, Q q, C2126d<R, E> c2126d) {
        com_fossil_ckb_Q__R__E.m6878a((C2132b) q);
        com_fossil_ckb_Q__R__E.m6879a(new C2135a(c2126d, this));
        dqx.increment();
        this.cnO.execute(new Runnable(this) {
            final /* synthetic */ ckc cnZ;

            public void run() {
                MFLogger.m12670d("UseCaseHandler", "execute: getIdlingResource = " + dqx.aul());
                com_fossil_ckb_Q__R__E.run();
                if (!dqx.aul().hw()) {
                    dqx.decrement();
                }
            }
        });
    }

    public <R extends C2133c, E extends C2131a> void m6885a(R r, C2126d<R, E> c2126d) {
        this.cnO.mo1875a(r, c2126d);
    }

    private <R extends C2133c, E extends C2131a> void m6883a(E e, C2126d<R, E> c2126d) {
        this.cnO.mo1876b(e, c2126d);
    }
}
