package com.portfolio.platform.data.source;

import android.content.Context;
import com.fossil.emi;
import com.fossil.emj;
import com.fossil.eru;
import com.misfit.frameworks.network.manager.MFNetwork;

public final class RepositoriesModule_ProvideSummariesRemoteDataSourceFactory implements emi<SummariesDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideSummariesRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final eru<MFNetwork> mfNetworkProvider;
    private final RepositoriesModule module;

    public RepositoriesModule_ProvideSummariesRemoteDataSourceFactory(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
        if ($assertionsDisabled || repositoriesModule != null) {
            this.module = repositoriesModule;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork != null) {
                    this.mfNetworkProvider = com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public SummariesDataSource get() {
        return (SummariesDataSource) emj.f(this.module.provideSummariesRemoteDataSource((Context) this.contextProvider.get(), (MFNetwork) this.mfNetworkProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<SummariesDataSource> create(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
        return new RepositoriesModule_ProvideSummariesRemoteDataSourceFactory(repositoriesModule, com_fossil_eru_android_content_Context, com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork);
    }

    public static SummariesDataSource proxyProvideSummariesRemoteDataSource(RepositoriesModule repositoriesModule, Context context, MFNetwork mFNetwork) {
        return repositoriesModule.provideSummariesRemoteDataSource(context, mFNetwork);
    }
}
