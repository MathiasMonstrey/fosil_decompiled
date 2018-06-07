package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class DeviceModule_ProvideFitnessLocalDataSourceFactory implements emi<DeviceDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!DeviceModule_ProvideFitnessLocalDataSourceFactory.class.desiredAssertionStatus());
    private final DeviceModule module;

    public DeviceModule_ProvideFitnessLocalDataSourceFactory(DeviceModule deviceModule) {
        if ($assertionsDisabled || deviceModule != null) {
            this.module = deviceModule;
            return;
        }
        throw new AssertionError();
    }

    public DeviceDataSource get() {
        return (DeviceDataSource) emj.f(this.module.provideFitnessLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<DeviceDataSource> create(DeviceModule deviceModule) {
        return new DeviceModule_ProvideFitnessLocalDataSourceFactory(deviceModule);
    }

    public static DeviceDataSource proxyProvideFitnessLocalDataSource(DeviceModule deviceModule) {
        return deviceModule.provideFitnessLocalDataSource();
    }
}
