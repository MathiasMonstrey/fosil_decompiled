package com.fossil;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

class vj implements vp {
    private final C4159b aCk = new C4159b();
    private final vn<C4158a, Bitmap> aCl = new vn();

    static class C4158a implements vq {
        private final C4159b aCm;
        private Config aCn;
        private int height;
        private int width;

        public C4158a(C4159b c4159b) {
            this.aCm = c4159b;
        }

        public void m13905f(int i, int i2, Config config) {
            this.width = i;
            this.height = i2;
            this.aCn = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C4158a)) {
                return false;
            }
            C4158a c4158a = (C4158a) obj;
            if (this.width == c4158a.width && this.height == c4158a.height && this.aCn == c4158a.aCn) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.aCn != null ? this.aCn.hashCode() : 0) + (((this.width * 31) + this.height) * 31);
        }

        public String toString() {
            return vj.m13913d(this.width, this.height, this.aCn);
        }

        public void va() {
            this.aCm.m13906a(this);
        }
    }

    static class C4159b extends vk<C4158a> {
        C4159b() {
        }

        protected /* synthetic */ vq vc() {
            return vb();
        }

        public C4158a m13907g(int i, int i2, Config config) {
            C4158a c4158a = (C4158a) vd();
            c4158a.m13905f(i, i2, config);
            return c4158a;
        }

        protected C4158a vb() {
            return new C4158a(this);
        }
    }

    vj() {
    }

    public void mo4210f(Bitmap bitmap) {
        this.aCl.m13932a(this.aCk.m13907g(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap mo4208b(int i, int i2, Config config) {
        return (Bitmap) this.aCl.m13933b(this.aCk.m13907g(i, i2, config));
    }

    public Bitmap uZ() {
        return (Bitmap) this.aCl.removeLast();
    }

    public String mo4211g(Bitmap bitmap) {
        return m13915i(bitmap);
    }

    public String mo4209c(int i, int i2, Config config) {
        return m13913d(i, i2, config);
    }

    public int mo4212h(Bitmap bitmap) {
        return abl.p(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.aCl;
    }

    private static String m13915i(Bitmap bitmap) {
        return m13913d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    private static String m13913d(int i, int i2, Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }
}
