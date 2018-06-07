package com.fossil;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.concurrent.ScheduledExecutorService;

class abr extends eog<SessionEvent> implements aca<SessionEvent> {
    private final eov aHu;
    eop aHv;
    abs aHw = new abt();

    public /* synthetic */ void bj(Object obj) {
        m2893a((SessionEvent) obj);
    }

    public abr(Context context, ScheduledExecutorService scheduledExecutorService, abx com_fossil_abx, eov com_fossil_eov) {
        super(context, scheduledExecutorService, com_fossil_abx);
        this.aHu = com_fossil_eov;
    }

    public eop xm() {
        return this.aHv;
    }

    public void mo796a(epe com_fossil_epe, String str) {
        this.aHv = abo.m2878a(new aby(abn.xg(), str, com_fossil_epe.dPN, this.aHu, new eng().er(this.context)));
        ((abx) this.dOT).m2903a(com_fossil_epe);
        ph(com_fossil_epe.dPO);
        if (com_fossil_epe.aHC > 1) {
            this.aHw = new abw(com_fossil_epe.aHC);
        }
    }

    public void m2893a(SessionEvent sessionEvent) {
        if (this.aHw.mo797b(sessionEvent)) {
            CommonUtils.Z(abn.xg().getContext(), "skipping filtered event " + sessionEvent);
        } else {
            super.bj(sessionEvent);
        }
    }
}
