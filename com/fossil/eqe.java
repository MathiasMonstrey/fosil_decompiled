package com.fossil;

import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import java.util.concurrent.TimeUnit;

public abstract class eqe<T> implements eqf<T> {
    public abstract void mo3016b(eqg<? super T> com_fossil_eqg__super_T);

    public static int aGF() {
        return eqc.aGF();
    }

    public static eqe<Long> m11040a(long j, long j2, TimeUnit timeUnit, eqh com_fossil_eqh) {
        era.requireNonNull(timeUnit, "unit is null");
        era.requireNonNull(com_fossil_eqh, "scheduler is null");
        return ers.m11104a(new ObservableInterval(Math.max(0, j), Math.max(0, j2), timeUnit, com_fossil_eqh));
    }

    public static eqe<Long> m11041e(long j, TimeUnit timeUnit) {
        return m11040a(j, j, timeUnit, ert.aGV());
    }

    public final eqe<T> m11042a(eqh com_fossil_eqh) {
        return m11043a(com_fossil_eqh, false, aGF());
    }

    public final eqe<T> m11043a(eqh com_fossil_eqh, boolean z, int i) {
        era.requireNonNull(com_fossil_eqh, "scheduler is null");
        era.m11074A(i, "bufferSize");
        return ers.m11104a(new ObservableObserveOn(this, com_fossil_eqh, z, i));
    }

    public final void mo3002a(eqg<? super T> com_fossil_eqg__super_T) {
        era.requireNonNull(com_fossil_eqg__super_T, "observer is null");
        try {
            eqg a = ers.m11105a(this, (eqg) com_fossil_eqg__super_T);
            era.requireNonNull(a, "Plugin returned null Observer");
            mo3016b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            eqp.m11067k(th);
            ers.onError(th);
            new NullPointerException("Actually not, but can't throw other exceptions due to RS").initCause(th);
        }
    }

    public final eqe<T> m11044a(eqw<? super T> com_fossil_eqw__super_T) {
        era.requireNonNull(com_fossil_eqw__super_T, "predicate is null");
        return ers.m11104a(new erg(this, com_fossil_eqw__super_T));
    }
}
