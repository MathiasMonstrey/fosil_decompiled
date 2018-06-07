package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.widget.TextView;
import java.util.Locale;

public class arp {
    private static final String TAG = ("Localization_" + arp.class.getSimpleName());

    public static Locale getLocale() {
        return Resources.getSystem().getConfiguration().locale;
    }

    public static String Jx() {
        return Resources.getSystem().getConfiguration().locale.toString();
    }

    public static void m4317c(TextView textView, int i) {
        if (textView != null && i != 0) {
            CharSequence u = m4318u(textView.getContext(), i);
            if (u == null || u.equals("")) {
                textView.setText(u);
            } else {
                textView.setText(u);
            }
        }
    }

    public static String m4318u(Context context, int i) {
        if (context == null || i == 0) {
            return "";
        }
        String str = "";
        try {
            str = context.getResources().getResourceEntryName(i);
            if (str == null || str.equals("")) {
                return "";
            }
            str = aro.Jw().cK(str);
            if (str == null || str.equals("")) {
                str = context.getResources().getString(i);
            }
            return str == null ? "" : str;
        } catch (NotFoundException e) {
            return "";
        }
    }
}
