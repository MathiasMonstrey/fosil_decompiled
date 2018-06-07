package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class C4831xc23541b8 implements emi<PresetDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C4831xc23541b8.class.desiredAssertionStatus());
    private final PresetRepositoryModule module;

    public C4831xc23541b8(PresetRepositoryModule presetRepositoryModule) {
        if ($assertionsDisabled || presetRepositoryModule != null) {
            this.module = presetRepositoryModule;
            return;
        }
        throw new AssertionError();
    }

    public PresetDataSource get() {
        return (PresetDataSource) emj.f(this.module.provideFavoriteMappingSetRemoteDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<PresetDataSource> create(PresetRepositoryModule presetRepositoryModule) {
        return new C4831xc23541b8(presetRepositoryModule);
    }

    public static PresetDataSource proxyProvideFavoriteMappingSetRemoteDataSource(PresetRepositoryModule presetRepositoryModule) {
        return presetRepositoryModule.provideFavoriteMappingSetRemoteDataSource();
    }
}
