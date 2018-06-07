package com.portfolio.platform.data.source.remote;

import android.content.Context;
import com.fossil.emi;
import com.fossil.eru;

public final class AlarmsSettingRemoteDataSource_Factory implements emi<AlarmsSettingRemoteDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!AlarmsSettingRemoteDataSource_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;

    public AlarmsSettingRemoteDataSource_Factory(eru<Context> com_fossil_eru_android_content_Context) {
        if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
            this.contextProvider = com_fossil_eru_android_content_Context;
            return;
        }
        throw new AssertionError();
    }

    public AlarmsSettingRemoteDataSource get() {
        return new AlarmsSettingRemoteDataSource((Context) this.contextProvider.get());
    }

    public static emi<AlarmsSettingRemoteDataSource> create(eru<Context> com_fossil_eru_android_content_Context) {
        return new AlarmsSettingRemoteDataSource_Factory(com_fossil_eru_android_content_Context);
    }
}
