package com.misfit.frameworks.buttonservice.model;

public class CalibrationEnums {

    public enum Direction {
        CLOCKWISE(1),
        COUNTER_CLOCKWISE(2),
        SHORTEST_PATH(3);
        
        private final int value;

        public static Direction fromValue(int i) {
            for (Direction direction : values()) {
                if (direction.getValue() == i) {
                    return direction;
                }
            }
            return SHORTEST_PATH;
        }

        private Direction(int i) {
            this.value = (byte) i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum HandId {
        HOUR(1),
        MINUTE(2),
        SUB_EYE(3),
        COMPLETE(4);
        
        private final int value;

        public static HandId fromValue(int i) {
            for (HandId handId : values()) {
                if (handId.getValue() == i) {
                    return handId;
                }
            }
            return HOUR;
        }

        private HandId(int i) {
            this.value = (byte) i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum MovingType {
        DISTANCE(1),
        POSITION(2);
        
        private final int value;

        public static MovingType fromValue(int i) {
            for (MovingType movingType : values()) {
                if (movingType.getValue() == i) {
                    return movingType;
                }
            }
            return DISTANCE;
        }

        private MovingType(int i) {
            this.value = (byte) i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum Speed {
        FULL(1),
        HALF(2),
        QUARTER(3),
        EIGHTH(4),
        SIXTEENTH(5);
        
        private final int value;

        public static Speed fromValue(int i) {
            for (Speed speed : values()) {
                if (speed.getValue() == i) {
                    return speed;
                }
            }
            return FULL;
        }

        private Speed(int i) {
            this.value = (byte) i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
