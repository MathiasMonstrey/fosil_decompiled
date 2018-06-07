package com.misfit.frameworks.common.enums;

public class Action {

    public static class ActivityTracker {
        public static final int TAG_ACTIVITY = 402;
        public static final int TIME_PROGRESS = 401;

        public static boolean isActionBelongToThisType(int i) {
            return i == 401 || i == TAG_ACTIVITY;
        }
    }

    public static class Apps {
        public static final int BOLT = 501;
        public static final int HARMONY = 504;
        public static final int IF = 502;
        public static final int RING_MY_PHONE = 505;
        public static final int YO = 503;

        public static boolean isActionBelongToThisType(int i) {
            return i == BOLT || i == IF || i == 503 || i == RING_MY_PHONE;
        }
    }

    public static class Bolt {
        public static final int BOLT_END_ACTION = 699;
        public static final int BOLT_START_ACTION = 600;
        public static final int CHANGE_BRIGHTNESS = 601;
        public static final int TURN_OFF = 602;

        public static boolean isActionBelongToThisType(int i) {
            return i == 600 || i == 601 || i == TURN_OFF;
        }
    }

    public static class DisplayAction {
        private static Integer[] DISPLAY_ACTIONS = new Integer[]{Integer.valueOf(DisplayMode.ACTIVITY), Integer.valueOf(DisplayMode.DATE), Integer.valueOf(DisplayMode.NOTIFICATION), Integer.valueOf(DisplayMode.SECOND_TIMEZONE), Integer.valueOf(DisplayMode.TOGGLE_MODE), Integer.valueOf(DisplayMode.ALARM), Integer.valueOf(DisplayMode.COUNT_DOWN), Integer.valueOf(DisplayMode.STOP_WATCH)};

        public static boolean isActionBelongToThisType(int i) {
            for (Integer intValue : DISPLAY_ACTIONS) {
                if (intValue.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class DisplayMode {
        public static final int ACTIVITY = 2001;
        public static final int ALARM = 2005;
        public static final int COUNT_DOWN = 2008;
        public static final int DATE = 2003;
        public static final int NOTIFICATION = 2002;
        public static final int SECOND_TIMEZONE = 2004;
        public static final int STOP_WATCH = 2007;
        public static final int TOGGLE_MODE = 2006;

        public static boolean isActionBelongToThisType(int i) {
            return i == ACTIVITY || i == NOTIFICATION || i == DATE || i == SECOND_TIMEZONE || i == ALARM || i == TOGGLE_MODE || i == STOP_WATCH || i == COUNT_DOWN;
        }
    }

    public static class GoalTracking {
        public static final int GOAL_TRACKING = 1000;

        public static boolean isActionBelongToThisType(int i) {
            return i == 1000;
        }
    }

    public static class HIDAction {
        public static Integer[] HID_ACTIONS = new Integer[]{Integer.valueOf(101), Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(201), Integer.valueOf(Selfie.TAKE_BURST)};

        public static boolean isActionBelongToThisType(int i) {
            for (Integer intValue : HID_ACTIONS) {
                if (intValue.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class MicroAppAction {
        public static final int SEVEN_MINUTE_WORKOUT = 3103;
        public static final int SHOW_COMMUTE = 3002;
        public static final int SHOW_TEMPERATURE = 3001;

        public static boolean isActionBelongToThisType(int i) {
            return i == 3001 || i == SHOW_COMMUTE || i == SEVEN_MINUTE_WORKOUT;
        }
    }

    public static class Music {
        public static final int MUSIC_END_ACTION = 199;
        public static final int NEXT = 102;
        public static final int PLAY = 101;
        public static final int PREVIOUS = 103;
        public static final int VOLUMN_DOWN = 105;
        public static final int VOLUMN_UP = 104;

        public static boolean isActionBelongToThisType(int i) {
            return i == 101 || i == 102 || i == 103 || i == 104 || i == 105;
        }
    }

    public static class Presenter {
        public static final int BLACKOUT = 303;
        public static final int NEXT = 301;
        public static final int PREVIOUS = 302;

        public static boolean isActionBelongToThisType(int i) {
            return i == NEXT || i == PREVIOUS || i == BLACKOUT;
        }
    }

    public static class Selfie {
        public static final int SELFIE_END_ACTION = 299;
        public static final int TAKE_BURST = 202;
        public static final int TAKE_ONE = 201;

        public static boolean isActionBelongToThisType(int i) {
            return i == 201 || i == TAKE_BURST;
        }
    }

    public static class StreamingAction {
        private static Integer[] STREAMING_ACTIONS = new Integer[]{Integer.valueOf(Apps.RING_MY_PHONE), Integer.valueOf(MicroAppAction.SHOW_COMMUTE), Integer.valueOf(3001), Integer.valueOf(MicroAppAction.SEVEN_MINUTE_WORKOUT)};

        public static boolean isActionBelongToThisType(int i) {
            for (Integer intValue : STREAMING_ACTIONS) {
                if (intValue.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
    }
}
