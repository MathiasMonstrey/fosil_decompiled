package com.fossil;

import com.flurry.sdk.kw;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class apa extends apo<kw> {
    private static apa bay = null;

    protected apa() {
        super(apa.class.getName(), TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new apm()));
    }

    public static synchronized apa IK() {
        apa com_fossil_apa;
        synchronized (apa.class) {
            if (bay == null) {
                bay = new apa();
            }
            com_fossil_apa = bay;
        }
        return com_fossil_apa;
    }
}
