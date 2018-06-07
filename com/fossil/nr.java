package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.widget.ImageView;

public class nr {
    static final C3921b WZ;

    interface C3921b {
        ColorStateList mo3933a(ImageView imageView);

        void mo3934a(ImageView imageView, ColorStateList colorStateList);

        void mo3935a(ImageView imageView, Mode mode);

        Mode mo3936b(ImageView imageView);
    }

    static class C3922a implements C3921b {
        C3922a() {
        }

        public ColorStateList mo3933a(ImageView imageView) {
            return ns.m12819a(imageView);
        }

        public void mo3934a(ImageView imageView, ColorStateList colorStateList) {
            ns.m12820a(imageView, colorStateList);
        }

        public void mo3935a(ImageView imageView, Mode mode) {
            ns.m12821a(imageView, mode);
        }

        public Mode mo3936b(ImageView imageView) {
            return ns.m12822b(imageView);
        }
    }

    static class C3923c extends C3922a {
        C3923c() {
        }

        public ColorStateList mo3933a(ImageView imageView) {
            return nt.m12823a(imageView);
        }

        public void mo3934a(ImageView imageView, ColorStateList colorStateList) {
            nt.m12824a(imageView, colorStateList);
        }

        public void mo3935a(ImageView imageView, Mode mode) {
            nt.m12825a(imageView, mode);
        }

        public Mode mo3936b(ImageView imageView) {
            return nt.m12826b(imageView);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            WZ = new C3923c();
        } else {
            WZ = new C3922a();
        }
    }

    public static ColorStateList m12815a(ImageView imageView) {
        return WZ.mo3933a(imageView);
    }

    public static void m12816a(ImageView imageView, ColorStateList colorStateList) {
        WZ.mo3934a(imageView, colorStateList);
    }

    public static Mode m12818b(ImageView imageView) {
        return WZ.mo3936b(imageView);
    }

    public static void m12817a(ImageView imageView, Mode mode) {
        WZ.mo3935a(imageView, mode);
    }
}
