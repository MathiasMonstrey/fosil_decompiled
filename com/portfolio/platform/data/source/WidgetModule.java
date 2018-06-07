package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.WidgetLocalDataSource;
import com.portfolio.platform.data.source.remote.WidgetRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class WidgetModule {
    @Local
    WidgetDataSource provideWidgetLocalDataSource() {
        return new WidgetLocalDataSource();
    }

    @Remote
    WidgetDataSource provideWidgetRemoteDataSource() {
        return new WidgetRemoteDataSource();
    }
}
