package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class C4799x98fc4484 implements emi<MicroAppSettingDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C4799x98fc4484.class.desiredAssertionStatus());
    private final MicroAppSettingRepositoryModule module;

    public C4799x98fc4484(MicroAppSettingRepositoryModule microAppSettingRepositoryModule) {
        if ($assertionsDisabled || microAppSettingRepositoryModule != null) {
            this.module = microAppSettingRepositoryModule;
            return;
        }
        throw new AssertionError();
    }

    public MicroAppSettingDataSource get() {
        return (MicroAppSettingDataSource) emj.f(this.module.provideFavoriteMappingSetRemoteDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<MicroAppSettingDataSource> create(MicroAppSettingRepositoryModule microAppSettingRepositoryModule) {
        return new C4799x98fc4484(microAppSettingRepositoryModule);
    }

    public static MicroAppSettingDataSource proxyProvideFavoriteMappingSetRemoteDataSource(MicroAppSettingRepositoryModule microAppSettingRepositoryModule) {
        return microAppSettingRepositoryModule.provideFavoriteMappingSetRemoteDataSource();
    }
}
