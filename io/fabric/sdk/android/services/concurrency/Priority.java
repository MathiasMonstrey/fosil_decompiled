package io.fabric.sdk.android.services.concurrency;

import com.fossil.enw;

public enum Priority {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    public static <Y> int compareTo(enw com_fossil_enw, Y y) {
        Priority xS;
        if (y instanceof enw) {
            xS = ((enw) y).xS();
        } else {
            xS = NORMAL;
        }
        return xS.ordinal() - com_fossil_enw.xS().ordinal();
    }
}
