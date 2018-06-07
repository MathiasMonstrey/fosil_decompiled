package com.fossil;

import com.misfit.frameworks.common.constants.Constants;
import com.sina.weibo.sdk.statistic.LogType;

class duc {
    private static String dtE = Constants.SESSION;
    private static long dtF = 1000;
    private long CZ;
    protected LogType dtA;
    protected String dtB;
    protected long dtC = System.currentTimeMillis();
    private long dtD;

    public duc(String str) {
        this.dtB = str;
    }

    public LogType axN() {
        return this.dtA;
    }

    public void m9754a(LogType logType) {
        this.dtA = logType;
    }

    public String axO() {
        return this.dtB;
    }

    public long getStartTime() {
        return this.dtC;
    }

    public long getEndTime() {
        return this.dtD;
    }

    public long getDuration() {
        return this.CZ;
    }
}
