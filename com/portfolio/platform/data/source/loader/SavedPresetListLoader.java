package com.portfolio.platform.data.source.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetListCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.PresetRepository.SavedPresetRepositoryObserver;
import java.util.ArrayList;
import java.util.List;

public class SavedPresetListLoader extends BaseLoader<List<SavedPreset>> implements SavedPresetRepositoryObserver {
    private static final String TAG = SavedPresetListLoader.class.getSimpleName();
    private final Object mLocker = new Object();
    private final PresetRepository mRepository;

    SavedPresetListLoader(Context context, PresetRepository presetRepository) {
        super(context);
        this.mRepository = presetRepository;
    }

    public List<SavedPreset> loadInBackground() {
        MFLogger.d(TAG, "loadInBackground");
        final List<SavedPreset> arrayList = new ArrayList();
        Handler handler = new Handler(Looper.getMainLooper());
        synchronized (this.mLocker) {
            handler.postDelayed(new Runnable() {

                class C48571 implements GetSavedPresetListCallback {
                    C48571() {
                    }

                    public void onSuccess(List<SavedPreset> list) {
                        MFLogger.d(SavedPresetListLoader.TAG, "loadInBackground onSuccess savedPresetListSize=" + list.size());
                        arrayList.addAll(list);
                        synchronized (SavedPresetListLoader.this.mLocker) {
                            SavedPresetListLoader.this.mLocker.notify();
                        }
                    }

                    public void onFail() {
                        MFLogger.d(SavedPresetListLoader.TAG, "loadInBackground onFail");
                        synchronized (SavedPresetListLoader.this.mLocker) {
                            SavedPresetListLoader.this.mLocker.notify();
                        }
                    }
                }

                public void run() {
                    SavedPresetListLoader.this.mRepository.getAllUserPresetsFromDB(PortfolioApp.ZQ().aaa(), new C48571());
                }
            }, 100);
            try {
                MFLogger.d(TAG, "Await on thread=" + Thread.currentThread().getName());
                this.mLocker.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCachedMappingSetAvailable());
        if (this.mRepository.isCachedMappingSetAvailable()) {
            deliverResult(this.mRepository.getCachedMappingSetList());
        }
        this.mRepository.addSavedPresetObserver(this);
        if (takeContentChanged() || !this.mRepository.isCachedMappingSetAvailable()) {
            MFLogger.d(TAG, "Inside onStartLoading forceReload");
            forceLoad();
        }
    }

    protected void onReset() {
        this.mRepository.removeSavedPresetObserver(this);
        super.onReset();
    }

    public void onSavedPresetChange() {
        if (isStarted()) {
            MFLogger.d(TAG, "Force load mapping set list");
            forceLoad();
        }
    }
}
