package io.reactivex.internal.operators.observable;

import com.fossil.eqe;
import com.fossil.eqg;
import com.fossil.eqh;
import com.fossil.eqn;
import com.fossil.erp;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableInterval extends eqe<Long> {
    final eqh dRu;
    final long dRv;
    final TimeUnit dRw;
    final long period;

    static final class IntervalObserver extends AtomicReference<eqn> implements eqn, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        final eqg<? super Long> actual;
        long count;

        IntervalObserver(eqg<? super Long> com_fossil_eqg__super_java_lang_Long) {
            this.actual = com_fossil_eqg__super_java_lang_Long;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                eqg com_fossil_eqg = this.actual;
                long j = this.count;
                this.count = 1 + j;
                com_fossil_eqg.onNext(Long.valueOf(j));
            }
        }

        public void setResource(eqn com_fossil_eqn) {
            DisposableHelper.setOnce(this, com_fossil_eqn);
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, eqh com_fossil_eqh) {
        this.dRv = j;
        this.period = j2;
        this.dRw = timeUnit;
        this.dRu = com_fossil_eqh;
    }

    public void m16328b(eqg<? super Long> com_fossil_eqg__super_java_lang_Long) {
        Object intervalObserver = new IntervalObserver(com_fossil_eqg__super_java_lang_Long);
        com_fossil_eqg__super_java_lang_Long.onSubscribe(intervalObserver);
        eqh com_fossil_eqh = this.dRu;
        if (com_fossil_eqh instanceof erp) {
            Object aGG = com_fossil_eqh.aGG();
            intervalObserver.setResource(aGG);
            aGG.b(intervalObserver, this.dRv, this.period, this.dRw);
            return;
        }
        intervalObserver.setResource(com_fossil_eqh.a(intervalObserver, this.dRv, this.period, this.dRw));
    }
}
