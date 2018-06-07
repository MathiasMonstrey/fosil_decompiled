package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

public class gn {
    private static final Object Mv = new Object();
    private static TypedValue Mw;

    public static boolean m10629a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            gs.m11532b(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            gr.m11531a(context, intentArr);
            return true;
        }
    }

    public static File[] m10630a(Context context, String str) {
        if (VERSION.SDK_INT >= 19) {
            return gt.m11533a(context, str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    public static File[] m10635n(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return gt.m11534n(context);
        }
        return new File[]{context.getExternalCacheDir()};
    }

    public static final Drawable m10632c(Context context, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            return go.m11527c(context, i);
        }
        if (i2 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (Mv) {
            if (Mw == null) {
                Mw = new TypedValue();
            }
            context.getResources().getValue(i, Mw, true);
            i2 = Mw.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static final ColorStateList m10633d(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return gp.m11528d(context, i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static final int m10634e(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return gp.m11529e(context, i);
        }
        return context.getResources().getColor(i);
    }

    public static int m10631b(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static boolean m10636o(Context context) {
        if (it.ji()) {
            return gq.m11530o(context);
        }
        return false;
    }
}
