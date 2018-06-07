package com.fossil;

import android.annotation.TargetApi;
import android.view.MenuItem;
import android.view.View;

@TargetApi(11)
class kq {
    public static void m12032a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m12031a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static MenuItem m12033b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    public static View m12034c(MenuItem menuItem) {
        return menuItem.getActionView();
    }
}
