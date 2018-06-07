package com.fossil;

import java.io.IOException;

public final class chk {
    public static final int[] bWo = new int[0];
    public static final long[] bWp = new long[0];
    public static final float[] bWq = new float[0];
    public static final double[] bWr = new double[0];
    public static final boolean[] bWs = new boolean[0];
    public static final byte[][] bWt = new byte[0][];
    public static final byte[] bWu = new byte[0];
    public static final String[] bqJ = new String[0];

    static int jf(int i) {
        return i & 7;
    }

    public static int jg(int i) {
        return i >>> 3;
    }

    static int bo(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean m6420a(chg com_fossil_chg, int i) throws IOException {
        return com_fossil_chg.iZ(i);
    }

    public static final int m6421b(chg com_fossil_chg, int i) throws IOException {
        int i2 = 1;
        int position = com_fossil_chg.getPosition();
        com_fossil_chg.iZ(i);
        while (com_fossil_chg.XF() == i) {
            com_fossil_chg.iZ(i);
            i2++;
        }
        com_fossil_chg.jc(position);
        return i2;
    }
}
