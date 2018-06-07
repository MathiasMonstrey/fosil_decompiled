package com.fossil;

import io.fabric.sdk.android.services.concurrency.AsyncTask;
import io.fabric.sdk.android.services.concurrency.AsyncTask.Status;
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class ent<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements enr<enz>, enw, enz {
    private final enx dOH = new enx();

    static class C3482a<Result> implements Executor {
        private final ent dOI;
        private final Executor executor;

        public C3482a(Executor executor, ent com_fossil_ent) {
            this.executor = executor;
            this.dOI = com_fossil_ent;
        }

        public void execute(Runnable runnable) {
            this.executor.execute(new env<Result>(this, runnable, null) {
                final /* synthetic */ C3482a dOJ;

                public <T extends enr<enz> & enw & enz> T aFJ() {
                    return this.dOJ.dOI;
                }
            });
        }
    }

    public /* synthetic */ void df(Object obj) {
        m10911a((enz) obj);
    }

    public final void m10912a(ExecutorService executorService, Params... paramsArr) {
        super.b(new C3482a(executorService, this), paramsArr);
    }

    public int compareTo(Object obj) {
        return Priority.compareTo(this, obj);
    }

    public void m10911a(enz com_fossil_enz) {
        if (aFH() != Status.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
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
        return this.dOH;
    }
}
