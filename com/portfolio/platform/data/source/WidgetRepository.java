package com.portfolio.platform.data.source;

import android.util.SparseArray;
import com.fossil.emj;
import com.fossil.tx;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Widget;
import com.portfolio.platform.data.source.WidgetDataSource.GetListWidgetCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import java.util.ArrayList;
import java.util.List;

public class WidgetRepository implements WidgetDataSource {
    private static final int CACHED_KEY_WIDGET = 1;
    private static final String TAG = WidgetRepository.class.getSimpleName();
    SparseArray<List<Widget>> mCachedWidget;
    boolean mIsCachedWidgetDirty;
    private volatile List<WidgetRepositoryObserver> mObservers = new ArrayList();
    private final WidgetDataSource mWidgetLocalDataSource;
    private final WidgetDataSource mWidgetRemoteDataSource;

    class C48501 implements GetListWidgetCallback {
        C48501() {
        }

        public void onSuccess(List<Widget> list) {
            MFLogger.d(WidgetRepository.TAG, "Inside .getAllWidget download updated widget success, newWidgetList=" + list);
            WidgetRepository.this.addOrUpdateWidgetList(list);
            WidgetRepository.this.processWidgetList(list);
            WidgetRepository.this.notifyWidgetsChanged();
        }

        public void onFailed(int i) {
            MFLogger.d(WidgetRepository.TAG, "Inside .getAllWidget download widget failed with errorCode=" + i);
        }
    }

    class C48512 implements GetListWidgetCallback {
        C48512() {
        }

        public void onSuccess(List<Widget> list) {
            MFLogger.d(WidgetRepository.TAG, "Inside .getAllWidget download updated widget success, newWidgetList=" + list);
            WidgetRepository.this.addOrUpdateWidgetList(list);
            WidgetRepository.this.processWidgetList(list);
            WidgetRepository.this.notifyWidgetsChanged();
            for (Widget widget : list) {
                MFLogger.d(WidgetRepository.TAG, "Preload widget url=" + widget.getBackgroundUrl());
                tx.m13753G(PortfolioApp.ZQ()).ah(widget.getBackgroundUrl()).bb(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            }
        }

        public void onFailed(int i) {
            MFLogger.d(WidgetRepository.TAG, "Inside .getAllWidget download widget failed with errorCode=" + i);
        }
    }

    public interface WidgetRepositoryObserver {
        void onWidgetDataChanged();
    }

    public WidgetRepository(@Remote WidgetDataSource widgetDataSource, @Local WidgetDataSource widgetDataSource2) {
        MFLogger.d(TAG, "Constructor");
        this.mWidgetLocalDataSource = (WidgetDataSource) emj.f(widgetDataSource2, "mWidgetLocalDataSource cannot be null!");
        this.mWidgetRemoteDataSource = (WidgetDataSource) emj.f(widgetDataSource, "mWidgetRemoteDataSource cannot be null!");
    }

    public void addContentObserver(WidgetRepositoryObserver widgetRepositoryObserver) {
        MFLogger.d(TAG, "Inside .addSavedPresetObserverobserver= " + widgetRepositoryObserver + ", isContains=" + this.mObservers.contains(widgetRepositoryObserver) + ", observer size=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        if (!this.mObservers.contains(widgetRepositoryObserver)) {
            this.mObservers.add(widgetRepositoryObserver);
        }
    }

    public void removeContentObserver(WidgetRepositoryObserver widgetRepositoryObserver) {
        MFLogger.d(TAG, "Inside .removeSavedPresetObserver");
        if (this.mObservers.contains(widgetRepositoryObserver)) {
            this.mObservers.remove(widgetRepositoryObserver);
        }
    }

    private void notifyWidgetsChanged() {
        MFLogger.d(TAG, "Inside .notifyWidgetsChanged, observerList=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        for (WidgetRepositoryObserver onWidgetDataChanged : this.mObservers) {
            onWidgetDataChanged.onWidgetDataChanged();
        }
    }

    public boolean isCachedWidgetAvailable() {
        return (this.mCachedWidget == null || isCachedWidgetDirty()) ? false : true;
    }

    public boolean isCachedWidgetDirty() {
        return this.mCachedWidget == null || this.mIsCachedWidgetDirty;
    }

    public List<Widget> getCachedWidget() {
        return this.mCachedWidget != null ? (List) this.mCachedWidget.get(1) : null;
    }

    private void processWidgetList(List<Widget> list) {
        if (this.mCachedWidget == null) {
            this.mCachedWidget = new SparseArray();
        }
        this.mCachedWidget.clear();
        this.mCachedWidget.put(1, list);
        this.mIsCachedWidgetDirty = false;
    }

    public void addOrUpdateWidgetList(List<Widget> list) {
        this.mWidgetLocalDataSource.addOrUpdateWidgetList(list);
    }

    public List<Widget> getAllWidget(GetListWidgetCallback getListWidgetCallback) {
        MFLogger.d(TAG, "Inside .getAllWidget isCachedDirty=" + this.mIsCachedWidgetDirty);
        if (this.mIsCachedWidgetDirty) {
            refreshWidgetData();
            return this.mWidgetLocalDataSource.getAllWidget(getListWidgetCallback);
        } else if (this.mCachedWidget != null && this.mCachedWidget.size() != 0) {
            return getCachedWidget();
        } else {
            List<Widget> allWidget = this.mWidgetLocalDataSource.getAllWidget(getListWidgetCallback);
            if (allWidget != null && !allWidget.isEmpty()) {
                return allWidget;
            }
            refreshWidgetData();
            return allWidget;
        }
    }

    private void refreshWidgetData() {
        this.mWidgetRemoteDataSource.getAllWidget(new C48501());
    }

    public void refreshWidget() {
        this.mIsCachedWidgetDirty = true;
        refreshWidgetData();
    }

    public void preloadWidget() {
        List allWidget = this.mWidgetLocalDataSource.getAllWidget(null);
        if (allWidget == null || allWidget.isEmpty()) {
            this.mWidgetRemoteDataSource.getAllWidget(new C48512());
        } else {
            MFLogger.d(TAG, "No need to preload widget");
        }
    }
}
