package com.ua.sdk.user;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.google.gson.JsonParseException;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import java.lang.reflect.Type;

public enum Gender {
    FEMALE,
    MALE;

    public static class GenderAdapter implements cfo<Gender>, cfv<Gender> {
        public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
            return m16243S(com_fossil_cfp, type, com_fossil_cfn);
        }

        public Gender m16243S(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
            String asString = com_fossil_cfp.getAsString();
            if (asString.equals("M") || asString.equals("m")) {
                return Gender.MALE;
            }
            if (asString.equals(DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX) || asString.equals("f")) {
                return Gender.FEMALE;
            }
            return null;
        }

        public cfp m16244a(Gender gender, Type type, cfu com_fossil_cfu) {
            switch (gender) {
                case FEMALE:
                    return new cft(DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX);
                case MALE:
                    return new cft("M");
                default:
                    return null;
            }
        }
    }
}
