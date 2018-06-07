package com.fossil;

import io.reactivex.internal.disposables.DisposableHelper;

public final class erg<T> extends erf<T, T> {
    final eqw<? super T> dRx;

    static final class C3514a<T> implements eqg<T>, eqn {
        final eqg<? super T> actual;
        final eqw<? super T> dRx;
        boolean done;
        eqn f1513s;

        C3514a(eqg<? super T> com_fossil_eqg__super_T, eqw<? super T> com_fossil_eqw__super_T) {
            this.actual = com_fossil_eqg__super_T;
            this.dRx = com_fossil_eqw__super_T;
        }

        public void onSubscribe(eqn com_fossil_eqn) {
            if (DisposableHelper.validate(this.f1513s, com_fossil_eqn)) {
                this.f1513s = com_fossil_eqn;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f1513s.dispose();
        }

        public void onNext(T t) {
            if (!this.done) {
                this.actual.onNext(t);
                try {
                    if (this.dRx.test(t)) {
                        this.done = true;
                        this.f1513s.dispose();
                        this.actual.onComplete();
                    }
                } catch (Throwable th) {
                    eqp.m11067k(th);
                    this.f1513s.dispose();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                ers.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }
    }

    public erg(eqf<T> com_fossil_eqf_T, eqw<? super T> com_fossil_eqw__super_T) {
        super(com_fossil_eqf_T);
        this.dRx = com_fossil_eqw__super_T;
    }

    public void mo3016b(eqg<? super T> com_fossil_eqg__super_T) {
        this.dRt.mo3002a(new C3514a(com_fossil_eqg__super_T, this.dRx));
    }
}
