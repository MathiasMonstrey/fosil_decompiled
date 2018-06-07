package com.fossil;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.d;
import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.fossil.pq.C3997a;
import com.fossil.te.C4103a;
import com.fossil.te.C4104b;
import com.fossil.te.C4105c;
import java.util.ArrayList;
import java.util.List;

public class tc extends g implements i {
    RecyclerView aqI;
    private d aqr = null;
    private int atc;
    int awA;
    List<C4093c> awB = new ArrayList();
    final Runnable awC = new C40911(this);
    private List<v> awD;
    private List<Integer> awE;
    View awF = null;
    int awG = -1;
    kd awH;
    private final k awI = new C40922(this);
    private long awJ;
    final List<View> awn = new ArrayList();
    private final float[] awo = new float[2];
    v awp = null;
    float awq;
    float awr;
    float aws;
    float awt;
    float awu;
    float awv;
    float aww;
    float awx;
    C4099a awy;
    int awz = 0;
    int mActivePointerId = -1;
    VelocityTracker mVelocityTracker;
    private Rect xL;

    class C40911 implements Runnable {
        final /* synthetic */ tc awK;

        C40911(tc tcVar) {
            this.awK = tcVar;
        }

        public void run() {
            if (this.awK.awp != null && this.awK.sO()) {
                if (this.awK.awp != null) {
                    this.awK.m13653Z(this.awK.awp);
                }
                this.awK.aqI.removeCallbacks(this.awK.awC);
                li.b(this.awK.aqI, this);
            }
        }
    }

    class C40922 implements k {
        final /* synthetic */ tc awK;

        C40922(tc tcVar) {
            this.awK = tcVar;
        }

        public boolean m13619a(RecyclerView recyclerView, MotionEvent motionEvent) {
            this.awK.awH.onTouchEvent(motionEvent);
            int a = ks.a(motionEvent);
            if (a == 0) {
                this.awK.mActivePointerId = motionEvent.getPointerId(0);
                this.awK.awq = motionEvent.getX();
                this.awK.awr = motionEvent.getY();
                this.awK.sP();
                if (this.awK.awp == null) {
                    C4093c q = this.awK.m13664q(motionEvent);
                    if (q != null) {
                        tc tcVar = this.awK;
                        tcVar.awq -= q.awZ;
                        tcVar = this.awK;
                        tcVar.awr -= q.axa;
                        this.awK.m13661g(q.aqZ, true);
                        if (this.awK.awn.remove(q.aqZ.arT)) {
                            this.awK.awy.m13642d(this.awK.aqI, q.aqZ);
                        }
                        this.awK.m13660f(q.aqZ, q.awz);
                        this.awK.m13656a(motionEvent, this.awK.awA, 0);
                    }
                }
            } else if (a == 3 || a == 1) {
                this.awK.mActivePointerId = -1;
                this.awK.m13660f(null, 0);
            } else if (this.awK.mActivePointerId != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.awK.mActivePointerId);
                if (findPointerIndex >= 0) {
                    this.awK.m13658a(a, motionEvent, findPointerIndex);
                }
            }
            if (this.awK.mVelocityTracker != null) {
                this.awK.mVelocityTracker.addMovement(motionEvent);
            }
            if (this.awK.awp != null) {
                return true;
            }
            return false;
        }

        public void m13620b(RecyclerView recyclerView, MotionEvent motionEvent) {
            int i = 0;
            this.awK.awH.onTouchEvent(motionEvent);
            if (this.awK.mVelocityTracker != null) {
                this.awK.mVelocityTracker.addMovement(motionEvent);
            }
            if (this.awK.mActivePointerId != -1) {
                int a = ks.a(motionEvent);
                int findPointerIndex = motionEvent.findPointerIndex(this.awK.mActivePointerId);
                if (findPointerIndex >= 0) {
                    this.awK.m13658a(a, motionEvent, findPointerIndex);
                }
                v vVar = this.awK.awp;
                if (vVar != null) {
                    switch (a) {
                        case 1:
                            break;
                        case 2:
                            if (findPointerIndex >= 0) {
                                this.awK.m13656a(motionEvent, this.awK.awA, findPointerIndex);
                                this.awK.m13653Z(vVar);
                                this.awK.aqI.removeCallbacks(this.awK.awC);
                                this.awK.awC.run();
                                this.awK.aqI.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (this.awK.mVelocityTracker != null) {
                                this.awK.mVelocityTracker.clear();
                                break;
                            }
                            break;
                        case 6:
                            a = ks.b(motionEvent);
                            if (motionEvent.getPointerId(a) == this.awK.mActivePointerId) {
                                if (a == 0) {
                                    i = 1;
                                }
                                this.awK.mActivePointerId = motionEvent.getPointerId(i);
                                this.awK.m13656a(motionEvent, this.awK.awA, a);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    this.awK.m13660f(null, 0);
                    this.awK.mActivePointerId = -1;
                }
            }
        }

        public void as(boolean z) {
            if (z) {
                this.awK.m13660f(null, 0);
            }
        }
    }

    class C4093c implements ea {
        boolean GG = false;
        private float HC;
        final v aqZ;
        final /* synthetic */ tc awK;
        final float awS;
        final float awT;
        final float awU;
        final float awV;
        private final ef awW;
        final int awX;
        public boolean awY;
        float awZ;
        final int awz;
        float axa;
        boolean axb = false;

        public C4093c(final tc tcVar, v vVar, int i, int i2, float f, float f2, float f3, float f4) {
            this.awK = tcVar;
            this.awz = i2;
            this.awX = i;
            this.aqZ = vVar;
            this.awS = f;
            this.awT = f2;
            this.awU = f3;
            this.awV = f4;
            this.awW = dz.hH();
            this.awW.a(new ec(this) {
                final /* synthetic */ C4093c axd;

                public void m13645e(ef efVar) {
                    this.axd.setFraction(efVar.getAnimatedFraction());
                }
            });
            this.awW.G(vVar.arT);
            this.awW.a(this);
            setFraction(0.0f);
        }

        public void setDuration(long j) {
            this.awW.setDuration(j);
        }

        public void start() {
            this.aqZ.at(false);
            this.awW.start();
        }

        public void cancel() {
            this.awW.cancel();
        }

        public void setFraction(float f) {
            this.HC = f;
        }

        public void update() {
            if (this.awS == this.awU) {
                this.awZ = li.Z(this.aqZ.arT);
            } else {
                this.awZ = this.awS + (this.HC * (this.awU - this.awS));
            }
            if (this.awT == this.awV) {
                this.axa = li.aa(this.aqZ.arT);
            } else {
                this.axa = this.awT + (this.HC * (this.awV - this.awT));
            }
        }

        public void m13621a(ef efVar) {
        }

        public void mo4156b(ef efVar) {
            if (!this.GG) {
                this.aqZ.at(true);
            }
            this.GG = true;
        }

        public void m13623c(ef efVar) {
            setFraction(1.0f);
        }

        public void m13624d(ef efVar) {
        }
    }

    class C40965 implements d {
        final /* synthetic */ tc awK;

        C40965(tc tcVar) {
            this.awK = tcVar;
        }

        public int aD(int i, int i2) {
            if (this.awK.awF == null) {
                return i2;
            }
            int i3 = this.awK.awG;
            if (i3 == -1) {
                i3 = this.awK.aqI.indexOfChild(this.awK.awF);
                this.awK.awG = i3;
            }
            if (i2 == i - 1) {
                return i3;
            }
            return i2 >= i3 ? i2 + 1 : i2;
        }
    }

    public static abstract class C4099a {
        private static final td awO;
        private static final Interpolator awP = new C40971();
        private static final Interpolator awQ = new C40982();
        private int awR = -1;

        static class C40971 implements Interpolator {
            C40971() {
            }

            public float getInterpolation(float f) {
                return (((f * f) * f) * f) * f;
            }
        }

        static class C40982 implements Interpolator {
            C40982() {
            }

            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
            }
        }

        public abstract int m13630a(RecyclerView recyclerView, v vVar);

        public abstract boolean m13640b(RecyclerView recyclerView, v vVar, v vVar2);

        public abstract void m13643i(v vVar, int i);

        static {
            if (VERSION.SDK_INT >= 21) {
                awO = new C4105c();
            } else if (VERSION.SDK_INT >= 11) {
                awO = new C4104b();
            } else {
                awO = new C4103a();
            }
        }

        public static int aU(int i, int i2) {
            int i3 = i & 789516;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 << 2);
            }
            return (i4 | ((i3 << 1) & -789517)) | (((i3 << 1) & 789516) << 2);
        }

        public static int aV(int i, int i2) {
            return (C4099a.aW(0, i2 | i) | C4099a.aW(1, i2)) | C4099a.aW(2, i);
        }

        public static int aW(int i, int i2) {
            return i2 << (i * 8);
        }

        public int aX(int i, int i2) {
            int i3 = i & 3158064;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 >> 2);
            }
            return (i4 | ((i3 >> 1) & -3158065)) | (((i3 >> 1) & 3158064) >> 2);
        }

        final int m13637b(RecyclerView recyclerView, v vVar) {
            return aX(m13630a(recyclerView, vVar), li.S(recyclerView));
        }

        boolean m13641c(RecyclerView recyclerView, v vVar) {
            return (m13637b(recyclerView, vVar) & 16711680) != 0;
        }

        public boolean m13636a(RecyclerView recyclerView, v vVar, v vVar2) {
            return true;
        }

        public boolean sS() {
            return true;
        }

        public boolean sT() {
            return true;
        }

        public int sU() {
            return 0;
        }

        public float ac(v vVar) {
            return 0.5f;
        }

        public float ad(v vVar) {
            return 0.5f;
        }

        public float m13627O(float f) {
            return f;
        }

        public float m13628P(float f) {
            return f;
        }

        public v m13632a(v vVar, List<v> list, int i, int i2) {
            int width = i + vVar.arT.getWidth();
            int height = i2 + vVar.arT.getHeight();
            v vVar2 = null;
            int i3 = -1;
            int left = i - vVar.arT.getLeft();
            int top = i2 - vVar.arT.getTop();
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                int i5;
                v vVar3;
                int i6;
                v vVar4;
                int i7;
                v vVar5 = (v) list.get(i4);
                if (left > 0) {
                    int right = vVar5.arT.getRight() - width;
                    if (right < 0 && vVar5.arT.getRight() > vVar.arT.getRight()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            i5 = right;
                            vVar3 = vVar5;
                            if (left < 0) {
                                i3 = vVar5.arT.getLeft() - i;
                                if (i3 > 0 && vVar5.arT.getLeft() < vVar.arT.getLeft()) {
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        vVar3 = vVar5;
                                        if (top < 0) {
                                            i5 = vVar5.arT.getTop() - i2;
                                            if (i5 > 0 && vVar5.arT.getTop() < vVar.arT.getTop()) {
                                                i5 = Math.abs(i5);
                                                if (i5 > i3) {
                                                    vVar3 = vVar5;
                                                    if (top > 0) {
                                                        i3 = vVar5.arT.getBottom() - height;
                                                        if (i3 < 0 && vVar5.arT.getBottom() > vVar.arT.getBottom()) {
                                                            i3 = Math.abs(i3);
                                                            if (i3 > i5) {
                                                                i6 = i3;
                                                                vVar4 = vVar5;
                                                                i7 = i6;
                                                                i4++;
                                                                vVar2 = vVar4;
                                                                i3 = i7;
                                                            }
                                                        }
                                                    }
                                                    i7 = i5;
                                                    vVar4 = vVar3;
                                                    i4++;
                                                    vVar2 = vVar4;
                                                    i3 = i7;
                                                }
                                            }
                                        }
                                        i5 = i3;
                                        if (top > 0) {
                                            i3 = vVar5.arT.getBottom() - height;
                                            i3 = Math.abs(i3);
                                            if (i3 > i5) {
                                                i6 = i3;
                                                vVar4 = vVar5;
                                                i7 = i6;
                                                i4++;
                                                vVar2 = vVar4;
                                                i3 = i7;
                                            }
                                        }
                                        i7 = i5;
                                        vVar4 = vVar3;
                                        i4++;
                                        vVar2 = vVar4;
                                        i3 = i7;
                                    }
                                }
                            }
                            i3 = i5;
                            if (top < 0) {
                                i5 = vVar5.arT.getTop() - i2;
                                i5 = Math.abs(i5);
                                if (i5 > i3) {
                                    vVar3 = vVar5;
                                    if (top > 0) {
                                        i3 = vVar5.arT.getBottom() - height;
                                        i3 = Math.abs(i3);
                                        if (i3 > i5) {
                                            i6 = i3;
                                            vVar4 = vVar5;
                                            i7 = i6;
                                            i4++;
                                            vVar2 = vVar4;
                                            i3 = i7;
                                        }
                                    }
                                    i7 = i5;
                                    vVar4 = vVar3;
                                    i4++;
                                    vVar2 = vVar4;
                                    i3 = i7;
                                }
                            }
                            i5 = i3;
                            if (top > 0) {
                                i3 = vVar5.arT.getBottom() - height;
                                i3 = Math.abs(i3);
                                if (i3 > i5) {
                                    i6 = i3;
                                    vVar4 = vVar5;
                                    i7 = i6;
                                    i4++;
                                    vVar2 = vVar4;
                                    i3 = i7;
                                }
                            }
                            i7 = i5;
                            vVar4 = vVar3;
                            i4++;
                            vVar2 = vVar4;
                            i3 = i7;
                        }
                    }
                }
                vVar3 = vVar2;
                i5 = i3;
                if (left < 0) {
                    i3 = vVar5.arT.getLeft() - i;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        vVar3 = vVar5;
                        if (top < 0) {
                            i5 = vVar5.arT.getTop() - i2;
                            i5 = Math.abs(i5);
                            if (i5 > i3) {
                                vVar3 = vVar5;
                                if (top > 0) {
                                    i3 = vVar5.arT.getBottom() - height;
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        i6 = i3;
                                        vVar4 = vVar5;
                                        i7 = i6;
                                        i4++;
                                        vVar2 = vVar4;
                                        i3 = i7;
                                    }
                                }
                                i7 = i5;
                                vVar4 = vVar3;
                                i4++;
                                vVar2 = vVar4;
                                i3 = i7;
                            }
                        }
                        i5 = i3;
                        if (top > 0) {
                            i3 = vVar5.arT.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                vVar4 = vVar5;
                                i7 = i6;
                                i4++;
                                vVar2 = vVar4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        vVar4 = vVar3;
                        i4++;
                        vVar2 = vVar4;
                        i3 = i7;
                    }
                }
                i3 = i5;
                if (top < 0) {
                    i5 = vVar5.arT.getTop() - i2;
                    i5 = Math.abs(i5);
                    if (i5 > i3) {
                        vVar3 = vVar5;
                        if (top > 0) {
                            i3 = vVar5.arT.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                vVar4 = vVar5;
                                i7 = i6;
                                i4++;
                                vVar2 = vVar4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        vVar4 = vVar3;
                        i4++;
                        vVar2 = vVar4;
                        i3 = i7;
                    }
                }
                i5 = i3;
                if (top > 0) {
                    i3 = vVar5.arT.getBottom() - height;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        i6 = i3;
                        vVar4 = vVar5;
                        i7 = i6;
                        i4++;
                        vVar2 = vVar4;
                        i3 = i7;
                    }
                }
                i7 = i5;
                vVar4 = vVar3;
                i4++;
                vVar2 = vVar4;
                i3 = i7;
            }
            return vVar2;
        }

        public void m13644j(v vVar, int i) {
            if (vVar != null) {
                awO.cL(vVar.arT);
            }
        }

        private int m13626p(RecyclerView recyclerView) {
            if (this.awR == -1) {
                this.awR = recyclerView.getResources().getDimensionPixelSize(C3997a.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.awR;
        }

        public void m13635a(RecyclerView recyclerView, v vVar, int i, v vVar2, int i2, int i3, int i4) {
            h layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof C4102d) {
                ((C4102d) layoutManager).m13646a(vVar.arT, vVar2.arT, i3, i4);
                return;
            }
            if (layoutManager.pe()) {
                if (layoutManager.ch(vVar2.arT) <= recyclerView.getPaddingLeft()) {
                    recyclerView.dg(i2);
                }
                if (layoutManager.cj(vVar2.arT) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.dg(i2);
                }
            }
            if (layoutManager.pf()) {
                if (layoutManager.ci(vVar2.arT) <= recyclerView.getPaddingTop()) {
                    recyclerView.dg(i2);
                }
                if (layoutManager.ck(vVar2.arT) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.dg(i2);
                }
            }
        }

        void m13634a(Canvas canvas, RecyclerView recyclerView, v vVar, List<C4093c> list, int i, float f, float f2) {
            int i2;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                C4093c c4093c = (C4093c) list.get(i2);
                c4093c.update();
                int save = canvas.save();
                m13633a(canvas, recyclerView, c4093c.aqZ, c4093c.awZ, c4093c.axa, c4093c.awz, false);
                canvas.restoreToCount(save);
            }
            if (vVar != null) {
                i2 = canvas.save();
                m13633a(canvas, recyclerView, vVar, f, f2, i, true);
                canvas.restoreToCount(i2);
            }
        }

        void m13639b(Canvas canvas, RecyclerView recyclerView, v vVar, List<C4093c> list, int i, float f, float f2) {
            int i2;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                C4093c c4093c = (C4093c) list.get(i2);
                int save = canvas.save();
                m13638b(canvas, recyclerView, c4093c.aqZ, c4093c.awZ, c4093c.axa, c4093c.awz, false);
                canvas.restoreToCount(save);
            }
            if (vVar != null) {
                i2 = canvas.save();
                m13638b(canvas, recyclerView, vVar, f, f2, i, true);
                canvas.restoreToCount(i2);
            }
            Object obj = null;
            int i3 = size - 1;
            while (i3 >= 0) {
                Object obj2;
                c4093c = (C4093c) list.get(i3);
                if (c4093c.GG && !c4093c.awY) {
                    list.remove(i3);
                    obj2 = obj;
                } else if (c4093c.GG) {
                    obj2 = obj;
                } else {
                    obj2 = 1;
                }
                i3--;
                obj = obj2;
            }
            if (obj != null) {
                recyclerView.invalidate();
            }
        }

        public void m13642d(RecyclerView recyclerView, v vVar) {
            awO.cK(vVar.arT);
        }

        public void m13633a(Canvas canvas, RecyclerView recyclerView, v vVar, float f, float f2, int i, boolean z) {
            awO.mo4157a(canvas, recyclerView, vVar.arT, f, f2, i, z);
        }

        public void m13638b(Canvas canvas, RecyclerView recyclerView, v vVar, float f, float f2, int i, boolean z) {
            awO.mo4158b(canvas, recyclerView, vVar.arT, f, f2, i, z);
        }

        public long m13631a(RecyclerView recyclerView, int i, float f, float f2) {
            e itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            } else {
                if (i == 8) {
                    return itemAnimator.qy();
                }
                return itemAnimator.qA();
            }
        }

        public int m13629a(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f = 1.0f;
            int p = (int) (((float) (m13626p(recyclerView) * ((int) Math.signum((float) i2)))) * awQ.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (awP.getInterpolation(f) * ((float) p));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            } else {
                return interpolation;
            }
        }
    }

    class C4100b extends SimpleOnGestureListener {
        final /* synthetic */ tc awK;

        C4100b(tc tcVar) {
            this.awK = tcVar;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View p = this.awK.m13663p(motionEvent);
            if (p != null) {
                v bB = this.awK.aqI.bB(p);
                if (bB != null && this.awK.awy.m13641c(this.awK.aqI, bB) && motionEvent.getPointerId(0) == this.awK.mActivePointerId) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.awK.mActivePointerId);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    this.awK.awq = x;
                    this.awK.awr = y;
                    tc tcVar = this.awK;
                    this.awK.awv = 0.0f;
                    tcVar.awu = 0.0f;
                    if (this.awK.awy.sS()) {
                        this.awK.m13660f(bB, 2);
                    }
                }
            }
        }
    }

    public interface C4102d {
        void m13646a(View view, View view2, int i, int i2);
    }

    public tc(C4099a c4099a) {
        this.awy = c4099a;
    }

    private static boolean m13649a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public void m13662o(RecyclerView recyclerView) {
        if (this.aqI != recyclerView) {
            if (this.aqI != null) {
                rQ();
            }
            this.aqI = recyclerView;
            if (this.aqI != null) {
                Resources resources = recyclerView.getResources();
                this.aws = resources.getDimension(C3997a.item_touch_helper_swipe_escape_velocity);
                this.awt = resources.getDimension(C3997a.item_touch_helper_swipe_escape_max_velocity);
                rP();
            }
        }
    }

    private void rP() {
        this.atc = ViewConfiguration.get(this.aqI.getContext()).getScaledTouchSlop();
        this.aqI.a(this);
        this.aqI.a(this.awI);
        this.aqI.a(this);
        sM();
    }

    private void rQ() {
        this.aqI.b(this);
        this.aqI.b(this.awI);
        this.aqI.b(this);
        for (int size = this.awB.size() - 1; size >= 0; size--) {
            this.awy.m13642d(this.aqI, ((C4093c) this.awB.get(0)).aqZ);
        }
        this.awB.clear();
        this.awF = null;
        this.awG = -1;
        sQ();
    }

    private void sM() {
        if (this.awH == null) {
            this.awH = new kd(this.aqI.getContext(), new C4100b(this));
        }
    }

    private void m13648a(float[] fArr) {
        if ((this.awA & 12) != 0) {
            fArr[0] = (this.aww + this.awu) - ((float) this.awp.arT.getLeft());
        } else {
            fArr[0] = li.Z(this.awp.arT);
        }
        if ((this.awA & 3) != 0) {
            fArr[1] = (this.awx + this.awv) - ((float) this.awp.arT.getTop());
        } else {
            fArr[1] = li.aa(this.awp.arT);
        }
    }

    public void m13659b(Canvas canvas, RecyclerView recyclerView, s sVar) {
        float f;
        float f2 = 0.0f;
        if (this.awp != null) {
            m13648a(this.awo);
            f = this.awo[0];
            f2 = this.awo[1];
        } else {
            f = 0.0f;
        }
        this.awy.m13639b(canvas, recyclerView, this.awp, this.awB, this.awz, f, f2);
    }

    public void m13654a(Canvas canvas, RecyclerView recyclerView, s sVar) {
        float f;
        float f2 = 0.0f;
        this.awG = -1;
        if (this.awp != null) {
            m13648a(this.awo);
            f = this.awo[0];
            f2 = this.awo[1];
        } else {
            f = 0.0f;
        }
        this.awy.m13634a(canvas, recyclerView, this.awp, this.awB, this.awz, f, f2);
    }

    void m13660f(v vVar, int i) {
        if (vVar != this.awp || i != this.awz) {
            this.awJ = Long.MIN_VALUE;
            int i2 = this.awz;
            m13661g(vVar, true);
            this.awz = i;
            if (i == 2) {
                this.awF = vVar.arT;
                sR();
            }
            int i3 = (1 << ((i * 8) + 8)) - 1;
            Object obj = null;
            if (this.awp != null) {
                v vVar2 = this.awp;
                if (vVar2.arT.getParent() != null) {
                    int i4;
                    float f;
                    float signum;
                    int i5;
                    if (i2 == 2) {
                        i4 = 0;
                    } else {
                        i4 = ab(vVar2);
                    }
                    sQ();
                    switch (i4) {
                        case 1:
                        case 2:
                            f = 0.0f;
                            signum = Math.signum(this.awv) * ((float) this.aqI.getHeight());
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            signum = 0.0f;
                            f = Math.signum(this.awu) * ((float) this.aqI.getWidth());
                            break;
                        default:
                            f = 0.0f;
                            signum = 0.0f;
                            break;
                    }
                    if (i2 == 2) {
                        i5 = 8;
                    } else if (i4 > 0) {
                        i5 = 2;
                    } else {
                        i5 = 4;
                    }
                    m13648a(this.awo);
                    float f2 = this.awo[0];
                    float f3 = this.awo[1];
                    final v vVar3 = vVar2;
                    C4093c c40943 = new C4093c(this, vVar2, i5, i2, f2, f3, f, signum) {
                        final /* synthetic */ tc awK;

                        public void mo4156b(ef efVar) {
                            super.mo4156b(efVar);
                            if (!this.axb) {
                                if (i4 <= 0) {
                                    this.awK.awy.m13642d(this.awK.aqI, vVar3);
                                } else {
                                    this.awK.awn.add(vVar3.arT);
                                    this.awY = true;
                                    if (i4 > 0) {
                                        this.awK.m13657a(this, i4);
                                    }
                                }
                                if (this.awK.awF == vVar3.arT) {
                                    this.awK.cJ(vVar3.arT);
                                }
                            }
                        }
                    };
                    c40943.setDuration(this.awy.m13631a(this.aqI, i5, f - f2, signum - f3));
                    this.awB.add(c40943);
                    c40943.start();
                    obj = 1;
                } else {
                    cJ(vVar2.arT);
                    this.awy.m13642d(this.aqI, vVar2);
                }
                this.awp = null;
            }
            Object obj2 = obj;
            if (vVar != null) {
                this.awA = (this.awy.m13637b(this.aqI, vVar) & i3) >> (this.awz * 8);
                this.aww = (float) vVar.arT.getLeft();
                this.awx = (float) vVar.arT.getTop();
                this.awp = vVar;
                if (i == 2) {
                    this.awp.arT.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.aqI.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.awp != null);
            }
            if (obj2 == null) {
                this.aqI.getLayoutManager().qK();
            }
            this.awy.m13644j(this.awp, this.awz);
            this.aqI.invalidate();
        }
    }

    void m13657a(final C4093c c4093c, final int i) {
        this.aqI.post(new Runnable(this) {
            final /* synthetic */ tc awK;

            public void run() {
                if (this.awK.aqI != null && this.awK.aqI.isAttachedToWindow() && !c4093c.axb && c4093c.aqZ.rm() != -1) {
                    e itemAnimator = this.awK.aqI.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.a(null)) && !this.awK.sN()) {
                        this.awK.awy.m13643i(c4093c.aqZ, i);
                    } else {
                        this.awK.aqI.post(this);
                    }
                }
            }
        });
    }

    boolean sN() {
        int size = this.awB.size();
        for (int i = 0; i < size; i++) {
            if (!((C4093c) this.awB.get(i)).GG) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean sO() {
        /*
        r14 = this;
        r12 = -9223372036854775808;
        r0 = 0;
        r5 = 0;
        r1 = r14.awp;
        if (r1 != 0) goto L_0x000b;
    L_0x0008:
        r14.awJ = r12;
    L_0x000a:
        return r0;
    L_0x000b:
        r10 = java.lang.System.currentTimeMillis();
        r2 = r14.awJ;
        r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r1 != 0) goto L_0x00bb;
    L_0x0015:
        r6 = 0;
    L_0x0017:
        r1 = r14.aqI;
        r1 = r1.getLayoutManager();
        r2 = r14.xL;
        if (r2 != 0) goto L_0x0028;
    L_0x0021:
        r2 = new android.graphics.Rect;
        r2.<init>();
        r14.xL = r2;
    L_0x0028:
        r2 = r14.awp;
        r2 = r2.arT;
        r3 = r14.xL;
        r1.g(r2, r3);
        r2 = r1.pe();
        if (r2 == 0) goto L_0x00e6;
    L_0x0037:
        r2 = r14.aww;
        r3 = r14.awu;
        r2 = r2 + r3;
        r2 = (int) r2;
        r3 = r14.xL;
        r3 = r3.left;
        r3 = r2 - r3;
        r4 = r14.aqI;
        r4 = r4.getPaddingLeft();
        r4 = r3 - r4;
        r3 = r14.awu;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 >= 0) goto L_0x00c1;
    L_0x0051:
        if (r4 >= 0) goto L_0x00c1;
    L_0x0053:
        r1 = r1.pf();
        if (r1 == 0) goto L_0x010e;
    L_0x0059:
        r1 = r14.awx;
        r2 = r14.awv;
        r1 = r1 + r2;
        r1 = (int) r1;
        r2 = r14.xL;
        r2 = r2.top;
        r2 = r1 - r2;
        r3 = r14.aqI;
        r3 = r3.getPaddingTop();
        r8 = r2 - r3;
        r2 = r14.awv;
        r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x00e9;
    L_0x0073:
        if (r8 >= 0) goto L_0x00e9;
    L_0x0075:
        if (r4 == 0) goto L_0x0117;
    L_0x0077:
        r1 = r14.awy;
        r2 = r14.aqI;
        r3 = r14.awp;
        r3 = r3.arT;
        r3 = r3.getWidth();
        r5 = r14.aqI;
        r5 = r5.getWidth();
        r4 = r1.m13629a(r2, r3, r4, r5, r6);
        r9 = r4;
    L_0x008e:
        if (r8 == 0) goto L_0x0115;
    L_0x0090:
        r1 = r14.awy;
        r2 = r14.aqI;
        r3 = r14.awp;
        r3 = r3.arT;
        r3 = r3.getHeight();
        r4 = r14.aqI;
        r5 = r4.getHeight();
        r4 = r8;
        r1 = r1.m13629a(r2, r3, r4, r5, r6);
    L_0x00a7:
        if (r9 != 0) goto L_0x00ab;
    L_0x00a9:
        if (r1 == 0) goto L_0x0111;
    L_0x00ab:
        r2 = r14.awJ;
        r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r0 != 0) goto L_0x00b3;
    L_0x00b1:
        r14.awJ = r10;
    L_0x00b3:
        r0 = r14.aqI;
        r0.scrollBy(r9, r1);
        r0 = 1;
        goto L_0x000a;
    L_0x00bb:
        r2 = r14.awJ;
        r6 = r10 - r2;
        goto L_0x0017;
    L_0x00c1:
        r3 = r14.awu;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 <= 0) goto L_0x00e6;
    L_0x00c7:
        r3 = r14.awp;
        r3 = r3.arT;
        r3 = r3.getWidth();
        r2 = r2 + r3;
        r3 = r14.xL;
        r3 = r3.right;
        r2 = r2 + r3;
        r3 = r14.aqI;
        r3 = r3.getWidth();
        r4 = r14.aqI;
        r4 = r4.getPaddingRight();
        r3 = r3 - r4;
        r4 = r2 - r3;
        if (r4 > 0) goto L_0x0053;
    L_0x00e6:
        r4 = r0;
        goto L_0x0053;
    L_0x00e9:
        r2 = r14.awv;
        r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x010e;
    L_0x00ef:
        r2 = r14.awp;
        r2 = r2.arT;
        r2 = r2.getHeight();
        r1 = r1 + r2;
        r2 = r14.xL;
        r2 = r2.bottom;
        r1 = r1 + r2;
        r2 = r14.aqI;
        r2 = r2.getHeight();
        r3 = r14.aqI;
        r3 = r3.getPaddingBottom();
        r2 = r2 - r3;
        r8 = r1 - r2;
        if (r8 > 0) goto L_0x0075;
    L_0x010e:
        r8 = r0;
        goto L_0x0075;
    L_0x0111:
        r14.awJ = r12;
        goto L_0x000a;
    L_0x0115:
        r1 = r8;
        goto L_0x00a7;
    L_0x0117:
        r9 = r4;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.tc.sO():boolean");
    }

    private List<v> m13647Y(v vVar) {
        if (this.awD == null) {
            this.awD = new ArrayList();
            this.awE = new ArrayList();
        } else {
            this.awD.clear();
            this.awE.clear();
        }
        int sU = this.awy.sU();
        int round = Math.round(this.aww + this.awu) - sU;
        int round2 = Math.round(this.awx + this.awv) - sU;
        int width = (vVar.arT.getWidth() + round) + (sU * 2);
        int height = (vVar.arT.getHeight() + round2) + (sU * 2);
        int i = (round + width) / 2;
        int i2 = (round2 + height) / 2;
        h layoutManager = this.aqI.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            if (childAt != vVar.arT && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                v bB = this.aqI.bB(childAt);
                if (this.awy.m13636a(this.aqI, this.awp, bB)) {
                    int abs = Math.abs(i - ((childAt.getLeft() + childAt.getRight()) / 2));
                    sU = Math.abs(i2 - ((childAt.getBottom() + childAt.getTop()) / 2));
                    int i4 = (abs * abs) + (sU * sU);
                    int size = this.awD.size();
                    int i5 = 0;
                    abs = 0;
                    while (abs < size && i4 > ((Integer) this.awE.get(abs)).intValue()) {
                        i5++;
                        abs++;
                    }
                    this.awD.add(i5, bB);
                    this.awE.add(i5, Integer.valueOf(i4));
                }
            }
        }
        return this.awD;
    }

    void m13653Z(v vVar) {
        if (!this.aqI.isLayoutRequested() && this.awz == 2) {
            float ad = this.awy.ad(vVar);
            int i = (int) (this.aww + this.awu);
            int i2 = (int) (this.awx + this.awv);
            if (((float) Math.abs(i2 - vVar.arT.getTop())) >= ((float) vVar.arT.getHeight()) * ad || ((float) Math.abs(i - vVar.arT.getLeft())) >= ad * ((float) vVar.arT.getWidth())) {
                List Y = m13647Y(vVar);
                if (Y.size() != 0) {
                    v a = this.awy.m13632a(vVar, Y, i, i2);
                    if (a == null) {
                        this.awD.clear();
                        this.awE.clear();
                        return;
                    }
                    int rm = a.rm();
                    int rm2 = vVar.rm();
                    if (this.awy.m13640b(this.aqI, vVar, a)) {
                        this.awy.m13635a(this.aqI, vVar, rm2, a, rm, i, i2);
                    }
                }
            }
        }
    }

    public void cr(View view) {
    }

    public void cs(View view) {
        cJ(view);
        v bB = this.aqI.bB(view);
        if (bB != null) {
            if (this.awp == null || bB != this.awp) {
                m13661g(bB, false);
                if (this.awn.remove(bB.arT)) {
                    this.awy.m13642d(this.aqI, bB);
                    return;
                }
                return;
            }
            m13660f(null, 0);
        }
    }

    int m13661g(v vVar, boolean z) {
        for (int size = this.awB.size() - 1; size >= 0; size--) {
            C4093c c4093c = (C4093c) this.awB.get(size);
            if (c4093c.aqZ == vVar) {
                c4093c.axb |= z;
                if (!c4093c.GG) {
                    c4093c.cancel();
                }
                this.awB.remove(size);
                return c4093c.awX;
            }
        }
        return 0;
    }

    public void m13655a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
        rect.setEmpty();
    }

    void sP() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    private void sQ() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private v m13652o(MotionEvent motionEvent) {
        h layoutManager = this.aqI.getLayoutManager();
        if (this.mActivePointerId == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        float x = motionEvent.getX(findPointerIndex) - this.awq;
        float y = motionEvent.getY(findPointerIndex) - this.awr;
        x = Math.abs(x);
        y = Math.abs(y);
        if (x < ((float) this.atc) && y < ((float) this.atc)) {
            return null;
        }
        if (x > y && layoutManager.pe()) {
            return null;
        }
        if (y > x && layoutManager.pf()) {
            return null;
        }
        View p = m13663p(motionEvent);
        if (p != null) {
            return this.aqI.bB(p);
        }
        return null;
    }

    boolean m13658a(int i, MotionEvent motionEvent, int i2) {
        if (this.awp != null || i != 2 || this.awz == 2 || !this.awy.sT() || this.aqI.getScrollState() == 1) {
            return false;
        }
        v o = m13652o(motionEvent);
        if (o == null) {
            return false;
        }
        int b = (this.awy.m13637b(this.aqI, o) & 65280) >> 8;
        if (b == 0) {
            return false;
        }
        float x = motionEvent.getX(i2);
        x -= this.awq;
        float y = motionEvent.getY(i2) - this.awr;
        float abs = Math.abs(x);
        float abs2 = Math.abs(y);
        if (abs < ((float) this.atc) && abs2 < ((float) this.atc)) {
            return false;
        }
        if (abs > abs2) {
            if (x < 0.0f && (b & 4) == 0) {
                return false;
            }
            if (x > 0.0f && (b & 8) == 0) {
                return false;
            }
        } else if (y < 0.0f && (b & 1) == 0) {
            return false;
        } else {
            if (y > 0.0f && (b & 2) == 0) {
                return false;
            }
        }
        this.awv = 0.0f;
        this.awu = 0.0f;
        this.mActivePointerId = motionEvent.getPointerId(0);
        m13660f(o, 1);
        return true;
    }

    View m13663p(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.awp != null) {
            View view = this.awp.arT;
            if (m13649a(view, x, y, this.aww + this.awu, this.awx + this.awv)) {
                return view;
            }
        }
        for (int size = this.awB.size() - 1; size >= 0; size--) {
            C4093c c4093c = (C4093c) this.awB.get(size);
            View view2 = c4093c.aqZ.arT;
            if (m13649a(view2, x, y, c4093c.awZ, c4093c.axa)) {
                return view2;
            }
        }
        return this.aqI.s(x, y);
    }

    public void aa(v vVar) {
        if (!this.awy.m13641c(this.aqI, vVar)) {
            Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
        } else if (vVar.arT.getParent() != this.aqI) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            sP();
            this.awv = 0.0f;
            this.awu = 0.0f;
            m13660f(vVar, 2);
        }
    }

    C4093c m13664q(MotionEvent motionEvent) {
        if (this.awB.isEmpty()) {
            return null;
        }
        View p = m13663p(motionEvent);
        for (int size = this.awB.size() - 1; size >= 0; size--) {
            C4093c c4093c = (C4093c) this.awB.get(size);
            if (c4093c.aqZ.arT == p) {
                return c4093c;
            }
        }
        return null;
    }

    void m13656a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.awu = x - this.awq;
        this.awv = y - this.awr;
        if ((i & 4) == 0) {
            this.awu = Math.max(0.0f, this.awu);
        }
        if ((i & 8) == 0) {
            this.awu = Math.min(0.0f, this.awu);
        }
        if ((i & 1) == 0) {
            this.awv = Math.max(0.0f, this.awv);
        }
        if ((i & 2) == 0) {
            this.awv = Math.min(0.0f, this.awv);
        }
    }

    private int ab(v vVar) {
        if (this.awz == 2) {
            return 0;
        }
        int a = this.awy.m13630a(this.aqI, vVar);
        int aX = (this.awy.aX(a, li.S(this.aqI)) & 65280) >> 8;
        if (aX == 0) {
            return 0;
        }
        int i = (a & 65280) >> 8;
        if (Math.abs(this.awu) > Math.abs(this.awv)) {
            a = m13650g(vVar, aX);
            if (a > 0) {
                return (i & a) == 0 ? C4099a.aU(a, li.S(this.aqI)) : a;
            } else {
                a = m13651h(vVar, aX);
                if (a > 0) {
                    return a;
                }
                return 0;
            }
        }
        a = m13651h(vVar, aX);
        if (a > 0) {
            return a;
        }
        a = m13650g(vVar, aX);
        if (a > 0) {
            return (i & a) == 0 ? C4099a.aU(a, li.S(this.aqI)) : a;
        } else {
            return 0;
        }
    }

    private int m13650g(v vVar, int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.awu > 0.0f ? 8 : 4;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.awy.m13628P(this.awt));
                float a = lg.a(this.mVelocityTracker, this.mActivePointerId);
                float b = lg.b(this.mVelocityTracker, this.mActivePointerId);
                if (a <= 0.0f) {
                    i2 = 4;
                }
                float abs = Math.abs(a);
                if ((i2 & i) != 0 && i3 == i2 && abs >= this.awy.m13627O(this.aws) && abs > Math.abs(b)) {
                    return i2;
                }
            }
            float width = ((float) this.aqI.getWidth()) * this.awy.ac(vVar);
            if ((i & i3) != 0 && Math.abs(this.awu) > width) {
                return i3;
            }
        }
        return 0;
    }

    private int m13651h(v vVar, int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.awv > 0.0f ? 2 : 1;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.awy.m13628P(this.awt));
                float a = lg.a(this.mVelocityTracker, this.mActivePointerId);
                float b = lg.b(this.mVelocityTracker, this.mActivePointerId);
                if (b <= 0.0f) {
                    i2 = 1;
                }
                float abs = Math.abs(b);
                if ((i2 & i) != 0 && i2 == i3 && abs >= this.awy.m13627O(this.aws) && abs > Math.abs(a)) {
                    return i2;
                }
            }
            float height = ((float) this.aqI.getHeight()) * this.awy.ac(vVar);
            if ((i & i3) != 0 && Math.abs(this.awv) > height) {
                return i3;
            }
        }
        return 0;
    }

    private void sR() {
        if (VERSION.SDK_INT < 21) {
            if (this.aqr == null) {
                this.aqr = new C40965(this);
            }
            this.aqI.setChildDrawingOrderCallback(this.aqr);
        }
    }

    void cJ(View view) {
        if (view == this.awF) {
            this.awF = null;
            if (this.aqr != null) {
                this.aqI.setChildDrawingOrderCallback(null);
            }
        }
    }
}
