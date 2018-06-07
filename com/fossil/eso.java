package com.fossil;

import java.util.NoSuchElementException;

public final class eso extends esc {
    private final int dSR;
    private final int dST;
    private int dSU;
    private boolean hasNext;

    public eso(int i, int i2, int i3) {
        boolean z = true;
        this.dSR = i3;
        this.dST = i2;
        if (this.dSR > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.hasNext = z;
        if (!this.hasNext) {
            i = this.dST;
        }
        this.dSU = i;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public int nextInt() {
        int i = this.dSU;
        if (i != this.dST) {
            this.dSU += this.dSR;
        } else if (this.hasNext) {
            this.hasNext = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
