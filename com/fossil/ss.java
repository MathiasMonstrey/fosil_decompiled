package com.fossil;

import android.content.res.Resources.Theme;
import android.widget.SpinnerAdapter;

public interface ss extends SpinnerAdapter {
    Theme getDropDownViewTheme();

    void setDropDownViewTheme(Theme theme);
}
