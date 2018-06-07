package com.portfolio.platform.data.source.remote;

import com.fossil.cnq;
import com.fossil.cpu;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.data.source.LandingPageDataSource;
import com.portfolio.platform.data.source.LandingPageDataSource.GetListLandingPageCallback;
import com.portfolio.platform.response.MFGetLandingPageResponse;
import java.util.List;

public class LandingPageRemoteDataSource implements LandingPageDataSource {

    static final class ServerResultCallback implements MFServerResultCallback {
        private GetListLandingPageCallback mGetListLandingPageCallback;
        private int mLandingPageType;

        public ServerResultCallback(int i) {
            this.mLandingPageType = i;
        }

        public ServerResultCallback(GetListLandingPageCallback getListLandingPageCallback, int i) {
            this(i);
            this.mGetListLandingPageCallback = getListLandingPageCallback;
        }

        public void onSuccess(MFResponse mFResponse) {
            switch (this.mLandingPageType) {
                case 18:
                    if (this.mGetListLandingPageCallback != null) {
                        this.mGetListLandingPageCallback.onSuccess(((MFGetLandingPageResponse) mFResponse).getLandingPageList());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            switch (this.mLandingPageType) {
                case 18:
                    if (this.mGetListLandingPageCallback != null) {
                        this.mGetListLandingPageCallback.onFailed(i);
                    }
                    cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("landing-pages", 0));
                    return;
                default:
                    return;
            }
        }
    }

    public void addOrUpdateLandingPage(List<LandingPage> list) {
    }

    public List<LandingPage> getAllLandingPage(GetListLandingPageCallback getListLandingPageCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cpu(PortfolioApp.ZQ()), new ServerResultCallback(getListLandingPageCallback, 18));
        return null;
    }

    public void refreshLandingPage() {
    }

    public void preloadLandingPage() {
    }
}
