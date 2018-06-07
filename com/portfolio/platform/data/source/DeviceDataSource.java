package com.portfolio.platform.data.source;

import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.SKUModel;
import java.util.List;

public interface DeviceDataSource {

    public interface GetAllDeviceCallback {
        void onFailed(int i);

        void onSuccess(List<DeviceModel> list);
    }

    public interface GetDeviceCallback {
        void onFailed(int i);

        void onSuccess(DeviceModel deviceModel);
    }

    public interface GetSupportedDeviceCallback {
        void onGetSupportedDeviceComplete(List<SKUModel> list, boolean z);
    }

    public interface LinkDeviceCallback {
        void onFail(int i);

        void onSuccess(DeviceModel deviceModel);
    }

    public interface RemoveDeviceCallback {
        void onFailed(int i);

        void onSuccess();
    }

    public interface UpdateDeviceCallback {
        void onFailed(int i);

        void onSuccess();
    }

    void fetchSupportedSkus();

    List<DeviceModel> getAllDevice(GetAllDeviceCallback getAllDeviceCallback);

    DeviceModel getDeviceBySerial(String str, GetDeviceCallback getDeviceCallback);

    SKUModel getSkuModelBySerial(String str);

    List<SKUModel> getSupportedSkus();

    void linkDevice(DeviceModel deviceModel, LinkDeviceCallback linkDeviceCallback);

    void reDownloadDevice();

    void removeDevice(DeviceModel deviceModel, RemoveDeviceCallback removeDeviceCallback);

    void stealDevice(DeviceModel deviceModel, LinkDeviceCallback linkDeviceCallback);

    void updateDevice(DeviceModel deviceModel, UpdateDeviceCallback updateDeviceCallback);
}
