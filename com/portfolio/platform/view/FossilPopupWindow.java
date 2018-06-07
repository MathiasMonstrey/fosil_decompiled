package com.portfolio.platform.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.PopupWindow.OnDismissListener;
import com.facebook.internal.NativeProtocol;
import com.fossil.cjz.a;
import java.lang.ref.WeakReference;

public class FossilPopupWindow {
    private View adu;
    private boolean aec;
    private OnDismissListener afM;
    private Drawable aga;
    private Rect ahg;
    private boolean akP;
    private int aqU;
    private int aqV;
    private Object diP;
    private final int[] diQ;
    private final int[] diR;
    private WindowManager diS;
    private boolean diT;
    private boolean diU;
    private boolean diV;
    private C4990b diW;
    private View diX;
    private int diY;
    private int diZ;
    private final OnScrollChangedListener djA;
    private int djB;
    private int djC;
    private int djD;
    private boolean djE;
    private boolean dja;
    private boolean djb;
    private boolean djc;
    private int djd;
    private boolean dje;
    private boolean djf;
    private boolean djg;
    private boolean djh;
    private boolean dji;
    private boolean djj;
    private boolean djk;
    private OnTouchListener djl;
    private int djm;
    private int djn;
    private Drawable djo;
    private Drawable djp;
    private Transition djq;
    private Transition djr;
    private boolean djs;
    private int djt;
    private boolean dju;
    private int djv;
    private final OnAttachStateChangeListener djw;
    private WeakReference<View> djx;
    private WeakReference<View> djy;
    private boolean djz;
    private Context mContext;
    private int mGravity;
    private int pS;
    private int pT;
    private final Rect uU;

    class C49851 implements OnAttachStateChangeListener {
        final /* synthetic */ FossilPopupWindow djF;

        C49851(FossilPopupWindow fossilPopupWindow) {
            this.djF = fossilPopupWindow;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.djF.djz = false;
        }
    }

    class C49862 implements OnScrollChangedListener {
        final /* synthetic */ FossilPopupWindow djF;

        C49862(FossilPopupWindow fossilPopupWindow) {
            this.djF = fossilPopupWindow;
        }

        public void onScrollChanged() {
            View view = this.djF.djx != null ? (View) this.djF.djx.get() : null;
            if (view != null && this.djF.diW != null) {
                LayoutParams layoutParams = (LayoutParams) this.djF.diW.getLayoutParams();
                this.djF.dr(this.djF.m15877a(view, layoutParams, this.djF.djB, this.djF.djC, layoutParams.width, layoutParams.height, this.djF.djD));
                this.djF.update(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        }
    }

    class C4987a extends FrameLayout {
        final /* synthetic */ FossilPopupWindow djF;

        public C4987a(FossilPopupWindow fossilPopupWindow, Context context) {
            this.djF = fossilPopupWindow;
            super(context);
        }

        protected int[] onCreateDrawableState(int i) {
            return super.onCreateDrawableState(i);
        }
    }

    class C4990b extends FrameLayout {
        final /* synthetic */ FossilPopupWindow djF;
        private final OnAttachStateChangeListener djw = new C49892(this);

        class C49892 implements OnAttachStateChangeListener {
            final /* synthetic */ C4990b djH;

            C49892(C4990b c4990b) {
                this.djH = c4990b;
            }

            public void onViewAttachedToWindow(View view) {
            }

            public void onViewDetachedFromWindow(View view) {
                view.removeOnAttachStateChangeListener(this);
            }
        }

        public C4990b(FossilPopupWindow fossilPopupWindow, Context context) {
            this.djF = fossilPopupWindow;
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() != 4) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 1) {
                keyDispatcherState = getKeyDispatcherState();
                if (!(keyDispatcherState == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled())) {
                    return super.dispatchKeyEvent(keyEvent);
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return (this.djF.djl != null && this.djF.djl.onTouch(this, motionEvent)) || super.dispatchTouchEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
                this.djF.dismiss();
                return true;
            } else if (motionEvent.getAction() != 4) {
                return super.onTouchEvent(motionEvent);
            } else {
                this.djF.dismiss();
                return true;
            }
        }

        public void m15873b(Transition transition) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null && transition != null) {
                final Transition clone = transition.clone();
                viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ C4990b djH;

                    public void onGlobalLayout() {
                        ViewTreeObserver viewTreeObserver = this.djH.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                        }
                        this.djH.m15872c(clone);
                    }
                });
            }
        }

        private void m15872c(Transition transition) {
            int i;
            int childCount = getChildCount();
            for (i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                transition.addTarget(childAt);
                childAt.setVisibility(4);
            }
            TransitionManager.beginDelayedTransition(this, transition);
            for (i = 0; i < childCount; i++) {
                getChildAt(i).setVisibility(0);
            }
        }

        public void avu() {
        }
    }

    public FossilPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FossilPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public FossilPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.diQ = new int[2];
        this.diR = new int[2];
        this.uU = new Rect();
        this.diY = 0;
        this.diZ = 1;
        this.dja = true;
        this.djb = false;
        this.djc = true;
        this.djd = -1;
        this.djg = true;
        this.djh = false;
        this.djj = true;
        this.djk = false;
        this.pS = -2;
        this.pT = -2;
        this.djt = 1000;
        this.dju = false;
        this.djv = -1;
        this.mGravity = 0;
        this.djw = new C49851(this);
        this.djA = new C49862(this);
        this.mContext = context;
        this.diS = (WindowManager) context.getSystemService("window");
        context.obtainStyledAttributes(attributeSet, a.PopupWindow, i, i2).recycle();
    }

    public FossilPopupWindow() {
        this(null, 0, 0);
    }

    public FossilPopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public FossilPopupWindow(View view, int i, int i2, boolean z) {
        this.diQ = new int[2];
        this.diR = new int[2];
        this.uU = new Rect();
        this.diY = 0;
        this.diZ = 1;
        this.dja = true;
        this.djb = false;
        this.djc = true;
        this.djd = -1;
        this.djg = true;
        this.djh = false;
        this.djj = true;
        this.djk = false;
        this.pS = -2;
        this.pT = -2;
        this.djt = 1000;
        this.dju = false;
        this.djv = -1;
        this.mGravity = 0;
        this.djw = new C49851(this);
        this.djA = new C49862(this);
        if (view != null) {
            this.mContext = view.getContext();
            this.diS = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    public void setContentView(View view) {
        if (!isShowing()) {
            this.adu = view;
            if (this.mContext == null && this.adu != null) {
                this.mContext = this.adu.getContext();
            }
            if (this.diS == null && this.adu != null) {
                this.diS = (WindowManager) this.mContext.getSystemService("window");
            }
            if (this.mContext != null && !this.djk) {
                setAttachedInDecor(this.mContext.getApplicationInfo().targetSdkVersion >= 22);
            }
        }
    }

    public void setFocusable(boolean z) {
        this.aec = z;
    }

    public void setOutsideTouchable(boolean z) {
        this.djb = z;
    }

    public boolean isSplitTouchEnabled() {
        if (this.djd >= 0 || this.mContext == null) {
            if (this.djd != 1) {
                return false;
            }
            return true;
        } else if (this.mContext.getApplicationInfo().targetSdkVersion >= 11) {
            return true;
        } else {
            return false;
        }
    }

    public void setAttachedInDecor(boolean z) {
        this.djj = z;
        this.djk = true;
    }

    public void ao(boolean z) {
        this.dji = !z;
    }

    public void setHeight(int i) {
        this.pT = i;
    }

    public void setWidth(int i) {
        this.pS = i;
    }

    public boolean isShowing() {
        return this.diT;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        m15893a(view.getWindowToken(), i, i2, i3);
    }

    public void m15893a(IBinder iBinder, int i, int i2, int i3) {
        if (!isShowing() && this.adu != null) {
            TransitionManager.endTransitions(this.diW);
            avt();
            this.diT = true;
            this.diV = false;
            this.mGravity = i;
            LayoutParams r = m15892r(iBinder);
            m15876a(r);
            r.x = i2;
            r.y = i3;
            m15884b(r);
        }
    }

    public void showAsDropDown(View view) {
        showAsDropDown(view, 0, 0);
    }

    public void showAsDropDown(View view, int i, int i2) {
        showAsDropDown(view, i, i2, 8388659);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (!isShowing() && this.adu != null) {
            m15883b(view, i, i2, i3);
            this.diT = true;
            this.diV = true;
            LayoutParams r = m15892r(view.getWindowToken());
            m15876a(r);
            dr(m15877a(view, r, i, i2, r.width, r.height, i3));
            m15884b(r);
        }
    }

    private void dr(boolean z) {
        if (z != this.djs) {
            this.djs = z;
            if (this.aga != null && this.diX != null) {
                if (this.djo == null) {
                    this.diX.refreshDrawableState();
                } else if (this.djs) {
                    this.diX.setBackground(this.djo);
                } else {
                    this.diX.setBackground(this.djp);
                }
            }
        }
    }

    private void m15876a(LayoutParams layoutParams) {
        if (this.adu == null || this.mContext == null || this.diS == null) {
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
        if (this.diW != null) {
            this.diW.avu();
        }
        if (this.aga != null) {
            this.diX = cY(this.adu);
            this.diX.setBackground(this.aga);
        } else {
            this.diX = this.adu;
        }
        this.diW = cZ(this.diX);
    }

    private C4987a cY(View view) {
        int i = -2;
        ViewGroup.LayoutParams layoutParams = this.adu.getLayoutParams();
        if (layoutParams == null || layoutParams.height != -2) {
            i = -1;
        }
        C4987a c4987a = new C4987a(this, this.mContext);
        c4987a.addView(view, new FrameLayout.LayoutParams(-1, i));
        return c4987a;
    }

    private C4990b cZ(View view) {
        int i = -2;
        ViewGroup.LayoutParams layoutParams = this.adu.getLayoutParams();
        if (layoutParams == null || layoutParams.height != -2) {
            i = -1;
        }
        C4990b c4990b = new C4990b(this, this.mContext);
        c4990b.addView(view, -1, i);
        c4990b.setClipChildren(false);
        c4990b.setClipToPadding(false);
        return c4990b;
    }

    private void m15884b(LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        View view = this.diW;
        view.setFitsSystemWindows(this.djh);
        avp();
        this.diS.addView(view, layoutParams);
        if (this.djq != null) {
            view.m15873b(this.djq);
        }
    }

    private void avp() {
        if (this.djx != null) {
            View view = (View) this.djx.get();
            if (view != null && this.djE) {
                this.diW.setLayoutDirection(view.getLayoutDirection());
            }
        }
    }

    private int avq() {
        int i = this.mGravity == 0 ? 8388659 : this.mGravity;
        if (!this.diV) {
            return i;
        }
        if (this.djf || this.djc) {
            return i | 268435456;
        }
        return i;
    }

    private LayoutParams m15892r(IBinder iBinder) {
        int i;
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = avq();
        layoutParams.flags = lF(layoutParams.flags);
        layoutParams.type = this.djt;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.diZ;
        layoutParams.windowAnimations = avr();
        if (this.aga != null) {
            layoutParams.format = this.aga.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        if (this.aqV < 0) {
            i = this.aqV;
            this.djn = i;
            layoutParams.height = i;
        } else {
            i = this.pT;
            this.djn = i;
            layoutParams.height = i;
        }
        if (this.aqU < 0) {
            i = this.aqU;
            this.djm = i;
            layoutParams.width = i;
        } else {
            i = this.pS;
            this.djm = i;
            layoutParams.width = i;
        }
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private int lF(int i) {
        int i2 = -8815129 & i;
        if (this.dju) {
            i2 |= 32768;
        }
        if (!this.aec) {
            i2 |= 8;
            if (this.diY == 1) {
                i2 |= 131072;
            }
        } else if (this.diY == 2) {
            i2 |= 131072;
        }
        if (!this.dja) {
            i2 |= 16;
        }
        if (this.djb) {
            i2 |= 262144;
        }
        if (!this.djc || this.djf) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.dje) {
            i2 |= 256;
        }
        if (this.djh) {
            i2 |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (this.dji) {
            i2 |= 32;
        }
        if (this.djj) {
            return i2 | 1073741824;
        }
        return i2;
    }

    private int avr() {
        return this.djv;
    }

    private boolean m15877a(View view, LayoutParams layoutParams, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int height = view.getHeight();
        int width = view.getWidth();
        if (this.akP) {
            i6 = i2 - height;
        } else {
            i6 = i2;
        }
        int[] iArr = this.diQ;
        view.getLocationInWindow(iArr);
        layoutParams.x = iArr[0] + i;
        layoutParams.y = (iArr[1] + height) + i6;
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        if (i3 == -1) {
            i3 = rect.right - rect.left;
        }
        if (i4 == -1) {
            i7 = rect.bottom - rect.top;
        } else {
            i7 = i4;
        }
        layoutParams.gravity = avq();
        layoutParams.width = i3;
        layoutParams.height = i7;
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, view.getLayoutDirection()) & 7;
        if (absoluteGravity == 8388613) {
            layoutParams.x -= i3 - width;
        }
        int[] iArr2 = this.diR;
        view.getLocationOnScreen(iArr2);
        boolean a = m15878a(layoutParams, i6, i7, height, iArr[1], iArr2[1], rect.top, rect.bottom, false);
        boolean b = m15886b(layoutParams, i, i3, width, iArr[0], iArr2[0], rect.left, rect.right, false);
        if (!(a && b)) {
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            Rect rect2 = new Rect(scrollX, scrollY, (scrollX + i3) + i, ((scrollY + i7) + height) + i6);
            if (this.djg && view.requestRectangleOnScreen(rect2, true)) {
                view.getLocationInWindow(iArr);
                layoutParams.x = iArr[0] + i;
                layoutParams.y = (iArr[1] + height) + i6;
                if (absoluteGravity == 8388613) {
                    layoutParams.x -= i3 - width;
                }
            }
            m15878a(layoutParams, i6, i7, height, iArr[1], iArr2[1], rect.top, rect.bottom, this.djf);
            m15886b(layoutParams, i, i3, width, iArr[0], iArr2[0], rect.left, rect.right, this.djf);
        }
        return layoutParams.y < iArr[1];
    }

    private boolean m15878a(LayoutParams layoutParams, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = (i5 - i4) + layoutParams.y;
        int i9 = i7 - i8;
        if (i8 >= 0 && i2 <= i9) {
            return true;
        }
        if (i2 > (i8 - i3) - i6) {
            return m15879a(layoutParams, i2, i4, i5, i6, i7, z);
        }
        if (this.akP) {
            i += i3;
        }
        layoutParams.y = (i4 - i2) + i;
        return true;
    }

    private boolean m15879a(LayoutParams layoutParams, int i, int i2, int i3, int i4, int i5, boolean z) {
        boolean z2 = true;
        int i6 = i3 - i2;
        layoutParams.y += i6;
        layoutParams.height = i;
        int i7 = layoutParams.y + i;
        if (i7 > i5) {
            layoutParams.y -= i7 - i5;
        }
        if (layoutParams.y < i4) {
            layoutParams.y = i4;
            i7 = i5 - i4;
            if (!z || i <= i7) {
                z2 = false;
            } else {
                layoutParams.height = i7;
            }
        }
        layoutParams.y -= i6;
        return z2;
    }

    private boolean m15886b(LayoutParams layoutParams, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = (i5 - i4) + layoutParams.x;
        int i9 = i7 - i8;
        if (i8 < 0 || i2 > i9) {
            return m15887b(layoutParams, i2, i4, i5, i6, i7, z);
        }
        return true;
    }

    private boolean m15887b(LayoutParams layoutParams, int i, int i2, int i3, int i4, int i5, boolean z) {
        boolean z2 = true;
        int i6 = i3 - i2;
        layoutParams.x += i6;
        int i7 = layoutParams.x + i;
        if (i7 > i5) {
            layoutParams.x -= i7 - i5;
        }
        if (layoutParams.x < i4) {
            layoutParams.x = i4;
            i7 = i5 - i4;
            if (!z || i <= i7) {
                z2 = false;
            } else {
                layoutParams.width = i7;
            }
        }
        layoutParams.x -= i6;
        return z2;
    }

    public void dismiss() {
        if (isShowing() && !this.diU) {
            ViewGroup viewGroup;
            View view = this.diW;
            View view2 = this.adu;
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            view.avu();
            this.diT = false;
            this.diU = true;
            Transition transition = this.djr;
            if (this.djz && transition != null && view.isLaidOut()) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.flags |= 16;
                layoutParams.flags |= 8;
                layoutParams.flags &= -131073;
                this.diS.updateViewLayout(view, layoutParams);
                if (this.djy != null) {
                    View view3 = (View) this.djy.get();
                }
                avs();
            } else {
                m15875a(view, viewGroup, view2);
            }
            avt();
            if (this.afM != null) {
                this.afM.onDismiss();
            }
        }
    }

    private Rect avs() {
        Rect rect = null;
        View view = this.djx != null ? (View) this.djx.get() : null;
        C4990b c4990b = this.diW;
        if (!(view == null || c4990b == null)) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            this.diW.getLocationOnScreen(iArr2);
            rect = new Rect(0, 0, view.getWidth(), view.getHeight());
            rect.offset(iArr[0] - iArr2[0], iArr[1] - iArr2[1]);
            if (this.ahg != null) {
                int i = rect.left;
                int i2 = rect.top;
                rect.set(this.ahg);
                rect.offset(i, i2);
            }
        }
        return rect;
    }

    private void m15875a(View view, ViewGroup viewGroup, View view2) {
        if (view.getParent() != null) {
            this.diS.removeViewImmediate(view);
        }
        if (viewGroup != null) {
            viewGroup.removeView(view2);
        }
        this.diW = null;
        this.diX = null;
        this.diU = false;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.afM = onDismissListener;
    }

    public void update() {
        Object obj = 1;
        if (isShowing() && this.adu != null) {
            LayoutParams layoutParams = (LayoutParams) this.diW.getLayoutParams();
            Object obj2 = null;
            int avr = avr();
            if (avr != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = avr;
                obj2 = 1;
            }
            avr = lF(layoutParams.flags);
            if (avr != layoutParams.flags) {
                layoutParams.flags = avr;
                obj2 = 1;
            }
            avr = avq();
            if (avr != layoutParams.gravity) {
                layoutParams.gravity = avr;
            } else {
                obj = obj2;
            }
            if (obj != null) {
                avp();
                this.diS.updateViewLayout(this.diW, layoutParams);
            }
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 >= 0) {
            this.djm = i3;
            setWidth(i3);
        }
        if (i4 >= 0) {
            this.djn = i4;
            setHeight(i4);
        }
        if (isShowing() && this.adu != null) {
            LayoutParams layoutParams = (LayoutParams) this.diW.getLayoutParams();
            int i5 = this.aqU < 0 ? this.aqU : this.djm;
            if (!(i3 == -1 || layoutParams.width == i5)) {
                this.djm = i5;
                layoutParams.width = i5;
                z = true;
            }
            i5 = this.aqV < 0 ? this.aqV : this.djn;
            if (!(i4 == -1 || layoutParams.height == i5)) {
                this.djn = i5;
                layoutParams.height = i5;
                z = true;
            }
            if (layoutParams.x != i) {
                layoutParams.x = i;
                z = true;
            }
            if (layoutParams.y != i2) {
                layoutParams.y = i2;
                z = true;
            }
            i5 = avr();
            if (i5 != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = i5;
                z = true;
            }
            i5 = lF(layoutParams.flags);
            if (i5 != layoutParams.flags) {
                layoutParams.flags = i5;
                z = true;
            }
            i5 = avq();
            if (i5 != layoutParams.gravity) {
                layoutParams.gravity = i5;
            } else {
                z2 = z;
            }
            if (z2) {
                avp();
                this.diS.updateViewLayout(this.diW, layoutParams);
            }
        }
    }

    public void setTag(Object obj) {
        this.diP = obj;
    }

    public Object getTag() {
        return this.diP;
    }

    private void avt() {
        View view = this.djx != null ? (View) this.djx.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.djA);
        }
        if (this.djy != null) {
            view = (View) this.djy.get();
        } else {
            view = null;
        }
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.djw);
        }
        this.djx = null;
        this.djy = null;
        this.djz = false;
    }

    private void m15883b(View view, int i, int i2, int i3) {
        avt();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.djA);
        }
        View rootView = view.getRootView();
        rootView.addOnAttachStateChangeListener(this.djw);
        this.djx = new WeakReference(view);
        this.djy = new WeakReference(rootView);
        this.djz = rootView.isAttachedToWindow();
        this.djB = i;
        this.djC = i2;
        this.djD = i3;
    }
}
