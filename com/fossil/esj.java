package com.fossil;

public final class esj {
    private static final int cu(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final int m11123L(int i, int i2, int i3) {
        return cu(cu(i, i3) - cu(i2, i3), i3);
    }

    public static final int m11124M(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - m11123L(i2, i, i3);
        }
        if (i3 < 0) {
            return m11123L(i, i2, -i3) + i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
