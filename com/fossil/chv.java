package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class chv extends View {
    protected int cbJ = -65536;

    public chv(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mo1731x(canvas);
    }

    public void setNormalColor(int i) {
        this.cbJ = i;
    }

    public int getNormalColor() {
        return this.cbJ;
    }

    public void mo1731x(Canvas canvas) {
    }

    public void setParts(int i) {
    }
}
