package com.fossil;

import com.misfit.frameworks.network.manager.MFNetwork;
import dagger.internal.MembersInjectors;

public final class cyj implements emi<cyi> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyj.class.desiredAssertionStatus());
    private final emg<cyi> cKY;
    private final eru<MFNetwork> cKZ;

    public /* synthetic */ Object get() {
        return ajQ();
    }

    public cyj(emg<cyi> com_fossil_emg_com_fossil_cyi, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cyi != null) {
            this.cKY = com_fossil_emg_com_fossil_cyi;
            if ($assertionsDisabled || com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork != null) {
                this.cKZ = com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cyi ajQ() {
        return (cyi) MembersInjectors.a(this.cKY, new cyi((MFNetwork) this.cKZ.get()));
    }

    public static emi<cyi> m7902a(emg<cyi> com_fossil_emg_com_fossil_cyi, eru<MFNetwork> com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork) {
        return new cyj(com_fossil_emg_com_fossil_cyi, com_fossil_eru_com_misfit_frameworks_network_manager_MFNetwork);
    }
}
