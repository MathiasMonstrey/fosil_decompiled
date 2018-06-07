package com.google.android.gms.measurement;

import com.fossil.bsk;
import com.google.firebase.analytics.FirebaseAnalytics.C4262c;
import com.j256.ormlite.field.FieldType;

public final class AppMeasurement$e extends C4262c {
    public static final String[] bJJ = new String[]{"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install"};
    public static final String[] bJK = new String[]{"_ln", "_fot", "_fvt", "_ldl", FieldType.FOREIGN_ID_FIELD_SUFFIX, "_fi"};

    public static String eY(String str) {
        return bsk.a(str, bJJ, bJK);
    }
}
