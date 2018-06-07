package com.misfit.frameworks.buttonservice.ble;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.misfit.ble.shine.ShineAdapter;
import com.misfit.ble.shine.ShineAdapter.ScanFailedErrorCode;
import com.misfit.ble.shine.ShineAdapter.ShineRetrieveCallback;
import com.misfit.ble.shine.ShineAdapter.ShineScanCallback;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectionCallback;
import com.misfit.ble.shine.ShineProfile.PreparationCallback;
import com.misfit.ble.shine.ShineProfile.PrepareActionResult;
import com.misfit.ble.shine.ShineProfile.State;
import com.misfit.frameworks.buttonservice.log.MFLog;
import com.misfit.frameworks.buttonservice.log.MFLogManager;
import com.misfit.frameworks.buttonservice.utils.DeviceUtils;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ScanService implements ShineRetrieveCallback, ShineScanCallback {
    private static final long BLE_SCAN_TIMEOUT = 120000;
    private static final int CONNECT_TIMEOUT = 10000;
    public static final int RETRIEVE_DEVICE_BOND_RSSI_MARK = -999999;
    public static final int RETRIEVE_DEVICE_RSSI_MARK = 0;
    private static final String TAG = ScanService.class.getSimpleName();
    private Handler autoStopHandler;
    private Runnable autoStopTask = new C46731();
    private Callback callback;
    private Context context;
    private List<HidConnectedDeviceHelper> hidConnectHelpers;
    private boolean isScanning;
    private MFLog mfLog;
    private ShineAdapter shineAdapter;
    private long startScanTimestamp;
    private long tagTime;

    public interface Callback {
        void onConnectedDeviceRetrieved(List<ShineDevice> list);

        void onDeviceFound(ShineDevice shineDevice, int i);

        void onScanFail(ScanServiceError scanServiceError);
    }

    class C46731 implements Runnable {
        C46731() {
        }

        public void run() {
            ScanService.this.stopScan();
        }
    }

    interface HidConnectedDeviceHelperCallback {
        void onGotSerialNumber(ShineDevice shineDevice);
    }

    class HidConnectedDeviceHelper {
        private HidConnectedDeviceHelperCallback helperCallback;
        private boolean isLive;
        private boolean isRetrieved;
        private ShineDevice shineDevice;
        private ShineProfile shineProfile;
        private Handler timer;
        private Runnable timerTask;

        class C46751 implements Runnable {
            C46751() {
            }

            public void run() {
                if (HidConnectedDeviceHelper.this.isLive) {
                    HidConnectedDeviceHelper.this.isLive = false;
                    if (HidConnectedDeviceHelper.this.shineDevice != null) {
                        State shineProfileState = HidConnectedDeviceHelper.this.shineDevice.getShineProfileState();
                        MFLogger.d(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - mac=" + HidConnectedDeviceHelper.this.shineDevice.getAddress() + " - Timeout!!! - currentState=" + shineProfileState);
                        if (shineProfileState == State.CONNECTED || shineProfileState == State.PREPARING) {
                            ScanService.this.log("Connect to " + HidConnectedDeviceHelper.this.shineDevice.getAddress() + " timeout - currentState=" + shineProfileState + ". Waiting for SDK callback...");
                            MFLogger.d(ScanService.TAG, ".onConnectedShinesRetrieved - Device is connected, waiting for serial");
                        } else {
                            ScanService.this.log("Connect to " + HidConnectedDeviceHelper.this.shineDevice.getAddress() + " timeout - Closing connection...");
                            MFLogger.d(ScanService.TAG, ".onConnectedShinesRetrieved - Connect to " + HidConnectedDeviceHelper.this.shineDevice.getAddress() + " timeout. Closing connection");
                            HidConnectedDeviceHelper.this.shineDevice.closeProfile();
                        }
                    }
                    HidConnectedDeviceHelper.this.helperCallback.onGotSerialNumber(HidConnectedDeviceHelper.this.shineDevice);
                }
            }
        }

        private HidConnectedDeviceHelper() {
            this.timerTask = new C46751();
        }

        public void setLive(boolean z) {
            this.isLive = z;
        }

        private void connectAndGetSerial(final ShineDevice shineDevice, HidConnectedDeviceHelperCallback hidConnectedDeviceHelperCallback) {
            this.isLive = true;
            this.isRetrieved = false;
            this.helperCallback = hidConnectedDeviceHelperCallback;
            this.shineDevice = shineDevice;
            this.timer = new Handler(Looper.getMainLooper());
            this.shineDevice.addDataCollectionTag(ScanService.this.getCollectionTagByActiveLog());
            final PreparationCallback c46762 = new PreparationCallback() {
                public void onPreparationCompleted(ShineProfile shineProfile, PrepareActionResult prepareActionResult) {
                    if (HidConnectedDeviceHelper.this.isLive) {
                        HidConnectedDeviceHelper.this.isLive = false;
                        ShineDevice device = shineProfile.getDevice();
                        HidConnectedDeviceHelper.this.timer.removeCallbacks(HidConnectedDeviceHelper.this.timerTask);
                        ScanService.this.log("Prepared to " + shineDevice.getAddress() + " - serial=" + device.getSerialNumber() + ". Closing connection...");
                        MFLogger.d(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - Got serial number succeeded - serial=" + device.getSerialNumber() + ". Close connection to " + device.getAddress());
                        HidConnectedDeviceHelper.this.isRetrieved = true;
                        device.closeProfile();
                    }
                }
            };
            this.shineProfile = shineDevice.getShineProfile();
            if (this.shineProfile == null) {
                ScanService.this.log("Connect profile to " + shineDevice.getAddress() + " to get serial");
                shineDevice.connectProfile(10000, new ConnectionCallback() {
                    public void onConnectionStateChanged(ShineProfile shineProfile, State state, ConnectActionResult connectActionResult) {
                        MFLogger.d(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - Connection state changed - state=" + state + ", resultCode=" + connectActionResult.getResultCode());
                        ScanService.this.log("Connection state changed - state=" + state + ", resultCode=" + connectActionResult.getResultCode());
                        if (state == State.CONNECTED) {
                            MFLogger.d(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - Prepare to device...");
                            ScanService.this.log("Connected to " + shineDevice.getAddress() + ". Prepare to device...");
                            if (HidConnectedDeviceHelper.this.isLive) {
                                shineProfile.prepare(c46762);
                            }
                        } else if (HidConnectedDeviceHelper.this.isRetrieved) {
                            MFLogger.e(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - retrieve success");
                            HidConnectedDeviceHelper.this.helperCallback.onGotSerialNumber(shineDevice);
                        } else {
                            MFLogger.e(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - Failed to connect to device");
                            ScanService.this.log("Connect to " + shineDevice.getAddress() + ". FAILED: state=" + state);
                        }
                    }
                });
            } else {
                State shineProfileState = shineDevice.getShineProfileState();
                MFLogger.d(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - Current state=" + shineProfileState);
                ScanService.this.log("Current state=" + shineProfileState);
                ScanService.this.log("Connect profile to " + shineDevice.getAddress() + " to get serial");
                shineDevice.connectProfile(10000, new ConnectionCallback() {
                    public void onConnectionStateChanged(ShineProfile shineProfile, State state, ConnectActionResult connectActionResult) {
                        MFLogger.d(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - Connection state changed - state=" + state + ", resultCode=" + connectActionResult.getResultCode());
                        ScanService.this.log("Connection state changed - state=" + state + ", resultCode=" + connectActionResult.getResultCode());
                        if (state == State.CONNECTED) {
                            MFLogger.d(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - Prepare to device...");
                            ScanService.this.log("Connected to " + shineDevice.getAddress() + ". Prepare to device...");
                            if (HidConnectedDeviceHelper.this.isLive) {
                                shineProfile.prepare(c46762);
                            }
                        } else if (HidConnectedDeviceHelper.this.isRetrieved) {
                            MFLogger.e(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - retrieve success");
                            HidConnectedDeviceHelper.this.helperCallback.onGotSerialNumber(shineDevice);
                        } else {
                            MFLogger.e(ScanService.TAG, "Inside " + ScanService.TAG + ".onConnectedShinesRetrieved - Failed to connect to device");
                            ScanService.this.log("Connect to " + shineDevice.getAddress() + ". FAILED: state=" + state);
                        }
                    }
                });
            }
            try {
                this.timer.postDelayed(this.timerTask, 10000);
            } catch (Exception e) {
                MFLogger.e(ScanService.TAG, "Error inside " + ScanService.TAG + ".onConnectedDeviceRetrieved - e=" + e);
            }
        }
    }

    public final class ScanServiceError {
        public final String message;
        public final ScanFailedErrorCode sdkError;

        public ScanServiceError(ScanFailedErrorCode scanFailedErrorCode, String str) {
            this.sdkError = scanFailedErrorCode;
            this.message = str;
        }
    }

    public ScanService(Context context, Callback callback, long j) {
        this.tagTime = j;
        this.callback = callback;
        this.shineAdapter = ShineAdapter.getDefaultAdapter(context);
        this.context = context.getApplicationContext();
        this.isScanning = false;
        this.hidConnectHelpers = new ArrayList();
    }

    public void setActiveDeviceLog(String str) {
        this.mfLog = MFLogManager.getInstance(this.context).getActiveLog(str);
    }

    private void startAutoStopTimer() {
        stopAutoStopTimer();
        this.autoStopHandler = new Handler(Looper.getMainLooper());
        this.autoStopHandler.postDelayed(this.autoStopTask, BLE_SCAN_TIMEOUT);
    }

    private void stopAutoStopTimer() {
        if (this.autoStopHandler != null) {
            this.autoStopHandler.removeCallbacks(this.autoStopTask);
        }
    }

    public synchronized void startScanWithAutoStopTimer() {
        MFLogger.i(TAG, "Inside .startScanWithAutoStopTimer shineAdapter is " + this.shineAdapter);
        if (this.shineAdapter != null) {
            try {
                startAutoStopTimer();
                this.isScanning = true;
                this.shineAdapter.startScanning(this, getCollectionTagByActiveLog());
                MFLogger.i(TAG, "Inside .startScanWithAutoStopTimer callback hashcode is " + hashCode());
                this.startScanTimestamp = System.currentTimeMillis();
            } catch (Exception e) {
                MFLogger.e(TAG, "Error inside " + TAG + ".startScanWithAutoStopTimer - e=" + e);
                stopAutoStopTimer();
                onScanFailed(new ScanServiceError(ScanFailedErrorCode.INTERNAL_ERROR, e.getMessage()));
            }
        }
    }

    public synchronized void startScan() {
        MFLogger.i(TAG, "Inside .startScan shineAdapter is " + this.shineAdapter);
        if (this.shineAdapter != null) {
            try {
                this.isScanning = true;
                this.shineAdapter.startScanning(this, getCollectionTagByActiveLog());
                log("Called start scan api.");
                MFLogger.i(TAG, "Inside .startScanWithAutoStopTimer callback hashcode is " + hashCode());
                this.startScanTimestamp = -1;
            } catch (Exception e) {
                MFLogger.e(TAG, "Error inside " + TAG + ".startScan - e=" + e);
                onScanFailed(new ScanServiceError(ScanFailedErrorCode.INTERNAL_ERROR, e.getMessage()));
            }
        }
    }

    public synchronized void stopScan() {
        MFLogger.i(TAG, "Inside .stopScan shineAdapter is " + this.shineAdapter);
        this.startScanTimestamp = -1;
        this.isScanning = false;
        stopAutoStopTimer();
        for (HidConnectedDeviceHelper live : this.hidConnectHelpers) {
            live.setLive(false);
        }
        this.hidConnectHelpers.clear();
        if (this.shineAdapter != null) {
            try {
                MFLogger.i(TAG, "Inside .stopScan, call stopScanning of shineAdapter");
                this.shineAdapter.stopScanning(this);
                MFLogger.i(TAG, "Inside .stopScan callback hashcode is " + hashCode());
            } catch (Exception e) {
                MFLogger.e(TAG, "Error inside " + TAG + ".stopScan - e=" + e);
            }
        }
    }

    public List<ShineDevice> retrieveGattConnectedDevice() {
        MFLogger.i(TAG, "Inside .retrieveGattConnectedDevice shineAdapter is " + this.shineAdapter);
        if (this.shineAdapter != null) {
            try {
                List<ShineDevice> gattConnectedShines = this.shineAdapter.getGattConnectedShines(getCollectionTagByActiveLog());
                int size = (gattConnectedShines == null || gattConnectedShines.size() == 0) ? 0 : gattConnectedShines.size();
                MFLogger.d(TAG, "Inside " + TAG + ".retrieveGattConnectedDevice - size=" + size);
                return gattConnectedShines;
            } catch (Exception e) {
                MFLogger.e(TAG, "Error inside " + TAG + ".retrieveGattConnectedDevice - e=" + e);
                onScanFailed(new ScanServiceError(ScanFailedErrorCode.INTERNAL_ERROR, e.getMessage()));
                return null;
            }
        }
        MFLogger.e(TAG, "Inside .retrieveGattConnectedDevice with shineAdapter null");
        return null;
    }

    public ShineDevice buildDeviceByMacAddress(String str) {
        if (TextUtils.isEmpty(str) || this.shineAdapter == null) {
            return null;
        }
        return this.shineAdapter.buildShineDevice(str);
    }

    public void retrieveHidConnectedDevice() {
        MFLogger.i(TAG, "Inside .retrieveHidConnectedDevice shineAdapter is " + this.shineAdapter);
        if (this.shineAdapter != null) {
            try {
                this.isScanning = true;
                this.shineAdapter.getHIDConnectedShines(this, getCollectionTagByActiveLog());
                return;
            } catch (Exception e) {
                MFLogger.e(TAG, "Error inside " + TAG + ".retrieveHidConnectedDevice - e=" + e);
                onScanFailed(new ScanServiceError(ScanFailedErrorCode.INTERNAL_ERROR, e.getMessage()));
                return;
            }
        }
        MFLogger.e(TAG, "Inside .retrieveHidConnectedDevice with shineAdapter null");
    }

    public void retrieveConnectedDevice() {
        MFLogger.i(TAG, "Inside .retrieveConnectedDevice shineAdapter is " + this.shineAdapter);
        if (this.shineAdapter != null) {
            try {
                this.shineAdapter.getConnectedShines(this, getCollectionTagByActiveLog());
                return;
            } catch (Exception e) {
                MFLogger.e(TAG, "Error inside " + TAG + ".retrieveConnectedDevice - e=" + e);
                onScanFailed(new ScanServiceError(ScanFailedErrorCode.INTERNAL_ERROR, e.getMessage()));
                return;
            }
        }
        MFLogger.e(TAG, "Inside .retrieveConnectedDevice with shineAdapter null");
    }

    public List<ShineDevice> retrieveBondedDevices() {
        MFLogger.i(TAG, "Inside .retrieveBondedDevices shineAdapter is " + this.shineAdapter);
        List<ShineDevice> arrayList = new ArrayList();
        if (this.shineAdapter != null) {
            Collection bondedShines = this.shineAdapter.getBondedShines(getCollectionTagByActiveLog());
            if (bondedShines != null) {
                arrayList.addAll(bondedShines);
            }
        } else {
            MFLogger.e(TAG, "Inside .retrieveBondedDevices with shineAdapter null");
        }
        return arrayList;
    }

    public void onConnectedShinesRetrieved(final List<ShineDevice> list) {
        if (this.isScanning) {
            int size = (list == null || list.size() == 0) ? 0 : list.size();
            MFLogger.d(TAG, "Inside " + TAG + ".onConnectedShinesRetrieved - size=" + size);
            final HashMap hashMap = new HashMap();
            if (list != null && list.size() != 0) {
                for (final ShineDevice shineDevice : list) {
                    MFLogger.d(TAG, "serial=" + shineDevice.getSerialNumber());
                    if (!TextUtils.isEmpty(shineDevice.getSerialNumber())) {
                        hashMap.put(shineDevice.getAddress(), shineDevice);
                        onGotSerialOfRetrievedDevices(list, hashMap);
                    } else if (TextUtils.isEmpty(DeviceUtils.getInstance(this.context).getSerial(this.context, shineDevice.getAddress()))) {
                        MFLogger.d(TAG, "Inside " + TAG + ".onConnectedShinesRetrieved - Connecting to " + shineDevice.getAddress() + " to get serial...");
                        HidConnectedDeviceHelper hidConnectedDeviceHelper = new HidConnectedDeviceHelper();
                        this.hidConnectHelpers.add(hidConnectedDeviceHelper);
                        hidConnectedDeviceHelper.connectAndGetSerial(shineDevice, new HidConnectedDeviceHelperCallback() {
                            public void onGotSerialNumber(ShineDevice shineDevice) {
                                hashMap.put(shineDevice.getAddress(), shineDevice);
                                ScanService.this.onGotSerialOfRetrievedDevices(list, hashMap);
                            }
                        });
                    } else {
                        MFLogger.d(TAG, "Inside " + TAG + ".onConnectedShinesRetrieved - Serial already existed in cache");
                        hashMap.put(shineDevice.getAddress(), shineDevice);
                        onGotSerialOfRetrievedDevices(list, hashMap);
                    }
                }
            } else if (this.callback != null) {
                this.callback.onConnectedDeviceRetrieved(new ArrayList());
            } else {
                MFLogger.e(TAG, "onConnectedShinesRetrieved - callback is NULL");
            }
        }
    }

    private void onGotSerialOfRetrievedDevices(List<ShineDevice> list, HashMap<String, ShineDevice> hashMap) {
        if (this.callback == null) {
            MFLogger.e(TAG, "Inside .onGotSerialOfRetrievedDevices, callback is null");
        } else if (list.size() == hashMap.size()) {
            this.callback.onConnectedDeviceRetrieved(new ArrayList(hashMap.values()));
        }
    }

    public void onScanResult(ShineDevice shineDevice, int i) {
        long currentTimeMillis = System.currentTimeMillis() - this.startScanTimestamp;
        MFLogger.d(TAG, "onScanResult " + shineDevice.getSerialNumber() + ", delta=" + currentTimeMillis + ", hashcode=" + hashCode());
        if (currentTimeMillis > BLE_SCAN_TIMEOUT && this.startScanTimestamp > 0) {
            MFLogger.i(TAG, "!!! Seem like scanning was not stopped correctly. Stop scanning to save battery !!!");
            stopScan();
        }
        if (this.callback != null) {
            this.callback.onDeviceFound(shineDevice, i);
        } else {
            MFLogger.e(TAG, "Inside .onScanResult, callback is null");
        }
    }

    public void onScanFailed(ScanFailedErrorCode scanFailedErrorCode) {
        onScanFailed(new ScanServiceError(scanFailedErrorCode, "Sdk error"));
    }

    private void onScanFailed(ScanServiceError scanServiceError) {
        stopScan();
        if (this.callback != null) {
            this.callback.onScanFail(scanServiceError);
        } else {
            MFLogger.e(TAG, "Inside .onScanFailed, callback is null");
        }
        this.callback = null;
    }

    private void log(String str) {
        if (this.mfLog != null) {
            this.mfLog.log("[" + this.mfLog.getSerial() + " - Scanning] " + str);
        }
    }

    private String getCollectionTagByActiveLog() {
        return this.mfLog != null ? String.valueOf(this.mfLog.getStartTimeEpoch()) : Long.toString(this.tagTime);
    }
}
