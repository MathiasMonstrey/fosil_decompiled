package com.fossil;

import android.content.Context;
import dagger.internal.MembersInjectors;

public final class djt implements emi<djs> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djt.class.desiredAssertionStatus());
    private final eru<Context> cJD;
    private final emg<djs> cXF;

    public /* synthetic */ Object get() {
        return aqy();
    }

    public djt(emg<djs> com_fossil_emg_com_fossil_djs, eru<Context> com_fossil_eru_android_content_Context) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_djs != null) {
            this.cXF = com_fossil_emg_com_fossil_djs;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.cJD = com_fossil_eru_android_content_Context;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public djs aqy() {
        return (djs) MembersInjectors.a(this.cXF, new djs((Context) this.cJD.get()));
    }

    public static emi<djs> m8850a(emg<djs> com_fossil_emg_com_fossil_djs, eru<Context> com_fossil_eru_android_content_Context) {
        return new djt(com_fossil_emg_com_fossil_djs, com_fossil_eru_android_content_Context);
    }
}
