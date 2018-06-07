package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.Gravity;
import com.fossil.ud.C4136a;
import com.fossil.yp.C4226b;

public class yl extends yf implements C4226b {
    private int aAi;
    private boolean aCe;
    private final Rect aDZ;
    private final C4225a aEA;
    private final ud aEB;
    private final yp aEC;
    private boolean aED;
    private boolean aEE;
    private int aEF;
    private boolean aEa;
    private final Paint aEf;
    private boolean isRunning;

    static class C4225a extends ConstantState {
        uf aEG;
        up<Bitmap> aEH;
        int aEI;
        int aEJ;
        Bitmap aEK;
        vl axR;
        C4136a azO;
        Context context;
        byte[] data;

        public C4225a(uf ufVar, byte[] bArr, Context context, up<Bitmap> upVar, int i, int i2, C4136a c4136a, vl vlVar, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.aEG = ufVar;
            this.data = bArr;
            this.axR = vlVar;
            this.aEK = bitmap;
            this.context = context.getApplicationContext();
            this.aEH = upVar;
            this.aEI = i;
            this.aEJ = i2;
            this.azO = c4136a;
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new yl(this);
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }

    public yl(Context context, C4136a c4136a, vl vlVar, up<Bitmap> upVar, int i, int i2, uf ufVar, byte[] bArr, Bitmap bitmap) {
        this(new C4225a(ufVar, bArr, context, upVar, i, i2, c4136a, vlVar, bitmap));
    }

    public yl(yl ylVar, Bitmap bitmap, up<Bitmap> upVar) {
        this(new C4225a(ylVar.aEA.aEG, ylVar.aEA.data, ylVar.aEA.context, upVar, ylVar.aEA.aEI, ylVar.aEA.aEJ, ylVar.aEA.azO, ylVar.aEA.axR, bitmap));
    }

    yl(C4225a c4225a) {
        this.aDZ = new Rect();
        this.aEE = true;
        this.aEF = -1;
        if (c4225a == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.aEA = c4225a;
        this.aEB = new ud(c4225a.azO);
        this.aEf = new Paint();
        this.aEB.m13816a(c4225a.aEG, c4225a.data);
        this.aEC = new yp(c4225a.context, this, this.aEB, c4225a.aEI, c4225a.aEJ);
        this.aEC.m14089a(c4225a.aEH);
    }

    public Bitmap vU() {
        return this.aEA.aEK;
    }

    public up<Bitmap> vV() {
        return this.aEA.aEH;
    }

    public byte[] getData() {
        return this.aEA.data;
    }

    public int getFrameCount() {
        return this.aEB.getFrameCount();
    }

    private void vW() {
        this.aAi = 0;
    }

    public void start() {
        this.aED = true;
        vW();
        if (this.aEE) {
            vX();
        }
    }

    public void stop() {
        this.aED = false;
        vY();
        if (VERSION.SDK_INT < 11) {
            reset();
        }
    }

    private void reset() {
        this.aEC.clear();
        invalidateSelf();
    }

    private void vX() {
        if (this.aEB.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.aEC.start();
            invalidateSelf();
        }
    }

    private void vY() {
        this.isRunning = false;
        this.aEC.stop();
    }

    public boolean setVisible(boolean z, boolean z2) {
        this.aEE = z;
        if (!z) {
            vY();
        } else if (this.aED) {
            vX();
        }
        return super.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.aEA.aEK.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.aEA.aEK.getHeight();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.aEa = true;
    }

    public void draw(Canvas canvas) {
        if (!this.aCe) {
            if (this.aEa) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.aDZ);
                this.aEa = false;
            }
            Bitmap vZ = this.aEC.vZ();
            if (vZ == null) {
                vZ = this.aEA.aEK;
            }
            canvas.drawBitmap(vZ, null, this.aDZ, this.aEf);
        }
    }

    public void setAlpha(int i) {
        this.aEf.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.aEf.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -2;
    }

    @TargetApi(11)
    public void eN(int i) {
        if (VERSION.SDK_INT < 11 || getCallback() != null) {
            invalidateSelf();
            if (i == this.aEB.getFrameCount() - 1) {
                this.aAi++;
            }
            if (this.aEF != -1 && this.aAi >= this.aEF) {
                stop();
                return;
            }
            return;
        }
        stop();
        reset();
    }

    public ConstantState getConstantState() {
        return this.aEA;
    }

    public void recycle() {
        this.aCe = true;
        this.aEA.axR.mo4217j(this.aEA.aEK);
        this.aEC.clear();
        this.aEC.stop();
    }

    public boolean vJ() {
        return true;
    }

    public void eI(int i) {
        int i2 = -1;
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i == 0) {
            int uh = this.aEB.uh();
            if (uh != 0) {
                i2 = uh;
            }
            this.aEF = i2;
        } else {
            this.aEF = i;
        }
    }
}
