package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.DataVersionsingLocalDataSource;
import com.portfolio.platform.data.source.remote.DataVersioningRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class DataVersioningModule {
    @Local
    DataVersioningDataSource provideDataVersioningLocalDataSource() {
        return new DataVersionsingLocalDataSource();
    }

    @Remote
    DataVersioningDataSource provideDataVersioningRemoteDataSource() {
        return new DataVersioningRemoteDataSource();
    }
}
