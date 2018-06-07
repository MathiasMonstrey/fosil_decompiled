package com.fossil;

import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class env<V> extends FutureTask<V> implements enr<enz>, enw, enz {
    final Object dOK;

    public /* synthetic */ void df(Object obj) {
        m10979a((enz) obj);
    }

    public env(Callable<V> callable) {
        super(callable);
        this.dOK = dg(callable);
    }

    public env(Runnable runnable, V v) {
        super(runnable, v);
        this.dOK = dg(runnable);
    }

    public int compareTo(Object obj) {
        return ((enw) aFJ()).compareTo(obj);
    }

    public void m10979a(enz com_fossil_enz) {
        ((enr) ((enw) aFJ())).df(com_fossil_enz);
    }

    public Collection<enz> aFc() {
        return ((enr) ((enw) aFJ())).aFc();
    }

    public boolean aFI() {
        return ((enr) ((enw) aFJ())).aFI();
    }

    public Priority xS() {
        return ((enw) aFJ()).xS();
    }

    public void dJ(boolean z) {
        ((enz) ((enw) aFJ())).dJ(z);
    }

    public boolean isFinished() {
        return ((enz) ((enw) aFJ())).isFinished();
    }

    public void mo817h(Throwable th) {
        ((enz) ((enw) aFJ())).mo817h(th);
    }

    public <T extends enr<enz> & enw & enz> T aFJ() {
        return (enr) this.dOK;
    }

    protected <T extends enr<enz> & enw & enz> T dg(Object obj) {
        if (enx.dh(obj)) {
            return (enr) obj;
        }
        return new enx();
    }
}
