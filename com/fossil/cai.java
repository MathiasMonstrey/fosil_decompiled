package com.fossil;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class cai {
    public static <TResult> cag<TResult> m5864a(Executor executor, Callable<TResult> callable) {
        awa.m4640p(executor, "Executor must not be null");
        awa.m4640p(callable, "Callback must not be null");
        cag com_fossil_can = new can();
        executor.execute(new cao(com_fossil_can, callable));
        return com_fossil_can;
    }

    public static <TResult> cag<TResult> bZ(TResult tResult) {
        cag com_fossil_can = new can();
        com_fossil_can.aV(tResult);
        return com_fossil_can;
    }

    public static <TResult> cag<TResult> m5865j(Exception exception) {
        cag com_fossil_can = new can();
        com_fossil_can.m5873h(exception);
        return com_fossil_can;
    }
}
