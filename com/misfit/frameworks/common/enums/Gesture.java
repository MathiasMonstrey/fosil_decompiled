package com.misfit.frameworks.common.enums;

import android.support.v8.renderscript.ScriptIntrinsicBLAS;

public enum Gesture {
    NONE(0),
    SINGLE_PRESS(1),
    DOUBLE_PRESS(2),
    TRIPLE_PRESS(3),
    LONG_PRESS(4),
    DOUBLE_LONG_PRESS(5),
    QUADRUPLE_PRESS(6),
    SAM_BT1_SINGLE_PRESS(111),
    SAM_BT1_SINGLE_PRESS_AND_HOLD(112),
    SAM_BT1_DOUBLE_PRESS(113),
    SAM_BT1_DOUBLE_PRESS_AND_HOLD(114),
    SAM_BT1_TRIPLE_PRESS(115),
    SAM_BT1_TRIPLE_PRESS_AND_HOLD(116),
    SAM_BT1_PRESSED(117),
    SAM_BT2_SINGLE_PRESS(ScriptIntrinsicBLAS.UPPER),
    SAM_BT2_SINGLE_PRESS_AND_HOLD(ScriptIntrinsicBLAS.LOWER),
    SAM_BT2_DOUBLE_PRESS(123),
    SAM_BT2_DOUBLE_PRESS_AND_HOLD(124),
    SAM_BT2_TRIPLE_PRESS(125),
    SAM_BT2_TRIPLE_PRESS_AND_HOLD(126),
    SAM_BT2_PRESSED(127),
    SAM_BT3_SINGLE_PRESS(ScriptIntrinsicBLAS.NON_UNIT),
    SAM_BT3_SINGLE_PRESS_AND_HOLD(ScriptIntrinsicBLAS.UNIT),
    SAM_BT3_DOUBLE_PRESS(133),
    SAM_BT3_DOUBLE_PRESS_AND_HOLD(134),
    SAM_BT3_TRIPLE_PRESS(135),
    SAM_BT3_TRIPLE_PRESS_AND_HOLD(136),
    SAM_BT3_PRESSED(137),
    SAM_DOUBLE_TAP(ScriptIntrinsicBLAS.LEFT),
    SAM_TRIPLE_TAP(ScriptIntrinsicBLAS.RIGHT),
    SAM_QUADRUPLE_TAP(143);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    public static Gesture fromInt(int i) {
        for (Gesture gesture : values()) {
            if (gesture.getValue() == i) {
                return gesture;
            }
        }
        return NONE;
    }

    private Gesture(int i) {
        this.value = i;
    }
}
