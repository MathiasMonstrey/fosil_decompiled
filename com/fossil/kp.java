package com.fossil;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class kp {
    static final C3801d RB;

    interface C3801d {
        MenuItem mo3291a(MenuItem menuItem, View view);

        void mo3292a(MenuItem menuItem, int i);

        MenuItem mo3293b(MenuItem menuItem, int i);

        View mo3294c(MenuItem menuItem);

        boolean mo3295d(MenuItem menuItem);

        boolean mo3296e(MenuItem menuItem);
    }

    static class C3802a implements C3801d {
        C3802a() {
        }

        public void mo3292a(MenuItem menuItem, int i) {
        }

        public MenuItem mo3291a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public MenuItem mo3293b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public View mo3294c(MenuItem menuItem) {
            return null;
        }

        public boolean mo3295d(MenuItem menuItem) {
            return false;
        }

        public boolean mo3296e(MenuItem menuItem) {
            return false;
        }
    }

    static class C3803b implements C3801d {
        C3803b() {
        }

        public void mo3292a(MenuItem menuItem, int i) {
            kq.m12032a(menuItem, i);
        }

        public MenuItem mo3291a(MenuItem menuItem, View view) {
            return kq.m12031a(menuItem, view);
        }

        public MenuItem mo3293b(MenuItem menuItem, int i) {
            return kq.m12033b(menuItem, i);
        }

        public View mo3294c(MenuItem menuItem) {
            return kq.m12034c(menuItem);
        }

        public boolean mo3295d(MenuItem menuItem) {
            return false;
        }

        public boolean mo3296e(MenuItem menuItem) {
            return false;
        }
    }

    static class C3804c extends C3803b {
        C3804c() {
        }

        public boolean mo3295d(MenuItem menuItem) {
            return kr.m12035d(menuItem);
        }

        public boolean mo3296e(MenuItem menuItem) {
            return kr.m12036e(menuItem);
        }
    }

    public interface C3805e {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            RB = new C3804c();
        } else if (VERSION.SDK_INT >= 11) {
            RB = new C3803b();
        } else {
            RB = new C3802a();
        }
    }

    public static void m12026a(MenuItem menuItem, int i) {
        if (menuItem instanceof hv) {
            ((hv) menuItem).setShowAsAction(i);
        } else {
            RB.mo3292a(menuItem, i);
        }
    }

    public static MenuItem m12024a(MenuItem menuItem, View view) {
        if (menuItem instanceof hv) {
            return ((hv) menuItem).setActionView(view);
        }
        return RB.mo3291a(menuItem, view);
    }

    public static MenuItem m12027b(MenuItem menuItem, int i) {
        if (menuItem instanceof hv) {
            return ((hv) menuItem).setActionView(i);
        }
        return RB.mo3293b(menuItem, i);
    }

    public static View m12028c(MenuItem menuItem) {
        if (menuItem instanceof hv) {
            return ((hv) menuItem).getActionView();
        }
        return RB.mo3294c(menuItem);
    }

    public static MenuItem m12025a(MenuItem menuItem, kc kcVar) {
        if (menuItem instanceof hv) {
            return ((hv) menuItem).mo3486a(kcVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean m12029d(MenuItem menuItem) {
        if (menuItem instanceof hv) {
            return ((hv) menuItem).expandActionView();
        }
        return RB.mo3295d(menuItem);
    }

    public static boolean m12030e(MenuItem menuItem) {
        if (menuItem instanceof hv) {
            return ((hv) menuItem).isActionViewExpanded();
        }
        return RB.mo3296e(menuItem);
    }
}
