package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import com.fossil.pk.C3991j;

@TargetApi(9)
public class rk {
    final TextView als;
    private su alt;
    private su alu;
    private su alv;
    private su alw;

    public static rk m13353d(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new rl(textView);
        }
        return new rk(textView);
    }

    rk(TextView textView) {
        this.als = textView;
    }

    public void mo4072a(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = null;
        Context context = this.als.getContext();
        rg ou = rg.ou();
        sw a = sw.m13583a(context, attributeSet, C3991j.AppCompatTextHelper, i, 0);
        int resourceId = a.getResourceId(C3991j.AppCompatTextHelper_android_textAppearance, -1);
        if (a.hasValue(C3991j.AppCompatTextHelper_android_drawableLeft)) {
            this.alt = m13352a(context, ou, a.getResourceId(C3991j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a.hasValue(C3991j.AppCompatTextHelper_android_drawableTop)) {
            this.alu = m13352a(context, ou, a.getResourceId(C3991j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a.hasValue(C3991j.AppCompatTextHelper_android_drawableRight)) {
            this.alv = m13352a(context, ou, a.getResourceId(C3991j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a.hasValue(C3991j.AppCompatTextHelper_android_drawableBottom)) {
            this.alw = m13352a(context, ou, a.getResourceId(C3991j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a.recycle();
        boolean z3 = this.als.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (resourceId != -1) {
            sw a2 = sw.m13581a(context, resourceId, C3991j.TextAppearance);
            if (z3 || !a2.hasValue(C3991j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a2.getBoolean(C3991j.TextAppearance_textAllCaps, false);
                z = true;
            }
            if (VERSION.SDK_INT < 23) {
                if (a2.hasValue(C3991j.TextAppearance_android_textColor)) {
                    colorStateList = a2.getColorStateList(C3991j.TextAppearance_android_textColor);
                } else {
                    colorStateList = null;
                }
                if (a2.hasValue(C3991j.TextAppearance_android_textColorHint)) {
                    colorStateList2 = a2.getColorStateList(C3991j.TextAppearance_android_textColorHint);
                }
            } else {
                colorStateList = null;
            }
            a2.recycle();
        } else {
            colorStateList = null;
            z = false;
            z2 = false;
        }
        sw a3 = sw.m13583a(context, attributeSet, C3991j.TextAppearance, i, 0);
        if (!z3 && a3.hasValue(C3991j.TextAppearance_textAllCaps)) {
            z2 = a3.getBoolean(C3991j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (VERSION.SDK_INT < 23) {
            if (a3.hasValue(C3991j.TextAppearance_android_textColor)) {
                colorStateList = a3.getColorStateList(C3991j.TextAppearance_android_textColor);
            }
            if (a3.hasValue(C3991j.TextAppearance_android_textColorHint)) {
                colorStateList2 = a3.getColorStateList(C3991j.TextAppearance_android_textColorHint);
            }
        }
        a3.recycle();
        if (colorStateList != null) {
            this.als.setTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.als.setHintTextColor(colorStateList2);
        }
        if (!z3 && r0) {
            setAllCaps(z2);
        }
    }

    public void m13356q(Context context, int i) {
        sw a = sw.m13581a(context, i, C3991j.TextAppearance);
        if (a.hasValue(C3991j.TextAppearance_textAllCaps)) {
            setAllCaps(a.getBoolean(C3991j.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.hasValue(C3991j.TextAppearance_android_textColor)) {
            ColorStateList colorStateList = a.getColorStateList(C3991j.TextAppearance_android_textColor);
            if (colorStateList != null) {
                this.als.setTextColor(colorStateList);
            }
        }
        a.recycle();
    }

    public void setAllCaps(boolean z) {
        this.als.setTransformationMethod(z ? new pr(this.als.getContext()) : null);
    }

    public void oB() {
        if (this.alt != null || this.alu != null || this.alv != null || this.alw != null) {
            Drawable[] compoundDrawables = this.als.getCompoundDrawables();
            m13354a(compoundDrawables[0], this.alt);
            m13354a(compoundDrawables[1], this.alu);
            m13354a(compoundDrawables[2], this.alv);
            m13354a(compoundDrawables[3], this.alw);
        }
    }

    final void m13354a(Drawable drawable, su suVar) {
        if (drawable != null && suVar != null) {
            rg.m13325a(drawable, suVar, this.als.getDrawableState());
        }
    }

    protected static su m13352a(Context context, rg rgVar, int i) {
        ColorStateList n = rgVar.m13343n(context, i);
        if (n == null) {
            return null;
        }
        su suVar = new su();
        suVar.auW = true;
        suVar.auU = n;
        return suVar;
    }
}
