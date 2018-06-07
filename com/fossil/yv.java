package com.fossil;

public class yv implements vh<yu> {
    private final yu aFh;

    public /* synthetic */ Object get() {
        return wg();
    }

    public yv(yu yuVar) {
        if (yuVar == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.aFh = yuVar;
    }

    public yu wg() {
        return this.aFh;
    }

    public int getSize() {
        return this.aFh.getSize();
    }

    public void recycle() {
        vh we = this.aFh.we();
        if (we != null) {
            we.recycle();
        }
        we = this.aFh.wf();
        if (we != null) {
            we.recycle();
        }
    }
}
