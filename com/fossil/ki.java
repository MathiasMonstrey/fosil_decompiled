package com.fossil;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class ki {
    static final C3792a Rw;

    interface C3792a {
        km mo3284a(LayoutInflater layoutInflater);

        void mo3285a(LayoutInflater layoutInflater, km kmVar);
    }

    static class C3793b implements C3792a {
        C3793b() {
        }

        public void mo3285a(LayoutInflater layoutInflater, km kmVar) {
            kj.m11975a(layoutInflater, kmVar);
        }

        public km mo3284a(LayoutInflater layoutInflater) {
            return kj.m11974a(layoutInflater);
        }
    }

    static class C3794c extends C3793b {
        C3794c() {
        }

        public void mo3285a(LayoutInflater layoutInflater, km kmVar) {
            kk.m11977a(layoutInflater, kmVar);
        }
    }

    static class C3795d extends C3794c {
        C3795d() {
        }

        public void mo3285a(LayoutInflater layoutInflater, km kmVar) {
            kl.m11978a(layoutInflater, kmVar);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            Rw = new C3795d();
        } else if (i >= 11) {
            Rw = new C3794c();
        } else {
            Rw = new C3793b();
        }
    }

    public static void m11973a(LayoutInflater layoutInflater, km kmVar) {
        Rw.mo3285a(layoutInflater, kmVar);
    }

    public static km m11972a(LayoutInflater layoutInflater) {
        return Rw.mo3284a(layoutInflater);
    }
}
