package com.misfit.ble.setting.sam;

public class SAMEnum {
    public static final short VIBE_STRENGTH_LEVEL_MEDIUM = (short) 75;
    public static final short VIBE_STRENGTH_LEVEL_NONE = (short) 0;
    public static final short VIBE_STRENGTH_LEVEL_STRONG = (short) 100;
    public static final short VIBE_STRENGTH_LEVEL_TICKLE = (short) 25;
    public static final short VIBE_STRENGTH_LEVEL_WEAK = (short) 50;

    public enum VibeEnum {
        CALL(1),
        TEXT(2),
        EMAIL(3),
        OTHERS(4),
        SINGLE_SHORT_VIBE(5),
        DOUBLE_SHORT_VIBE(6),
        TRIPLE_SHORT_VIBE(7),
        SINGLE_LONG_VIBE(8),
        NO_VIBE(9);
        
        private final byte ax;

        private VibeEnum(int i) {
            this.ax = (byte) i;
        }

        public byte getId() {
            return this.ax;
        }
    }
}
