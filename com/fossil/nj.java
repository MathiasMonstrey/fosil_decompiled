package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.CompoundButton;

@TargetApi(21)
class nj {
    static void m12767a(CompoundButton compoundButton, ColorStateList colorStateList) {
        compoundButton.setButtonTintList(colorStateList);
    }

    static void m12768a(CompoundButton compoundButton, Mode mode) {
        compoundButton.setButtonTintMode(mode);
    }
}
