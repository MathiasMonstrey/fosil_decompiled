package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class kd {
    private final C3782a QV;

    interface C3782a {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    static class C3784b implements C3782a {
        private static final int Ra = ViewConfiguration.getLongPressTimeout();
        private static final int Rb = ViewConfiguration.getTapTimeout();
        private static final int Rc = ViewConfiguration.getDoubleTapTimeout();
        private int QW;
        private int QX;
        private int QY;
        private int QZ;
        final OnGestureListener Rd;
        OnDoubleTapListener Re;
        boolean Rf;
        boolean Rg;
        private boolean Rh;
        private boolean Ri;
        private boolean Rj;
        MotionEvent Rk;
        private MotionEvent Rl;
        private boolean Rm;
        private float Rn;
        private float Ro;
        private float Rp;
        private float Rq;
        private boolean Rr;
        private final Handler mHandler;
        private VelocityTracker mVelocityTracker;

        class C3783a extends Handler {
            final /* synthetic */ C3784b Rs;

            C3783a(C3784b c3784b) {
                this.Rs = c3784b;
            }

            C3783a(C3784b c3784b, Handler handler) {
                this.Rs = c3784b;
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        this.Rs.Rd.onShowPress(this.Rs.Rk);
                        return;
                    case 2:
                        this.Rs.jB();
                        return;
                    case 3:
                        if (this.Rs.Re == null) {
                            return;
                        }
                        if (this.Rs.Rf) {
                            this.Rs.Rg = true;
                            return;
                        } else {
                            this.Rs.Re.onSingleTapConfirmed(this.Rs.Rk);
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        public C3784b(Context context, OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new C3783a(this, handler);
            } else {
                this.mHandler = new C3783a(this);
            }
            this.Rd = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                setOnDoubleTapListener((OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.Rd == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.Rr = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.QY = viewConfiguration.getScaledMinimumFlingVelocity();
                this.QZ = viewConfiguration.getScaledMaximumFlingVelocity();
                this.QW = scaledTouchSlop * scaledTouchSlop;
                this.QX = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            this.Re = onDoubleTapListener;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int i;
            int action = motionEvent.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            boolean z = (action & 255) == 6;
            int b = z ? ks.m12044b(motionEvent) : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            for (i = 0; i < pointerCount; i++) {
                if (b != i) {
                    f2 += motionEvent.getX(i);
                    f += motionEvent.getY(i);
                }
            }
            b = z ? pointerCount - 1 : pointerCount;
            f2 /= (float) b;
            f /= (float) b;
            boolean hasMessages;
            float b2;
            float a;
            switch (action & 255) {
                case 0:
                    if (this.Re != null) {
                        hasMessages = this.mHandler.hasMessages(3);
                        if (hasMessages) {
                            this.mHandler.removeMessages(3);
                        }
                        if (this.Rk == null || this.Rl == null || !hasMessages || !m11957a(this.Rk, this.Rl, motionEvent)) {
                            this.mHandler.sendEmptyMessageDelayed(3, (long) Rc);
                        } else {
                            this.Rm = true;
                            b = (this.Re.onDoubleTap(this.Rk) | 0) | this.Re.onDoubleTapEvent(motionEvent);
                            this.Rn = f2;
                            this.Rp = f2;
                            this.Ro = f;
                            this.Rq = f;
                            if (this.Rk != null) {
                                this.Rk.recycle();
                            }
                            this.Rk = MotionEvent.obtain(motionEvent);
                            this.Ri = true;
                            this.Rj = true;
                            this.Rf = true;
                            this.Rh = false;
                            this.Rg = false;
                            if (this.Rr) {
                                this.mHandler.removeMessages(2);
                                this.mHandler.sendEmptyMessageAtTime(2, (this.Rk.getDownTime() + ((long) Rb)) + ((long) Ra));
                            }
                            this.mHandler.sendEmptyMessageAtTime(1, this.Rk.getDownTime() + ((long) Rb));
                            return b | this.Rd.onDown(motionEvent);
                        }
                    }
                    b = 0;
                    this.Rn = f2;
                    this.Rp = f2;
                    this.Ro = f;
                    this.Rq = f;
                    if (this.Rk != null) {
                        this.Rk.recycle();
                    }
                    this.Rk = MotionEvent.obtain(motionEvent);
                    this.Ri = true;
                    this.Rj = true;
                    this.Rf = true;
                    this.Rh = false;
                    this.Rg = false;
                    if (this.Rr) {
                        this.mHandler.removeMessages(2);
                        this.mHandler.sendEmptyMessageAtTime(2, (this.Rk.getDownTime() + ((long) Rb)) + ((long) Ra));
                    }
                    this.mHandler.sendEmptyMessageAtTime(1, this.Rk.getDownTime() + ((long) Rb));
                    return b | this.Rd.onDown(motionEvent);
                case 1:
                    this.Rf = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.Rm) {
                        hasMessages = this.Re.onDoubleTapEvent(motionEvent) | 0;
                    } else if (this.Rh) {
                        this.mHandler.removeMessages(3);
                        this.Rh = false;
                        hasMessages = false;
                    } else if (this.Ri) {
                        hasMessages = this.Rd.onSingleTapUp(motionEvent);
                        if (this.Rg && this.Re != null) {
                            this.Re.onSingleTapConfirmed(motionEvent);
                        }
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, (float) this.QZ);
                        b2 = lg.m12076b(velocityTracker, pointerId);
                        a = lg.m12075a(velocityTracker, pointerId);
                        hasMessages = (Math.abs(b2) > ((float) this.QY) || Math.abs(a) > ((float) this.QY)) ? this.Rd.onFling(this.Rk, motionEvent, a, b2) : false;
                    }
                    if (this.Rl != null) {
                        this.Rl.recycle();
                    }
                    this.Rl = obtain;
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.Rm = false;
                    this.Rg = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    return hasMessages;
                case 2:
                    if (this.Rh) {
                        return false;
                    }
                    a = this.Rn - f2;
                    b2 = this.Ro - f;
                    if (this.Rm) {
                        return false | this.Re.onDoubleTapEvent(motionEvent);
                    }
                    if (this.Ri) {
                        i = (int) (f2 - this.Rp);
                        int i2 = (int) (f - this.Rq);
                        i = (i * i) + (i2 * i2);
                        if (i > this.QW) {
                            hasMessages = this.Rd.onScroll(this.Rk, motionEvent, a, b2);
                            this.Rn = f2;
                            this.Ro = f;
                            this.Ri = false;
                            this.mHandler.removeMessages(3);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(2);
                        } else {
                            hasMessages = false;
                        }
                        if (i > this.QW) {
                            this.Rj = false;
                        }
                        return hasMessages;
                    } else if (Math.abs(a) < 1.0f && Math.abs(b2) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.Rd.onScroll(this.Rk, motionEvent, a, b2);
                        this.Rn = f2;
                        this.Ro = f;
                        return onScroll;
                    }
                case 3:
                    cancel();
                    return false;
                case 5:
                    this.Rn = f2;
                    this.Rp = f2;
                    this.Ro = f;
                    this.Rq = f;
                    jA();
                    return false;
                case 6:
                    this.Rn = f2;
                    this.Rp = f2;
                    this.Ro = f;
                    this.Rq = f;
                    this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.QZ);
                    int b3 = ks.m12044b(motionEvent);
                    b = motionEvent.getPointerId(b3);
                    f2 = lg.m12075a(this.mVelocityTracker, b);
                    float b4 = lg.m12076b(this.mVelocityTracker, b);
                    for (b = 0; b < pointerCount; b++) {
                        if (b != b3) {
                            int pointerId2 = motionEvent.getPointerId(b);
                            if ((lg.m12076b(this.mVelocityTracker, pointerId2) * b4) + (lg.m12075a(this.mVelocityTracker, pointerId2) * f2) < 0.0f) {
                                this.mVelocityTracker.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                default:
                    return false;
            }
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.Rm = false;
            this.Rf = false;
            this.Ri = false;
            this.Rj = false;
            this.Rg = false;
            if (this.Rh) {
                this.Rh = false;
            }
        }

        private void jA() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.Rm = false;
            this.Ri = false;
            this.Rj = false;
            this.Rg = false;
            if (this.Rh) {
                this.Rh = false;
            }
        }

        private boolean m11957a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.Rj || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) Rc)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x * x) + (y * y) < this.QX) {
                return true;
            }
            return false;
        }

        void jB() {
            this.mHandler.removeMessages(3);
            this.Rg = false;
            this.Rh = true;
            this.Rd.onLongPress(this.Rk);
        }
    }

    static class C3785c implements C3782a {
        private final GestureDetector Rt;

        public C3785c(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.Rt = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.Rt.onTouchEvent(motionEvent);
        }
    }

    public kd(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public kd(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.QV = new C3785c(context, onGestureListener, handler);
        } else {
            this.QV = new C3784b(context, onGestureListener, handler);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.QV.onTouchEvent(motionEvent);
    }
}
