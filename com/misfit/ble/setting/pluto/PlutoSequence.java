package com.misfit.ble.setting.pluto;

public class PlutoSequence {

    public static class LED {
        public static final short DEFAULT_SEQUENCE = (short) 0;
        private short bc;

        public short getValue() {
            return this.bc;
        }

        public LED(short s) {
            this.bc = s;
        }
    }

    public static class Sound {
        public static final short DEFAULT_SEQUENCE = (short) 1;
        private short bc;

        public short getValue() {
            return this.bc;
        }

        public Sound(short s) {
            this.bc = s;
        }
    }

    public static class Vibe {
        public static final short DEFAULT_SEQUENCE = (short) 3;
        private short bc;

        public short getValue() {
            return this.bc;
        }

        public Vibe(short s) {
            this.bc = s;
        }
    }
}
