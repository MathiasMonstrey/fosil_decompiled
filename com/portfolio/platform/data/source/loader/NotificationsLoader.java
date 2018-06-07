package com.portfolio.platform.data.source.loader;

import android.content.Context;
import android.util.SparseArray;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.NotificationsRepository.NotificationRepositoryObserver;
import java.util.List;

public class NotificationsLoader extends BaseLoader<SparseArray<List<BaseFeatureModel>>> implements NotificationRepositoryObserver {
    private static final String TAG = NotificationsLoader.class.getSimpleName();
    private final NotificationsRepository mRepository;

    NotificationsLoader(Context context, NotificationsRepository notificationsRepository) {
        super(context);
        this.mRepository = notificationsRepository;
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "Inside onStartLoading isCachedAvailable=" + this.mRepository.isCacheNotificationsAvailable());
        if (this.mRepository.isCacheNotificationsAvailable()) {
            MFLogger.d(TAG, "Inside onStartLoading return result from cached=");
            deliverResult(this.mRepository.getCachedNotifications());
        }
        this.mRepository.addContentObserver(this);
        if (!this.mRepository.isCacheNotificationsAvailable()) {
            MFLogger.d(TAG, "Inside onStartLoading forceReload");
            forceLoad();
        }
    }

    public SparseArray<List<BaseFeatureModel>> loadInBackground() {
        SparseArray<List<BaseFeatureModel>> allNotificationsByHour = this.mRepository.getAllNotificationsByHour("");
        MFLogger.d(TAG, "Inside loadInBackground result= " + allNotificationsByHour);
        return allNotificationsByHour;
    }

    public void onNotificationsDataChanged() {
        MFLogger.d(TAG, "Inside .onNotificationDataChanged, isStarted=" + isStarted());
        if (isStarted()) {
            forceLoad();
        }
    }

    protected void onReset() {
        this.mRepository.removeContentObserver(this);
        super.onReset();
    }
}
