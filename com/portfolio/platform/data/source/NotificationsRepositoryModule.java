package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.NotificationLocalDataSource;
import com.portfolio.platform.data.source.remote.NotificationRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class NotificationsRepositoryModule {
    @Local
    NotificationsDataSource provideLocalNotificationsDataSource() {
        return new NotificationLocalDataSource();
    }

    @Remote
    NotificationsDataSource provideRemoteNotificationsDataSource() {
        return new NotificationRemoteDataSource();
    }
}
