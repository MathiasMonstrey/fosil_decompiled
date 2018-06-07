package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.MicroAppSettingLocalDataSource;
import com.portfolio.platform.data.source.remote.MicroAppSettingRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class MicroAppSettingRepositoryModule {
    @Local
    MicroAppSettingDataSource provideFavoriteMappingSetLocalDataSource() {
        return new MicroAppSettingLocalDataSource();
    }

    @Remote
    MicroAppSettingDataSource provideFavoriteMappingSetRemoteDataSource() {
        return new MicroAppSettingRemoteDataSource();
    }
}
