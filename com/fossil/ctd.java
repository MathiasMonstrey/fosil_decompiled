package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.PinObject;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.SleepSessionsDataSource;
import com.portfolio.platform.data.source.local.SleepSessionsLocalDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.helper.GsonConvertDateTime;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

public class ctd extends ckb<C2288a, C2133c, C2131a> {
    private static final String TAG = ctd.class.getSimpleName();
    private SleepSessionsLocalDataSource cEn;
    private ActivitiesRepository cxG;

    public static final class C2288a implements C2132b {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7497a((C2288a) c2132b);
    }

    ctd(ActivitiesRepository activitiesRepository, @Local SleepSessionsDataSource sleepSessionsDataSource) {
        this.cxG = (ActivitiesRepository) cco.m5996s(activitiesRepository, "activitiesLocalDataSource cannot be null!");
        this.cEn = (SleepSessionsLocalDataSource) cco.m5996s(sleepSessionsDataSource, "sleepSessionsLocalDataSource cannot be null!");
    }

    protected void m7497a(C2288a c2288a) {
        if (this.cEn == null) {
            MFLogger.m12670d(TAG, "ActivitiesLocalDataSource or SleepSessionLocalDataSource is null");
        } else if (TextUtils.isEmpty(dqz.aum().cp(PortfolioApp.ZQ()))) {
            MFLogger.m12670d(TAG, "There is no user here. No need to migrate");
        } else {
            cpf acq = cnq.acd().acq();
            List<PinObject> hu = acq.hu("FitnessSample");
            List<SampleRaw> arrayList = new ArrayList();
            for (PinObject pinObject : hu) {
                SampleRaw sampleRaw = (SampleRaw) new cfj().m6205c(pinObject.getJsonData(), SampleRaw.class);
                if (sampleRaw != null) {
                    arrayList.add(sampleRaw);
                }
                acq.mo2005b(pinObject);
            }
            for (SampleRaw sampleRaw2 : arrayList) {
                sampleRaw2.setPinType(1);
                this.cxG.updateActivityPinType(sampleRaw2);
            }
            hu = acq.hu("MFSleepSessionUpload");
            List<MFSleepSession> arrayList2 = new ArrayList();
            for (PinObject pinObject2 : hu) {
                MFSleepSession mFSleepSession = (MFSleepSession) new cfk().m6207a(DateTime.class, new GsonConvertDateTime()).Wu().m6205c(pinObject2.getJsonData(), MFSleepSession.class);
                if (mFSleepSession != null) {
                    arrayList2.add(mFSleepSession);
                }
                acq.mo2005b(pinObject2);
            }
            for (MFSleepSession mFSleepSession2 : arrayList2) {
                mFSleepSession2.setPinType(1);
                this.cEn.updateSleepSessionPinType(mFSleepSession2, 1);
            }
        }
    }
}
