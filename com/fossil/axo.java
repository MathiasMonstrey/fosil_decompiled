package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;

public final class axo {
    private static Boolean bja;
    private static Boolean bjb;
    private static Boolean bjc;

    @TargetApi(20)
    public static boolean as(Context context) {
        if (bja == null) {
            boolean z = axt.LI() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            bja = Boolean.valueOf(z);
        }
        return bja.booleanValue();
    }

    @TargetApi(24)
    public static boolean at(Context context) {
        return (!axt.ji() || au(context)) && as(context);
    }

    @TargetApi(21)
    public static boolean au(Context context) {
        if (bjb == null) {
            boolean z = axt.LJ() && context.getPackageManager().hasSystemFeature("cn.google");
            bjb = Boolean.valueOf(z);
        }
        return bjb.booleanValue();
    }

    public static boolean av(Context context) {
        if (bjc == null) {
            boolean z = context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded");
            bjc = Boolean.valueOf(z);
        }
        return bjc.booleanValue();
    }
}
