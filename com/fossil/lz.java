package com.fossil;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class lz {
    static final C3849g TY;
    private WeakReference<View> TU;
    Runnable TV = null;
    Runnable TW = null;
    int TX = -1;

    interface C3849g {
        long mo3386a(lz lzVar, View view);

        void mo3387a(lz lzVar, View view, float f);

        void mo3388a(lz lzVar, View view, long j);

        void mo3389a(lz lzVar, View view, Interpolator interpolator);

        void mo3390a(lz lzVar, View view, md mdVar);

        void mo3391a(lz lzVar, View view, mf mfVar);

        void mo3392b(lz lzVar, View view);

        void mo3393b(lz lzVar, View view, float f);

        void mo3394b(lz lzVar, View view, long j);

        void mo3395c(lz lzVar, View view);

        void mo3396c(lz lzVar, View view, float f);
    }

    static class C3850a implements C3849g {
        WeakHashMap<View, Runnable> TZ = null;

        class C3848a implements Runnable {
            lz Ua;
            final /* synthetic */ C3850a Ub;
            WeakReference<View> wd;

            C3848a(C3850a c3850a, lz lzVar, View view) {
                this.Ub = c3850a;
                this.wd = new WeakReference(view);
                this.Ua = lzVar;
            }

            public void run() {
                View view = (View) this.wd.get();
                if (view != null) {
                    this.Ub.m12399d(this.Ua, view);
                }
            }
        }

        C3850a() {
        }

        public void mo3388a(lz lzVar, View view, long j) {
        }

        public void mo3387a(lz lzVar, View view, float f) {
            m12387e(lzVar, view);
        }

        public void mo3393b(lz lzVar, View view, float f) {
            m12387e(lzVar, view);
        }

        public void mo3396c(lz lzVar, View view, float f) {
            m12387e(lzVar, view);
        }

        public long mo3386a(lz lzVar, View view) {
            return 0;
        }

        public void mo3389a(lz lzVar, View view, Interpolator interpolator) {
        }

        public void mo3394b(lz lzVar, View view, long j) {
        }

        public void mo3392b(lz lzVar, View view) {
            m12387e(lzVar, view);
        }

        public void mo3395c(lz lzVar, View view) {
            aC(view);
            m12399d(lzVar, view);
        }

        public void mo3390a(lz lzVar, View view, md mdVar) {
            view.setTag(2113929216, mdVar);
        }

        public void mo3391a(lz lzVar, View view, mf mfVar) {
        }

        void m12399d(lz lzVar, View view) {
            md mdVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof md) {
                mdVar = (md) tag;
            } else {
                mdVar = null;
            }
            Runnable runnable = lzVar.TV;
            Runnable runnable2 = lzVar.TW;
            lzVar.TV = null;
            lzVar.TW = null;
            if (runnable != null) {
                runnable.run();
            }
            if (mdVar != null) {
                mdVar.mo81e(view);
                mdVar.mo82f(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            if (this.TZ != null) {
                this.TZ.remove(view);
            }
        }

        private void aC(View view) {
            if (this.TZ != null) {
                Runnable runnable = (Runnable) this.TZ.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void m12387e(lz lzVar, View view) {
            Runnable runnable = null;
            if (this.TZ != null) {
                runnable = (Runnable) this.TZ.get(view);
            }
            if (runnable == null) {
                runnable = new C3848a(this, lzVar, view);
                if (this.TZ == null) {
                    this.TZ = new WeakHashMap();
                }
                this.TZ.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    static class C3852b extends C3850a {
        WeakHashMap<View, Integer> Uc = null;

        static class C3851a implements md {
            lz Ua;
            boolean Ud;

            C3851a(lz lzVar) {
                this.Ua = lzVar;
            }

            public void mo81e(View view) {
                md mdVar;
                this.Ud = false;
                if (this.Ua.TX >= 0) {
                    li.m12244a(view, 2, null);
                }
                if (this.Ua.TV != null) {
                    Runnable runnable = this.Ua.TV;
                    this.Ua.TV = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof md) {
                    mdVar = (md) tag;
                } else {
                    mdVar = null;
                }
                if (mdVar != null) {
                    mdVar.mo81e(view);
                }
            }

            public void mo82f(View view) {
                if (this.Ua.TX >= 0) {
                    li.m12244a(view, this.Ua.TX, null);
                    this.Ua.TX = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.Ud) {
                    md mdVar;
                    if (this.Ua.TW != null) {
                        Runnable runnable = this.Ua.TW;
                        this.Ua.TW = null;
                        runnable.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof md) {
                        mdVar = (md) tag;
                    } else {
                        mdVar = null;
                    }
                    if (mdVar != null) {
                        mdVar.mo82f(view);
                    }
                    this.Ud = true;
                }
            }

            public void aD(View view) {
                md mdVar;
                Object tag = view.getTag(2113929216);
                if (tag instanceof md) {
                    mdVar = (md) tag;
                } else {
                    mdVar = null;
                }
                if (mdVar != null) {
                    mdVar.aD(view);
                }
            }
        }

        C3852b() {
        }

        public void mo3388a(lz lzVar, View view, long j) {
            ma.m12438b(view, j);
        }

        public void mo3387a(lz lzVar, View view, float f) {
            ma.m12440n(view, f);
        }

        public void mo3393b(lz lzVar, View view, float f) {
            ma.m12441o(view, f);
        }

        public void mo3396c(lz lzVar, View view, float f) {
            ma.m12442p(view, f);
        }

        public long mo3386a(lz lzVar, View view) {
            return ma.aE(view);
        }

        public void mo3389a(lz lzVar, View view, Interpolator interpolator) {
            ma.m12436a(view, interpolator);
        }

        public void mo3394b(lz lzVar, View view, long j) {
            ma.m12439c(view, j);
        }

        public void mo3392b(lz lzVar, View view) {
            ma.aF(view);
        }

        public void mo3395c(lz lzVar, View view) {
            ma.aG(view);
        }

        public void mo3390a(lz lzVar, View view, md mdVar) {
            view.setTag(2113929216, mdVar);
            ma.m12437a(view, new C3851a(lzVar));
        }
    }

    static class C3853d extends C3852b {
        C3853d() {
        }

        public void mo3390a(lz lzVar, View view, md mdVar) {
            mb.m12443a(view, mdVar);
        }
    }

    static class C3854c extends C3853d {
        C3854c() {
        }
    }

    static class C3855e extends C3854c {
        C3855e() {
        }

        public void mo3391a(lz lzVar, View view, mf mfVar) {
            mc.m12444a(view, mfVar);
        }
    }

    static class C3856f extends C3855e {
        C3856f() {
        }
    }

    lz(View view) {
        this.TU = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            TY = new C3856f();
        } else if (i >= 19) {
            TY = new C3855e();
        } else if (i >= 18) {
            TY = new C3854c();
        } else if (i >= 16) {
            TY = new C3853d();
        } else if (i >= 14) {
            TY = new C3852b();
        } else {
            TY = new C3850a();
        }
    }

    public lz m12418n(long j) {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3388a(this, view, j);
        }
        return this;
    }

    public lz m12420y(float f) {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3387a(this, view, f);
        }
        return this;
    }

    public lz m12421z(float f) {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3393b(this, view, f);
        }
        return this;
    }

    public lz m12414A(float f) {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3396c(this, view, f);
        }
        return this;
    }

    public long getDuration() {
        View view = (View) this.TU.get();
        if (view != null) {
            return TY.mo3386a(this, view);
        }
        return 0;
    }

    public lz m12417c(Interpolator interpolator) {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3389a(this, view, interpolator);
        }
        return this;
    }

    public lz m12419o(long j) {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3394b(this, view, j);
        }
        return this;
    }

    public void cancel() {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3392b(this, view);
        }
    }

    public void start() {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3395c(this, view);
        }
    }

    public lz m12415a(md mdVar) {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3390a(this, view, mdVar);
        }
        return this;
    }

    public lz m12416a(mf mfVar) {
        View view = (View) this.TU.get();
        if (view != null) {
            TY.mo3391a(this, view, mfVar);
        }
        return this;
    }
}
