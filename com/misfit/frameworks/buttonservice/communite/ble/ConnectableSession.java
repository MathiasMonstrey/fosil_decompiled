package com.misfit.frameworks.buttonservice.communite.ble;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectionResult;
import com.misfit.ble.shine.ShineProfile.State;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.BluetoothUtils;
import com.misfit.frameworks.buttonservice.utils.DeviceUtils;
import com.misfit.frameworks.buttonservice.utils.LocationUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;

public abstract class ConnectableSession extends BleSession {
    private static final int MAX_RETRIES = 3;
    protected int maxRetries = 3;
    protected SdkCallback sdkCallback;
    protected Object[] sessionParams;

    public class CloseConnectionWhenTimeoutState extends BleState {
        private int failureCode;

        public void setFailureCode(int i) {
            this.failureCode = i;
        }

        public CloseConnectionWhenTimeoutState() {
            super(ConnectableSession.this.TAG);
            ConnectableSession.this.log("Close connection of device with serial " + ConnectableSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            ConnectableSession.this.bleAdapter.closeConnection(!ConnectableSession.this.canRetry(ConnectableSession.this.maxRetries, this.failureCode));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            ConnectableSession.this.stop(this.failureCode);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            ConnectableSession.this.log("Close connection timeout.");
            ConnectableSession.this.stop(this.failureCode);
        }
    }

    public class ConnectingState extends BleState {
        protected int failureCodeOfState = FailureCode.FAILED_TO_CONNECT;
        protected boolean isScannedDevice;

        public void setIsScannedDevice(boolean z) {
            this.isScannedDevice = z;
            if (z) {
                this.failureCodeOfState = FailureCode.FAILED_TO_CONNECT_BY_SCANNED_DEVICE;
            }
        }

        public ConnectingState() {
            super(ConnectableSession.this.TAG);
            ConnectableSession.this.log("Connecting to device with serial " + ConnectableSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            ConnectableSession.this.log("Connecting to device, hid state " + ConnectableSession.this.bleAdapter.getHidState());
            if (ConnectableSession.this.bleAdapter.connect(true, (long) ConnectableSession.this.getStartTime())) {
                return true;
            }
            stopTimeout();
            onFatal(this.failureCodeOfState);
            return false;
        }

        public boolean handleOnDeviceConnected() {
            ConnectableSession.this.log(String.format("Connect to %s. OK", new Object[]{ConnectableSession.this.serial}));
            ConnectableSession.this.log("hid state " + ConnectableSession.this.bleAdapter.getHidState());
            stopTimeout();
            if (this.isScannedDevice) {
                ConnectableSession.this.addFailureCode(FailureCode.CONNECT_BY_SCANNED_DEVICE_SUCCESS);
            } else {
                ConnectableSession.this.addFailureCode(FailureCode.CONNECT_BY_MAC_SUCCESS);
            }
            ConnectableSession.this.enterState(ConnectableSession.this.createConcreteState(SessionState.PREPARE_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            if (connectActionResult != null) {
                ConnectableSession.this.log(String.format("Connect to %s. FAILED, reason = %s", new Object[]{ConnectableSession.this.serial, connectActionResult.getResultCode()}));
            } else {
                ConnectableSession.this.log(String.format("Connect to %s. FAILED, reason = NULL", new Object[]{ConnectableSession.this.serial}));
            }
            ConnectableSession.this.log(String.format("Connect to %s. FAILED, reason = %s", new Object[]{ConnectableSession.this.serial, connectActionResult}));
            ConnectableSession.this.log("hid state " + ConnectableSession.this.bleAdapter.getHidState());
            processActionResult(connectActionResult);
            stopTimeout();
            if (connectActionResult == null || connectActionResult.getResultCode() == ConnectionResult.SUCCEEDED || VERSION.SDK_INT != 24) {
                ConnectableSession.this.log("current failure code " + this.failureCodeOfState);
                onFatal(this.failureCodeOfState);
            } else {
                MFLogger.d(ConnectableSession.this.TAG, "Inside " + ConnectableSession.this.TAG + ".handleOnDeviceDisconnected, reason=" + connectActionResult.getResultCode() + ", manufacturer=" + Build.MANUFACTURER + ", os version=" + 24 + ", retry=" + 1);
                ConnectableSession.this.maxRetries = 1;
                ConnectableSession.this.log("current failure code " + this.failureCodeOfState);
                ConnectableSession.this.stop(this.failureCodeOfState);
            }
            return true;
        }

        protected void processActionResult(ConnectActionResult connectActionResult) {
            if (connectActionResult.getResultCode() != ConnectionResult.TIMED_OUT) {
                return;
            }
            if (this.isScannedDevice) {
                this.failureCodeOfState = FailureCode.FAILED_TO_CONNECT_BY_SCANNED_DEVICE_TIMEOUT;
            } else {
                this.failureCodeOfState = FailureCode.FAILED_TO_CONNECT_TIMEOUT;
            }
        }

        protected void onFatal(int i) {
            super.onFatal(i);
            ConnectableSession.this.maxRetries = 0;
            ConnectableSession.this.stop(i);
        }

        protected void onTimeout() {
            super.onTimeout();
            ConnectableSession.this.log("Connect timeout.");
            ConnectableSession.this.maxRetries = 0;
            processActionResult(new ConnectActionResult(-1000, ConnectionResult.TIMED_OUT, null));
            CloseConnectionWhenTimeoutState closeConnectionWhenTimeoutState = (CloseConnectionWhenTimeoutState) ConnectableSession.this.createConcreteState(SessionState.CLOSE_CONNECTION_WHEN_CONNECT_TIMEOUT);
            if (closeConnectionWhenTimeoutState != null) {
                closeConnectionWhenTimeoutState.setFailureCode(this.failureCodeOfState);
                ConnectableSession.this.enterState(closeConnectionWhenTimeoutState);
                return;
            }
            ConnectableSession.this.stop(this.failureCodeOfState);
        }
    }

    public class DisconnectHIDState extends BleState {
        public DisconnectHIDState() {
            super(ConnectableSession.this.TAG);
            ConnectableSession.this.log("Disconnect HID to" + ConnectableSession.this.serial);
        }

        public boolean onEnter() {
            startTimeout();
            if (ConnectableSession.this.bleAdapter.hidDisconnect()) {
                return true;
            }
            stopTimeout();
            ConnectableSession.this.enterStateWithDelayTime(ConnectableSession.this.getFirstState(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            ConnectableSession.this.enterState(ConnectableSession.this.getFirstState());
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            ConnectableSession.this.log("Disconnect HID timeout.");
            ConnectableSession.this.enterState(ConnectableSession.this.getFirstState());
        }

        public int getTimeout() {
            return 5000;
        }
    }

    public class PreRetryState extends BleState {
        protected boolean waitingForConnectionClosed;

        public PreRetryState() {
            super(ConnectableSession.this.TAG);
            ConnectableSession.this.log("Prepare to retry session. close connection of device with serial " + ConnectableSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            this.waitingForConnectionClosed = true;
            ConnectableSession.this.bleAdapter.closeConnection(false);
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            if (!this.waitingForConnectionClosed) {
                return false;
            }
            ConnectableSession.this.enterState(ConnectableSession.this.createConcreteState(SessionState.HID_DISCONNECT_STATE));
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            ConnectableSession.this.log("Prepare to retry session timeout.");
            if (this.waitingForConnectionClosed) {
                ConnectableSession.this.enterState(ConnectableSession.this.createConcreteState(SessionState.HID_DISCONNECT_STATE));
            }
        }

        public int getTimeout() {
            return 5000;
        }
    }

    public class PrepareState extends BleState {
        protected int failureCodeOfState = FailureCode.FAILED_TO_PREPARE;

        public PrepareState() {
            super(ConnectableSession.this.TAG);
            ConnectableSession.this.addDataCollectionTagToSdk();
            ConnectableSession.this.log("Start prepare to" + ConnectableSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (ConnectableSession.this.bleAdapter.prepare()) {
                return true;
            }
            stopTimeout();
            ConnectableSession.this.stop(this.failureCodeOfState);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            ConnectableSession.this.log("Prepare timeout.");
            ConnectableSession.this.stop(this.failureCodeOfState);
        }

        public boolean handleOnDevicePreparedCompleted(boolean z) {
            stopTimeout();
            if (z) {
                ConnectableSession.this.enterState(ConnectableSession.this.getStateAfterConnected());
            } else {
                ConnectableSession.this.stop(this.failureCodeOfState);
            }
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            ConnectableSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class ScanningFirstStepState extends BleState {
        protected static final int GATT_DEVICE = 0;
        protected static final int MAC_DEVICE = 1;
        protected static final int SCANNED_DEVICE = 2;
        protected boolean found;

        public ScanningFirstStepState() {
            super(ConnectableSession.this.TAG);
            ConnectableSession.this.log("Looking for device - serial=" + ConnectableSession.this.serial + ", mac=" + ConnectableSession.this.bleAdapter.getMacAddress() + " - first step...");
        }

        public int getTimeout() {
            return 30000;
        }

        public boolean handleOnDeviceScanned(ShineDevice shineDevice, int i) {
            String serial;
            boolean z;
            CharSequence serialNumber = shineDevice.getSerialNumber();
            MFLogger.d(ConnectableSession.this.TAG, "Inside " + ConnectableSession.this.TAG + ".handleOnDeviceScanned - [" + (i == 0 ? "Retrieved" : "Found") + ": " + serialNumber + ", " + shineDevice.getAddress() + "], [Candidate: " + ConnectableSession.this.bleAdapter.getSerial() + ", " + ConnectableSession.this.bleAdapter.getMacAddress() + "]");
            if (TextUtils.isEmpty(serialNumber)) {
                serial = DeviceUtils.getInstance(ConnectableSession.this.context).getSerial(ConnectableSession.this.context, shineDevice.getAddress());
            } else {
                CharSequence charSequence = serialNumber;
            }
            if (TextUtils.isEmpty(ConnectableSession.this.serial) || !ConnectableSession.this.serial.equals(serial)) {
                z = false;
            } else {
                z = true;
            }
            this.found = z;
            this.found |= shineDevice.getAddress().equals(ConnectableSession.this.bleAdapter.getMacAddress());
            ConnectableSession.this.log(String.format((i == 0 ? "Retrieved" : "Found") + ": %s, MAC %s", new Object[]{serial, shineDevice.getAddress()}));
            if (this.found) {
                ConnectableSession.this.log("Found device: " + serial);
                stopTimeout();
                ConnectableSession.this.bleAdapter.stopScanning();
                ConnectableSession.this.bleAdapter.setShineDevice(shineDevice);
                ConnectableSession.this.enterState(stateAfterFoundDevice(2));
            }
            return true;
        }

        public boolean onEnter() {
            int i;
            super.onEnter();
            boolean isBluetoothEnable = BluetoothUtils.isBluetoothEnable();
            boolean isLocationPermissionGranted = LocationUtils.isLocationPermissionGranted(ConnectableSession.this.context);
            boolean isLocationEnable = LocationUtils.isLocationEnable(ConnectableSession.this.context);
            ShineDevice shineDevice = null;
            for (ShineDevice shineDevice2 : ConnectableSession.this.bleAdapter.retrieveGattDevices((long) ConnectableSession.this.getStartTime())) {
                if (isFound(shineDevice2)) {
                    shineDevice = shineDevice2;
                    i = 0;
                    break;
                }
            }
            i = 1;
            if (shineDevice == null) {
                shineDevice = ConnectableSession.this.bleAdapter.buildShineDeviceByMAC((long) ConnectableSession.this.getStartTime());
                i = 1;
            }
            if (shineDevice != null) {
                ConnectableSession.this.log("Found device: " + ConnectableSession.this.serial);
                if (isBluetoothEnable) {
                    ConnectableSession.this.bleAdapter.setShineDevice(shineDevice);
                    ConnectableSession.this.enterStateWithDelayTime(stateAfterFoundDevice(i), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                } else {
                    ConnectableSession.this.log("Cannot move on. Bluetooth is disable.");
                    ConnectableSession.this.maxRetries = 0;
                    ConnectableSession.this.stop(FailureCode.BLUETOOTH_IS_DISABLED);
                }
            } else {
                ConnectableSession.this.log("Not found device, start scan ");
                if (!isBluetoothEnable) {
                    ConnectableSession.this.log("Cannot start scan. Bluetooth is disable.");
                    ConnectableSession.this.maxRetries = 0;
                    ConnectableSession.this.stop(FailureCode.BLUETOOTH_IS_DISABLED);
                } else if (!isLocationPermissionGranted) {
                    ConnectableSession.this.log("Cannot start scan. Location permission is disable.");
                    if (!isLocationEnable) {
                        ConnectableSession.this.log("Cannot start scan. Location service is off.");
                    }
                    ConnectableSession.this.maxRetries = 0;
                    ConnectableSession.this.stop(FailureCode.LOCATION_ACCESS_DENIED);
                } else if (isLocationEnable) {
                    startTimeout();
                    ConnectableSession.this.bleAdapter.startScanning((long) ConnectableSession.this.getStartTime());
                } else {
                    ConnectableSession.this.log("Cannot start scan. LocationService is off.");
                    ConnectableSession.this.maxRetries = 0;
                    ConnectableSession.this.stop(FailureCode.LOCATION_SERVICE_DISABLED);
                }
            }
            return true;
        }

        private boolean isFound(ShineDevice shineDevice) {
            String serialNumber = shineDevice.getSerialNumber();
            if (TextUtils.isEmpty(serialNumber)) {
                serialNumber = DeviceUtils.getInstance(ConnectableSession.this.context).getSerial(ConnectableSession.this.context, shineDevice.getAddress());
            }
            return (!TextUtils.isEmpty(ConnectableSession.this.serial) && ConnectableSession.this.serial.equalsIgnoreCase(serialNumber)) || shineDevice.getAddress().equalsIgnoreCase(ConnectableSession.this.bleAdapter.getMacAddress());
        }

        public void onExit() {
            stopTimeout();
            ConnectableSession.this.bleAdapter.stopScanning();
        }

        protected void onFatal(int i) {
            super.onFatal(i);
            ConnectableSession.this.maxRetries = 0;
            stopTimeout();
            ConnectableSession.this.bleAdapter.stopScanning();
            ConnectableSession.this.stop(i);
        }

        protected void onTimeout() {
            ConnectableSession.this.log("The scanning timeout.");
            ConnectableSession.this.log("Not found device.");
            onFatal(FailureCode.getFailureCodeNoDeviceFound(ConnectableSession.this.context, FailureCode.DEVICE_NOT_FOUND));
        }

        protected BleState stateAfterFoundDevice(int i) {
            if (i == 0) {
                return ConnectableSession.this.createConcreteState(SessionState.CONNECTING_STATE);
            }
            BleState createConcreteState = ConnectableSession.this.createConcreteState(SessionState.WORKAROUND_HID_CONNECTING_STATE);
            ((WorkaroundHIDConnectingState) createConcreteState).setIsScannedDevice(i == 2);
            return createConcreteState;
        }
    }

    public class WorkaroundHIDConnectingState extends BleState {
        protected boolean isScannedDevice = false;

        public void setIsScannedDevice(boolean z) {
            this.isScannedDevice = z;
        }

        public WorkaroundHIDConnectingState() {
            super(ConnectableSession.this.TAG);
            ConnectableSession.this.log("Start check is HID state CONNECTING, serial=" + ConnectableSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            int hidState = ConnectableSession.this.bleAdapter.getHidState();
            if (hidState == 1 || hidState == 3) {
                startTimeout();
                ConnectableSession.this.bleAdapter.hidDisconnect();
            } else {
                ConnectableSession.this.log("HID state: " + hidState + ", we could move to connect state.");
                ConnectableSession.this.enterStateWithDelayTime(stateAfterDone(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            }
            return true;
        }

        public int getTimeout() {
            return 5000;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            ConnectableSession.this.enterStateWithDelayTime(stateAfterDone(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            ConnectableSession.this.log("WorkaroundHIDConnectingState timeout.");
            ConnectableSession.this.enterState(stateAfterDone());
        }

        protected BleState stateAfterDone() {
            ConnectingState connectingState = (ConnectingState) ConnectableSession.this.createConcreteState(SessionState.CONNECTING_STATE);
            connectingState.setIsScannedDevice(this.isScannedDevice);
            return connectingState;
        }
    }

    public abstract BleState getStateAfterConnected();

    protected ConnectableSession(SessionType sessionType, CommunicateMode communicateMode, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(sessionType, communicateMode, bleAdapter, bleSessionCallback);
        this.sdkCallback = sdkCallback;
        this.serial = bleAdapter.getSerial();
        this.context = bleAdapter.getContext();
    }

    public void initStateMap() {
        this.sessionStateMap.put(SessionState.PRE_RETRY_STATE, PreRetryState.class.getName());
        this.sessionStateMap.put(SessionState.HID_DISCONNECT_STATE, DisconnectHIDState.class.getName());
        this.sessionStateMap.put(SessionState.SCANNING_FIRST_STEP_STATE, ScanningFirstStepState.class.getName());
        this.sessionStateMap.put(SessionState.WORKAROUND_HID_CONNECTING_STATE, WorkaroundHIDConnectingState.class.getName());
        this.sessionStateMap.put(SessionState.CONNECTING_STATE, ConnectingState.class.getName());
        this.sessionStateMap.put(SessionState.PREPARE_STATE, PrepareState.class.getName());
        this.sessionStateMap.put(SessionState.CLOSE_CONNECTION_WHEN_CONNECT_TIMEOUT, CloseConnectionWhenTimeoutState.class.getName());
    }

    protected boolean containConnectState() {
        return true;
    }

    public boolean onStart(Object... objArr) {
        this.sessionParams = objArr;
        if (this.bleAdapter.isDeviceReady()) {
            addDataCollectionTagToSdk();
            log("Device is ready");
            this.sdkCallback.onConnectionStateChanged(this.bleAdapter.getShineProfile(), State.CONNECTED, new ConnectActionResult(-1000, ConnectionResult.SUCCEEDED, null));
            enterState(getStateAfterConnected());
        } else if (this.bleAdapter.getGattState() == 2) {
            log("Device is connected");
            enterState(createConcreteState(SessionState.PREPARE_STATE));
        } else {
            log("Device is disconnected");
            enterState(createConcreteState(SessionState.SCANNING_FIRST_STEP_STATE));
        }
        return true;
    }

    protected void onRetry(Object... objArr) {
        enterState(createConcreteState(SessionState.PRE_RETRY_STATE));
    }

    public int getMaxRetries() {
        return this.maxRetries;
    }

    protected BleState getFirstState() {
        return createConcreteState(SessionState.SCANNING_FIRST_STEP_STATE);
    }
}
