package com.fossil;

import com.fossil.dgh.C2740b;
import dagger.internal.MembersInjectors;

public final class dgm implements emi<dgl> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dgm.class.desiredAssertionStatus());
    private final eru<C2740b> cGA;
    private final emg<dgl> clc;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return aoa();
    }

    public dgm(emg<dgl> com_fossil_emg_com_fossil_dgl, eru<C2740b> com_fossil_eru_com_fossil_dgh_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dgl != null) {
            this.clc = com_fossil_emg_com_fossil_dgl;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dgh_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dgh_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
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
        throw new AssertionError();
    }

    public dgl aoa() {
        return (dgl) MembersInjectors.a(this.clc, new dgl((C2740b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get(), (cnr) this.sharedPreferencesManagerProvider.get()));
    }

    public static emi<dgl> create(emg<dgl> com_fossil_emg_com_fossil_dgl, eru<C2740b> com_fossil_eru_com_fossil_dgh_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new dgm(com_fossil_emg_com_fossil_dgl, com_fossil_eru_com_fossil_dgh_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_cnr);
    }
}
