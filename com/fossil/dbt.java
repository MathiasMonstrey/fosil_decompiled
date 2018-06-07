package com.fossil;

import android.os.Bundle;
import android.util.SparseArray;
import com.fossil.dbr.C2632a;
import com.fossil.dbr.C2633b;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.loader.NotificationsLoader;
import java.util.List;

public class dbt implements C2632a, C2426a<SparseArray<List<BaseFeatureModel>>> {
    private static final String TAG = dbt.class.getSimpleName();
    private fj cFC;
    private C2633b cOL;
    private NotificationsLoader cOM;
    private LandingPageRepository mLandingPageRepository;

    dbt(C2633b c2633b, fj fjVar, LandingPageRepository landingPageRepository, NotificationsLoader notificationsLoader) {
        this.cOL = (C2633b) cco.m5996s(c2633b, "mHomeNotificationsView cannot be null!");
        this.cOM = notificationsLoader;
        this.cFC = fjVar;
        this.mLandingPageRepository = landingPageRepository;
        this.cOL.cK(this);
    }

    public void start() {
        if (this.cFC.aN(3) != null) {
            this.cFC.destroyLoader(3);
        }
        this.cFC.mo3100a(3, null, this);
        alm();
    }

    public void stop() {
    }

    public gx<SparseArray<List<BaseFeatureModel>>> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "Inside .onCreateLoader id=" + i);
        return this.cOM;
    }

    public void m8175a(gx<SparseArray<List<BaseFeatureModel>>> gxVar, SparseArray<List<BaseFeatureModel>> sparseArray) {
        if (sparseArray == null) {
            this.cOL.alq();
        } else {
            this.cOL.mo2245a(sparseArray);
        }
    }

    public void mo2129a(gx<SparseArray<List<BaseFeatureModel>>> gxVar) {
    }

    public void alm() {
        List<LandingPage> allLandingPage = this.mLandingPageRepository.getAllLandingPage(null);
        if (allLandingPage != null && !allLandingPage.isEmpty()) {
            for (LandingPage landingPage : allLandingPage) {
                if (landingPage.getType().equals("home2")) {
                    this.cOL.mo2247b(landingPage);
                    return;
                }
            }
        }
    }
}
