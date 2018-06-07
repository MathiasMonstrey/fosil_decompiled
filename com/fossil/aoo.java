package com.fossil;

public final class aoo {
    private static aoo aZS;

    private aoo() {
    }

    public static synchronized aoo It() {
        aoo com_fossil_aoo;
        synchronized (aoo.class) {
            if (aZS == null) {
                aZS = new aoo();
            }
            com_fossil_aoo = aZS;
        }
        return com_fossil_aoo;
    }
}
