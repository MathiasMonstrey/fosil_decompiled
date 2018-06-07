package com.fossil;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

@TargetApi(9)
class ok {
    private static Field Zs;
    private static boolean Zt;
    private static Field Zu;
    private static boolean Zv;

    static int m12889b(TextView textView) {
        if (!Zv) {
            Zu = ab("mMaxMode");
            Zv = true;
        }
        if (Zu != null && m12888a(Zu, textView) == 1) {
            if (!Zt) {
                Zs = ab("mMaximum");
                Zt = true;
            }
            if (Zs != null) {
                return m12888a(Zs, textView);
            }
        }
        return -1;
    }

    private static Field ab(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatGingerbread", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    private static int m12888a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            Log.d("TextViewCompatGingerbread", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    static void m12890b(TextView textView, int i) {
        textView.setTextAppearance(textView.getContext(), i);
    }

    static Drawable[] m12891c(TextView textView) {
        return textView.getCompoundDrawables();
    }
}
