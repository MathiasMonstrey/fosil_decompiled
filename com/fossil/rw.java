package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.widget.ListViewCompat;
import android.view.MotionEvent;
import android.view.View;
import com.fossil.pk.C3982a;

public class rw extends ListViewCompat {
    private boolean amI;
    private boolean amJ;
    private boolean amK;
    private lz amL;
    private nu amM;

    public rw(Context context, boolean z) {
        super(context, null, C3982a.dropDownListViewStyle);
        this.amJ = z;
        setCacheColorHint(0);
    }

    public boolean mo4097g(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int a = ks.a(motionEvent);
        switch (a) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                m13474a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (a == 1) {
                    m13475x(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            oP();
        }
        if (z2) {
            if (this.amM == null) {
                this.amM = new nu(this);
            }
            this.amM.m12745J(true);
            this.amM.onTouch(this, motionEvent);
        } else if (this.amM != null) {
            this.amM.m12745J(false);
        }
        return z2;
    }

    private void m13475x(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    public void setListSelectionHidden(boolean z) {
        this.amI = z;
    }

    private void oP() {
        this.amK = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.aoV - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.amL != null) {
            this.amL.cancel();
            this.amL = null;
        }
    }

    private void m13474a(View view, int i, float f, float f2) {
        this.amK = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.aoV != -1) {
            View childAt = getChildAt(this.aoV - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.aoV = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    protected boolean oQ() {
        return this.amK || super.oQ();
    }

    public boolean isInTouchMode() {
        return (this.amJ && this.amI) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.amJ || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.amJ || super.isFocused();
    }

    public boolean hasFocus() {
        return this.amJ || super.hasFocus();
    }
}
