package com.fossil;

public final class dbi implements emg<dbh> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dbi.class.desiredAssertionStatus());
    private final eru<doy> cOe;

    public /* synthetic */ void injectMembers(Object obj) {
        m8131c((dbh) obj);
    }

    public dbi(eru<doy> com_fossil_eru_com_fossil_doy) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_doy != null) {
            this.cOe = com_fossil_eru_com_fossil_doy;
            return;
        }
        throw new AssertionError();
    }

    public static emg<dbh> create(eru<doy> com_fossil_eru_com_fossil_doy) {
        return new dbi(com_fossil_eru_com_fossil_doy);
    }

    public void m8131c(dbh com_fossil_dbh) {
        if (com_fossil_dbh == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dbh.cOb = (doy) this.cOe.get();
    }
}
