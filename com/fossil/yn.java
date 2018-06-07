package com.fossil;

public class yn extends ye<yl> {
    public yn(yl ylVar) {
        super(ylVar);
    }

    public int getSize() {
        return abl.p(((yl) this.aEw).vU()) + ((yl) this.aEw).getData().length;
    }

    public void recycle() {
        ((yl) this.aEw).stop();
        ((yl) this.aEw).recycle();
    }
}
