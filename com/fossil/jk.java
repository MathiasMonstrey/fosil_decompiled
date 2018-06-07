package com.fossil;

import android.annotation.TargetApi;
import android.text.TextUtils;
import java.util.Locale;

@TargetApi(17)
class jk {
    public static int getLayoutDirectionFromLocale(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
