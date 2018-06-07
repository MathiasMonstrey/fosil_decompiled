package com.misfit.ble.shine.error;

import com.facebook.appevents.AppEventsConstants;
import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.shine.ActionID;
import com.misfit.frameworks.common.constants.Constants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class ShineError {
    private Domain iU;
    private ActionID iV;
    private Event iW;
    private Reason iX;

    public enum Domain {
        NONE(AppEventsConstants.EVENT_PARAM_VALUE_NO),
        SHINE_PROFILE_ERROR(AppEventsConstants.EVENT_PARAM_VALUE_YES),
        PHASE_ACTION_ERROR("2");
        
        private static final Map<String, Domain> aD = null;
        private String ew;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(Domain.class).iterator();
            while (it.hasNext()) {
                Domain domain = (Domain) it.next();
                aD.put(domain.getId(), domain);
            }
        }

        private Domain(String str) {
            this.ew = str;
        }

        public static Domain get(String str) {
            return (Domain) aD.get(str);
        }

        public String getId() {
            return this.ew;
        }
    }

    public enum Event {
        READ_SERIAL_NUMBER("200"),
        READ_FIRMWARE_VERSION("201"),
        READ_MODEL_NUMBER("202"),
        UPDATE_VALUE_FOR_CHARACTERISTIC("203"),
        DISCOVER_SERVICES("204"),
        DISCOVER_CHARACTERISTICS("205"),
        UNKNOWN_FIRMWARE("206"),
        ESTABLISH_CONNECTION("207"),
        DISCONNECT("208"),
        UNKNOWN("999"),
        NONE("000"),
        ACTIVATE("001"),
        DISPLAY_PAIR_ANIMATION("002"),
        DISPLAY_SYNC_ANIMATION("003"),
        STOP_ANIMATION("004"),
        GET_ACTIVITY_POINT("005"),
        GET_ACTIVITY_TAGGING_STATE("006"),
        GET_BATTERY("007"),
        GET_CLOCK_STATE("008"),
        GET_COUNTDOWN_SETTINGS("009"),
        GET_CURRENT_STEPS("010"),
        GET_GOAL_IN_STEPS("011"),
        GET_GOAL("012"),
        GET_GOAL_TRACKING("013"),
        GET_SECOND_TIMEZONE("014"),
        GET_TIME("015"),
        GET_TRIPLE_TAP_ENABLE("016"),
        GET_VIBE_STRENGTH("017"),
        GET_WRIST_FLICK("018"),
        SET_ACTIVITY_POINT("019"),
        SET_ACTIVITY_TAGGING_STATE("020"),
        SET_CLOCK_STATE("021"),
        SET_COUNTDOWN_SETTINGS("022"),
        SET_CURRENT_STEPS("023"),
        SET_EXTRA_ADVERTISING_DATA_STATE("024"),
        SET_GOAL_IN_STEPS("025"),
        SET_GOAL("026"),
        SET_GOAL_TRACKING("027"),
        SET_SECOND_TIMEZONE("028"),
        SET_TIME("029"),
        SET_TRIPLE_TAP_ENABLE("030"),
        SET_VIBE_STRENGTH("031"),
        SET_WRIST_FLICK("032"),
        GET_CONNECTION_PARAMETERS("033"),
        SET_CONNECTION_PARAMETERS("034"),
        SET_EVENT_MAPPING("035"),
        UNMAP_EVENT_MAPPING("036"),
        FILE_STREAMING("037"),
        GET_FLASH_BUTTON_MODE("038"),
        MAP_BUTTON_EVENT_ANIMATION("039"),
        PLAY_BUTTON_EVENT_ANIMATION("040"),
        SET_FILE_STREAMING_HEARTBEAT_INTERVAL("041"),
        SET_FILE_STREAMING_NUMBER_OF_PACKET_EVENTS("042"),
        SET_FLASH_BUTTON_MODE("043"),
        STOP_FILE_STREAMING("044"),
        PLAY_SPECIFIC_LED("045"),
        MULTIPLE_ALARM_PUT("046"),
        VERIFY_MULTIPLE_ALARMS("047"),
        PLAY_NOTIFICATION_WITH_ANIMATION("048"),
        CLEAR_ALL_HAND_NOTIFICATIONS("049"),
        CLEAR_NOTIFICATION_FILTERING("050"),
        GET_NOTIFICATION_FILTERING("051 "),
        SAVE_ALL_NOTIFICATION_FILTERING("052"),
        SET_NOTIFICATION_FILTERING("053"),
        OTA_ENTER("054"),
        OTA_ERASE("055"),
        OTA_GET_SIZE_WRITTEN("056"),
        OTA_PUT("057"),
        OTA_RESET("058"),
        OTA_VERIFY_FILE("059"),
        OTA_VERIFY_SEGMENT("060"),
        CLEAR_ALL_ALARMS("061"),
        DISABLE_ALL_BLE_NOTIFICATIONS("062"),
        GET_ALARM_PARAMETERS("063"),
        GET_BLE_NOTIFICATION("064"),
        GET_BLE_NOTIFICATION_TIME_WINDOW("065"),
        GET_GOAL_HIT_NOTIFICATION("066"),
        GET_INACTIVITY_NUDGE("067"),
        GET_SINGLE_ALARM("068"),
        PLAY_LED("069"),
        PLAY_SOUND("070"),
        PLAY_VIBRATION("071"),
        SET_ALARM_PARAMETERS("072"),
        SETUP_BLE_NOTIFICATION("073"),
        SETUP_BLE_NOTIFICATION_TIME_WINDOW("074"),
        SETUP_GOAL_HIT_NOTIFICATION("075"),
        SETUP_INACTIVITY_NUDGE("076"),
        SETUP_SINGLE_ALARM("077"),
        GET_HAND_POSITION("078"),
        SET_CALIBRATED_HAND_POSITION("079"),
        SET_MOVING_HANDS("080"),
        SET_RELEASE_HANDS_CONTROL("081"),
        SET_REQUEST_HANDS_CONTROL("082"),
        SERIAL_NUMBER_CHANGE_AND_LOCK("083"),
        SERIAL_NUMBER_CHANGE("084"),
        SERIAL_NUMBER_GET_LOCK("085"),
        SERIAL_NUMBER_SET_LOCK("086"),
        SERIAL_NUMBER_SET("087"),
        SERIAL_NUMBER_UNLOCK("088"),
        CLOSE_CURRENT_ACTIVITY_FILE("089"),
        FILE_ABORT("090"),
        FILE_ERASE_ACTIVITY("091"),
        FILE_ERASE_HARDWARE_LOG("092"),
        FILE_ERASE("093"),
        FILE_GET_ACTIVITY("094"),
        FILE_GET_HARDWARE_LOG("095"),
        FILE_GET("096"),
        FILE_LIST("097"),
        GET_LAST_PROCESSED_FILE_HANDLE("098"),
        SET_LAST_PROCESSED_FILE_HANDLE("099"),
        PLAY_SPECIFIED_VIBRATION("100"),
        CUSTOM("101"),
        BOLT_ADD_GROUP_ID("102"),
        BOLT_GET_GROUP_ID("103"),
        BOLT_GET_PASSCODE("104"),
        BOLT_SET_PASSCODE("105"),
        GET_BUTTON_EVENT_MAPPING("106"),
        MAPPING_SYSTEM_CONTROL("109"),
        GET_ACTIVATION_STATE("110"),
        GET_CONNECTION_HEARTBEAT_INTERVAL("111"),
        GET_EXTRA_ADVERTISING_DATA_STATE("112"),
        UNMAP_ALL_EVENT_MAPPINGS("113"),
        SET_CURRENT_TIME_SERVICE("114"),
        SEND_CALL_NOTIFICATION("115"),
        SEND_TEXT_NOTIFICATION("116"),
        SET_STOP_WATCH_SETTING("128"),
        GET_STOP_WATCH_SETTING("129"),
        READ_UAPP_SYSTEM_VERSION("122"),
        FILE_SETTING_PUT("123"),
        FILE_SETTING_GET_SIZE_WRITTEN("124"),
        FILE_SETTING_ABORT("125"),
        ACK_HEARTBEAT("126"),
        REQUEST_CONNECTION_PRIORITY("127");
        
        private static final Map<String, Event> aD = null;
        private String ew;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(Event.class).iterator();
            while (it.hasNext()) {
                Event event = (Event) it.next();
                aD.put(event.getId(), event);
            }
        }

        private Event(String str) {
            this.ew = str;
        }

        public static Event get(String str) {
            return (Event) aD.get(str);
        }

        public String getId() {
            return this.ew;
        }
    }

    public enum Reason {
        UNKNOWN("99"),
        NONE("00"),
        SENDING_REQUEST_FAILED("12"),
        SENDING_REQUEST_FAILED_WITH_UNKNOWN_ERROR("02"),
        RECEIVE_RESPONSE_FAILED("15"),
        TIMED_OUT("13"),
        REQUEST_ERROR("23"),
        RESPONSE_PARSE_ERROR("16"),
        FLOW_BROKEN("22"),
        INTERRUPTED("19"),
        DATA_TRANSFER_FAILED("18"),
        UNSUPPORTED("14"),
        CONNECTION_DROPPED("28"),
        REQUEST_VALUE_OUT_OF_RANGE_ERROR("11"),
        FUNCTION_NOT_IMPLEMENTED_ERROR("24"),
        RESOURCE_UNAVAILABLE_ERROR("20"),
        BLE_STACK_ERROR("21"),
        WRITE_CHARACTERISTIC_FAILED("26"),
        INCOMPATIBLE_PARAMS("27"),
        GATT_INTERNAL_ERROR("29"),
        LACK_OF_CHARACTERISTICS("30"),
        LACK_OF_SERVICES("31");
        
        private static final Map<String, Reason> aD = null;
        private String ew;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(Reason.class).iterator();
            while (it.hasNext()) {
                Reason reason = (Reason) it.next();
                aD.put(reason.getId(), reason);
            }
        }

        private Reason(String str) {
            this.ew = str;
        }

        public static Reason get(String str) {
            return (Reason) aD.get(str);
        }

        public String getId() {
            return this.ew;
        }
    }

    public ShineError(Domain domain, ActionID actionID, Event event, Reason reason) {
        this.iU = domain;
        this.iV = actionID;
        this.iW = event;
        this.iX = reason;
    }

    public Domain getDomain() {
        return this.iU;
    }

    public ActionID getAction() {
        return this.iV;
    }

    public Event getEvent() {
        return this.iW;
    }

    public Reason getReason() {
        return this.iX;
    }

    public String toString() {
        return "ShineError{domain='" + this.iU + '\'' + ", action='" + this.iV + '\'' + ", event='" + this.iW + '\'' + ", reason='" + this.iX + '\'' + '}';
    }

    public String getCode() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.iU.getId());
        stringBuffer.append(this.iV.getId());
        stringBuffer.append(this.iW.getId());
        stringBuffer.append(this.iX.getId());
        return stringBuffer.toString();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("domain", this.iU);
            jSONObject.put("reason", this.iX);
            jSONObject.put("action", this.iV);
            jSONObject.put(Constants.EVENT, this.iW);
            jSONObject.put("code", getCode());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
