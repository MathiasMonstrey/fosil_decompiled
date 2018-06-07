package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.DeviceRepository.DeviceRepositoryObserver;
import java.util.List;

public class DeviceLoader extends BaseLoader<List<DeviceModel>> implements DeviceRepositoryObserver {
    private static final String TAG = DeviceLoader.class.getSimpleName();
    public DeviceRepository mRepository;

    public DeviceLoader(Context context) {
        super(context);
        PortfolioApp.ZQ().aam().a(this);
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCachedDeviceAvailable());
        if (this.mRepository.isCachedDeviceAvailable()) {
            deliverResult(this.mRepository.getCachedDevice());
        }
        this.mRepository.addContentObserver(this);
        if (takeContentChanged() || !this.mRepository.isCachedDeviceAvailable()) {
            MFLogger.d(TAG, "Inside onStartLoading forceReload");
            forceLoad();
        }
    }

    public List<DeviceModel> loadInBackground() {
        return this.mRepository.getAllDevice(null);
    }

    public void onActiveDeviceChanged() {
        MFLogger.d(TAG, "Inside .onActiveDeviceChanged, isStarted=" + isStarted());
        if (isStarted()) {
            forceLoad();
        }
    }

    protected void onReset() {
        this.mRepository.removeContentObserver(this);
        super.onReset();
    }
}
