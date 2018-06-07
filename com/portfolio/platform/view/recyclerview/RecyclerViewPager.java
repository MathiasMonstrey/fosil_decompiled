package com.portfolio.platform.view.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.fossil.sg;
import com.portfolio.platform.PortfolioApp;

public class RecyclerViewPager extends RecyclerView {
    private int BU;
    private float RW;
    private float RX;
    private boolean Th;
    private int Ti;
    private int Tj;
    private float Tk;
    private float Tl;
    private int anz;
    private final LinearLayoutManager dpg;
    private C5040a dph;
    private int mActivePointerId;
    private boolean mIsBeingDragged;
    private int mTouchSlop;

    public interface C5040a {
        void ar(int i);
    }

    public RecyclerViewPager(Context context) {
        this(context, null);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.BU = 0;
        this.anz = 0;
        this.dpg = new LinearLayoutManager(context, 0, false);
        setLayoutManager(this.dpg);
        new sg().m13523o(this);
        this.Ti = (int) (PortfolioApp.ZQ().getResources().getDisplayMetrics().density * 16.0f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.Tj = Math.min(getMeasuredWidth() / 10, this.Ti);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            pX();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (this.Th) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.RW = x;
                this.Tk = x;
                x = motionEvent.getY();
                this.RX = x;
                this.Tl = x;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.Th = false;
                if (this.BU != 2) {
                    this.mIsBeingDragged = false;
                    break;
                }
                this.mIsBeingDragged = true;
                m16043I(true);
                this.BU = 1;
                break;
            case 2:
                action = this.mActivePointerId;
                if (action != -1) {
                    action = motionEvent.findPointerIndex(action);
                    float x2 = motionEvent.getX(action);
                    float f = x2 - this.Tk;
                    float abs = Math.abs(f);
                    float y = motionEvent.getY(action);
                    float abs2 = Math.abs(y - this.RX);
                    if (f == 0.0f || m16045f(this.Tk, f) || !m16046a(this, false, (int) f, (int) x2, (int) y)) {
                        if (abs <= ((float) this.mTouchSlop) || 0.5f * abs <= abs2) {
                            if (abs2 > ((float) this.mTouchSlop)) {
                                this.Th = true;
                                break;
                            }
                        }
                        this.mIsBeingDragged = true;
                        m16043I(true);
                        this.BU = 1;
                        this.Tk = f > 0.0f ? this.RW + ((float) this.mTouchSlop) : this.RW - ((float) this.mTouchSlop);
                        this.Tl = y;
                        break;
                    }
                    this.Tk = x2;
                    this.Tl = y;
                    this.Th = true;
                    return false;
                }
                break;
            case 6:
                m16044d(motionEvent);
                break;
        }
        if (super.onInterceptTouchEvent(motionEvent) && this.mIsBeingDragged) {
            return true;
        }
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || getAdapter() == null || getAdapter().getItemCount() == 0) {
            return false;
        }
        float x;
        int findPointerIndex;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                this.RW = x;
                this.Tk = x;
                x = motionEvent.getY();
                this.RX = x;
                this.Tl = x;
                this.mActivePointerId = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.mIsBeingDragged) {
                    pX();
                    break;
                }
                break;
            case 2:
                if (!this.mIsBeingDragged) {
                    findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex != -1) {
                        x = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x - this.Tk);
                        float y = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y - this.Tl);
                        if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                            this.mIsBeingDragged = true;
                            m16043I(true);
                            if (x - this.RW > 0.0f) {
                                abs2 = this.RW + ((float) this.mTouchSlop);
                            } else {
                                abs2 = this.RW - ((float) this.mTouchSlop);
                            }
                            this.Tk = abs2;
                            this.Tl = y;
                            this.BU = 1;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    pX();
                    break;
                }
                break;
            case 3:
                if (this.mIsBeingDragged) {
                    pX();
                    break;
                }
                break;
            case 5:
                findPointerIndex = motionEvent.getActionIndex();
                this.Tk = motionEvent.getX(findPointerIndex);
                this.mActivePointerId = motionEvent.getPointerId(findPointerIndex);
                break;
            case 6:
                m16044d(motionEvent);
                this.Tk = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void pX() {
        this.mActivePointerId = -1;
        jP();
    }

    private void m16044d(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.Tk = motionEvent.getX(actionIndex);
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
        }
    }

    private void jP() {
        this.mIsBeingDragged = false;
        this.Th = false;
    }

    private boolean m16045f(float f, float f2) {
        return (f < ((float) this.Tj) && f2 > 0.0f) || (f > ((float) (getWidth() - this.Tj)) && f2 < 0.0f);
    }

    protected boolean m16046a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m16046a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && view.canScrollHorizontally(-i)) {
            return true;
        }
        return false;
    }

    private void m16043I(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void au(int i, int i2) {
        super.au(i, i2);
        int pp = this.dpg.pp();
        if (this.anz != pp && pp >= 0) {
            this.anz = pp;
            if (this.dph != null) {
                this.dph.ar(pp);
            }
        }
    }

    public void setOnPageChangeListener(C5040a c5040a) {
        this.dph = c5040a;
    }

    public void dg(int i) {
        if (i == this.dpg.pp()) {
            au(0, 0);
        } else {
            super.dg(i);
        }
    }
}
