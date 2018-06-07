package com.fossil;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.fossil.arv.C1873a;
import com.fossil.arv.C1874b;
import com.fossil.arv.C1875c;

public final class awi extends Button {
    public awi(Context context) {
        this(context, null);
    }

    private awi(Context context, AttributeSet attributeSet) {
        super(context, null, 16842824);
    }

    private static int m4645t(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    public final void m4646a(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
        int t = m4645t(i2, C1874b.common_google_signin_btn_icon_dark, C1874b.common_google_signin_btn_icon_light, C1874b.common_google_signin_btn_icon_light);
        int t2 = m4645t(i2, C1874b.common_google_signin_btn_text_dark, C1874b.common_google_signin_btn_text_light, C1874b.common_google_signin_btn_text_light);
        switch (i) {
            case 0:
            case 1:
                break;
            case 2:
                t2 = t;
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        Drawable i3 = hh.m11635i(resources.getDrawable(t2));
        hh.m11623a(i3, resources.getColorStateList(C1873a.common_google_signin_btn_tint));
        hh.m11626a(i3, Mode.SRC_ATOP);
        setBackgroundDrawable(i3);
        setTextColor((ColorStateList) awa.bO(resources.getColorStateList(m4645t(i2, C1873a.common_google_signin_btn_text_dark, C1873a.common_google_signin_btn_text_light, C1873a.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C1875c.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C1875c.common_signin_button_text_long));
                break;
            case 2:
                setText(null);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod(null);
        if (axo.as(getContext())) {
            setGravity(19);
        }
    }
}
