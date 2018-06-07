package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.buttonservice.ble.ScanService;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.SummariesDataSource.UpdateStepGoalCallback;
import com.portfolio.platform.data.source.SummariesRepository;
import java.util.Date;

public class dpj extends ckb<C3056a, C2133c, C3057b> {
    private final ActivitiesRepository cxG;
    private final SummariesRepository mSummariesRepository;

    public static class C3056a implements C2132b {
        private final int cGo;

        public C3056a(int i) {
            this.cGo = i;
        }

        public int getStepGoal() {
            return this.cGo;
        }
    }

    public static final class C3057b implements C2131a {
        private int errorCode;

        public C3057b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9331a((C3056a) c2132b);
    }

    dpj(SummariesRepository summariesRepository, ActivitiesRepository activitiesRepository) {
        this.mSummariesRepository = summariesRepository;
        this.cxG = activitiesRepository;
    }

    protected void m9331a(final C3056a c3056a) {
        this.mSummariesRepository.updateLastStepGoal(new Date(), c3056a.getStepGoal(), new UpdateStepGoalCallback(this) {
            final /* synthetic */ dpj dcT;

            public void onUpdateStepGoalFinish(MFResponse mFResponse, boolean z) {
                if (z) {
                    this.dcT.mSummariesRepository.refresh();
                    this.dcT.cxG.refresh();
                    cml.abG().m7097i(c3056a.getStepGoal(), ScanService.RETRIEVE_DEVICE_BOND_RSSI_MARK, "");
                    this.dcT.abr().onSuccess(null);
                    return;
                }
                this.dcT.abr().onError(new C3057b(mFResponse.getHttpReturnCode()));
            }
        });
    }
}
