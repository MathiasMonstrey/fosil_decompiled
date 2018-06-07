package com.fossil;

import com.fossil.dnl.C2997b;

public final class dnq implements emi<dnp> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dnq.class.desiredAssertionStatus());
    private final eru<dqf> cir;
    private final eru<C2997b> dbg;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return asF();
    }

    public dnq(eru<C2997b> com_fossil_eru_com_fossil_dnl_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dqf> com_fossil_eru_com_fossil_dqf) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dnl_b != null) {
            this.dbg = com_fossil_eru_com_fossil_dnl_b;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dqf != null) {
                    this.cir = com_fossil_eru_com_fossil_dqf;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dnp asF() {
        return new dnp((C2997b) this.dbg.get(), (ckc) this.useCaseHandlerProvider.get(), (dqf) this.cir.get());
    }

    public static emi<dnp> create(eru<C2997b> com_fossil_eru_com_fossil_dnl_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dqf> com_fossil_eru_com_fossil_dqf) {
        return new dnq(com_fossil_eru_com_fossil_dnl_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dqf);
    }
}
