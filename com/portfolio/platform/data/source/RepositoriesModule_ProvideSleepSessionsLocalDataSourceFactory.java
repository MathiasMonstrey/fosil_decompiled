package com.portfolio.platform.data.source;

import com.fossil.cnq;
import com.fossil.emi;
import com.fossil.emj;
import com.fossil.eru;

public final class RepositoriesModule_ProvideSleepSessionsLocalDataSourceFactory implements emi<SleepSessionsDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideSleepSessionsLocalDataSourceFactory.class.desiredAssertionStatus());
    private final RepositoriesModule module;
    private final eru<cnq> providerManagerProvider;

    public RepositoriesModule_ProvideSleepSessionsLocalDataSourceFactory(RepositoriesModule repositoriesModule, eru<cnq> com_fossil_eru_com_fossil_cnq) {
        if ($assertionsDisabled || repositoriesModule != null) {
            this.module = repositoriesModule;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnq != null) {
                this.providerManagerProvider = com_fossil_eru_com_fossil_cnq;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public SleepSessionsDataSource get() {
        return (SleepSessionsDataSource) emj.f(this.module.provideSleepSessionsLocalDataSource((cnq) this.providerManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<SleepSessionsDataSource> create(RepositoriesModule repositoriesModule, eru<cnq> com_fossil_eru_com_fossil_cnq) {
        return new RepositoriesModule_ProvideSleepSessionsLocalDataSourceFactory(repositoriesModule, com_fossil_eru_com_fossil_cnq);
    }

    public static SleepSessionsDataSource proxyProvideSleepSessionsLocalDataSource(RepositoriesModule repositoriesModule, cnq com_fossil_cnq) {
        return repositoriesModule.provideSleepSessionsLocalDataSource(com_fossil_cnq);
    }
}
