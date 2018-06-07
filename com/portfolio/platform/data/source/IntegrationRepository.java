package com.portfolio.platform.data.source;

import android.util.SparseArray;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.Integration;
import com.portfolio.platform.data.source.IntegrationDataSource.GetListIntegrationCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import java.util.ArrayList;
import java.util.List;

public class IntegrationRepository implements IntegrationDataSource {
    private static final int CACHED_KEY_INTEGRATION = 1;
    private static final String TAG = IntegrationRepository.class.getSimpleName();
    SparseArray<List<Integration>> mCachedIntegration;
    boolean mIsCachedIntegrationDirty;
    private final IntegrationDataSource mLocalDataSource;
    private volatile List<IntegrationRepositoryObserver> mObservers = new ArrayList();
    private final IntegrationDataSource mRemoteDataSource;

    class C47721 implements GetListIntegrationCallback {
        C47721() {
        }

        public void onSuccess(List<Integration> list) {
            MFLogger.d(IntegrationRepository.TAG, "Inside .getAllIntegrations download updated integration success, latestIntegrationList=" + list);
            IntegrationRepository.this.addOrUpdateListIntegration(list);
            IntegrationRepository.this.processIntegationList(list);
            IntegrationRepository.this.notifyWidgetsChanged();
        }

        public void onFailed(int i) {
            MFLogger.d(IntegrationRepository.TAG, "Inside .getAllIntegrations download integration failed with errorCode=" + i);
        }
    }

    public interface IntegrationRepositoryObserver {
        void onIntegrationDataChanged();
    }

    public IntegrationRepository(@Local IntegrationDataSource integrationDataSource, @Remote IntegrationDataSource integrationDataSource2) {
        this.mLocalDataSource = integrationDataSource;
        this.mRemoteDataSource = integrationDataSource2;
    }

    public void addContentObserver(IntegrationRepositoryObserver integrationRepositoryObserver) {
        MFLogger.d(TAG, "Inside .addSavedPresetObserver");
        if (!this.mObservers.contains(integrationRepositoryObserver)) {
            this.mObservers.add(integrationRepositoryObserver);
        }
    }

    public void removeContentObserver(IntegrationRepositoryObserver integrationRepositoryObserver) {
        MFLogger.d(TAG, "Inside .removeSavedPresetObserver");
        if (this.mObservers.contains(integrationRepositoryObserver)) {
            this.mObservers.remove(integrationRepositoryObserver);
        }
    }

    private void notifyWidgetsChanged() {
        MFLogger.d(TAG, "Inside .notifyWidgetsChanged, observerList=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        for (IntegrationRepositoryObserver onIntegrationDataChanged : this.mObservers) {
            onIntegrationDataChanged.onIntegrationDataChanged();
        }
    }

    public boolean isCachedWidgetAvailable() {
        return (this.mCachedIntegration == null || isCachedIntegrationDirty()) ? false : true;
    }

    public boolean isCachedIntegrationDirty() {
        return this.mCachedIntegration == null || this.mIsCachedIntegrationDirty;
    }

    public List<Integration> getCachedIntegration() {
        return this.mCachedIntegration != null ? (List) this.mCachedIntegration.get(1) : null;
    }

    private void processIntegationList(List<Integration> list) {
        if (this.mCachedIntegration == null) {
            this.mCachedIntegration = new SparseArray();
        }
        this.mCachedIntegration.clear();
        this.mCachedIntegration.put(1, list);
        this.mIsCachedIntegrationDirty = false;
    }

    public void addOrUpdateListIntegration(List<Integration> list) {
        this.mLocalDataSource.addOrUpdateListIntegration(list);
    }

    public List<Integration> getAllIntegrations(GetListIntegrationCallback getListIntegrationCallback) {
        MFLogger.d(TAG, "Inside .getAllIntegrations isCachedDirty=" + this.mIsCachedIntegrationDirty);
        if (this.mIsCachedIntegrationDirty) {
            refreshIntegrationData();
            return this.mLocalDataSource.getAllIntegrations(getListIntegrationCallback);
        } else if (this.mCachedIntegration != null && this.mCachedIntegration.size() != 0) {
            return getCachedIntegration();
        } else {
            List<Integration> allIntegrations = this.mLocalDataSource.getAllIntegrations(getListIntegrationCallback);
            if (allIntegrations != null && !allIntegrations.isEmpty()) {
                return allIntegrations;
            }
            refreshIntegrationData();
            return allIntegrations;
        }
    }

    private void refreshIntegrationData() {
        this.mRemoteDataSource.getAllIntegrations(new C47721());
    }

    public void refreshIntegration() {
        this.mIsCachedIntegrationDirty = true;
        refreshIntegrationData();
    }
}
