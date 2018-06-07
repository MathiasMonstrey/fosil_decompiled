package com.portfolio.platform.data.source.local;

import android.content.Context;
import com.fossil.cnr;
import com.fossil.emi;
import com.fossil.eru;

public final class AlarmsSettingLocalDataSource_Factory implements emi<AlarmsSettingLocalDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!AlarmsSettingLocalDataSource_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public AlarmsSettingLocalDataSource_Factory(eru<Context> com_fossil_eru_android_content_Context, eru<cnr> com_fossil_eru_com_fossil_cnr) {
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

    public AlarmsSettingLocalDataSource get() {
        return new AlarmsSettingLocalDataSource((Context) this.contextProvider.get(), (cnr) this.sharedPreferencesManagerProvider.get());
    }

    public static emi<AlarmsSettingLocalDataSource> create(eru<Context> com_fossil_eru_android_content_Context, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new AlarmsSettingLocalDataSource_Factory(com_fossil_eru_android_content_Context, com_fossil_eru_com_fossil_cnr);
    }
}
