package com.misfit.frameworks.common.enums;

public enum ButtonType {
    NONE(0),
    SELFIE(1),
    MUSIC(2),
    PRESENTATION(3),
    FIND_MY_PHONE(4),
    ACTIVITY(5),
    APPS(6),
    BOLT_CONTROL(7),
    RING_MY_PHONE(8),
    GOAL_TRACKING(9),
    DISPLAY_MODE(10),
    PLUTO_TRACKER(50),
    SILVRETTA_TRACKER(51),
    BMW_TRACKER(52),
    SWAROVSKI_TRACKER(53),
    CUSTOM(100),
    ThirdPartyApp(1000);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    public static ButtonType fromInt(int i) {
        for (ButtonType buttonType : values()) {
            if (buttonType.getValue() == i) {
                return buttonType;
            }
        }
        return NONE;
    }

    private ButtonType(int i) {
        this.value = i;
    }
}
