package com.fossil;

import android.util.Log;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.buttonservice.ble.ScanService;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserDataSource.OnUpdateUserComplete;
import com.portfolio.platform.data.source.UserRepository;

public class dpl extends ckb<C3059a, C3061c, C3060b> {
    private static final String TAG = dpl.class.getSimpleName();
    private final UserRepository mUserRepository;

    class C30581 implements OnUpdateUserComplete {
        final /* synthetic */ dpl dcV;

        C30581(dpl com_fossil_dpl) {
            this.dcV = com_fossil_dpl;
        }

        public void onComplete(MFResponse mFResponse, boolean z, MFUser mFUser) {
            Log.d(dpl.TAG, "addOrUpdateUser is " + z);
            if (!z || mFUser == null) {
                this.dcV.abr().onError(new C3060b(mFResponse.getHttpReturnCode()));
                return;
            }
            cml.abG().m7097i(-1, ScanService.RETRIEVE_DEVICE_BOND_RSSI_MARK, mFUser.getProfilePicture());
            this.dcV.abr().onSuccess(new C3061c(mFUser));
        }
    }

    public static class C3059a implements C2132b {
        private final MFUser cTi;

        public C3059a(MFUser mFUser) {
            this.cTi = mFUser;
        }

        public MFUser atE() {
            return this.cTi;
        }
    }

    public static final class C3060b implements C2131a {
        private int errorCode;

        public C3060b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static class C3061c implements C2133c {
        private final MFUser cTi;

        public C3061c(MFUser mFUser) {
            this.cTi = mFUser;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9333a((C3059a) c2132b);
    }

    dpl(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    protected void m9333a(C3059a c3059a) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.mUserRepository.addOrUpdateUser(c3059a.atE(), new C30581(this));
        } else {
            abr().onError(new C3060b(601));
        }
    }
}
