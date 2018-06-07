package com.portfolio.platform.data.model.microapp;

import com.misfit.frameworks.common.enums.Action.DisplayMode;
import com.misfit.frameworks.common.enums.Action.Selfie;
import com.misfit.frameworks.common.enums.Gesture;
import com.misfit.frameworks.common.log.MFLogger;

public class PusherConfiguration {
    public static final String TAG = PusherConfiguration.class.getSimpleName();
    private Pusher pusher;

    static /* synthetic */ class C47411 {
        static final /* synthetic */ int[] $SwitchMap$com$misfit$frameworks$common$enums$Gesture = new int[Gesture.values().length];

        static {
            f1637x96782840 = new int[Pusher.values().length];
            try {
                f1637x96782840[Pusher.TOP_PUSHER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1637x96782840[Pusher.MID_PUSHER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1637x96782840[Pusher.BOTTOM_PUSHER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1637x96782840[Pusher.TRIPLE_TAP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1637x96782840[Pusher.DOUBLE_TAP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_PRESSED.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_SINGLE_PRESS.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_SINGLE_PRESS_AND_HOLD.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_DOUBLE_PRESS.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_DOUBLE_PRESS_AND_HOLD.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_TRIPLE_PRESS.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_TRIPLE_PRESS_AND_HOLD.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_PRESSED.ordinal()] = 8;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_SINGLE_PRESS.ordinal()] = 9;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_SINGLE_PRESS_AND_HOLD.ordinal()] = 10;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_DOUBLE_PRESS.ordinal()] = 11;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_DOUBLE_PRESS_AND_HOLD.ordinal()] = 12;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_TRIPLE_PRESS.ordinal()] = 13;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_TRIPLE_PRESS_AND_HOLD.ordinal()] = 14;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_PRESSED.ordinal()] = 15;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_SINGLE_PRESS.ordinal()] = 16;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_SINGLE_PRESS_AND_HOLD.ordinal()] = 17;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_DOUBLE_PRESS.ordinal()] = 18;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_DOUBLE_PRESS_AND_HOLD.ordinal()] = 19;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_TRIPLE_PRESS.ordinal()] = 20;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_TRIPLE_PRESS_AND_HOLD.ordinal()] = 21;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.TRIPLE_PRESS.ordinal()] = 22;
            } catch (NoSuchFieldError e27) {
            }
        }
    }

    public enum Pusher {
        TOP_PUSHER("top"),
        MID_PUSHER("middle"),
        BOTTOM_PUSHER("bottom"),
        DOUBLE_TAP("double tap"),
        TRIPLE_TAP("triple tap");
        
        private String value;

        private Pusher(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }

        public static Pusher getPusherFromValue(String str) {
            for (Pusher pusher : values()) {
                if (pusher.getValue().equals(str)) {
                    return pusher;
                }
            }
            return TOP_PUSHER;
        }
    }

    public PusherConfiguration(Pusher pusher) {
        this.pusher = pusher;
    }

    public Pusher getPusher() {
        return this.pusher;
    }

    public static Pusher getPusherByGesture(Gesture gesture) {
        if (gesture != null) {
            switch (C47411.$SwitchMap$com$misfit$frameworks$common$enums$Gesture[gesture.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    return Pusher.TOP_PUSHER;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    return Pusher.MID_PUSHER;
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    return Pusher.BOTTOM_PUSHER;
                case 22:
                    return Pusher.TRIPLE_TAP;
            }
        }
        return Pusher.TOP_PUSHER;
    }

    public static Gesture getGestureWithLinkAction(Pusher pusher, int i) {
        MFLogger.d(TAG, "Get action of pusher=" + pusher);
        switch (pusher) {
            case TOP_PUSHER:
                switch (i) {
                    case 102:
                        return Gesture.SAM_BT1_DOUBLE_PRESS;
                    case 103:
                        return Gesture.SAM_BT1_SINGLE_PRESS_AND_HOLD;
                    case Selfie.TAKE_BURST /*202*/:
                        return Gesture.SAM_BT1_SINGLE_PRESS_AND_HOLD;
                    default:
                        if (DisplayMode.isActionBelongToThisType(i)) {
                            return Gesture.SAM_BT1_PRESSED;
                        }
                        return Gesture.SAM_BT1_SINGLE_PRESS;
                }
            case MID_PUSHER:
                switch (i) {
                    case 102:
                        return Gesture.SAM_BT2_DOUBLE_PRESS;
                    case 103:
                        return Gesture.SAM_BT2_SINGLE_PRESS_AND_HOLD;
                    case Selfie.TAKE_BURST /*202*/:
                        return Gesture.SAM_BT2_SINGLE_PRESS_AND_HOLD;
                    default:
                        if (DisplayMode.isActionBelongToThisType(i)) {
                            return Gesture.SAM_BT2_PRESSED;
                        }
                        return Gesture.SAM_BT2_SINGLE_PRESS;
                }
            case BOTTOM_PUSHER:
                switch (i) {
                    case 102:
                        return Gesture.SAM_BT3_DOUBLE_PRESS;
                    case 103:
                        return Gesture.SAM_BT3_SINGLE_PRESS_AND_HOLD;
                    case Selfie.TAKE_BURST /*202*/:
                        return Gesture.SAM_BT3_SINGLE_PRESS_AND_HOLD;
                    default:
                        if (DisplayMode.isActionBelongToThisType(i)) {
                            return Gesture.SAM_BT3_PRESSED;
                        }
                        return Gesture.SAM_BT3_SINGLE_PRESS;
                }
            case TRIPLE_TAP:
                return Gesture.TRIPLE_PRESS;
            default:
                MFLogger.d(TAG, "Error!!! Gesture is undefined");
                return Gesture.NONE;
        }
    }

    public static Gesture getGestureByPusher(Pusher pusher) {
        switch (pusher) {
            case TOP_PUSHER:
                return Gesture.SAM_BT1_SINGLE_PRESS;
            case MID_PUSHER:
                return Gesture.SAM_BT2_SINGLE_PRESS;
            case BOTTOM_PUSHER:
                return Gesture.SAM_BT3_SINGLE_PRESS;
            case TRIPLE_TAP:
                return Gesture.TRIPLE_PRESS;
            case DOUBLE_TAP:
                return Gesture.DOUBLE_PRESS;
            default:
                return Gesture.NONE;
        }
    }
}
