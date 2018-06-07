package com.portfolio.platform.data.source;

import android.content.Context;
import com.fossil.emi;
import com.fossil.emj;
import com.fossil.eru;
import com.misfit.frameworks.network.manager.MFNetwork;

public final class RepositoriesModule_ProvideSleepSessionsRemoteDataSourceFactory implements emi<SleepSessionsDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideSleepSessionsRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final eru<MFNetwork> mfNetworkProvider;
    private final RepositoriesModule module;

    public RepositoriesModule_ProvideSleepSessionsRemoteDataSourceFactory(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
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

    public SleepSessionsDataSource get() {
        return (SleepSessionsDataSource) emj.f(this.module.provideSleepSessionsRemoteDataSource((Context) this.contextProvider.get(), (MFNetwork) this.mfNetworkProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<SleepSessionsDataSource> create(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
        return new RepositoriesModule_ProvideSleepSessionsRemoteDataSourceFactory(repositoriesModule, com_fossil_eru_android_content_Context, com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork);
    }

    public static SleepSessionsDataSource proxyProvideSleepSessionsRemoteDataSource(RepositoriesModule repositoriesModule, Context context, MFNetwork mFNetwork) {
        return repositoriesModule.provideSleepSessionsRemoteDataSource(context, mFNetwork);
    }
}
