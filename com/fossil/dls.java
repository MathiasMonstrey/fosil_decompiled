package com.fossil;

import android.os.Bundle;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dlq.C2920a;
import com.fossil.dlq.C2939b;
import com.fossil.dlv.C2946a;
import com.fossil.dpf.C3051a;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.SummariesLoader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class dls implements C2920a, C2426a<List<SampleDay>> {
    private static final String TAG = dls.class.getSimpleName();
    private final fj cFC;
    private final dpf cSm;
    private final C2939b cZG;
    private final SummariesLoader cZH;
    private Date cZI = Calendar.getInstance().getTime();
    private Date cZJ;
    private final dlv cZw;
    private final ckc mUseCaseHandler;
    private final UserRepository mUserRepository;

    class C29451 implements C2126d<C3051a, C2131a> {
        final /* synthetic */ dls cZK;

        C29451(dls com_fossil_dls) {
            this.cZK = com_fossil_dls;
        }

        public /* synthetic */ void onError(Object obj) {
            m9026a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9027a((C3051a) obj);
        }

        public void m9027a(C3051a c3051a) {
            this.cZK.cZG.mo2559v(cmq.fZ(c3051a.atE().getCreatedAt()));
        }

        public void m9026a(C2131a c2131a) {
        }
    }

    dls(C2939b c2939b, fj fjVar, SummariesLoader summariesLoader, UserRepository userRepository, ckc com_fossil_ckc, dpf com_fossil_dpf, dlv com_fossil_dlv) {
        this.cZG = c2939b;
        this.cFC = fjVar;
        this.cZH = summariesLoader;
        this.mUserRepository = userRepository;
        this.mUseCaseHandler = com_fossil_ckc;
        this.cSm = com_fossil_dpf;
        this.cZw = com_fossil_dlv;
    }

    public void ahu() {
        this.cZG.cK(this);
    }

    public void arG() {
        this.cZG.mo2560w(this.cZI);
        this.mUseCaseHandler.m6886a(this.cSm, null, new C29451(this));
        this.cFC.mo3100a(8, null, this);
    }

    public void mo2525a(int i, Date date) {
        MFLogger.m12670d(TAG, "selectActivityCalendar: position = " + i + ", selectDate = " + date);
        this.cZI = date;
        this.cZG.ll(i);
    }

    public void mo2546s(Date date) {
        MFLogger.m12670d(TAG, "loadActivityMonthData: calendar = " + date);
        this.cZJ = date;
        this.cFC.destroyLoader(8);
        this.cFC.mo3100a(8, null, this);
    }

    public gx<List<SampleDay>> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "LOADER_SUMMARIES onCreateLoader: mCurrentMonth = " + this.cZJ);
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser == null) {
            return null;
        }
        if (this.cZJ == null) {
            this.cZJ = this.cZI;
        }
        Date fZ = cmq.fZ(currentUser.getCreatedAt());
        if (!cmq.m7129g(this.cZJ.getTime(), fZ.getTime())) {
            fZ = cmq.m7136n(this.cZJ).getTime();
        }
        Date date = cmq.m7120e(this.cZJ).booleanValue() ? new Date() : cmq.m7137o(this.cZJ).getTime();
        if (date.getTime() < fZ.getTime()) {
            return null;
        }
        this.mUseCaseHandler.m6886a(this.cZw, new C2946a(this.cZJ, cmq.m7114c(this.cZI).booleanValue()), null);
        this.cZH.setCalendar(fZ, date);
        return this.cZH;
    }

    public void m9032a(gx<List<SampleDay>> gxVar, List<SampleDay> list) {
        MFLogger.m12670d(TAG, "LOADER_SUMMARIES onLoadFinished: data = " + list);
        this.cZG.ao(list);
    }

    public void mo2129a(gx<List<SampleDay>> gxVar) {
        MFLogger.m12670d(TAG, "LOADER_SUMMARIES onLoaderReset");
    }

    public void m9035x(Date date) {
        this.cZI = date;
    }
}
