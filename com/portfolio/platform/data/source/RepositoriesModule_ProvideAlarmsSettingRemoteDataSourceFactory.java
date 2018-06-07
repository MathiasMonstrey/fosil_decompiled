package com.portfolio.platform.data.source;

import android.content.Context;
import com.fossil.emi;
import com.fossil.emj;
import com.fossil.eru;

public final class RepositoriesModule_ProvideAlarmsSettingRemoteDataSourceFactory implements emi<AlarmsSettingDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideAlarmsSettingRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final RepositoriesModule module;

    public RepositoriesModule_ProvideAlarmsSettingRemoteDataSourceFactory(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context) {
        if ($assertionsDisabled || repositoriesModule != null) {
            this.module = repositoriesModule;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public AlarmsSettingDataSource get() {
        return (AlarmsSettingDataSource) emj.f(this.module.provideAlarmsSettingRemoteDataSource((Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<AlarmsSettingDataSource> create(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context) {
        return new RepositoriesModule_ProvideAlarmsSettingRemoteDataSourceFactory(repositoriesModule, com_fossil_eru_android_content_Context);
    }

    public static AlarmsSettingDataSource proxyProvideAlarmsSettingRemoteDataSource(RepositoriesModule repositoriesModule, Context context) {
        return repositoriesModule.provideAlarmsSettingRemoteDataSource(context);
    }
}
