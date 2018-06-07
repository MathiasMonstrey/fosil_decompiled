package com.fossil;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class lv {
    static final C3837c SI;

    interface C3837c {
        void mo3378d(ViewGroup viewGroup, boolean z);
    }

    static class C3838f implements C3837c {
        C3838f() {
        }

        public void mo3378d(ViewGroup viewGroup, boolean z) {
        }
    }

    static class C3839a extends C3838f {
        C3839a() {
        }

        public void mo3378d(ViewGroup viewGroup, boolean z) {
            lw.m12340d(viewGroup, z);
        }
    }

    static class C3840b extends C3839a {
        C3840b() {
        }
    }

    static class C3841d extends C3840b {
        C3841d() {
        }
    }

    static class C3842e extends C3841d {
        C3842e() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            SI = new C3842e();
        } else if (i >= 18) {
            SI = new C3841d();
        } else if (i >= 14) {
            SI = new C3840b();
        } else if (i >= 11) {
            SI = new C3839a();
        } else {
            SI = new C3838f();
        }
    }

    public static void m12339d(ViewGroup viewGroup, boolean z) {
        SI.mo3378d(viewGroup, z);
    }
}
