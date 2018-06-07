package com.fossil;

import android.text.TextUtils;
import com.fossil.cun.C2343a;
import com.fossil.cun.C2344b;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import com.portfolio.platform.response.buddychallenge.MFCheckBCAccountResponse;
import com.portfolio.platform.response.buddychallenge.MFRegisterBCAccountResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TimeZone;

public class cur implements C2343a {
    C2344b cGw;
    private BCPlayer cGy = null;

    class C23551 implements MFServerResultCallback {
        final /* synthetic */ cur cGz;

        C23551(cur com_fossil_cur) {
            this.cGz = com_fossil_cur;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d("BCCreateAccountPresenter", " onSuccess");
            MFCheckBCAccountResponse mFCheckBCAccountResponse = (MFCheckBCAccountResponse) mFResponse;
            this.cGz.cGw.ahn();
            if (!this.cGz.cGw.isActive()) {
                return;
            }
            if (mFResponse.getInternalErrorCode() == 200100) {
                this.cGz.cGw.mo2077t(1, mFResponse.getMessage());
                this.cGz.cGw.mo2072V(mFCheckBCAccountResponse.getSuggestionList());
            } else if (mFResponse.getInternalErrorCode() == 409100) {
                this.cGz.cGw.mo2072V(mFCheckBCAccountResponse.getSuggestionList());
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d("BCCreateAccountPresenter", " onFailed");
            if (!NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
                this.cGz.cGw.jV(601);
            }
            this.cGz.cGw.ahn();
        }
    }

    class C23562 implements MFServerResultCallback {
        final /* synthetic */ cur cGz;

        C23562(cur com_fossil_cur) {
            this.cGz = com_fossil_cur;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d("BCCreateAccountPresenter", " onSuccess");
            this.cGz.cGw.ahn();
            if (this.cGz.cGw.isActive()) {
                this.cGz.cGy = ((MFRegisterBCAccountResponse) mFResponse).getBuddyChallengeAccount();
                cnq.acd().acw().mo1931b(this.cGz.cGy);
                this.cGz.cGw.ahm();
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d("BCCreateAccountPresenter", " onFailed");
            this.cGz.cGw.ahn();
            if (!NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
                this.cGz.cGw.jV(601);
            } else if (mFResponse.getInternalErrorCode() == 409100 && this.cGz.cGw.isActive()) {
                this.cGz.cGw.mo2072V(((MFRegisterBCAccountResponse) mFResponse).getSuggestionList());
            }
        }
    }

    cur(C2344b c2344b) {
        this.cGw = c2344b;
    }

    public void ahu() {
        this.cGw.cK(this);
    }

    public void start() {
    }

    public void stop() {
    }

    public void hN(String str) {
        this.cGw.showDialog();
        String str2 = "";
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            this.cGw.mo2077t(0, "Invalid account name");
        }
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqq(PortfolioApp.ZQ(), str2), new C23551(this));
    }

    public void mo2078E(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            this.cGw.mo2077t(0, "Account name can not be empty");
            return;
        }
        MFUser currentUser = cnq.acd().ace().getCurrentUser();
        this.cGw.showDialog();
        int offset = (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000) / 60;
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cra(PortfolioApp.ZQ(), str, i, offset, currentUser.getProfilePicture()), new C23562(this));
    }
}
