package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.fossil.cho.e;
import com.fossil.cht;
import com.fossil.chu;
import com.fossil.chv;
import com.fossil.chw;
import com.fossil.chx;
import com.fossil.chy;
import com.fossil.chz;
import com.fossil.cia;
import com.fossil.cib;
import com.fossil.cic;
import com.fossil.cid;
import com.fossil.cie;
import com.fossil.cif;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public class ProcessCircle extends ViewGroup {
    private cib caS;
    private chv caT;
    private int caU = 0;

    public cib getCircle() {
        return this.caS;
    }

    public void setOnDrawListener(cht com_fossil_cht) {
        if (this.caS != null) {
            this.caS.setOnDrawListener(com_fossil_cht);
        }
    }

    private void m15569j(Context context, AttributeSet attributeSet) {
        int i = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            int color = obtainStyledAttributes.getColor(e.ProcessCircle_doneColor, -7829368);
            int color2 = obtainStyledAttributes.getColor(e.ProcessCircle_startColor, -7829368);
            int color3 = obtainStyledAttributes.getColor(e.ProcessCircle_normalColor, -65536);
            int color4 = obtainStyledAttributes.getColor(e.ProcessCircle_numPoints, 1);
            boolean z = obtainStyledAttributes.getBoolean(e.ProcessCircle_roundedPaint, false);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_doneStrokeWidth, 10);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_normalStrokeWidth, -1);
            if (dimensionPixelSize2 == -1) {
                dimensionPixelSize2 = dimensionPixelSize;
            }
            i = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_marginBetweenDoneLineAndNormalLine, 0);
            this.caT = new chv(context);
            this.caS = new cie(context, color3, color2, color, dimensionPixelSize2, dimensionPixelSize, z, i, color4);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m15570k(Context context, AttributeSet attributeSet) {
        int i = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            int color = obtainStyledAttributes.getColor(e.ProcessCircle_doneColor, -7829368);
            int color2 = obtainStyledAttributes.getColor(e.ProcessCircle_normalColor, -3355444);
            int color3 = obtainStyledAttributes.getColor(e.ProcessCircle_celebrateColor, -65536);
            int i2 = obtainStyledAttributes.getInt(e.ProcessCircle_numPoints, 3);
            boolean z = obtainStyledAttributes.getBoolean(e.ProcessCircle_needInitial, true);
            if (i2 >= 3) {
                i = i2;
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_normalPointRadius, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_donePointRadius, 10);
            if (dimensionPixelSize2 < dimensionPixelSize) {
                dimensionPixelSize2 = dimensionPixelSize;
            }
            obtainStyledAttributes.recycle();
            this.caT = new chv(context);
            this.caS = new cid(context, color2, color, color3, i, dimensionPixelSize, dimensionPixelSize2, z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    private void m15571l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(e.ProcessCircle_backgroundInsideCircle);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(e.ProcessCircle_donePointDrawable);
            Drawable drawable3 = obtainStyledAttributes.getDrawable(e.ProcessCircle_normalPointDrawable);
            int i = obtainStyledAttributes.getInt(e.ProcessCircle_numPoints, 3);
            int color = obtainStyledAttributes.getColor(e.ProcessCircle_normalColor, -7829368);
            int color2 = obtainStyledAttributes.getColor(e.ProcessCircle_doneColor, -3355444);
            int color3 = obtainStyledAttributes.getColor(e.ProcessCircle_celebrateColor, -65536);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_normalStrokeWidth, 10);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_doneStrokeWidth, 10);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_normalPointDrawableWidth, 0);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_donePointDrawableWidth, 0);
            boolean z = obtainStyledAttributes.getBoolean(e.ProcessCircle_needInitial, true);
            this.caT = new chv(context);
            this.caS = new cic(context, drawable, drawable2, drawable3, dimensionPixelSize4, dimensionPixelSize3, i, color, color2, color3, dimensionPixelSize, dimensionPixelSize2, z);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m15572m(Context context, AttributeSet attributeSet) {
        float f = Float.NaN;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            int color = obtainStyledAttributes.getColor(e.ProcessCircle_doneColor, -7829368);
            int color2 = obtainStyledAttributes.getColor(e.ProcessCircle_startColor, -7829368);
            int color3 = obtainStyledAttributes.getColor(e.ProcessCircle_normalColor, -3355444);
            int color4 = obtainStyledAttributes.getColor(e.ProcessCircle_celebrateColor, -3355444);
            boolean z = obtainStyledAttributes.getBoolean(e.ProcessCircle_roundedPaint, false);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_doneStrokeWidth, 10);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_normalStrokeWidth, -1);
            int i = obtainStyledAttributes.getInt(e.ProcessCircle_parts, 1);
            if (dimensionPixelSize2 == -1) {
                dimensionPixelSize2 = dimensionPixelSize;
            }
            f = obtainStyledAttributes.getFloat(e.ProcessCircle_normalStrokePercent, -1.0f);
            float f2 = obtainStyledAttributes.getFloat(e.ProcessCircle_doneStrokePercent, -1.0f);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_marginBetweenDoneLineAndNormalLine, 0);
            this.caT = new chv(context);
            this.caS = new chw(context, color3, color2, color, color4, dimensionPixelSize2, dimensionPixelSize, z, dimensionPixelSize3, i, f, f2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m15573n(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            int color = obtainStyledAttributes.getColor(e.ProcessCircle_doneColor, -7829368);
            int color2 = obtainStyledAttributes.getColor(e.ProcessCircle_normalColor, -3355444);
            int color3 = obtainStyledAttributes.getColor(e.ProcessCircle_celebrateColor, -65536);
            boolean z = obtainStyledAttributes.getBoolean(e.ProcessCircle_needInitial, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_inRadiusOffset, 50);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_outRadiusOffset, 40);
            if (dimensionPixelSize < dimensionPixelSize2) {
                dimensionPixelSize2 = dimensionPixelSize;
            }
            obtainStyledAttributes.recycle();
            this.caT = new chv(context);
            this.caS = new chy(context, color2, color, color3, dimensionPixelSize, dimensionPixelSize2, z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    private void m15574o(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            int color = obtainStyledAttributes.getColor(e.ProcessCircle_doneColor, -7829368);
            int color2 = obtainStyledAttributes.getColor(e.ProcessCircle_normalColor, -3355444);
            int color3 = obtainStyledAttributes.getColor(e.ProcessCircle_celebrateColor, -65536);
            int color4 = obtainStyledAttributes.getColor(e.ProcessCircle_startGradientColor, 0);
            int color5 = obtainStyledAttributes.getColor(e.ProcessCircle_centerGradientColor, 0);
            int color6 = obtainStyledAttributes.getColor(e.ProcessCircle_endGradientColor, 0);
            float f = obtainStyledAttributes.getFloat(e.ProcessCircle_startGradientPosition, 0.0f);
            float f2 = obtainStyledAttributes.getFloat(e.ProcessCircle_centerGradientPosition, 0.5f);
            float f3 = obtainStyledAttributes.getFloat(e.ProcessCircle_endGradientPosition, 1.0f);
            boolean z = obtainStyledAttributes.getBoolean(e.ProcessCircle_needInitial, true);
            boolean z2 = obtainStyledAttributes.getBoolean(e.ProcessCircle_roundedPaint, true);
            boolean z3 = obtainStyledAttributes.getBoolean(e.ProcessCircle_enableShadow, true);
            boolean z4 = obtainStyledAttributes.getBoolean(e.ProcessCircle_enableSweepGradient, false);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_normalStrokeWidth, 10);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_doneStrokeWidth, 10);
            this.caT = new chv(context);
            this.caS = new chz(context, color2, color, color3, dimensionPixelSize, dimensionPixelSize2, z, color4, color5, color6, f, f2, f3, z2, z3, z4);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m15575p(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            int color = obtainStyledAttributes.getColor(e.ProcessCircle_doneColor, -7829368);
            int color2 = obtainStyledAttributes.getColor(e.ProcessCircle_normalColor, -3355444);
            int color3 = obtainStyledAttributes.getColor(e.ProcessCircle_celebrateColor, -65536);
            int color4 = obtainStyledAttributes.getColor(e.ProcessCircle_startGradientColor, 0);
            int color5 = obtainStyledAttributes.getColor(e.ProcessCircle_endGradientColor, 0);
            int color6 = obtainStyledAttributes.getColor(e.ProcessCircle_centerGradientColor, 0);
            int color7 = obtainStyledAttributes.getColor(e.ProcessCircle_splittedColor, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(e.ProcessCircle_backgroundInsideCircle);
            boolean z = obtainStyledAttributes.getBoolean(e.ProcessCircle_needInitial, true);
            boolean z2 = obtainStyledAttributes.getBoolean(e.ProcessCircle_roundedPaint, true);
            boolean z3 = obtainStyledAttributes.getBoolean(e.ProcessCircle_enableShadow, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_normalStrokeWidth, 10);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_doneStrokeWidth, 10);
            this.caS = new chx(context, color2, color, color3, dimensionPixelSize, dimensionPixelSize2, z, color4, color6, color5, color7, z2, z3, drawable);
            this.caT = new chu(context, color2, color, color3, dimensionPixelSize, dimensionPixelSize2, z, color4, color6, color5, color7, z2, z3, drawable);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m15576q(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            int color = obtainStyledAttributes.getColor(e.ProcessCircle_doneColor, -7829368);
            int color2 = obtainStyledAttributes.getColor(e.ProcessCircle_normalColor, -3355444);
            int color3 = obtainStyledAttributes.getColor(e.ProcessCircle_celebrateColor, -3355444);
            boolean z = obtainStyledAttributes.getBoolean(e.ProcessCircle_needInitial, true);
            boolean z2 = obtainStyledAttributes.getBoolean(e.ProcessCircle_enableDotGoal, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_normalStrokeWidth, 10);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_doneStrokeWidth, 10);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_dotGoalSize, 10);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_marginBetweenDoneLineAndNormalLine, 10);
            this.caT = new chv(context);
            this.caS = new cia(context, color2, color, color3, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize4, dimensionPixelSize3, z, z2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m15577r(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            int color = obtainStyledAttributes.getColor(e.ProcessCircle_doneColor, -7829368);
            int color2 = obtainStyledAttributes.getColor(e.ProcessCircle_startColor, -7829368);
            int color3 = obtainStyledAttributes.getColor(e.ProcessCircle_normalColor, -3355444);
            int color4 = obtainStyledAttributes.getColor(e.ProcessCircle_celebrateColor, -3355444);
            boolean z = obtainStyledAttributes.getBoolean(e.ProcessCircle_roundedPaint, false);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_doneStrokeWidth, 10);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_normalStrokeWidth, -1);
            int i = obtainStyledAttributes.getInt(e.ProcessCircle_parts, 1);
            if (dimensionPixelSize2 == -1) {
                dimensionPixelSize2 = dimensionPixelSize;
            }
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(e.ProcessCircle_marginBetweenDoneLineAndNormalLine, 0);
            this.caT = new chv(context);
            this.caS = new cif(context, color3, color2, color, color4, dimensionPixelSize2, dimensionPixelSize, z, dimensionPixelSize3, i);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onMeasure(int i, int i2) {
        int min = Math.min(jn(i), jn(i2));
        setMeasuredDimension(min, min);
    }

    private int jn(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 0) {
            return MFNetworkReturnCode.RESPONSE_OK;
        }
        return size;
    }

    public ProcessCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProcessCircle);
        try {
            this.caU = obtainStyledAttributes.getInt(e.ProcessCircle_circleStyle, 0);
            switch (this.caU) {
                case 0:
                    m15571l(context, attributeSet);
                    break;
                case 1:
                    m15573n(context, attributeSet);
                    break;
                case 2:
                    m15574o(context, attributeSet);
                    break;
                case 3:
                    m15577r(context, attributeSet);
                    break;
                case 4:
                    m15570k(context, attributeSet);
                    break;
                case 5:
                    m15576q(context, attributeSet);
                    break;
                case 6:
                    m15575p(context, attributeSet);
                    break;
                case 7:
                    m15572m(context, attributeSet);
                    break;
                case 8:
                    m15569j(context, attributeSet);
                    break;
            }
            addView(this.caT);
            addView(this.caS);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void setPercent(int i) {
        this.caS.setPercent(i);
    }

    public void setPercentDecimal(float f) {
        this.caS.setPercentDecimal(f);
    }

    public void setMaxGoal(int i) {
        this.caS.setParts(i);
        this.caT.setParts(i);
    }

    public int getCurrentPercent() {
        return this.caS.getCurrentPercent();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.caT.layout(0, 0, i, i2);
        this.caS.layout(0, 0, i, i2);
    }

    public void invalidate() {
        XU();
    }

    public void XU() {
        this.caS.invalidate();
        this.caT.invalidate();
    }

    public void setNormalColor(int i) {
        this.caS.setNormalColor(i);
        this.caT.setNormalColor(i);
    }

    public void setDoneColor(int i) {
        this.caS.setDoneColor(i);
    }

    public void setCelebrateColor(int i) {
        this.caS.setCelebrateColor(i);
    }
}
