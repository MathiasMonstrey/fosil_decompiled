package com.fossil;

import com.fossil.dii.C2807b;

public final class dio implements emi<dik> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dio.class.desiredAssertionStatus());
    private final eru<C2807b> cGA;
    private final eru<fj> cIC;
    private final eru<djo> cfI;
    private final eru<dkc> cfJ;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return apT();
    }

    public dio(eru<C2807b> com_fossil_eru_com_fossil_dii_b, eru<djo> com_fossil_eru_com_fossil_djo, eru<dkc> com_fossil_eru_com_fossil_dkc, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<fj> com_fossil_eru_com_fossil_fj) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dii_b != null) {
            this.cGA = com_fossil_eru_com_fossil_dii_b;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_djo != null) {
                this.cfI = com_fossil_eru_com_fossil_djo;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dkc != null) {
                    this.cfJ = com_fossil_eru_com_fossil_dkc;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                        this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                            this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                                this.cIC = com_fossil_eru_com_fossil_fj;
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
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dik apT() {
        return new dik((C2807b) this.cGA.get(), (djo) this.cfI.get(), (dkc) this.cfJ.get(), (ckc) this.useCaseHandlerProvider.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (fj) this.cIC.get());
    }

    public static emi<dik> m8771a(eru<C2807b> com_fossil_eru_com_fossil_dii_b, eru<djo> com_fossil_eru_com_fossil_djo, eru<dkc> com_fossil_eru_com_fossil_dkc, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<fj> com_fossil_eru_com_fossil_fj) {
        return new dio(com_fossil_eru_com_fossil_dii_b, com_fossil_eru_com_fossil_djo, com_fossil_eru_com_fossil_dkc, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_fj);
    }
}
