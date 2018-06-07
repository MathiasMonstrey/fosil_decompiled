package com.fossil;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class cii extends cih implements Cloneable {
    private List<cig> cdR;
    private float cdS;

    public cii() {
        super("Unset");
        this.cdR = new ArrayList();
    }

    public cii(String str) {
        super(str);
        this.cdR = new ArrayList();
    }

    public cii(List<cig> list) {
        super("Unset");
        this.cdR = list;
    }

    public List<cig> Yt() {
        return this.cdR;
    }

    public void m6509a(cig com_fossil_cig) {
        this.cdR.add(com_fossil_cig);
    }

    public RectF Yu() {
        RectF rectF = new RectF();
        if (!(this.cdR.isEmpty() || ((cig) this.cdR.get(this.cdR.size() - 1)).Yn() == null)) {
            rectF.set(((cig) this.cdR.get(0)).Yn().left, ((cig) this.cdR.get(0)).Yn().top, ((cig) this.cdR.get(this.cdR.size() - 1)).Yn().right, ((cig) this.cdR.get(this.cdR.size() - 1)).Yn().bottom);
        }
        return rectF;
    }

    public float Yv() {
        return this.cdS;
    }

    public void aq(float f) {
        this.cdS = f;
    }
}
