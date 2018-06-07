package com.fossil;

import java.util.concurrent.Executor;

final class caj<TResult> implements cal<TResult> {
    private final Object Am = new Object();
    private final Executor bKr;
    private caf<TResult> bKs;

    public caj(Executor executor, caf<TResult> com_fossil_caf_TResult) {
        this.bKr = executor;
        this.bKs = com_fossil_caf_TResult;
    }

    public final void mo1587a(cag<TResult> com_fossil_cag_TResult) {
        synchronized (this.Am) {
            if (this.bKs == null) {
                return;
            }
            this.bKr.execute(new cak(this, com_fossil_cag_TResult));
        }
    }
}
