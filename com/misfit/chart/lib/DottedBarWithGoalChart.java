package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.fossil.cho.e;
import com.fossil.chr;
import com.fossil.cig;
import com.fossil.cih;
import com.fossil.cii;
import com.fossil.cis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DottedBarWithGoalChart extends BaseBarChart {
    private static int bWY = 10;
    private List<cii> bWZ;
    boolean bXz;
    private Paint bYV;
    protected chr bYW;
    public boolean bYY;
    private List<cii> bYZ;
    private boolean bYq;
    private int bZa;
    int bZe;
    private C4656a bZf;
    private float bZg;
    private float bZh;
    private Drawable bZi;
    private Drawable bZj;
    private Drawable bZk;
    private float bZl;
    private float bZm;
    private float bZn;
    private List<Float> bZo;

    public interface C4656a {
    }

    public int getDottedAmountVertical() {
        return this.bZa;
    }

    public void setDottedAmountVertical(int i) {
        this.bZa = i;
    }

    public float getDottedWithGoalDrawableSize() {
        return this.bZn;
    }

    public void setDottedWithGoalDrawableSize(float f) {
        this.bZn = f;
    }

    public DottedBarWithGoalChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYW = null;
        this.bYY = false;
        this.bYZ = new ArrayList();
        this.bYq = true;
        this.bZg = 0.0f;
        this.bZh = 0.0f;
        this.bZo = new ArrayList();
        this.bXz = false;
        this.bZe = 0;
        this.bZo = new ArrayList();
        this.bXm = (float) bWY;
        XS();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.DottedBarWithGoalChart, 0, 0);
        try {
            this.bZa = obtainStyledAttributes.getInteger(e.DottedBarWithGoalChart_egDottedWithGoalAmountVertical, 0);
            this.bZl = obtainStyledAttributes.getDimension(e.DottedBarWithGoalChart_egDottedWithGoalMarginBottomBaseLine, 0.0f);
            this.bZm = obtainStyledAttributes.getDimension(e.DottedBarWithGoalChart_egDottedWithGoalPaddingLeftRightBaseLine, 0.0f);
            this.bZi = obtainStyledAttributes.getDrawable(e.DottedBarWithGoalChart_egDottedWithGoalTopDrawable);
            this.bZj = obtainStyledAttributes.getDrawable(e.DottedBarWithGoalChart_egDottedWithGoalCenterDrawable);
            this.bZk = obtainStyledAttributes.getDrawable(e.DottedBarWithGoalChart_egDottedWithGoalBottomDrawable);
            this.bZn = obtainStyledAttributes.getDimension(e.DottedBarWithGoalChart_egDottedWithGoalDrawableSize, 0.0f);
            this.bZg = obtainStyledAttributes.getDimension(e.DottedBarWithGoalChart_egNormalDotPadding, 0.0f);
            this.bZh = obtainStyledAttributes.getDimension(e.DottedBarWithGoalChart_egDottedWithGoalDrawableOffsetX, 0.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private Bitmap m15530a(Drawable drawable, int i, int i2) {
        Bitmap createBitmap;
        Exception e;
        try {
            createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            } catch (Exception e2) {
                e = e2;
                Log.d(this.TAG, e.toString());
                return createBitmap;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            createBitmap = null;
            e = exception;
            Log.d(this.TAG, e.toString());
            return createBitmap;
        }
        return createBitmap;
    }

    public chr getOnBarClickedListener() {
        return this.bYW;
    }

    public void setOnBarClickedListener(chr com_fossil_chr) {
        this.bYW = com_fossil_chr;
    }

    public void m15532a(cii com_fossil_cii, boolean z) {
        this.bYq = z;
        this.bWZ.add(com_fossil_cii);
        XT();
    }

    public void m15531a(cii com_fossil_cii) {
        m15532a(com_fossil_cii, true);
    }

    public void setBarBottomColor(int i) {
        this.bXi = i;
    }

    public void setBarCenterColor(int i) {
        this.bXk = i;
    }

    public void setBarTopColor(int i) {
        this.bXj = i;
    }

    public List<cii> getData() {
        return this.bWZ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setAnimationListener(C4656a c4656a) {
        this.bZf = c4656a;
    }

    protected void XS() {
        super.XS();
        this.bWZ = new ArrayList();
        this.bYV = new Paint(1);
        this.bYV.setTextSize(this.bXl);
        this.bYV.setTextAlign(Align.CENTER);
        this.bYV.setColor(-1);
        if (this.Ci != null) {
            this.bYV.setTypeface(this.Ci);
        }
    }

    protected void XT() {
        aj((float) this.bWZ.size());
        super.XT();
    }

    protected void mo4949z(float f, float f2) {
        int i = 0;
        for (cii com_fossil_cii : this.bWZ) {
            float f3 = 0.0f;
            for (cig Ym : com_fossil_cii.Yt()) {
                f3 = Ym.Ym() + f3;
            }
            if (((double) f3) < 0.1d) {
                f3 = 0.1f;
            }
            int i2 = (int) (((float) i) + (f2 / 2.0f));
            float f4 = 0.0f;
            for (cig Ym2 : com_fossil_cii.Yt()) {
                float round = (((float) Math.round((Ym2.Ym() * ((float) this.bZa)) / this.bXm)) * this.bXm) / ((float) this.bZa);
                if (round == 0.0f) {
                    round = Ym2.Ym();
                }
                round = (((round * ((float) this.bXF)) * f3) / (this.bXm * f3)) + f4;
                float f5 = round - f4;
                Rect rect = new Rect();
                String valueOf = String.valueOf(Ym2.Ym());
                this.bYV.getTextBounds(valueOf, 0, valueOf.length(), rect);
                if (((float) rect.height()) * 1.5f < f5 && ((float) rect.width()) * 1.1f < f) {
                    Ym2.bK(true);
                    Ym2.l(rect);
                }
                Ym2.a(new RectF((float) i2, f4, ((float) i2) + f, round));
                f4 = round;
            }
            com_fossil_cii.b(new RectF((float) i2, 0.0f, ((float) i2) + f, this.bXJ));
            i = (int) ((((float) i2) + f) + (f2 / 2.0f));
        }
        cis.a(this.bWZ, 0.0f, (float) this.bXb.width(), this.bXd);
    }

    protected void mo4943u(int i, int i2, int i3, int i4) {
        if (!this.bXz) {
            this.bXF = (int) (((float) this.bXF) - this.bZl);
            this.bXz = true;
        }
    }

    protected void mo4940g(Canvas canvas) {
        this.bXc.setStrokeWidth(this.bXp);
        this.bXc.setColor(this.bXw);
        Canvas canvas2 = canvas;
        canvas2.drawLine(this.bZm, this.bZl + ((float) this.bXF), ((float) canvas.getWidth()) - this.bZm, this.bZl + ((float) this.bXF), this.bXc);
    }

    protected void mo4945d(Canvas canvas) {
        if (this.Ci != null) {
            this.bYV.setTypeface(this.Ci);
        }
        this.bZo.clear();
        float f = ((float) this.bXF) / ((float) this.bZa);
        for (cii com_fossil_cii : this.bWZ) {
            int i;
            int ceil;
            HashMap hashMap = new HashMap();
            int i2 = 0;
            float f2 = 0.0f;
            for (i = 0; i < com_fossil_cii.Yt().size(); i++) {
                cig com_fossil_cig = (cig) com_fossil_cii.Yt().get(i);
                if (com_fossil_cig.Yn() != null) {
                    f2 += com_fossil_cig.Ym();
                    ceil = (int) Math.ceil((double) ((((float) this.bZa) * f2) / this.bXm));
                    int i3 = i2;
                    while (i3 < ceil) {
                        hashMap.put(Integer.valueOf(i2), Integer.valueOf(com_fossil_cig.getColor()));
                        i3++;
                        i2++;
                    }
                }
            }
            if (com_fossil_cii.Yv() > 0.0f) {
                i = Math.round((com_fossil_cii.Yv() * ((float) this.bZa)) / this.bXm);
            } else {
                i = Math.round((this.bXn * ((float) this.bZa)) / this.bXm);
            }
            f2 = 0.0f;
            for (cig com_fossil_cig2 : com_fossil_cii.Yt()) {
                f2 = com_fossil_cig2.Ym() + f2;
            }
            float f3 = Float.MAX_VALUE;
            int size = hashMap.size();
            for (ceil = 0; ceil < size; ceil++) {
                com_fossil_cig2 = (cig) com_fossil_cii.Yt().get(0);
                float f4 = (com_fossil_cig2.Yn().right - com_fossil_cig2.Yn().left) / 2.0f;
                float f5 = com_fossil_cig2.Yn().left + f4;
                float round = ((float) this.bXF) - (((float) Math.round((f / 2.0f) - f4)) + ((((float) ceil) * f) + f4));
                if (round < f3) {
                    f3 = round;
                }
                this.bXc.setColor(((Integer) hashMap.get(Integer.valueOf(ceil))).intValue());
                if (this.bYq) {
                    if (ceil + 1 < i || f2 < com_fossil_cii.Yv()) {
                        canvas.drawCircle(f5, round, f4 - this.bZg, this.bXc);
                    } else {
                        Drawable drawable;
                        Drawable drawable2 = this.bZk;
                        if (((Integer) hashMap.get(Integer.valueOf(ceil))).intValue() == this.bXk) {
                            drawable = this.bZj;
                        } else if (((Integer) hashMap.get(Integer.valueOf(ceil))).intValue() == this.bXj) {
                            drawable = this.bZi;
                        } else {
                            drawable = drawable2;
                        }
                        if (drawable != null) {
                            if (this.bZn == 0.0f) {
                                this.bZn = 2.0f * f4;
                            }
                            Bitmap createScaledBitmap;
                            if (drawable instanceof BitmapDrawable) {
                                createScaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), (int) this.bZn, (int) this.bZn, false);
                                canvas.drawBitmap(createScaledBitmap, (f5 - ((float) (createScaledBitmap.getWidth() / 2))) + this.bZh, round - ((float) (createScaledBitmap.getHeight() / 2)), null);
                            } else if (drawable instanceof ColorDrawable) {
                                this.bXc.setColor(((ColorDrawable) drawable).getColor());
                                canvas.drawCircle(this.bZh + f5, round, f4, this.bXc);
                            } else {
                                createScaledBitmap = m15530a(drawable, (int) this.bZn, (int) this.bZn);
                                canvas.drawBitmap(createScaledBitmap, (f5 - ((float) (createScaledBitmap.getWidth() / 2))) + this.bZh, round - ((float) (createScaledBitmap.getHeight() / 2)), null);
                            }
                        }
                    }
                }
            }
            if (com_fossil_cii.Yt().size() <= 0 || f3 >= Float.MAX_VALUE) {
                this.bZo.add(Float.valueOf(0.0f));
            } else {
                this.bZo.add(Float.valueOf(f3 - (((((cig) com_fossil_cii.Yt().get(0)).Yn().right - ((cig) com_fossil_cii.Yt().get(0)).Yn().left) / 2.0f) * 2.0f)));
            }
        }
    }

    protected void mo4939f(Canvas canvas) {
        super.mo4939f(canvas);
        if (this.bXH) {
            for (cih com_fossil_cih : getLegendData()) {
                if (com_fossil_cih.Yp()) {
                    RectF Yr = com_fossil_cih.Yr();
                    this.bXd.setColor(this.bXL);
                    this.bXd.setTextSize(this.bXK);
                    canvas.drawText(com_fossil_cih.Yo(), (float) com_fossil_cih.Yq(), Yr.bottom - this.bXR, this.bXd);
                }
            }
        }
    }

    protected List<? extends cih> getLegendData() {
        return this.bWZ;
    }

    protected List<RectF> getBarBounds() {
        List arrayList = new ArrayList();
        for (cii com_fossil_cii : this.bWZ) {
            RectF rectF = new RectF();
            rectF.left = com_fossil_cii.Yu().left;
            rectF.right = com_fossil_cii.Yu().right;
            rectF.top = ((float) this.bXF) - com_fossil_cii.Yu().bottom;
            rectF.bottom = (float) this.bXF;
            arrayList.add(rectF);
        }
        return arrayList;
    }

    protected boolean mo4942r(MotionEvent motionEvent) {
        if (this.bYY) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.bYW != null) {
                    float x = this.bXa.left + motionEvent.getX();
                    float y = motionEvent.getY() + this.bXa.top;
                    this.bXy = 0;
                    for (RectF rectF : getBarBounds()) {
                        if (cis.a(rectF, x, true)) {
                            if (this.bZo.size() > this.bXy) {
                                rectF.top = ((Float) this.bZo.get(this.bXy)).floatValue();
                                this.bYW.a(this.bXy, rectF.centerX(), rectF.top);
                            }
                            return true;
                        }
                        this.bXy++;
                    }
                    this.bXy = 0;
                    break;
                }
                onTouchEvent(motionEvent);
                break;
            case 1:
            case 3:
                this.bYW.jh(this.bXy);
                return true;
        }
        return false;
    }
}
