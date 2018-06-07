package com.fossil;

import android.content.res.Resources;
import android.os.Build.VERSION;

public final class hb {
    private static final C3641a Nk;

    interface C3641a {
        int mo3137a(Resources resources);

        int mo3138b(Resources resources);

        int mo3139c(Resources resources);
    }

    static class C3642b implements C3641a {
        C3642b() {
        }

        public int mo3137a(Resources resources) {
            return hc.m11555a(resources);
        }

        public int mo3138b(Resources resources) {
            return hc.m11556b(resources);
        }

        public int mo3139c(Resources resources) {
            return hc.m11557c(resources);
        }
    }

    static class C3643c extends C3642b {
        C3643c() {
        }

        public int mo3137a(Resources resources) {
            return hd.m11558a(resources);
        }

        public int mo3138b(Resources resources) {
            return hd.m11559b(resources);
        }

        public int mo3139c(Resources resources) {
            return hd.m11560c(resources);
        }
    }

    static class C3644d extends C3643c {
        C3644d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            Nk = new C3644d();
        } else if (i >= 13) {
            Nk = new C3643c();
        } else {
            Nk = new C3642b();
        }
    }

    public static int m11552a(Resources resources) {
        return Nk.mo3137a(resources);
    }

    public static int m11553b(Resources resources) {
        return Nk.mo3138b(resources);
    }

    public static int m11554c(Resources resources) {
        return Nk.mo3139c(resources);
    }
}
