package com.fossil;

public final class err {
    public static int pp(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
