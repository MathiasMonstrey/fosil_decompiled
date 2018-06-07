package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class aba<T extends View, Z> extends aaq<Z> {
    private static boolean aGK = false;
    private static Integer aGL = null;
    private final C1558a aGM;
    protected final T view;

    static class C1558a {
        private final List<aax> aBN = new ArrayList();
        private C1557a aGN;
        private Point aGO;
        private final View view;

        static class C1557a implements OnPreDrawListener {
            private final WeakReference<C1558a> aGP;

            public C1557a(C1558a c1558a) {
                this.aGP = new WeakReference(c1558a);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
                }
                C1558a c1558a = (C1558a) this.aGP.get();
                if (c1558a != null) {
                    c1558a.wO();
                }
                return true;
            }
        }

        public C1558a(View view) {
            this.view = view;
        }

        private void bf(int i, int i2) {
            for (aax be : this.aBN) {
                be.be(i, i2);
            }
            this.aBN.clear();
        }

        private void wO() {
            if (!this.aBN.isEmpty()) {
                int wQ = wQ();
                int wP = wP();
                if (eO(wQ) && eO(wP)) {
                    bf(wQ, wP);
                    ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this.aGN);
                    }
                    this.aGN = null;
                }
            }
        }

        public void m2850a(aax com_fossil_aax) {
            int wQ = wQ();
            int wP = wP();
            if (eO(wQ) && eO(wP)) {
                com_fossil_aax.be(wQ, wP);
                return;
            }
            if (!this.aBN.contains(com_fossil_aax)) {
                this.aBN.add(com_fossil_aax);
            }
            if (this.aGN == null) {
                ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                this.aGN = new C1557a(this);
                viewTreeObserver.addOnPreDrawListener(this.aGN);
            }
        }

        private int wP() {
            LayoutParams layoutParams = this.view.getLayoutParams();
            if (eO(this.view.getHeight())) {
                return this.view.getHeight();
            }
            if (layoutParams != null) {
                return m2849n(layoutParams.height, true);
            }
            return 0;
        }

        private int wQ() {
            LayoutParams layoutParams = this.view.getLayoutParams();
            if (eO(this.view.getWidth())) {
                return this.view.getWidth();
            }
            if (layoutParams != null) {
                return m2849n(layoutParams.width, false);
            }
            return 0;
        }

        private int m2849n(int i, boolean z) {
            if (i != -2) {
                return i;
            }
            Point wR = wR();
            return z ? wR.y : wR.x;
        }

        @TargetApi(13)
        private Point wR() {
            if (this.aGO != null) {
                return this.aGO;
            }
            Display defaultDisplay = ((WindowManager) this.view.getContext().getSystemService("window")).getDefaultDisplay();
            if (VERSION.SDK_INT >= 13) {
                this.aGO = new Point();
                defaultDisplay.getSize(this.aGO);
            } else {
                this.aGO = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.aGO;
        }

        private boolean eO(int i) {
            return i > 0 || i == -2;
        }
    }

    public aba(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.view = t;
        this.aGM = new C1558a(t);
    }

    public T getView() {
        return this.view;
    }

    public void mo764a(aax com_fossil_aax) {
        this.aGM.m2850a(com_fossil_aax);
    }

    public void mo767f(aad com_fossil_aad) {
        setTag(com_fossil_aad);
    }

    public aad wD() {
        Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof aad) {
            return (aad) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    private void setTag(Object obj) {
        if (aGL == null) {
            aGK = true;
            this.view.setTag(obj);
            return;
        }
        this.view.setTag(aGL.intValue(), obj);
    }

    private Object getTag() {
        if (aGL == null) {
            return this.view.getTag();
        }
        return this.view.getTag(aGL.intValue());
    }

    public String toString() {
        return "Target for: " + this.view;
    }
}
