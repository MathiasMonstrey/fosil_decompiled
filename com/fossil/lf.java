package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public interface lf {
    ColorStateList getSupportBackgroundTintList();

    Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(Mode mode);
}
