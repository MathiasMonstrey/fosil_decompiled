package com.fossil;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

@TargetApi(14)
class qt extends qe<hu> implements Menu {
    qt(Context context, hu huVar) {
        super(context, huVar);
    }

    public MenuItem add(CharSequence charSequence) {
        return m13136g(((hu) this.afr).add(charSequence));
    }

    public MenuItem add(int i) {
        return m13136g(((hu) this.afr).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m13136g(((hu) this.afr).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m13136g(((hu) this.afr).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m13135a(((hu) this.afr).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return m13135a(((hu) this.afr).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m13135a(((hu) this.afr).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m13135a(((hu) this.afr).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((hu) this.afr).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m13136g(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        cu(i);
        ((hu) this.afr).removeItem(i);
    }

    public void removeGroup(int i) {
        ct(i);
        ((hu) this.afr).removeGroup(i);
    }

    public void clear() {
        mF();
        ((hu) this.afr).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((hu) this.afr).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((hu) this.afr).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((hu) this.afr).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((hu) this.afr).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return m13136g(((hu) this.afr).findItem(i));
    }

    public int size() {
        return ((hu) this.afr).size();
    }

    public MenuItem getItem(int i) {
        return m13136g(((hu) this.afr).getItem(i));
    }

    public void close() {
        ((hu) this.afr).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((hu) this.afr).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((hu) this.afr).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((hu) this.afr).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((hu) this.afr).setQwertyMode(z);
    }
}
