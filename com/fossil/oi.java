package com.fossil;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class oi {
    static final C3935f Zr;

    interface C3935f {
        void mo3943a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4);

        int mo3944b(TextView textView);

        void mo3945b(TextView textView, int i);

        Drawable[] mo3946c(TextView textView);
    }

    static class C3936b implements C3935f {
        C3936b() {
        }

        public void mo3943a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        public int mo3944b(TextView textView) {
            return ok.m12889b(textView);
        }

        public void mo3945b(TextView textView, int i) {
            ok.m12890b(textView, i);
        }

        public Drawable[] mo3946c(TextView textView) {
            return ok.m12891c(textView);
        }
    }

    static class C3937e extends C3936b {
        C3937e() {
        }

        public int mo3944b(TextView textView) {
            return ol.m12892b(textView);
        }
    }

    static class C3938c extends C3937e {
        C3938c() {
        }

        public void mo3943a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            om.m12893a(textView, drawable, drawable2, drawable3, drawable4);
        }

        public Drawable[] mo3946c(TextView textView) {
            return om.m12894c(textView);
        }
    }

    static class C3939d extends C3938c {
        C3939d() {
        }

        public void mo3943a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            on.m12895a(textView, drawable, drawable2, drawable3, drawable4);
        }

        public Drawable[] mo3946c(TextView textView) {
            return on.m12896c(textView);
        }
    }

    static class C3940a extends C3939d {
        C3940a() {
        }

        public void mo3945b(TextView textView, int i) {
            oj.m12887b(textView, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            Zr = new C3940a();
        } else if (i >= 18) {
            Zr = new C3939d();
        } else if (i >= 17) {
            Zr = new C3938c();
        } else if (i >= 16) {
            Zr = new C3937e();
        } else {
            Zr = new C3936b();
        }
    }

    public static void m12883a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Zr.mo3943a(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static int m12884b(TextView textView) {
        return Zr.mo3944b(textView);
    }

    public static void m12885b(TextView textView, int i) {
        Zr.mo3945b(textView, i);
    }

    public static Drawable[] m12886c(TextView textView) {
        return Zr.mo3946c(textView);
    }
}
