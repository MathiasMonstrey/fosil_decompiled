package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.PresetLocalDataSource;
import com.portfolio.platform.data.source.remote.PresetRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class PresetRepositoryModule {
    @Local
    PresetDataSource provideFavoriteMappingSetLocalDataSource() {
        return new PresetLocalDataSource();
    }

    @Remote
    PresetDataSource provideFavoriteMappingSetRemoteDataSource() {
        return new PresetRemoteDataSource();
    }
}
