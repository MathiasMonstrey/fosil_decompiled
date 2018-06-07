package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.UAppSystemVersionLocalDataSource;
import com.portfolio.platform.data.source.scope.Local;

public class UAppSystemVersionRepositoryModule {
    @Local
    UAppSystemVersionDataSource provideUserLocalDataSource() {
        return new UAppSystemVersionLocalDataSource();
    }
}
