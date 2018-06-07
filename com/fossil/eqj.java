package com.fossil;

import java.util.concurrent.Callable;

public final class eqj {
    private static volatile equ<Callable<eqh>, eqh> dQW;
    private static volatile equ<eqh, eqh> dQX;

    public static eqh m11055g(Callable<eqh> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        equ com_fossil_equ = dQW;
        if (com_fossil_equ == null) {
            return m11056h(callable);
        }
        return m11052a(com_fossil_equ, (Callable) callable);
    }

    public static eqh m11054b(eqh com_fossil_eqh) {
        if (com_fossil_eqh == null) {
            throw new NullPointerException("scheduler == null");
        }
        equ com_fossil_equ = dQX;
        return com_fossil_equ == null ? com_fossil_eqh : (eqh) m11053a(com_fossil_equ, (Object) com_fossil_eqh);
    }

    static eqh m11056h(Callable<eqh> callable) {
        try {
            eqh com_fossil_eqh = (eqh) callable.call();
            if (com_fossil_eqh != null) {
                return com_fossil_eqh;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            RuntimeException j = eqp.m11066j(th);
        }
    }

    static eqh m11052a(equ<Callable<eqh>, eqh> com_fossil_equ_java_util_concurrent_Callable_com_fossil_eqh__com_fossil_eqh, Callable<eqh> callable) {
        eqh com_fossil_eqh = (eqh) m11053a((equ) com_fossil_equ_java_util_concurrent_Callable_com_fossil_eqh__com_fossil_eqh, (Object) callable);
        if (com_fossil_eqh != null) {
            return com_fossil_eqh;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static <T, R> R m11053a(equ<T, R> com_fossil_equ_T__R, T t) {
        try {
            return com_fossil_equ_T__R.apply(t);
        } catch (Throwable th) {
            RuntimeException j = eqp.m11066j(th);
        }
    }
}
