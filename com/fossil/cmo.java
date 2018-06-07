package com.fossil;

import android.util.Pair;

public class cmo {
    public static float au(float f) {
        return f / 100.0f;
    }

    public static Pair<Integer, Integer> av(float f) {
        int round = (int) Math.round(((double) f) / 2.54d);
        return new Pair(Integer.valueOf(round / 12), Integer.valueOf(round % 12));
    }

    public static float aw(float f) {
        return 2.54f * f;
    }

    public static float ax(float f) {
        return 6.21371E-4f * f;
    }

    public static float ay(float f) {
        return 0.001f * f;
    }

    public static float m7102B(float f, float f2) {
        return aw((12.0f * f) + f2);
    }

    public static float az(float f) {
        return 0.001f * f;
    }

    public static float aA(float f) {
        return 0.00220462f * f;
    }

    public static float aB(float f) {
        return 453.592f * f;
    }

    public static float aC(float f) {
        return 1000.0f * f;
    }
}
