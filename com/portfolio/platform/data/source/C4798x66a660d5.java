package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class C4798x66a660d5 implements emi<MicroAppSettingDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C4798x66a660d5.class.desiredAssertionStatus());
    private final MicroAppSettingRepositoryModule module;

    public C4798x66a660d5(MicroAppSettingRepositoryModule microAppSettingRepositoryModule) {
        if ($assertionsDisabled || microAppSettingRepositoryModule != null) {
            this.module = microAppSettingRepositoryModule;
            return;
        }
        throw new AssertionError();
    }

    public MicroAppSettingDataSource get() {
        return (MicroAppSettingDataSource) emj.f(this.module.provideFavoriteMappingSetLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<MicroAppSettingDataSource> create(MicroAppSettingRepositoryModule microAppSettingRepositoryModule) {
        return new C4798x66a660d5(microAppSettingRepositoryModule);
    }

    public static MicroAppSettingDataSource proxyProvideFavoriteMappingSetLocalDataSource(MicroAppSettingRepositoryModule microAppSettingRepositoryModule) {
        return microAppSettingRepositoryModule.provideFavoriteMappingSetLocalDataSource();
    }
}
