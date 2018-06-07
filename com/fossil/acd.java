package com.fossil;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.concurrent.ScheduledExecutorService;

class acd extends eoj<SessionEvent> {
    acd(Context context, eon<SessionEvent> com_fossil_eon_com_crashlytics_android_answers_SessionEvent, abx com_fossil_abx, ScheduledExecutorService scheduledExecutorService) {
        super(context, com_fossil_eon_com_crashlytics_android_answers_SessionEvent, com_fossil_abx, scheduledExecutorService);
    }

    protected eon<SessionEvent> xs() {
        return new abq();
    }

    protected void m2923a(final epe com_fossil_epe, final String str) {
        super.m2920n(new Runnable(this) {
            final /* synthetic */ acd aIa;

            public void run() {
                try {
                    ((aca) this.aIa.dPe).mo796a(com_fossil_epe, str);
                } catch (Throwable e) {
                    CommonUtils.a(abn.xg().getContext(), "Crashlytics failed to set analytics settings data.", e);
                }
            }
        });
    }
}
