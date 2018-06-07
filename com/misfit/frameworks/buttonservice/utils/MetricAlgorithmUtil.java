package com.misfit.frameworks.buttonservice.utils;

import com.misfit.ble.parser.MetricAlgorithm;
import com.misfit.ble.shine.sync.UserProfile;
import com.misfit.ble.shine.sync.result.MinuteData;
import com.misfit.frameworks.buttonservice.model.WrapperMinuteData;
import java.util.ArrayList;
import java.util.List;

public class MetricAlgorithmUtil {
    public static float calculateCalories(UserProfile userProfile, List<MinuteData> list) {
        return MetricAlgorithm.calculateCalories(userProfile, list);
    }

    public static float calculateDistance(UserProfile userProfile, List<MinuteData> list) {
        return MetricAlgorithm.calculateDistance(userProfile, list);
    }

    public static float calculateCalories(com.misfit.frameworks.buttonservice.model.UserProfile userProfile, List<WrapperMinuteData> list) {
        List arrayList = new ArrayList();
        for (WrapperMinuteData toMinuteData : list) {
            arrayList.add(WrapperMinuteData.toMinuteData(toMinuteData));
        }
        return MetricAlgorithm.calculateCalories(new UserProfile(userProfile.age, userProfile.height, userProfile.weight, userProfile.gender), arrayList);
    }

    public static float calculateDistance(com.misfit.frameworks.buttonservice.model.UserProfile userProfile, List<WrapperMinuteData> list) {
        List arrayList = new ArrayList();
        for (WrapperMinuteData toMinuteData : list) {
            arrayList.add(WrapperMinuteData.toMinuteData(toMinuteData));
        }
        return MetricAlgorithm.calculateDistance(new UserProfile(userProfile.age, userProfile.height, userProfile.weight, userProfile.gender), arrayList);
    }
}
