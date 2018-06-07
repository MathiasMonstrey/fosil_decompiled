package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.UserLocalDataSource;
import com.portfolio.platform.data.source.remote.UserRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class UserModule {
    @Local
    UserDataSource provideUserLocalDataSource() {
        return new UserLocalDataSource();
    }

    @Remote
    UserDataSource provideRemoteLocalDataSource() {
        return new UserRemoteDataSource();
    }
}
