package com.fossil;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

abstract class ca extends Drawable implements ht {
    Drawable Ea;

    ca() {
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.Ea != null) {
            this.Ea.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.Ea != null) {
            return hh.m11633g(this.Ea);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.Ea != null) {
            return this.Ea.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.Ea != null) {
            this.Ea.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.Ea != null) {
            hh.m11620a(this.Ea, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.Ea != null) {
            hh.m11622a(this.Ea, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.Ea != null) {
            this.Ea.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.Ea != null) {
            hh.m11629c(this.Ea);
        }
    }

    public void applyTheme(Theme theme) {
        if (this.Ea != null) {
            hh.m11624a(this.Ea, theme);
        }
    }

    public void clearColorFilter() {
        if (this.Ea != null) {
            this.Ea.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.Ea != null) {
            return this.Ea.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.Ea != null) {
            return this.Ea.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.Ea != null) {
            return this.Ea.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.Ea != null) {
            return this.Ea.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.Ea != null) {
            return this.Ea.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.Ea != null) {
            return this.Ea.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.Ea != null) {
            this.Ea.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.Ea != null) {
            return this.Ea.setState(iArr);
        }
        return super.setState(iArr);
    }
}
