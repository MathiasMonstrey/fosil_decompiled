package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.fossil.pk.C3991j;

@TargetApi(17)
class rl extends rk {
    private su alx;
    private su aly;

    rl(TextView textView) {
        super(textView);
    }

    void mo4072a(AttributeSet attributeSet, int i) {
        super.mo4072a(attributeSet, i);
        Context context = this.als.getContext();
        rg ou = rg.ou();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3991j.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(C3991j.AppCompatTextHelper_android_drawableStart)) {
            this.alx = rk.m13352a(context, ou, obtainStyledAttributes.getResourceId(C3991j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(C3991j.AppCompatTextHelper_android_drawableEnd)) {
            this.aly = rk.m13352a(context, ou, obtainStyledAttributes.getResourceId(C3991j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
    }

    void oB() {
        super.oB();
        if (this.alx != null || this.aly != null) {
            Drawable[] compoundDrawablesRelative = this.als.getCompoundDrawablesRelative();
            m13354a(compoundDrawablesRelative[0], this.alx);
            m13354a(compoundDrawablesRelative[2], this.aly);
        }
    }
}
