package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.SessionEvent;
import com.crashlytics.android.answers.SessionEvent.Type;
import java.util.concurrent.ScheduledExecutorService;

class abz {
    final acb aHG;
    final acd aHH;
    boolean aHI = true;

    public static abz m2880a(Context context, acb com_fossil_acb, abx com_fossil_abx, eov com_fossil_eov) {
        ScheduledExecutorService ml = enl.ml("Crashlytics SAM");
        return new abz(com_fossil_acb, new acd(context, new abr(context, ml, com_fossil_abx, com_fossil_eov), com_fossil_abx, ml));
    }

    abz(acb com_fossil_acb, acd com_fossil_acd) {
        this.aHG = com_fossil_acb;
        this.aHH = com_fossil_acd;
    }

    public void aq(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        this.aHH.dj(SessionEvent.m2625a(this.aHG, str));
    }

    public void xr() {
        this.aHH.m2921q(SessionEvent.m2621a(this.aHG), true);
    }

    public void m2882p(Activity activity) {
        this.aHH.m2921q(SessionEvent.m2622a(this.aHG, Type.CREATE, activity), false);
    }

    public void m2883q(Activity activity) {
        this.aHH.m2921q(SessionEvent.m2622a(this.aHG, Type.DESTROY, activity), false);
    }

    public void m2884r(Activity activity) {
        this.aHH.m2921q(SessionEvent.m2622a(this.aHG, Type.PAUSE, activity), false);
    }

    public void m2885s(Activity activity) {
        this.aHH.m2921q(SessionEvent.m2622a(this.aHG, Type.RESUME, activity), false);
    }

    public void m2886t(Activity activity) {
        this.aHH.m2921q(SessionEvent.m2622a(this.aHG, Type.SAVE_INSTANCE_STATE, activity), false);
    }

    public void m2887u(Activity activity) {
        this.aHH.m2921q(SessionEvent.m2622a(this.aHG, Type.START, activity), false);
    }

    public void m2888v(Activity activity) {
        this.aHH.m2921q(SessionEvent.m2622a(this.aHG, Type.STOP, activity), false);
    }

    public void m2881a(epe com_fossil_epe, String str) {
        this.aHI = com_fossil_epe.dPS;
        this.aHH.m2923a(com_fossil_epe, str);
    }

    public void disable() {
        this.aHH.disable();
    }
}
