package com.fossil;

import android.content.Context;
import android.graphics.Canvas;

public class chw extends cif {
    float cbK;
    float cbL;

    public chw(Context context, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, int i8, float f, float f2) {
        super(context, i, i2, i3, i4, i5, i6, z, i7, i8);
        this.cbL = f;
        this.cbK = f2;
        this.cct = 0;
    }

    private void jq(int i) {
        if (this.cbL > 0.0f) {
            this.ccz = (((float) i) * this.cbL) / 100.0f;
        }
        if (this.cbK > 0.0f) {
            this.ccy = (((float) i) * this.cbK) / 100.0f;
        }
    }

    public void mo1737z(Canvas canvas) {
        int min = Math.min(getWidth(), getHeight());
        jq(min);
        this.ccu = (360.0f * this.ccz) / ((float) (((double) ((((float) min) - (this.ccy * 2.0f)) + this.ccz)) * 3.141592653589793d));
        super.mo1737z(canvas);
    }
}
