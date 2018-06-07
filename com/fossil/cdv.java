package com.fossil;

import com.facebook.internal.NativeProtocol;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

public final class cdv {
    static final byte[] bOg = new byte[]{(byte) 9, (byte) 9, (byte) 9, (byte) 8, (byte) 8, (byte) 8, (byte) 7, (byte) 7, (byte) 7, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 5, (byte) 5, (byte) 4, (byte) 4, (byte) 4, (byte) 3, (byte) 3, (byte) 3, (byte) 3, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    static final int[] bOh = new int[]{1, 10, 100, 1000, FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL, 100000, 1000000, 10000000, 100000000, 1000000000};
    static final int[] bOi = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    private static final int[] bOj = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    static int[] bOk = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    static /* synthetic */ class C20101 {
        static final /* synthetic */ int[] bOl = new int[RoundingMode.values().length];

        static {
            try {
                bOl[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                bOl[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bOl[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                bOl[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                bOl[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                bOl[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                bOl[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                bOl[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public static boolean iP(int i) {
        int i2 = 1;
        int i3 = i > 0 ? 1 : 0;
        if (((i - 1) & i) != 0) {
            i2 = 0;
        }
        return i2 & i3;
    }

    static int bS(int i, int i2) {
        return (((i - i2) ^ -1) ^ -1) >>> 31;
    }

    public static int m6034a(int i, RoundingMode roundingMode) {
        cdw.m6035w("x", i);
        switch (C20101.bOl[roundingMode.ordinal()]) {
            case 1:
                cdw.bC(iP(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + bS(-1257966797 >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static int bT(int i, int i2) {
        return Ints.aw(((long) i) + ((long) i2));
    }
}
