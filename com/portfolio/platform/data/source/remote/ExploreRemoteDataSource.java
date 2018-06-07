package com.portfolio.platform.data.source.remote;

import com.fossil.cnq;
import com.fossil.csi;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.model.Explore;
import com.portfolio.platform.data.source.ExploreDataSource;
import com.portfolio.platform.data.source.ExploreDataSource.GetExploreListCallback;
import com.portfolio.platform.response.onboarding.MFGetExplorationResponse;
import java.util.List;

public class ExploreRemoteDataSource implements ExploreDataSource {

    static final class ServerResultCallback implements MFServerResultCallback {
        private int mExploreType;
        private GetExploreListCallback mGetExploreCallback;

        public ServerResultCallback(int i) {
            this.mExploreType = i;
        }

        public ServerResultCallback(GetExploreListCallback getExploreListCallback, int i) {
            this(i);
            this.mGetExploreCallback = getExploreListCallback;
        }

        public void onSuccess(MFResponse mFResponse) {
            switch (this.mExploreType) {
                case 16:
                    if (this.mGetExploreCallback != null) {
                        this.mGetExploreCallback.onSuccess(((MFGetExplorationResponse) mFResponse).getExploreList());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            switch (this.mExploreType) {
                case 16:
                    if (this.mGetExploreCallback != null) {
                        this.mGetExploreCallback.onFailed(i);
                    }
                    cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("explorations", 0));
                    return;
                default:
                    return;
            }
        }
    }

    public void addOrUpdateExploreList(List<Explore> list) {
    }

    public List<Explore> getAllExplore(GetExploreListCallback getExploreListCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new csi(PortfolioApp.ZQ()), new ServerResultCallback(getExploreListCallback, 16));
        return null;
    }

    public List<Explore> getExploreByType(String str) {
        return null;
    }

    public void refreshExplore() {
    }
}
