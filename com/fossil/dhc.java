package com.fossil;

public final class dhc implements emg<dhb> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dhc.class.desiredAssertionStatus());
    private final eru<dhk> cUv;

    public /* synthetic */ void injectMembers(Object obj) {
        m8600t((dhb) obj);
    }

    public dhc(eru<dhk> com_fossil_eru_com_fossil_dhk) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dhk != null) {
            this.cUv = com_fossil_eru_com_fossil_dhk;
            return;
        }
        throw new AssertionError();
    }

    public static emg<dhb> create(eru<dhk> com_fossil_eru_com_fossil_dhk) {
        return new dhc(com_fossil_eru_com_fossil_dhk);
    }

    public void m8600t(dhb com_fossil_dhb) {
        if (com_fossil_dhb == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dhb.cUo = (dhk) this.cUv.get();
    }
}
