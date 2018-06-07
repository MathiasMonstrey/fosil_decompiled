package com.fossil;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class lt {
    static final C3833d SH;

    interface C3833d {
        boolean mo3377b(ViewConfiguration viewConfiguration);
    }

    static class C3834a implements C3833d {
        C3834a() {
        }

        public boolean mo3377b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    static class C3835b extends C3834a {
        C3835b() {
        }

        public boolean mo3377b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    static class C3836c extends C3835b {
        C3836c() {
        }

        public boolean mo3377b(ViewConfiguration viewConfiguration) {
            return lu.m12335b(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            SH = new C3836c();
        } else if (VERSION.SDK_INT >= 11) {
            SH = new C3835b();
        } else {
            SH = new C3834a();
        }
    }

    @Deprecated
    public static int m12333a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static boolean m12334b(ViewConfiguration viewConfiguration) {
        return SH.mo3377b(viewConfiguration);
    }
}
