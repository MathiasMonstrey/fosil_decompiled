package com.fossil;

public final class cvt implements emg<cvs> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cvt.class.desiredAssertionStatus());
    private final eru<cwc> cIl;

    public /* synthetic */ void injectMembers(Object obj) {
        m7706d((cvs) obj);
    }

    public cvt(eru<cwc> com_fossil_eru_com_fossil_cwc) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cwc != null) {
            this.cIl = com_fossil_eru_com_fossil_cwc;
            return;
        }
        throw new AssertionError();
    }

    public static emg<cvs> create(eru<cwc> com_fossil_eru_com_fossil_cwc) {
        return new cvt(com_fossil_eru_com_fossil_cwc);
    }

    public void m7706d(cvs com_fossil_cvs) {
        if (com_fossil_cvs == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cvs.cIf = (cwc) this.cIl.get();
    }
}
