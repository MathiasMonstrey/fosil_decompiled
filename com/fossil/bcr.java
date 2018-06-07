package com.fossil;

import java.io.IOException;

public final class bcr {
    private static int bqA = 11;
    private static int bqB = 12;
    private static int bqC = 16;
    private static int bqD = 26;
    public static final int[] bqE = new int[0];
    public static final long[] bqF = new long[0];
    public static final float[] bqG = new float[0];
    private static double[] bqH = new double[0];
    public static final boolean[] bqI = new boolean[0];
    public static final String[] bqJ = new String[0];
    public static final byte[][] bqK = new byte[0][];
    public static final byte[] bqL = new byte[0];

    public static final int m4872b(bch com_fossil_bch, int i) throws IOException {
        int i2 = 1;
        int position = com_fossil_bch.getPosition();
        com_fossil_bch.hM(i);
        while (com_fossil_bch.MF() == i) {
            com_fossil_bch.hM(i);
            i2++;
        }
        com_fossil_bch.bK(position, i);
        return i2;
    }
}
