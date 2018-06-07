package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class DeviceModule_ProvideFitnessRemoteDataSourceFactory implements emi<DeviceDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!DeviceModule_ProvideFitnessRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final DeviceModule module;

    public DeviceModule_ProvideFitnessRemoteDataSourceFactory(DeviceModule deviceModule) {
        if ($assertionsDisabled || deviceModule != null) {
            this.module = deviceModule;
            return;
        }
        throw new AssertionError();
    }

    public DeviceDataSource get() {
        return (DeviceDataSource) emj.f(this.module.provideFitnessRemoteDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<DeviceDataSource> create(DeviceModule deviceModule) {
        return new DeviceModule_ProvideFitnessRemoteDataSourceFactory(deviceModule);
    }

    public static DeviceDataSource proxyProvideFitnessRemoteDataSource(DeviceModule deviceModule) {
        return deviceModule.provideFitnessRemoteDataSource();
    }
}
