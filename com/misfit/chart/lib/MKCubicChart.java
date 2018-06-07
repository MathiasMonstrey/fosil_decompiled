package com.misfit.chart.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import com.fossil.cis;

public class MKCubicChart extends CubicChart {
    private float bYQ = -1.0f;
    private Paint bYR;
    private Paint bYS;

    public void setDashLinePaint(Paint paint) {
        this.bYS = paint;
    }

    public void setArrowViewPaint(Paint paint) {
        this.bYR = paint;
    }

    public void setArrowViewPositionX(float f) {
        this.bYQ = f;
    }

    public MKCubicChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void XV() {
        super.XV();
        this.bYR = new Paint();
        this.bYR.setDither(true);
        this.bYR.setColor(-16777216);
        this.bYR.setStyle(Style.STROKE);
        this.bYR.setStrokeWidth(cis.at(1.0f));
        this.bYS = new Paint();
        this.bYS.setAntiAlias(true);
        this.bYS.setStyle(Style.STROKE);
        this.bYS.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        this.bYS.setAlpha(102);
        this.bYS.setColor(Color.rgb(109, 110, 102));
    }

    protected void mo4956l(Canvas canvas) {
        mo4951j(canvas);
    }

    protected void mo4940g(Canvas canvas) {
        super.mo4940g(canvas);
        if (this.bYQ > -1.0f) {
            canvas.drawLine(this.bYQ, 0.0f, this.bYQ, (float) getHeight(), this.bYR);
        }
    }
}
