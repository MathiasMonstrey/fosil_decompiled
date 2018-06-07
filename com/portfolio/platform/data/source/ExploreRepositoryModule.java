package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.ExploreLocalDataSource;
import com.portfolio.platform.data.source.remote.ExploreRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class ExploreRepositoryModule {
    @Local
    ExploreDataSource provideExploreLocalDataSource() {
        return new ExploreLocalDataSource();
    }

    @Remote
    ExploreDataSource provideExploreRemoteDataSource() {
        return new ExploreRemoteDataSource();
    }
}
