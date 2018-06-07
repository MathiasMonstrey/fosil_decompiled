package com.portfolio.platform.data.source;

import com.fossil.cnq;
import com.fossil.emi;
import com.fossil.emj;
import com.fossil.eru;

public final class RepositoriesModule_ProvideSleepSummariesLocalDataSourceFactory implements emi<SleepSummariesDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideSleepSummariesLocalDataSourceFactory.class.desiredAssertionStatus());
    private final RepositoriesModule module;
    private final eru<cnq> providerManagerProvider;

    public RepositoriesModule_ProvideSleepSummariesLocalDataSourceFactory(RepositoriesModule repositoriesModule, eru<cnq> com_fossil_eru_com_fossil_cnq) {
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

    public SleepSummariesDataSource get() {
        return (SleepSummariesDataSource) emj.f(this.module.provideSleepSummariesLocalDataSource((cnq) this.providerManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<SleepSummariesDataSource> create(RepositoriesModule repositoriesModule, eru<cnq> com_fossil_eru_com_fossil_cnq) {
        return new RepositoriesModule_ProvideSleepSummariesLocalDataSourceFactory(repositoriesModule, com_fossil_eru_com_fossil_cnq);
    }

    public static SleepSummariesDataSource proxyProvideSleepSummariesLocalDataSource(RepositoriesModule repositoriesModule, cnq com_fossil_cnq) {
        return repositoriesModule.provideSleepSummariesLocalDataSource(com_fossil_cnq);
    }
}
