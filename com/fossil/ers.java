package com.fossil;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;

public final class ers {
    static volatile eqt<? super Throwable> dSA;
    static volatile equ<? super Runnable, ? extends Runnable> dSB;
    static volatile equ<? super Callable<eqh>, ? extends eqh> dSC;
    static volatile equ<? super Callable<eqh>, ? extends eqh> dSD;
    static volatile equ<? super Callable<eqh>, ? extends eqh> dSE;
    static volatile equ<? super Callable<eqh>, ? extends eqh> dSF;
    static volatile equ<? super eqh, ? extends eqh> dSG;
    static volatile equ<? super eqe, ? extends eqe> dSH;
    static volatile eqr<? super eqe, ? super eqg, ? extends eqg> dSI;

    public static eqh m11111i(Callable<eqh> callable) {
        era.requireNonNull(callable, "Scheduler Callable can't be null");
        equ com_fossil_equ = dSC;
        if (com_fossil_equ == null) {
            return m11110h(callable);
        }
        return m11106a(com_fossil_equ, (Callable) callable);
    }

    public static eqh m11112j(Callable<eqh> callable) {
        era.requireNonNull(callable, "Scheduler Callable can't be null");
        equ com_fossil_equ = dSE;
        if (com_fossil_equ == null) {
            return m11110h(callable);
        }
        return m11106a(com_fossil_equ, (Callable) callable);
    }

    public static eqh m11113k(Callable<eqh> callable) {
        era.requireNonNull(callable, "Scheduler Callable can't be null");
        equ com_fossil_equ = dSF;
        if (com_fossil_equ == null) {
            return m11110h(callable);
        }
        return m11106a(com_fossil_equ, (Callable) callable);
    }

    public static eqh m11114l(Callable<eqh> callable) {
        era.requireNonNull(callable, "Scheduler Callable can't be null");
        equ com_fossil_equ = dSD;
        if (com_fossil_equ == null) {
            return m11110h(callable);
        }
        return m11106a(com_fossil_equ, (Callable) callable);
    }

    public static eqh m11109c(eqh com_fossil_eqh) {
        equ com_fossil_equ = dSG;
        return com_fossil_equ == null ? com_fossil_eqh : (eqh) m11108a(com_fossil_equ, (Object) com_fossil_eqh);
    }

    public static void onError(Throwable th) {
        eqt com_fossil_eqt = dSA;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!m11115n(th)) {
            th = new UndeliverableException(th);
        }
        if (com_fossil_eqt != null) {
            try {
                com_fossil_eqt.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m11116o(th2);
            }
        }
        th.printStackTrace();
        m11116o(th);
    }

    static boolean m11115n(Throwable th) {
        if ((th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException)) {
            return true;
        }
        return false;
    }

    static void m11116o(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static Runnable m11117q(Runnable runnable) {
        equ com_fossil_equ = dSB;
        return com_fossil_equ == null ? runnable : (Runnable) m11108a(com_fossil_equ, (Object) runnable);
    }

    public static <T> eqg<? super T> m11105a(eqe<T> com_fossil_eqe_T, eqg<? super T> com_fossil_eqg__super_T) {
        eqr com_fossil_eqr = dSI;
        if (com_fossil_eqr != null) {
            return (eqg) m11107a(com_fossil_eqr, com_fossil_eqe_T, com_fossil_eqg__super_T);
        }
        return com_fossil_eqg__super_T;
    }

    public static <T> eqe<T> m11104a(eqe<T> com_fossil_eqe_T) {
        equ com_fossil_equ = dSH;
        if (com_fossil_equ != null) {
            return (eqe) m11108a(com_fossil_equ, (Object) com_fossil_eqe_T);
        }
        return com_fossil_eqe_T;
    }

    static <T, R> R m11108a(equ<T, R> com_fossil_equ_T__R, T t) {
        try {
            return com_fossil_equ_T__R.apply(t);
        } catch (Throwable th) {
            RuntimeException m = ExceptionHelper.m(th);
        }
    }

    static <T, U, R> R m11107a(eqr<T, U, R> com_fossil_eqr_T__U__R, T t, U u) {
        try {
            return com_fossil_eqr_T__U__R.apply(t, u);
        } catch (Throwable th) {
            RuntimeException m = ExceptionHelper.m(th);
        }
    }

    static eqh m11110h(Callable<eqh> callable) {
        try {
            return (eqh) era.requireNonNull(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            RuntimeException m = ExceptionHelper.m(th);
        }
    }

    static eqh m11106a(equ<? super Callable<eqh>, ? extends eqh> com_fossil_equ__super_java_util_concurrent_Callable_com_fossil_eqh___extends_com_fossil_eqh, Callable<eqh> callable) {
        return (eqh) era.requireNonNull(m11108a((equ) com_fossil_equ__super_java_util_concurrent_Callable_com_fossil_eqh___extends_com_fossil_eqh, (Object) callable), "Scheduler Callable result can't be null");
    }
}
