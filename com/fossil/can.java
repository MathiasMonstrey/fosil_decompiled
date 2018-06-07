package com.fossil;

import java.util.concurrent.Executor;

final class can<TResult> extends cag<TResult> {
    private final Object Am = new Object();
    private Exception bKA;
    private final cam<TResult> bKx = new cam();
    private boolean bKy;
    private TResult bKz;

    can() {
    }

    private final void TR() {
        awa.m4634a(!this.bKy, "Task is already complete");
    }

    private final void TS() {
        synchronized (this.Am) {
            if (this.bKy) {
                this.bKx.m5871b(this);
                return;
            }
        }
    }

    public final boolean TQ() {
        boolean z;
        synchronized (this.Am) {
            z = this.bKy && this.bKA == null;
        }
        return z;
    }

    public final cag<TResult> mo1589a(Executor executor, caf<TResult> com_fossil_caf_TResult) {
        this.bKx.m5870a(new caj(executor, com_fossil_caf_TResult));
        TS();
        return this;
    }

    public final void aV(TResult tResult) {
        synchronized (this.Am) {
            TR();
            this.bKy = true;
            this.bKz = tResult;
        }
        this.bKx.m5871b(this);
    }

    public final Exception getException() {
        Exception exception;
        synchronized (this.Am) {
            exception = this.bKA;
        }
        return exception;
    }

    public final void m5873h(Exception exception) {
        awa.m4640p(exception, "Exception must not be null");
        synchronized (this.Am) {
            TR();
            this.bKy = true;
            this.bKA = exception;
        }
        this.bKx.m5871b(this);
    }

    public final boolean m5874i(Exception exception) {
        boolean z = true;
        awa.m4640p(exception, "Exception must not be null");
        synchronized (this.Am) {
            if (this.bKy) {
                z = false;
            } else {
                this.bKy = true;
                this.bKA = exception;
                this.bKx.m5871b(this);
            }
        }
        return z;
    }
}
