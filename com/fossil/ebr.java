package com.fossil;

import android.content.Context;
import com.tencent.wxop.stat.StatReportStrategy;

final class ebr implements Runnable {
    final /* synthetic */ Context baD;

    ebr(Context context) {
        this.baD = context;
    }

    public final void run() {
        dzi.dx(dzg.dBT).HN();
        ebb.m10441j(this.baD, true);
        ead.dy(this.baD);
        ebo.ei(this.baD);
        dzg.dBS = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new dzx());
        if (dze.aBF() == StatReportStrategy.APP_LAUNCH) {
            dzg.m10352J(this.baD, -1);
        }
        if (dze.aBG()) {
            dzg.dBR.db("Init MTA StatService success.");
        }
    }
}
