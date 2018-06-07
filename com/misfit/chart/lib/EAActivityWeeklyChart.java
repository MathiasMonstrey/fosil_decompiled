package com.misfit.chart.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.fossil.cir;

public class EAActivityWeeklyChart extends EAWeeklyChart {
    private static final String TAG = EAActivityWeeklyChart.class.getSimpleName();

    public EAActivityWeeklyChart(Context context) {
        super(context);
    }

    public EAActivityWeeklyChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EAActivityWeeklyChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void Yb() {
        int i;
        super.Yb();
        for (i = 0; i < 7; i++) {
            this.caG.add(jk(i));
        }
        for (i = 0; i < this.caw; i++) {
            this.caF.add(cir.b((double) ((i + 1) * 2000), 0));
        }
        if (this.bZB) {
            Ye();
        }
    }

    protected void Yc() {
        this.cav = Math.max(this.cat, this.cau);
        this.cav = (int) (Math.ceil(((double) this.cav) / 1000.0d) * 1000.0d);
        int i = this.cav / this.caw;
        for (int i2 = 0; i2 < this.caw; i2++) {
            if (this.bZA) {
                Log.d(TAG, "calculateData: " + cir.b((double) ((i2 + 1) * i), 0));
            }
            this.caF.set(i2, cir.b((double) ((i2 + 1) * i), 0));
        }
    }

    protected String ak(float f) {
        Log.d(TAG, "getStringFromValue() called with: goal = [" + f + "]");
        return cir.b((double) f, 0);
    }
}
