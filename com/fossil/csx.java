package com.fossil;

import com.portfolio.platform.service.ThirdPartyUploadIntentService;

public final class csx implements emg<ThirdPartyUploadIntentService> {
    static final /* synthetic */ boolean $assertionsDisabled = (!csx.class.desiredAssertionStatus());
    private final eru<ecp> cDH;
    private final eru<cmx> cDI;

    public /* synthetic */ void injectMembers(Object obj) {
        m7491b((ThirdPartyUploadIntentService) obj);
    }

    public csx(eru<ecp> com_fossil_eru_com_fossil_ecp, eru<cmx> com_fossil_eru_com_fossil_cmx) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_ecp != null) {
            this.cDH = com_fossil_eru_com_fossil_ecp;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cmx != null) {
                this.cDI = com_fossil_eru_com_fossil_cmx;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ThirdPartyUploadIntentService> m7490a(eru<ecp> com_fossil_eru_com_fossil_ecp, eru<cmx> com_fossil_eru_com_fossil_cmx) {
        return new csx(com_fossil_eru_com_fossil_ecp, com_fossil_eru_com_fossil_cmx);
    }

    public void m7491b(ThirdPartyUploadIntentService thirdPartyUploadIntentService) {
        if (thirdPartyUploadIntentService == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        thirdPartyUploadIntentService.cDE = (ecp) this.cDH.get();
        thirdPartyUploadIntentService.cDF = (cmx) this.cDI.get();
    }
}
