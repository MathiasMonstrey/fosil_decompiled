package com.fossil;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Pattern;

public class dra {
    public static boolean m9453v(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    public static boolean m9454w(CharSequence charSequence) {
        return Pattern.compile("((?=.*\\d)(?=.*[a-zA-Z]).{7,20})").matcher(charSequence).matches();
    }
}
