package com.fossil;

import dagger.internal.MembersInjectors;

public final class dqg implements emi<dqf> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dqg.class.desiredAssertionStatus());
    private final emg<dqf> ddA;

    public /* synthetic */ Object get() {
        return atX();
    }

    public dqg(emg<dqf> com_fossil_emg_com_fossil_dqf) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dqf != null) {
            this.ddA = com_fossil_emg_com_fossil_dqf;
            return;
        }
        throw new AssertionError();
    }

    public dqf atX() {
        return (dqf) MembersInjectors.a(this.ddA, new dqf());
    }

    public static emi<dqf> m9368a(emg<dqf> com_fossil_emg_com_fossil_dqf) {
        return new dqg(com_fossil_emg_com_fossil_dqf);
    }
}
