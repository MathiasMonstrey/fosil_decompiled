package com.fossil;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

@TargetApi(17)
class om {
    public static void m12893a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Drawable drawable5;
        Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
        if (obj != null) {
            drawable5 = drawable3;
        } else {
            drawable5 = drawable;
        }
        if (obj == null) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }

    public static Drawable[] m12894c(TextView textView) {
        int i = 1;
        if (textView.getLayoutDirection() != 1) {
            i = 0;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (i != 0) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }
}
