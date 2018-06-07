package com.fossil;

import android.content.Context;
import com.tencent.wxop.stat.StatReportStrategy;
import java.util.Timer;
import java.util.TimerTask;

public class ebj {
    private static volatile ebj dDf = null;
    private Timer bcq = null;
    private Context dAA = null;

    private ebj(Context context) {
        this.dAA = context.getApplicationContext();
        this.bcq = new Timer(false);
    }

    public static ebj eh(Context context) {
        if (dDf == null) {
            synchronized (ebj.class) {
                if (dDf == null) {
                    dDf = new ebj(context);
                }
            }
        }
        return dDf;
    }

    public void HJ() {
        if (dze.aBF() == StatReportStrategy.PERIOD) {
            long aBO = (long) ((dze.aBO() * 60) * 1000);
            if (dze.aBG()) {
                ebb.aCr().cY("setupPeriodTimer delay:" + aBO);
            }
            m10456a(new ebk(this), aBO);
        }
    }

    public void m10456a(TimerTask timerTask, long j) {
        if (this.bcq != null) {
            if (dze.aBG()) {
                ebb.aCr().cY("setupPeriodTimer schedule delay:" + j);
            }
            this.bcq.schedule(timerTask, j);
        } else if (dze.aBG()) {
            ebb.aCr().cZ("setupPeriodTimer schedule timer == null");
        }
    }
}
