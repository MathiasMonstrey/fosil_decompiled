package com.fossil;

import android.text.TextUtils;

public abstract class apj {
    protected String aWX = "com.flurry.android.sdk.ReplaceMeWithAProperEventName";

    public apj(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Event must have a name!");
        }
        this.aWX = str;
    }

    public final String Ik() {
        return this.aWX;
    }

    public final void HO() {
        apl.IW().m4167a(this);
    }
}
