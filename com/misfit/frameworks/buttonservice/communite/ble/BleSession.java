package com.misfit.frameworks.buttonservice.communite.ble;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.fossil.euj;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.log.MFLog;
import com.misfit.frameworks.buttonservice.log.MFLogManager;
import com.misfit.frameworks.buttonservice.model.Device;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class BleSession {
    protected String TAG;
    protected BleAdapter bleAdapter;
    protected BleSessionCallback bleSessionCallback;
    private CommunicateMode communicateMode;
    protected Context context;
    private Handler delayHandler;
    private DelayTask delayTask;
    protected Device device;
    private int endTime;
    protected Bundle extraInfoReturned;
    private int failureCode;
    private List<Integer> failureCodes;
    private boolean isExist;
    private boolean isInterruptable;
    protected MFLog mfLog;
    private int retriesCounter;
    protected String serial;
    protected HashMap<SessionState, String> sessionStateMap;
    private SessionType sessionType;
    private Object[] startParams;
    private int startTime;
    private BleState state;

    public interface BleSessionCallback {
        void onBleStateResult(int i, Bundle bundle);

        void onReceivedSyncData(Bundle bundle);

        void onStop(int i, Bundle bundle, BleSession bleSession);
    }

    class C46962 implements Runnable {
        C46962() {
        }

        public void run() {
            BleSession.this.onRetry(new Object[0]);
        }
    }

    static /* synthetic */ class C46995 {
        static final /* synthetic */ int[] f1622xe21851be = new int[CommunicateMode.values().length];

        static {
            try {
                f1622xe21851be[CommunicateMode.ENTER_CALIBRATION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1622xe21851be[CommunicateMode.EXIT_CALIBRATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1622xe21851be[CommunicateMode.APPLY_HAND_POSITION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1622xe21851be[CommunicateMode.MOVE_HAND.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1622xe21851be[CommunicateMode.RESET_HAND.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1622xe21851be[CommunicateMode.LINK.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    final class DelayTask implements Runnable {
        private Runnable task;

        private DelayTask() {
        }

        public void setTask(Runnable runnable) {
            this.task = runnable;
        }

        public void run() {
            if (this.task != null) {
                this.task.run();
            }
        }
    }

    public enum SessionState {
        PRE_RETRY_STATE,
        HID_DISCONNECT_STATE,
        SCANNING_FIRST_STEP_STATE,
        SCANNING_SECOND_STEP_STATE,
        WORKAROUND_HID_CONNECTING_STATE,
        CONNECTING_STATE,
        PREPARE_STATE,
        CLOSE_CONNECTION_WHEN_CONNECT_TIMEOUT,
        GET_DEVICE_CONFIGURATION_STATE,
        START_STREAMING_STATE,
        HID_CONNECT_STATE,
        CHOOSE_STREAM_HID,
        DONE_CONNECT_DEVICE,
        INTERRUPT_PENDING_ACTION_STATE,
        SET_CONNECTION_PARAMS_STATE,
        STOP_STREAMING_STATE,
        PLAY_SYNC_ANIMATION_STATE,
        READ_DATA_FILE_STATE,
        PROCESS_AND_STORE_DATA_STATE,
        READ_HARDWARE_LOG_STATE,
        SET_DEVICE_CONFIGURATION_STATE,
        GET_DEVICE_CONFIGURATION_AFTER_SYNC_STATE,
        SET_ALARM_IF_FULL_SYNC_STATE,
        SET_MULTIPLE_ALARMS_IF_FULL_SYNC_STATE,
        SET_MICRO_APP_MAPPING_AFTER_SYNCING_STATE,
        SET_MAPPING_AFTER_SYNCING_STATE,
        SET_GOAL_TRACKING_STATE,
        START_STREAMING_AFTER_SYNCING_STATE,
        HID_CONNECT_AFTER_SYNCING_STATE,
        DONE_SYNC_STATE,
        CLOSE_CONNECTION_ON_OTA_FAILED_STATE,
        SENDING_FILE_STATE,
        CLOSE_CONNECTION_AFTER_OTA_STATE,
        REMOVE_BOND_AFTER_OTA_STATE,
        SCANNING_FIRST_STEP_AFTER_OTA_STATE,
        SCANNING_SECOND_STEP_AFTER_OTA_STATE,
        WORKAROUND_HID_CONNECTING_AFTER_OTA_STATE,
        CONNECTING_AFTER_OTA_STATE,
        PREPARE_AFTER_OTA_STATE,
        RETRY_ON_PREPARE_FAILED_AFTER_OTA_STATE,
        CONNECTING_AFTER_OTA_SECOND_CHANCE_STATE,
        PREPARE_AFTER_OTA_SECOND_CHANCE_STATE,
        PLAY_ANIMATION_AFTER_OTA_STATE,
        HID_CONNECT_AFTER_OTA_STATE,
        READ_FIRMWARE_VERSION_AFTER_OTA_STATE,
        GET_DEVICE_CONFIGURATION_AFTER_OTA_STATE,
        CLEAR_ALL_MAPPINGS_AFTER_OTA_STATE,
        SET_ALARM_AFTER_OTA_STATE,
        SET_MULTIPLE_ALARMS_AFTER_OTA_STATE,
        SET_SECOND_TIMEZONE_AFTER_OTA_STATE,
        CHOOSE_SET_LINK_MAPPING_STATE,
        SET_CONNECTION_PARAMS_AFTER_OTA_STATE,
        SET_MICRO_APP_MAPPING_AFTER_OTA_STATE,
        SET_MAPPING_AFTER_OTA_STATE,
        START_STREAMING_AFTER_OTA_STATE,
        SET_GOAL_TRACKING_AFTER_OTA_STATE,
        DONE_OTA_SESSION_STATE,
        PLAY_ANIMATION_STATE,
        ERASE_FILE_STATE,
        SET_ALARM_AFTER_PAIRING_STATE,
        SET_MULTIPLE_ALAMRS_AFTER_PAIRING_STATE,
        CLEAR_ALL_MAPPINGS_STATE,
        DISABLE_GOAL_TRACKING_STATE,
        SET_MAPPING_STATE,
        SET_MICRO_APP_MAPPING_STATE,
        DONE_PAIRING_NEW_DEVICE_SESSION_STATE,
        CHOOSE_DISABLE_LINK_MAPPINGS_STATE,
        DONE_CLEAN_LINK_MAPPING_STATE,
        GET_COUNT_DOWN_SETTING_STATE,
        GET_VIBRATION_STRENGTH_STATE,
        PLAY_LIGHT_AND_VIBRATION_STATE,
        PLAY_LIGHT_STATE,
        PLAY_VIBRATION_STATE,
        READ_REAL_TIME_STEP_STATE,
        READ_RSSI_STATE,
        SET_COUNT_DOWN_SETTING_STATE,
        CHOOSE_DISABLE_OLD_LINK_MAPPINGS_STATE,
        DISABLE_OLD_GOAL_TRACKING_STATE,
        DONE_STATE,
        CLEAR_MAPPING_DISCONNECT_HID,
        CLEAR_MAPPING_STOP_STREAMING,
        HID_CONNECT_OF_SET_MAPPING_SESSION_STATE,
        SET_MAPPING_START_STREAMING_STATE,
        SET_MAPPING_CONNECT_HID_STATE,
        DONE_SET_LINK_MAPPING_STATE,
        PROCESS_OLD_MAPPING,
        PROCESS_MAPPING,
        PROCESS_HID,
        PROCESS_STREAMING,
        DONE_SET_MICRO_APP_MAPPING_STATE,
        SET_MAPPING_ANIMATIONS_STATE,
        SET_STEP_GOAL_STATE,
        SET_VIBRATION_STRENGTH_STATE,
        START_STREAMING_SSS_STATE,
        DONE_START_STREAMING,
        CLOSE_CONNECTION_STATE,
        REMOVE_BOND_STATE,
        UPDATE_CURRENT_TIME_STATE,
        SET_MULTIPLE_ALARMS_STATE,
        SET_SECOND_TIMEZONE_STATE,
        SET_REAL_TIME_STEP_STATE,
        SET_GOAL_IN_STEP_STATE,
        START_STREAMING_AGAIN_STATE,
        DONE_SET_MULTIPLE_ALARMS_STATE,
        SET_SING_ALARM_STATE,
        PLAY_HAND_ANIMATION_STATE,
        GET_SECOND_TIMEZONE_STATE,
        GET_ALARM_STATE,
        CLEAR_ALARM_STATE,
        REQUEST_HAND_CONTROL_STATE,
        RESET_HAND_POSITION_STATE,
        SET_CONNECTION_PARAM_FOR_CALIBRATION,
        MOVE_HAND_STATE,
        APPLY_HANDS_POSITION_STATE,
        RELEASE_HAND_CONTROL_STATE,
        CLEAR_LAST_NOTIFICATION_STATE,
        CONNECT_WITHOUT_TIMEOUT,
        DONE_ANIMATION_STATE,
        GET_CURRENT_HAND_POSITION_STATE,
        DONE_MCA_MOVING_HAND_STATE,
        SET_STOP_WATCH_SETTING_STATE,
        SET_MICRO_APP_SETTING_STATE,
        SET_SETTING_DONE_STATE
    }

    public abstract void buildExtraInfoReturned();

    public abstract BleSession copyObject();

    public abstract void initStateMap();

    public abstract boolean onStart(Object... objArr);

    protected BleState createConcreteState(SessionState sessionState) {
        String str = (String) this.sessionStateMap.get(sessionState);
        try {
            MFLogger.d(this.TAG, "stateClassName = " + str);
            Class cls = Class.forName(str);
            MFLogger.d(this.TAG, "stateClassName = " + str + ", parentClass=" + cls.getDeclaringClass().getClass());
            return (BleState) cls.getDeclaredConstructor(new Class[]{r3}).newInstance(new Object[]{this});
        } catch (InstantiationException e) {
            MFLogger.e(this.TAG, "Inside getState method, cannot instance state, e = " + e);
            log(this.TAG + ", cannot create a instance state by InstantiationException");
            return null;
        } catch (IllegalAccessException e2) {
            MFLogger.e(this.TAG, "Inside getState method, cannot instance state, e = " + e2);
            log(this.TAG + ", cannot create a instance state by IllegalAccessException");
            return null;
        } catch (ClassNotFoundException e3) {
            MFLogger.e(this.TAG, "Inside getState method, cannot instance state, e = " + e3);
            log(this.TAG + ", cannot create a instance state by ClassNotFoundException");
            return null;
        } catch (NoSuchMethodException e4) {
            MFLogger.e(this.TAG, "Inside getState method, cannot instance state, e = " + e4);
            log(this.TAG + ", cannot create a instance state by NoSuchMethodException");
            return null;
        } catch (InvocationTargetException e5) {
            MFLogger.e(this.TAG, "Inside getState method, cannot instance state, e = " + e5);
            log(this.TAG + ", cannot create a instance state by InvocationTargetException");
            return null;
        }
    }

    protected BleSession(CommunicateMode communicateMode, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        this.TAG = BleSession.class.getSimpleName();
        this.isExist = true;
        this.sessionStateMap = new HashMap();
        this.extraInfoReturned = new Bundle();
        this.failureCodes = new ArrayList();
        this.delayTask = new DelayTask();
        this.sessionType = SessionType.BACK_GROUND;
        this.isExist = true;
        this.communicateMode = communicateMode;
        this.bleAdapter = bleAdapter;
        this.bleSessionCallback = bleSessionCallback;
        this.context = bleAdapter.getContext();
        this.serial = bleAdapter.getSerial();
        this.startTime = 0;
        this.endTime = 0;
        if (isNeedGetActiveLogForThisSession()) {
            this.mfLog = MFLogManager.getInstance(this.context).getActiveLog(this.serial);
        }
        if (this.mfLog != null) {
            this.mfLog.setSerial(this.serial);
            this.mfLog.setFirmwareVersion(bleAdapter.getFirmwareVersion());
        }
        this.TAG = getClass().getSimpleName();
        initStateMap();
    }

    protected BleSession(SessionType sessionType, CommunicateMode communicateMode, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        this(communicateMode, bleAdapter, bleSessionCallback);
        this.sessionType = sessionType;
    }

    protected void onStop(int i) {
        try {
            buildExtraInfoReturned();
        } catch (Exception e) {
            log(e.getMessage());
        }
    }

    protected void onPostStop(int i) {
        this.state = null;
        if (this.startTime == 0) {
            this.endTime = 0;
        }
        long j = (long) (this.endTime - this.startTime);
        String str = this.TAG;
        StringBuilder append = new StringBuilder().append("___ Stop ").append(this.TAG).append(": duration=");
        if (j <= 0) {
            j = 0;
        }
        MFLogger.d(str, append.append(euj.bm(j * 1000)).append(" ___").toString());
    }

    private final void startWithDelay(final Object[] objArr, int i) {
        enterTaskWithDelayTime(new Runnable() {
            public void run() {
                BleSession.this.start(objArr);
            }
        }, i);
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public final boolean start(Object... objArr) {
        setStartTime((int) (System.currentTimeMillis() / 1000));
        setStartParams(objArr);
        log("MODE: " + getCommunicateMode().name());
        log("START");
        removeDelayWork();
        return onStart(objArr);
    }

    public final void stop(int i) {
        boolean z = true;
        int lastFailureCode = getLastFailureCode();
        MFLogger.d(this.TAG, "Inside " + this.TAG + ".stop - failureCode=" + i + ", lastFailureCode=" + lastFailureCode);
        log("Inside " + this.TAG + ".stop - failureCode=" + i + ", lastFailureCode=" + lastFailureCode);
        addFailureCode(i);
        if (getState() != null) {
            enterState(null);
        }
        if (this.delayHandler != null) {
            this.delayHandler.removeCallbacks(this.delayTask);
        }
        boolean z2 = (i == 0 || i == FailureCode.SESSION_INTERRUPTED) ? false : true;
        if (z2 && canRetry(this.retriesCounter, i)) {
            this.retriesCounter++;
            log("RETRY " + this.retriesCounter);
            enterTaskWithDelayTime(new C46962(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return;
        }
        setEndTime((int) (System.currentTimeMillis() / 1000));
        this.failureCode = i;
        if (i != 0) {
            z = false;
        }
        if (z) {
            MFLogger.d(this.TAG, "SUCCESS");
            log("SUCCESS");
        } else {
            MFLogger.e(this.TAG, "FAIL: " + this.failureCode);
            log("FAIL: " + this.failureCode);
            if (this.mfLog != null) {
                this.mfLog.setResultCode(this.failureCode);
            }
        }
        if (this.mfLog != null) {
            this.mfLog.setErrorCodes(this.failureCodes);
            log("error code size: " + this.failureCodes.size());
        }
        log("Call onStop");
        onStop(this.failureCode);
        this.isExist = false;
        if (this.bleSessionCallback != null) {
            this.bleSessionCallback.onStop(this.failureCode, this.extraInfoReturned, this);
            this.bleSessionCallback = null;
        }
        onPostStop(this.failureCode);
    }

    public void addFailureCode(int i) {
        this.failureCodes.add(Integer.valueOf(i));
    }

    public int getLastFailureCode() {
        if (this.failureCodes.isEmpty()) {
            return 0;
        }
        return ((Integer) this.failureCodes.get(this.failureCodes.size() - 1)).intValue();
    }

    public boolean enterState(BleState bleState) {
        if (!this.isExist) {
            return false;
        }
        if (this.state != null && bleState != null && this.state.getClass().getName().equalsIgnoreCase(bleState.getClass().getName())) {
            return true;
        }
        if (this.state != null) {
            this.state.onExit();
        }
        if (bleState == null) {
            this.state = null;
            return false;
        }
        this.state = bleState;
        this.isInterruptable = this.state.isInterruptable();
        boolean onEnter = bleState.onEnter();
        if (!onEnter) {
            MFLogger.e(this.TAG, "Failed to enter state: " + bleState);
            this.state = null;
            this.isInterruptable = false;
        }
        return onEnter;
    }

    private void removeDelayWork() {
        if (this.delayHandler != null) {
            this.delayHandler.removeCallbacks(this.delayTask);
            this.delayHandler = null;
        }
    }

    public void enterStateWithDelayTime(final BleState bleState, int i) {
        removeDelayWork();
        this.delayTask.setTask(new Runnable() {
            public void run() {
                BleSession.this.enterState(bleState);
            }
        });
        this.delayHandler = new Handler(Looper.getMainLooper());
        this.delayHandler.postDelayed(this.delayTask, (long) i);
    }

    public void enterTaskWithDelayTime(final Runnable runnable, int i) {
        removeDelayWork();
        this.delayTask.setTask(new Runnable() {
            public void run() {
                runnable.run();
            }
        });
        this.delayHandler = new Handler(Looper.getMainLooper());
        this.delayHandler.postDelayed(this.delayTask, (long) i);
    }

    protected void onRetry(Object... objArr) {
    }

    protected boolean canRetry(int i, int i2) {
        if (i < getMaxRetries()) {
            return true;
        }
        return false;
    }

    public int getMaxRetries() {
        return 0;
    }

    protected boolean containConnectState() {
        return false;
    }

    public boolean isInterruptable() {
        return this.isInterruptable;
    }

    public CommunicateMode getCommunicateMode() {
        return this.communicateMode;
    }

    public void setCommunicateMode(CommunicateMode communicateMode) {
        this.communicateMode = communicateMode;
    }

    public SessionType getSessionType() {
        return this.sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public Object[] getStartParams() {
        return this.startParams;
    }

    public void setStartParams(Object[] objArr) {
        this.startParams = objArr;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int i) {
        this.endTime = i;
    }

    public void log(String str) {
        MFLogger.d(MFLogManager.TAG, str);
        if (this.mfLog != null) {
            this.mfLog.log("[" + this.bleAdapter.getSerial() + "] " + str);
        }
    }

    public String getLog() {
        return null;
    }

    public void setFailureCode(int i) {
        this.failureCode = i;
    }

    public int getFailureCode() {
        return this.failureCode;
    }

    public void setRetriesCounter(int i) {
        this.retriesCounter = i;
    }

    public int getRetriesCounter() {
        return this.retriesCounter;
    }

    public BleState getState() {
        return this.state;
    }

    public boolean addDataCollectionTagToSdk() {
        return this.bleAdapter != null && this.bleAdapter.addDataCollectionTag(this.mfLog != null ? String.valueOf(this.mfLog.getStartTimeEpoch()) : Long.toString((long) this.startTime));
    }

    public boolean handleUnexpectedDisconnection() {
        log("Handle device disconnected.");
        stop(FailureCode.UNEXPECTED_DISCONNECT);
        return true;
    }

    private boolean isNeedGetActiveLogForThisSession() {
        MFLogger.e(this.TAG, ".isNeedGetActiveLogForThisSession");
        CommunicateMode activeCommunicateMode = MFLogManager.getInstance(this.context).getActiveCommunicateMode(this.serial);
        if (activeCommunicateMode == null) {
            return false;
        }
        MFLogger.e(this.TAG, ".isNeedGetActiveLogForThisSession - activeCommunicateMode=" + activeCommunicateMode + ", communicateMode=" + this.communicateMode);
        if (activeCommunicateMode == this.communicateMode && this.communicateMode != CommunicateMode.LINK) {
            return true;
        }
        if (activeCommunicateMode == CommunicateMode.LINK) {
            switch (C46995.f1622xe21851be[this.communicateMode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return true;
            }
        }
        MFLogger.e(this.TAG, ".isNeedGetActiveLogForThisSession - result=FALSE");
        return false;
    }

    public boolean accept(BleSession bleSession) {
        return this.communicateMode != bleSession.getCommunicateMode();
    }

    public final boolean requireBroadCastInAnyCase() {
        return this.sessionType == SessionType.UI || this.sessionType == SessionType.SYNC || mustSendBroadcast();
    }

    protected boolean mustSendBroadcast() {
        return false;
    }
}
