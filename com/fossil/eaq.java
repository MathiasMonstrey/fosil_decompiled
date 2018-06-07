package com.fossil;

import android.util.Log;

public final class eaq {
    private String aWB = "default";
    private boolean aXI = true;
    private int f1494c = 2;

    public eaq(String str) {
        this.aWB = str;
    }

    private String Ik() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public final boolean aBG() {
        return this.aXI;
    }

    public final void cY(Object obj) {
        if (aBG()) {
            info(obj);
        }
    }

    public final void cZ(Object obj) {
        if (aBG()) {
            warn(obj);
        }
    }

    public final void dG(boolean z) {
        this.aXI = z;
    }

    public final void da(Object obj) {
        if (aBG()) {
            error(obj);
        }
    }

    public final void db(Object obj) {
        if (aBG()) {
            debug(obj);
        }
    }

    public final void debug(Object obj) {
        if (this.f1494c <= 3) {
            String Ik = Ik();
            Ik = Ik == null ? obj.toString() : Ik + " - " + obj;
            Log.d(this.aWB, Ik);
            ebm aBU = dze.aBU();
            if (aBU != null) {
                aBU.da(Ik);
            }
        }
    }

    public final void error(Object obj) {
        if (this.f1494c <= 6) {
            String Ik = Ik();
            Ik = Ik == null ? obj.toString() : Ik + " - " + obj;
            Log.e(this.aWB, Ik);
            ebm aBU = dze.aBU();
            if (aBU != null) {
                aBU.db(Ik);
            }
        }
    }

    public final void m10418f(Throwable th) {
        if (this.f1494c <= 6) {
            Log.e(this.aWB, "", th);
            ebm aBU = dze.aBU();
            if (aBU != null) {
                aBU.db(th);
            }
        }
    }

    public final void m10419g(Throwable th) {
        if (aBG()) {
            m10418f(th);
        }
    }

    public final void info(Object obj) {
        if (this.f1494c <= 4) {
            String Ik = Ik();
            Ik = Ik == null ? obj.toString() : Ik + " - " + obj;
            Log.i(this.aWB, Ik);
            ebm aBU = dze.aBU();
            if (aBU != null) {
                aBU.bJ(Ik);
            }
        }
    }

    public final void warn(Object obj) {
        if (this.f1494c <= 5) {
            String Ik = Ik();
            Ik = Ik == null ? obj.toString() : Ik + " - " + obj;
            Log.w(this.aWB, Ik);
            ebm aBU = dze.aBU();
            if (aBU != null) {
                aBU.dc(Ik);
            }
        }
    }
}
