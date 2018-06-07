package com.fossil;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.DisplayMetrics;

@TargetApi(9)
class hc {
    static int m11555a(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    static int m11556b(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    static int m11557c(Resources resources) {
        return Math.min(m11556b(resources), m11555a(resources));
    }
}
