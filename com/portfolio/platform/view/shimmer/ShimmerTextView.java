package com.portfolio.platform.view.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.fossil.dsd;
import com.fossil.dsd.a;

public class ShimmerTextView extends AppCompatTextView {
    private dsd dpi;

    public ShimmerTextView(Context context) {
        super(context);
        this.dpi = new dsd(this, getPaint(), null);
        this.dpi.setPrimaryColor(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dpi = new dsd(this, getPaint(), attributeSet);
        this.dpi.setPrimaryColor(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dpi = new dsd(this, getPaint(), attributeSet);
        this.dpi.setPrimaryColor(getCurrentTextColor());
    }

    public float getGradientX() {
        return this.dpi.getGradientX();
    }

    public void setGradientX(float f) {
        this.dpi.setGradientX(f);
    }

    public void setShimmering(boolean z) {
        this.dpi.setShimmering(z);
    }

    public void setAnimationSetupCallback(a aVar) {
        this.dpi.setAnimationSetupCallback(aVar);
    }

    public int getPrimaryColor() {
        return this.dpi.getPrimaryColor();
    }

    public void setPrimaryColor(int i) {
        this.dpi.setPrimaryColor(i);
    }

    public int getReflectionColor() {
        return this.dpi.getReflectionColor();
    }

    public void setReflectionColor(int i) {
        this.dpi.setReflectionColor(i);
    }

    public void setTextColor(int i) {
        super.setTextColor(i);
        if (this.dpi != null) {
            this.dpi.setPrimaryColor(getCurrentTextColor());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        if (this.dpi != null) {
            this.dpi.setPrimaryColor(getCurrentTextColor());
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (getLineCount() != 1) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.dpi != null) {
                this.dpi.awq();
            }
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.dpi != null) {
            this.dpi.onDraw();
        }
        super.onDraw(canvas);
    }
}
