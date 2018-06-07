package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public interface op {
    ColorStateList getSupportImageTintList();

    Mode getSupportImageTintMode();

    void setSupportImageTintList(ColorStateList colorStateList);

    void setSupportImageTintMode(Mode mode);
}
