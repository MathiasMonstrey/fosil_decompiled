package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import java.util.Date;

public class dpb extends ckb<C3047a, C3048b, C2131a> {
    private static final String TAG = dpb.class.getSimpleName();
    private final SleepSummariesRepository mSummariesRepository;

    public static class C3047a implements C2132b {
        private final Date mDate;

        public C3047a(Date date) {
            this.mDate = date;
        }

        public Date getDate() {
            return this.mDate;
        }
    }

    public static class C3048b implements C2133c {
        private final int dcJ;

        public C3048b(int i) {
            this.dcJ = i;
        }

        public int atB() {
            return this.dcJ;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9317a((C3047a) c2132b);
    }

    dpb(SleepSummariesRepository sleepSummariesRepository) {
        this.mSummariesRepository = sleepSummariesRepository;
    }

    protected void m9317a(C3047a c3047a) {
        MFLogger.m12670d(TAG, "executeUseCase()");
        abr().onSuccess(new C3048b(this.mSummariesRepository.getLastSleepGoal(c3047a.getDate())));
    }
}
