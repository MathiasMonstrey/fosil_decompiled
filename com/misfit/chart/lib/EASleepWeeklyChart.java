package com.misfit.chart.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.fossil.cir;

public class EASleepWeeklyChart extends EAWeeklyChart {
    private static final String TAG = EASleepWeeklyChart.class.getSimpleName();

    public EASleepWeeklyChart(Context context) {
        super(context);
    }

    public EASleepWeeklyChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EASleepWeeklyChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void Yb() {
        int i = 0;
        int i2 = this.bZD;
        this.bZD = this.bZF;
        this.bZF = i2;
        i2 = this.bZE;
        this.bZE = this.bZG;
        this.bZG = i2;
        super.Yb();
        for (i2 = 0; i2 < 7; i2++) {
            this.caG.add(jk(i2));
        }
        while (i < this.caw) {
            this.caF.add(cir.jv((i + 1) * 120));
            i++;
        }
    }

    protected void Yc() {
        this.cav = Math.max(this.cat, this.cau);
        this.cav = (int) (Math.ceil(((double) this.cav) / 120.0d) * 120.0d);
        int i = this.cav / this.caw;
        for (int i2 = 0; i2 < this.caw; i2++) {
            if (this.bZA) {
                Log.d(TAG, "calculateData: " + cir.jv((i2 + 1) * i));
            }
            this.caF.set(i2, cir.jv(((i2 + 1) * i) * 60));
        }
    }

    protected String ak(float f) {
        return cir.jv(((int) f) * 60);
    }
}
