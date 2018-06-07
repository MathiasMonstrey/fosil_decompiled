package com.portfolio.platform.data.source.local;

import com.fossil.cnq;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.source.DeviceDataSource;
import com.portfolio.platform.data.source.DeviceDataSource.GetAllDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.GetDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.LinkDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.RemoveDeviceCallback;
import com.portfolio.platform.data.source.DeviceDataSource.UpdateDeviceCallback;
import com.portfolio.platform.helper.DeviceHelper;
import java.util.List;

public class DeviceLocalDataSource implements DeviceDataSource {
    public void updateDevice(DeviceModel deviceModel, UpdateDeviceCallback updateDeviceCallback) {
        cnq.acd().acp().a(deviceModel);
    }

    public void linkDevice(DeviceModel deviceModel, LinkDeviceCallback linkDeviceCallback) {
        cnq.acd().acp().a(deviceModel);
    }

    public void stealDevice(DeviceModel deviceModel, LinkDeviceCallback linkDeviceCallback) {
        cnq.acd().acp().a(deviceModel);
    }

    public void removeDevice(DeviceModel deviceModel, RemoveDeviceCallback removeDeviceCallback) {
        cnq.acd().acp().he(deviceModel.getDeviceId());
    }

    public DeviceModel getDeviceBySerial(String str, GetDeviceCallback getDeviceCallback) {
        return cnq.acd().acp().hd(str);
    }

    public List<DeviceModel> getAllDevice(GetAllDeviceCallback getAllDeviceCallback) {
        return cnq.acd().acp().adS();
    }

    public List<SKUModel> getSupportedSkus() {
        return cnq.acd().acp().adW();
    }

    public void fetchSupportedSkus() {
    }

    public void reDownloadDevice() {
    }

    public SKUModel getSkuModelBySerial(String str) {
        return cnq.acd().acp().hl(DeviceHelper.gi(str));
    }
}
