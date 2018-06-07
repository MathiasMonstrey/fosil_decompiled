package com.fossil;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class lx {
    static final C3843b TT;

    interface C3843b {
        void mo3379a(ViewParent viewParent, View view);

        void mo3380a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void mo3381a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean mo3382a(ViewParent viewParent, View view, float f, float f2);

        boolean mo3383a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean mo3384a(ViewParent viewParent, View view, View view2, int i);

        void mo3385b(ViewParent viewParent, View view, View view2, int i);
    }

    static class C3844e implements C3843b {
        C3844e() {
        }

        public boolean mo3384a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof kx) {
                return ((kx) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void mo3385b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof kx) {
                ((kx) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void mo3379a(ViewParent viewParent, View view) {
            if (viewParent instanceof kx) {
                ((kx) viewParent).onStopNestedScroll(view);
            }
        }

        public void mo3380a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof kx) {
                ((kx) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void mo3381a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof kx) {
                ((kx) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean mo3383a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof kx) {
                return ((kx) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean mo3382a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof kx) {
                return ((kx) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    static class C3845a extends C3844e {
        C3845a() {
        }
    }

    static class C3846c extends C3845a {
        C3846c() {
        }
    }

    static class C3847d extends C3846c {
        C3847d() {
        }

        public boolean mo3384a(ViewParent viewParent, View view, View view2, int i) {
            return ly.m12374a(viewParent, view, view2, i);
        }

        public void mo3385b(ViewParent viewParent, View view, View view2, int i) {
            ly.m12375b(viewParent, view, view2, i);
        }

        public void mo3379a(ViewParent viewParent, View view) {
            ly.m12369a(viewParent, view);
        }

        public void mo3380a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            ly.m12370a(viewParent, view, i, i2, i3, i4);
        }

        public void mo3381a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            ly.m12371a(viewParent, view, i, i2, iArr);
        }

        public boolean mo3383a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return ly.m12373a(viewParent, view, f, f2, z);
        }

        public boolean mo3382a(ViewParent viewParent, View view, float f, float f2) {
            return ly.m12372a(viewParent, view, f, f2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            TT = new C3847d();
        } else if (i >= 19) {
            TT = new C3846c();
        } else if (i >= 14) {
            TT = new C3845a();
        } else {
            TT = new C3844e();
        }
    }

    public static boolean m12367a(ViewParent viewParent, View view, View view2, int i) {
        return TT.mo3384a(viewParent, view, view2, i);
    }

    public static void m12368b(ViewParent viewParent, View view, View view2, int i) {
        TT.mo3385b(viewParent, view, view2, i);
    }

    public static void m12362a(ViewParent viewParent, View view) {
        TT.mo3379a(viewParent, view);
    }

    public static void m12363a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        TT.mo3380a(viewParent, view, i, i2, i3, i4);
    }

    public static void m12364a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        TT.mo3381a(viewParent, view, i, i2, iArr);
    }

    public static boolean m12366a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return TT.mo3383a(viewParent, view, f, f2, z);
    }

    public static boolean m12365a(ViewParent viewParent, View view, float f, float f2) {
        return TT.mo3382a(viewParent, view, f, f2);
    }
}
