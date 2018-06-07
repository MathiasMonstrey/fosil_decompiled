package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class cis {
    private static final ThreadLocal<SimpleDateFormat> ceo = new C20881();

    static class C20881 extends ThreadLocal<SimpleDateFormat> {
        C20881() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        }
    }

    public static float at(float f) {
        return Resources.getSystem().getDisplayMetrics().density * f;
    }

    public static void m6523a(List<? extends cih> list, float f, float f2, Paint paint) {
        float at = at(10.0f);
        for (cih com_fossil_cih : list) {
            if (!com_fossil_cih.Ys()) {
                Rect rect = new Rect();
                RectF Yr = com_fossil_cih.Yr();
                paint.getTextBounds(com_fossil_cih.Yo(), 0, com_fossil_cih.Yo().length(), rect);
                com_fossil_cih.m6506m(rect);
                float centerX = Yr.centerX();
                float width = centerX - ((float) (rect.width() / 2));
                float f3 = width - at;
                if (((float) rect.width()) + width > f2 - at) {
                    com_fossil_cih.bL(false);
                } else if (f3 >= f) {
                    com_fossil_cih.bL(true);
                    com_fossil_cih.jr((int) width);
                    f = centerX + ((float) (rect.width() / 2));
                } else if (f + at < Yr.left) {
                    com_fossil_cih.jr((int) (f + at));
                    com_fossil_cih.bL(true);
                    f = (f + at) + ((float) rect.width());
                } else {
                    com_fossil_cih.bL(false);
                }
            }
        }
    }

    public static float m6519a(Paint paint, String str) {
        Rect rect = new Rect();
        if (str == null) {
            str = "MgHITasger";
        }
        paint.getTextBounds(str, 0, str.length(), rect);
        return (float) rect.height();
    }

    public static float m6526b(Paint paint, String str) {
        Rect rect = new Rect();
        if (str == null) {
            str = "MgHITasger";
        }
        paint.getTextBounds(str, 0, str.length(), rect);
        return (float) rect.width();
    }

    public static boolean m6528b(RectF rectF, float f, float f2) {
        float width = rectF.width() * 2.0f;
        return f > rectF.left - width && f < width + rectF.right && f2 > rectF.top && f2 < rectF.bottom;
    }

    public static boolean m6525a(RectF rectF, float f, boolean z) {
        float width = rectF.width() * 2.0f;
        if (!z) {
            width = 0.0f;
        }
        return f > rectF.left - width && f < width + rectF.right;
    }

    public static boolean m6524a(RectF rectF, float f) {
        return f > rectF.left && f < rectF.right;
    }

    public static String ay(long j) {
        return new SimpleDateFormat("hh:mm a").format(new Date(j));
    }

    public static void m6522a(cik com_fossil_cik, cik com_fossil_cik2, cik com_fossil_cik3, float f, float f2) {
        float Yz = com_fossil_cik2.Yz() - com_fossil_cik.Yz();
        com_fossil_cik3.ar(((com_fossil_cik2.Yy() - com_fossil_cik.Yy()) * f) + com_fossil_cik.Yy());
        com_fossil_cik3.as(com_fossil_cik.Yz() + (Yz * f2));
    }

    public static float m6529d(float f, int i) {
        return ((float) Math.round(((double) f) * Math.pow(10.0d, (double) i))) / ((float) Math.pow(10.0d, (double) i));
    }

    public static int m6520a(long j, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTimeInMillis(j);
        return instance.get(12);
    }

    public static int m6527b(long j, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTimeInMillis(j);
        return instance.get(11);
    }

    public static String m6521a(Date date) {
        return ((SimpleDateFormat) ceo.get()).format(date);
    }

    public static float m6518a(float f, float f2, float f3, float f4, float f5) {
        float f6 = f - f3;
        float f7 = f2 - f4;
        return m6516A((float) Math.sqrt((double) ((f6 * f6) + (f7 * f7))), f5);
    }

    public static float m6516A(float f, float f2) {
        return f / f2;
    }

    public static int[] m6517E(Context context, int i) {
        return i == -1 ? null : context.getResources().getIntArray(i);
    }
}
