package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSummariesDataSource.UpdateSleepGoalCallback;
import com.portfolio.platform.data.source.SleepSummariesRepository;

public class dph extends ckb<C3053a, C2133c, C3054b> {
    private final SleepSessionsRepository cBa;
    private final SleepSummariesRepository mSummariesRepository;

    class C30521 implements UpdateSleepGoalCallback {
        final /* synthetic */ dph dcQ;

        C30521(dph com_fossil_dph) {
            this.dcQ = com_fossil_dph;
        }

        public void onUpdateSleepGoalFinish(MFResponse mFResponse, boolean z) {
            if (z) {
                this.dcQ.mSummariesRepository.refresh();
                this.dcQ.cBa.refresh();
                this.dcQ.abr().onSuccess(null);
                return;
            }
            this.dcQ.abr().onError(new C3054b(mFResponse.getHttpReturnCode()));
        }
    }

    public static class C3053a implements C2132b {
        private final int dcJ;

        public C3053a(int i) {
            this.dcJ = i;
        }

        public int atB() {
            return this.dcJ;
        }
    }

    public static final class C3054b implements C2131a {
        private int errorCode;

        public C3054b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9327a((C3053a) c2132b);
    }

    dph(SleepSummariesRepository sleepSummariesRepository, SleepSessionsRepository sleepSessionsRepository) {
        this.mSummariesRepository = sleepSummariesRepository;
        this.cBa = sleepSessionsRepository;
    }

    protected void m9327a(C3053a c3053a) {
        this.mSummariesRepository.updateLastSleepGoal(c3053a.atB(), new C30521(this));
    }
}
