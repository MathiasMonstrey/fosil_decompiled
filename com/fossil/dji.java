package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppGalleryCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingListCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetListCallback;
import com.portfolio.platform.data.source.PresetRepository;
import java.util.List;

public class dji extends ckb<C2837a, C2839c, C2838b> {
    private static final String TAG = dji.class.getSimpleName();
    private String bcS;
    MicroAppSettingRepository mMicroAppSettingRepository;
    private PresetRepository mPresetRepository;

    class C28291 implements GetMicroAppGalleryCallback {
        final /* synthetic */ dji cXn;

        C28291(dji com_fossil_dji) {
            this.cXn = com_fossil_dji;
        }

        public void onSuccess(List<MicroApp> list) {
            MFLogger.m12670d(dji.TAG, "Inside .GetDeviceShortcutSettingUseCase downloadMicroAppGallery SUCCESS");
            this.cXn.aql();
        }

        public void onFail() {
            MFLogger.m12670d(dji.TAG, "Inside .GetDeviceShortcutSettingUseCase downloadMicroAppGallery FAILED!!");
            this.cXn.aql();
        }
    }

    class C28302 implements MicroAppSettingListCallback {
        final /* synthetic */ dji cXn;

        C28302(dji com_fossil_dji) {
            this.cXn = com_fossil_dji;
        }

        public void onSuccess(List<MicroAppSetting> list) {
            MFLogger.m12670d(dji.TAG, "Inside .downloadMicroAppSettings SUCCESS");
            this.cXn.aqm();
        }

        public void onFail() {
            MFLogger.m12670d(dji.TAG, "Inside .downloadMicroAppSettings FAILED!!");
            this.cXn.aqm();
        }
    }

    class C28313 implements GetRecommendedPresetListCallback {
        final /* synthetic */ dji cXn;

        C28313(dji com_fossil_dji) {
            this.cXn = com_fossil_dji;
        }

        public void onSuccess(List<RecommendedPreset> list) {
            MFLogger.m12670d(dji.TAG, "Inside .downloadRecommendPreset SUCCESS");
            this.cXn.aqn();
        }

        public void onFail() {
            MFLogger.m12670d(dji.TAG, "Inside .downloadRecommendPreset FAILED!!");
            this.cXn.aqn();
        }
    }

    class C28324 implements GetRecommendedPresetCallback {
        final /* synthetic */ dji cXn;

        C28324(dji com_fossil_dji) {
            this.cXn = com_fossil_dji;
        }

        public void onSuccess(RecommendedPreset recommendedPreset) {
            MFLogger.m12670d(dji.TAG, "Inside .downloadDefaultPreset SUCCESS");
            this.cXn.aqo();
            this.cXn.aqp();
        }

        public void onFail() {
            MFLogger.m12670d(dji.TAG, "Inside .downloadDefaultPreset FAILED!!");
            this.cXn.aqo();
            this.cXn.aqp();
        }
    }

    class C28335 implements GetSavedPresetListCallback {
        final /* synthetic */ dji cXn;

        C28335(dji com_fossil_dji) {
            this.cXn = com_fossil_dji;
        }

        public void onSuccess(List<SavedPreset> list) {
            MFLogger.m12670d(dji.TAG, "Inside .downloadUserPresets SUCCESS");
        }

        public void onFail() {
            MFLogger.m12670d(dji.TAG, "Inside .downloadDefaultPreset FAILED!!");
        }
    }

    class C28346 implements GetActivePresetCallback {
        final /* synthetic */ dji cXn;

        C28346(dji com_fossil_dji) {
            this.cXn = com_fossil_dji;
        }

        public void onSuccess(ActivePreset activePreset) {
            MFLogger.m12670d(dji.TAG, "Inside .GetDeviceShortcutSettingUseCase setActivePreset SUCCESS, savedPreset=" + activePreset);
            this.cXn.abr().onSuccess(new C2839c());
        }

        public void onFail() {
            MFLogger.m12670d(dji.TAG, "Inside .GetDeviceShortcutSettingUseCase setActivePreset FAILED!!");
            this.cXn.aqq();
        }
    }

    class C28367 implements GetRecommendedPresetCallback {
        final /* synthetic */ dji cXn;

        class C28351 implements GetActivePresetCallback {
            final /* synthetic */ C28367 cXo;

            C28351(C28367 c28367) {
                this.cXo = c28367;
            }

            public void onSuccess(ActivePreset activePreset) {
                MFLogger.m12670d(dji.TAG, "Inside .GetDeviceShortcutSettingUseCase activateDefaultPreset SUCCESS");
                this.cXo.cXn.abr().onSuccess(new C2839c());
            }

            public void onFail() {
                MFLogger.m12670d(dji.TAG, "Inside .GetDeviceShortcutSettingUseCase activateDefaultPreset FAILED!!");
                this.cXo.cXn.abr().onError(null);
            }
        }

        C28367(dji com_fossil_dji) {
            this.cXn = com_fossil_dji;
        }

        public void onSuccess(RecommendedPreset recommendedPreset) {
            MFLogger.m12670d(dji.TAG, "Inside .GetDeviceShortcutSettingUseCase getDefaultPreset SUCCESS");
            this.cXn.mPresetRepository.activateDefaultPreset(recommendedPreset, new C28351(this));
        }

        public void onFail() {
            MFLogger.m12670d(dji.TAG, "Inside .GetDeviceShortcutSettingUseCase getDefaultPreset FAILED!!!");
            this.cXn.abr().onError(null);
        }
    }

    public static final class C2837a implements C2132b {
        private final String mSerial;

        public C2837a(String str) {
            this.mSerial = str;
        }

        public String getSerial() {
            return this.mSerial;
        }
    }

    public static final class C2838b implements C2131a {
        private int errorCode;

        public C2838b(int i) {
            this.errorCode = i;
        }
    }

    public static final class C2839c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8830a((C2837a) c2132b);
    }

    public dji(MicroAppSettingRepository microAppSettingRepository, PresetRepository presetRepository) {
        this.mMicroAppSettingRepository = microAppSettingRepository;
        this.mPresetRepository = presetRepository;
    }

    protected void m8830a(C2837a c2837a) {
        this.bcS = c2837a.getSerial();
        MFLogger.m12670d(TAG, "Inside .GetDeviceShortcutSettingUseCase executing!!! with serial=" + this.bcS);
        if (!NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            abr().onError(new C2838b(601));
        } else if (!TextUtils.isEmpty(this.bcS)) {
            this.mMicroAppSettingRepository.notifyStatusChanged("INIT_STATUS", this.bcS);
            MFLogger.m12670d(TAG, "Inside .GetDeviceShortcutSettingUseCase Step1: downloadMicroAppGallery");
            this.mMicroAppSettingRepository.getMicroAppGallery(this.bcS, new C28291(this));
        }
    }

    private void aql() {
        MFLogger.m12670d(TAG, "Inside .GetDeviceShortcutSettingUseCase Step2: downloadMicroAppSettings");
        this.mMicroAppSettingRepository.getMicroAppSettingList(new C28302(this));
    }

    private void aqm() {
        MFLogger.m12670d(TAG, "Inside .GetDeviceShortcutSettingUseCase Step3: downloadRecommendPreset");
        this.mPresetRepository.getRecommendedPresets(((C2837a) abq()).getSerial(), new C28313(this));
    }

    private void aqn() {
        MFLogger.m12670d(TAG, "Inside .GetDeviceShortcutSettingUseCase Step4: downloadDefaultPreset");
        this.mPresetRepository.getDefaultPreset(((C2837a) abq()).getSerial(), new C28324(this), true);
    }

    private void aqo() {
        MFLogger.m12670d(TAG, "Inside .GetDeviceShortcutSettingUseCase Step5: downloadUserPresets");
        this.mPresetRepository.getAllSavedPresets(new C28335(this));
    }

    private void aqp() {
        MFLogger.m12670d(TAG, "Inside .GetDeviceShortcutSettingUseCase Step6: setActivePresetToDB");
        this.mPresetRepository.getActivePreset(this.bcS, new C28346(this));
    }

    private void aqq() {
        MFLogger.m12670d(TAG, "Inside .GetDeviceShortcutSettingUseCase Step7: activeDefaultPreset");
        this.mPresetRepository.getDefaultPreset(((C2837a) abq()).getSerial(), new C28367(this), false);
    }
}
