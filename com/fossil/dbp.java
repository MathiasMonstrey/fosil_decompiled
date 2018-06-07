package com.fossil;

import android.os.Bundle;
import android.text.TextUtils;
import com.fossil.dbn.C2623a;
import com.fossil.dbn.C2624b;
import com.fossil.fj.C2426a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppGalleryCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.loader.ActivePresetLoader;
import java.util.ArrayList;
import java.util.List;

public class dbp implements C2623a, C2426a<ActivePreset> {
    private static final String TAG = dbp.class.getSimpleName();
    private ActivePreset cEs;
    private fj cFC;
    private C2624b cOC;
    private ActivePresetLoader cOD;
    private List<MicroApp> cOE;
    private LandingPageRepository mLandingPageRepository;
    private MicroAppSettingRepository mMicroAppSettingRepository;

    static /* synthetic */ class C26312 {
        static final /* synthetic */ int[] f1459x96782840 = new int[Pusher.values().length];

        static {
            try {
                f1459x96782840[Pusher.TOP_PUSHER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1459x96782840[Pusher.MID_PUSHER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1459x96782840[Pusher.BOTTOM_PUSHER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public dbp(C2624b c2624b, fj fjVar, ActivePresetLoader activePresetLoader, MicroAppSettingRepository microAppSettingRepository, LandingPageRepository landingPageRepository) {
        this.cOC = (C2624b) cco.m5996s(c2624b, "StatisticsView cannot be null!");
        this.cFC = fjVar;
        this.cOD = activePresetLoader;
        this.mLandingPageRepository = landingPageRepository;
        this.mMicroAppSettingRepository = microAppSettingRepository;
        this.cOC.cK(this);
    }

    public void start() {
        this.cFC.mo3100a(1, null, this);
    }

    public void stop() {
    }

    public gx<ActivePreset> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "Inside .onCreateLoader id=" + i);
        return this.cOD;
    }

    public void m8161a(gx<ActivePreset> gxVar, ActivePreset activePreset) {
        MFLogger.m12670d(TAG, "Inside .onLoadFinished activePreset=" + activePreset.getSerialNumber());
        alm();
        this.cEs = activePreset;
        m8159d(activePreset);
    }

    private void m8159d(final ActivePreset activePreset) {
        MFLogger.m12670d(TAG, "Inside .getMicroAppGallery");
        this.mMicroAppSettingRepository.getMicroAppGallery(PortfolioApp.ZQ().aaa(), new GetMicroAppGalleryCallback(this) {
            final /* synthetic */ dbp cOG;

            public void onSuccess(List<MicroApp> list) {
                MFLogger.m12670d(dbp.TAG, "Inside .getMicroAppGallery onSuccess");
                if (this.cOG.cOE == null) {
                    this.cOG.cOE = new ArrayList();
                }
                this.cOG.cOE.clear();
                this.cOG.cOE.addAll(list);
                if (this.cOG.cOC.isActive()) {
                    this.cOG.cOC.mo2242c(activePreset);
                }
            }

            public void onFail() {
                MFLogger.m12670d(dbp.TAG, "Inside .getMicroAppGallery onFail");
            }
        });
    }

    public void mo2129a(gx<ActivePreset> gxVar) {
        MFLogger.m12670d(TAG, "Inside .onLoaderReset loaderId=" + gxVar.getId());
    }

    public void alm() {
        List<LandingPage> allLandingPage = this.mLandingPageRepository.getAllLandingPage(null);
        if (allLandingPage != null && !allLandingPage.isEmpty()) {
            for (LandingPage landingPage : allLandingPage) {
                if (landingPage.getType().equals("home1")) {
                    this.cOC.mo2241b(landingPage);
                    return;
                }
            }
        }
    }

    public MicroApp fT(String str) {
        for (MicroApp microApp : this.cOE) {
            if (microApp.getAppId().equals(str)) {
                return microApp;
            }
        }
        return null;
    }

    public void mo2243a(Pusher pusher) {
        if (this.cEs != null && this.cOE != null) {
            Object appId;
            String str = "";
            for (ButtonMapping buttonMapping : this.cEs.getButtonMappingList()) {
                Pusher pusherFromValue = Pusher.getPusherFromValue(buttonMapping.getButton());
                MicroApp fT = fT(buttonMapping.getMicroAppId());
                if (pusherFromValue == pusher && fT != null) {
                    appId = fT.getAppId();
                    break;
                }
            }
            String str2 = str;
            if (!TextUtils.isEmpty(appId)) {
                int i;
                switch (C26312.f1459x96782840[pusher.ordinal()]) {
                    case 1:
                        i = 1;
                        break;
                    case 2:
                        i = 2;
                        break;
                    case 3:
                        i = 3;
                        break;
                    default:
                        i = 1;
                        break;
                }
                this.cOC.mo2240G(appId, i);
                cnp.acc().gu(String.format("fossilq://main/view=microApp&subView=detail&id=%s", new Object[]{appId}));
            }
        }
    }
}
