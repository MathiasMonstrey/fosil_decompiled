package com.misfit.ble.setting.qmotion;

public class QMotionEnum {

    public enum LEDColor {
        BLUE((short) 0),
        YELLOW((short) 1),
        ORANGE((short) 2),
        PURPLE((short) 3),
        GREEN((short) 4),
        PINK((short) 5);
        
        private final short bd;

        private LEDColor(short s) {
            this.bd = (short) ((byte) s);
        }

        public short getId() {
            return this.bd;
        }
    }
}
