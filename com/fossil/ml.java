package com.fossil;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v8.renderscript.Allocation;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;

public class ml {
    static final C3871g Uj;
    private final Object Uk;
    public int Ul = -1;

    public static class C3870a {
        public static final C3870a UA = new C3870a(16384, null);
        public static final C3870a UB = new C3870a(32768, null);
        public static final C3870a UC = new C3870a(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, null);
        public static final C3870a UD = new C3870a(131072, null);
        public static final C3870a UE = new C3870a(262144, null);
        public static final C3870a UF = new C3870a(524288, null);
        public static final C3870a UG = new C3870a(1048576, null);
        public static final C3870a UH = new C3870a(2097152, null);
        public static final C3870a UJ = new C3870a(ml.Uj.jW());
        public static final C3870a UK = new C3870a(ml.Uj.jV());
        public static final C3870a UL = new C3870a(ml.Uj.jX());
        public static final C3870a UM = new C3870a(ml.Uj.jZ());
        public static final C3870a UN = new C3870a(ml.Uj.jY());
        public static final C3870a UO = new C3870a(ml.Uj.ka());
        public static final C3870a UP = new C3870a(ml.Uj.kb());
        public static final C3870a UQ = new C3870a(ml.Uj.kc());
        public static final C3870a Um = new C3870a(1, null);
        public static final C3870a Un = new C3870a(2, null);
        public static final C3870a Uo = new C3870a(4, null);
        public static final C3870a Up = new C3870a(8, null);
        public static final C3870a Uq = new C3870a(16, null);
        public static final C3870a Ur = new C3870a(32, null);
        public static final C3870a Us = new C3870a(64, null);
        public static final C3870a Ut = new C3870a(Allocation.USAGE_SHARED, null);
        public static final C3870a Uu = new C3870a(256, null);
        public static final C3870a Uv = new C3870a(512, null);
        public static final C3870a Uw = new C3870a(1024, null);
        public static final C3870a Ux = new C3870a(2048, null);
        public static final C3870a Uy = new C3870a(4096, null);
        public static final C3870a Uz = new C3870a(Utility.DEFAULT_STREAM_BUFFER_SIZE, null);
        final Object UR;

        public C3870a(int i, CharSequence charSequence) {
            this(ml.Uj.mo3408a(i, charSequence));
        }

        C3870a(Object obj) {
            this.UR = obj;
        }
    }

    interface C3871g {
        Object mo3407a(int i, int i2, int i3, int i4, boolean z, boolean z2);

        Object mo3408a(int i, CharSequence charSequence);

        void mo3409a(Object obj, boolean z);

        boolean aA(Object obj);

        boolean aB(Object obj);

        boolean aC(Object obj);

        boolean aD(Object obj);

        boolean aE(Object obj);

        boolean aF(Object obj);

        boolean aG(Object obj);

        void aH(Object obj);

        int aI(Object obj);

        boolean aJ(Object obj);

        boolean aK(Object obj);

        String aL(Object obj);

        Object ar(Object obj);

        int as(Object obj);

        CharSequence at(Object obj);

        CharSequence au(Object obj);

        CharSequence av(Object obj);

        CharSequence aw(Object obj);

        boolean ax(Object obj);

        boolean ay(Object obj);

        boolean az(Object obj);

        Object mo3431b(int i, int i2, boolean z, int i3);

        void mo3432b(Object obj, int i);

        void mo3433b(Object obj, Rect rect);

        void mo3434b(Object obj, boolean z);

        void mo3435c(Object obj, int i);

        void mo3436c(Object obj, Rect rect);

        void mo3437c(Object obj, boolean z);

        void mo3438d(Object obj, Rect rect);

        void mo3439d(Object obj, CharSequence charSequence);

        void mo3440d(Object obj, boolean z);

        void mo3441e(Object obj, Rect rect);

        void mo3442e(Object obj, CharSequence charSequence);

        void mo3443e(Object obj, boolean z);

        boolean mo3444e(Object obj, Object obj2);

        void mo3445f(Object obj, View view);

        void mo3446f(Object obj, CharSequence charSequence);

        void mo3447f(Object obj, Object obj2);

        void mo3448f(Object obj, boolean z);

        void mo3449g(Object obj, View view);

        void mo3450g(Object obj, CharSequence charSequence);

        void mo3451g(Object obj, Object obj2);

        void mo3452g(Object obj, boolean z);

        void mo3453h(Object obj, View view);

        void mo3454h(Object obj, CharSequence charSequence);

        void mo3455h(Object obj, boolean z);

        void mo3456i(Object obj, View view);

        void mo3457i(Object obj, boolean z);

        void mo3458j(Object obj, boolean z);

        Object jV();

        Object jW();

        Object jX();

        Object jY();

        Object jZ();

        void mo3464k(Object obj, boolean z);

        Object ka();

        Object kb();

        Object kc();

        void mo3468l(Object obj, boolean z);

        void mo3469m(Object obj, boolean z);
    }

    static class C3872l implements C3871g {
        C3872l() {
        }

        public Object mo3408a(int i, CharSequence charSequence) {
            return null;
        }

        public Object ar(Object obj) {
            return null;
        }

        public void mo3432b(Object obj, int i) {
        }

        public boolean mo3444e(Object obj, Object obj2) {
            return false;
        }

        public void mo3445f(Object obj, View view) {
        }

        public int as(Object obj) {
            return 0;
        }

        public void mo3433b(Object obj, Rect rect) {
        }

        public void mo3436c(Object obj, Rect rect) {
        }

        public CharSequence at(Object obj) {
            return null;
        }

        public CharSequence au(Object obj) {
            return null;
        }

        public CharSequence av(Object obj) {
            return null;
        }

        public CharSequence aw(Object obj) {
            return null;
        }

        public boolean ax(Object obj) {
            return false;
        }

        public boolean ay(Object obj) {
            return false;
        }

        public boolean az(Object obj) {
            return false;
        }

        public boolean aA(Object obj) {
            return false;
        }

        public boolean aB(Object obj) {
            return false;
        }

        public boolean aC(Object obj) {
            return false;
        }

        public boolean aJ(Object obj) {
            return false;
        }

        public boolean aK(Object obj) {
            return false;
        }

        public boolean aD(Object obj) {
            return false;
        }

        public boolean aE(Object obj) {
            return false;
        }

        public boolean aF(Object obj) {
            return false;
        }

        public boolean aG(Object obj) {
            return false;
        }

        public void mo3435c(Object obj, int i) {
        }

        public int aI(Object obj) {
            return 0;
        }

        public void mo3438d(Object obj, Rect rect) {
        }

        public void mo3441e(Object obj, Rect rect) {
        }

        public void mo3409a(Object obj, boolean z) {
        }

        public void mo3434b(Object obj, boolean z) {
        }

        public void mo3442e(Object obj, CharSequence charSequence) {
        }

        public void mo3437c(Object obj, boolean z) {
        }

        public void mo3446f(Object obj, CharSequence charSequence) {
        }

        public void mo3440d(Object obj, boolean z) {
        }

        public void mo3443e(Object obj, boolean z) {
        }

        public void mo3448f(Object obj, boolean z) {
        }

        public void mo3458j(Object obj, boolean z) {
        }

        public void mo3464k(Object obj, boolean z) {
        }

        public void mo3452g(Object obj, boolean z) {
        }

        public void mo3450g(Object obj, CharSequence charSequence) {
        }

        public void mo3449g(Object obj, View view) {
        }

        public void mo3455h(Object obj, boolean z) {
        }

        public void mo3457i(Object obj, boolean z) {
        }

        public void mo3453h(Object obj, View view) {
        }

        public void mo3454h(Object obj, CharSequence charSequence) {
        }

        public void aH(Object obj) {
        }

        public String aL(Object obj) {
            return null;
        }

        public void mo3447f(Object obj, Object obj2) {
        }

        public void mo3451g(Object obj, Object obj2) {
        }

        public Object mo3431b(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object mo3407a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public void mo3468l(Object obj, boolean z) {
        }

        public void mo3439d(Object obj, CharSequence charSequence) {
        }

        public void mo3456i(Object obj, View view) {
        }

        public void mo3469m(Object obj, boolean z) {
        }

        public Object jV() {
            return null;
        }

        public Object kc() {
            return null;
        }

        public Object jW() {
            return null;
        }

        public Object jX() {
            return null;
        }

        public Object jY() {
            return null;
        }

        public Object jZ() {
            return null;
        }

        public Object ka() {
            return null;
        }

        public Object kb() {
            return null;
        }
    }

    static class C3873f extends C3872l {
        C3873f() {
        }

        public Object ar(Object obj) {
            return mp.ar(obj);
        }

        public void mo3432b(Object obj, int i) {
            mp.m12576b(obj, i);
        }

        public void mo3445f(Object obj, View view) {
            mp.m12586f(obj, view);
        }

        public int as(Object obj) {
            return mp.as(obj);
        }

        public void mo3433b(Object obj, Rect rect) {
            mp.m12577b(obj, rect);
        }

        public void mo3436c(Object obj, Rect rect) {
            mp.m12579c(obj, rect);
        }

        public CharSequence at(Object obj) {
            return mp.at(obj);
        }

        public CharSequence au(Object obj) {
            return mp.au(obj);
        }

        public CharSequence av(Object obj) {
            return mp.av(obj);
        }

        public CharSequence aw(Object obj) {
            return mp.aw(obj);
        }

        public boolean ax(Object obj) {
            return mp.ax(obj);
        }

        public boolean ay(Object obj) {
            return mp.ay(obj);
        }

        public boolean az(Object obj) {
            return mp.az(obj);
        }

        public boolean aA(Object obj) {
            return mp.aA(obj);
        }

        public boolean aB(Object obj) {
            return mp.aB(obj);
        }

        public boolean aC(Object obj) {
            return mp.aC(obj);
        }

        public boolean aD(Object obj) {
            return mp.aD(obj);
        }

        public boolean aE(Object obj) {
            return mp.aE(obj);
        }

        public boolean aF(Object obj) {
            return mp.aF(obj);
        }

        public boolean aG(Object obj) {
            return mp.aG(obj);
        }

        public void mo3438d(Object obj, Rect rect) {
            mp.m12581d(obj, rect);
        }

        public void mo3441e(Object obj, Rect rect) {
            mp.m12583e(obj, rect);
        }

        public void mo3409a(Object obj, boolean z) {
            mp.m12575a(obj, z);
        }

        public void mo3434b(Object obj, boolean z) {
            mp.m12578b(obj, z);
        }

        public void mo3442e(Object obj, CharSequence charSequence) {
            mp.m12584e(obj, charSequence);
        }

        public void mo3437c(Object obj, boolean z) {
            mp.m12580c(obj, z);
        }

        public void mo3446f(Object obj, CharSequence charSequence) {
            mp.m12587f(obj, charSequence);
        }

        public void mo3440d(Object obj, boolean z) {
            mp.m12582d(obj, z);
        }

        public void mo3443e(Object obj, boolean z) {
            mp.m12585e(obj, z);
        }

        public void mo3448f(Object obj, boolean z) {
            mp.m12588f(obj, z);
        }

        public void mo3452g(Object obj, boolean z) {
            mp.m12591g(obj, z);
        }

        public void mo3450g(Object obj, CharSequence charSequence) {
            mp.m12590g(obj, charSequence);
        }

        public void mo3449g(Object obj, View view) {
            mp.m12589g(obj, view);
        }

        public void mo3455h(Object obj, boolean z) {
            mp.m12594h(obj, z);
        }

        public void mo3457i(Object obj, boolean z) {
            mp.m12595i(obj, z);
        }

        public void mo3453h(Object obj, View view) {
            mp.m12592h(obj, view);
        }

        public void mo3454h(Object obj, CharSequence charSequence) {
            mp.m12593h(obj, charSequence);
        }

        public void aH(Object obj) {
            mp.aH(obj);
        }
    }

    static class C3874h extends C3873f {
        C3874h() {
        }

        public boolean aJ(Object obj) {
            return mq.aJ(obj);
        }

        public void mo3458j(Object obj, boolean z) {
            mq.m12597j(obj, z);
        }

        public boolean aK(Object obj) {
            return mq.aK(obj);
        }

        public void mo3464k(Object obj, boolean z) {
            mq.m12598n(obj, z);
        }

        public void mo3435c(Object obj, int i) {
            mq.m12596c(obj, i);
        }

        public int aI(Object obj) {
            return mq.aI(obj);
        }
    }

    static class C3875i extends C3874h {
        C3875i() {
        }

        public void mo3456i(Object obj, View view) {
            mr.m12599i(obj, view);
        }
    }

    static class C3876j extends C3875i {
        C3876j() {
        }

        public String aL(Object obj) {
            return ms.aL(obj);
        }
    }

    static class C3877k extends C3876j {
        C3877k() {
        }

        public void mo3447f(Object obj, Object obj2) {
            mt.m12602f(obj, obj2);
        }

        public Object mo3431b(int i, int i2, boolean z, int i3) {
            return mt.m12601b(i, i2, z, i3);
        }

        public Object mo3407a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return mt.m12600a(i, i2, i3, i4, z);
        }

        public void mo3451g(Object obj, Object obj2) {
            mt.m12603g(obj, obj2);
        }

        public void mo3468l(Object obj, boolean z) {
            mt.m12604l(obj, z);
        }

        public void mo3469m(Object obj, boolean z) {
            mt.m12605m(obj, z);
        }
    }

    static class C3878b extends C3877k {
        C3878b() {
        }

        public Object mo3408a(int i, CharSequence charSequence) {
            return mm.m12571a(i, charSequence);
        }

        public Object mo3431b(int i, int i2, boolean z, int i3) {
            return mm.m12572b(i, i2, z, i3);
        }

        public boolean mo3444e(Object obj, Object obj2) {
            return mm.m12574e(obj, obj2);
        }

        public Object mo3407a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return mm.m12570a(i, i2, i3, i4, z, z2);
        }

        public void mo3439d(Object obj, CharSequence charSequence) {
            mm.m12573d(obj, charSequence);
        }
    }

    static class C3879c extends C3878b {
        C3879c() {
        }
    }

    static class C3880d extends C3879c {
        C3880d() {
        }

        public Object jV() {
            return mn.jV();
        }

        public Object jW() {
            return mn.jW();
        }

        public Object jX() {
            return mn.jX();
        }

        public Object jY() {
            return mn.jY();
        }

        public Object jZ() {
            return mn.jZ();
        }

        public Object ka() {
            return mn.ka();
        }

        public Object kb() {
            return mn.kb();
        }
    }

    static class C3881e extends C3880d {
        C3881e() {
        }

        public Object kc() {
            return mo.kc();
        }
    }

    public static class C3882m {
        final Object Uk;

        public static C3882m m12566c(int i, int i2, boolean z, int i3) {
            return new C3882m(ml.Uj.mo3431b(i, i2, z, i3));
        }

        C3882m(Object obj) {
            this.Uk = obj;
        }
    }

    public static class C3883n {
        final Object Uk;

        public static C3883n m12567b(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new C3883n(ml.Uj.mo3407a(i, i2, i3, i4, z, z2));
        }

        C3883n(Object obj) {
            this.Uk = obj;
        }
    }

    static {
        if (VERSION.SDK_INT >= 24) {
            Uj = new C3881e();
        } else if (VERSION.SDK_INT >= 23) {
            Uj = new C3880d();
        } else if (VERSION.SDK_INT >= 22) {
            Uj = new C3879c();
        } else if (VERSION.SDK_INT >= 21) {
            Uj = new C3878b();
        } else if (VERSION.SDK_INT >= 19) {
            Uj = new C3877k();
        } else if (VERSION.SDK_INT >= 18) {
            Uj = new C3876j();
        } else if (VERSION.SDK_INT >= 17) {
            Uj = new C3875i();
        } else if (VERSION.SDK_INT >= 16) {
            Uj = new C3874h();
        } else if (VERSION.SDK_INT >= 14) {
            Uj = new C3873f();
        } else {
            Uj = new C3872l();
        }
    }

    static ml ao(Object obj) {
        if (obj != null) {
            return new ml(obj);
        }
        return null;
    }

    public ml(Object obj) {
        this.Uk = obj;
    }

    public Object jU() {
        return this.Uk;
    }

    public static ml m12568a(ml mlVar) {
        return ao(Uj.ar(mlVar.Uk));
    }

    public void setSource(View view) {
        Uj.mo3453h(this.Uk, view);
    }

    public void addChild(View view) {
        Uj.mo3445f(this.Uk, view);
    }

    public int getActions() {
        return Uj.as(this.Uk);
    }

    public void addAction(int i) {
        Uj.mo3432b(this.Uk, i);
    }

    public boolean m12569a(C3870a c3870a) {
        return Uj.mo3444e(this.Uk, c3870a.UR);
    }

    public void setMovementGranularities(int i) {
        Uj.mo3435c(this.Uk, i);
    }

    public int getMovementGranularities() {
        return Uj.aI(this.Uk);
    }

    public void setParent(View view) {
        Uj.mo3449g(this.Uk, view);
    }

    public void getBoundsInParent(Rect rect) {
        Uj.mo3433b(this.Uk, rect);
    }

    public void setBoundsInParent(Rect rect) {
        Uj.mo3438d(this.Uk, rect);
    }

    public void getBoundsInScreen(Rect rect) {
        Uj.mo3436c(this.Uk, rect);
    }

    public void setBoundsInScreen(Rect rect) {
        Uj.mo3441e(this.Uk, rect);
    }

    public boolean isCheckable() {
        return Uj.ax(this.Uk);
    }

    public void setCheckable(boolean z) {
        Uj.mo3409a(this.Uk, z);
    }

    public boolean isChecked() {
        return Uj.ay(this.Uk);
    }

    public void setChecked(boolean z) {
        Uj.mo3434b(this.Uk, z);
    }

    public boolean isFocusable() {
        return Uj.aB(this.Uk);
    }

    public void setFocusable(boolean z) {
        Uj.mo3443e(this.Uk, z);
    }

    public boolean isFocused() {
        return Uj.aC(this.Uk);
    }

    public void setFocused(boolean z) {
        Uj.mo3448f(this.Uk, z);
    }

    public boolean isVisibleToUser() {
        return Uj.aJ(this.Uk);
    }

    public void setVisibleToUser(boolean z) {
        Uj.mo3458j(this.Uk, z);
    }

    public boolean isAccessibilityFocused() {
        return Uj.aK(this.Uk);
    }

    public void setAccessibilityFocused(boolean z) {
        Uj.mo3464k(this.Uk, z);
    }

    public boolean isSelected() {
        return Uj.aG(this.Uk);
    }

    public void setSelected(boolean z) {
        Uj.mo3457i(this.Uk, z);
    }

    public boolean isClickable() {
        return Uj.az(this.Uk);
    }

    public void setClickable(boolean z) {
        Uj.mo3437c(this.Uk, z);
    }

    public boolean isLongClickable() {
        return Uj.aD(this.Uk);
    }

    public void setLongClickable(boolean z) {
        Uj.mo3452g(this.Uk, z);
    }

    public boolean isEnabled() {
        return Uj.aA(this.Uk);
    }

    public void setEnabled(boolean z) {
        Uj.mo3440d(this.Uk, z);
    }

    public boolean isPassword() {
        return Uj.aE(this.Uk);
    }

    public boolean isScrollable() {
        return Uj.aF(this.Uk);
    }

    public void setScrollable(boolean z) {
        Uj.mo3455h(this.Uk, z);
    }

    public CharSequence getPackageName() {
        return Uj.av(this.Uk);
    }

    public void setPackageName(CharSequence charSequence) {
        Uj.mo3450g(this.Uk, charSequence);
    }

    public CharSequence getClassName() {
        return Uj.at(this.Uk);
    }

    public void setClassName(CharSequence charSequence) {
        Uj.mo3442e(this.Uk, charSequence);
    }

    public CharSequence getText() {
        return Uj.aw(this.Uk);
    }

    public void setText(CharSequence charSequence) {
        Uj.mo3454h(this.Uk, charSequence);
    }

    public CharSequence getContentDescription() {
        return Uj.au(this.Uk);
    }

    public void setContentDescription(CharSequence charSequence) {
        Uj.mo3446f(this.Uk, charSequence);
    }

    public void recycle() {
        Uj.aH(this.Uk);
    }

    public String getViewIdResourceName() {
        return Uj.aL(this.Uk);
    }

    public void ap(Object obj) {
        Uj.mo3447f(this.Uk, ((C3882m) obj).Uk);
    }

    public void aq(Object obj) {
        Uj.mo3451g(this.Uk, ((C3883n) obj).Uk);
    }

    public void setContentInvalid(boolean z) {
        Uj.mo3468l(this.Uk, z);
    }

    public void setError(CharSequence charSequence) {
        Uj.mo3439d(this.Uk, charSequence);
    }

    public void setLabelFor(View view) {
        Uj.mo3456i(this.Uk, view);
    }

    public void setDismissable(boolean z) {
        Uj.mo3469m(this.Uk, z);
    }

    public int hashCode() {
        return this.Uk == null ? 0 : this.Uk.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ml mlVar = (ml) obj;
        if (this.Uk == null) {
            if (mlVar.Uk != null) {
                return false;
            }
            return true;
        } else if (this.Uk.equals(mlVar.Uk)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(getPackageName());
        stringBuilder.append("; className: ").append(getClassName());
        stringBuilder.append("; text: ").append(getText());
        stringBuilder.append("; contentDescription: ").append(getContentDescription());
        stringBuilder.append("; viewId: ").append(getViewIdResourceName());
        stringBuilder.append("; checkable: ").append(isCheckable());
        stringBuilder.append("; checked: ").append(isChecked());
        stringBuilder.append("; focusable: ").append(isFocusable());
        stringBuilder.append("; focused: ").append(isFocused());
        stringBuilder.append("; selected: ").append(isSelected());
        stringBuilder.append("; clickable: ").append(isClickable());
        stringBuilder.append("; longClickable: ").append(isLongClickable());
        stringBuilder.append("; enabled: ").append(isEnabled());
        stringBuilder.append("; password: ").append(isPassword());
        stringBuilder.append("; scrollable: " + isScrollable());
        stringBuilder.append("; [");
        int actions = getActions();
        while (actions != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            actions &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(bw(numberOfTrailingZeros));
            if (actions != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String bw(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case Allocation.USAGE_SHARED /*128*/:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /*65536*/:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
