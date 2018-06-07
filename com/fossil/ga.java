package com.fossil;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ga implements OnAttachStateChangeListener, OnPreDrawListener {
    private final Runnable Dc;
    private ViewTreeObserver LZ;
    private final View mView;

    private ga(View view, Runnable runnable) {
        this.mView = view;
        this.LZ = view.getViewTreeObserver();
        this.Dc = runnable;
    }

    public static ga m11502a(View view, Runnable runnable) {
        ga gaVar = new ga(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(gaVar);
        view.addOnAttachStateChangeListener(gaVar);
        return gaVar;
    }

    public boolean onPreDraw() {
        iH();
        this.Dc.run();
        return true;
    }

    public void iH() {
        if (this.LZ.isAlive()) {
            this.LZ.removeOnPreDrawListener(this);
        } else {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.mView.removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        this.LZ = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        iH();
    }
}
