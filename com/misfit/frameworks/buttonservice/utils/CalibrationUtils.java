package com.misfit.frameworks.buttonservice.utils;

import com.misfit.ble.setting.sam.SAMEnum$HandID;
import com.misfit.ble.setting.sam.SAMEnum$HandMovingDirection;
import com.misfit.ble.setting.sam.SAMEnum$HandMovingSpeed;
import com.misfit.ble.setting.sam.SAMEnum$HandMovingType;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Direction;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.MovingType;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Speed;

public class CalibrationUtils {
    public static SAMEnum$HandID getCalibrationId(HandId handId) {
        switch (handId) {
            case HOUR:
                return SAMEnum$HandID.HOUR;
            case MINUTE:
                return SAMEnum$HandID.MINUTE;
            case SUB_EYE:
                return SAMEnum$HandID.SUB_EYE;
            default:
                return SAMEnum$HandID.HOUR;
        }
    }

    public static SAMEnum$HandMovingType getCalibrationMovingType(MovingType movingType) {
        switch (movingType) {
            case DISTANCE:
                return SAMEnum$HandMovingType.DISTANCE;
            case POSITION:
                return SAMEnum$HandMovingType.POSITION;
            default:
                return SAMEnum$HandMovingType.DISTANCE;
        }
    }

    public static SAMEnum$HandMovingSpeed getCalibrationSpeed(Speed speed) {
        switch (speed) {
            case FULL:
                return SAMEnum$HandMovingSpeed.FULL;
            case HALF:
                return SAMEnum$HandMovingSpeed.HALF;
            case SIXTEENTH:
                return SAMEnum$HandMovingSpeed.SIXTEENTH;
            case QUARTER:
                return SAMEnum$HandMovingSpeed.QUARTER;
            case EIGHTH:
                return SAMEnum$HandMovingSpeed.EIGHTH;
            default:
                return SAMEnum$HandMovingSpeed.FULL;
        }
    }

    public static SAMEnum$HandMovingDirection getCalibrationDirection(Direction direction) {
        switch (direction) {
            case CLOCKWISE:
                return SAMEnum$HandMovingDirection.CLOCKWISE;
            case COUNTER_CLOCKWISE:
                return SAMEnum$HandMovingDirection.COUNTER_CLOCKWISE;
            case SHORTEST_PATH:
                return SAMEnum$HandMovingDirection.SHORTEST_PATH;
            default:
                return SAMEnum$HandMovingDirection.SHORTEST_PATH;
        }
    }
}
