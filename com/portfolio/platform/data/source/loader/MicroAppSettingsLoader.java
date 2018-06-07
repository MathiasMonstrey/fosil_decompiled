package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction$MicroAppID;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository.MicroAppSettingRepositoryObserver;

public class MicroAppSettingsLoader extends BaseLoader<MicroAppSetting> implements MicroAppSettingRepositoryObserver {
    private static final String TAG = MicroAppSettingsLoader.class.getSimpleName();
    private String mMicroAppId = "";
    private MicroAppSettingRepository mRepository;

    MicroAppSettingsLoader(Context context, MicroAppSettingRepository microAppSettingRepository) {
        super(context);
        this.mRepository = microAppSettingRepository;
    }

    public void setMicroAppId(String str) {
        MFLogger.d(TAG, "setMicroAppId microAppId=" + str);
        this.mMicroAppId = str;
    }

    public MicroAppSetting loadInBackground() {
        MFLogger.d(TAG, "loadInBackground");
        MFLogger.d(TAG, "Inside loadInBackground in thread=" + Thread.currentThread().getName());
        final MicroAppSetting microAppSetting = new MicroAppSetting(this.mMicroAppId, "");
        this.mRepository.getMicroAppSettingInDB(this.mMicroAppId, new MicroAppSettingCallback() {
            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.d(MicroAppSettingsLoader.TAG, "executeUseCase onSuccess microAppId=" + MicroAppSettingsLoader.this.mMicroAppId);
                microAppSetting.setMicroAppId(microAppSetting.getMicroAppId());
                microAppSetting.setCreatedAt(microAppSetting.getCreatedAt());
                microAppSetting.setFirstUsed(microAppSetting.getFirstUsed());
                microAppSetting.setLike(microAppSetting.isLike());
                microAppSetting.setPinType(microAppSetting.getPinType());
                microAppSetting.setSetting(microAppSetting.getSetting());
                microAppSetting.setUpdatedAt(microAppSetting.getUpdatedAt());
            }

            public void onFail() {
                MFLogger.d(MicroAppSettingsLoader.TAG, "executeUseCase onFail microAppId=" + MicroAppSettingsLoader.this.mMicroAppId);
                microAppSetting.setMicroAppId(MicroAppInstruction$MicroAppID.UAPP_UNKNOWN.getValue());
            }
        });
        MFLogger.d(TAG, "After call get micro app setting in db");
        if (microAppSetting.getMicroAppId().equals(MicroAppInstruction$MicroAppID.UAPP_UNKNOWN.getValue())) {
            return null;
        }
        return microAppSetting;
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCachedSettingAvailable(this.mMicroAppId));
        if (this.mRepository.isCachedSettingAvailable(this.mMicroAppId)) {
            deliverResult(this.mRepository.getCachedSetting());
        }
        this.mRepository.addMicroAppSettingRepositoryObserver(this);
        if (takeContentChanged() || !this.mRepository.isCachedSettingAvailable(this.mMicroAppId)) {
            MFLogger.d(TAG, "Inside onStartLoading forceReload");
            forceLoad();
        }
    }

    protected void onReset() {
        this.mRepository.removeMicroAppSettingRepositoryObserver(this);
        super.onReset();
    }

    public void onMicroAppChanged() {
        if (isStarted()) {
            MFLogger.d(TAG, "Force load micro app settings");
            forceLoad();
        }
    }
}
