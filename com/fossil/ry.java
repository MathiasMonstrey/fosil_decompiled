package com.fossil;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public abstract class ry implements OnTouchListener {
    private final float amO;
    private final int amP;
    private final int amQ;
    final View amR;
    private Runnable amS;
    private Runnable amT;
    private boolean amU;
    private final int[] amV = new int[2];
    private int mActivePointerId;

    class C40621 implements OnAttachStateChangeListener {
        final /* synthetic */ ry amW;

        C40621(ry ryVar) {
            this.amW = ryVar;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.amW.onDetachedFromWindow();
        }
    }

    class C40632 implements OnGlobalLayoutListener {
        final /* synthetic */ ry amW;
        boolean amX = li.au(this.amW.amR);

        C40632(ry ryVar) {
            this.amW = ryVar;
        }

        public void onGlobalLayout() {
            boolean z = this.amX;
            this.amX = li.au(this.amW.amR);
            if (z && !this.amX) {
                this.amW.onDetachedFromWindow();
            }
        }
    }

    class C4064a implements Runnable {
        final /* synthetic */ ry amW;

        C4064a(ry ryVar) {
            this.amW = ryVar;
        }

        public void run() {
            ViewParent parent = this.amW.amR.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    class C4065b implements Runnable {
        final /* synthetic */ ry amW;

        C4065b(ry ryVar) {
            this.amW = ryVar;
        }

        public void run() {
            this.amW.oS();
        }
    }

    public abstract qu mC();

    public ry(View view) {
        this.amR = view;
        view.setLongClickable(true);
        if (VERSION.SDK_INT >= 12) {
            bE(view);
        } else {
            bF(view);
        }
        this.amO = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.amP = ViewConfiguration.getTapTimeout();
        this.amQ = (this.amP + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @TargetApi(12)
    private void bE(View view) {
        view.addOnAttachStateChangeListener(new C40621(this));
    }

    private void bF(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new C40632(this));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.amU;
        if (!z2) {
            boolean z3 = m13250h(motionEvent) && mD();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.amR.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        } else if (m13251i(motionEvent) || !nN()) {
            z = true;
        } else {
            z = false;
        }
        this.amU = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    private void onDetachedFromWindow() {
        this.amU = false;
        this.mActivePointerId = -1;
        if (this.amS != null) {
            this.amR.removeCallbacks(this.amS);
        }
    }

    public boolean mD() {
        qu mC = mC();
        if (!(mC == null || mC.isShowing())) {
            mC.show();
        }
        return true;
    }

    public boolean nN() {
        qu mC = mC();
        if (mC != null && mC.isShowing()) {
            mC.dismiss();
        }
        return true;
    }

    private boolean m13250h(MotionEvent motionEvent) {
        View view = this.amR;
        if (!view.isEnabled()) {
            return false;
        }
        switch (ks.a(motionEvent)) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (this.amS == null) {
                    this.amS = new C4064a(this);
                }
                view.postDelayed(this.amS, (long) this.amP);
                if (this.amT == null) {
                    this.amT = new C4065b(this);
                }
                view.postDelayed(this.amT, (long) this.amQ);
                return false;
            case 1:
            case 3:
                oR();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex < 0 || m13247a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.amO)) {
                    return false;
                }
                oR();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private void oR() {
        if (this.amT != null) {
            this.amR.removeCallbacks(this.amT);
        }
        if (this.amS != null) {
            this.amR.removeCallbacks(this.amS);
        }
    }

    void oS() {
        oR();
        View view = this.amR;
        if (view.isEnabled() && !view.isLongClickable() && mD()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.amU = true;
        }
    }

    private boolean m13251i(MotionEvent motionEvent) {
        View view = this.amR;
        qu mC = mC();
        if (mC == null || !mC.isShowing()) {
            return false;
        }
        rw rwVar = (rw) mC.getListView();
        if (rwVar == null || !rwVar.isShown()) {
            return false;
        }
        boolean z;
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m13249b(view, obtainNoHistory);
        m13248a(rwVar, obtainNoHistory);
        boolean g = rwVar.mo4097g(obtainNoHistory, this.mActivePointerId);
        obtainNoHistory.recycle();
        int a = ks.a(motionEvent);
        if (a == 1 || a == 3) {
            z = false;
        } else {
            z = true;
        }
        if (g && r0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private static boolean m13247a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean m13248a(View view, MotionEvent motionEvent) {
        int[] iArr = this.amV;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean m13249b(View view, MotionEvent motionEvent) {
        int[] iArr = this.amV;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }
}
