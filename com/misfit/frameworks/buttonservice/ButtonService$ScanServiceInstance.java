package com.misfit.frameworks.buttonservice;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectionCallback;
import com.misfit.ble.shine.ShineProfile.PreparationCallback;
import com.misfit.ble.shine.ShineProfile.PrepareActionResult;
import com.misfit.ble.shine.ShineProfile.State;
import com.misfit.frameworks.buttonservice.ble.ScanService;
import com.misfit.frameworks.buttonservice.ble.ScanService.Callback;
import com.misfit.frameworks.buttonservice.ble.ScanService.ScanServiceError;
import com.misfit.frameworks.buttonservice.log.MFLogManager;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class ButtonService$ScanServiceInstance implements Callback {
    private Context context;
    private ScanService scanService;
    final /* synthetic */ ButtonService this$0;

    public ButtonService$ScanServiceInstance(ButtonService buttonService, Context context) {
        this.this$0 = buttonService;
        this.context = context;
        this.scanService = new ScanService(context, this, System.currentTimeMillis() / 1000);
    }

    public void startScan() {
        MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".startScan");
        MFLogManager.getInstance(this.context).addLogForActiveLog("", "Start scan device");
        try {
            if (this.scanService != null) {
                stopScan();
            }
            this.scanService = new ScanService(this.context, this, System.currentTimeMillis() / 1000);
            this.scanService.setActiveDeviceLog("");
            MFLogManager.getInstance(this.context).addLogForActiveLog("", "Call 'start scan service'");
            this.scanService.startScan();
            this.scanService.retrieveHidConnectedDevice();
            List retrieveGattConnectedDevice = this.scanService.retrieveGattConnectedDevice();
            List retrieveBondedDevices = this.scanService.retrieveBondedDevices();
            if (retrieveGattConnectedDevice != null) {
                MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".startScan, retrieve Gatt connected devices: " + retrieveGattConnectedDevice.size());
                processDevices(retrieveGattConnectedDevice, 0);
            } else {
                MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".startScan - GATT connected device list is null.");
            }
            if (retrieveBondedDevices != null) {
                MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".startScan, retrieve Bond connected devices: " + retrieveBondedDevices.size());
                processDevices(retrieveBondedDevices, ScanService.RETRIEVE_DEVICE_BOND_RSSI_MARK);
                return;
            }
            MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".startScan - bonded device list is null.");
        } catch (Exception e) {
            MFLogger.e(ButtonService.access$000(), "Error on start scan " + e);
        }
    }

    public void stopScan() {
        MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".stopScan");
        this.scanService.stopScan();
    }

    public void onDeviceFound(ShineDevice shineDevice, int i) {
        this.this$0.onDeviceFound(shineDevice, i);
    }

    public void onConnectedDeviceRetrieved(List<ShineDevice> list) {
        if (list != null) {
            MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".onConnectedDeviceRetrieved, retrieve HID connected devices: " + list.size());
            processDevices(list, 0);
            return;
        }
        MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".onConnectedDeviceRetrieved - HID connected device null.");
    }

    private void processDevices(List<ShineDevice> list, final int i) {
        for (final ShineDevice shineDevice : list) {
            if (TextUtils.isEmpty(shineDevice.getSerialNumber())) {
                final Handler handler = new Handler(this.context.getMainLooper());
                final Runnable c46691 = new Runnable() {
                    public void run() {
                        MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".processDevices - Timeout!!! Close connection to " + shineDevice.getAddress() + ", rssi: " + i);
                        shineDevice.closeProfile();
                        ButtonService$ScanServiceInstance.this.onDeviceFound(shineDevice, i);
                    }
                };
                MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".processDevices - connect to get serial, mac: " + shineDevice.getAddress() + ", rssi: " + i);
                shineDevice.connectProfile(10000, new ConnectionCallback() {

                    class C46701 implements PreparationCallback {
                        C46701() {
                        }

                        public void onPreparationCompleted(ShineProfile shineProfile, PrepareActionResult prepareActionResult) {
                            ShineDevice device = shineProfile.getDevice();
                            MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".processDevices - Got serial number succeeded. Close connection to serial: " + device.getSerialNumber() + ", mac: " + device.getAddress() + ", rssi: " + i);
                            device.closeProfile();
                            handler.removeCallbacks(c46691);
                            ButtonService$ScanServiceInstance.this.onDeviceFound(device, i);
                        }
                    }

                    public void onConnectionStateChanged(ShineProfile shineProfile, State state, ConnectActionResult connectActionResult) {
                        if (state == State.CONNECTED) {
                            shineProfile.prepare(new C46701());
                        }
                    }
                });
                try {
                    handler.postDelayed(c46691, 10000);
                } catch (Exception e) {
                    MFLogger.e(ButtonService.access$000(), "Error inside " + ButtonService.access$000() + ".processDevices - e=" + e);
                }
            } else {
                onDeviceFound(shineDevice, i);
            }
        }
    }

    public void onScanFail(ScanServiceError scanServiceError) {
    }
}
