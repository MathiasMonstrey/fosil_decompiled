package com.fossil;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class oq {
    private static final Interpolator SM = new C39411();
    private float[] ZA;
    private int[] ZB;
    private int[] ZC;
    private int[] ZD;
    private int ZE;
    private float ZF;
    private float ZG;
    private int ZH;
    private int ZI;
    private final C3943a ZJ;
    private View ZK;
    private boolean ZL;
    private final ViewGroup ZM;
    private final Runnable ZN = new C39422(this);
    private int Zw;
    private float[] Zx;
    private float[] Zy;
    private float[] Zz;
    private int mActivePointerId = -1;
    private of mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    static class C39411 implements Interpolator {
        C39411() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C39422 implements Runnable {
        final /* synthetic */ oq ZO;

        C39422(oq oqVar) {
            this.ZO = oqVar;
        }

        public void run() {
            this.ZO.ce(0);
        }
    }

    public static abstract class C3943a {
        public abstract boolean m12903b(View view, int i);

        public void m12899Q(int i) {
        }

        public void m12902b(View view, int i, int i2, int i3, int i4) {
        }

        public void m12906j(View view, int i) {
        }

        public void m12900a(View view, float f, float f2) {
        }

        public void m12897D(int i, int i2) {
        }

        public boolean bR(int i) {
            return false;
        }

        public void m12898E(int i, int i2) {
        }

        public int ch(int i) {
            return i;
        }

        public int m12907v(View view) {
            return 0;
        }

        public int m12905j(View view) {
            return 0;
        }

        public int m12904c(View view, int i, int i2) {
            return 0;
        }

        public int m12901b(View view, int i, int i2) {
            return 0;
        }
    }

    public static oq m12910a(ViewGroup viewGroup, C3943a c3943a) {
        return new oq(viewGroup.getContext(), viewGroup, c3943a);
    }

    public static oq m12909a(ViewGroup viewGroup, float f, C3943a c3943a) {
        oq a = m12910a(viewGroup, c3943a);
        a.mTouchSlop = (int) (((float) a.mTouchSlop) * (1.0f / f));
        return a;
    }

    private oq(Context context, ViewGroup viewGroup, C3943a c3943a) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c3943a == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.ZM = viewGroup;
            this.ZJ = c3943a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.ZH = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.ZF = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.ZG = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = of.m12867a(context, SM);
        }
    }

    public void m12928M(float f) {
        this.ZG = f;
    }

    public int le() {
        return this.Zw;
    }

    public void ca(int i) {
        this.ZI = i;
    }

    public int lf() {
        return this.ZH;
    }

    public void m12934u(View view, int i) {
        if (view.getParent() != this.ZM) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.ZM + ")");
        }
        this.ZK = view;
        this.mActivePointerId = i;
        this.ZJ.m12906j(view, i);
        ce(1);
    }

    public View lg() {
        return this.ZK;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        lh();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void abort() {
        cancel();
        if (this.Zw == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.ZJ.m12902b(this.ZK, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        ce(0);
    }

    public boolean m12932h(View view, int i, int i2) {
        this.ZK = view;
        this.mActivePointerId = -1;
        boolean i3 = m12919i(i, i2, 0, 0);
        if (!(i3 || this.Zw != 0 || this.ZK == null)) {
            this.ZK = null;
        }
        return i3;
    }

    public boolean m12924J(int i, int i2) {
        if (this.ZL) {
            return m12919i(i, i2, (int) lg.a(this.mVelocityTracker, this.mActivePointerId), (int) lg.b(this.mVelocityTracker, this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m12919i(int i, int i2, int i3, int i4) {
        int left = this.ZK.getLeft();
        int top = this.ZK.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.mScroller.abortAnimation();
            ce(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i5, i6, m12917f(this.ZK, i5, i6, i3, i4));
        ce(2);
        return true;
    }

    private int m12917f(View view, int i, int i2, int i3, int i4) {
        int j = m12920j(i3, (int) this.ZG, (int) this.ZF);
        int j2 = m12920j(i4, (int) this.ZG, (int) this.ZF);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(j);
        int abs4 = Math.abs(j2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((j2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m12918i(i2, j2, this.ZJ.m12905j(view)))) + ((j != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m12918i(i, j, this.ZJ.m12907v(view)))));
    }

    private int m12918i(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.ZM.getWidth();
        int i4 = width / 2;
        float v = (m12923v(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(v / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m12920j(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float m12915e(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float m12923v(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m12929N(boolean z) {
        if (this.Zw == 2) {
            int i;
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.ZK.getLeft();
            int top = currY - this.ZK.getTop();
            if (left != 0) {
                li.q(this.ZK, left);
            }
            if (top != 0) {
                li.p(this.ZK, top);
            }
            if (!(left == 0 && top == 0)) {
                this.ZJ.m12902b(this.ZK, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                i = 0;
            } else {
                boolean z2 = computeScrollOffset;
            }
            if (i == 0) {
                if (z) {
                    this.ZM.post(this.ZN);
                } else {
                    ce(0);
                }
            }
        }
        return this.Zw == 2;
    }

    private void m12922q(float f, float f2) {
        this.ZL = true;
        this.ZJ.m12900a(this.ZK, f, f2);
        this.ZL = false;
        if (this.Zw == 1) {
            ce(0);
        }
    }

    private void lh() {
        if (this.Zx != null) {
            Arrays.fill(this.Zx, 0.0f);
            Arrays.fill(this.Zy, 0.0f);
            Arrays.fill(this.Zz, 0.0f);
            Arrays.fill(this.ZA, 0.0f);
            Arrays.fill(this.ZB, 0);
            Arrays.fill(this.ZC, 0);
            Arrays.fill(this.ZD, 0);
            this.ZE = 0;
        }
    }

    private void cb(int i) {
        if (this.Zx != null && cd(i)) {
            this.Zx[i] = 0.0f;
            this.Zy[i] = 0.0f;
            this.Zz[i] = 0.0f;
            this.ZA[i] = 0.0f;
            this.ZB[i] = 0;
            this.ZC[i] = 0;
            this.ZD[i] = 0;
            this.ZE &= (1 << i) ^ -1;
        }
    }

    private void cc(int i) {
        if (this.Zx == null || this.Zx.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.Zx != null) {
                System.arraycopy(this.Zx, 0, obj, 0, this.Zx.length);
                System.arraycopy(this.Zy, 0, obj2, 0, this.Zy.length);
                System.arraycopy(this.Zz, 0, obj3, 0, this.Zz.length);
                System.arraycopy(this.ZA, 0, obj4, 0, this.ZA.length);
                System.arraycopy(this.ZB, 0, obj5, 0, this.ZB.length);
                System.arraycopy(this.ZC, 0, obj6, 0, this.ZC.length);
                System.arraycopy(this.ZD, 0, obj7, 0, this.ZD.length);
            }
            this.Zx = obj;
            this.Zy = obj2;
            this.Zz = obj3;
            this.ZA = obj4;
            this.ZB = obj5;
            this.ZC = obj6;
            this.ZD = obj7;
        }
    }

    private void m12911a(float f, float f2, int i) {
        cc(i);
        float[] fArr = this.Zx;
        this.Zz[i] = f;
        fArr[i] = f;
        fArr = this.Zy;
        this.ZA[i] = f2;
        fArr[i] = f2;
        this.ZB[i] = m12908N((int) f, (int) f2);
        this.ZE |= 1 << i;
    }

    private void m12916e(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (cg(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.Zz[pointerId] = x;
                this.ZA[pointerId] = y;
            }
        }
    }

    public boolean cd(int i) {
        return (this.ZE & (1 << i)) != 0;
    }

    void ce(int i) {
        this.ZM.removeCallbacks(this.ZN);
        if (this.Zw != i) {
            this.Zw = i;
            this.ZJ.m12899Q(i);
            if (this.Zw == 0) {
                this.ZK = null;
            }
        }
    }

    boolean m12935v(View view, int i) {
        if (view == this.ZK && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.ZJ.m12903b(view, i)) {
            return false;
        }
        this.mActivePointerId = i;
        m12934u(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m12930f(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = com.fossil.ks.a(r14);
        r1 = com.fossil.ks.b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.cancel();
    L_0x000d:
        r2 = r13.mVelocityTracker;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.mVelocityTracker = r2;
    L_0x0017:
        r2 = r13.mVelocityTracker;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.Zw;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = r14.getPointerId(r2);
        r13.m12911a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m12927M(r0, r1);
        r1 = r13.ZK;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.Zw;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m12935v(r0, r2);
    L_0x0048:
        r0 = r13.ZB;
        r0 = r0[r2];
        r1 = r13.ZI;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.ZJ;
        r3 = r13.ZI;
        r0 = r0 & r3;
        r1.m12897D(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = r14.getPointerId(r1);
        r2 = r14.getX(r1);
        r1 = r14.getY(r1);
        r13.m12911a(r2, r1, r0);
        r3 = r13.Zw;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.ZB;
        r1 = r1[r0];
        r2 = r13.ZI;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.ZJ;
        r3 = r13.ZI;
        r1 = r1 & r3;
        r2.m12897D(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.Zw;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m12927M(r2, r1);
        r2 = r13.ZK;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m12935v(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.Zx;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.Zy;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = r14.getPointerCount();
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = r14.getPointerId(r1);
        r0 = r13.cg(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = r14.getX(r1);
        r4 = r14.getY(r1);
        r5 = r13.Zx;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.Zy;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m12927M(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m12914b(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.ZJ;
        r10 = (int) r5;
        r8 = r9.m12904c(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.ZJ;
        r12 = (int) r6;
        r10 = r11.m12901b(r4, r10, r12);
        r11 = r13.ZJ;
        r11 = r11.m12907v(r4);
        r12 = r13.ZJ;
        r12 = r12.m12905j(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m12916e(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m12913b(r5, r6, r3);
        r5 = r13.Zw;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m12935v(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = r14.getPointerId(r1);
        r13.cb(r0);
        goto L_0x001f;
    L_0x0128:
        r13.cancel();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.oq.f(android.view.MotionEvent):boolean");
    }

    public void m12931g(MotionEvent motionEvent) {
        int i = 0;
        int a = ks.a(motionEvent);
        int b = ks.b(motionEvent);
        if (a == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        float x;
        float y;
        View M;
        int i2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = motionEvent.getPointerId(0);
                M = m12927M((int) x, (int) y);
                m12911a(x, y, i);
                m12935v(M, i);
                i2 = this.ZB[i];
                if ((this.ZI & i2) != 0) {
                    this.ZJ.m12897D(i2 & this.ZI, i);
                    return;
                }
                return;
            case 1:
                if (this.Zw == 1) {
                    li();
                }
                cancel();
                return;
            case 2:
                if (this.Zw != 1) {
                    i2 = motionEvent.getPointerCount();
                    while (i < i2) {
                        a = motionEvent.getPointerId(i);
                        if (cg(a)) {
                            float x2 = motionEvent.getX(i);
                            float y2 = motionEvent.getY(i);
                            float f = x2 - this.Zx[a];
                            float f2 = y2 - this.Zy[a];
                            m12913b(f, f2, a);
                            if (this.Zw != 1) {
                                M = m12927M((int) x2, (int) y2);
                                if (m12914b(M, f, f2) && m12935v(M, a)) {
                                }
                            }
                            m12916e(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m12916e(motionEvent);
                    return;
                } else if (cg(this.mActivePointerId)) {
                    i = motionEvent.findPointerIndex(this.mActivePointerId);
                    x = motionEvent.getX(i);
                    i2 = (int) (x - this.Zz[this.mActivePointerId]);
                    i = (int) (motionEvent.getY(i) - this.ZA[this.mActivePointerId]);
                    m12921j(this.ZK.getLeft() + i2, this.ZK.getTop() + i, i2, i);
                    m12916e(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.Zw == 1) {
                    m12922q(0.0f, 0.0f);
                }
                cancel();
                return;
            case 5:
                i = motionEvent.getPointerId(b);
                x = motionEvent.getX(b);
                y = motionEvent.getY(b);
                m12911a(x, y, i);
                if (this.Zw == 0) {
                    m12935v(m12927M((int) x, (int) y), i);
                    i2 = this.ZB[i];
                    if ((this.ZI & i2) != 0) {
                        this.ZJ.m12897D(i2 & this.ZI, i);
                        return;
                    }
                    return;
                } else if (m12926L((int) x, (int) y)) {
                    m12935v(this.ZK, i);
                    return;
                } else {
                    return;
                }
            case 6:
                a = motionEvent.getPointerId(b);
                if (this.Zw == 1 && a == this.mActivePointerId) {
                    b = motionEvent.getPointerCount();
                    while (i < b) {
                        int pointerId = motionEvent.getPointerId(i);
                        if (pointerId != this.mActivePointerId) {
                            if (m12927M((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.ZK && m12935v(this.ZK, pointerId)) {
                                i = this.mActivePointerId;
                                if (i == -1) {
                                    li();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        li();
                    }
                }
                cb(a);
                return;
            default:
                return;
        }
    }

    private void m12913b(float f, float f2, int i) {
        int i2 = 1;
        if (!m12912a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m12912a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m12912a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m12912a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.ZC;
            iArr[i] = iArr[i] | i2;
            this.ZJ.m12898E(i2, i);
        }
    }

    private boolean m12912a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.ZB[i] & i2) != i2 || (this.ZI & i2) == 0 || (this.ZD[i] & i2) == i2 || (this.ZC[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.ZJ.bR(i2)) {
            int[] iArr = this.ZD;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.ZC[i] & i2) != 0 || abs <= ((float) this.mTouchSlop)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m12914b(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.ZJ.m12907v(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.ZJ.m12905j(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.mTouchSlop * this.mTouchSlop))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.mTouchSlop)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.mTouchSlop)) {
                return false;
            }
            return true;
        }
    }

    public boolean cf(int i) {
        int length = this.Zx.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m12925K(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m12925K(int i, int i2) {
        if (!cd(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.Zz[i2] - this.Zx[i2];
        float f2 = this.ZA[i2] - this.Zy[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.mTouchSlop * this.mTouchSlop))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.mTouchSlop)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.mTouchSlop)) {
                return false;
            }
            return true;
        }
    }

    private void li() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.ZF);
        m12922q(m12915e(lg.a(this.mVelocityTracker, this.mActivePointerId), this.ZG, this.ZF), m12915e(lg.b(this.mVelocityTracker, this.mActivePointerId), this.ZG, this.ZF));
    }

    private void m12921j(int i, int i2, int i3, int i4) {
        int c;
        int b;
        int left = this.ZK.getLeft();
        int top = this.ZK.getTop();
        if (i3 != 0) {
            c = this.ZJ.m12904c(this.ZK, i, i3);
            li.q(this.ZK, c - left);
        } else {
            c = i;
        }
        if (i4 != 0) {
            b = this.ZJ.m12901b(this.ZK, i2, i4);
            li.p(this.ZK, b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.ZJ.m12902b(this.ZK, c, b, c - left, b - top);
        }
    }

    public boolean m12926L(int i, int i2) {
        return m12933i(this.ZK, i, i2);
    }

    public boolean m12933i(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m12927M(int i, int i2) {
        for (int childCount = this.ZM.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.ZM.getChildAt(this.ZJ.ch(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m12908N(int i, int i2) {
        int i3 = 0;
        if (i < this.ZM.getLeft() + this.ZH) {
            i3 = 1;
        }
        if (i2 < this.ZM.getTop() + this.ZH) {
            i3 |= 4;
        }
        if (i > this.ZM.getRight() - this.ZH) {
            i3 |= 2;
        }
        if (i2 > this.ZM.getBottom() - this.ZH) {
            return i3 | 8;
        }
        return i3;
    }

    private boolean cg(int i) {
        if (cd(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
