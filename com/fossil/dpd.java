package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.portfolio.platform.data.source.SummariesRepository;
import java.util.Date;

public class dpd extends ckb<C3049a, C3050b, C2131a> {
    private final SummariesRepository mSummariesRepository;

    public static class C3049a implements C2132b {
        private final Date mDate;

        public C3049a(Date date) {
            this.mDate = date;
        }

        public Date getDate() {
            return this.mDate;
        }
    }

    public static class C3050b implements C2133c {
        private final int cGo;

        public C3050b(int i) {
            this.cGo = i;
        }

        public int getStepGoal() {
            return this.cGo;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9320a((C3049a) c2132b);
    }

    dpd(SummariesRepository summariesRepository) {
        this.mSummariesRepository = summariesRepository;
    }

    protected void m9320a(C3049a c3049a) {
        abr().onSuccess(new C3050b(this.mSummariesRepository.getLastStepGoal(c3049a.getDate())));
    }
}
