package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.os.Build.VERSION;

public class chz extends cib {
    private final Paint aEf;
    private final Paint cbA;
    private RectF cbC;
    private int cbD = 1;
    private int cbE = 10;
    private boolean cbH = true;
    private boolean cbI = false;
    private float cbO;
    private int cbP = 0;
    private int cbV;
    private int cbW;
    private int cbX;
    float cbY;
    float cbZ;
    private final Paint cbz;
    float cca;
    private boolean ccb = false;
    private boolean ccc = false;

    public int getCenterGradientColor() {
        return this.cbW;
    }

    public void setCenterGradientColor(int i) {
        this.cbW = i;
    }

    public int getEndGradientColor() {
        return this.cbX;
    }

    public void setEndGradientColor(int i) {
        this.cbX = i;
    }

    public int getStartGradientColor() {
        return this.cbV;
    }

    public void setStartGradientColor(int i) {
        this.cbV = i;
    }

    public chz(Context context, int i, int i2, int i3, int i4, int i5, boolean z, int i6, int i7, int i8, float f, float f2, float f3, boolean z2, boolean z3, boolean z4) {
        super(context);
        this.cbJ = i;
        this.cbY = f;
        this.cca = f2;
        this.cbZ = f3;
        this.ccc = z4;
        this.cci = i2;
        this.ccj = i3;
        this.cbD = i4;
        this.cbE = i5;
        this.cbH = z;
        this.cbV = i6;
        this.cbX = i8;
        this.cbI = z3;
        this.cbW = i7;
        if (this.cbD > this.cbE) {
            this.cbE = this.cbD;
        }
        this.aEf = new Paint();
        this.aEf.setAntiAlias(true);
        this.aEf.setStyle(Style.STROKE);
        this.aEf.setStrokeWidth((float) i5);
        if (z2) {
            this.aEf.setDither(true);
            this.aEf.setStrokeJoin(Join.ROUND);
            this.aEf.setStrokeCap(Cap.ROUND);
        }
        this.cbz = new Paint(this.aEf);
        this.cbA = new Paint(this.aEf);
        this.cbA.setColor(-16777216);
        this.cbA.setAlpha(100);
        this.cbA.setShadowLayer(20.0f, 0.0f, 10.0f, -16777216);
        boolean z5 = (i6 == 0 && i8 == 0 && i7 == 0) ? false : true;
        this.ccb = z5;
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    void m6489a(Canvas canvas) {
        canvas.drawArc(this.cbC, -90.0f, this.cbO, false, this.cbA);
    }

    void m6490w(Canvas canvas) {
        this.cbz.setColor(this.cbJ);
        this.cbz.setStrokeWidth((float) this.cbD);
        canvas.drawArc(this.cbC, -90.0f, 360.0f, false, this.cbz);
    }

    void m6488A(Canvas canvas) {
        this.aEf.setStrokeWidth((float) this.cbE);
        this.aEf.setColor(this.cci);
        canvas.drawArc(this.cbC, -90.0f, this.cbO, false, this.aEf);
    }

    public void mo1737z(Canvas canvas) {
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        float min = ((Math.min((float) getWidth(), (float) getHeight()) - ((float) this.cbE)) - ((float) this.cbE)) - 20.0f;
        this.cbC = new RectF(width - (min / 2.0f), height - (min / 2.0f), width + (min / 2.0f), (min / 2.0f) + height);
        this.cbO = (360.0f * Math.min(100.0f, (float) this.cbP)) / 100.0f;
        if (this.ccb) {
            Yj();
        }
        m6490w(canvas);
        if (this.cbI) {
            m6489a(canvas);
        }
        m6488A(canvas);
    }

    private void Yj() {
        if (this.ccc) {
            Shader sweepGradient = new SweepGradient((float) (getWidth() / 2), (float) (getHeight() / 2), new int[]{this.cbV, this.cbW, this.cbX}, new float[]{this.cbY, this.cca, this.cbZ});
            Matrix matrix = new Matrix();
            matrix.preRotate(270.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
            sweepGradient.setLocalMatrix(matrix);
            this.aEf.setShader(sweepGradient);
            return;
        }
        float f = (float) this.cbP;
        if (f > 100.0f) {
            f = 100.0f;
        }
        float f2 = (f * 360.0f) / 100.0f;
        float f3;
        float f4;
        if (this.cbW != 0) {
            f3 = 0.0f;
            f4 = 0.0f;
            sweepGradient = new LinearGradient(0.0f, f3, f4, (float) getHeight(), new int[]{this.cbV, this.cbW, this.cbX}, new float[]{this.cbY, this.cca, this.cbZ}, TileMode.REPEAT);
        } else {
            f3 = 0.0f;
            f4 = 0.0f;
            sweepGradient = new LinearGradient(0.0f, f3, f4, (float) getHeight(), new int[]{this.cbV, this.cbX}, new float[]{this.cbY, this.cbZ}, TileMode.REPEAT);
        }
        Matrix matrix2 = new Matrix();
        matrix2.preRotate(f2, (float) (getWidth() / 2), (float) (getHeight() / 2));
        sweepGradient.setLocalMatrix(matrix2);
        this.aEf.setShader(sweepGradient);
    }

    public void setPercent(int i) {
        this.cbP = i;
    }

    public int getCurrentPercent() {
        return this.cbP;
    }

    public float getAngle() {
        return this.cbO;
    }

    public void setAngle(float f) {
        this.cbO = f;
    }
}
