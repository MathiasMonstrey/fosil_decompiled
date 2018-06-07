package com.fossil;

import android.os.Build.VERSION;

public class mg {
    private static final C3861d Ug;
    private final Object Uh;

    interface C3861d {
        mg mo3397a(Object obj, int i, int i2, int i3, int i4);

        mg ag(Object obj);

        int ah(Object obj);

        int ai(Object obj);

        int aj(Object obj);

        int ak(Object obj);

        boolean al(Object obj);

        boolean am(Object obj);
    }

    static class C3862c implements C3861d {
        C3862c() {
        }

        public int ai(Object obj) {
            return 0;
        }

        public int ak(Object obj) {
            return 0;
        }

        public int aj(Object obj) {
            return 0;
        }

        public int ah(Object obj) {
            return 0;
        }

        public boolean al(Object obj) {
            return false;
        }

        public boolean am(Object obj) {
            return false;
        }

        public mg ag(Object obj) {
            return null;
        }

        public mg mo3397a(Object obj, int i, int i2, int i3, int i4) {
            return null;
        }
    }

    static class C3863a extends C3862c {
        C3863a() {
        }

        public mg ag(Object obj) {
            return new mg(mh.an(obj));
        }

        public int ah(Object obj) {
            return mh.ah(obj);
        }

        public int ai(Object obj) {
            return mh.ai(obj);
        }

        public int aj(Object obj) {
            return mh.aj(obj);
        }

        public int ak(Object obj) {
            return mh.ak(obj);
        }

        public boolean al(Object obj) {
            return mh.al(obj);
        }

        public mg mo3397a(Object obj, int i, int i2, int i3, int i4) {
            return new mg(mh.m12450b(obj, i, i2, i3, i4));
        }
    }

    static class C3864b extends C3863a {
        C3864b() {
        }

        public boolean am(Object obj) {
            return mi.am(obj);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            Ug = new C3864b();
        } else if (i >= 20) {
            Ug = new C3863a();
        } else {
            Ug = new C3862c();
        }
    }

    mg(Object obj) {
        this.Uh = obj;
    }

    public int getSystemWindowInsetLeft() {
        return Ug.ai(this.Uh);
    }

    public int getSystemWindowInsetTop() {
        return Ug.ak(this.Uh);
    }

    public int getSystemWindowInsetRight() {
        return Ug.aj(this.Uh);
    }

    public int getSystemWindowInsetBottom() {
        return Ug.ah(this.Uh);
    }

    public boolean hasSystemWindowInsets() {
        return Ug.al(this.Uh);
    }

    public boolean isConsumed() {
        return Ug.am(this.Uh);
    }

    public mg jT() {
        return Ug.ag(this.Uh);
    }

    public mg m12449h(int i, int i2, int i3, int i4) {
        return Ug.mo3397a(this.Uh, i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        mg mgVar = (mg) obj;
        if (this.Uh != null) {
            return this.Uh.equals(mgVar.Uh);
        }
        if (mgVar.Uh != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.Uh == null ? 0 : this.Uh.hashCode();
    }

    static mg af(Object obj) {
        return obj == null ? null : new mg(obj);
    }

    static Object m12448f(mg mgVar) {
        return mgVar == null ? null : mgVar.Uh;
    }
}
