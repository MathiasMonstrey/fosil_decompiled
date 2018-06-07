package com.fossil;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.C1092c;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.SwipeDismissBehavior.C1106a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.fossil.ag.C1620a;
import com.fossil.ag.C1630k;
import com.fossil.bg.C1921a;
import java.util.List;

public abstract class ar<B extends ar<B>> {
    static final Handler vz = new Handler(Looper.getMainLooper(), new C18411());
    private List<C1852a<B>> nW;
    private final ViewGroup vA;
    final C1105f vB;
    private final C1071c vC;
    private final AccessibilityManager vD;
    final C1921a vE;

    public interface C1071c {
        void mo12k(int i, int i2);

        void mo13l(int i, int i2);
    }

    public static class C1105f extends FrameLayout {
        private C1847e vI;
        private C1845d vJ;

        protected C1105f(Context context) {
            this(context, null);
        }

        protected C1105f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(C1630k.SnackbarLayout_elevation)) {
                li.m12269l((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(C1630k.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.vI != null) {
                this.vI.mo1128a(this, i, i2, i3, i4);
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.vJ != null) {
                this.vJ.onViewAttachedToWindow(this);
            }
            li.aj(this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.vJ != null) {
                this.vJ.onViewDetachedFromWindow(this);
            }
        }

        void setOnLayoutChangeListener(C1847e c1847e) {
            this.vI = c1847e;
        }

        void setOnAttachStateChangeListener(C1845d c1845d) {
            this.vJ = c1845d;
        }
    }

    static class C18411 implements Callback {
        C18411() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((ar) message.obj).fo();
                    return true;
                case 1:
                    ((ar) message.obj).m1879J(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    }

    class C18433 implements C1106a {
        final /* synthetic */ ar vG;

        C18433(ar arVar) {
            this.vG = arVar;
        }

        public void mo1125d(View view) {
            view.setVisibility(8);
            this.vG.m1878H(0);
        }

        public void mo1124L(int i) {
            switch (i) {
                case 0:
                    bg.gB().m5125d(this.vG.vE);
                    return;
                case 1:
                case 2:
                    bg.gB().m5124c(this.vG.vE);
                    return;
                default:
                    return;
            }
        }
    }

    interface C1845d {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    class C18464 implements C1845d {
        final /* synthetic */ ar vG;

        class C18441 implements Runnable {
            final /* synthetic */ C18464 vH;

            C18441(C18464 c18464) {
                this.vH = c18464;
            }

            public void run() {
                this.vH.vG.m1880K(3);
            }
        }

        C18464(ar arVar) {
            this.vG = arVar;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.vG.fn()) {
                ar.vz.post(new C18441(this));
            }
        }
    }

    interface C1847e {
        void mo1128a(View view, int i, int i2, int i3, int i4);
    }

    class C18485 implements C1847e {
        final /* synthetic */ ar vG;

        C18485(ar arVar) {
            this.vG = arVar;
        }

        public void mo1128a(View view, int i, int i2, int i3, int i4) {
            this.vG.vB.setOnLayoutChangeListener(null);
            if (this.vG.fr()) {
                this.vG.fp();
            } else {
                this.vG.fq();
            }
        }
    }

    class C18496 extends me {
        final /* synthetic */ ar vG;

        C18496(ar arVar) {
            this.vG = arVar;
        }

        public void mo81e(View view) {
            this.vG.vC.mo12k(70, 180);
        }

        public void mo82f(View view) {
            this.vG.fq();
        }
    }

    class C18507 implements AnimationListener {
        final /* synthetic */ ar vG;

        C18507(ar arVar) {
            this.vG = arVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.vG.fq();
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public static abstract class C1852a<B> {
        public void m4267a(B b, int i) {
        }

        public void m4268g(B b) {
        }
    }

    final class C1853b extends SwipeDismissBehavior<C1105f> {
        final /* synthetic */ ar vG;

        C1853b(ar arVar) {
            this.vG = arVar;
        }

        public /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return m4269a(coordinatorLayout, (C1105f) view, motionEvent);
        }

        public boolean mo1129g(View view) {
            return view instanceof C1105f;
        }

        public boolean m4269a(CoordinatorLayout coordinatorLayout, C1105f c1105f, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (coordinatorLayout.m1845e(c1105f, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        bg.gB().m5124c(this.vG.vE);
                        break;
                    }
                    break;
                case 1:
                case 3:
                    bg.gB().m5125d(this.vG.vE);
                    break;
            }
            return super.onInterceptTouchEvent(coordinatorLayout, c1105f, motionEvent);
        }
    }

    void m1878H(int i) {
        bg.gB().m5121a(this.vE, i);
    }

    public boolean fn() {
        return bg.gB().m5126e(this.vE);
    }

    final void fo() {
        if (this.vB.getParent() == null) {
            LayoutParams layoutParams = this.vB.getLayoutParams();
            if (layoutParams instanceof C1092c) {
                C1092c c1092c = (C1092c) layoutParams;
                Behavior c1853b = new C1853b(this);
                c1853b.m1898s(0.1f);
                c1853b.m1899t(0.6f);
                c1853b.ah(0);
                c1853b.m1896a(new C18433(this));
                c1092c.m1810a(c1853b);
                c1092c.yH = 80;
            }
            this.vA.addView(this.vB);
        }
        this.vB.setOnAttachStateChangeListener(new C18464(this));
        if (!li.as(this.vB)) {
            this.vB.setOnLayoutChangeListener(new C18485(this));
        } else if (fr()) {
            fp();
        } else {
            fq();
        }
    }

    void fp() {
        if (VERSION.SDK_INT >= 14) {
            li.m12262f(this.vB, (float) this.vB.getHeight());
            li.ae(this.vB).m12414A(0.0f).m12417c(aq.vc).m12418n(250).m12415a(new C18496(this)).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.vB.getContext(), C1620a.design_snackbar_in);
        loadAnimation.setInterpolator(aq.vc);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C18507(this));
        this.vB.startAnimation(loadAnimation);
    }

    private void m1876I(final int i) {
        if (VERSION.SDK_INT >= 14) {
            li.ae(this.vB).m12414A((float) this.vB.getHeight()).m12417c(aq.vc).m12418n(250).m12415a(new me(this) {
                final /* synthetic */ ar vG;

                public void mo81e(View view) {
                    this.vG.vC.mo13l(0, 180);
                }

                public void mo82f(View view) {
                    this.vG.m1880K(i);
                }
            }).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.vB.getContext(), C1620a.design_snackbar_out);
        loadAnimation.setInterpolator(aq.vc);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ar vG;

            public void onAnimationEnd(Animation animation) {
                this.vG.m1880K(i);
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.vB.startAnimation(loadAnimation);
    }

    final void m1879J(int i) {
        if (fr() && this.vB.getVisibility() == 0) {
            m1876I(i);
        } else {
            m1880K(i);
        }
    }

    void fq() {
        bg.gB().m5122b(this.vE);
        if (this.nW != null) {
            for (int size = this.nW.size() - 1; size >= 0; size--) {
                ((C1852a) this.nW.get(size)).m4268g(this);
            }
        }
    }

    void m1880K(int i) {
        bg.gB().m5120a(this.vE);
        if (this.nW != null) {
            for (int size = this.nW.size() - 1; size >= 0; size--) {
                ((C1852a) this.nW.get(size)).m4267a(this, i);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.vB.setVisibility(8);
        }
        ViewParent parent = this.vB.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.vB);
        }
    }

    boolean fr() {
        return !this.vD.isEnabled();
    }
}
