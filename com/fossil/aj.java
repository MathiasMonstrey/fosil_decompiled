package com.fossil;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

public final class aj extends qj {
    public aj(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    protected MenuItem m3484a(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        }
        mS();
        MenuItem a = super.a(i, i2, i3, charSequence);
        if (a instanceof ql) {
            ((ql) a).ad(true);
        }
        mT();
        return a;
    }
}
