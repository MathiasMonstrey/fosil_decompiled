package com.fossil;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class mj {
    private static final C3865e Ui;

    interface C3865e {
        void mo3405a(AccessibilityEvent accessibilityEvent, int i);

        int mo3406b(AccessibilityEvent accessibilityEvent);
    }

    static class C3866d implements C3865e {
        C3866d() {
        }

        public void mo3405a(AccessibilityEvent accessibilityEvent, int i) {
        }

        public int mo3406b(AccessibilityEvent accessibilityEvent) {
            return 0;
        }
    }

    static class C3867a extends C3866d {
        C3867a() {
        }
    }

    static class C3868b extends C3867a {
        C3868b() {
        }
    }

    static class C3869c extends C3868b {
        C3869c() {
        }

        public void mo3405a(AccessibilityEvent accessibilityEvent, int i) {
            mk.m12460a(accessibilityEvent, i);
        }

        public int mo3406b(AccessibilityEvent accessibilityEvent) {
            return mk.m12461b(accessibilityEvent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            Ui = new C3869c();
        } else if (VERSION.SDK_INT >= 16) {
            Ui = new C3868b();
        } else if (VERSION.SDK_INT >= 14) {
            Ui = new C3867a();
        } else {
            Ui = new C3866d();
        }
    }

    public static mx m12457a(AccessibilityEvent accessibilityEvent) {
        return new mx(accessibilityEvent);
    }

    public static void m12458a(AccessibilityEvent accessibilityEvent, int i) {
        Ui.mo3405a(accessibilityEvent, i);
    }

    public static int m12459b(AccessibilityEvent accessibilityEvent) {
        return Ui.mo3406b(accessibilityEvent);
    }
}
