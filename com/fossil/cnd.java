package com.fossil;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;

public class cnd {
    private static int cyH = -1;

    public static SpannableString m7187a(String str, String str2, float f) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new RelativeSizeSpan(f), str.length(), str.length() + str2.length(), 0);
        return spannableString;
    }

    public static char gn(String str) {
        if (TextUtils.isEmpty(str)) {
            return '#';
        }
        char toUpperCase = Character.toUpperCase(str.charAt(0));
        if (Character.isAlphabetic(toUpperCase)) {
            return toUpperCase;
        }
        return '#';
    }
}
