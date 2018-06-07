package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.data.source.UserRepository;
import java.util.Calendar;
import java.util.Date;

public class dlv extends ckb<C2946a, C2133c, C2131a> {
    private static final String TAG = dlv.class.getSimpleName();
    private final SummariesRepository mSummariesRepository;
    private final UserRepository mUserRepository;

    public static final class C2946a implements C2132b {
        private final boolean cZB;
        private final Date mDate;

        public C2946a(Date date, boolean z) {
            this.mDate = date;
            this.cZB = z;
        }

        public Date getDate() {
            return this.mDate;
        }

        public boolean arT() {
            return this.cZB;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9038a((C2946a) c2132b);
    }

    dlv(SummariesRepository summariesRepository, UserRepository userRepository) {
        this.mSummariesRepository = summariesRepository;
        this.mUserRepository = userRepository;
    }

    protected void m9038a(C2946a c2946a) {
        Date date = c2946a.getDate();
        MFLogger.m12670d(TAG, "executeUseCase: date = " + date);
        if (this.mUserRepository.getCurrentUser() == null || TextUtils.isEmpty(this.mUserRepository.getCurrentUser().getCreatedAt())) {
            MFLogger.m12670d(TAG, "executeUseCase FAIL!! with currentUser=" + this.mUserRepository.getCurrentUser());
            return;
        }
        Date date2;
        Date fZ = cmq.fZ(this.mUserRepository.getCurrentUser().getCreatedAt());
        if (cmq.m7129g(new Date().getTime(), date.getTime())) {
            date2 = new Date();
        } else {
            date2 = cmq.m7137o(date).getTime();
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        date = date2;
        for (int i = 0; i < 3; i++) {
            instance.add(2, -i);
            instance.set(5, 1);
            if (cmq.m7129g(instance.getTimeInMillis(), fZ.getTime())) {
                date2 = fZ;
            } else {
                date2 = cmq.m7125f(instance).getTime();
                if (cmq.m7123e(fZ, date2)) {
                    return;
                }
            }
            if (this.mSummariesRepository.getSummary(date2) == null) {
                if (c2946a.arT() && cmq.m7114c(date2).booleanValue()) {
                    this.mSummariesRepository.getSummary(date2, null);
                } else {
                    this.mSummariesRepository.fetch(date2);
                }
            }
            if (this.mSummariesRepository.loadSummaries(date2, date).size() < cmq.m7117d(date2, date) + 1 || cmq.m7120e(date2).booleanValue()) {
                if (cmq.m7120e(date2).booleanValue()) {
                    date = new Date();
                } else {
                    date = cmq.m7137o(date2).getTime();
                }
                if (c2946a.arT() && cmq.m7120e(date).booleanValue()) {
                    this.mSummariesRepository.loadSummaries(date2, date, null);
                } else {
                    this.mSummariesRepository.fetch(date2, date);
                }
            }
        }
    }
}
