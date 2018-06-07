package com.fossil;

import android.graphics.RectF;
import java.util.Calendar;
import java.util.Locale;

public class cio {
    private long ced;
    private int cee;
    private RectF cef;
    private int ceg;
    private String ceh;
    private String cei;
    private int mValue;

    public cio(int i, long j, int i2) {
        setValue(i);
        aA(j);
        js(i2);
    }

    public int getValue() {
        return this.mValue;
    }

    public void setValue(int i) {
        this.mValue = i;
    }

    public long YD() {
        return this.ced;
    }

    public Calendar YE() {
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.setTimeInMillis(this.ced);
        return instance;
    }

    public void aA(long j) {
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.setTimeInMillis(j);
        instance.set(7, 1);
        this.ced = instance.getTimeInMillis();
    }

    public void js(int i) {
        this.cee = i;
    }

    public int getWeekNumber() {
        return this.cee;
    }

    public void m6512c(RectF rectF) {
        this.cef = rectF;
    }

    public RectF YF() {
        return this.cef;
    }

    public void jt(int i) {
        this.ceg = i;
    }

    public int YG() {
        return this.ceg;
    }

    public void fL(String str) {
        this.ceh = str;
    }

    public String YH() {
        return this.ceh;
    }

    public void fM(String str) {
        this.cei = str;
    }

    public String YI() {
        return this.cei;
    }
}
