package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.profile.editprofile.EditProfileActivity;

public final class dej implements emg<EditProfileActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dej.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<dep> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8429b((EditProfileActivity) obj);
    }

    public dej(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dep> com_fossil_eru_com_fossil_dep) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dep != null) {
                    this.cET = com_fossil_eru_com_fossil_dep;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<EditProfileActivity> m8428a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dep> com_fossil_eru_com_fossil_dep) {
        return new dej(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dep);
    }

    public void m8429b(EditProfileActivity editProfileActivity) {
        if (editProfileActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        editProfileActivity.mUserRepository = (UserRepository) this.cnc.get();
        editProfileActivity.cEF = (cnr) this.cEM.get();
        editProfileActivity.cRP = (dep) this.cET.get();
    }
}
