package com.fossil;

import android.os.Bundle;
import com.fossil.dlx.C2921a;
import com.fossil.dlx.C2947b;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.loader.ActivitiesDayLoader;
import java.util.Date;
import java.util.List;

public class dlz implements C2921a {
    private static final String TAG = dlz.class.getSimpleName();
    private final fj cFC;
    private final ActivitiesDayLoader cOi;
    private final C2947b cZP;
    private Date mDate;

    class C29501 implements C2426a<jt<List<SampleRaw>, Integer>> {
        final /* synthetic */ dlz cZQ;

        C29501(dlz com_fossil_dlz) {
            this.cZQ = com_fossil_dlz;
        }

        public gx<jt<List<SampleRaw>, Integer>> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dlz.TAG, "LOADER_ACTIVITIES_DAY onCreateLoader: mDate = " + this.cZQ.mDate);
            if (this.cZQ.mDate == null) {
                return null;
            }
            this.cZQ.cOi.setDate(this.cZQ.mDate);
            return this.cZQ.cOi;
        }

        public void m9042a(gx<jt<List<SampleRaw>, Integer>> gxVar, jt<List<SampleRaw>, Integer> jtVar) {
            MFLogger.m12670d(dlz.TAG, "LOADER_ACTIVITIES_DAY onLoadFinished: data = " + jtVar.first);
            this.cZQ.cZP.ap((List) jtVar.first);
        }

        public void mo2129a(gx<jt<List<SampleRaw>, Integer>> gxVar) {
            MFLogger.m12670d(dlz.TAG, "LOADER_ACTIVITIES_DAY onLoaderReset");
        }
    }

    dlz(C2947b c2947b, fj fjVar, ActivitiesDayLoader activitiesDayLoader) {
        this.cZP = c2947b;
        this.cFC = fjVar;
        this.cOi = activitiesDayLoader;
    }

    public void ahu() {
        this.cZP.cK(this);
    }

    public void arH() {
        if (this.cFC.aN(6) != null) {
            this.cFC.destroyLoader(6);
        }
        this.cFC.mo3100a(6, null, new C29501(this));
    }

    public void setDate(Date date) {
        this.mDate = date;
    }
}
