package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class C4830x787eed21 implements emi<PresetDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C4830x787eed21.class.desiredAssertionStatus());
    private final PresetRepositoryModule module;

    public C4830x787eed21(PresetRepositoryModule presetRepositoryModule) {
        if ($assertionsDisabled || presetRepositoryModule != null) {
            this.module = presetRepositoryModule;
            return;
        }
        throw new AssertionError();
    }

    public PresetDataSource get() {
        return (PresetDataSource) emj.f(this.module.provideFavoriteMappingSetLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<PresetDataSource> create(PresetRepositoryModule presetRepositoryModule) {
        return new C4830x787eed21(presetRepositoryModule);
    }

    public static PresetDataSource proxyProvideFavoriteMappingSetLocalDataSource(PresetRepositoryModule presetRepositoryModule) {
        return presetRepositoryModule.provideFavoriteMappingSetLocalDataSource();
    }
}
