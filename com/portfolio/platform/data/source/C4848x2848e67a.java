package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class C4848x2848e67a implements emi<UAppSystemVersionDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C4848x2848e67a.class.desiredAssertionStatus());
    private final UAppSystemVersionRepositoryModule module;

    public C4848x2848e67a(UAppSystemVersionRepositoryModule uAppSystemVersionRepositoryModule) {
        if ($assertionsDisabled || uAppSystemVersionRepositoryModule != null) {
            this.module = uAppSystemVersionRepositoryModule;
            return;
        }
        throw new AssertionError();
    }

    public UAppSystemVersionDataSource get() {
        return (UAppSystemVersionDataSource) emj.f(this.module.provideUserLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<UAppSystemVersionDataSource> create(UAppSystemVersionRepositoryModule uAppSystemVersionRepositoryModule) {
        return new C4848x2848e67a(uAppSystemVersionRepositoryModule);
    }

    public static UAppSystemVersionDataSource proxyProvideUserLocalDataSource(UAppSystemVersionRepositoryModule uAppSystemVersionRepositoryModule) {
        return uAppSystemVersionRepositoryModule.provideUserLocalDataSource();
    }
}
