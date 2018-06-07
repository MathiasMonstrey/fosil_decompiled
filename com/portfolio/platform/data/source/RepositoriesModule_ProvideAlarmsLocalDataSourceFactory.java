package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class RepositoriesModule_ProvideAlarmsLocalDataSourceFactory implements emi<AlarmsDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideAlarmsLocalDataSourceFactory.class.desiredAssertionStatus());
    private final RepositoriesModule module;

    public RepositoriesModule_ProvideAlarmsLocalDataSourceFactory(RepositoriesModule repositoriesModule) {
        if ($assertionsDisabled || repositoriesModule != null) {
            this.module = repositoriesModule;
            return;
        }
        throw new AssertionError();
    }

    public AlarmsDataSource get() {
        return (AlarmsDataSource) emj.f(this.module.provideAlarmsLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<AlarmsDataSource> create(RepositoriesModule repositoriesModule) {
        return new RepositoriesModule_ProvideAlarmsLocalDataSourceFactory(repositoriesModule);
    }

    public static AlarmsDataSource proxyProvideAlarmsLocalDataSource(RepositoriesModule repositoriesModule) {
        return repositoriesModule.provideAlarmsLocalDataSource();
    }
}
