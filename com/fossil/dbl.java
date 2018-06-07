package com.fossil;

import android.os.Bundle;
import com.fossil.dbg.C2619a;
import com.fossil.dbg.C2620b;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.loader.ActivitiesDayLoader;
import com.portfolio.platform.data.source.loader.SummaryLoader;
import java.util.Date;
import java.util.List;

public class dbl implements C2619a, C2426a<SampleDay> {
    private static final String TAG = dbl.class.getSimpleName();
    private fj cFC;
    private C2620b cOh;
    private final ActivitiesDayLoader cOi;
    private SummaryLoader cOj;
    private LandingPageRepository mLandingPageRepository;

    class C26221 implements C2426a<jt<List<SampleRaw>, Integer>> {
        final /* synthetic */ dbl cOk;

        C26221(dbl com_fossil_dbl) {
            this.cOk = com_fossil_dbl;
        }

        public gx<jt<List<SampleRaw>, Integer>> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dbl.TAG, "LOADER_ACTIVITIES_DAY onCreateLoader: mDate = " + new Date());
            this.cOk.cOi.setDate(new Date());
            return this.cOk.cOi;
        }

        public void m8134a(gx<jt<List<SampleRaw>, Integer>> gxVar, jt<List<SampleRaw>, Integer> jtVar) {
            MFLogger.m12670d(dbl.TAG, "LOADER_ACTIVITIES_DAY onLoadFinished: data = " + jtVar.first + ", stepGoal=" + jtVar.second);
            if (this.cOk.cOh.isActive()) {
                this.cOk.cOh.mo2239f((List) jtVar.first, ((Integer) jtVar.second).intValue());
            }
        }

        public void mo2129a(gx<jt<List<SampleRaw>, Integer>> gxVar) {
            MFLogger.m12670d(dbl.TAG, "LOADER_ACTIVITIES_DAY onLoaderReset");
        }
    }

    dbl(C2620b c2620b, fj fjVar, ActivitiesDayLoader activitiesDayLoader, SummaryLoader summaryLoader, LandingPageRepository landingPageRepository) {
        this.cOh = (C2620b) cco.m5996s(c2620b, "StatisticsView cannot be null!");
        this.cOj = summaryLoader;
        this.cFC = fjVar;
        this.cOi = activitiesDayLoader;
        this.mLandingPageRepository = landingPageRepository;
        this.cOh.cK(this);
    }

    public void start() {
        this.cOj.setDate(new Date());
        this.cFC.mo3100a(2, null, this);
        if (this.cFC.aN(6) != null) {
            this.cFC.destroyLoader(6);
        }
        this.cFC.mo3100a(6, null, new C26221(this));
        alm();
    }

    public void stop() {
    }

    public gx<SampleDay> mo2137b(int i, Bundle bundle) {
        this.cOh.afT();
        return this.cOj;
    }

    public void m8140a(gx<SampleDay> gxVar, SampleDay sampleDay) {
        MFLogger.m12670d(TAG, "Inside .onLoadFinished sampleDayToday=" + sampleDay);
        this.cOh.afU();
        this.cOh.mo2237b(sampleDay);
    }

    public void mo2129a(gx<SampleDay> gxVar) {
    }

    public void alm() {
        List<LandingPage> allLandingPage = this.mLandingPageRepository.getAllLandingPage(null);
        if (allLandingPage != null && !allLandingPage.isEmpty()) {
            for (LandingPage landingPage : allLandingPage) {
                if (landingPage.getType().equals("home3")) {
                    this.cOh.mo2238b(landingPage);
                    return;
                }
            }
        }
    }
}
