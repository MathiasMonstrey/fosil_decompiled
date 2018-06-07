package com.fossil;

import android.annotation.TargetApi;
import android.view.View;
import android.widget.PopupWindow;

@TargetApi(19)
class oc {
    public static void m12866a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        popupWindow.showAsDropDown(view, i, i2, i3);
    }
}
