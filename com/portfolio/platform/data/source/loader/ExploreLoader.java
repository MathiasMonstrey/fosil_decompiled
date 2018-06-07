package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Explore;
import com.portfolio.platform.data.source.ExploreRepository;
import com.portfolio.platform.data.source.ExploreRepository.ExploreRepositoryObserver;
import java.util.List;

public class ExploreLoader extends BaseLoader<List<Explore>> implements ExploreRepositoryObserver {
    private static final String TAG = ExploreLoader.class.getSimpleName();
    public ExploreRepository mRepository;

    public ExploreLoader(Context context) {
        super(context);
        PortfolioApp.ZQ().aam().a(this);
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCachedExploreAvailable());
        if (this.mRepository.isCachedExploreAvailable()) {
            deliverResult(this.mRepository.getCachedExplore());
        }
        this.mRepository.addContentObserver(this);
        if (takeContentChanged() || !this.mRepository.isCachedExploreAvailable()) {
            MFLogger.d(TAG, "Inside onStartLoading forceReload");
            forceLoad();
        }
    }

    public List<Explore> loadInBackground() {
        return this.mRepository.getAllExplore(null);
    }

    public void onExploreDataChanged() {
        MFLogger.d(TAG, "Inside .onExploreDataChanged, isStarted=" + isStarted());
        if (isStarted()) {
            forceLoad();
        }
    }

    protected void onReset() {
        this.mRepository.removeContentObserver(this);
        super.onReset();
    }
}
