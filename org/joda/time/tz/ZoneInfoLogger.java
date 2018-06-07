package org.joda.time.tz;

public class ZoneInfoLogger {
    static ThreadLocal<Boolean> cVerbose = new 1();

    public static boolean verbose() {
        return ((Boolean) cVerbose.get()).booleanValue();
    }

    public static void set(boolean z) {
        cVerbose.set(Boolean.valueOf(z));
    }
}
