package com.misfit.ble.setting.flashlink;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EventMappingEnum {

    public enum AnimNumber {
        NO_ANIMATION(0),
        SUCCESS(11),
        ERROR(12),
        SINGLE_CLICK_SUCCEEDED(20),
        DOUBLE_CLICK_SUCCEEDED(15),
        TRIPLE_PRESS_SUCCEEDED(16),
        LONG_PRESS_SUCCEEDED(21),
        DOUBLE_PRESS_N_HOLD_SUCCEEDED(22),
        SINGLE_CLICK_RECEIVED(17),
        DOUBLE_CLICK_RECEIVED(13),
        TRIPLE_CLICK_RECEIVED(14),
        LONG_PRESS_RECEIVED(18),
        DOUBLE_PRESS_N_HOLD_RECEIVED(19),
        BATTERY_LEVEL(23);
        
        private final byte ax;

        private AnimNumber(int i) {
            this.ax = (byte) i;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum KeyCode {
        KB_KEY_RIGHT(79),
        KB_KEY_LEFT(80),
        KB_B(5),
        KB_W(26),
        MEDIA_PLAY_PAUSE(205),
        MEDIA_VOLUME_UP_OR_SELFIE(233),
        MEDIA_VOLUME_DOWN(234),
        MEDIA_NEXT_SONG(181),
        MEDIA_PREVIOUS_SONG(182);
        
        private final byte ax;

        private KeyCode(int i) {
            this.ax = (byte) i;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum MemEventNumber {
        NO_EVENT(0),
        CONSUMED(1),
        TIMED_OUT(2),
        END_OF_ANIMATION(3),
        END_OF_SEQUENCE(4),
        CONNECTION_CLOSE(5),
        PRESS(10),
        RELEASE_AFTER_SHORT_PRESS(11),
        RELEASE_AFTER_LONG_PRESS(13),
        SINGLE_CLICK(19),
        DOUBLE_CLICK(20),
        TRIPLE_CLICK(21),
        LONG_PRESS(12),
        DOUBLE_PRESS_N_HOLD(22),
        TRIPLE_PRESS_N_HOLD(23),
        PLUTO_TRIPLE_TAP(12),
        SILVRETTA_DOUBLE_TAP(20),
        SILVRETTA_TRIPLE_TAP(12),
        SILVRETTA_QUAD_TAP(24),
        BUTTON1_PRESSED(42),
        BUTTON2_PRESSED(43),
        BUTTON3_PRESSED(44),
        EVENT_TYPE_BUTTON1_SINGLE_PRESS(48),
        EVENT_TYPE_BUTTON1_SINGLE_PRESS_AND_HOLD(49),
        EVENT_TYPE_BUTTON1_DOUBLE_PRESS(50),
        EVENT_TYPE_BUTTON1_DOUBLE_PRESS_AND_HOLD(51),
        EVENT_TYPE_BUTTON1_TRIPLE_PRESS(52),
        EVENT_TYPE_BUTTON1_TRIPLE_PRESS_AND_HOLD(53),
        EVENT_TYPE_BUTTON1_HOLD_RELEASED(54),
        EVENT_TYPE_BUTTON2_SINGLE_PRESS(56),
        EVENT_TYPE_BUTTON2_SINGLE_PRESS_AND_HOLD(57),
        EVENT_TYPE_BUTTON2_DOUBLE_PRESS(58),
        EVENT_TYPE_BUTTON2_DOUBLE_PRESS_AND_HOLD(59),
        EVENT_TYPE_BUTTON2_TRIPLE_PRESS(60),
        EVENT_TYPE_BUTTON2_TRIPLE_PRESS_AND_HOLD(61),
        EVENT_TYPE_BUTTON2_HOLD_RELEASED(62),
        EVENT_TYPE_BUTTON3_SINGLE_PRESS(64),
        EVENT_TYPE_BUTTON3_SINGLE_PRESS_AND_HOLD(65),
        EVENT_TYPE_BUTTON3_DOUBLE_PRESS(66),
        EVENT_TYPE_BUTTON3_DOUBLE_PRESS_AND_HOLD(67),
        EVENT_TYPE_BUTTON3_TRIPLE_PRESS(68),
        EVENT_TYPE_BUTTON3_TRIPLE_PRESS_AND_HOLD(69),
        EVENT_TYPE_BUTTON3_HOLD_RELEASED(70);
        
        private static final Map<Byte, MemEventNumber> aD = null;
        private final byte ax;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(MemEventNumber.class).iterator();
            while (it.hasNext()) {
                MemEventNumber memEventNumber = (MemEventNumber) it.next();
                aD.put(Byte.valueOf(memEventNumber.getId()), memEventNumber);
            }
        }

        private MemEventNumber(int i) {
            this.ax = (byte) i;
        }

        public static MemEventNumber get(byte b) {
            return (MemEventNumber) aD.get(Byte.valueOf(b));
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum ModeDisplay {
        DATE(0),
        TIME_ONE(1),
        TIME_TWO(2),
        ALERT(3),
        ALARM(4),
        TWENTY_FOUR_HOUR(5),
        TWELVE_HOUR(6),
        NO_MODE(7),
        PROGRESS(8),
        SECONDS(9),
        COUNTDOWN(10),
        DEFAULTS(11),
        SEQUENCED_MODES(12),
        STOP_WATCH(13),
        DIAL_SPIN(14),
        MODE_TYPE_ERROR(255);
        
        private final byte ax;

        private ModeDisplay(int i) {
            this.ax = (byte) i;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum OperationType {
        APP_TYPE_1(23),
        APP_TYPE_2(39),
        APP_TYPE_3(40),
        UNMAP_ONE_BUTTON(50),
        TRACKER(64),
        GOAL_TRACKING(65),
        BOLT_AUTO(96),
        BOLT_LEVEL(97),
        BOLT_ITERATE(98),
        HID_KEYBOARD(80),
        HID_MEDIA(81),
        MODE_DISPLAY(114);
        
        private final byte ax;

        private OperationType(int i) {
            this.ax = (byte) i;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum StopWatchSecondHand {
        HOUR(1),
        MINUTE(2);
        
        private static final Map<Byte, StopWatchSecondHand> aD = null;
        private final byte ax;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(StopWatchSecondHand.class).iterator();
            while (it.hasNext()) {
                StopWatchSecondHand stopWatchSecondHand = (StopWatchSecondHand) it.next();
                aD.put(Byte.valueOf(stopWatchSecondHand.getId()), stopWatchSecondHand);
            }
        }

        private StopWatchSecondHand(int i) {
            this.ax = (byte) i;
        }

        public static StopWatchSecondHand get(byte b) {
            return (StopWatchSecondHand) aD.get(Byte.valueOf(b));
        }

        public byte getId() {
            return this.ax;
        }
    }

    public enum C4601a {
        NONE(0),
        BUTTON_ONE(1),
        BUTTON_TWO(2),
        BUTTON_THREE(3);
        
        private final byte ax;

        private C4601a(int i) {
            this.ax = (byte) i;
        }

        public byte getId() {
            return this.ax;
        }

        public static C4601a m15238a(MemEventNumber memEventNumber) {
            if (memEventNumber == null) {
                return NONE;
            }
            switch (memEventNumber) {
                case BUTTON1_PRESSED:
                case EVENT_TYPE_BUTTON1_SINGLE_PRESS:
                case EVENT_TYPE_BUTTON1_SINGLE_PRESS_AND_HOLD:
                case EVENT_TYPE_BUTTON1_DOUBLE_PRESS:
                case EVENT_TYPE_BUTTON1_DOUBLE_PRESS_AND_HOLD:
                case EVENT_TYPE_BUTTON1_TRIPLE_PRESS:
                case EVENT_TYPE_BUTTON1_TRIPLE_PRESS_AND_HOLD:
                case EVENT_TYPE_BUTTON1_HOLD_RELEASED:
                    return BUTTON_ONE;
                case BUTTON2_PRESSED:
                case EVENT_TYPE_BUTTON2_SINGLE_PRESS:
                case EVENT_TYPE_BUTTON2_SINGLE_PRESS_AND_HOLD:
                case EVENT_TYPE_BUTTON2_DOUBLE_PRESS:
                case EVENT_TYPE_BUTTON2_DOUBLE_PRESS_AND_HOLD:
                case EVENT_TYPE_BUTTON2_TRIPLE_PRESS:
                case EVENT_TYPE_BUTTON2_TRIPLE_PRESS_AND_HOLD:
                case EVENT_TYPE_BUTTON2_HOLD_RELEASED:
                    return BUTTON_TWO;
                case BUTTON3_PRESSED:
                case EVENT_TYPE_BUTTON3_SINGLE_PRESS:
                case EVENT_TYPE_BUTTON3_SINGLE_PRESS_AND_HOLD:
                case EVENT_TYPE_BUTTON3_DOUBLE_PRESS:
                case EVENT_TYPE_BUTTON3_DOUBLE_PRESS_AND_HOLD:
                case EVENT_TYPE_BUTTON3_TRIPLE_PRESS:
                case EVENT_TYPE_BUTTON3_TRIPLE_PRESS_AND_HOLD:
                case EVENT_TYPE_BUTTON3_HOLD_RELEASED:
                    return BUTTON_THREE;
                default:
                    return NONE;
            }
        }
    }
}
