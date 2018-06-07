package com.fossil;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class qe<T> extends qf<T> {
    private Map<hv, MenuItem> afp;
    private Map<hw, SubMenu> afq;
    final Context mContext;

    qe(Context context, T t) {
        super(t);
        this.mContext = context;
    }

    final MenuItem m13136g(MenuItem menuItem) {
        if (!(menuItem instanceof hv)) {
            return menuItem;
        }
        hv hvVar = (hv) menuItem;
        if (this.afp == null) {
            this.afp = new jl();
        }
        MenuItem menuItem2 = (MenuItem) this.afp.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = qs.m13209a(this.mContext, hvVar);
        this.afp.put(hvVar, menuItem2);
        return menuItem2;
    }

    final SubMenu m13135a(SubMenu subMenu) {
        if (!(subMenu instanceof hw)) {
            return subMenu;
        }
        hw hwVar = (hw) subMenu;
        if (this.afq == null) {
            this.afq = new jl();
        }
        SubMenu subMenu2 = (SubMenu) this.afq.get(hwVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = qs.m13210a(this.mContext, hwVar);
        this.afq.put(hwVar, subMenu2);
        return subMenu2;
    }

    final void mF() {
        if (this.afp != null) {
            this.afp.clear();
        }
        if (this.afq != null) {
            this.afq.clear();
        }
    }

    final void ct(int i) {
        if (this.afp != null) {
            Iterator it = this.afp.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void cu(int i) {
        if (this.afp != null) {
            Iterator it = this.afp.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
