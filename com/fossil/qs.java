package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class qs {
    public static Menu m13208a(Context context, hu huVar) {
        if (VERSION.SDK_INT >= 14) {
            return new qt(context, huVar);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m13209a(Context context, hv hvVar) {
        if (VERSION.SDK_INT >= 16) {
            return new qn(context, hvVar);
        }
        if (VERSION.SDK_INT >= 14) {
            return new qm(context, hvVar);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m13210a(Context context, hw hwVar) {
        if (VERSION.SDK_INT >= 14) {
            return new qx(context, hwVar);
        }
        throw new UnsupportedOperationException();
    }
}
