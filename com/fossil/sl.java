package com.fossil;

public class sl {
    private int QC = Integer.MIN_VALUE;
    private int asA = 0;
    private boolean asB = false;
    private int asw = 0;
    private int asx = 0;
    private int asy = Integer.MIN_VALUE;
    private int asz = 0;
    private boolean xh = false;

    public int getLeft() {
        return this.asw;
    }

    public int getRight() {
        return this.asx;
    }

    public int getStart() {
        return this.xh ? this.asx : this.asw;
    }

    public int getEnd() {
        return this.xh ? this.asw : this.asx;
    }

    public void aL(int i, int i2) {
        this.asy = i;
        this.QC = i2;
        this.asB = true;
        if (this.xh) {
            if (i2 != Integer.MIN_VALUE) {
                this.asw = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.asx = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.asw = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.asx = i2;
        }
    }

    public void aM(int i, int i2) {
        this.asB = false;
        if (i != Integer.MIN_VALUE) {
            this.asz = i;
            this.asw = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.asA = i2;
            this.asx = i2;
        }
    }

    public void au(boolean z) {
        if (z != this.xh) {
            this.xh = z;
            if (!this.asB) {
                this.asw = this.asz;
                this.asx = this.asA;
            } else if (z) {
                this.asw = this.QC != Integer.MIN_VALUE ? this.QC : this.asz;
                this.asx = this.asy != Integer.MIN_VALUE ? this.asy : this.asA;
            } else {
                this.asw = this.asy != Integer.MIN_VALUE ? this.asy : this.asz;
                this.asx = this.QC != Integer.MIN_VALUE ? this.QC : this.asA;
            }
        }
    }
}
