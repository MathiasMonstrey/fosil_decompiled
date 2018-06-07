package com.fossil;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.flurry.sdk.kb;
import com.flurry.sdk.kb.C1536a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class apf {
    private static final String aWB = apf.class.getSimpleName();
    private static int aXp;
    private static final List<String> baK = new ArrayList(Arrays.asList(new String[]{"FlurryFullscreenTakeoverActivity", "FlurryBrowserActivity"}));
    private static apf baL;
    private static int f1442e;
    private static int f1443f;
    private static int f1444g;
    private ActivityLifecycleCallbacks baM;

    class C17881 implements ActivityLifecycleCallbacks {
        final /* synthetic */ apf baN;

        C17881(apf com_fossil_apf) {
            this.baN = com_fossil_apf;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            app.m4180g(3, apf.aWB, "onActivityCreated for activity:" + activity);
            C17881.m4162a(activity, C1536a.kCreated);
        }

        public final void onActivityStarted(Activity activity) {
            app.m4180g(3, apf.aWB, "onActivityStarted for activity:" + activity);
            if (C17881.m4163w(activity)) {
                C17881.m4162a(activity, C1536a.kStarted);
            }
            apf.IA();
            apf.HK();
        }

        public final void onActivityResumed(Activity activity) {
            app.m4180g(3, apf.aWB, "onActivityResumed for activity:" + activity);
            C17881.m4162a(activity, C1536a.kResumed);
            apf.IR();
            apf.HK();
        }

        public final void onActivityPaused(Activity activity) {
            app.m4180g(3, apf.aWB, "onActivityPaused for activity:" + activity);
            C17881.m4162a(activity, C1536a.kPaused);
            apf.IS();
            apf.HK();
        }

        public final void onActivityStopped(Activity activity) {
            app.m4180g(3, apf.aWB, "onActivityStopped for activity:" + activity);
            if (C17881.m4163w(activity)) {
                C17881.m4162a(activity, C1536a.kStopped);
            }
            apf.HX();
            apf.HK();
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            app.m4180g(3, apf.aWB, "onActivitySaveInstanceState for activity:" + activity);
            C17881.m4162a(activity, C1536a.kSaveState);
        }

        public final void onActivityDestroyed(Activity activity) {
            app.m4180g(3, apf.aWB, "onActivityDestroyed for activity:" + activity);
            C17881.m4162a(activity, C1536a.kDestroyed);
        }

        private static void m4162a(Activity activity, C1536a c1536a) {
            kb kbVar = new kb();
            kbVar.baz = new WeakReference(activity);
            kbVar.f1331b = c1536a;
            kbVar.HO();
        }

        private static boolean m4163w(Activity activity) {
            return !apf.baK.contains(activity.getClass().getSimpleName());
        }
    }

    static /* synthetic */ int HX() {
        int i = aXp + 1;
        aXp = i;
        return i;
    }

    static /* synthetic */ int IA() {
        int i = f1444g + 1;
        f1444g = i;
        return i;
    }

    static /* synthetic */ int IR() {
        int i = f1442e + 1;
        f1442e = i;
        return i;
    }

    static /* synthetic */ int IS() {
        int i = f1443f + 1;
        f1443f = i;
        return i;
    }

    private apf() {
        if (VERSION.SDK_INT >= 14 && this.baM == null) {
            Context context = apc.IO().baD;
            if (context instanceof Application) {
                this.baM = new C17881(this);
                ((Application) context).registerActivityLifecycleCallbacks(this.baM);
            }
        }
    }

    public static synchronized apf IQ() {
        apf com_fossil_apf;
        synchronized (apf.class) {
            if (baL == null) {
                baL = new apf();
            }
            com_fossil_apf = baL;
        }
        return com_fossil_apf;
    }

    public final boolean Ie() {
        return this.baM != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void HK() {
        /*
        r1 = 1;
        r0 = 0;
        r2 = f1442e;
        r3 = f1443f;
        if (r2 <= r3) goto L_0x0019;
    L_0x0008:
        r2 = r1;
    L_0x0009:
        if (r2 != 0) goto L_0x0014;
    L_0x000b:
        r2 = f1444g;
        r3 = aXp;
        if (r2 <= r3) goto L_0x001b;
    L_0x0011:
        r2 = r1;
    L_0x0012:
        if (r2 == 0) goto L_0x0015;
    L_0x0014:
        r0 = r1;
    L_0x0015:
        com.fossil.apc.m4155a(r0);
        return;
    L_0x0019:
        r2 = r0;
        goto L_0x0009;
    L_0x001b:
        r2 = r0;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.apf.HK():void");
    }
}
