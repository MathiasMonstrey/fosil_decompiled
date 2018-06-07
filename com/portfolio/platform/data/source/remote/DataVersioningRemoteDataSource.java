package com.portfolio.platform.data.source.remote;

import com.fossil.cpt;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.source.DataVersioningDataSource;
import com.portfolio.platform.data.source.DataVersioningDataSource.GetDataVersioningCallback;
import com.portfolio.platform.response.MFCheckDataVersioningResponse;

public class DataVersioningRemoteDataSource implements DataVersioningDataSource {

    static final class ServerResultCallback implements MFServerResultCallback {
        private GetDataVersioningCallback mGetDataVersioningCallback;
        private int networkCallbackType;

        public ServerResultCallback(int i) {
            this.networkCallbackType = i;
        }

        public ServerResultCallback(GetDataVersioningCallback getDataVersioningCallback, int i) {
            this(i);
            this.mGetDataVersioningCallback = getDataVersioningCallback;
        }

        public void onSuccess(MFResponse mFResponse) {
            switch (this.networkCallbackType) {
                case 13:
                    if (this.mGetDataVersioningCallback != null) {
                        this.mGetDataVersioningCallback.onSuccess(((MFCheckDataVersioningResponse) mFResponse).getDataVersions());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            switch (this.networkCallbackType) {
                case 13:
                    if (this.mGetDataVersioningCallback != null) {
                        this.mGetDataVersioningCallback.onFailed(i);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void addOrUpdateDataVersioning(DataVersion dataVersion) {
    }

    public DataVersion getDataVersioning(String str) {
        return null;
    }

    public void checkDataVersioning(GetDataVersioningCallback getDataVersioningCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cpt(PortfolioApp.ZQ()), new ServerResultCallback(getDataVersioningCallback, 13));
    }

    public void clearAllDataVersioning() {
    }

    public void removeDataVersion(String str) {
    }

    public void clearDeviceDataVersioning() {
    }

    public DataVersion getDataVersion(String str) {
        return null;
    }
}
