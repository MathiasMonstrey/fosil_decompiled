package com.misfit.frameworks.buttonservice.communite;

import com.misfit.frameworks.buttonservice.log.FailureCode;

public enum CommunicateMode {
    COMMAND(0),
    MANUAL_SYNC(1),
    SYNC(2),
    SHOW_DEVICE(4),
    SAVE_DEVICE_DATA(5),
    SAVE_STANDALONE_DATA(5),
    TS_RESET_BT_SYNC(7),
    TS_BATTERY_SYNC(8),
    LINK(10),
    SEND_CALL_NOTIFICATION(18),
    SEND_TEXT_NOTIFICATION(19),
    SEND_NOTIFICATION(20),
    STANDALONE_LINK(22),
    ACTIVATE(23),
    SET_CONFIG(24),
    UNLINK(25),
    SET_LAP_COUNTING_LICENSE(26),
    SET_LINK_MAPPING(27),
    CLEAN_LINK_MAPPINGS(28),
    START_HID_CONNECTION(29),
    ENTER_CALIBRATION(30),
    MOVE_HAND(31),
    EXIT_CALIBRATION(32),
    RESET_HAND(33),
    APPLY_HAND_POSITION(34),
    OTA(35),
    SET_ALARM(36),
    GET_ALARM(37),
    CLEAR_ALARM(38),
    SET_SECOND_TIMEZONE(39),
    GET_SECOND_TIMEZONE(40),
    SET_REALTIME_STEP_GOAL_STEP(41),
    RECONNECT(42),
    DISABLE_GOAL_TRACKING(43),
    STREAMING(50),
    SET_COUNTDOWN(60),
    GET_COUNTDOWN(61),
    SET_VIBRATION_STRENGTH(62),
    GET_VIBRATION_STRENGTH(63),
    PLAY_LED_ANIMATION(64),
    GET_BATTERY_LEVEL(65),
    READ_RSSI(66),
    SET_MAPPING_ANIMATION(67),
    PLAY_LIGHT(68),
    PLAY_VIBRATION(69),
    PLAY_LIGHT_AND_VIBRATION(70),
    UPDATE_CURRENT_TIME(71),
    READ_REAL_TIME_STEP(72),
    SET_STEP_GOAL(73),
    STOP_STREAMING(74),
    DISCONNECT(75),
    INTERRUPT(76),
    SET_LIST_ALARM(77),
    VERIFY_LIST_ALARM(78),
    FORCE_CONNECT(79),
    CLEAR_LAST_NOTIFICATION(80),
    CONNECT_WITHOUT_TIMEOUT(81),
    MICRO_APP_REQUEST_HAND_CONTROL(82),
    MICRO_APP_PLAY_ANIMATION(83),
    MICRO_APP_BUZZ(84),
    MICRO_APP_RELEASE_HAND_CONTROL(85),
    MICRO_APP_MOVE_HAND(86),
    HW_LOG_SYNC(87),
    STOP_WATCH_SETTING(88),
    SET_AUTO_MAPPING(89),
    SET_AUTO_SECOND_TIMEZONE(90),
    SET_AUTO_SINGLE_ALARM(91),
    SET_AUTO_MULTI_ALARM(92),
    SET_AUTO_COUNT_DOWN(93),
    IDLE(FailureCode.UNKNOWN_ERROR);
    
    private int value;

    private CommunicateMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static CommunicateMode fromValue(int i) {
        for (CommunicateMode communicateMode : values()) {
            if (communicateMode.getValue() == i) {
                return communicateMode;
            }
        }
        return IDLE;
    }
}
