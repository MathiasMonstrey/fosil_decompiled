package com.fossil;

import android.os.Bundle;
import com.fossil.dmv.C2924a;
import com.fossil.dmv.C2975b;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.loader.SleepSummaryLoader;
import java.util.Date;

public class dmx implements C2924a {
    private static final String TAG = dmx.class.getSimpleName();
    private final fj cFC;
    private final C2975b dau;
    private final SleepSummaryLoader dav;
    private Date mDate;

    class C29791 implements C2426a<MFSleepDay> {
        final /* synthetic */ dmx daw;

        C29791(dmx com_fossil_dmx) {
            this.daw = com_fossil_dmx;
        }

        public gx<MFSleepDay> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dmx.TAG, "LOADER_ACTIVITIES_DAY onCreateLoader: mDate = " + this.daw.mDate);
            if (this.daw.mDate == null) {
                return null;
            }
            this.daw.dav.setDate(this.daw.mDate);
            return this.daw.dav;
        }

        public void m9124a(gx<MFSleepDay> gxVar, MFSleepDay mFSleepDay) {
            MFLogger.m12670d(dmx.TAG, "LOADER_ACTIVITIES_DAY onLoadFinished: data = " + mFSleepDay);
            this.daw.dau.mo2572a(mFSleepDay);
        }

        public void mo2129a(gx<MFSleepDay> gxVar) {
            MFLogger.m12670d(dmx.TAG, "LOADER_ACTIVITIES_DAY onLoaderReset");
        }
    }

    dmx(C2975b c2975b, fj fjVar, SleepSummaryLoader sleepSummaryLoader) {
        this.dau = c2975b;
        this.cFC = fjVar;
        this.dav = sleepSummaryLoader;
    }

    public void ahu() {
        this.dau.cK(this);
    }

    public void arL() {
        if (this.cFC.aN(10) != null) {
            this.cFC.destroyLoader(10);
        }
        this.cFC.mo3100a(10, null, new C29791(this));
    }

    public void setDate(Date date) {
        this.mDate = date;
        this.dav.setDate(date);
    }
}
