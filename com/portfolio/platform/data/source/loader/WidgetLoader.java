package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.gk;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Widget;
import com.portfolio.platform.data.source.WidgetRepository;
import com.portfolio.platform.data.source.WidgetRepository.WidgetRepositoryObserver;
import java.util.List;

public class WidgetLoader extends gk<List<Widget>> implements WidgetRepositoryObserver {
    private static final String TAG = WidgetLoader.class.getSimpleName();
    public WidgetRepository mRepository;

    public WidgetLoader(Context context) {
        super(context);
        PortfolioApp.ZQ().aam().a(this);
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCachedWidgetAvailable());
        if (this.mRepository.isCachedWidgetAvailable()) {
            deliverResult(this.mRepository.getCachedWidget());
        }
        this.mRepository.addContentObserver(this);
        if (takeContentChanged() || !this.mRepository.isCachedWidgetAvailable()) {
            MFLogger.d(TAG, "Inside onStartLoading forceReload");
            forceLoad();
        }
    }

    public List<Widget> loadInBackground() {
        return this.mRepository.getAllWidget(null);
    }

    public void onWidgetDataChanged() {
        MFLogger.d(TAG, "Inside .onWidgetDataChanged, isStarted=" + isStarted());
        if (isStarted()) {
            forceLoad();
        }
    }

    protected void onReset() {
        this.mRepository.removeContentObserver(this);
        super.onReset();
    }
}
