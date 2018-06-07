package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.cjz.C2125a;
import com.fossil.cmb;
import com.fossil.cmg;
import com.fossil.cmn;
import com.fossil.tt;
import com.fossil.tz;
import com.fossil.wearables.fossil.R;
import com.fossil.xq;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class FossilCircleImageView extends AppCompatImageView {
    private static final String TAG = FossilCircleImageView.class.getSimpleName();
    private static final ScaleType dgR = ScaleType.CENTER_CROP;
    private final Paint ER;
    private ColorFilter Ee;
    private int Eo;
    private int cpw;
    private final RectF dgT;
    private final RectF dgU;
    private final Paint dgY;
    private float dhh;
    private boolean dhj;
    private boolean dhk;
    private boolean dhl;
    private boolean dho;
    private String diH;
    private float diI;
    private boolean diJ;
    private boolean diK;
    private int zb;

    public FossilCircleImageView(Context context) {
        super(context);
        this.dgT = new RectF();
        this.dgU = new RectF();
        this.dgY = new Paint();
        this.ER = new Paint();
        this.cpw = -16777216;
        this.zb = 0;
        this.Eo = 0;
        this.diK = false;
        init();
    }

    public FossilCircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FossilCircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgT = new RectF();
        this.dgU = new RectF();
        this.dgY = new Paint();
        this.ER = new Paint();
        this.cpw = -16777216;
        this.zb = 0;
        this.Eo = 0;
        this.diK = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2125a.FossilCircleImageView, i, 0);
        this.zb = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.cpw = obtainStyledAttributes.getColor(1, -16777216);
        this.dhl = obtainStyledAttributes.getBoolean(2, false);
        this.Eo = obtainStyledAttributes.getColor(3, 0);
        this.diH = obtainStyledAttributes.getString(4);
        if (this.diH == null) {
            this.diH = "";
        }
        obtainStyledAttributes.recycle();
        Log.d(TAG, "FossilCircleImageView constructor");
        init();
    }

    private void init() {
        super.setScaleType(dgR);
        this.dhj = true;
        if (this.dhk) {
            setup();
            this.dhk = false;
        }
        Log.d(TAG, "init()");
    }

    public void m12735b(Bitmap bitmap, Bitmap bitmap2) {
        new a(new WeakReference(this)).execute(new Bitmap[]{bitmap, bitmap2});
    }

    public void m12729a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        new a(new WeakReference(this)).execute(new Bitmap[]{bitmap, bitmap2, bitmap3});
    }

    public void m12730a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4) {
        new a(new WeakReference(this)).execute(new Bitmap[]{bitmap, bitmap2, bitmap3, bitmap4});
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
        super.onDraw(canvas);
        if (!this.dho) {
            if (this.Eo != 0) {
                canvas.drawCircle(this.dgT.centerX(), this.dgT.centerY(), this.dhh, this.ER);
            }
            if (this.zb > 0) {
                canvas.drawCircle(this.dgU.centerX(), this.dgU.centerY(), this.diI, this.dgY);
            }
            if (this.diJ) {
                this.dgY.setAntiAlias(true);
                this.dgY.setFilterBitmap(true);
                this.dgY.setDither(true);
                this.dgY.setColor(Color.parseColor("#EEEEEE"));
                canvas.drawCircle(this.dgU.centerX(), this.dgU.centerY(), this.diI, this.dgY);
            }
        }
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

    public void setBorderOverlay(boolean z) {
        if (z != this.dhl) {
            this.dhl = z;
            setup();
        }
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.dho != z) {
            this.dho = z;
        }
    }

    public void m12733a(String str, tz tzVar) {
        MFLogger.m12670d(TAG, "setImageUrl without defaultName url=" + str);
        tzVar.ah(str).b(new xq[]{new cmn(getContext())}).c(DiskCacheStrategy.RESULT).c(this);
    }

    public void m12734a(String str, String str2, tz tzVar) {
        MFLogger.m12670d(TAG, "setImageUrl url=" + str);
        tzVar.a(new cmg()).bc(new cmb(str, str2)).b(new xq[]{new cmn(getContext())}).c(DiskCacheStrategy.RESULT).c(this);
    }

    public void m12731a(Bitmap bitmap, tz tzVar) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 50, byteArrayOutputStream);
        tt c = tzVar.H(byteArrayOutputStream.toByteArray()).b(new xq[]{new cmn(getContext())}).c(DiskCacheStrategy.RESULT);
        if (this.diK) {
            c = c.ev(R.anim.scale_animation);
        } else {
            c = c.ty();
        }
        c.c(this);
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.diJ = false;
    }

    public void m12728a(int i, tz tzVar) {
        tzVar.a(Integer.valueOf(i)).b(new xq[]{new cmn(getContext())}).c(DiskCacheStrategy.RESULT).c(this);
        Log.d(TAG, "setImageResource resId = " + i);
    }

    public void m12732a(Uri uri, tz tzVar) {
        MFLogger.m12670d(TAG, "setImageURI uri=" + uri);
        tzVar.g(uri).b(new xq[]{new cmn(getContext())}).c(DiskCacheStrategy.NONE).aA(true).c(this);
        Log.d(TAG, "setImageURI uri = " + uri);
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
    }

    public String getHandNumber() {
        return this.diH;
    }

    public void setHandNumber(String str) {
        this.diH = str;
    }

    private void setup() {
        if (!this.dhj) {
            this.dhk = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            this.dgY.setStyle(Style.STROKE);
            this.dgY.setAntiAlias(true);
            this.dgY.setColor(this.cpw);
            this.dgY.setStrokeWidth((float) this.zb);
            this.ER.setStyle(Style.FILL);
            this.ER.setAntiAlias(true);
            this.ER.setColor(this.Eo);
            this.ER.setFilterBitmap(true);
            this.ER.setDither(true);
            this.dgU.set(avb());
            this.diI = Math.min((this.dgU.height() - ((float) this.zb)) / 2.0f, (this.dgU.width() - ((float) this.zb)) / 2.0f);
            this.dgT.set(this.dgU);
            if (!this.dhl && this.zb > 0) {
                this.dgT.inset(((float) this.zb) - 1.0f, ((float) this.zb) - 1.0f);
            }
            this.dhh = Math.min(this.dgT.height() / 2.0f, this.dgT.width() / 2.0f);
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
        return new RectF(paddingLeft, paddingTop, ((float) min) + paddingLeft, ((float) min) + paddingTop);
    }

    private void avd() {
    }

    public void setDefault(boolean z) {
        this.diJ = z;
    }
}
