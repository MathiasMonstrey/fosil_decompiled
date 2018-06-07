package com.misfit.ble.parser;

import com.misfit.ble.shine.sync.UserProfile;
import com.misfit.ble.shine.sync.result.MinuteData;
import java.util.List;

public class MetricAlgorithm {
    private static final int[] f1585a = new int[]{80, 140, 186, 255};
    private static final float[] f1586b = new float[]{0.33f, 0.45f, 0.841f, 0.91f};
    private static final float[] f1587c = new float[]{0.002f, 0.0085f, 0.001f};

    public static float calculateCalories(UserProfile userProfile, List<MinuteData> list) {
        long j = 0;
        for (MinuteData point : list) {
            j = point.getPoint() + j;
        }
        return (((float) j) * 0.12f) * (userProfile.getWeightInKg() / 60.0f);
    }

    public static float calculateOneMinuteDistances(UserProfile userProfile, MinuteData minuteData) {
        float f;
        long step = minuteData.getStep();
        if (step <= ((long) f1585a[0])) {
            f = f1586b[0];
        } else if (step > ((long) f1585a[0]) && step <= ((long) f1585a[1])) {
            f = f1586b[0] + (f1587c[0] * ((float) (step - ((long) f1585a[0]))));
        } else if (step > ((long) f1585a[1]) && step <= ((long) f1585a[2])) {
            f = f1586b[1] + (f1587c[1] * ((float) (step - ((long) f1585a[1]))));
        } else if (step <= ((long) f1585a[2]) || step > ((long) f1585a[3])) {
            f = f1586b[3];
        } else {
            f = f1586b[2] + (f1587c[2] * ((float) (step - ((long) f1585a[2]))));
        }
        return (f * userProfile.getHeightInMeter()) * ((float) step);
    }

    public static float calculateDistance(UserProfile userProfile, List<MinuteData> list) {
        float f = 0.0f;
        for (MinuteData calculateOneMinuteDistances : list) {
            f = calculateOneMinuteDistances(userProfile, calculateOneMinuteDistances) + f;
        }
        return f;
    }
}
