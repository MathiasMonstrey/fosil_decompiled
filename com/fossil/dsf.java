package com.fossil;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.misfit.frameworks.common.log.MFLogger;

class dsf implements OnAttachStateChangeListener, OnGlobalLayoutListener {
    private static final String TAG = dsf.class.getSimpleName();
    @SuppressLint({"StaticFieldLeak"})
    private static dsf dpG;
    private final View dpA;
    private final int dpB;
    private final int dpC;
    private final String dpD;
    private dsg dpE;
    private boolean dpF = false;
    private final OnClickListener dpu;
    private final int dpv;
    private final int dpw;
    private final int dpx;
    private final int dpy;

    dsf(View view, int i, int i2, OnClickListener onClickListener, int i3, int i4, int i5, int i6) {
        this.dpA = view;
        this.dpB = i;
        this.dpC = i2;
        this.dpu = onClickListener;
        this.dpv = i3;
        this.dpw = i4;
        this.dpx = i5;
        this.dpD = null;
        this.dpy = i6;
    }

    dsf(View view, String str, int i, OnClickListener onClickListener, int i2, int i3, int i4, int i5) {
        this.dpA = view;
        this.dpB = -1;
        this.dpD = str;
        this.dpC = i;
        this.dpu = onClickListener;
        this.dpv = i2;
        this.dpw = i3;
        this.dpx = i4;
        this.dpy = i5;
    }

    public void onGlobalLayout() {
        MFLogger.m12670d(TAG, "onGlobalLayout");
        this.dpE.db(this.dpA);
        this.dpA.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        MFLogger.m12670d(TAG, "onViewAttachedToWindow: v = " + view);
    }

    public void onViewDetachedFromWindow(View view) {
        MFLogger.m12670d(TAG, "onViewDetachedFromWindow: v = " + view);
        hide();
    }

    void show() {
        MFLogger.m12670d(TAG, "show");
        if (dpG != null) {
            dpG.hide();
        }
        dpG = this;
        this.dpE = new dsg(this.dpA.getContext());
        this.dpE.mn(this.dpB);
        this.dpE.setContent(this.dpD);
        this.dpE.m9617b(this.dpC, this.dpu);
        this.dpE.mp(this.dpv);
        this.dpE.mq(this.dpw);
        this.dpE.mr(this.dpx);
        this.dpE.mo(this.dpy);
        this.dpA.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.dpA.requestLayout();
        this.dpA.addOnAttachStateChangeListener(this);
        this.dpF = true;
    }

    void hide() {
        MFLogger.m12670d(TAG, "hide");
        if (dpG == this) {
            dpG = null;
            if (this.dpE != null) {
                this.dpE.hide();
                this.dpE = null;
                this.dpA.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.dpA.removeOnAttachStateChangeListener(this);
            } else {
                MFLogger.m12671e(TAG, "sActiveHandler.mPopup == null");
            }
        }
        this.dpF = false;
    }

    boolean isShowing() {
        return this.dpF;
    }

    static dsf awr() {
        return dpG;
    }
}
