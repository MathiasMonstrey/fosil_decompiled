package com.fossil;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class aqx implements Runnable {
    private static final String aWB = aqx.class.getSimpleName();
    private PrintStream bcJ;
    private PrintWriter bcK;

    public abstract void HJ();

    public final void run() {
        try {
            HJ();
        } catch (Throwable th) {
            if (this.bcJ != null) {
                th.printStackTrace(this.bcJ);
            } else if (this.bcK != null) {
                th.printStackTrace(this.bcK);
            } else {
                th.printStackTrace();
            }
            app.m4174b(6, aWB, "", th);
        }
    }
}
