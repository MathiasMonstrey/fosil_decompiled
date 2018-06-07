package com.fossil;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.misfit.frameworks.common.constants.Constants;

public class wa {
    private final int aCW;
    private final int aCX;
    private final Context context;

    interface C4173b {
        int vp();

        int vq();
    }

    static class C4174a implements C4173b {
        private final DisplayMetrics aCY;

        public C4174a(DisplayMetrics displayMetrics) {
            this.aCY = displayMetrics;
        }

        public int vp() {
            return this.aCY.widthPixels;
        }

        public int vq() {
            return this.aCY.heightPixels;
        }
    }

    public wa(Context context) {
        this(context, (ActivityManager) context.getSystemService(Constants.ACTIVITY), new C4174a(context.getResources().getDisplayMetrics()));
    }

    wa(Context context, ActivityManager activityManager, C4173b c4173b) {
        this.context = context;
        int a = m13977a(activityManager);
        int vp = (c4173b.vp() * c4173b.vq()) * 4;
        int i = vp * 4;
        vp *= 2;
        if (vp + i <= a) {
            this.aCX = vp;
            this.aCW = i;
        } else {
            int round = Math.round(((float) a) / 6.0f);
            this.aCX = round * 2;
            this.aCW = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculated memory cache size: " + eH(this.aCX) + " pool size: " + eH(this.aCW) + " memory class limited? " + (vp + i > a) + " max size: " + eH(a) + " memoryClass: " + activityManager.getMemoryClass() + " isLowMemoryDevice: " + m13978b(activityManager));
        }
    }

    public int vn() {
        return this.aCX;
    }

    public int vo() {
        return this.aCW;
    }

    private static int m13977a(ActivityManager activityManager) {
        return Math.round((m13978b(activityManager) ? 0.33f : 0.4f) * ((float) ((activityManager.getMemoryClass() * 1024) * 1024)));
    }

    private String eH(int i) {
        return Formatter.formatFileSize(this.context, (long) i);
    }

    @TargetApi(19)
    private static boolean m13978b(ActivityManager activityManager) {
        if (VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return VERSION.SDK_INT < 11;
    }
}
