package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Integration;
import com.portfolio.platform.data.source.IntegrationRepository;
import com.portfolio.platform.data.source.IntegrationRepository.IntegrationRepositoryObserver;
import java.util.List;

public class IntegrationLoader extends BaseLoader<List<Integration>> implements IntegrationRepositoryObserver {
    private static final String TAG = IntegrationLoader.class.getSimpleName();
    public IntegrationRepository mRepository;

    public IntegrationLoader(Context context) {
        super(context);
        PortfolioApp.ZQ().aam().a(this);
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCachedWidgetAvailable());
        if (this.mRepository.isCachedWidgetAvailable()) {
            deliverResult(this.mRepository.getCachedIntegration());
        }
        this.mRepository.addContentObserver(this);
        if (takeContentChanged() || !this.mRepository.isCachedWidgetAvailable()) {
            MFLogger.d(TAG, "Inside onStartLoading forceReload");
            forceLoad();
        }
    }

    public List<Integration> loadInBackground() {
        return this.mRepository.getAllIntegrations(null);
    }

    public void onIntegrationDataChanged() {
        MFLogger.d(TAG, "Inside .onIntegrationDataChanged, isStarted=" + isStarted());
        if (isStarted()) {
            forceLoad();
        }
    }

    protected void onReset() {
        this.mRepository.removeContentObserver(this);
        super.onReset();
    }
}
