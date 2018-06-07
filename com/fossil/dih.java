package com.fossil;

import com.fossil.dib.C2804b;

public final class dih implements emi<did> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dih.class.desiredAssertionStatus());
    private final eru<C2804b> cGA;
    private final eru<String> cWj;
    private final eru<djo> cWk;
    private final eru<dkc> cfJ;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return apN();
    }

    public dih(eru<C2804b> com_fossil_eru_com_fossil_dib_b, eru<String> com_fossil_eru_java_lang_String, eru<djo> com_fossil_eru_com_fossil_djo, eru<dkc> com_fossil_eru_com_fossil_dkc, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dib_b != null) {
            this.cGA = com_fossil_eru_com_fossil_dib_b;
            if ($assertionsDisabled || com_fossil_eru_java_lang_String != null) {
                this.cWj = com_fossil_eru_java_lang_String;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_djo != null) {
                    this.cWk = com_fossil_eru_com_fossil_djo;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dkc != null) {
                        this.cfJ = com_fossil_eru_com_fossil_dkc;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                            this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
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

    public did apN() {
        return new did((C2804b) this.cGA.get(), (String) this.cWj.get(), (djo) this.cWk.get(), (dkc) this.cfJ.get(), (ckc) this.useCaseHandlerProvider.get());
    }

    public static emi<did> m8754b(eru<C2804b> com_fossil_eru_com_fossil_dib_b, eru<String> com_fossil_eru_java_lang_String, eru<djo> com_fossil_eru_com_fossil_djo, eru<dkc> com_fossil_eru_com_fossil_dkc, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        return new dih(com_fossil_eru_com_fossil_dib_b, com_fossil_eru_java_lang_String, com_fossil_eru_com_fossil_djo, com_fossil_eru_com_fossil_dkc, com_fossil_eru_com_fossil_ckc);
    }
}
