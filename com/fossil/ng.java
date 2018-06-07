package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class ng {
    private static final C3913c VJ;

    interface C3913c {
        Drawable mo3917a(CompoundButton compoundButton);

        void mo3918a(CompoundButton compoundButton, ColorStateList colorStateList);

        void mo3919a(CompoundButton compoundButton, Mode mode);
    }

    static class C3914b implements C3913c {
        C3914b() {
        }

        public void mo3918a(CompoundButton compoundButton, ColorStateList colorStateList) {
            ni.m12765a(compoundButton, colorStateList);
        }

        public void mo3919a(CompoundButton compoundButton, Mode mode) {
            ni.m12766a(compoundButton, mode);
        }

        public Drawable mo3917a(CompoundButton compoundButton) {
            return ni.m12764a(compoundButton);
        }
    }

    static class C3915d extends C3914b {
        C3915d() {
        }

        public void mo3918a(CompoundButton compoundButton, ColorStateList colorStateList) {
            nj.m12767a(compoundButton, colorStateList);
        }

        public void mo3919a(CompoundButton compoundButton, Mode mode) {
            nj.m12768a(compoundButton, mode);
        }
    }

    static class C3916a extends C3915d {
        C3916a() {
        }

        public Drawable mo3917a(CompoundButton compoundButton) {
            return nh.m12763a(compoundButton);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            VJ = new C3916a();
        } else if (i >= 21) {
            VJ = new C3915d();
        } else {
            VJ = new C3914b();
        }
    }

    public static void m12761a(CompoundButton compoundButton, ColorStateList colorStateList) {
        VJ.mo3918a(compoundButton, colorStateList);
    }

    public static void m12762a(CompoundButton compoundButton, Mode mode) {
        VJ.mo3919a(compoundButton, mode);
    }

    public static Drawable m12760a(CompoundButton compoundButton) {
        return VJ.mo3917a(compoundButton);
    }
}
