package com.fossil;

import android.os.Bundle;
import android.os.Parcelable;

public final class byj {
    private byj() {
    }

    public static void m5799a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(byj.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(byj.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }

    public static void m5800b(Bundle bundle, Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            Parcelable e = m5801e(bundle, "MapOptions");
            if (e != null) {
                m5799a(bundle2, "MapOptions", e);
            }
            e = m5801e(bundle, "StreetViewPanoramaOptions");
            if (e != null) {
                m5799a(bundle2, "StreetViewPanoramaOptions", e);
            }
            e = m5801e(bundle, "camera");
            if (e != null) {
                m5799a(bundle2, "camera", e);
            }
            if (bundle.containsKey("position")) {
                bundle2.putString("position", bundle.getString("position"));
            }
            if (bundle.containsKey("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT")) {
                bundle2.putBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", bundle.getBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", false));
            }
        }
    }

    private static <T extends Parcelable> T m5801e(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(byj.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(byj.class.getClassLoader());
        return bundle2.getParcelable(str);
    }
}
