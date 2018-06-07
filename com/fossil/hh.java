package com.fossil;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class hh {
    static final C3645b Nm;

    interface C3645b {
        void mo3140a(Drawable drawable, float f, float f2);

        void mo3141a(Drawable drawable, int i);

        void mo3142a(Drawable drawable, int i, int i2, int i3, int i4);

        void mo3143a(Drawable drawable, ColorStateList colorStateList);

        void mo3144a(Drawable drawable, Theme theme);

        void mo3145a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException;

        void mo3146a(Drawable drawable, Mode mode);

        void mo3147a(Drawable drawable, boolean z);

        boolean mo3148b(Drawable drawable, int i);

        void mo3149c(Drawable drawable);

        boolean mo3150d(Drawable drawable);

        int mo3151e(Drawable drawable);

        boolean mo3152f(Drawable drawable);

        ColorFilter mo3153g(Drawable drawable);

        void mo3154h(Drawable drawable);

        Drawable mo3155i(Drawable drawable);
    }

    static class C3646a implements C3645b {
        C3646a() {
        }

        public void mo3149c(Drawable drawable) {
        }

        public void mo3147a(Drawable drawable, boolean z) {
        }

        public boolean mo3150d(Drawable drawable) {
            return false;
        }

        public void mo3140a(Drawable drawable, float f, float f2) {
        }

        public void mo3142a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void mo3141a(Drawable drawable, int i) {
            hj.m11638a(drawable, i);
        }

        public void mo3143a(Drawable drawable, ColorStateList colorStateList) {
            hj.m11639a(drawable, colorStateList);
        }

        public void mo3146a(Drawable drawable, Mode mode) {
            hj.m11641a(drawable, mode);
        }

        public Drawable mo3155i(Drawable drawable) {
            return hj.m11642k(drawable);
        }

        public boolean mo3148b(Drawable drawable, int i) {
            return false;
        }

        public int mo3151e(Drawable drawable) {
            return 0;
        }

        public void mo3144a(Drawable drawable, Theme theme) {
        }

        public boolean mo3152f(Drawable drawable) {
            return false;
        }

        public ColorFilter mo3153g(Drawable drawable) {
            return null;
        }

        public void mo3154h(Drawable drawable) {
            drawable.clearColorFilter();
        }

        public void mo3145a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
            hj.m11640a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    static class C3647c extends C3646a {
        C3647c() {
        }

        public void mo3149c(Drawable drawable) {
            hk.m11643c(drawable);
        }

        public Drawable mo3155i(Drawable drawable) {
            return hk.m11644k(drawable);
        }
    }

    static class C3648d extends C3647c {
        C3648d() {
        }

        public boolean mo3148b(Drawable drawable, int i) {
            return hl.m11645b(drawable, i);
        }
    }

    static class C3649e extends C3648d {
        C3649e() {
        }

        public void mo3147a(Drawable drawable, boolean z) {
            hm.m11646a(drawable, z);
        }

        public boolean mo3150d(Drawable drawable) {
            return hm.m11647d(drawable);
        }

        public Drawable mo3155i(Drawable drawable) {
            return hm.m11649k(drawable);
        }

        public int mo3151e(Drawable drawable) {
            return hm.m11648e(drawable);
        }
    }

    static class C3650f extends C3649e {
        C3650f() {
        }

        public void mo3140a(Drawable drawable, float f, float f2) {
            hn.m11650a(drawable, f, f2);
        }

        public void mo3142a(Drawable drawable, int i, int i2, int i3, int i4) {
            hn.m11652a(drawable, i, i2, i3, i4);
        }

        public void mo3141a(Drawable drawable, int i) {
            hn.m11651a(drawable, i);
        }

        public void mo3143a(Drawable drawable, ColorStateList colorStateList) {
            hn.m11653a(drawable, colorStateList);
        }

        public void mo3146a(Drawable drawable, Mode mode) {
            hn.m11656a(drawable, mode);
        }

        public Drawable mo3155i(Drawable drawable) {
            return hn.m11660k(drawable);
        }

        public void mo3144a(Drawable drawable, Theme theme) {
            hn.m11654a(drawable, theme);
        }

        public boolean mo3152f(Drawable drawable) {
            return hn.m11657f(drawable);
        }

        public ColorFilter mo3153g(Drawable drawable) {
            return hn.m11658g(drawable);
        }

        public void mo3154h(Drawable drawable) {
            hn.m11659h(drawable);
        }

        public void mo3145a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
            hn.m11655a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    static class C3651g extends C3650f {
        C3651g() {
        }

        public boolean mo3148b(Drawable drawable, int i) {
            return hi.m11637b(drawable, i);
        }

        public Drawable mo3155i(Drawable drawable) {
            return drawable;
        }

        public void mo3154h(Drawable drawable) {
            drawable.clearColorFilter();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            Nm = new C3651g();
        } else if (i >= 21) {
            Nm = new C3650f();
        } else if (i >= 19) {
            Nm = new C3649e();
        } else if (i >= 17) {
            Nm = new C3648d();
        } else if (i >= 11) {
            Nm = new C3647c();
        } else {
            Nm = new C3646a();
        }
    }

    public static void m11629c(Drawable drawable) {
        Nm.mo3149c(drawable);
    }

    public static void m11627a(Drawable drawable, boolean z) {
        Nm.mo3147a(drawable, z);
    }

    public static boolean m11630d(Drawable drawable) {
        return Nm.mo3150d(drawable);
    }

    public static void m11620a(Drawable drawable, float f, float f2) {
        Nm.mo3140a(drawable, f, f2);
    }

    public static void m11622a(Drawable drawable, int i, int i2, int i3, int i4) {
        Nm.mo3142a(drawable, i, i2, i3, i4);
    }

    public static void m11621a(Drawable drawable, int i) {
        Nm.mo3141a(drawable, i);
    }

    public static void m11623a(Drawable drawable, ColorStateList colorStateList) {
        Nm.mo3143a(drawable, colorStateList);
    }

    public static void m11626a(Drawable drawable, Mode mode) {
        Nm.mo3146a(drawable, mode);
    }

    public static int m11631e(Drawable drawable) {
        return Nm.mo3151e(drawable);
    }

    public static void m11624a(Drawable drawable, Theme theme) {
        Nm.mo3144a(drawable, theme);
    }

    public static boolean m11632f(Drawable drawable) {
        return Nm.mo3152f(drawable);
    }

    public static ColorFilter m11633g(Drawable drawable) {
        return Nm.mo3153g(drawable);
    }

    public static void m11634h(Drawable drawable) {
        Nm.mo3154h(drawable);
    }

    public static void m11625a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        Nm.mo3145a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable m11635i(Drawable drawable) {
        return Nm.mo3155i(drawable);
    }

    public static <T extends Drawable> T m11636j(Drawable drawable) {
        if (drawable instanceof ho) {
            return ((ho) drawable).iM();
        }
        return drawable;
    }

    public static boolean m11628b(Drawable drawable, int i) {
        return Nm.mo3148b(drawable, i);
    }
}
