package com.fossil;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

public class aay extends yf {
    private boolean aEb;
    private yf aGG;
    private C1555a aGH;

    static class C1555a extends ConstantState {
        private final ConstantState aGI;
        private final int aGJ;

        C1555a(C1555a c1555a) {
            this(c1555a.aGI, c1555a.aGJ);
        }

        C1555a(ConstantState constantState, int i) {
            this.aGI = constantState;
            this.aGJ = i;
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public Drawable newDrawable(Resources resources) {
            return new aay(this, null, resources);
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }

    public aay(yf yfVar, int i) {
        this(new C1555a(yfVar.getConstantState(), i), yfVar, null);
    }

    aay(C1555a c1555a, yf yfVar, Resources resources) {
        this.aGH = c1555a;
        if (yfVar != null) {
            this.aGG = yfVar;
        } else if (resources != null) {
            this.aGG = (yf) c1555a.aGI.newDrawable(resources);
        } else {
            this.aGG = (yf) c1555a.aGI.newDrawable();
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.aGG.setBounds(i, i2, i3, i4);
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.aGG.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.aGG.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.aGG.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.aGG.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.aGG.setFilterBitmap(z);
    }

    @TargetApi(11)
    public Callback getCallback() {
        return this.aGG.getCallback();
    }

    @TargetApi(19)
    public int getAlpha() {
        return this.aGG.getAlpha();
    }

    public void setColorFilter(int i, Mode mode) {
        this.aGG.setColorFilter(i, mode);
    }

    public void clearColorFilter() {
        this.aGG.clearColorFilter();
    }

    public Drawable getCurrent() {
        return this.aGG.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.aGG.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.aGH.aGJ;
    }

    public int getIntrinsicHeight() {
        return this.aGH.aGJ;
    }

    public int getMinimumWidth() {
        return this.aGG.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.aGG.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.aGG.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.aGG.invalidateSelf();
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.aGG.unscheduleSelf(runnable);
    }

    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.aGG.scheduleSelf(runnable, j);
    }

    public void draw(Canvas canvas) {
        this.aGG.draw(canvas);
    }

    public void setAlpha(int i) {
        this.aGG.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.aGG.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return this.aGG.getOpacity();
    }

    public boolean vJ() {
        return this.aGG.vJ();
    }

    public void eI(int i) {
        this.aGG.eI(i);
    }

    public void start() {
        this.aGG.start();
    }

    public void stop() {
        this.aGG.stop();
    }

    public boolean isRunning() {
        return this.aGG.isRunning();
    }

    public Drawable mutate() {
        if (!this.aEb && super.mutate() == this) {
            this.aGG = (yf) this.aGG.mutate();
            this.aGH = new C1555a(this.aGH);
            this.aEb = true;
        }
        return this;
    }

    public ConstantState getConstantState() {
        return this.aGH;
    }
}
