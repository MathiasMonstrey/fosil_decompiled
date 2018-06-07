package com.portfolio.platform.data.source;

import android.content.Context;
import com.fossil.emi;
import com.fossil.emj;
import com.fossil.eru;
import com.misfit.frameworks.network.manager.MFNetwork;

public final class RepositoriesModule_ProvideActivitiesRemoteDataSourceFactory implements emi<ActivitiesDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideActivitiesRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final eru<MFNetwork> mfNetworkProvider;
    private final RepositoriesModule module;

    public RepositoriesModule_ProvideActivitiesRemoteDataSourceFactory(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
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

    public ActivitiesDataSource get() {
        return (ActivitiesDataSource) emj.f(this.module.provideActivitiesRemoteDataSource((Context) this.contextProvider.get(), (MFNetwork) this.mfNetworkProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<ActivitiesDataSource> create(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
        return new RepositoriesModule_ProvideActivitiesRemoteDataSourceFactory(repositoriesModule, com_fossil_eru_android_content_Context, com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork);
    }

    public static ActivitiesDataSource proxyProvideActivitiesRemoteDataSource(RepositoriesModule repositoriesModule, Context context, MFNetwork mFNetwork) {
        return repositoriesModule.provideActivitiesRemoteDataSource(context, mFNetwork);
    }
}
