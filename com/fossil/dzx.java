package com.fossil;

import java.lang.Thread.UncaughtExceptionHandler;

class dzx implements UncaughtExceptionHandler {
    dzx() {
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (dze.aBH() && dzg.dBT != null) {
            if (dze.aBQ()) {
                ead.dy(dzg.dBT).m10412b(new dzl(dzg.dBT, dzg.m10354a(dzg.dBT, false, null), 2, th, thread, null), null, false, true);
                dzg.dBR.debug("MTA has caught the following uncaught exception:");
                dzg.dBR.m10418f(th);
            }
            dzg.dw(dzg.dBT);
            if (dzg.dBS != null) {
                dzg.dBR.db("Call the original uncaught exception handler.");
                if (!(dzg.dBS instanceof dzx)) {
                    dzg.dBS.uncaughtException(thread, th);
                }
            }
        }
    }
}
