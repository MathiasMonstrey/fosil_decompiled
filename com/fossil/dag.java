package com.fossil;

import dagger.internal.MembersInjectors;

public final class dag implements emi<daf> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dag.class.desiredAssertionStatus());
    private final emg<daf> cNo;
    private final eru<civ> cNp;

    public /* synthetic */ Object get() {
        return akQ();
    }

    public dag(emg<daf> com_fossil_emg_com_fossil_daf, eru<civ> com_fossil_eru_com_fossil_civ) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_daf != null) {
            this.cNo = com_fossil_emg_com_fossil_daf;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_civ != null) {
                this.cNp = com_fossil_eru_com_fossil_civ;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public daf akQ() {
        return (daf) MembersInjectors.a(this.cNo, new daf((civ) this.cNp.get()));
    }

    public static emi<daf> m8075a(emg<daf> com_fossil_emg_com_fossil_daf, eru<civ> com_fossil_eru_com_fossil_civ) {
        return new dag(com_fossil_emg_com_fossil_daf, com_fossil_eru_com_fossil_civ);
    }
}
