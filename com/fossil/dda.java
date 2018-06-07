package com.fossil;

import android.content.Context;
import dagger.internal.MembersInjectors;

public final class dda implements emi<dcz> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dda.class.desiredAssertionStatus());
    private final emg<dcz> cQG;
    private final eru<Context> contextProvider;

    public /* synthetic */ Object get() {
        return amz();
    }

    public dda(emg<dcz> com_fossil_emg_com_fossil_dcz, eru<Context> com_fossil_eru_android_content_Context) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dcz != null) {
            this.cQG = com_fossil_emg_com_fossil_dcz;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dcz amz() {
        return (dcz) MembersInjectors.a(this.cQG, new dcz((Context) this.contextProvider.get()));
    }

    public static emi<dcz> m8355a(emg<dcz> com_fossil_emg_com_fossil_dcz, eru<Context> com_fossil_eru_android_content_Context) {
        return new dda(com_fossil_emg_com_fossil_dcz, com_fossil_eru_android_content_Context);
    }
}
