package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class no {
    private static final c WT;
    private Object WS;

    static {
        if (VERSION.SDK_INT >= 21) {
            WT = new d();
        } else if (VERSION.SDK_INT >= 14) {
            WT = new b();
        } else {
            WT = new a();
        }
    }

    public no(Context context) {
        this.WS = WT.r(context);
    }

    public void setSize(int i, int i2) {
        WT.a(this.WS, i, i2);
    }

    public boolean isFinished() {
        return WT.aN(this.WS);
    }

    public void finish() {
        WT.p(this.WS);
    }

    @Deprecated
    public boolean m12644C(float f) {
        return WT.a(this.WS, f);
    }

    public boolean m12645n(float f, float f2) {
        return WT.a(this.WS, f, f2);
    }

    public boolean kz() {
        return WT.aO(this.WS);
    }

    public boolean bS(int i) {
        return WT.k(this.WS, i);
    }

    public boolean draw(Canvas canvas) {
        return WT.a(this.WS, canvas);
    }
}
