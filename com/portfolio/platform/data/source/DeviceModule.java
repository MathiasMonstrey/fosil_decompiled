package com.portfolio.platform.data.source;

import com.portfolio.platform.data.source.local.DeviceLocalDataSource;
import com.portfolio.platform.data.source.remote.DeviceRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class DeviceModule {
    @Local
    DeviceDataSource provideFitnessLocalDataSource() {
        return new DeviceLocalDataSource();
    }

    @Remote
    DeviceDataSource provideFitnessRemoteDataSource() {
        return new DeviceRemoteDataSource();
    }
}
