package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.LandingPageLocalDataSource;
import com.portfolio.platform.data.source.remote.LandingPageRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class LandingPageModule {
    @Local
    LandingPageDataSource provideLocalDataSource() {
        return new LandingPageLocalDataSource();
    }

    @Remote
    LandingPageDataSource provideRemoteDataSource() {
        return new LandingPageRemoteDataSource();
    }
}
