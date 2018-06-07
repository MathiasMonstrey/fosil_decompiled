package com.portfolio.platform.enums;

import android.text.TextUtils;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;

public enum Gender {
    FEMALE(DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX),
    MALE("M"),
    OTHER("O"),
    RATHER_NOT_SAY("NA");
    
    private final String value;

    private Gender(String str) {
        this.value = str;
    }

    public static Gender fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return RATHER_NOT_SAY;
        }
        for (Gender gender : values()) {
            if (str.equalsIgnoreCase(gender.value)) {
                return gender;
            }
        }
        return RATHER_NOT_SAY;
    }

    public String toString() {
        return this.value;
    }
}
