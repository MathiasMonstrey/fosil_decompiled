package com.misfit.frameworks.buttonservice.model;

import com.misfit.frameworks.common.enums.Action.DisplayAction;
import com.misfit.frameworks.common.enums.Action.GoalTracking;
import com.misfit.frameworks.common.enums.Action.HIDAction;
import com.misfit.frameworks.common.enums.Action.StreamingAction;
import java.util.List;

public enum MicroAppMode {
    UNKNOWN,
    HID,
    STREAMING,
    GOAL_TRACKING,
    DISPLAY_ACTION;

    public static MicroAppMode fromAction(int i) {
        MicroAppMode microAppMode = UNKNOWN;
        if (HIDAction.isActionBelongToThisType(i)) {
            return HID;
        }
        if (StreamingAction.isActionBelongToThisType(i)) {
            return STREAMING;
        }
        if (GoalTracking.isActionBelongToThisType(i)) {
            return GOAL_TRACKING;
        }
        if (DisplayAction.isActionBelongToThisType(i)) {
            return DISPLAY_ACTION;
        }
        return microAppMode;
    }

    public static MicroAppMode fromMappings(List<Mapping> list) {
        MicroAppMode microAppMode = UNKNOWN;
        if (list == null || list.size() == 0) {
            return UNKNOWN;
        }
        return fromAction(((Mapping) list.get(0)).getAction());
    }
}
