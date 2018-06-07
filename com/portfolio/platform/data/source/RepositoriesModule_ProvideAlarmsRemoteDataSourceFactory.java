package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class RepositoriesModule_ProvideAlarmsRemoteDataSourceFactory implements emi<AlarmsDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideAlarmsRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final RepositoriesModule module;

    public RepositoriesModule_ProvideAlarmsRemoteDataSourceFactory(RepositoriesModule repositoriesModule) {
        if ($assertionsDisabled || repositoriesModule != null) {
            this.module = repositoriesModule;
            return;
        }
        throw new AssertionError();
    }

    public AlarmsDataSource get() {
        return (AlarmsDataSource) emj.f(this.module.provideAlarmsRemoteDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<AlarmsDataSource> create(RepositoriesModule repositoriesModule) {
        return new RepositoriesModule_ProvideAlarmsRemoteDataSourceFactory(repositoriesModule);
    }

    public static AlarmsDataSource proxyProvideAlarmsRemoteDataSource(RepositoriesModule repositoriesModule) {
        return repositoriesModule.provideAlarmsRemoteDataSource();
    }
}
