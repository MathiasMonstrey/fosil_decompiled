package com.fossil;

import android.location.Criteria;
import android.location.Location;

public final class aqp extends aqq {
    public static final String aWX = null;
    public static final Long aZE = null;
    public static final Location bah = null;
    public static final String bbK = null;
    public static final Integer bbW = Integer.valueOf(258);
    public static final Criteria bcA = null;
    public static final Long bcB = Long.valueOf(10000);
    public static final Boolean bcC = Boolean.valueOf(true);
    public static final Byte bcD = Byte.valueOf((byte) -1);
    public static final Boolean bcE = Boolean.valueOf(false);
    public static final Boolean bcF = Boolean.valueOf(true);
    public static final Boolean bcG = Boolean.valueOf(true);
    private static aqp bcH;
    public static final Integer bct = Integer.valueOf(8);
    public static final Integer bcu = Integer.valueOf(2);
    public static final Integer bcv = Integer.valueOf(0);
    public static final Boolean bcw = Boolean.valueOf(true);
    public static final Boolean bcx = Boolean.valueOf(true);
    public static final String bcy = null;
    public static final Boolean bcz = Boolean.valueOf(true);

    private aqp() {
        m4242a("AgentVersion", (Object) bbW);
        m4242a("ReleaseMajorVersion", (Object) bct);
        m4242a("ReleaseMinorVersion", (Object) bcu);
        m4242a("ReleasePatchVersion", (Object) bcv);
        m4242a("ReleaseBetaVersion", (Object) "");
        m4242a("VersionName", (Object) aWX);
        m4242a("CaptureUncaughtExceptions", (Object) bcw);
        m4242a("UseHttps", (Object) bcx);
        m4242a("ReportUrl", (Object) bcy);
        m4242a("ReportLocation", (Object) bcz);
        m4242a("ExplicitLocation", (Object) bah);
        m4242a("ContinueSessionMillis", (Object) bcB);
        m4242a("LogEvents", (Object) bcC);
        m4242a("Age", (Object) aZE);
        m4242a("Gender", (Object) bcD);
        m4242a("UserId", (Object) "");
        m4242a("ProtonEnabled", (Object) bcE);
        m4242a("ProtonConfigUrl", (Object) bbK);
        m4242a("analyticsEnabled", (Object) bcF);
        m4242a("IncludeBackgroundSessionsInMetrics", (Object) bcG);
        m4242a("notificationsEnabled", (Object) Boolean.valueOf(false));
    }

    public static synchronized aqp Jf() {
        aqp com_fossil_aqp;
        synchronized (aqp.class) {
            if (bcH == null) {
                bcH = new aqp();
            }
            com_fossil_aqp = bcH;
        }
        return com_fossil_aqp;
    }
}
