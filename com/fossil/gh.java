package com.fossil;

import android.app.Activity;

public class gh extends Activity {
    private jv<Class<? extends C3623a>, C3623a> mExtraDataMap = new jv();

    public static class C3623a {
    }

    public void putExtraData(C3623a c3623a) {
        this.mExtraDataMap.put(c3623a.getClass(), c3623a);
    }

    public <T extends C3623a> T getExtraData(Class<T> cls) {
        return (C3623a) this.mExtraDataMap.get(cls);
    }
}
