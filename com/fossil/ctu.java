package com.fossil;

public final class ctu implements emg<ctt> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ctu.class.desiredAssertionStatus());
    private final eru<dbc> cFv;
    private final eru<dhd> cFw;
    private final eru<dcb> cFx;
    private final eru<dlg> cFy;
    private final eru<cnr> cFz;

    public /* synthetic */ void injectMembers(Object obj) {
        m7561h((ctt) obj);
    }

    public ctu(eru<dbc> com_fossil_eru_com_fossil_dbc, eru<dhd> com_fossil_eru_com_fossil_dhd, eru<dcb> com_fossil_eru_com_fossil_dcb, eru<dlg> com_fossil_eru_com_fossil_dlg, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dbc != null) {
            this.cFv = com_fossil_eru_com_fossil_dbc;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dhd != null) {
                this.cFw = com_fossil_eru_com_fossil_dhd;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dcb != null) {
                    this.cFx = com_fossil_eru_com_fossil_dcb;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dlg != null) {
                        this.cFy = com_fossil_eru_com_fossil_dlg;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                            this.cFz = com_fossil_eru_com_fossil_cnr;
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

    public static emg<ctt> m7560a(eru<dbc> com_fossil_eru_com_fossil_dbc, eru<dhd> com_fossil_eru_com_fossil_dhd, eru<dcb> com_fossil_eru_com_fossil_dcb, eru<dlg> com_fossil_eru_com_fossil_dlg, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new ctu(com_fossil_eru_com_fossil_dbc, com_fossil_eru_com_fossil_dhd, com_fossil_eru_com_fossil_dcb, com_fossil_eru_com_fossil_dlg, com_fossil_eru_com_fossil_cnr);
    }

    public void m7561h(ctt com_fossil_ctt) {
        if (com_fossil_ctt == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_ctt.cEU = (dbc) this.cFv.get();
        com_fossil_ctt.cEV = (dhd) this.cFw.get();
        com_fossil_ctt.cEW = (dcb) this.cFx.get();
        com_fossil_ctt.cEX = (dlg) this.cFy.get();
        com_fossil_ctt.cFh = (cnr) this.cFz.get();
    }
}
