package com.fossil;

import android.os.Bundle;
import android.util.LongSparseArray;
import com.fossil.dmc.C2953a;
import com.fossil.dmc.C2954b;
import com.fossil.fj.C2426a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.ActivitiesWeekLoader;
import java.util.Date;
import java.util.List;

public class dme implements C2953a {
    private static final String TAG = dme.class.getSimpleName();
    private final fj cFC;
    private final C2954b cZV;
    private final ActivitiesWeekLoader cZW;
    private Date cZX = new Date();
    private final UserRepository mUserRepository;

    class C29571 implements C2426a<jt<LongSparseArray<List<Float>>, Integer>> {
        final /* synthetic */ dme cZY;

        C29571(dme com_fossil_dme) {
            this.cZY = com_fossil_dme;
        }

        public gx<jt<LongSparseArray<List<Float>>, Integer>> mo2137b(int i, Bundle bundle) {
            MFUser currentUser = this.cZY.mUserRepository.getCurrentUser();
            if (currentUser == null) {
                return null;
            }
            MFLogger.m12670d(dme.TAG, "LOADER_ACTIVITIES_WEEK onCreateLoader: mCurrentWeek = " + this.cZY.cZX);
            Date startOfDay = cmq.getStartOfDay(cmq.fZ(currentUser.getCreatedAt()));
            if (!cmq.m7111b(this.cZY.cZX, startOfDay)) {
                startOfDay = cmq.m7134l(this.cZY.cZX).getTime();
            }
            Date endOfDay = cmq.getEndOfDay(cmq.m7111b(this.cZY.cZX, new Date()) ? new Date() : cmq.m7135m(this.cZY.cZX).getTime());
            if (endOfDay.getTime() < startOfDay.getTime()) {
                return null;
            }
            this.cZY.cZW.setDate(startOfDay, endOfDay);
            return this.cZY.cZW;
        }

        public void m9060a(gx<jt<LongSparseArray<List<Float>>, Integer>> gxVar, jt<LongSparseArray<List<Float>>, Integer> jtVar) {
            MFLogger.m12670d(dme.TAG, "LOADER_ACTIVITIES_WEEK onLoadFinished: data = " + ((LongSparseArray) jtVar.first).size() + ", stepGoal=" + jtVar.second);
            this.cZY.cZV.mo2562a(this.cZY.cZX, (LongSparseArray) jtVar.first, ((Integer) jtVar.second).intValue());
        }

        public void mo2129a(gx<jt<LongSparseArray<List<Float>>, Integer>> gxVar) {
            MFLogger.m12670d(dme.TAG, "LOADER_ACTIVITIES_WEEK onLoaderReset");
        }
    }

    dme(C2954b c2954b, fj fjVar, ActivitiesWeekLoader activitiesWeekLoader, UserRepository userRepository) {
        this.cZV = c2954b;
        this.cFC = fjVar;
        this.cZW = activitiesWeekLoader;
        this.mUserRepository = userRepository;
    }

    public void ahu() {
        this.cZV.cK(this);
    }

    public void asc() {
        MFLogger.m12670d(TAG, "startStatsActivityWeek");
        this.cZV.mo2563y(this.cZX);
        this.cFC.mo3100a(18, null, new C29571(this));
    }

    public void m9067z(Date date) {
        this.cZX = date;
        if (this.cFC.aN(18) != null) {
            this.cFC.destroyLoader(18);
        }
    }
}
