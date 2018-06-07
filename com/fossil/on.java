package com.fossil;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

@TargetApi(18)
class on {
    public static void m12895a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static Drawable[] m12896c(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }
}
