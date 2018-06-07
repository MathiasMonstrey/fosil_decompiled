package com.fossil;

import java.util.Comparator;

public class apm implements Comparator<Runnable> {
    private static final String aWB = apm.class.getSimpleName();

    public /* synthetic */ int compare(Object obj, Object obj2) {
        Runnable runnable = (Runnable) obj2;
        int f = m4171f((Runnable) obj);
        int f2 = m4171f(runnable);
        if (f < f2) {
            return -1;
        }
        if (f > f2) {
            return 1;
        }
        return 0;
    }

    private static int m4171f(Runnable runnable) {
        if (runnable == null) {
            return Integer.MAX_VALUE;
        }
        if (runnable instanceof apn) {
            int i;
            aqy com_fossil_aqy = (aqy) ((apn) runnable).IX();
            if (com_fossil_aqy != null) {
                i = com_fossil_aqy.bcN;
            } else {
                i = Integer.MAX_VALUE;
            }
            return i;
        } else if (runnable instanceof aqy) {
            return ((aqy) runnable).bcN;
        } else {
            app.m4180g(6, aWB, "Unknown runnable class: " + runnable.getClass().getName());
            return Integer.MAX_VALUE;
        }
    }
}
