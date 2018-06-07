package com.misfit.frameworks.buttonservice.log;

import android.content.Context;
import com.misfit.frameworks.buttonservice.utils.LocationUtils;

public class FailureCode {
    public static final int APP_CRASH_FROM_APP_LAYER = 1906;
    public static final int APP_CRASH_FROM_BUTTON_SERVICE = 1905;
    public static final int BLUETOOTH_IS_DISABLED = 1101;
    public static final int CONNECT_BY_MAC_SUCCESS = 1217;
    public static final int CONNECT_BY_SCANNED_DEVICE_SUCCESS = 1218;
    public static final int DEVICE_NOT_FOUND = 1122;
    public static final int DEVICE_NOT_FOUND_AFTER_OTA = 1123;
    public static final int FAILED_TO_ACTIVATE = 1204;
    public static final int FAILED_TO_APPLY_HAND_POSITION = 1353;
    public static final int FAILED_TO_CLEAR_ALARM = 1313;
    public static final int FAILED_TO_CLEAR_LAST_NOTIFICATION = 1345;
    public static final int FAILED_TO_CLEAR_LINK_MAPPING = 1334;
    public static final int FAILED_TO_CONNECT = 1201;
    public static final int FAILED_TO_CONNECT_AFTER_OTA = 1202;
    public static final int FAILED_TO_CONNECT_AFTER_OTA_BY_BOND = 1207;
    public static final int FAILED_TO_CONNECT_AFTER_OTA_BY_BOND_TIMEOUT = 1214;
    public static final int FAILED_TO_CONNECT_AFTER_OTA_TIMEOUT = 1212;
    public static final int FAILED_TO_CONNECT_BY_BOND = 1206;
    public static final int FAILED_TO_CONNECT_BY_BOND_TIMEOUT = 1213;
    public static final int FAILED_TO_CONNECT_BY_SCANNED_DEVICE = 1215;
    public static final int FAILED_TO_CONNECT_BY_SCANNED_DEVICE_TIMEOUT = 1216;
    public static final int FAILED_TO_CONNECT_TIMEOUT = 1211;
    public static final int FAILED_TO_DISABLE_GOAL_TRACKING = 1362;
    public static final int FAILED_TO_ENABLE_GOAL_TRACKING = 1361;
    public static final int FAILED_TO_GET_ALARM = 1312;
    public static final int FAILED_TO_GET_BATTERY = 1305;
    public static final int FAILED_TO_GET_CONFIG = 1302;
    public static final int FAILED_TO_GET_COUNTDOWN = 1372;
    public static final int FAILED_TO_GET_REAL_TIME_STEP = 1504;
    public static final int FAILED_TO_GET_SECOND_TIMEZONE = 1322;
    public static final int FAILED_TO_GET_STEP_GOAL = 1506;
    public static final int FAILED_TO_GET_VIBRATION_STRENGTH = 1307;
    public static final int FAILED_TO_MICRO_APP_SETTING = 1385;
    public static final int FAILED_TO_MOVE_HAND = 1352;
    public static final int FAILED_TO_OTA = 1401;
    public static final int FAILED_TO_OTA_FILE_NOT_READY = 1403;
    public static final int FAILED_TO_OTA_FW_NOT_MATCH = 1404;
    public static final int FAILED_TO_PLAY_ANIMATION = 201;
    public static final int FAILED_TO_PLAY_LIGHT_VIBRATION = 1344;
    public static final int FAILED_TO_PLAY_VIBRATION = 1343;
    public static final int FAILED_TO_PREPARE = 1203;
    public static final int FAILED_TO_PREPARE_AFTER_OTA = 1205;
    public static final int FAILED_TO_READ_RSSI = 1308;
    public static final int FAILED_TO_RELEASE_HAND_CONTROL = 1354;
    public static final int FAILED_TO_REQUEST_HAND_CONTROL = 1351;
    public static final int FAILED_TO_RESET_HAND_CONTROL = 1355;
    public static final int FAILED_TO_SEND_NOTIFICATION = 1342;
    public static final int FAILED_TO_SET_ALARM = 1311;
    public static final int FAILED_TO_SET_CONFIG = 1301;
    public static final int FAILED_TO_SET_CONFIG_BACK = 1304;
    public static final int FAILED_TO_SET_CONNECTION_PARAM = 1303;
    public static final int FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE = 1310;
    public static final int FAILED_TO_SET_COUNTDOWN = 1371;
    public static final int FAILED_TO_SET_LINK_MAPPING = 1331;
    public static final int FAILED_TO_SET_LINK_MAPPING_EMPTY = 1332;
    public static final int FAILED_TO_SET_MAPPING_ANIMATION = 1337;
    public static final int FAILED_TO_SET_MICRO_APP_MAPPING = 1338;
    public static final int FAILED_TO_SET_NOTIFICATION = 1341;
    public static final int FAILED_TO_SET_REAL_TIME_STEP = 1503;
    public static final int FAILED_TO_SET_SECOND_TIMEZONE = 1321;
    public static final int FAILED_TO_SET_STEP_GOAL = 1505;
    public static final int FAILED_TO_SET_STOP_WATCH_SETTING = 1384;
    public static final int FAILED_TO_SET_TIME = 1309;
    public static final int FAILED_TO_SET_VIBRATION_STRENGTH = 1306;
    public static final int FAILED_TO_START_STREAMING = 1335;
    public static final int FAILED_TO_STOP_STREAMING = 1336;
    public static final int FAILED_TO_SYNC = 1501;
    public static final int FIRMWARE_INCOMPATIBLE = 1502;
    public static final int LOCATION_ACCESS_DENIED = 1113;
    public static final int LOCATION_SERVICE_DISABLED = 1112;
    public static final int NETWORK_ERROR = 1901;
    public static final int NO_DEVICE_FOUND = 1121;
    public static final int OTA_INTERRUPTED = 1402;
    public static final int PERMISSION_GRANTED = 1114;
    public static final int SCANNING_FAILED_WITH_SDK_EXCEPTION = 1111;
    public static final int SERVER_MAINTENANCE = 1903;
    public static final int SESSION_INTERRUPTED = 1611;
    public static final int SUCCESS = 0;
    public static final int TOO_MANY_REQUEST_CALL_API_STEAL_DEVICE = 1902;
    public static final int UNEXPECTED_DISCONNECT = 1801;
    public static final int UNKNOWN_ERROR = 9999;
    public static final int USER_CANCELLED = 1603;
    public static final int USER_CANCELLED_BUT_USER_DID_NOT_SELECT_ANY_DEVICE = 1602;
    public static final int USER_CANCELLED_NO_DEVICE_FOUND = 1601;
    public static final int USER_KILL_APP_FROM_TASK_MANAGER = 1904;
    public static final int VERIFY_MULTIPLE_ALARMS_FAILED = 101;

    public static int getFailureCodeNoDeviceFound(Context context, int i) {
        if (!LocationUtils.isLocationEnable(context)) {
            return LOCATION_SERVICE_DISABLED;
        }
        if (LocationUtils.isLocationPermissionGranted(context)) {
            return i;
        }
        return LOCATION_ACCESS_DENIED;
    }
}
