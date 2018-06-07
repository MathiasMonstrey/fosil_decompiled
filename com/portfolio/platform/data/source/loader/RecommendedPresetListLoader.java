package com.portfolio.platform.data.source.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetListCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.PresetRepository.SavedPresetRepositoryObserver;
import java.util.ArrayList;
import java.util.List;

public class RecommendedPresetListLoader extends BaseLoader<List<RecommendedPreset>> implements SavedPresetRepositoryObserver {
    private static final String TAG = SavedPresetListLoader.class.getSimpleName();
    private final Object mLocker = new Object();
    public PresetRepository mRepository;

    RecommendedPresetListLoader(Context context, PresetRepository presetRepository) {
        super(context);
        this.mRepository = presetRepository;
    }

    public List<RecommendedPreset> loadInBackground() {
        final List<RecommendedPreset> arrayList = new ArrayList();
        Handler handler = new Handler(Looper.getMainLooper());
        synchronized (this.mLocker) {
            handler.postDelayed(new Runnable() {

                class C48551 implements GetRecommendedPresetListCallback {
                    C48551() {
                    }

                    public void onSuccess(List<RecommendedPreset> list) {
                        arrayList.addAll(list);
                        synchronized (RecommendedPresetListLoader.this.mLocker) {
                            RecommendedPresetListLoader.this.mLocker.notify();
                        }
                    }

                    public void onFail() {
                        synchronized (RecommendedPresetListLoader.this.mLocker) {
                            RecommendedPresetListLoader.this.mLocker.notify();
                        }
                    }
                }

                public void run() {
                    RecommendedPresetListLoader.this.mRepository.getRecommendedPresets(PortfolioApp.ZQ().aaa(), new C48551());
                }
            }, 100);
            try {
                this.mLocker.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCachedMappingSetAvailable());
        this.mRepository.addSavedPresetObserver(this);
        if (takeContentChanged()) {
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
