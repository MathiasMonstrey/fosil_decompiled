package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.util.Log;

public final class avw {
    private static Object bhH = new Object();
    private static boolean bhI;
    private static String bhJ;
    private static int bhK;

    public static String ao(Context context) {
        aq(context);
        return bhJ;
    }

    public static int ap(Context context) {
        aq(context);
        return bhK;
    }

    private static void aq(Context context) {
        synchronized (bhH) {
            if (bhI) {
                return;
            }
            bhI = true;
            try {
                Bundle bundle = bje.aQ(context).getApplicationInfo(context.getPackageName(), Allocation.USAGE_SHARED).metaData;
                if (bundle == null) {
                    return;
                }
                bhJ = bundle.getString("com.google.app.id");
                bhK = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
