package com.fossil;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class bg {
    private static bg Al;
    private final Object Am = new Object();
    private C1922b An;
    private C1922b Ao;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new C19201(this));

    class C19201 implements Callback {
        final /* synthetic */ bg Ap;

        C19201(bg bgVar) {
            this.Ap = bgVar;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.Ap.m5123b((C1922b) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    }

    interface C1921a {
        void ag(int i);

        void show();
    }

    static class C1922b {
        final WeakReference<C1921a> Aq;
        boolean Ar;
        int duration;

        boolean m5115h(C1921a c1921a) {
            return c1921a != null && this.Aq.get() == c1921a;
        }
    }

    static bg gB() {
        if (Al == null) {
            Al = new bg();
        }
        return Al;
    }

    private bg() {
    }

    public void m5121a(C1921a c1921a, int i) {
        synchronized (this.Am) {
            if (m5118f(c1921a)) {
                m5117a(this.An, i);
            } else if (m5119g(c1921a)) {
                m5117a(this.Ao, i);
            }
        }
    }

    public void m5120a(C1921a c1921a) {
        synchronized (this.Am) {
            if (m5118f(c1921a)) {
                this.An = null;
                if (this.Ao != null) {
                    gC();
                }
            }
        }
    }

    public void m5122b(C1921a c1921a) {
        synchronized (this.Am) {
            if (m5118f(c1921a)) {
                m5116a(this.An);
            }
        }
    }

    public void m5124c(C1921a c1921a) {
        synchronized (this.Am) {
            if (m5118f(c1921a) && !this.An.Ar) {
                this.An.Ar = true;
                this.mHandler.removeCallbacksAndMessages(this.An);
            }
        }
    }

    public void m5125d(C1921a c1921a) {
        synchronized (this.Am) {
            if (m5118f(c1921a) && this.An.Ar) {
                this.An.Ar = false;
                m5116a(this.An);
            }
        }
    }

    public boolean m5126e(C1921a c1921a) {
        boolean z;
        synchronized (this.Am) {
            z = m5118f(c1921a) || m5119g(c1921a);
        }
        return z;
    }

    private void gC() {
        if (this.Ao != null) {
            this.An = this.Ao;
            this.Ao = null;
            C1921a c1921a = (C1921a) this.An.Aq.get();
            if (c1921a != null) {
                c1921a.show();
            } else {
                this.An = null;
            }
        }
    }

    private boolean m5117a(C1922b c1922b, int i) {
        C1921a c1921a = (C1921a) c1922b.Aq.get();
        if (c1921a == null) {
            return false;
        }
        this.mHandler.removeCallbacksAndMessages(c1922b);
        c1921a.ag(i);
        return true;
    }

    private boolean m5118f(C1921a c1921a) {
        return this.An != null && this.An.m5115h(c1921a);
    }

    private boolean m5119g(C1921a c1921a) {
        return this.Ao != null && this.Ao.m5115h(c1921a);
    }

    private void m5116a(C1922b c1922b) {
        if (c1922b.duration != -2) {
            int i = 2750;
            if (c1922b.duration > 0) {
                i = c1922b.duration;
            } else if (c1922b.duration == -1) {
                i = 1500;
            }
            this.mHandler.removeCallbacksAndMessages(c1922b);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, c1922b), (long) i);
        }
    }

    void m5123b(C1922b c1922b) {
        synchronized (this.Am) {
            if (this.An == c1922b || this.Ao == c1922b) {
                m5117a(c1922b, 2);
            }
        }
    }
}
