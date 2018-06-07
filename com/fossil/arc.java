package com.fossil;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class arc {
    private static arc bcO;
    final Map<UncaughtExceptionHandler, Void> aWW = new WeakHashMap();
    final UncaughtExceptionHandler bcP = Thread.getDefaultUncaughtExceptionHandler();

    final class C1855a implements UncaughtExceptionHandler {
        final /* synthetic */ arc bcQ;

        private C1855a(arc com_fossil_arc) {
            this.bcQ = com_fossil_arc;
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            for (UncaughtExceptionHandler uncaughtException : this.bcQ.Ji()) {
                try {
                    uncaughtException.uncaughtException(thread, th);
                } catch (Throwable th2) {
                }
            }
            arc com_fossil_arc = this.bcQ;
            if (com_fossil_arc.bcP != null) {
                try {
                    com_fossil_arc.bcP.uncaughtException(thread, th);
                } catch (Throwable th3) {
                }
            }
        }
    }

    private arc() {
        Thread.setDefaultUncaughtExceptionHandler(new C1855a());
    }

    public static synchronized arc Jh() {
        arc com_fossil_arc;
        synchronized (arc.class) {
            if (bcO == null) {
                bcO = new arc();
            }
            com_fossil_arc = bcO;
        }
        return com_fossil_arc;
    }

    final Set<UncaughtExceptionHandler> Ji() {
        Set<UncaughtExceptionHandler> keySet;
        synchronized (this.aWW) {
            keySet = this.aWW.keySet();
        }
        return keySet;
    }
}
