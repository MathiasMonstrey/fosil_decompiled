package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class pp extends Drawable implements Callback {
    private Drawable Nt;

    public pp(Drawable drawable) {
        m13086l(drawable);
    }

    public void draw(Canvas canvas) {
        this.Nt.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.Nt.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.Nt.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.Nt.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.Nt.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.Nt.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.Nt.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.Nt.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.Nt.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.Nt.setState(iArr);
    }

    public int[] getState() {
        return this.Nt.getState();
    }

    public void jumpToCurrentState() {
        hh.c(this.Nt);
    }

    public Drawable getCurrent() {
        return this.Nt.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.Nt.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.Nt.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.Nt.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.Nt.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.Nt.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.Nt.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.Nt.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.Nt.getPadding(rect);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.Nt.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        hh.a(this.Nt, z);
    }

    public boolean isAutoMirrored() {
        return hh.d(this.Nt);
    }

    public void setTint(int i) {
        hh.a(this.Nt, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        hh.a(this.Nt, colorStateList);
    }

    public void setTintMode(Mode mode) {
        hh.a(this.Nt, mode);
    }

    public void setHotspot(float f, float f2) {
        hh.a(this.Nt, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        hh.a(this.Nt, i, i2, i3, i4);
    }

    public Drawable iM() {
        return this.Nt;
    }

    public void m13086l(Drawable drawable) {
        if (this.Nt != null) {
            this.Nt.setCallback(null);
        }
        this.Nt = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
