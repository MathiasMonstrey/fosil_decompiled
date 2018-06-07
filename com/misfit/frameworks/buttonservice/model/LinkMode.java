package com.misfit.frameworks.buttonservice.model;

import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.common.enums.Action.GoalTracking;
import com.misfit.frameworks.common.enums.Action.Music;
import com.misfit.frameworks.common.enums.Action.Selfie;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum LinkMode implements Serializable {
    RING_PHONE {
        public boolean isHidMode() {
            return false;
        }
    },
    CONTROL_MUSIC {
        public boolean isHidMode() {
            return true;
        }
    },
    TAKE_PHOTO {
        public boolean isHidMode() {
            return true;
        }
    },
    GOAL_TRACKING {
        public boolean isHidMode() {
            return false;
        }
    };

    public abstract boolean isHidMode();

    public static LinkMode fromAction(int i) {
        if (Music.isActionBelongToThisType(i)) {
            return CONTROL_MUSIC;
        }
        if (Selfie.isActionBelongToThisType(i)) {
            return TAKE_PHOTO;
        }
        if (GoalTracking.isActionBelongToThisType(i)) {
            return GOAL_TRACKING;
        }
        return RING_PHONE;
    }

    public static LinkMode fromLinkMappings(List<LinkMapping> list) {
        if (list == null || list.isEmpty()) {
            return RING_PHONE;
        }
        return fromAction(((LinkMapping) list.get(0)).getAction());
    }

    public static LinkMode fromMappings(List<Mapping> list) {
        if (list == null || list.isEmpty()) {
            return RING_PHONE;
        }
        return fromAction(((Mapping) list.get(0)).getAction());
    }

    public static List<LinkMode> getLinkModesFromMappings(List<Mapping> list) {
        HashMap hashMap = new HashMap();
        if (!(list == null || list.isEmpty())) {
            for (Mapping action : list) {
                int action2 = action.getAction();
                hashMap.put(fromAction(action2), Integer.valueOf(action2));
            }
        }
        return new ArrayList(hashMap.keySet());
    }

    public static boolean hasLinkModeInMappings(List<Mapping> list, LinkMode linkMode) {
        if (!(list == null || list.isEmpty())) {
            for (Mapping action : list) {
                if (fromAction(action.getAction()) == linkMode) {
                    return true;
                }
            }
        }
        return false;
    }
}
