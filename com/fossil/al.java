package com.fossil;

import android.content.Context;
import android.view.SubMenu;

public class al extends qj {
    public al(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        ql qlVar = (ql) a(i, i2, i3, charSequence);
        SubMenu anVar = new an(getContext(), this, qlVar);
        qlVar.m12650b(anVar);
        return anVar;
    }
}
