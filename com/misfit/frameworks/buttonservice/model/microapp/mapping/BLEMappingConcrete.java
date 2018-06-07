package com.misfit.frameworks.buttonservice.model.microapp.mapping;

import com.misfit.frameworks.common.enums.Gesture;

public class BLEMappingConcrete extends BLEMapping {
    public Gesture getGesture() {
        return null;
    }

    public boolean isNeedStreaming() {
        return false;
    }

    public boolean isNeedHID() {
        return false;
    }

    protected String getHash() {
        return this.mType + "";
    }
}
