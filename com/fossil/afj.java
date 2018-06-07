package com.fossil;

public class afj extends afk {
    protected final aey aMJ;

    public afj(String str) {
        this(aey.ba(str));
    }

    public afj(aey com_fossil_aey) {
        this.aMJ = com_fossil_aey;
    }

    public afk fv(int i) {
        aey fp = this.aMJ.fp(i);
        if (fp == null) {
            return null;
        }
        if (fp.matches()) {
            return afk.aMK;
        }
        return new afj(fp);
    }

    public afk bh(String str) {
        aey bb = this.aMJ.bb(str);
        if (bb == null) {
            return null;
        }
        if (bb.matches()) {
            return afk.aMK;
        }
        return new afj(bb);
    }

    public afk Bg() {
        return this;
    }

    public afk Bh() {
        return this;
    }

    protected boolean Bi() {
        return this.aMJ.matches();
    }

    public String toString() {
        return "[JsonPointerFilter at: " + this.aMJ + "]";
    }
}
