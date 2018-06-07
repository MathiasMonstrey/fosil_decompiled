package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.profile.unit.ProfileUnitActivity;

public final class dgo implements emg<ProfileUnitActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dgo.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<dgv> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8507b((ProfileUnitActivity) obj);
    }

    public dgo(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dgv> com_fossil_eru_com_fossil_dgv) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dgv != null) {
                    this.cET = com_fossil_eru_com_fossil_dgv;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ProfileUnitActivity> m8506a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dgv> com_fossil_eru_com_fossil_dgv) {
        return new dgo(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dgv);
    }

    public void m8507b(ProfileUnitActivity profileUnitActivity) {
        if (profileUnitActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        profileUnitActivity.mUserRepository = (UserRepository) this.cnc.get();
        profileUnitActivity.cEF = (cnr) this.cEM.get();
        profileUnitActivity.cTF = (dgv) this.cET.get();
    }
}
