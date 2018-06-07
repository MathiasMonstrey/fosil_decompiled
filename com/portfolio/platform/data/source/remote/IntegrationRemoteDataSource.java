package com.portfolio.platform.data.source.remote;

import com.fossil.cnq;
import com.fossil.cpv;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.model.Integration;
import com.portfolio.platform.data.source.IntegrationDataSource;
import com.portfolio.platform.data.source.IntegrationDataSource.GetListIntegrationCallback;
import com.portfolio.platform.response.MFGetListIntegrationResponse;
import java.util.ArrayList;
import java.util.List;

public class IntegrationRemoteDataSource implements IntegrationDataSource {

    static final class ServerResultCallback implements MFServerResultCallback {
        private GetListIntegrationCallback mGetListIntegrationCallback;
        private int mIntegrationType;

        public ServerResultCallback(int i) {
            this.mIntegrationType = i;
        }

        public ServerResultCallback(GetListIntegrationCallback getListIntegrationCallback, int i) {
            this(i);
            this.mGetListIntegrationCallback = getListIntegrationCallback;
        }

        public void onSuccess(MFResponse mFResponse) {
            switch (this.mIntegrationType) {
                case 14:
                    if (this.mGetListIntegrationCallback != null) {
                        this.mGetListIntegrationCallback.onSuccess(((MFGetListIntegrationResponse) mFResponse).getIntegrationList());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            switch (this.mIntegrationType) {
                case 14:
                    if (this.mGetListIntegrationCallback != null) {
                        this.mGetListIntegrationCallback.onFailed(i);
                    }
                    cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("explorations", 0));
                    return;
                default:
                    return;
            }
        }
    }

    public void addOrUpdateListIntegration(List<Integration> list) {
    }

    public List<Integration> getAllIntegrations(GetListIntegrationCallback getListIntegrationCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cpv(PortfolioApp.ZQ()), new ServerResultCallback(getListIntegrationCallback, 14));
        return new ArrayList();
    }

    public void refreshIntegration() {
    }
}
