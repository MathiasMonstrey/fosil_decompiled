package io.reactivex.internal.disposables;

import com.fossil.eqb;
import com.fossil.eqd;
import com.fossil.eqg;
import com.fossil.eqi;
import com.fossil.erb;

public enum EmptyDisposable implements erb<Object> {
    INSTANCE,
    NEVER;

    public void dispose() {
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public static void complete(eqg<?> com_fossil_eqg_) {
        com_fossil_eqg_.onSubscribe(INSTANCE);
        com_fossil_eqg_.onComplete();
    }

    public static void complete(eqd<?> com_fossil_eqd_) {
        com_fossil_eqd_.onSubscribe(INSTANCE);
        com_fossil_eqd_.onComplete();
    }

    public static void error(Throwable th, eqg<?> com_fossil_eqg_) {
        com_fossil_eqg_.onSubscribe(INSTANCE);
        com_fossil_eqg_.onError(th);
    }

    public static void complete(eqb com_fossil_eqb) {
        com_fossil_eqb.onSubscribe(INSTANCE);
        com_fossil_eqb.onComplete();
    }

    public static void error(Throwable th, eqb com_fossil_eqb) {
        com_fossil_eqb.onSubscribe(INSTANCE);
        com_fossil_eqb.onError(th);
    }

    public static void error(Throwable th, eqi<?> com_fossil_eqi_) {
        com_fossil_eqi_.onSubscribe(INSTANCE);
        com_fossil_eqi_.onError(th);
    }

    public static void error(Throwable th, eqd<?> com_fossil_eqd_) {
        com_fossil_eqd_.onSubscribe(INSTANCE);
        com_fossil_eqd_.onError(th);
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() throws Exception {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public void clear() {
    }

    public int requestFusion(int i) {
        return i & 2;
    }
}
