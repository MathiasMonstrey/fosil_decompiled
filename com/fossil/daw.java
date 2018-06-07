package com.fossil;

public final class daw implements emg<dav> {
    static final /* synthetic */ boolean $assertionsDisabled = (!daw.class.desiredAssertionStatus());
    private final eru<dbp> ciL;
    private final eru<dbt> ciO;
    private final eru<dbl> ciS;

    public /* synthetic */ void injectMembers(Object obj) {
        m8110d((dav) obj);
    }

    public daw(eru<dbp> com_fossil_eru_com_fossil_dbp, eru<dbt> com_fossil_eru_com_fossil_dbt, eru<dbl> com_fossil_eru_com_fossil_dbl) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dbp != null) {
            this.ciL = com_fossil_eru_com_fossil_dbp;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dbt != null) {
                this.ciO = com_fossil_eru_com_fossil_dbt;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dbl != null) {
                    this.ciS = com_fossil_eru_com_fossil_dbl;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<dav> m8109a(eru<dbp> com_fossil_eru_com_fossil_dbp, eru<dbt> com_fossil_eru_com_fossil_dbt, eru<dbl> com_fossil_eru_com_fossil_dbl) {
        return new daw(com_fossil_eru_com_fossil_dbp, com_fossil_eru_com_fossil_dbt, com_fossil_eru_com_fossil_dbl);
    }

    public void m8110d(dav com_fossil_dav) {
        if (com_fossil_dav == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dav.cNG = (dbp) this.ciL.get();
        com_fossil_dav.cNH = (dbt) this.ciO.get();
        com_fossil_dav.cNI = (dbl) this.ciS.get();
    }
}
