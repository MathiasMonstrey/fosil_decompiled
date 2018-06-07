package com.fossil;

import android.content.Context;
import com.fossil.aqq.C1543a;
import java.lang.Thread.UncaughtExceptionHandler;

public class arb implements aps, C1543a, UncaughtExceptionHandler {
    private static final String aWB = arb.class.getSimpleName();
    private boolean aXI;

    public void init(Context context) {
        aqq Jf = aqp.Jf();
        this.aXI = ((Boolean) Jf.cw("CaptureUncaughtExceptions")).booleanValue();
        Jf.m4241a("CaptureUncaughtExceptions", (C1543a) this);
        app.m4180g(4, aWB, "initSettings, CrashReportingEnabled = " + this.aXI);
        arc Jh = arc.Jh();
        synchronized (Jh.aWW) {
            Jh.aWW.put(this, null);
        }
    }

    public final void mo761a(String str, Object obj) {
        if (str.equals("CaptureUncaughtExceptions")) {
            this.aXI = ((Boolean) obj).booleanValue();
            app.m4180g(4, aWB, "onSettingUpdate, CrashReportingEnabled = " + this.aXI);
            return;
        }
        app.m4180g(6, aWB, "onSettingUpdate internal error!");
    }

    public void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace();
        if (this.aXI) {
            String str = "";
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                if (th.getMessage() != null) {
                    stringBuilder.append(" (").append(th.getMessage()).append(")\n");
                }
                str = stringBuilder.toString();
            } else if (th.getMessage() != null) {
                str = th.getMessage();
            }
            ana.HD().m3956b("uncaught", str, th);
        }
        aqm.Jc().HO();
        aos.Iy().HW();
    }
}
