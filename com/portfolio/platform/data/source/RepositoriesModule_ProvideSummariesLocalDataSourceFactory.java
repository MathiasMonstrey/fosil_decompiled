package com.portfolio.platform.data.source;

import com.fossil.cnq;
import com.fossil.emi;
import com.fossil.emj;
import com.fossil.eru;

public final class RepositoriesModule_ProvideSummariesLocalDataSourceFactory implements emi<SummariesDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideSummariesLocalDataSourceFactory.class.desiredAssertionStatus());
    private final RepositoriesModule module;
    private final eru<cnq> providerManagerProvider;

    public RepositoriesModule_ProvideSummariesLocalDataSourceFactory(RepositoriesModule repositoriesModule, eru<cnq> com_fossil_eru_com_fossil_cnq) {
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

    public SummariesDataSource get() {
        return (SummariesDataSource) emj.f(this.module.provideSummariesLocalDataSource((cnq) this.providerManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<SummariesDataSource> create(RepositoriesModule repositoriesModule, eru<cnq> com_fossil_eru_com_fossil_cnq) {
        return new RepositoriesModule_ProvideSummariesLocalDataSourceFactory(repositoriesModule, com_fossil_eru_com_fossil_cnq);
    }

    public static SummariesDataSource proxyProvideSummariesLocalDataSource(RepositoriesModule repositoriesModule, cnq com_fossil_cnq) {
        return repositoriesModule.provideSummariesLocalDataSource(com_fossil_cnq);
    }
}
