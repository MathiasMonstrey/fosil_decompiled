package com.misfit.frameworks.buttonservice.communite.ble;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.misfit.ble.parser.SyncSessionBuilder;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.shine.ShineConfiguration;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.controller.ConfigurationSession;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Reason;
import com.misfit.ble.shine.sync.ActivityType;
import com.misfit.ble.shine.sync.result.MinuteData;
import com.misfit.ble.shine.sync.result.SessionTimestamp;
import com.misfit.ble.shine.sync.result.SleepData;
import com.misfit.ble.shine.sync.result.SleepSession;
import com.misfit.ble.shine.sync.result.SleepStateChange;
import com.misfit.ble.shine.sync.result.TapEventSummary;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetAlarmBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMultipleAlarmsBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.StopStreamingBaseState;
import com.misfit.frameworks.buttonservice.db.DataCollectorHelper;
import com.misfit.frameworks.buttonservice.db.DataFile;
import com.misfit.frameworks.buttonservice.db.DataFileProvider;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.log.MFLog;
import com.misfit.frameworks.buttonservice.log.MFLogManager;
import com.misfit.frameworks.buttonservice.log.MFSyncLog;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.WrapperSyncResult;
import com.misfit.frameworks.buttonservice.utils.BluetoothUtils;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.buttonservice.utils.LocationUtils;
import com.misfit.frameworks.buttonservice.utils.MetricAlgorithmUtil;
import com.misfit.frameworks.buttonservice.utils.SettingsUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public abstract class SyncSession extends ConnectableSession {
    private static final long IGNORE_VALUE = -1;
    protected HashMap<String, byte[]> activityFiles = new HashMap();
    protected AlarmSettings alarmSettings;
    protected boolean isNewDevice;
    protected List<MultipleAlarmSettings> multipleAlarmSettingsList;
    protected long realTimeSteps;
    protected String secondTimezoneId;
    protected int secondTimezoneOffset;
    protected long stepGoal;
    protected MFSyncLog syncLog;
    protected int syncMode;
    protected com.misfit.ble.parser.SyncSession syncResult = null;
    protected long syncTime = (System.currentTimeMillis() / 1000);
    protected UserProfile userProfile;
    protected short vibrationLevel;

    public class GetDeviceConfigurationState extends BleState {
        public GetDeviceConfigurationState() {
            super(SyncSession.this.TAG);
            SyncSession.this.log("Get configuration of device with serial " + SyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SyncSession.this.bleAdapter.getDeviceConfiguration(SyncSession.this.device)) {
                return true;
            }
            stopTimeout();
            SyncSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            BleState nextState = getNextState();
            if (nextState != null) {
                SyncSession.this.enterStateWithDelayTime(nextState, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            }
            return false;
        }

        public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
            stopTimeout();
            if (z) {
                storeValue(hashtable);
                logConfiguration(hashtable);
            } else {
                SyncSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            }
            SyncSession.this.enterState(getNextState());
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            SyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        protected void onTimeout() {
            SyncSession.this.log("Get config params timeout.");
            SyncSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            SyncSession.this.enterState(getNextState());
        }

        protected BleState getNextState() {
            return SyncSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE);
        }

        protected void storeValue(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ShineConfiguration shineConfiguration;
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                } else {
                    shineConfiguration = null;
                }
                if (shineConfiguration != null) {
                    SyncSession.this.setVibrationLevel(shineConfiguration.mVibeStrength);
                    SyncSession.this.stepGoal = Math.max(shineConfiguration.mGoalInSteps, SyncSession.this.stepGoal);
                    SyncSession.this.realTimeSteps = Math.max(shineConfiguration.mCurrentSteps, SyncSession.this.realTimeSteps);
                    return;
                }
                MFLogger.d(SyncSession.this.TAG, "Inside " + SyncSession.this.TAG + ", storeValue failed, shineConfiguration is null");
            }
        }

        protected void logConfiguration(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                ShineConfiguration shineConfiguration = null;
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                }
                if (shineConfiguration != null) {
                    int i = (int) configurationSession.mTimestamp;
                    byte b = shineConfiguration.mActivityTaggingState;
                    short s = shineConfiguration.mBatteryLevel;
                    short s2 = configurationSession.mTimeZoneOffset;
                    long j = shineConfiguration.mActivityPoint;
                    short s3 = shineConfiguration.mVibeStrength;
                    long j2 = shineConfiguration.mGoalInSteps;
                    long j3 = shineConfiguration.mCurrentSteps;
                    SyncSession.this.log(String.format("Get configuration  " + SyncSession.this.serial + "\n\t[timeConfiguration: \n\t{milliseconds = %d;\n\ttimeZoneOffsetInMinutes = %d;\n\ttimestamp = %d;}, \n\tgoalValue: %d, \n\tactivityTaggingState: %d, \n\tactivityPoint: %d, \n\tbatteryLevel: %d, \n\tvibrationStrength: %d\trealTimeSteps: %d\t]", new Object[]{Integer.valueOf(configurationSession.mPartialSecond), Integer.valueOf(s2), Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(b), Long.valueOf(j), Integer.valueOf(s), Short.valueOf(s3), Long.valueOf(j3)}));
                    if (SyncSession.this.syncLog != null) {
                        SyncSession.this.syncLog.setActivityPoint(j);
                        SyncSession.this.syncLog.setTimezone(s2);
                        SyncSession.this.syncLog.setBattery(s);
                        SyncSession.this.syncLog.setActivityTaggingState(b);
                        SyncSession.this.syncLog.setWatchTimestamp(i);
                        SyncSession.this.syncLog.setPhoneTimestamp((int) (Calendar.getInstance().getTimeInMillis() / 1000));
                    }
                }
            }
        }
    }

    public class GetDeviceConfigurationAfterSyncState extends GetDeviceConfigurationState {
        public GetDeviceConfigurationAfterSyncState() {
            super();
        }

        protected BleState getNextState() {
            return SyncSession.this.createConcreteState(SessionState.SET_ALARM_IF_FULL_SYNC_STATE);
        }
    }

    public class InterruptPendingActionState extends BleState {
        public InterruptPendingActionState() {
            super(SyncSession.this.TAG);
            SyncSession.this.log("Interrupt pending action of device with serial " + SyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SyncSession.this.bleAdapter.interrupt()) {
                return true;
            }
            stopTimeout();
            SyncSession.this.enterStateWithDelayTime(SyncSession.this.createConcreteState(SessionState.GET_DEVICE_CONFIGURATION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            boolean hasPendingAction = SyncSession.this.bleAdapter.hasPendingAction();
            SyncSession.this.log("Interrupt timeout - Has pending action=" + hasPendingAction);
            if (hasPendingAction) {
                SyncSession.this.bleAdapter.closeConnection(!SyncSession.this.canRetry(SyncSession.this.maxRetries, FailureCode.UNEXPECTED_DISCONNECT));
                return;
            }
            SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.GET_DEVICE_CONFIGURATION_STATE));
        }

        public int getTimeout() {
            return 3000;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            SyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class PlaySyncAnimation extends BleState {
        public PlaySyncAnimation() {
            super(SyncSession.this.TAG);
            SyncSession.this.log("Play sync animation device with serial " + SyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SyncSession.this.bleAdapter.playSyncAnimation()) {
                return true;
            }
            stopTimeout();
            SyncSession.this.addFailureCode(201);
            SyncSession.this.enterStateWithDelayTime(SyncSession.this.createConcreteState(SessionState.READ_DATA_FILE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            SyncSession.this.log("Play sync animation timeout");
            SyncSession.this.addFailureCode(201);
            SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.READ_DATA_FILE_STATE));
        }

        public boolean handleOnPlaySyncAnimationCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                SyncSession.this.addFailureCode(201);
            }
            SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.READ_DATA_FILE_STATE));
            return true;
        }

        public boolean handleOnPlayAnimationCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                SyncSession.this.addFailureCode(201);
            }
            SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.READ_DATA_FILE_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            SyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class ProcessAndStoreDataState extends BleState {
        public ProcessAndStoreDataState() {
            super(SyncSession.this.TAG);
            SyncSession.this.log("Process and store data of device with serial " + SyncSession.this.serial);
        }

        public boolean onEnter() {
            startTimeout();
            SyncSession.this.bleSessionCallback.onReceivedSyncData(bundleData());
            return true;
        }

        private Bundle bundleData() {
            List arrayList = new ArrayList();
            if (SyncSession.this.activityFiles != null) {
                arrayList.addAll(SyncSession.this.activityFiles.keySet());
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            arrayList.add(valueOf);
            DataCollectorHelper.saveDataFile(SyncSession.this.bleAdapter.getContext(), new DataFile(valueOf, WrapperSyncResult.cloneFrom(SyncSession.this.syncResult, SyncSession.this.userProfile, arrayList, SyncSession.this.realTimeSteps, SyncSession.this.vibrationLevel).toJson(), SyncSession.this.bleAdapter.getSerial(), System.currentTimeMillis()));
            Bundle bundle = new Bundle();
            bundle.putString(Constants.SYNC_RESULT, valueOf);
            if (SyncSession.this.syncResult != null) {
                SyncSession.this.syncResult.clearSession();
            }
            return bundle;
        }

        public void updateCurrentStepsAndStepGoal(boolean z, long j, long j2) {
            long j3 = -1;
            SyncSession.this.log("Set percentage goal progress session " + SyncSession.this.serial + ", currentSteps=" + j + ", stepGoal=" + j2 + " (Ready)");
            stopTimeout();
            SyncSession syncSession = SyncSession.this;
            if (z) {
                j = -1;
            }
            syncSession.realTimeSteps = j;
            syncSession = SyncSession.this;
            if (!z) {
                j3 = j2;
            }
            syncSession.stepGoal = j3;
            SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.READ_HARDWARE_LOG_STATE));
        }

        protected void onTimeout() {
            super.onTimeout();
            SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.READ_HARDWARE_LOG_STATE));
        }

        public int getTimeout() {
            return 300000;
        }
    }

    public class ReadDataFileState extends BleState {
        public ReadDataFileState() {
            super(SyncSession.this.TAG);
            SyncSession.this.log("Read data file of device with serial " + SyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (!SyncSession.this.isNewDevice) {
                SyncSession.this.log(String.format("Syncing with %s, user profile: age(%s), height(%s), weight(%s)", new Object[]{SyncSession.this.serial, Long.valueOf(SyncSession.this.userProfile.age), Float.valueOf(SyncSession.this.userProfile.height), Float.valueOf(SyncSession.this.userProfile.weight)}));
                if (!SyncSession.this.bleAdapter.readFiles(true)) {
                    stopTimeout();
                    SyncSession.this.stop(FailureCode.FAILED_TO_SYNC);
                    return false;
                }
            } else if (!SyncSession.this.bleAdapter.eraseFiles(true)) {
                stopTimeout();
                SyncSession.this.stop(FailureCode.FAILED_TO_SYNC);
                return false;
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            SyncSession.this.log("Read data file timeout");
            SyncSession.this.stop(FailureCode.FAILED_TO_SYNC);
        }

        public boolean handleOnDataReadProgressUpdate(int i, byte[] bArr) {
            startTimeout();
            String str = "SYNC PROGRESS: " + String.format(Locale.US, "%d", new Object[]{Integer.valueOf(i)}) + "%";
            SyncSession.this.log("Read data file " + SyncSession.this.serial + " progress: " + String.format(Locale.US, "%d", new Object[]{Integer.valueOf(i)}) + "%");
            MFLogger.d(SyncSession.this.TAG, str);
            str = SyncSession.this.saveDataFile(bArr, SyncSession.this.syncTime);
            if (str != null) {
                SyncSession.this.activityFiles.put(str, bArr);
            }
            return true;
        }

        public boolean handleOnDataReadCompleted(boolean z) {
            stopTimeout();
            if (z) {
                SyncSession.this.buildSyncResult(SyncSession.this.activityFiles, SyncSession.this.syncTime);
                SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.PROCESS_AND_STORE_DATA_STATE));
            } else {
                SyncSession.this.stop(FailureCode.FAILED_TO_SYNC);
            }
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            SyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class ReadHardwareLogState extends BleState {
        public ReadHardwareLogState() {
            super(SyncSession.this.TAG);
            SyncSession.this.log("Read hardware log of device with serial " + SyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SyncSession.this.bleAdapter.readHardwareLog(true)) {
                return true;
            }
            stopTimeout();
            SyncSession.this.enterStateWithDelayTime(SyncSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            SyncSession.this.log("Read hardware log timeout");
            SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE));
        }

        public boolean handleOnHardwareLogRead(boolean z, byte[] bArr) {
            stopTimeout();
            SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            SyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class SetAlarmIfFullSyncState extends SetAlarmBaseState {
        public SetAlarmIfFullSyncState() {
            super(SyncSession.this.alarmSettings, SyncSession.this.bleAdapter, SyncSession.this);
            SyncSession.this.log("Set alarm to device with serial " + SyncSession.this.serial);
        }

        public boolean onEnter() {
            boolean isFullSync = SyncSession.this.isFullSync();
            boolean z = SyncSession.this.device != null && SyncSession.this.device.isSupportDeviceState(CommunicateMode.SET_ALARM);
            boolean isNeedToSetSetting = DevicePreferenceUtils.isNeedToSetSetting(SyncSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
            if ((isFullSync || isNeedToSetSetting) && z) {
                return super.onEnter();
            }
            if (z) {
                SyncSession.this.log("This is not full-sync and single alarm has been set. Skip.");
            } else {
                SyncSession.this.log("Single alarm function is not supported");
                DevicePreferenceUtils.removeSettingFlag(SyncSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
            }
            SyncSession.this.enterStateWithDelayTime(SyncSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_IF_FULL_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(SyncSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
            } else {
                SyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            }
            return SyncSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_IF_FULL_SYNC_STATE);
        }

        protected BleState getStateOnTimeOut() {
            SyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            return SyncSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_IF_FULL_SYNC_STATE);
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            SyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class SetConnectionParamsState extends BleState {
        public SetConnectionParamsState() {
            super(SyncSession.this.TAG);
            SyncSession.this.log("Set connection params to device with serial " + SyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SyncSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            SyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            SyncSession.this.enterStateWithDelayTime(SyncSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            SyncSession.this.log("Set connection params timeout.");
            SyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            SyncSession.this.enterStateWithDelayTime(SyncSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            stopTimeout();
            if (!z) {
                if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                    SyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                } else {
                    SyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
                }
            }
            SyncSession.this.enterState(SyncSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            SyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class SetDeviceConfigurationState extends BleState {
        private ShineConfiguration configuration;
        private boolean countDownSupport;
        private CountdownSettings countdownSettings;
        private boolean isNeedToSetCountDown;
        private boolean isNeedToSetSecondTimeZone;
        private boolean secondTimeZoneSupport;
        final /* synthetic */ SyncSession this$0;

        public SetDeviceConfigurationState(SyncSession syncSession) {
            boolean z = false;
            this.this$0 = syncSession;
            super(syncSession.TAG);
            if (DevicePreferenceUtils.getCurrentSecondTimezoneOffset(syncSession.context) != syncSession.secondTimezoneOffset) {
                DevicePreferenceUtils.setSettingFlag(syncSession.context, DeviceSettings.SECOND_TIMEZONE);
            }
            boolean z2 = syncSession.device != null && syncSession.device.isSupportDeviceState(CommunicateMode.SET_SECOND_TIMEZONE);
            this.secondTimeZoneSupport = z2;
            this.countDownSupport = SettingsUtils.isSupportCountDown(syncSession.bleAdapter.getSerial());
            this.countdownSettings = DevicePreferenceUtils.getAutoCountDownSetting(syncSession.bleAdapter.getContext());
            if (syncSession.isFullSync() || DevicePreferenceUtils.isNeedToSetSetting(syncSession.bleAdapter.getContext(), DeviceSettings.COUNT_DOWN)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.isNeedToSetCountDown = z2;
            if (syncSession.isFullSync() || DevicePreferenceUtils.isNeedToSetSetting(syncSession.bleAdapter.getContext(), DeviceSettings.SECOND_TIMEZONE)) {
                z = true;
            }
            this.isNeedToSetSecondTimeZone = z;
            this.configuration = prepareData();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Set device configuration and time " + syncSession.serial + "\n");
            JSONObject toJSON = this.configuration.toJSON();
            stringBuilder.append("\tConfiguration: " + (toJSON != null ? toJSON.toString() : "null") + ", \n");
            syncSession.log(stringBuilder.toString());
        }

        private ShineConfiguration prepareData() {
            ShineConfiguration shineConfiguration = new ShineConfiguration();
            if (this.this$0.stepGoal != -1) {
                shineConfiguration.mGoalInSteps = this.this$0.stepGoal;
            }
            if (this.this$0.isNewDevice) {
                shineConfiguration.mCurrentSteps = 0;
            }
            if (this.this$0.realTimeSteps != -1) {
                shineConfiguration.mCurrentSteps = this.this$0.realTimeSteps;
            }
            if (this.secondTimeZoneSupport && this.isNeedToSetSecondTimeZone) {
                shineConfiguration.mTimezoneOffset = (short) this.this$0.secondTimezoneOffset;
            }
            if (this.countDownSupport && this.isNeedToSetCountDown) {
                if (this.countdownSettings == null) {
                    this.countdownSettings = this.this$0.bleAdapter.getDisableCountDownSetting();
                }
                shineConfiguration.mCountdownSettings = this.countdownSettings;
            }
            return shineConfiguration;
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (this.this$0.bleAdapter.setDeviceConfiguration(this.configuration)) {
                return true;
            }
            stopTimeout();
            this.this$0.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            this.this$0.enterStateWithDelayTime(this.this$0.createConcreteState(SessionState.GET_DEVICE_CONFIGURATION_AFTER_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            this.this$0.log("Set device configuration timeout");
            this.this$0.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            this.this$0.enterState(this.this$0.createConcreteState(SessionState.GET_DEVICE_CONFIGURATION_AFTER_SYNC_STATE));
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                this.this$0.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            }
            this.this$0.enterState(this.this$0.createConcreteState(SessionState.GET_DEVICE_CONFIGURATION_AFTER_SYNC_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            this.this$0.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class SetMultipleAlarmsIfFullSyncState extends SetMultipleAlarmsBaseState {
        public SetMultipleAlarmsIfFullSyncState() {
            super(SyncSession.this.multipleAlarmSettingsList, SyncSession.this.bleAdapter, SyncSession.this);
            SyncSession.this.log("Set multiple alarms to device with serial " + SyncSession.this.serial);
        }

        public boolean onEnter() {
            boolean isFullSync = SyncSession.this.isFullSync();
            boolean z = SyncSession.this.device != null && SyncSession.this.device.isSupportDeviceState(CommunicateMode.SET_LIST_ALARM);
            boolean isNeedToSetSetting = DevicePreferenceUtils.isNeedToSetSetting(SyncSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
            if ((isFullSync || isNeedToSetSetting) && z) {
                return super.onEnter();
            }
            if (z) {
                SyncSession.this.log("This is not full-sync or multi alarm has been set. Skip.");
            } else {
                SyncSession.this.log("Multi alarm function is not supported");
                DevicePreferenceUtils.removeSettingFlag(SyncSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
            }
            SyncSession.this.enterStateWithDelayTime(SyncSession.this.getStateAfterSetMultipleAlarm(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(SyncSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
            } else {
                SyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            }
            return SyncSession.this.getStateAfterSetMultipleAlarm();
        }

        protected BleState getStateOnTimeOut() {
            SyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            return SyncSession.this.getStateAfterSetMultipleAlarm();
        }
    }

    public class StopStreamingState extends StopStreamingBaseState {
        public StopStreamingState() {
            super(SyncSession.this.bleAdapter, SyncSession.this);
            SyncSession.this.log("Stop streaming to device with serial " + SyncSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (!z) {
                SyncSession.this.addFailureCode(FailureCode.FAILED_TO_STOP_STREAMING);
            }
            return SyncSession.this.createConcreteState(SessionState.PLAY_SYNC_ANIMATION_STATE);
        }

        protected BleState getStateOnTimeOut() {
            SyncSession.this.addFailureCode(FailureCode.FAILED_TO_STOP_STREAMING);
            return SyncSession.this.createConcreteState(SessionState.PLAY_SYNC_ANIMATION_STATE);
        }

        protected boolean isSkipStopStreaming() {
            return SyncSession.this.bleAdapter.isSupportedFeature(ShineFeature.ASYNCHRONOUS_DATA_STREAMING);
        }
    }

    public abstract BleState getStateAfterSetMultipleAlarm();

    public int getSyncMode() {
        return this.syncMode;
    }

    public SyncSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback, UserProfile userProfile) {
        super(SessionType.SYNC, CommunicateMode.SYNC, bleAdapter, bleSessionCallback, sdkCallback);
        this.sdkCallback = sdkCallback;
        this.userProfile = userProfile;
        this.isNewDevice = userProfile.isNewDevice;
        this.syncMode = userProfile.syncMode;
        this.realTimeSteps = (long) userProfile.currentSteps;
    }

    protected boolean onStart(Object... objArr) {
        if (getRetriesCounter() == 0) {
            this.syncLog = MFLogManager.getInstance(this.bleAdapter.getContext()).startSyncLog(this.serial);
            this.mfLog = this.syncLog;
            if (this.syncLog != null) {
                this.syncLog.setSerial(this.serial);
                this.syncLog.setFirmwareVersion(this.bleAdapter.getFirmwareVersion());
                this.syncLog.setSyncMode(this.syncMode);
            }
        }
        initSettings();
        MFLogger.i(this.TAG, "START SYNCING SESSION - isNewDevice=" + this.isNewDevice + ", syncMode=" + this.syncMode + ", bluetoothOn=" + BluetoothUtils.isBluetoothEnable() + ", locationServiceEnabled=" + LocationUtils.isLocationEnable(this.context) + ", locationPermissionAllowed=" + LocationUtils.isLocationPermissionGranted(this.context));
        log("Start new sync session: newDevice=" + this.isNewDevice + ", syncMode=" + this.userProfile.syncMode + ", bluetoothOn=" + BluetoothUtils.isBluetoothEnable() + ", locationServiceEnabled=" + LocationUtils.isLocationEnable(this.context) + ", locationPermissionAllowed=" + LocationUtils.isLocationPermissionGranted(this.context));
        return super.onStart(objArr);
    }

    public void initSettings() {
        this.alarmSettings = DevicePreferenceUtils.getAutoAlarmSetting(this.context);
        this.multipleAlarmSettingsList = DevicePreferenceUtils.getAutoListAlarm(this.context);
        this.secondTimezoneOffset = DevicePreferenceUtils.getAutoSecondTimezone(this.context);
        this.secondTimezoneId = DevicePreferenceUtils.getAutoSecondTimezoneId(this.context);
    }

    protected boolean canRetry(int i, int i2) {
        if (i >= getMaxRetries()) {
            return false;
        }
        if (this.syncLog != null) {
            this.syncLog.setRetries(i);
        }
        return true;
    }

    public void setVibrationLevel(short s) {
        this.vibrationLevel = s;
    }

    public void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.INTERRUPT_PENDING_ACTION_STATE, InterruptPendingActionState.class.getName());
        this.sessionStateMap.put(SessionState.GET_DEVICE_CONFIGURATION_STATE, GetDeviceConfigurationState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAMS_STATE, SetConnectionParamsState.class.getName());
        this.sessionStateMap.put(SessionState.STOP_STREAMING_STATE, StopStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PLAY_SYNC_ANIMATION_STATE, PlaySyncAnimation.class.getName());
        this.sessionStateMap.put(SessionState.READ_DATA_FILE_STATE, ReadDataFileState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_AND_STORE_DATA_STATE, ProcessAndStoreDataState.class.getName());
        this.sessionStateMap.put(SessionState.READ_HARDWARE_LOG_STATE, ReadHardwareLogState.class.getName());
        this.sessionStateMap.put(SessionState.SET_DEVICE_CONFIGURATION_STATE, SetDeviceConfigurationState.class.getName());
        this.sessionStateMap.put(SessionState.GET_DEVICE_CONFIGURATION_AFTER_SYNC_STATE, GetDeviceConfigurationAfterSyncState.class.getName());
        this.sessionStateMap.put(SessionState.SET_ALARM_IF_FULL_SYNC_STATE, SetAlarmIfFullSyncState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MULTIPLE_ALARMS_IF_FULL_SYNC_STATE, SetMultipleAlarmsIfFullSyncState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.INTERRUPT_PENDING_ACTION_STATE);
    }

    protected void onStop(int i) {
        super.onStop(i);
    }

    protected void buildExtraInfoReturned() {
        MFLog end = MFLogManager.getInstance(this.bleAdapter.getContext()).end(CommunicateMode.SYNC, this.serial);
        this.extraInfoReturned.putInt(ButtonService.LOG_ID, end != null ? end.getStartTimeEpoch() : 0);
        this.extraInfoReturned.putLong(Constants.SYNC_ID, this.userProfile.syncId);
        this.extraInfoReturned.putInt(ButtonService.SYNC_MODE, this.userProfile.syncMode);
        this.extraInfoReturned.putParcelable(Constants.DEVICE, MisfitDeviceProfile.cloneFrom(this.bleAdapter));
        if (this.syncResult != null) {
            this.syncResult.clearSession();
        }
    }

    protected boolean hasActivityFile() {
        return !this.activityFiles.isEmpty();
    }

    protected String formatByteToHex(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            formatter.format("%02X", new Object[]{Byte.valueOf(bArr[i])});
        }
        return formatter.toString();
    }

    protected String saveDataFile(byte[] bArr, long j) {
        String str = null;
        MFLogger.d(this.TAG, "Inside " + this.TAG + ".saveDataFile");
        if (bArr == null || bArr.length < 6) {
            MFLogger.e(this.TAG, "Inside " + this.TAG + ".saveDataFile - Invalid data file");
            log("Saving data file: INVALID DATA FILE");
        } else {
            try {
                String formatByteToHex = formatByteToHex(Arrays.copyOf(bArr, 2));
                String formatByteToHex2 = formatByteToHex(Arrays.copyOfRange(bArr, bArr.length - 4, bArr.length));
                String encodeToString = Base64.encodeToString(bArr, 0);
                str = formatByteToHex + formatByteToHex2;
                log("Saving fileCrc: " + formatByteToHex2);
                MFLogger.d(this.TAG, "Inside " + this.TAG + ".saveDataFile - fileHandler=" + formatByteToHex + ", fileCrc=" + formatByteToHex2 + ", fileContent=" + formatByteToHex(bArr));
                DataCollectorHelper.saveDataFile(this.bleAdapter.getContext(), new DataFile(str, encodeToString, this.bleAdapter.getSerial(), j));
            } catch (Exception e) {
                MFLogger.e(this.TAG, "Error inside " + this.TAG + ".saveDataFile - e=" + e);
            }
        }
        return str;
    }

    protected void buildSyncResult(HashMap<String, byte[]> hashMap, long j) {
        int size;
        com.misfit.ble.shine.sync.UserProfile userProfile = new com.misfit.ble.shine.sync.UserProfile(this.userProfile.age, this.userProfile.height, this.userProfile.weight, this.userProfile.gender);
        StringBuilder stringBuilder = new StringBuilder();
        if (this.activityFiles != null) {
            size = this.activityFiles.size();
        } else {
            size = 0;
        }
        List<DataFile> allDataFiles = DataFileProvider.getInstance(this.bleAdapter.getContext()).getAllDataFiles(j);
        stringBuilder.append("\nnumberOfFiles: " + size);
        List arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList(hashMap.values());
        for (DataFile dataFile : allDataFiles) {
            try {
                Object decode = Base64.decode(dataFile.getDataFile(), 0);
                if (hashMap.containsKey(dataFile.getKey())) {
                    MFLogger.i(this.TAG, "Cached file - key=" + dataFile.getKey() + " already existed");
                    arrayList2.remove(decode);
                } else {
                    MFLogger.d(this.TAG, "Adding cached file - key=" + dataFile.getKey() + ", syncTime=" + dataFile.getSyncTime() + " to list");
                    arrayList.add(decode);
                    hashMap.put(dataFile.getKey(), decode);
                }
            } catch (Exception e) {
                MFLogger.e(this.TAG, "Error inside " + this.TAG + ".buildSyncResult - e=" + e + ", fileId=" + dataFile.getKey());
            }
        }
        arrayList.addAll(arrayList2);
        log(String.format("Sync data: new %s file(s), cached %s file(s). Total %s file(s) to process", new Object[]{Integer.valueOf(size), Integer.valueOf(allDataFiles.size()), Integer.valueOf(arrayList.size())}));
        if (!arrayList.isEmpty()) {
            try {
                this.syncResult = SyncSessionBuilder.buildSyncSession(arrayList, userProfile, ActivityType.UNKNOWN_TYPE.getId(), this.bleAdapter.getDeviceFamily(), j);
            } catch (IllegalStateException e2) {
                log("Data exception: " + e2.getMessage());
                int size2 = arrayList.size();
                for (size = 0; size < size2; size++) {
                    log("data[" + size + "]: " + Base64.encodeToString((byte[]) arrayList.get(size), 0));
                }
                this.syncResult = null;
            }
        }
        if (this.syncResult != null) {
            float f;
            log("Calculating sleep session...");
            SleepData sleepData = this.syncResult.getSleepData(null, null, null, new SessionTimestamp(), null);
            if (sleepData != null) {
                stringBuilder.append("\nnumberOfSleepSession: " + (sleepData.sleepSessions != null ? String.valueOf(sleepData.sleepSessions.size()) : AppEventsConstants.EVENT_PARAM_VALUE_NO));
                log(String.format("Done calculating sleep: total %s sleep session(s)", new Object[]{r2}));
            }
            List<MinuteData> minuteData = this.syncResult.getMinuteData();
            float f2 = 0.0f;
            long j2 = 0;
            long j3 = 0;
            if (minuteData != null) {
                log("Calculating calories...");
                float calculateCalories = MetricAlgorithmUtil.calculateCalories(userProfile, (List) minuteData);
                log("Calculating distance...");
                float calculateDistance = MetricAlgorithmUtil.calculateDistance(userProfile, (List) minuteData);
                for (MinuteData minuteData2 : minuteData) {
                    long step;
                    j2 += minuteData2.getStep();
                    if (DateUtils.isToday(minuteData2.getStartTime() * 1000)) {
                        step = minuteData2.getStep() + j3;
                    } else {
                        step = j3;
                    }
                    j3 = step;
                }
                stringBuilder.append("\nnumberOfMinutes: " + minuteData.size());
                stringBuilder.append("\ntotalCalories: " + calculateCalories);
                stringBuilder.append("\ntotalDistance: " + calculateDistance);
                f2 = calculateDistance;
                f = calculateCalories;
            } else {
                f = 0.0f;
            }
            log(String.format("After calculation: steps=%s, todayStep=%s, realTimeSteps=%s, stepsInDb=%s. Calories=%s. Distance=%s. Taps=%s", new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.realTimeSteps), Integer.valueOf(this.userProfile.currentSteps), Float.valueOf(f), Float.valueOf(f2), buildTapEventString(this.syncResult.getTapEventSummaries())}));
            if (this.syncLog != null) {
                this.syncLog.setTodaySumMinuteDataStep(j3);
                this.syncLog.setRealTimeStep(this.realTimeSteps);
            }
            MFLogger.d(this.TAG, "Release=false");
            MFLogger.d(this.TAG, "onSyncCompleted - Sleep session details: " + (sleepData != null ? buildSleepSessionShineList(sleepData.sleepSessions) : ", no sleep data"));
            MFLogger.d(this.TAG, "onSyncCompleted - Minute data details: " + buildMinuteDataList(this.syncResult.getMinuteData()));
            MFLogger.d(this.TAG, "onSyncCompleted - Tap event details: " + buildTapEventString(this.syncResult.getTapEventSummaries()));
        }
    }

    protected String buildMinuteDataList(List<MinuteData> list) {
        if (list == null || list.isEmpty()) {
            return "null\n";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (MinuteData minuteData : list) {
            stringBuffer.append("[");
            stringBuffer.append("startTime:" + minuteData.getStartTime());
            stringBuffer.append(", step:" + minuteData.getStep());
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }

    protected String buildSleepSessionShineList(List<SleepSession> list) {
        if (list == null || list.isEmpty()) {
            return "null\n";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (SleepSession sleepSession : list) {
            stringBuffer.append(sleepSession.toString());
            stringBuffer.append("\n");
            stringBuffer.append("State: ");
            for (SleepStateChange sleepStateChange : sleepSession.getSleepStateChanges()) {
                stringBuffer.append(sleepStateChange.toString());
                stringBuffer.append(" -- ");
            }
            stringBuffer.append("\n");
        }
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    protected String buildTapEventString(List<TapEventSummary> list) {
        if (list == null || list.isEmpty()) {
            return "null\n";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (TapEventSummary tapEventSummary : list) {
            stringBuilder.append("[startTime:" + tapEventSummary.getStartTime() + ", doubleTaps:" + tapEventSummary.getDoubleTapCount() + ", tripleTaps:" + tapEventSummary.getTripleTapCount() + ", goalTrackingIds=" + (tapEventSummary.getGoalID() != null ? Arrays.toString(tapEventSummary.getGoalID()) : "null") + "]");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean isFullSync() {
        return this.syncMode == 13;
    }

    public boolean accept(BleSession bleSession) {
        if (bleSession.getCommunicateMode() != CommunicateMode.SYNC) {
            if (getCommunicateMode() != bleSession.getCommunicateMode()) {
                return true;
            }
            return false;
        } else if (((SyncSession) bleSession).getSyncMode() != 13) {
            return false;
        } else {
            return true;
        }
    }

    public void updateCurrentStepAndStepGoalFromApp(boolean z, long j, long j2) {
        BleState state = getState();
        MFLogger.d(this.TAG, "Inside " + this.TAG + ".updateCurrentStepAndStepGoalFromApp - currentState=" + state);
        if (state == null || !(state instanceof ProcessAndStoreDataState)) {
            MFLogger.d(this.TAG, "Inside " + this.TAG + ".updateCurrentStepAndStepGoalFromApp - cannot update current steps and step goal to device caused by current state null or not an instance of ProcessAndStoreDataState.");
        } else {
            ((ProcessAndStoreDataState) state).updateCurrentStepsAndStepGoal(z, j, j2);
        }
    }
}
