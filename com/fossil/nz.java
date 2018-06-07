package com.fossil;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class nz {
    static final C3928e XY;

    interface C3928e {
        void mo3940a(PopupWindow popupWindow, int i);

        void mo3941a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void mo3942a(PopupWindow popupWindow, boolean z);
    }

    static class C3929c implements C3928e {
        private static Method XZ;
        private static boolean Ya;

        C3929c() {
        }

        public void mo3941a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((ke.getAbsoluteGravity(i3, li.S(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void mo3942a(PopupWindow popupWindow, boolean z) {
        }

        public void mo3940a(PopupWindow popupWindow, int i) {
            if (!Ya) {
                try {
                    XZ = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    XZ.setAccessible(true);
                } catch (Exception e) {
                }
                Ya = true;
            }
            if (XZ != null) {
                try {
                    XZ.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                }
            }
        }
    }

    static class C3930d extends C3929c {
        C3930d() {
        }

        public void mo3941a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            oc.m12866a(popupWindow, view, i, i2, i3);
        }
    }

    static class C3931a extends C3930d {
        C3931a() {
        }

        public void mo3942a(PopupWindow popupWindow, boolean z) {
            oa.m12863a(popupWindow, z);
        }
    }

    static class C3932b extends C3931a {
        C3932b() {
        }

        public void mo3942a(PopupWindow popupWindow, boolean z) {
            ob.m12865a(popupWindow, z);
        }

        public void mo3940a(PopupWindow popupWindow, int i) {
            ob.m12864a(popupWindow, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            XY = new C3932b();
        } else if (i >= 21) {
            XY = new C3931a();
        } else if (i >= 19) {
            XY = new C3930d();
        } else {
            XY = new C3929c();
        }
    }

    public static void m12859a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        XY.mo3941a(popupWindow, view, i, i2, i3);
    }

    public static void m12860a(PopupWindow popupWindow, boolean z) {
        XY.mo3942a(popupWindow, z);
    }

    public static void m12858a(PopupWindow popupWindow, int i) {
        XY.mo3940a(popupWindow, i);
    }
}
