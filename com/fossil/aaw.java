package com.fossil;

public abstract class aaw<Z> extends aaq<Z> {
    private final int height;
    private final int width;

    public aaw() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public aaw(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final void mo764a(aax com_fossil_aax) {
        if (abl.bg(this.width, this.height)) {
            com_fossil_aax.be(this.width, this.height);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor" + " or call override()");
    }
}
