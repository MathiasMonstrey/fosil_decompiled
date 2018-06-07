package com.fossil;

import android.content.Context;
import com.fossil.cloudimagelib.Constants.Resolution;

public class arl {
    private static float density;

    public static void ac(Context context) {
        density = context.getResources().getDisplayMetrics().density;
    }

    public static Resolution Js() {
        if (density < 1.5f) {
            return Resolution.MDPI;
        }
        if (density >= 1.5f && density < 2.0f) {
            return Resolution.HDPI;
        }
        if (density < 2.0f || density >= 3.0f) {
            return Resolution.XXHDPI;
        }
        return Resolution.XHDPI;
    }
}
