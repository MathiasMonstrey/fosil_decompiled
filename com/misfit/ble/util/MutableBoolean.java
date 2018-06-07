package com.misfit.ble.util;

import com.misfit.ble.obfuscated.he;

public class MutableBoolean extends he<Boolean> {
    public MutableBoolean(Boolean bool) {
        super(bool);
    }

    public boolean getValue() {
        return ((Boolean) this.nU).booleanValue();
    }

    public void setValue(boolean z) {
        this.nU = Boolean.valueOf(z);
    }
}
