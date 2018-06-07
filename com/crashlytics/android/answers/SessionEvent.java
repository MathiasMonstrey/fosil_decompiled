package com.crashlytics.android.answers;

import android.app.Activity;
import com.fossil.acb;
import com.misfit.frameworks.common.constants.Constants;
import java.util.Collections;
import java.util.Map;

public final class SessionEvent {
    public final acb aHJ;
    public final Type aHK;
    public final Map<String, String> aHL;
    public final String aHM;
    public final Map<String, Object> aHN;
    private String aHO;
    public final long timestamp;

    public enum Type {
        CREATE,
        START,
        RESUME,
        SAVE_INSTANCE_STATE,
        PAUSE,
        STOP,
        DESTROY,
        ERROR,
        CRASH,
        INSTALL,
        CUSTOM
    }

    public static SessionEvent m2622a(acb com_fossil_acb, Type type, Activity activity) {
        return m2623a(com_fossil_acb, type, Collections.singletonMap(Constants.ACTIVITY, activity.getClass().getName()));
    }

    public static SessionEvent m2621a(acb com_fossil_acb) {
        return m2623a(com_fossil_acb, Type.INSTALL, Collections.emptyMap());
    }

    public static SessionEvent m2625a(acb com_fossil_acb, String str) {
        return m2623a(com_fossil_acb, Type.CRASH, Collections.singletonMap("sessionId", str));
    }

    private static SessionEvent m2623a(acb com_fossil_acb, Type type, Map<String, String> map) {
        return m2624a(com_fossil_acb, type, map, null, Collections.emptyMap());
    }

    private static SessionEvent m2624a(acb com_fossil_acb, Type type, Map<String, String> map, String str, Map<String, Object> map2) {
        return new SessionEvent(com_fossil_acb, System.currentTimeMillis(), type, map, str, map2);
    }

    private SessionEvent(acb com_fossil_acb, long j, Type type, Map<String, String> map, String str, Map<String, Object> map2) {
        this.aHJ = com_fossil_acb;
        this.timestamp = j;
        this.aHK = type;
        this.aHL = map;
        this.aHM = str;
        this.aHN = map2;
    }

    public String toString() {
        if (this.aHO == null) {
            this.aHO = "[" + getClass().getSimpleName() + ": " + "timestamp=" + this.timestamp + ", type=" + this.aHK + ", details=" + this.aHL.toString() + ", customType=" + this.aHM + ", customAttributes=" + this.aHN.toString() + ", metadata=[" + this.aHJ + "]]";
        }
        return this.aHO;
    }
}
