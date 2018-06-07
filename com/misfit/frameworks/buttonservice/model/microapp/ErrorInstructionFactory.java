package com.misfit.frameworks.buttonservice.model.microapp;

import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ErrorInstructionFactory {

    @Retention(RetentionPolicy.SOURCE)
    public @interface MicroAppType {
        public static final int MICRO_APP_COMMUTE_ETA = 0;
        public static final int MICRO_APP_COMMUTE_TRAVEL = 1;
        public static final int MICRO_APP_RING_PHONE = 3;
        public static final int MICRO_APP_WEATHER = 2;
    }

    public static MicroAppInstruction getErrorInstructions(int i) {
        switch (i) {
            case 0:
                return new ErrorInstruction(UAppID.UAPP_COMMUTE_TIME, UAppVariant.UAPP_VARIANT_ETA);
            case 1:
                return new ErrorInstruction(UAppID.UAPP_COMMUTE_TIME, UAppVariant.UAPP_VARIANT_TRAVEL);
            case 2:
                return new ErrorInstruction(UAppID.UAPP_WEATHER, UAppVariant.UAPP_VARIANT_STANDARD);
            case 3:
                return new ErrorInstruction(UAppID.UAPP_RING_PHONE, UAppVariant.UAPP_VARIANT_STANDARD);
            default:
                return new ErrorInstruction(UAppID.UAPP_UNDEFINED, UAppVariant.UAPP_VARIANT_UNDEFINED);
        }
    }
}
