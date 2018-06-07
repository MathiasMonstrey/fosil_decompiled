package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class abl {
    private static final char[] aHe = "0123456789abcdef".toCharArray();
    private static final char[] aHf = new char[64];
    private static final char[] aHg = new char[40];

    static /* synthetic */ class C15591 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static String m2863M(byte[] bArr) {
        String a;
        synchronized (aHf) {
            a = m2864a(bArr, aHf);
        }
        return a;
    }

    private static String m2864a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = aHe[i2 >>> 4];
            cArr[(i * 2) + 1] = aHe[i2 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    public static int m2868p(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int m2867i(int i, int i2, Config config) {
        return (i * i2) * m2866c(config);
    }

    private static int m2866c(Config config) {
        if (config == null) {
            config = Config.ARGB_8888;
        }
        switch (C15591.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    public static boolean bg(int i, int i2) {
        return eQ(i) && eQ(i2);
    }

    private static boolean eQ(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static void wX() {
        if (!wZ()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void wY() {
        if (!xa()) {
            throw new IllegalArgumentException("YOu must call this method on a background thread");
        }
    }

    public static boolean wZ() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean xa() {
        return !wZ();
    }

    public static <T> Queue<T> eR(int i) {
        return new ArrayDeque(i);
    }

    public static <T> List<T> m2865a(Collection<T> collection) {
        List<T> arrayList = new ArrayList(collection.size());
        for (T add : collection) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
