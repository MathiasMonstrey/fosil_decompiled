package com.fossil;

import com.misfit.frameworks.common.log.MFLogger;

public abstract class ckb<Q extends C2132b, R extends C2133c, E extends C2131a> {
    private static final String TAG = ckb.class.getSimpleName();
    private Q cnW;
    private C2126d<R, E> cnX;

    public interface C2126d<R, E> {
        void onError(E e);

        void onSuccess(R r);
    }

    public interface C2131a {
    }

    public interface C2132b {
    }

    public interface C2133c {
    }

    protected abstract void mo2022b(Q q);

    public void m6878a(Q q) {
        this.cnW = q;
    }

    public Q abq() {
        return this.cnW;
    }

    public C2126d<R, E> abr() {
        return this.cnX;
    }

    public void m6879a(C2126d<R, E> c2126d) {
        this.cnX = c2126d;
    }

    void run() {
        String simpleName = getClass().getSimpleName();
        MFLogger.m12670d(TAG, "Inside .run useCase=" + simpleName);
        Thread.currentThread().setName(simpleName);
        mo2022b(this.cnW);
        MFLogger.m12670d(TAG, "Inside .done useCase=" + simpleName);
    }
}
