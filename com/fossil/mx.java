package com.fossil;

import android.os.Build.VERSION;

public class mx {
    private static final C3894c UZ;
    private final Object Va;

    interface C3894c {
        void mo3478d(Object obj, int i);

        void mo3479e(Object obj, int i);

        void mo3480f(Object obj, int i);

        void mo3481g(Object obj, int i);

        void mo3482h(Object obj, int i);

        void mo3483h(Object obj, boolean z);

        void mo3484i(Object obj, int i);

        void mo3485j(Object obj, int i);
    }

    static class C3895e implements C3894c {
        C3895e() {
        }

        public void mo3478d(Object obj, int i) {
        }

        public void mo3479e(Object obj, int i) {
        }

        public void mo3484i(Object obj, int i) {
        }

        public void mo3485j(Object obj, int i) {
        }

        public void mo3480f(Object obj, int i) {
        }

        public void mo3481g(Object obj, int i) {
        }

        public void mo3483h(Object obj, boolean z) {
        }

        public void mo3482h(Object obj, int i) {
        }
    }

    static class C3896a extends C3895e {
        C3896a() {
        }

        public void mo3478d(Object obj, int i) {
            my.m12636d(obj, i);
        }

        public void mo3479e(Object obj, int i) {
            my.m12637e(obj, i);
        }

        public void mo3480f(Object obj, int i) {
            my.m12638f(obj, i);
        }

        public void mo3481g(Object obj, int i) {
            my.m12639g(obj, i);
        }

        public void mo3483h(Object obj, boolean z) {
            my.m12641h(obj, z);
        }

        public void mo3482h(Object obj, int i) {
            my.m12640h(obj, i);
        }
    }

    static class C3897b extends C3896a {
        C3897b() {
        }

        public void mo3484i(Object obj, int i) {
            mz.m12642i(obj, i);
        }

        public void mo3485j(Object obj, int i) {
            mz.m12643j(obj, i);
        }
    }

    static class C3898d extends C3897b {
        C3898d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            UZ = new C3898d();
        } else if (VERSION.SDK_INT >= 15) {
            UZ = new C3897b();
        } else if (VERSION.SDK_INT >= 14) {
            UZ = new C3896a();
        } else {
            UZ = new C3895e();
        }
    }

    @Deprecated
    public mx(Object obj) {
        this.Va = obj;
    }

    public void setScrollable(boolean z) {
        UZ.mo3483h(this.Va, z);
    }

    public void setItemCount(int i) {
        UZ.mo3479e(this.Va, i);
    }

    public void setFromIndex(int i) {
        UZ.mo3478d(this.Va, i);
    }

    public void setToIndex(int i) {
        UZ.mo3482h(this.Va, i);
    }

    public void setScrollX(int i) {
        UZ.mo3480f(this.Va, i);
    }

    public void setScrollY(int i) {
        UZ.mo3481g(this.Va, i);
    }

    public void setMaxScrollX(int i) {
        UZ.mo3484i(this.Va, i);
    }

    public void setMaxScrollY(int i) {
        UZ.mo3485j(this.Va, i);
    }

    public int hashCode() {
        return this.Va == null ? 0 : this.Va.hashCode();
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
        mx mxVar = (mx) obj;
        if (this.Va == null) {
            if (mxVar.Va != null) {
                return false;
            }
            return true;
        } else if (this.Va.equals(mxVar.Va)) {
            return true;
        } else {
            return false;
        }
    }
}
