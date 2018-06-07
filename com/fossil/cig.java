package com.fossil;

import android.graphics.Rect;
import android.graphics.RectF;

public class cig extends cih implements Comparable {
    private int LA;
    private float cdH;
    private RectF cdI;
    private boolean cdJ = false;
    private Rect cdK = new Rect();

    public cig(float f, int i) {
        super("" + f);
        this.cdH = cis.m6529d(f, 1);
        this.LA = i;
    }

    public cig(float f) {
        super("" + f);
        this.cdH = cis.m6529d(f, 1);
        this.LA = 0;
    }

    public float Ym() {
        return this.cdH;
    }

    public int getColor() {
        return this.LA;
    }

    public void setColor(int i) {
        this.LA = i;
    }

    public RectF Yn() {
        return this.cdI;
    }

    public void m6507a(RectF rectF) {
        this.cdI = rectF;
    }

    public void bK(boolean z) {
        this.cdJ = z;
    }

    public void m6508l(Rect rect) {
        this.cdK = rect;
    }

    public int compareTo(Object obj) {
        cig com_fossil_cig = (cig) obj;
        if (this.cdH > com_fossil_cig.Ym()) {
            return 1;
        }
        if (this.cdH == com_fossil_cig.Ym()) {
            return 0;
        }
        return -1;
    }
}
