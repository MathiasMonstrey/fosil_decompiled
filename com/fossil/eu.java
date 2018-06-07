package com.fossil;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;

@TargetApi(18)
class eu {
    public static IBinder m11206a(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    public static void m11207a(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
