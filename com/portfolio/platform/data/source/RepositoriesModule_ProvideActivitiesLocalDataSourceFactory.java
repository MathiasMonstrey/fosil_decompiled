package com.portfolio.platform.data.source;

import com.fossil.cnq;
import com.fossil.emi;
import com.fossil.emj;
import com.fossil.eru;

public final class RepositoriesModule_ProvideActivitiesLocalDataSourceFactory implements emi<ActivitiesDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideActivitiesLocalDataSourceFactory.class.desiredAssertionStatus());
    private final RepositoriesModule module;
    private final eru<cnq> providerManagerProvider;

    public RepositoriesModule_ProvideActivitiesLocalDataSourceFactory(RepositoriesModule repositoriesModule, eru<cnq> com_fossil_eru_com_fossil_cnq) {
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

    public ActivitiesDataSource get() {
        return (ActivitiesDataSource) emj.f(this.module.provideActivitiesLocalDataSource((cnq) this.providerManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<ActivitiesDataSource> create(RepositoriesModule repositoriesModule, eru<cnq> com_fossil_eru_com_fossil_cnq) {
        return new RepositoriesModule_ProvideActivitiesLocalDataSourceFactory(repositoriesModule, com_fossil_eru_com_fossil_cnq);
    }

    public static ActivitiesDataSource proxyProvideActivitiesLocalDataSource(RepositoriesModule repositoriesModule, cnq com_fossil_cnq) {
        return repositoriesModule.provideActivitiesLocalDataSource(com_fossil_cnq);
    }
}
