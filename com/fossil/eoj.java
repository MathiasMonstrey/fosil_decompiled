package com.fossil;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.concurrent.ScheduledExecutorService;

public abstract class eoj<T> implements eom {
    protected final Context context;
    protected final ScheduledExecutorService dPd;
    protected eon<T> dPe;

    class C34893 implements Runnable {
        final /* synthetic */ eoj dPg;

        C34893(eoj com_fossil_eoj) {
            this.dPg = com_fossil_eoj;
        }

        public void run() {
            try {
                this.dPg.dPe.aFP();
            } catch (Throwable e) {
                CommonUtils.a(this.dPg.context, "Failed to send events files.", e);
            }
        }
    }

    class C34904 implements Runnable {
        final /* synthetic */ eoj dPg;

        C34904(eoj com_fossil_eoj) {
            this.dPg = com_fossil_eoj;
        }

        public void run() {
            try {
                eon com_fossil_eon = this.dPg.dPe;
                this.dPg.dPe = this.dPg.xs();
                com_fossil_eon.aFQ();
            } catch (Throwable e) {
                CommonUtils.a(this.dPg.context, "Failed to disable events.", e);
            }
        }
    }

    protected abstract eon<T> xs();

    public eoj(Context context, eon<T> com_fossil_eon_T, eoi com_fossil_eoi, ScheduledExecutorService scheduledExecutorService) {
        this.context = context.getApplicationContext();
        this.dPd = scheduledExecutorService;
        this.dPe = com_fossil_eon_T;
        com_fossil_eoi.m2902a(this);
    }

    public void m2921q(final T t, final boolean z) {
        m2920n(new Runnable(this) {
            final /* synthetic */ eoj dPg;

            public void run() {
                try {
                    this.dPg.dPe.bj(t);
                    if (z) {
                        this.dPg.dPe.aFS();
                    }
                } catch (Throwable e) {
                    CommonUtils.a(this.dPg.context, "Failed to record event.", e);
                }
            }
        });
    }

    public void dj(final T t) {
        m2919m(new Runnable(this) {
            final /* synthetic */ eoj dPg;

            public void run() {
                try {
                    this.dPg.dPe.bj(t);
                } catch (Throwable e) {
                    CommonUtils.a(this.dPg.context, "Crashlytics failed to record event", e);
                }
            }
        });
    }

    public void ms(String str) {
        m2920n(new C34893(this));
    }

    public void disable() {
        m2920n(new C34904(this));
    }

    protected void m2919m(Runnable runnable) {
        try {
            this.dPd.submit(runnable).get();
        } catch (Throwable e) {
            CommonUtils.a(this.context, "Failed to run events task", e);
        }
    }

    protected void m2920n(Runnable runnable) {
        try {
            this.dPd.submit(runnable);
        } catch (Throwable e) {
            CommonUtils.a(this.context, "Failed to submit events task", e);
        }
    }
}
