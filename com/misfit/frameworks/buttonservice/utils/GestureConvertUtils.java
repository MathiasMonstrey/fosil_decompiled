package com.misfit.frameworks.buttonservice.utils;

import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.uapp.UAppEnum$UAppSystemLevelEvent;
import com.misfit.frameworks.common.enums.Gesture;

public class GestureConvertUtils {
    public static Gesture convertFromSDKEventToGesture(int i) {
        switch (MemEventNumber.get((byte) i)) {
            case SINGLE_CLICK:
                return Gesture.SINGLE_PRESS;
            case DOUBLE_CLICK:
                return Gesture.DOUBLE_PRESS;
            case TRIPLE_CLICK:
                return Gesture.TRIPLE_PRESS;
            case LONG_PRESS:
                return Gesture.LONG_PRESS;
            case EVENT_TYPE_BUTTON1_SINGLE_PRESS:
                return Gesture.SAM_BT1_SINGLE_PRESS;
            case EVENT_TYPE_BUTTON1_SINGLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT1_SINGLE_PRESS_AND_HOLD;
            case EVENT_TYPE_BUTTON1_DOUBLE_PRESS:
                return Gesture.SAM_BT1_DOUBLE_PRESS;
            case EVENT_TYPE_BUTTON1_DOUBLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT1_DOUBLE_PRESS_AND_HOLD;
            case EVENT_TYPE_BUTTON1_TRIPLE_PRESS:
                return Gesture.SAM_BT1_TRIPLE_PRESS;
            case EVENT_TYPE_BUTTON1_TRIPLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT1_TRIPLE_PRESS_AND_HOLD;
            case BUTTON1_PRESSED:
                return Gesture.SAM_BT1_PRESSED;
            case EVENT_TYPE_BUTTON2_SINGLE_PRESS:
                return Gesture.SAM_BT2_SINGLE_PRESS;
            case EVENT_TYPE_BUTTON2_SINGLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT2_SINGLE_PRESS_AND_HOLD;
            case EVENT_TYPE_BUTTON2_DOUBLE_PRESS:
                return Gesture.SAM_BT2_DOUBLE_PRESS;
            case EVENT_TYPE_BUTTON2_DOUBLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT2_DOUBLE_PRESS_AND_HOLD;
            case EVENT_TYPE_BUTTON2_TRIPLE_PRESS:
                return Gesture.SAM_BT2_TRIPLE_PRESS;
            case EVENT_TYPE_BUTTON2_TRIPLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT2_TRIPLE_PRESS_AND_HOLD;
            case BUTTON2_PRESSED:
                return Gesture.SAM_BT2_PRESSED;
            case EVENT_TYPE_BUTTON3_SINGLE_PRESS:
                return Gesture.SAM_BT3_SINGLE_PRESS;
            case EVENT_TYPE_BUTTON3_SINGLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT3_SINGLE_PRESS_AND_HOLD;
            case EVENT_TYPE_BUTTON3_DOUBLE_PRESS:
                return Gesture.SAM_BT3_DOUBLE_PRESS;
            case EVENT_TYPE_BUTTON3_DOUBLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT3_DOUBLE_PRESS_AND_HOLD;
            case EVENT_TYPE_BUTTON3_TRIPLE_PRESS:
                return Gesture.SAM_BT3_TRIPLE_PRESS;
            case EVENT_TYPE_BUTTON3_TRIPLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT3_TRIPLE_PRESS_AND_HOLD;
            case BUTTON3_PRESSED:
                return Gesture.SAM_BT3_PRESSED;
            default:
                return Gesture.NONE;
        }
    }

    public static Gesture convertFromMicroAppSDKEventToGesture(int i) {
        switch (UAppEnum$UAppSystemLevelEvent.get((byte) i)) {
            case TAP_DOUBLE:
                return Gesture.DOUBLE_PRESS;
            case TAP_TRIPLE:
                return Gesture.TRIPLE_PRESS;
            case BTN_1_SINGLE_CLICK:
                return Gesture.SAM_BT1_SINGLE_PRESS;
            case BTN_1_SINGLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT1_SINGLE_PRESS_AND_HOLD;
            case BTN_1_DOUBLE_CLICK:
                return Gesture.SAM_BT1_DOUBLE_PRESS;
            case BTN_1_DOUBLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT1_DOUBLE_PRESS_AND_HOLD;
            case BTN_1_TRIPLE_CLICK:
                return Gesture.SAM_BT1_TRIPLE_PRESS;
            case BTN_1_TRIPLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT1_TRIPLE_PRESS_AND_HOLD;
            case BTN_1_PRESS:
                return Gesture.SAM_BT1_PRESSED;
            case BTN_2_SINGLE_CLICK:
                return Gesture.SAM_BT2_SINGLE_PRESS;
            case BTN_2_SINGLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT2_SINGLE_PRESS_AND_HOLD;
            case BTN_2_DOUBLE_CLICK:
                return Gesture.SAM_BT2_DOUBLE_PRESS;
            case BTN_2_DOUBLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT2_DOUBLE_PRESS_AND_HOLD;
            case BTN_2_TRIPLE_CLICK:
                return Gesture.SAM_BT2_TRIPLE_PRESS;
            case BTN_2_TRIPLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT2_TRIPLE_PRESS_AND_HOLD;
            case BTN_2_PRESS:
                return Gesture.SAM_BT2_PRESSED;
            case BTN_3_SINGLE_CLICK:
                return Gesture.SAM_BT3_SINGLE_PRESS;
            case BTN_3_SINGLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT3_SINGLE_PRESS_AND_HOLD;
            case BTN_3_DOUBLE_CLICK:
                return Gesture.SAM_BT3_DOUBLE_PRESS;
            case BTN_3_DOUBLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT3_DOUBLE_PRESS_AND_HOLD;
            case BTN_3_TRIPLE_CLICK:
                return Gesture.SAM_BT3_TRIPLE_PRESS;
            case BTN_3_TRIPLE_PRESS_AND_HOLD:
                return Gesture.SAM_BT3_TRIPLE_PRESS_AND_HOLD;
            case BTN_3_PRESS:
                return Gesture.SAM_BT3_PRESSED;
            default:
                return Gesture.NONE;
        }
    }
}
