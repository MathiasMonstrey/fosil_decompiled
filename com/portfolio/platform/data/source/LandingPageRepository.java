package com.portfolio.platform.data.source;

import android.util.SparseArray;
import com.fossil.emj;
import com.fossil.tx;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.data.source.LandingPageDataSource.GetListLandingPageCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import java.util.ArrayList;
import java.util.List;

public class LandingPageRepository implements LandingPageDataSource {
    private static final int CACHED_KEY_LANDINGPAGE = 2;
    private static final String TAG = LandingPageRepository.class.getSimpleName();
    SparseArray<List<LandingPage>> mCachedLandingPage;
    boolean mIsCachedLandingPageDirty;
    private final LandingPageDataSource mLandingPageLocalDataSource;
    private final LandingPageDataSource mLandingPageRemoteDataSource;
    private volatile List<LandingPageRepositoryObserver> mObservers = new ArrayList();

    class C47731 implements GetListLandingPageCallback {
        C47731() {
        }

        public void onSuccess(List<LandingPage> list) {
            MFLogger.d(LandingPageRepository.TAG, "Inside .getAllWidget download updated widget success, newWidgetList=" + list);
            LandingPageRepository.this.addOrUpdateLandingPage(list);
            LandingPageRepository.this.processLandingPageList(list);
            LandingPageRepository.this.notifyLandingPagesChanged();
        }

        public void onFailed(int i) {
            MFLogger.d(LandingPageRepository.TAG, "Inside .getAllWidget download widget failed with errorCode=" + i);
        }
    }

    class C47742 implements GetListLandingPageCallback {
        C47742() {
        }

        public void onSuccess(List<LandingPage> list) {
            MFLogger.d(LandingPageRepository.TAG, "Inside .preloadLandingPage download all landing page success, newLandingPageList=" + list);
            LandingPageRepository.this.addOrUpdateLandingPage(list);
            LandingPageRepository.this.processLandingPageList(list);
            LandingPageRepository.this.notifyLandingPagesChanged();
            for (LandingPage landingPage : list) {
                MFLogger.d(LandingPageRepository.TAG, "Preload landingPage url=" + landingPage.getBackgroundUrl());
                tx.m13753G(PortfolioApp.ZQ()).ah(landingPage.getBackgroundUrl()).bb(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            }
        }

        public void onFailed(int i) {
            MFLogger.d(LandingPageRepository.TAG, "Inside .getAllWidget download widget failed with errorCode=" + i);
        }
    }

    public interface LandingPageRepositoryObserver {
        void onLandingPageDataChanged();
    }

    public LandingPageRepository(@Remote LandingPageDataSource landingPageDataSource, @Local LandingPageDataSource landingPageDataSource2) {
        MFLogger.d(TAG, "Constructor");
        this.mLandingPageLocalDataSource = (LandingPageDataSource) emj.f(landingPageDataSource2, "mLandingPageLocalDataSource cannot be null!");
        this.mLandingPageRemoteDataSource = (LandingPageDataSource) emj.f(landingPageDataSource, "mLandingPageRemoteDataSource cannot be null!");
    }

    public void addContentObserver(LandingPageRepositoryObserver landingPageRepositoryObserver) {
        MFLogger.d(TAG, "Inside .addSavedPresetObserverobserver= " + landingPageRepositoryObserver + ", isContains=" + this.mObservers.contains(landingPageRepositoryObserver) + ", observer size=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        if (!this.mObservers.contains(landingPageRepositoryObserver)) {
            this.mObservers.add(landingPageRepositoryObserver);
        }
    }

    public void removeContentObserver(LandingPageRepositoryObserver landingPageRepositoryObserver) {
        MFLogger.d(TAG, "Inside .removeSavedPresetObserver");
        if (this.mObservers.contains(landingPageRepositoryObserver)) {
            this.mObservers.remove(landingPageRepositoryObserver);
        }
    }

    private void notifyLandingPagesChanged() {
        MFLogger.d(TAG, "Inside .notifyLandingPagesChanged, observerList=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        for (LandingPageRepositoryObserver onLandingPageDataChanged : this.mObservers) {
            onLandingPageDataChanged.onLandingPageDataChanged();
        }
    }

    public boolean isCachedLandingPageAvailable() {
        return (this.mCachedLandingPage == null || isCachedLandingPageDirty()) ? false : true;
    }

    public boolean isCachedLandingPageDirty() {
        return this.mCachedLandingPage == null || this.mIsCachedLandingPageDirty;
    }

    public List<LandingPage> getCachedLandingPage() {
        return this.mCachedLandingPage != null ? (List) this.mCachedLandingPage.get(2) : null;
    }

    private void processLandingPageList(List<LandingPage> list) {
        if (this.mCachedLandingPage == null) {
            this.mCachedLandingPage = new SparseArray();
        }
        this.mCachedLandingPage.clear();
        this.mCachedLandingPage.put(2, list);
        this.mIsCachedLandingPageDirty = false;
    }

    public void addOrUpdateLandingPage(List<LandingPage> list) {
        this.mLandingPageLocalDataSource.addOrUpdateLandingPage(list);
    }

    public List<LandingPage> getAllLandingPage(GetListLandingPageCallback getListLandingPageCallback) {
        MFLogger.d(TAG, "Inside .getAllLandingPage isCachedDirty=" + this.mIsCachedLandingPageDirty);
        if (this.mIsCachedLandingPageDirty) {
            refreshLandingPageData();
            return this.mLandingPageLocalDataSource.getAllLandingPage(getListLandingPageCallback);
        } else if (this.mCachedLandingPage != null && this.mCachedLandingPage.size() != 0) {
            return getCachedLandingPage();
        } else {
            List<LandingPage> allLandingPage = this.mLandingPageLocalDataSource.getAllLandingPage(getListLandingPageCallback);
            if (allLandingPage != null && !allLandingPage.isEmpty()) {
                return allLandingPage;
            }
            refreshLandingPageData();
            return allLandingPage;
        }
    }

    private void refreshLandingPageData() {
        this.mLandingPageRemoteDataSource.getAllLandingPage(new C47731());
    }

    public void refreshLandingPage() {
        this.mIsCachedLandingPageDirty = true;
        refreshLandingPageData();
    }

    public void preloadLandingPage() {
        List allLandingPage = this.mLandingPageLocalDataSource.getAllLandingPage(null);
        if (allLandingPage == null || allLandingPage.isEmpty()) {
            this.mLandingPageRemoteDataSource.getAllLandingPage(new C47742());
        } else {
            MFLogger.d(TAG, "No need to preload landing page");
        }
    }
}
