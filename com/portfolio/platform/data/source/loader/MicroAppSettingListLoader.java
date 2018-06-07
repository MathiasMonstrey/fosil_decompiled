package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingListCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository.MicroAppSettingRepositoryObserver;
import java.util.ArrayList;
import java.util.List;

public class MicroAppSettingListLoader extends BaseLoader<List<MicroAppSetting>> implements MicroAppSettingRepositoryObserver {
    private static final String TAG = MicroAppSettingsLoader.class.getSimpleName();
    private MicroAppSettingRepository mRepository;

    public MicroAppSettingListLoader(Context context, MicroAppSettingRepository microAppSettingRepository) {
        super(context);
        this.mRepository = microAppSettingRepository;
    }

    public void setMicroAppId(String str) {
        MFLogger.d(TAG, "setMicroAppId microAppId=" + str);
    }

    public List<MicroAppSetting> loadInBackground() {
        MFLogger.d(TAG, "loadInBackground");
        MFLogger.d(TAG, "Inside loadInBackground in thread=" + Thread.currentThread().getName());
        final List<MicroAppSetting> arrayList = new ArrayList();
        this.mRepository.getMicroAppSettingListInDB(new MicroAppSettingListCallback() {
            public void onSuccess(List<MicroAppSetting> list) {
                MFLogger.d(MicroAppSettingListLoader.TAG, "executeUseCase onSuccess");
                arrayList.addAll(list);
            }

            public void onFail() {
                MFLogger.d(MicroAppSettingListLoader.TAG, "executeUseCase onFail");
            }
        });
        MFLogger.d(TAG, "After call get micro app setting in db");
        return arrayList;
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCachedSettingListAvailable());
        if (this.mRepository.isCachedSettingListAvailable()) {
            deliverResult(this.mRepository.getCachedSettingList());
        }
        this.mRepository.addMicroAppSettingRepositoryObserver(this);
        if (takeContentChanged() || !this.mRepository.isCachedSettingListAvailable()) {
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
