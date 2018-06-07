package com.fossil;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class cmy {
    public static void m7168a(View view, Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
