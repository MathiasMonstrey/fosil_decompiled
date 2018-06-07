package android.support.design.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import com.fossil.ag.C1630k;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    private Drawable um;
    private final Rect un;
    private final Rect uo;
    private int uq;
    protected boolean ur;
    boolean us;

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.un = new Rect();
        this.uo = new Rect();
        this.uq = 119;
        this.ur = true;
        this.us = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.ForegroundLinearLayout, i, 0);
        this.uq = obtainStyledAttributes.getInt(C1630k.ForegroundLinearLayout_android_foregroundGravity, this.uq);
        Drawable drawable = obtainStyledAttributes.getDrawable(C1630k.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.ur = obtainStyledAttributes.getBoolean(C1630k.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public int getForegroundGravity() {
        return this.uq;
    }

    public void setForegroundGravity(int i) {
        if (this.uq != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.uq = i2;
            if (this.uq == 119 && this.um != null) {
                this.um.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.um;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.um != null) {
            this.um.jumpToCurrentState();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.um != null && this.um.isStateful()) {
            this.um.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.um != drawable) {
            if (this.um != null) {
                this.um.setCallback(null);
                unscheduleDrawable(this.um);
            }
            this.um = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.uq == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.um;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.us |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.us = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.um != null) {
            Drawable drawable = this.um;
            if (this.us) {
                this.us = false;
                Rect rect = this.un;
                Rect rect2 = this.uo;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.ur) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.uq, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.um != null) {
            this.um.setHotspot(f, f2);
        }
    }
}
