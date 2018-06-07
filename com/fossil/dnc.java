package com.fossil;

import android.os.Bundle;
import android.util.LongSparseArray;
import com.fossil.dna.C2980a;
import com.fossil.dna.C2981b;
import com.fossil.fj.C2426a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.SleepSessionsWeekLoader;
import java.util.Date;
import java.util.List;

public class dnc implements C2980a {
    private static final String TAG = dnc.class.getSimpleName();
    private final fj cFC;
    private Date cZX = new Date();
    private final C2981b daB;
    private final SleepSessionsWeekLoader daC;
    private final ckc mUseCaseHandler;
    private final UserRepository mUserRepository;

    class C29841 implements C2426a<jt<LongSparseArray<List<Float>>, Integer>> {
        final /* synthetic */ dnc daD;

        C29841(dnc com_fossil_dnc) {
            this.daD = com_fossil_dnc;
        }

        public gx<jt<LongSparseArray<List<Float>>, Integer>> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dnc.TAG, "LOADER_SLEEP_SESSIONS_WEEK onCreateLoader: mCurrentWeek = " + this.daD.cZX);
            MFUser currentUser = this.daD.mUserRepository.getCurrentUser();
            if (currentUser == null) {
                return null;
            }
            Date startOfDay = cmq.getStartOfDay(cmq.fZ(currentUser.getCreatedAt()));
            if (!cmq.m7111b(this.daD.cZX, startOfDay)) {
                startOfDay = cmq.m7134l(this.daD.cZX).getTime();
            }
            Date endOfDay = cmq.getEndOfDay(cmq.m7111b(this.daD.cZX, new Date()) ? new Date() : cmq.m7135m(this.daD.cZX).getTime());
            if (endOfDay.getTime() < startOfDay.getTime()) {
                return null;
            }
            this.daD.daC.setDate(startOfDay, endOfDay);
            return this.daD.daC;
        }

        public void m9139a(gx<jt<LongSparseArray<List<Float>>, Integer>> gxVar, jt<LongSparseArray<List<Float>>, Integer> jtVar) {
            MFLogger.m12670d(dnc.TAG, "LOADER_SLEEP_SESSIONS_WEEK onLoadFinished: data = " + jtVar.first + ", sleepGoal=" + jtVar.second);
            this.daD.daB.mo2573b(this.daD.cZX, (LongSparseArray) jtVar.first, ((Integer) jtVar.second).intValue());
        }

        public void mo2129a(gx<jt<LongSparseArray<List<Float>>, Integer>> gxVar) {
            MFLogger.m12670d(dnc.TAG, "LOADER_SLEEP_SESSIONS_WEEK onLoaderReset");
        }
    }

    dnc(C2981b c2981b, fj fjVar, SleepSessionsWeekLoader sleepSessionsWeekLoader, UserRepository userRepository, ckc com_fossil_ckc) {
        this.daB = c2981b;
        this.cFC = fjVar;
        this.daC = sleepSessionsWeekLoader;
        this.mUserRepository = userRepository;
        this.mUseCaseHandler = com_fossil_ckc;
    }

    public void ahu() {
        this.daB.cK(this);
    }

    public void asn() {
        MFLogger.m12670d(TAG, "startStatsSleepWeek()");
        this.daB.mo2574y(this.cZX);
        this.cFC.mo3100a(19, null, new C29841(this));
    }

    public void m9146z(Date date) {
        this.cZX = date;
        if (this.cFC.aN(19) != null) {
            this.cFC.destroyLoader(19);
        }
    }
}
