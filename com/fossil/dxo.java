package com.fossil;

import android.os.Looper;

public interface dxo {
    public static final dxo dAw = new C32861();
    public static final dxo dAx = new C32872();

    static class C32861 implements dxo {
        C32861() {
        }

        public void mo2773a(dxh com_fossil_dxh) {
        }
    }

    static class C32872 implements dxo {
        C32872() {
        }

        public void mo2773a(dxh com_fossil_dxh) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("Event bus " + com_fossil_dxh + " accessed from non-main thread " + Looper.myLooper());
            }
        }
    }

    void mo2773a(dxh com_fossil_dxh);
}
