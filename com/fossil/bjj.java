package com.fossil;

import com.fossil.wearables.fsl.location.DeviceLocation;
import com.misfit.frameworks.common.constants.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class bjj {
    public static final Set<String> bvU = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"altitude", Constants.DURATION, "food_item", "meal_type", "repetitions", "resistance", "resistance_type", "debug_session", "google.android.fitness.SessionV2"})));
    private static final bjj bvX = new bjj();
    private final Map<String, Map<String, bjl>> bvV;
    private final Map<String, bjl> bvW;

    private bjj() {
        Map hashMap = new HashMap();
        hashMap.put(DeviceLocation.COLUMN_LATITUDE, new bjl(-90.0d, 90.0d));
        hashMap.put(DeviceLocation.COLUMN_LONGITUDE, new bjl(-180.0d, 180.0d));
        hashMap.put("accuracy", new bjl(0.0d, 10000.0d));
        hashMap.put("bpm", new bjl(0.0d, 1000.0d));
        hashMap.put("altitude", new bjl(-100000.0d, 100000.0d));
        hashMap.put("percentage", new bjl(0.0d, 100.0d));
        hashMap.put("confidence", new bjl(0.0d, 100.0d));
        hashMap.put(Constants.DURATION, new bjl(0.0d, 9.223372036854776E18d));
        hashMap.put(Constants.PROFILE_KEY_UNITS_HEIGHT, new bjl(0.0d, 3.0d));
        hashMap.put(Constants.PROFILE_KEY_UNITS_WEIGHT, new bjl(0.0d, 1000.0d));
        hashMap.put("speed", new bjl(0.0d, 11000.0d));
        this.bvW = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put("com.google.step_count.delta", m5228q("steps", new bjl(0.0d, 1.0E-8d)));
        hashMap.put("com.google.calories.consumed", m5228q("calories", new bjl(0.0d, 1.0E-6d)));
        hashMap.put("com.google.calories.expended", m5228q("calories", new bjl(0.0d, 5.555555555555555E-10d)));
        hashMap.put("com.google.distance.delta", m5228q("distance", new bjl(0.0d, 1.0E-7d)));
        this.bvV = Collections.unmodifiableMap(hashMap);
    }

    public static bjj OH() {
        return bvX;
    }

    private static <K, V> Map<K, V> m5228q(K k, V v) {
        Map<K, V> hashMap = new HashMap();
        hashMap.put(k, v);
        return hashMap;
    }

    final bjl m5229Q(String str, String str2) {
        Map map = (Map) this.bvV.get(str);
        return map != null ? (bjl) map.get(str2) : null;
    }

    final bjl dM(String str) {
        return (bjl) this.bvW.get(str);
    }
}
