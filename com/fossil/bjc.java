package com.fossil;

import android.content.Context;
import android.content.pm.PackageManager;
import java.lang.reflect.InvocationTargetException;

public final class bjc {
    private static Context bvQ;
    private static Boolean bvR;

    public static synchronized boolean aO(Context context) {
        boolean booleanValue;
        synchronized (bjc.class) {
            Context applicationContext = context.getApplicationContext();
            if (bvQ == null || bvR == null || bvQ != applicationContext) {
                bvR = null;
                if (axt.LK()) {
                    try {
                        bvR = (Boolean) PackageManager.class.getDeclaredMethod("isInstantApp", new Class[0]).invoke(applicationContext.getPackageManager(), new Object[0]);
                    } catch (NoSuchMethodException e) {
                        bvR = Boolean.valueOf(false);
                        bvQ = applicationContext;
                        booleanValue = bvR.booleanValue();
                        return booleanValue;
                    } catch (InvocationTargetException e2) {
                        bvR = Boolean.valueOf(false);
                        bvQ = applicationContext;
                        booleanValue = bvR.booleanValue();
                        return booleanValue;
                    } catch (IllegalAccessException e3) {
                        bvR = Boolean.valueOf(false);
                        bvQ = applicationContext;
                        booleanValue = bvR.booleanValue();
                        return booleanValue;
                    }
                }
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    bvR = Boolean.valueOf(true);
                } catch (ClassNotFoundException e4) {
                    bvR = Boolean.valueOf(false);
                }
                bvQ = applicationContext;
                booleanValue = bvR.booleanValue();
            } else {
                booleanValue = bvR.booleanValue();
            }
        }
        return booleanValue;
    }
}
