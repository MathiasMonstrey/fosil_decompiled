package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.IntegrationLocalDataSource;
import com.portfolio.platform.data.source.remote.IntegrationRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class IntegrationModule {
    @Local
    IntegrationDataSource provideLocalDataSource() {
        return new IntegrationLocalDataSource();
    }

    @Remote
    IntegrationDataSource provideRemoteDataSource() {
        return new IntegrationRemoteDataSource();
    }
}
