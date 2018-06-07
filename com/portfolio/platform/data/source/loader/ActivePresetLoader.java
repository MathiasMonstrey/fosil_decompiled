package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.PresetRepository.ActivePresetRepositoryObserver;
import java.util.concurrent.CountDownLatch;

public class ActivePresetLoader extends BaseLoader<ActivePreset> implements ActivePresetRepositoryObserver {
    private static final String TAG = ActivePresetLoader.class.getSimpleName();
    public PresetRepository mRepository;

    ActivePresetLoader(Context context, PresetRepository presetRepository) {
        super(context);
        this.mRepository = presetRepository;
    }

    public ActivePreset loadInBackground() {
        MFLogger.d(TAG, "loadInBackground");
        final ActivePreset activePreset = new ActivePreset();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mRepository.getActivePresetFromDB(PortfolioApp.ZQ().aaa(), new GetActivePresetCallback() {
            public void onSuccess(ActivePreset activePreset) {
                MFLogger.d(ActivePresetLoader.TAG, "loadInBackground onSuccess activePreset=" + activePreset.getSerialNumber());
                activePreset.setOriginalId(activePreset.getOriginalId());
                activePreset.setSerialNumber(activePreset.getSerialNumber());
                activePreset.setButtons(activePreset.getButtons());
                activePreset.setUpdateAt(activePreset.getUpdateAt());
                activePreset.setCreateAt(activePreset.getCreateAt());
                countDownLatch.countDown();
            }

            public void onFail() {
                MFLogger.d(ActivePresetLoader.TAG, "loadInBackground onFail");
                countDownLatch.countDown();
            }
        });
        try {
            MFLogger.d(TAG, "Await on thread=" + Thread.currentThread().getName());
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activePreset;
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCachedActivePreset());
        if (this.mRepository.isCachedActivePreset()) {
            deliverResult(this.mRepository.getCachedActivepreset());
        }
        this.mRepository.addActivePresetObserver(this);
        if (takeContentChanged() || !this.mRepository.isCachedActivePreset()) {
            MFLogger.d(TAG, "Inside onStartLoading forceReload");
            forceLoad();
        }
    }

    protected void onReset() {
        this.mRepository.removeActivePresetObserver(this);
        super.onReset();
    }

    public void onActivePresetChange() {
        if (isStarted()) {
            MFLogger.d(TAG, "Force load mapping set list");
            forceLoad();
        }
    }
}
