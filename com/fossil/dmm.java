package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.UserRepository;
import java.util.Calendar;
import java.util.Date;

public class dmm extends ckb<C2966a, C2133c, C2131a> {
    private static final String TAG = dmm.class.getSimpleName();
    private final SleepSessionsRepository mRepository;
    private final UserRepository mUserRepository;

    public static final class C2966a implements C2132b {
        private final boolean cZB;
        private final Date mDate;

        public C2966a(Date date, boolean z) {
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
        m9094a((C2966a) c2132b);
    }

    dmm(SleepSessionsRepository sleepSessionsRepository, UserRepository userRepository) {
        this.mRepository = sleepSessionsRepository;
        this.mUserRepository = userRepository;
    }

    protected void m9094a(C2966a c2966a) {
        Date date = c2966a.getDate();
        MFLogger.m12670d(TAG, "executeUseCase: date = " + date);
        if (this.mUserRepository.getCurrentUser() == null || TextUtils.isEmpty(this.mUserRepository.getCurrentUser().getCreatedAt())) {
            MFLogger.m12670d(TAG, "executeUseCase FAIL!! with currentUser=" + this.mUserRepository.getCurrentUser());
            return;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        Calendar instance3 = Calendar.getInstance();
        instance3.setTime(date);
        Date fZ = cmq.fZ(this.mUserRepository.getCurrentUser().getCreatedAt());
        if (cmq.m7129g(date.getTime(), fZ.getTime())) {
            instance.setTime(fZ);
        } else {
            instance = cmq.m7136n(date);
        }
        if (cmq.m7129g(date.getTime(), new Date().getTime())) {
            instance2.setTime(new Date());
        } else {
            instance2.setTime(date);
            instance2 = cmq.m7127g(instance2);
        }
        int i = instance2.get(4);
        for (int i2 = instance.get(4); i2 <= i; i2++) {
            instance3.set(4, i2);
            Date time = cmq.m7119d(instance3).getTime();
            if (cmq.m7123e(fZ, time)) {
                time = cmq.getStartOfDay(fZ);
            }
            Date time2 = cmq.m7121e(instance3).getTime();
            if (cmq.m7123e(time2, new Date())) {
                time2 = cmq.getEndOfDay(new Date());
            }
            if (time.getTime() <= time2.getTime() && (this.mRepository.getCachedSleepSessionList(time, time2).size() < cmq.m7117d(time, time2) + 1 || cmq.m7118d(time2).booleanValue())) {
                if (c2966a.arT() && cmq.m7118d(time2).booleanValue()) {
                    this.mRepository.getSleepSessionList(time, time2, null);
                } else {
                    this.mRepository.fetch(time, time2);
                }
            }
        }
    }
}
