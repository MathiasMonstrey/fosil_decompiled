package com.misfit.ble.shine;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ShineActionID implements ActionID {
    UNKNOWN("999"),
    NONE("000"),
    CONNECT("072"),
    DISCONNECT("073"),
    PREPARE("001"),
    SEND_DUMMY_FILE_LIST("054"),
    ANIMATE("002"),
    STOP_ANIMATING("011"),
    SYNC_ANIMATE("055"),
    ACTIVATE("010"),
    GET_ACTIVATION_STATE("056"),
    GET_CONFIGURATION("003"),
    SET_CONFIGURATION("004"),
    SYNC("005"),
    RETRIEVE_HARDWARE_LOG("030"),
    OTA("006"),
    CHANGE_SERIAL_NUMBER("009"),
    GET_CONNECTION_PARAMETERS("007"),
    SET_CONNECTION_PARAMETERS("008"),
    STREAM_USER_INPUT_EVENTS("012"),
    GET_STREAMING_CONFIGURATION("057"),
    SET_STREAMING_CONFIGURATION("014"),
    READ_REMOTE_RSSI("058"),
    PLAY_BUTTON_EVENT_ANIMATION("016"),
    EVENT_MAPPING_SYSTEM_CONTROL("059"),
    SET_INACTIVITY_NUDGE("022"),
    GET_INACTIVITY_NUDGE("023"),
    SET_GOAL_HIT_NOTIFICATION("020"),
    GET_GOAL_HIT_NOTIFICATION("021"),
    SET_SINGLE_ALARM_TIME("024"),
    GET_SINGLE_ALARM_TIME("025"),
    CLEAR_ALL_ALARMS("026"),
    SET_CALL_TEXT_NOTIFICATIONS("027"),
    GET_CALL_TEXT_NOTIFICATIONS("028"),
    DISABLE_ALL_CALL_TEXT_NOTIFICATIONS("029"),
    SEND_CALL_NOTIFICATION("060"),
    SEND_TEXT_NOTIFICATION("061"),
    PLAY_VIBRATION("018"),
    PLAY_SOUND("019"),
    PLAY_LED_ANIMATION("017"),
    SET_EVENT_MAPPING("015"),
    UNMAP_BUTTON_EVENT("048"),
    UNMAP_ALL_BUTTON_EVENTS("062"),
    PLAY_NOTIFICATION_FILTER_LED_ANIMATION("039"),
    PLAY_NOTIFICATION_FILTER_VIBRATION("040"),
    SET_CALIBRATED_HAND_POSITION("043"),
    SET_MOVING_HANDS("044"),
    SET_REQUEST_HANDS_CONTROL("041"),
    SET_RELEASE_HANDS_CONTROL("042"),
    GET_CURRENT_HAND_POSITIONS("045"),
    SEND_NOTIFICATION_HAND_CONTROL("046"),
    SET_CURRENT_TIME_SERVICE("053"),
    SET_MULTIPLE_ALARMS("049"),
    VERIFY_MULTIPLE_ALARMS("050"),
    CLEAR_ALL_HAND_NOTIFICATIONS("035"),
    SET_STOP_WATCH_SETTING("036"),
    GET_STOP_WATCH_SETTING("037"),
    READ_UAPP_SYSTEM_VERSION("068"),
    SET_UAPP_CONFIGURATION("069"),
    SEND_UAPP_REMOTE_ACTIVITY("070"),
    SEND_ACK_NEW_HEARTBEAT("071");
    
    private static final Map<String, ShineActionID> aD = null;
    private String ew;

    static {
        aD = new HashMap();
        Iterator it = EnumSet.allOf(ShineActionID.class).iterator();
        while (it.hasNext()) {
            ShineActionID shineActionID = (ShineActionID) it.next();
            aD.put(shineActionID.getId(), shineActionID);
        }
    }

    private ShineActionID(String str) {
        this.ew = str;
    }

    public static ShineActionID get(String str) {
        return (ShineActionID) aD.get(str);
    }

    public String getId() {
        return this.ew;
    }
}
