package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class bdq implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final bdq brr = new bdq();
    private final ArrayList<bdr> Da = new ArrayList();
    private final AtomicBoolean brs = new AtomicBoolean();
    private final AtomicBoolean brt = new AtomicBoolean();
    private boolean bru = false;

    private bdq() {
    }

    public static bdq Nd() {
        return brr;
    }

    public static void m4909a(Application application) {
        synchronized (brr) {
            if (!brr.bru) {
                application.registerActivityLifecycleCallbacks(brr);
                application.registerComponentCallbacks(brr);
                brr.bru = true;
            }
        }
    }

    private final void ba(boolean z) {
        synchronized (brr) {
            ArrayList arrayList = this.Da;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((bdr) obj).ba(z);
            }
        }
    }

    public final void m4910a(bdr com_fossil_bdr) {
        synchronized (brr) {
            this.Da.add(com_fossil_bdr);
        }
    }

    @TargetApi(16)
    public final boolean aZ(boolean z) {
        if (!this.brt.get()) {
            if (!axt.LF()) {
                return true;
            }
            RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.brt.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.brs.set(true);
            }
        }
        return this.brs.get();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.brs.compareAndSet(true, false);
        this.brt.set(true);
        if (compareAndSet) {
            ba(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.brs.compareAndSet(true, false);
        this.brt.set(true);
        if (compareAndSet) {
            ba(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.brs.compareAndSet(false, true)) {
            this.brt.set(true);
            ba(true);
        }
    }
}
