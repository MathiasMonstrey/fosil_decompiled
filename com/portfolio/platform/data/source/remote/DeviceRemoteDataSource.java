package com.portfolio.platform.data.source.remote;

import android.util.Log;
import com.fossil.cnq;
import com.fossil.crg;
import com.fossil.crh;
import com.fossil.cri;
import com.fossil.crj;
import com.fossil.crk;
import com.fossil.crl;
import com.fossil.crm;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.source.DeviceDataSource;
import com.portfolio.platform.data.source.DeviceDataSource.GetAllDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.GetDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.GetSupportedDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.LinkDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.RemoveDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.UpdateDeviceCallback;
import com.portfolio.platform.response.device.MFGetSKUsResponse;
import com.portfolio.platform.response.device.MFGetWatchListResponse;
import com.portfolio.platform.response.device.MFGetWatchResponse;
import java.util.List;

public class DeviceRemoteDataSource implements DeviceDataSource {
    private static final String TAG = DeviceRemoteDataSource.class.getSimpleName();

    static final class ServerResultCallback implements MFServerResultCallback {
        private GetAllDeviceCallback mGetAllDeviceCallback;
        private GetDeviceCallback mGetDeviceCallback;
        private GetSupportedDeviceCallback mGetSupportedDeviceCallback;
        private LinkDeviceCallback mLinkDeviceCallback;
        private int mNetworkCallbackType;
        private RemoveDeviceCallback mRemoveDeviceCallback;
        private UpdateDeviceCallback mUpdateDeviceCallback;

        ServerResultCallback(int i) {
            this.mNetworkCallbackType = i;
        }

        ServerResultCallback(int i, GetSupportedDeviceCallback getSupportedDeviceCallback) {
            this(i);
            this.mGetSupportedDeviceCallback = getSupportedDeviceCallback;
        }

        ServerResultCallback(int i, LinkDeviceCallback linkDeviceCallback) {
            this(i);
            this.mLinkDeviceCallback = linkDeviceCallback;
        }

        ServerResultCallback(int i, UpdateDeviceCallback updateDeviceCallback) {
            this(i);
            this.mUpdateDeviceCallback = updateDeviceCallback;
        }

        ServerResultCallback(int i, RemoveDeviceCallback removeDeviceCallback) {
            this(i);
            this.mRemoveDeviceCallback = removeDeviceCallback;
        }

        ServerResultCallback(int i, GetAllDeviceCallback getAllDeviceCallback) {
            this(i);
            this.mGetAllDeviceCallback = getAllDeviceCallback;
        }

        ServerResultCallback(int i, GetDeviceCallback getDeviceCallback) {
            this(i);
            this.mGetDeviceCallback = getDeviceCallback;
        }

        public void onSuccess(MFResponse mFResponse) {
            switch (this.mNetworkCallbackType) {
                case 0:
                case 1:
                    MFGetWatchResponse mFGetWatchResponse = (MFGetWatchResponse) mFResponse;
                    if (this.mLinkDeviceCallback != null) {
                        this.mLinkDeviceCallback.onSuccess(mFGetWatchResponse.getDeviceInformation());
                        return;
                    }
                    return;
                case 2:
                    if (this.mRemoveDeviceCallback != null) {
                        this.mRemoveDeviceCallback.onSuccess();
                        return;
                    }
                    return;
                case 3:
                    if (this.mUpdateDeviceCallback != null) {
                        this.mUpdateDeviceCallback.onSuccess();
                        return;
                    }
                    return;
                case 4:
                    MFGetSKUsResponse mFGetSKUsResponse = (MFGetSKUsResponse) mFResponse;
                    if (mFGetSKUsResponse != null && mFGetSKUsResponse.getSkuModelList() != null && !mFGetSKUsResponse.getSkuModelList().isEmpty()) {
                        cnq.acd().acp().adX();
                        cnq.acd().acp().S(mFGetSKUsResponse.getSkuModelList());
                        return;
                    }
                    return;
                case 5:
                    if (this.mGetAllDeviceCallback != null) {
                        this.mGetAllDeviceCallback.onSuccess(((MFGetWatchListResponse) mFResponse).getDeviceInformations());
                        return;
                    }
                    return;
                case 6:
                    if (this.mGetDeviceCallback != null) {
                        this.mGetDeviceCallback.onSuccess(((MFGetWatchResponse) mFResponse).getDeviceInformation());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            switch (this.mNetworkCallbackType) {
                case 0:
                case 1:
                    if (this.mLinkDeviceCallback != null) {
                        this.mLinkDeviceCallback.onFail(i);
                        return;
                    }
                    return;
                case 2:
                    if (this.mRemoveDeviceCallback != null) {
                        this.mRemoveDeviceCallback.onFailed(i);
                        return;
                    }
                    return;
                case 3:
                    if (this.mUpdateDeviceCallback != null) {
                        this.mUpdateDeviceCallback.onFailed(i);
                        return;
                    }
                    return;
                case 4:
                    MFLogger.e(DeviceRemoteDataSource.TAG, "Error when fetch supported skus, errorCode=" + i);
                    if (cnq.acd().acf().hc("sku") != null) {
                        cnq.acd().acf().removeDataVersion("sku");
                        return;
                    }
                    return;
                case 5:
                    if (this.mGetAllDeviceCallback != null) {
                        this.mGetAllDeviceCallback.onFailed(i);
                        return;
                    }
                    return;
                case 6:
                    if (this.mGetDeviceCallback != null) {
                        this.mGetDeviceCallback.onFailed(i);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void updateDevice(DeviceModel deviceModel, UpdateDeviceCallback updateDeviceCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crm(PortfolioApp.ZQ(), deviceModel), new ServerResultCallback(3, updateDeviceCallback));
    }

    public void removeDevice(DeviceModel deviceModel, RemoveDeviceCallback removeDeviceCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crl(PortfolioApp.ZQ(), deviceModel.getDeviceId()), new ServerResultCallback(2, removeDeviceCallback));
    }

    public DeviceModel getDeviceBySerial(String str, GetDeviceCallback getDeviceCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crh(PortfolioApp.ZQ(), str), new ServerResultCallback(6, getDeviceCallback));
        return null;
    }

    public List<DeviceModel> getAllDevice(GetAllDeviceCallback getAllDeviceCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cri(PortfolioApp.ZQ()), new ServerResultCallback(5, getAllDeviceCallback));
        return null;
    }

    public List<SKUModel> getSupportedSkus() {
        return null;
    }

    public void fetchSupportedSkus() {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crg(PortfolioApp.ZQ(), 0, 1000), new ServerResultCallback(4));
    }

    public void reDownloadDevice() {
    }

    public SKUModel getSkuModelBySerial(String str) {
        return null;
    }

    public void stealDevice(DeviceModel deviceModel, LinkDeviceCallback linkDeviceCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crk(PortfolioApp.ZQ(), deviceModel), new ServerResultCallback(0, linkDeviceCallback));
    }

    public void linkDevice(DeviceModel deviceModel, LinkDeviceCallback linkDeviceCallback) {
        Log.e(TAG, "Save device " + deviceModel.getDeviceId() + ", fwRevision=" + deviceModel.getFirmwareRevision());
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crj(PortfolioApp.ZQ(), deviceModel), new ServerResultCallback(1, linkDeviceCallback));
    }
}
