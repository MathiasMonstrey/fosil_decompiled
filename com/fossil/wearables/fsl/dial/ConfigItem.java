package com.fossil.wearables.fsl.dial;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;

public class ConfigItem extends BaseModel {
    public static final String KEY_24_HOUR = "24-hour";
    public static final String KEY_DATE = "Date";
    public static final String KEY_DAY_COLOR = "Day color";
    public static final String KEY_DAY_DATE = "Day & Date";
    public static final String KEY_DIAL_COLOR = "Dial color";
    public static final String KEY_DIGITS_COLOR = "Digits color";
    public static final String KEY_HAND_COLOR = "Hand color";
    public static final String KEY_ICONS = "icon";
    public static final String KEY_MOON_PHASE = "Moon phase";
    public static final String KEY_STYLE_ID = "Style";
    public static final String KEY_SUBEYES = "Subeye";
    public static final String KEY_TEMPERATURE = "Temperature";
    public static final String VALUE_KEY_ALARM = "Alarm";
    public static final String VALUE_KEY_DAY = "Day";
    public static final String VALUE_KEY_MISSED_CALLS = "Missed call";
    public static final String VALUE_KEY_NEXT_MEETING = "Next meeting";
    public static final String VALUE_KEY_PHONE_BATTERY = "Phone battery";
    public static final String VALUE_KEY_SECOND_TIME_ZONE = "Timezone";
    public static final String VALUE_KEY_STEP_COUNT = "Step count";
    public static final String VALUE_KEY_UNREAD_TEXT = "Unread text";
    public static final String VALUE_KEY_WATCH_BATTERY = "Watch battery";
    public static final String VALUE_KEY_WEATHER = "Weather";
    public static final String VALUE_OFF = "Off";
    public static final String VALUE_ON = "On";
    public Float floatValue;
    @DatabaseField(canBeNull = false)
    private String mName;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private SavedDial mSavedDial;
    @DatabaseField(canBeNull = false)
    public String value;

    ConfigItem() {
    }

    public ConfigItem(SavedDial savedDial, String str, String str2) {
        this.mSavedDial = savedDial;
        this.mName = str;
        this.value = str2;
    }

    public String getName() {
        return this.mName;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append(getDbRowId());
        stringBuilder.append(", ").append("name=").append(this.mName);
        stringBuilder.append(", ").append("value=").append(this.value);
        return stringBuilder.toString();
    }

    public boolean isType(String str) {
        if (this.mName.equalsIgnoreCase(str)) {
            return true;
        }
        if ((this.mName.contains(KEY_SUBEYES) || this.mName.contains("icon")) && this.value.contains(str)) {
            return true;
        }
        return false;
    }

    public void setSubvalue(String str, int i) {
        this.value = str + "/" + i;
    }

    public int getSubvalue(String str) {
        if (this.value == null || this.value.length() == 0) {
            return -1;
        }
        String[] split = this.value.split("/");
        if (split == null || split.length < 2 || !isType(str)) {
            return -1;
        }
        return Integer.valueOf(split[1]).intValue();
    }
}
