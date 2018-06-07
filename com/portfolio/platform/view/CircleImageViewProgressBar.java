package com.portfolio.platform.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.fossil.cjz.C2125a;

public class CircleImageViewProgressBar extends AppCompatImageView {
    private static final Config azC = Config.ARGB_8888;
    private static final ScaleType dgR = ScaleType.CENTER_CROP;
    private static float dgS = 0.805f;
    private ValueAnimator De;
    private final Paint ER;
    private ColorFilter Ee;
    private int Eo;
    private int cpw;
    private final RectF dgT;
    private final RectF dgU;
    private final RectF dgV;
    private final Matrix dgW;
    private final Paint dgX;
    private final Paint dgY;
    private final Paint dgZ;
    float dha;
    private int dhb;
    private int dhc;
    private BitmapShader dhd;
    private int dhe;
    private int dhf;
    private float dhg;
    private float dhh;
    private float dhi;
    private boolean dhj;
    private boolean dhk;
    private boolean dhl;
    private boolean dhn;
    private boolean dho;
    private boolean dhp;
    private Bitmap mBitmap;
    private int zb;

    public float getInnrCircleDiammeter() {
        return this.dhg;
    }

    public void setInnrCircleDiammeter(float f) {
        this.dhg = f;
    }

    public CircleImageViewProgressBar(Context context) {
        super(context);
        this.dgT = new RectF();
        this.dgU = new RectF();
        this.dgV = new RectF();
        this.dgW = new Matrix();
        this.dgX = new Paint(1);
        this.dgY = new Paint(1);
        this.dgZ = new Paint(1);
        this.ER = new Paint(1);
        this.dha = 0.0f;
        this.cpw = -16777216;
        this.zb = 0;
        this.dhb = 10;
        this.Eo = 0;
        this.dhc = -16776961;
        this.dhi = 0.0f;
        this.dhp = true;
        init();
    }

    public CircleImageViewProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageViewProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgT = new RectF();
        this.dgU = new RectF();
        this.dgV = new RectF();
        this.dgW = new Matrix();
        this.dgX = new Paint(1);
        this.dgY = new Paint(1);
        this.dgZ = new Paint(1);
        this.ER = new Paint(1);
        this.dha = 0.0f;
        this.cpw = -16777216;
        this.zb = 0;
        this.dhb = 10;
        this.Eo = 0;
        this.dhc = -16776961;
        this.dhi = 0.0f;
        this.dhp = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2125a.CircleImageViewProgressBar, i, 0);
        this.dhb = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.zb = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.cpw = obtainStyledAttributes.getColor(2, -16777216);
        this.dhl = obtainStyledAttributes.getBoolean(3, false);
        this.dhn = obtainStyledAttributes.getBoolean(4, false);
        this.Eo = obtainStyledAttributes.getColor(5, 0);
        this.dhg = obtainStyledAttributes.getFloat(7, dgS);
        this.dhc = obtainStyledAttributes.getColor(6, -16776961);
        this.dha = obtainStyledAttributes.getFloat(8, 0.0f);
        obtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        this.De = ValueAnimator.ofFloat(new float[]{0.0f, this.dhi});
        this.De.setDuration(800);
        this.De.addUpdateListener(new 1(this));
        super.setScaleType(dgR);
        this.dhj = true;
        if (this.dhk) {
            setup();
            this.dhk = false;
        }
    }

    public ScaleType getScaleType() {
        return dgR;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != dgR) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.dho) {
            super.onDraw(canvas);
        } else if (this.mBitmap != null) {
            canvas.save();
            canvas.rotate(this.dha - 90.0f, this.dgT.centerX(), this.dgT.centerY());
            if (this.zb > 0 && this.zb < 10) {
                this.dgY.setColor(this.cpw);
                canvas.drawArc(this.dgU, 0.0f, 360.0f, false, this.dgY);
            }
            this.dgY.setColor(this.cpw);
            this.dgZ.setColor(this.dhc);
            float f = 360.0f * (this.dhi / 100.0f);
            RectF rectF = this.dgV;
            if (this.dhn) {
                f = -f;
            }
            canvas.drawArc(rectF, 0.0f, f, false, this.dgZ);
            canvas.restore();
            canvas.drawCircle(this.dgT.centerX(), this.dgT.centerY(), this.dhh, this.dgX);
            if (this.Eo != 0) {
                canvas.drawCircle(this.dgT.centerX(), this.dgT.centerY(), this.dhh, this.ER);
            }
        }
    }

    public void setProgressValue(float f) {
        if (this.dhp) {
            if (this.De.isRunning()) {
                this.De.cancel();
            }
            this.De.setFloatValues(new float[]{this.dhi, f});
            this.De.start();
            return;
        }
        this.dhi = f;
        invalidate();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        setup();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        setup();
    }

    public void setProgressAnimationState(boolean z) {
        this.dhp = z;
    }

    public void setProgressAnimatorInterpolator(TimeInterpolator timeInterpolator) {
        this.De.setInterpolator(timeInterpolator);
    }

    public int getBorderColor() {
        return this.cpw;
    }

    public void setBorderColor(int i) {
        if (i != this.cpw) {
            this.cpw = i;
            this.dgY.setColor(this.cpw);
            invalidate();
        }
    }

    public void setBorderProgressColor(int i) {
        if (i != this.dhc) {
            this.dhc = i;
            this.dgZ.setColor(i);
            invalidate();
        }
    }

    @Deprecated
    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    @Deprecated
    public int getFillColor() {
        return this.Eo;
    }

    @Deprecated
    public void setFillColor(int i) {
        if (i != this.Eo) {
            this.Eo = i;
            this.ER.setColor(i);
            invalidate();
        }
    }

    @Deprecated
    public void setFillColorResource(int i) {
        setFillColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.zb;
    }

    public void setBorderWidth(int i) {
        if (i != this.zb) {
            this.zb = i;
            setup();
        }
    }

    public int getProgressBorderWidth() {
        return this.dhb;
    }

    public void setProgressBorderWidth(int i) {
        if (i != this.dhb) {
            this.dhb = i;
            setup();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.dhl) {
            this.dhl = z;
            setup();
        }
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.dho != z) {
            this.dho = z;
            ava();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        ava();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ava();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        ava();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        ava();
    }

    public ColorFilter getColorFilter() {
        return this.Ee;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.Ee) {
            this.Ee = colorFilter;
            auZ();
            invalidate();
        }
    }

    private void auZ() {
        if (this.dgX != null) {
            this.dgX.setColorFilter(this.Ee);
        }
    }

    private Bitmap m12726A(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap;
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, azC);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), azC);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void ava() {
        if (this.dho) {
            this.mBitmap = null;
        } else {
            this.mBitmap = m12726A(getDrawable());
        }
        setup();
    }

    private void setup() {
        if (!this.dhj) {
            this.dhk = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.mBitmap == null) {
                invalidate();
                return;
            }
            this.dhd = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.dgX.setAntiAlias(true);
            this.dgX.setShader(this.dhd);
            this.dgY.setStyle(Style.STROKE);
            this.dgY.setAntiAlias(true);
            this.dgY.setColor(this.cpw);
            this.dgY.setStrokeWidth((float) this.zb);
            this.dgY.setStrokeCap(Cap.ROUND);
            this.dgZ.setStyle(Style.STROKE);
            this.dgZ.setAntiAlias(true);
            this.dgZ.setColor(this.dhc);
            this.dgZ.setStrokeWidth((float) this.dhb);
            this.dgZ.setStrokeCap(Cap.ROUND);
            this.ER.setStyle(Style.FILL);
            this.ER.setAntiAlias(true);
            this.ER.setColor(this.Eo);
            this.dhf = this.mBitmap.getHeight();
            this.dhe = this.mBitmap.getWidth();
            this.dgU.set(avb());
            this.dgV.set(avc());
            this.dgT.set(this.dgV);
            if (!this.dhl && this.dhb > 0) {
                this.dgT.inset((float) (this.dhb / 2), (float) (this.dhb / 2));
            }
            this.dhh = Math.min(this.dgT.height() / 2.0f, this.dgT.width() / 2.0f);
            if (this.dhg > 1.0f) {
                this.dhg = 1.0f;
            }
            this.dhh *= this.dhg;
            auZ();
            avd();
            invalidate();
        }
    }

    private RectF avb() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = (((float) (width - min)) / 2.0f) + ((float) getPaddingLeft());
        float paddingTop = (((float) (height - min)) / 2.0f) + ((float) getPaddingTop());
        return new RectF(((((float) getProgressBorderWidth()) * 1.5f) + paddingLeft) + ((float) getBorderWidth()), ((((float) getProgressBorderWidth()) * 1.5f) + paddingTop) + ((float) getBorderWidth()), ((paddingLeft + ((float) min)) - (((float) getProgressBorderWidth()) * 1.5f)) - ((float) getBorderWidth()), ((paddingTop + ((float) min)) - (((float) getProgressBorderWidth()) * 1.5f)) - ((float) getBorderWidth()));
    }

    private RectF avc() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = (((float) (width - min)) / 2.0f) + ((float) getPaddingLeft());
        float paddingTop = (((float) (height - min)) / 2.0f) + ((float) getPaddingTop());
        return new RectF((((float) getProgressBorderWidth()) * 1.5f) + paddingLeft, (((float) getProgressBorderWidth()) * 1.5f) + paddingTop, (paddingLeft + ((float) min)) - (((float) getProgressBorderWidth()) * 1.5f), (paddingTop + ((float) min)) - (((float) getProgressBorderWidth()) * 1.5f));
    }

    private void avd() {
        float height;
        float width;
        float f = 0.0f;
        this.dgW.set(null);
        if (((float) this.dhe) * this.dgT.height() > this.dgT.width() * ((float) this.dhf)) {
            height = this.dgT.height() / ((float) this.dhf);
            width = (this.dgT.width() - (((float) this.dhe) * height)) * 0.5f;
        } else {
            height = this.dgT.width() / ((float) this.dhe);
            width = 0.0f;
            f = (this.dgT.height() - (((float) this.dhf) * height)) * 0.5f;
        }
        this.dgW.setScale(height, height);
        this.dgW.postTranslate(((float) ((int) (width + 0.5f))) + this.dgT.left, ((float) ((int) (f + 0.5f))) + this.dgT.top);
        this.dhd.setLocalMatrix(this.dgW);
    }
}
