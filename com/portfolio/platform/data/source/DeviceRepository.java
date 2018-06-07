package com.portfolio.platform.data.source;

import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.fossil.cnq;
import com.fossil.gy;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.source.DeviceDataSource.GetAllDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.GetDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.LinkDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.RemoveDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.UpdateDeviceCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.ArrayList;
import java.util.List;

public class DeviceRepository implements DeviceDataSource {
    private static final int CACHED_KEY_DEVICE = 1;
    private final String TAG = DeviceRepository.class.getSimpleName();
    SparseArray<List<DeviceModel>> mCacheDevice;
    private final DeviceDataSource mDeviceLocalDataSource;
    private final DeviceDataSource mDeviceRemoteDataSource;
    boolean mIsCacheDeviceDirty;
    private volatile List<DeviceRepositoryObserver> mObservers = new ArrayList();
    private final UAppSystemVersionRepository mUAppSystemVersionRepository;

    class C47707 implements GetAllDeviceCallback {
        C47707() {
        }

        public void onSuccess(List<DeviceModel> list) {
            if (list == null || list.isEmpty()) {
                MFLogger.d(DeviceRepository.this.TAG, "Inside .reDownloadDevice no device found on server, remove active device serial if possible");
                if (!TextUtils.isEmpty(PortfolioApp.ZQ().aaa())) {
                    MFLogger.d(DeviceRepository.this.TAG, "Inside .reDownloadDevice remove activeSerial=" + PortfolioApp.ZQ().aaa());
                    PortfolioApp.ZQ().fO("");
                    gy.p(PortfolioApp.ZQ()).b(new Intent("BROADCAST_ACTIVE_DEVICE_STEALED"));
                    return;
                }
                return;
            }
            List<DeviceModel> allDevice = DeviceRepository.this.mDeviceLocalDataSource.getAllDevice(null);
            MFLogger.d(DeviceRepository.this.TAG, "Inside .reDownloadDevice local devices=" + allDevice);
            if (allDevice != null && !allDevice.isEmpty()) {
                for (DeviceModel deviceModel : allDevice) {
                    if (!DeviceRepository.this.isHasDevice(list, deviceModel.getDeviceId())) {
                        MFLogger.d(DeviceRepository.this.TAG, "Inside .reDownloadDevice device=" + deviceModel.getDeviceId() + " was stealed, remove it on local");
                        DeviceRepository.this.mDeviceLocalDataSource.removeDevice(deviceModel, null);
                        if (!TextUtils.isEmpty(deviceModel.getDeviceId()) && deviceModel.getDeviceId().equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                            MFLogger.d(DeviceRepository.this.TAG, "Inside .reDownloadDevice remove activeSerial=" + PortfolioApp.ZQ().aaa());
                            PortfolioApp.ZQ().fO("");
                            gy.p(PortfolioApp.ZQ()).b(new Intent("BROADCAST_ACTIVE_DEVICE_STEALED"));
                        }
                    }
                }
            }
        }

        public void onFailed(int i) {
            MFLogger.d(DeviceRepository.this.TAG, "Inside .reDownloadDeviceFail remove data version");
            cnq.acd().acf().removeDataVersion("device/watches");
        }
    }

    public interface DeviceRepositoryObserver {
        void onActiveDeviceChanged();
    }

    public DeviceRepository(@Remote DeviceDataSource deviceDataSource, @Local DeviceDataSource deviceDataSource2, UAppSystemVersionRepository uAppSystemVersionRepository) {
        this.mDeviceRemoteDataSource = deviceDataSource;
        this.mDeviceLocalDataSource = deviceDataSource2;
        this.mUAppSystemVersionRepository = uAppSystemVersionRepository;
    }

    public void addContentObserver(DeviceRepositoryObserver deviceRepositoryObserver) {
        MFLogger.d(this.TAG, "Inside .addSavedPresetObserverobserver= " + deviceRepositoryObserver + ", isContains=" + this.mObservers.contains(deviceRepositoryObserver) + ", observer size=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        if (!this.mObservers.contains(deviceRepositoryObserver)) {
            this.mObservers.add(deviceRepositoryObserver);
        }
    }

    public void removeContentObserver(DeviceRepositoryObserver deviceRepositoryObserver) {
        MFLogger.d(this.TAG, "Inside .removeSavedPresetObserver");
        if (this.mObservers.contains(deviceRepositoryObserver)) {
            this.mObservers.remove(deviceRepositoryObserver);
        }
    }

    private void notifyActiveDeviceChanged() {
        MFLogger.d(this.TAG, "Inside .notifyActiveDeviceChanged, observerList=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        for (DeviceRepositoryObserver onActiveDeviceChanged : this.mObservers) {
            onActiveDeviceChanged.onActiveDeviceChanged();
        }
    }

    public boolean isCachedDeviceAvailable() {
        return (this.mCacheDevice == null || isCachedDeviceDirty()) ? false : true;
    }

    public boolean isCachedDeviceDirty() {
        return this.mCacheDevice == null || this.mIsCacheDeviceDirty;
    }

    public List<DeviceModel> getCachedDevice() {
        return this.mCacheDevice != null ? (List) this.mCacheDevice.get(1) : null;
    }

    private void processDeviceList(List<DeviceModel> list) {
        if (this.mCacheDevice == null) {
            this.mCacheDevice = new SparseArray();
        }
        this.mCacheDevice.clear();
        this.mCacheDevice.put(1, list);
        this.mIsCacheDeviceDirty = false;
    }

    public void updateDevice(final DeviceModel deviceModel, final UpdateDeviceCallback updateDeviceCallback) {
        if (updateDeviceCallback != null) {
            if (TextUtils.isEmpty(deviceModel.getDeviceId())) {
                MFLogger.d(this.TAG, "Inside .updateDevice can't update device without serial number");
                updateDeviceCallback.onFailed(600);
                return;
            }
            this.mDeviceRemoteDataSource.updateDevice(deviceModel, new UpdateDeviceCallback() {
                public void onSuccess() {
                    DeviceRepository.this.mDeviceLocalDataSource.updateDevice(deviceModel, null);
                    DeviceRepository.this.mIsCacheDeviceDirty = true;
                    DeviceRepository.this.notifyActiveDeviceChanged();
                    updateDeviceCallback.onSuccess();
                }

                public void onFailed(int i) {
                    updateDeviceCallback.onFailed(i);
                }
            });
        } else if (!TextUtils.isEmpty(deviceModel.getDeviceId())) {
            this.mDeviceLocalDataSource.updateDevice(deviceModel, null);
            this.mIsCacheDeviceDirty = true;
            notifyActiveDeviceChanged();
        }
    }

    public void linkDevice(final DeviceModel deviceModel, final LinkDeviceCallback linkDeviceCallback) {
        MFLogger.d(this.TAG, "Inside .linkDevice device=" + deviceModel + " , callback=" + linkDeviceCallback);
        if (linkDeviceCallback == null) {
            return;
        }
        if (TextUtils.isEmpty(deviceModel.getDeviceId())) {
            MFLogger.d(this.TAG, "Inside .linkDevice can't link device without serial number");
            linkDeviceCallback.onFail(600);
            return;
        }
        this.mDeviceRemoteDataSource.linkDevice(deviceModel, new LinkDeviceCallback() {
            public void onSuccess(DeviceModel deviceModel) {
                MFLogger.d(DeviceRepository.this.TAG, "Inside .linkDevice link device=" + deviceModel.getDeviceId() + "on server success");
                DeviceRepository.this.mDeviceLocalDataSource.linkDevice(deviceModel, null);
                DeviceRepository.this.mIsCacheDeviceDirty = true;
                DeviceRepository.this.notifyActiveDeviceChanged();
                linkDeviceCallback.onSuccess(deviceModel);
            }

            public void onFail(int i) {
                MFLogger.d(DeviceRepository.this.TAG, "Inside .linkDevice link device=" + deviceModel.getDeviceId() + "on server fail, errorCode=" + i);
                linkDeviceCallback.onFail(i);
            }
        });
    }

    public void stealDevice(final DeviceModel deviceModel, final LinkDeviceCallback linkDeviceCallback) {
        MFLogger.d(this.TAG, "Inside .stealDevice device=" + deviceModel + " , callback=" + linkDeviceCallback);
        if (linkDeviceCallback == null) {
            return;
        }
        if (TextUtils.isEmpty(deviceModel.getDeviceId())) {
            MFLogger.d(this.TAG, "Inside .stealDevice can't steal device without serial number");
            linkDeviceCallback.onFail(600);
            return;
        }
        this.mDeviceRemoteDataSource.stealDevice(deviceModel, new LinkDeviceCallback() {
            public void onSuccess(DeviceModel deviceModel) {
                MFLogger.d(DeviceRepository.this.TAG, "Inside .stealDevice steal device=" + deviceModel.getDeviceId() + "on server success");
                DeviceRepository.this.mDeviceLocalDataSource.linkDevice(deviceModel, null);
                linkDeviceCallback.onSuccess(deviceModel);
            }

            public void onFail(int i) {
                MFLogger.d(DeviceRepository.this.TAG, "Inside .stealDevice steal device=" + deviceModel.getDeviceId() + "on server fail, errorCode=" + i);
                linkDeviceCallback.onFail(i);
            }
        });
    }

    public String getNextActiveDevice() {
        List allDevice = this.mDeviceLocalDataSource.getAllDevice(null);
        if (allDevice == null || allDevice.isEmpty()) {
            return "";
        }
        return ((DeviceModel) allDevice.get(0)).getDeviceId();
    }

    public void removeDevice(final DeviceModel deviceModel, final RemoveDeviceCallback removeDeviceCallback) {
        MFLogger.d(this.TAG, "Inside .removeDevice deviceId=" + deviceModel.getDeviceId() + " , callback=" + removeDeviceCallback);
        if (removeDeviceCallback != null) {
            this.mDeviceRemoteDataSource.removeDevice(deviceModel, new RemoveDeviceCallback() {
                public void onSuccess() {
                    MFLogger.d(DeviceRepository.this.TAG, "Inside .removeDevice remove deviceId=" + deviceModel.getDeviceId() + " success");
                    DeviceRepository.this.mDeviceLocalDataSource.removeDevice(deviceModel, null);
                    DeviceRepository.this.mIsCacheDeviceDirty = true;
                    DeviceRepository.this.notifyActiveDeviceChanged();
                    removeDeviceCallback.onSuccess();
                }

                public void onFailed(int i) {
                    MFLogger.d(DeviceRepository.this.TAG, "Inside .removeDevice remove deviceId=" + deviceModel.getDeviceId() + " fail, errorCode=" + i);
                    switch (i) {
                        case 404:
                            DeviceRepository.this.mDeviceLocalDataSource.removeDevice(deviceModel, null);
                            DeviceRepository.this.mIsCacheDeviceDirty = true;
                            DeviceRepository.this.notifyActiveDeviceChanged();
                            removeDeviceCallback.onSuccess();
                            return;
                        default:
                            removeDeviceCallback.onFailed(i);
                            return;
                    }
                }
            });
            return;
        }
        this.mDeviceLocalDataSource.removeDevice(deviceModel, null);
        this.mIsCacheDeviceDirty = true;
        notifyActiveDeviceChanged();
    }

    public DeviceModel getDeviceBySerial(String str, final GetDeviceCallback getDeviceCallback) {
        DeviceModel deviceBySerial = this.mDeviceLocalDataSource.getDeviceBySerial(str, getDeviceCallback);
        if (getDeviceCallback != null) {
            this.mDeviceRemoteDataSource.getDeviceBySerial(str, new GetDeviceCallback() {
                public void onSuccess(DeviceModel deviceModel) {
                    getDeviceCallback.onSuccess(deviceModel);
                    if (deviceModel != null) {
                        DeviceRepository.this.mDeviceLocalDataSource.updateDevice(deviceModel, null);
                        DeviceRepository.this.mUAppSystemVersionRepository.addOrUpdateUAppSystemVersionModel(new UAppSystemVersionModel(deviceModel.getDeviceId(), deviceModel.getMajor(), deviceModel.getMinor()));
                    }
                }

                public void onFailed(int i) {
                    getDeviceCallback.onFailed(i);
                }
            });
        }
        return deviceBySerial;
    }

    public List<DeviceModel> getAllDevice(final GetAllDeviceCallback getAllDeviceCallback) {
        List<DeviceModel> allDevice = this.mDeviceLocalDataSource.getAllDevice(getAllDeviceCallback);
        if (getAllDeviceCallback != null) {
            this.mDeviceRemoteDataSource.getAllDevice(new GetAllDeviceCallback() {
                public void onSuccess(List<DeviceModel> list) {
                    getAllDeviceCallback.onSuccess(list);
                    if (list != null && !list.isEmpty()) {
                        for (DeviceModel deviceModel : list) {
                            if (DeviceHelper.gf(deviceModel.getDeviceId())) {
                                DeviceRepository.this.mDeviceLocalDataSource.updateDevice(deviceModel, null);
                                DeviceRepository.this.mUAppSystemVersionRepository.addOrUpdateUAppSystemVersionModel(new UAppSystemVersionModel(deviceModel.getDeviceId(), deviceModel.getMajor(), deviceModel.getMinor()));
                            } else {
                                MFLogger.d(DeviceRepository.this.TAG, "Ignoring legacy device=" + deviceModel.getDeviceId());
                            }
                        }
                    }
                }

                public void onFailed(int i) {
                    getAllDeviceCallback.onFailed(i);
                }
            });
            return allDevice;
        } else if (this.mIsCacheDeviceDirty) {
            processDeviceList(this.mDeviceLocalDataSource.getAllDevice(getAllDeviceCallback));
            return getCachedDevice();
        } else if (this.mCacheDevice == null || this.mCacheDevice.size() == 0) {
            return this.mDeviceLocalDataSource.getAllDevice(getAllDeviceCallback);
        } else {
            return getCachedDevice();
        }
    }

    public List<SKUModel> getSupportedSkus() {
        List<SKUModel> supportedSkus = this.mDeviceLocalDataSource.getSupportedSkus();
        if (supportedSkus == null || supportedSkus.isEmpty()) {
            this.mDeviceRemoteDataSource.fetchSupportedSkus();
        }
        return supportedSkus;
    }

    public void fetchSupportedSkus() {
        this.mDeviceRemoteDataSource.fetchSupportedSkus();
    }

    public void reDownloadDevice() {
        this.mDeviceRemoteDataSource.getAllDevice(new C47707());
    }

    private boolean isHasDevice(List<DeviceModel> list, String str) {
        for (DeviceModel deviceId : list) {
            if (deviceId.getDeviceId().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public SKUModel getSkuModelBySerial(String str) {
        return null;
    }
}
