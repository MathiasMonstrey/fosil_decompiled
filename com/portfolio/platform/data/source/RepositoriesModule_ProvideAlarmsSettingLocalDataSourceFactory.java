package com.portfolio.platform.data.source;

import android.content.Context;
import com.fossil.cnr;
import com.fossil.emi;
import com.fossil.emj;
import com.fossil.eru;

public final class RepositoriesModule_ProvideAlarmsSettingLocalDataSourceFactory implements emi<AlarmsSettingDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RepositoriesModule_ProvideAlarmsSettingLocalDataSourceFactory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final RepositoriesModule module;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public RepositoriesModule_ProvideAlarmsSettingLocalDataSourceFactory(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || repositoriesModule != null) {
            this.module = repositoriesModule;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                    this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public AlarmsSettingDataSource get() {
        return (AlarmsSettingDataSource) emj.f(this.module.provideAlarmsSettingLocalDataSource((Context) this.contextProvider.get(), (cnr) this.sharedPreferencesManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<AlarmsSettingDataSource> create(RepositoriesModule repositoriesModule, eru<Context> com_fossil_eru_android_content_Context, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new RepositoriesModule_ProvideAlarmsSettingLocalDataSourceFactory(repositoriesModule, com_fossil_eru_android_content_Context, com_fossil_eru_com_fossil_cnr);
    }

    public static AlarmsSettingDataSource proxyProvideAlarmsSettingLocalDataSource(RepositoriesModule repositoriesModule, Context context, cnr com_fossil_cnr) {
        return repositoriesModule.provideAlarmsSettingLocalDataSource(context, com_fossil_cnr);
    }
}
