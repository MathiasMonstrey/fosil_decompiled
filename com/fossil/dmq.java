package com.fossil;

import android.os.Bundle;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dmo.C2923a;
import com.fossil.dmo.C2967b;
import com.fossil.dmt.C2974a;
import com.fossil.dpf.C3051a;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.SleepSummariesLoader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class dmq implements C2923a, C2426a<List<MFSleepDay>> {
    private static final String TAG = dmq.class.getSimpleName();
    private final fj cFC;
    private final dpf cSm;
    private Date cZI = Calendar.getInstance().getTime();
    private Date cZJ;
    private final dmt dae;
    private final C2967b dam;
    private final SleepSummariesLoader dan;
    private final ckc mUseCaseHandler;
    private final UserRepository mUserRepository;

    class C29731 implements C2126d<C3051a, C2131a> {
        final /* synthetic */ dmq dap;

        C29731(dmq com_fossil_dmq) {
            this.dap = com_fossil_dmq;
        }

        public /* synthetic */ void onError(Object obj) {
            m9105a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9106a((C3051a) obj);
        }

        public void m9106a(C3051a c3051a) {
            this.dap.dam.mo2570v(cmq.fZ(c3051a.atE().getCreatedAt()));
        }

        public void m9105a(C2131a c2131a) {
        }
    }

    dmq(C2967b c2967b, fj fjVar, SleepSummariesLoader sleepSummariesLoader, UserRepository userRepository, ckc com_fossil_ckc, dpf com_fossil_dpf, dmt com_fossil_dmt) {
        this.dam = c2967b;
        this.cFC = fjVar;
        this.dan = sleepSummariesLoader;
        this.mUserRepository = userRepository;
        this.mUseCaseHandler = com_fossil_ckc;
        this.cSm = com_fossil_dpf;
        this.dae = com_fossil_dmt;
    }

    public void ahu() {
        this.dam.cK(this);
    }

    public void arK() {
        this.dam.mo2571w(this.cZI);
        this.mUseCaseHandler.m6886a(this.cSm, null, new C29731(this));
        this.cFC.mo3100a(11, null, this);
    }

    public void mo2544b(int i, Date date) {
        MFLogger.m12670d(TAG, "selectSleepCalendar: position = " + i + ", selectDate = " + date);
        this.cZI = date;
        this.dam.ll(i);
    }

    public void mo2548t(Date date) {
        MFLogger.m12670d(TAG, "loadSleepMonthData: calendar = " + date);
        this.cZJ = date;
        this.cFC.destroyLoader(11);
        this.cFC.mo3100a(11, null, this);
    }

    public gx<List<MFSleepDay>> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "LOADER_SLEEP_SUMMARIES onCreateLoader: mCurrentMonth = " + this.cZJ);
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
        this.mUseCaseHandler.m6886a(this.dae, new C2974a(this.cZJ, cmq.m7114c(this.cZI).booleanValue()), null);
        this.dan.setCalendar(fZ, date);
        return this.dan;
    }

    public void m9110a(gx<List<MFSleepDay>> gxVar, List<MFSleepDay> list) {
        MFLogger.m12670d(TAG, "LOADER_SLEEP_SUMMARIES onLoadFinished: data = " + list);
        this.dam.ao(list);
    }

    public void mo2129a(gx<List<MFSleepDay>> gxVar) {
        MFLogger.m12670d(TAG, "LOADER_SLEEP_SUMMARIES onLoaderReset");
    }

    public void m9114x(Date date) {
        this.cZI = date;
    }
}
