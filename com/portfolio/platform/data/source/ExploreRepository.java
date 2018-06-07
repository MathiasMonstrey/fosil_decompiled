package com.portfolio.platform.data.source;

import android.util.SparseArray;
import com.fossil.emj;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.Explore;
import com.portfolio.platform.data.source.ExploreDataSource.GetExploreListCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import java.util.ArrayList;
import java.util.List;

public class ExploreRepository implements ExploreDataSource {
    private static final int CACHED_KEY_EXPLORE = 100;
    private static final String TAG = ExploreRepository.class.getSimpleName();
    SparseArray<List<Explore>> mCachedExplore;
    private final ExploreDataSource mExploreLocalDataSource;
    private final ExploreDataSource mExploreRemoteDataSource;
    boolean mIsCachedExploreDirty;
    private volatile List<ExploreRepositoryObserver> mObservers = new ArrayList();

    class C47711 implements GetExploreListCallback {
        C47711() {
        }

        public void onSuccess(List<Explore> list) {
            MFLogger.d(ExploreRepository.TAG, "Inside .getAllExplore download updated explore success, newExploreList=" + list);
            ExploreRepository.this.addOrUpdateExploreList(list);
            ExploreRepository.this.processExploreList(list);
            ExploreRepository.this.notifyExploreChanged();
        }

        public void onFailed(int i) {
            MFLogger.d(ExploreRepository.TAG, "Inside .getAllExplore download explore failed with errorCode=" + i);
        }
    }

    public interface ExploreRepositoryObserver {
        void onExploreDataChanged();
    }

    public ExploreRepository(@Remote ExploreDataSource exploreDataSource, @Local ExploreDataSource exploreDataSource2) {
        MFLogger.d(TAG, "Constructor");
        this.mExploreLocalDataSource = (ExploreDataSource) emj.f(exploreDataSource2, "mExploreLocalDataSource cannot be null!");
        this.mExploreRemoteDataSource = (ExploreDataSource) emj.f(exploreDataSource, "mExploreRemoteDataSource cannot be null!");
    }

    public void addContentObserver(ExploreRepositoryObserver exploreRepositoryObserver) {
        MFLogger.d(TAG, "Inside .addSavedPresetObserverobserver= " + exploreRepositoryObserver + ", isContains=" + this.mObservers.contains(exploreRepositoryObserver) + ", observer size=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        if (!this.mObservers.contains(exploreRepositoryObserver)) {
            this.mObservers.add(exploreRepositoryObserver);
        }
    }

    public void removeContentObserver(ExploreRepositoryObserver exploreRepositoryObserver) {
        MFLogger.d(TAG, "Inside .removeSavedPresetObserver");
        if (this.mObservers.contains(exploreRepositoryObserver)) {
            this.mObservers.remove(exploreRepositoryObserver);
        }
    }

    private void notifyExploreChanged() {
        MFLogger.d(TAG, "Inside .notifyExploreChanged, observerList=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        for (ExploreRepositoryObserver onExploreDataChanged : this.mObservers) {
            onExploreDataChanged.onExploreDataChanged();
        }
    }

    public boolean isCachedExploreAvailable() {
        return (this.mCachedExplore == null || isCachedExploreDirty()) ? false : true;
    }

    public boolean isCachedExploreDirty() {
        return this.mCachedExplore == null || this.mIsCachedExploreDirty;
    }

    public List<Explore> getCachedExplore() {
        return this.mCachedExplore != null ? (List) this.mCachedExplore.get(100) : null;
    }

    private void processExploreList(List<Explore> list) {
        if (this.mCachedExplore == null) {
            this.mCachedExplore = new SparseArray();
        }
        this.mCachedExplore.clear();
        this.mCachedExplore.put(100, list);
        this.mIsCachedExploreDirty = false;
    }

    public void addOrUpdateExploreList(List<Explore> list) {
        this.mExploreLocalDataSource.addOrUpdateExploreList(list);
    }

    public List<Explore> getAllExplore(GetExploreListCallback getExploreListCallback) {
        MFLogger.d(TAG, "Inside .getAllExplore isCachedDirty=" + this.mIsCachedExploreDirty);
        if (this.mIsCachedExploreDirty) {
            refreshExploreData();
            return this.mExploreLocalDataSource.getAllExplore(getExploreListCallback);
        } else if (this.mCachedExplore != null && this.mCachedExplore.size() != 0) {
            return getCachedExplore();
        } else {
            List<Explore> allExplore = this.mExploreLocalDataSource.getAllExplore(getExploreListCallback);
            if (allExplore != null && !allExplore.isEmpty()) {
                return allExplore;
            }
            refreshExploreData();
            return allExplore;
        }
    }

    public List<Explore> getExploreByType(String str) {
        return this.mExploreLocalDataSource.getExploreByType(str);
    }

    private void refreshExploreData() {
        this.mExploreRemoteDataSource.getAllExplore(new C47711());
    }

    public void refreshExplore() {
        this.mIsCachedExploreDirty = true;
        refreshExploreData();
    }
}
