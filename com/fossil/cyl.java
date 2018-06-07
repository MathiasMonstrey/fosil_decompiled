package com.fossil;

import com.misfit.frameworks.network.manager.MFNetwork;
import dagger.internal.MembersInjectors;

public final class cyl implements emi<cyk> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyl.class.desiredAssertionStatus());
    private final eru<MFNetwork> cKZ;
    private final emg<cyk> cLb;

    public /* synthetic */ Object get() {
        return ajR();
    }

    public cyl(emg<cyk> com_fossil_emg_com_fossil_cyk, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cyk != null) {
            this.cLb = com_fossil_emg_com_fossil_cyk;
            if ($assertionsDisabled || com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork != null) {
                this.cKZ = com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cyk ajR() {
        return (cyk) MembersInjectors.a(this.cLb, new cyk((MFNetwork) this.cKZ.get()));
    }

    public static emi<cyk> m7907a(emg<cyk> com_fossil_emg_com_fossil_cyk, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
        return new cyl(com_fossil_emg_com_fossil_cyk, com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork);
    }
}
