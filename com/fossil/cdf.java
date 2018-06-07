package com.fossil;

public final class cdf {
    public static int iv(int i) {
        return (int) (461845907 * ((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)));
    }

    public static int cm(Object obj) {
        return iv(obj == null ? 0 : obj.hashCode());
    }

    static int m6007b(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (((double) highestOneBit) * d))) {
            return highestOneBit;
        }
        highestOneBit <<= 1;
        if (highestOneBit > 0) {
            return highestOneBit;
        }
        return 1073741824;
    }
}
