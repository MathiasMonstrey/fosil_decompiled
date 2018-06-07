package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class cib extends View {
    protected cht caW;
    protected int cbJ = -65536;
    protected int cci = -65536;
    protected int ccj = -12303292;

    public cib(Context context) {
        super(context);
    }

    public void setOnDrawListener(cht com_fossil_cht) {
        this.caW = com_fossil_cht;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mo1737z(canvas);
        if (this.caW != null) {
            this.caW.XR();
        }
    }

    public void setNormalColor(int i) {
        this.cbJ = i;
    }

    public int getNormalColor() {
        return this.cbJ;
    }

    public void setDoneColor(int i) {
        this.cci = i;
    }

    public int getDoneColor() {
        return this.cci;
    }

    public void setCelebrateColor(int i) {
        this.ccj = i;
    }

    public int getCelebrateColor() {
        return this.ccj;
    }

    public void mo1737z(Canvas canvas) {
    }

    public void setPercent(int i) {
    }

    public void setPercentDecimal(float f) {
        setPercent(Math.round(f));
    }

    public void setParts(int i) {
    }

    public int getCurrentPercent() {
        return 0;
    }
}
