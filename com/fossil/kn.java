package com.fossil;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class kn {
    static final C3798a RA;

    interface C3798a {
        void mo3286a(MarginLayoutParams marginLayoutParams, int i);

        int mo3287b(MarginLayoutParams marginLayoutParams);

        void mo3288b(MarginLayoutParams marginLayoutParams, int i);

        int mo3289c(MarginLayoutParams marginLayoutParams);

        void mo3290c(MarginLayoutParams marginLayoutParams, int i);
    }

    static class C3799b implements C3798a {
        C3799b() {
        }

        public int mo3287b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public int mo3289c(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }

        public void mo3286a(MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.leftMargin = i;
        }

        public void mo3288b(MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.rightMargin = i;
        }

        public void mo3290c(MarginLayoutParams marginLayoutParams, int i) {
        }
    }

    static class C3800c implements C3798a {
        C3800c() {
        }

        public int mo3287b(MarginLayoutParams marginLayoutParams) {
            return ko.m12000b(marginLayoutParams);
        }

        public int mo3289c(MarginLayoutParams marginLayoutParams) {
            return ko.m12002c(marginLayoutParams);
        }

        public void mo3286a(MarginLayoutParams marginLayoutParams, int i) {
            ko.m11999a(marginLayoutParams, i);
        }

        public void mo3288b(MarginLayoutParams marginLayoutParams, int i) {
            ko.m12001b(marginLayoutParams, i);
        }

        public void mo3290c(MarginLayoutParams marginLayoutParams, int i) {
            ko.m12003c(marginLayoutParams, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            RA = new C3800c();
        } else {
            RA = new C3799b();
        }
    }

    public static int m11995b(MarginLayoutParams marginLayoutParams) {
        return RA.mo3287b(marginLayoutParams);
    }

    public static int m11997c(MarginLayoutParams marginLayoutParams) {
        return RA.mo3289c(marginLayoutParams);
    }

    public static void m11994a(MarginLayoutParams marginLayoutParams, int i) {
        RA.mo3286a(marginLayoutParams, i);
    }

    public static void m11996b(MarginLayoutParams marginLayoutParams, int i) {
        RA.mo3288b(marginLayoutParams, i);
    }

    public static void m11998c(MarginLayoutParams marginLayoutParams, int i) {
        RA.mo3290c(marginLayoutParams, i);
    }
}
