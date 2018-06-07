package com.fossil;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;

public class xw extends yf {
    private final Rect aDZ;
    private boolean aEa;
    private boolean aEb;
    private C4217a aEc;
    private int height;
    private int width;

    static class C4217a extends ConstantState {
        private static final Paint aEd = new Paint(6);
        int aEe;
        Paint aEf;
        final Bitmap bitmap;

        public C4217a(Bitmap bitmap) {
            this.aEf = aEd;
            this.bitmap = bitmap;
        }

        C4217a(C4217a c4217a) {
            this(c4217a.bitmap);
            this.aEe = c4217a.aEe;
        }

        void setColorFilter(ColorFilter colorFilter) {
            vK();
            this.aEf.setColorFilter(colorFilter);
        }

        void setAlpha(int i) {
            vK();
            this.aEf.setAlpha(i);
        }

        void vK() {
            if (aEd == this.aEf) {
                this.aEf = new Paint(6);
            }
        }

        public Drawable newDrawable() {
            return new xw(null, this);
        }

        public Drawable newDrawable(Resources resources) {
            return new xw(resources, this);
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }

    public xw(Resources resources, Bitmap bitmap) {
        this(resources, new C4217a(bitmap));
    }

    xw(Resources resources, C4217a c4217a) {
        this.aDZ = new Rect();
        if (c4217a == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        int i;
        this.aEc = c4217a;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            if (i == 0) {
                i = 160;
            }
            c4217a.aEe = i;
        } else {
            i = c4217a.aEe;
        }
        this.width = c4217a.bitmap.getScaledWidth(i);
        this.height = c4217a.bitmap.getScaledHeight(i);
    }

    public int getIntrinsicWidth() {
        return this.width;
    }

    public int getIntrinsicHeight() {
        return this.height;
    }

    public boolean vJ() {
        return false;
    }

    public void eI(int i) {
    }

    public void start() {
    }

    public void stop() {
    }

    public boolean isRunning() {
        return false;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.aEa = true;
    }

    public ConstantState getConstantState() {
        return this.aEc;
    }

    public void draw(Canvas canvas) {
        if (this.aEa) {
            Gravity.apply(119, this.width, this.height, getBounds(), this.aDZ);
            this.aEa = false;
        }
        canvas.drawBitmap(this.aEc.bitmap, null, this.aDZ, this.aEc.aEf);
    }

    public void setAlpha(int i) {
        if (this.aEc.aEf.getAlpha() != i) {
            this.aEc.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.aEc.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        Bitmap bitmap = this.aEc.bitmap;
        return (bitmap == null || bitmap.hasAlpha() || this.aEc.aEf.getAlpha() < 255) ? -3 : -1;
    }

    public Drawable mutate() {
        if (!this.aEb && super.mutate() == this) {
            this.aEc = new C4217a(this.aEc);
            this.aEb = true;
        }
        return this;
    }

    public Bitmap getBitmap() {
        return this.aEc.bitmap;
    }
}
