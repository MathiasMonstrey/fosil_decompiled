package com.misfit.chart.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.fossil.cij;
import com.fossil.cis;

public class CHCubicChart extends CubicChart {
    public CHCubicChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void mo4954a(Canvas canvas, int i) {
        if (this.bYH && ((this.bYn == -1 || this.bYE) && this.bXY.size() > this.lastIndex && this.lastIndex != -1)) {
            this.bYn = (int) m15509i((double) ((cij) this.bXY.get(this.lastIndex)).Yx());
            this.bYo = this.bYw;
        } else if (this.bYn == -1) {
            this.bYn = getWidth();
            this.bYo = getWidth();
        }
        if (this.bYm < getWidth() && !this.bYD) {
            canvas.drawRect((float) (this.bYm - i), 0.0f, (float) getWidth(), (float) getHeight(), this.bYi);
        }
        if ((this.bYn < getWidth() && !this.bYD) || this.bYH) {
            canvas.drawRect(((float) (this.bYn - i)) - (this.bYl.getStrokeWidth() / 2.0f), 0.0f, (float) getWidth(), (float) getHeight(), this.bYk);
        }
    }

    protected void mo4939f(Canvas canvas) {
        float f = (float) (this.bXF / 3);
        this.bXd.setColor(this.bXS);
        this.bXd.setTextSize(this.bXK);
        float a = cis.a(this.bXd, this.bYr) / 2.0f;
        canvas.drawText(this.bYr, cis.at(20.0f), (f / 2.0f) + a, this.bXd);
        canvas.drawText(this.bYs, cis.at(20.0f), ((3.0f * f) / 2.0f) + a, this.bXd);
        canvas.drawText(this.bYt, cis.at(20.0f), ((f * 5.0f) / 2.0f) + a, this.bXd);
    }
}
