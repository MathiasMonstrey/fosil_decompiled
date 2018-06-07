package com.fossil;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v8.renderscript.Allocation;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.wxop.stat.StatReportStrategy;
import java.net.URI;
import java.util.Iterator;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class dze {
    private static int f1469E = 180;
    private static int f1470L = 20;
    private static int f1471M = 0;
    private static String f1472Q = null;
    static boolean aWF = false;
    static volatile String aWJ = "pingma.qq.com:80";
    static String aWS = "__HIBERNATE__";
    static String aWX = "__MTA_KILL__";
    static boolean aXU = true;
    static long aXW = 10000;
    static String aXl = "";
    static int aXp = 100;
    static long aYw = 10000;
    static boolean aYx = true;
    private static String aZB;
    private static String aZC = "mta_channel";
    static int aZe = 512;
    private static boolean aZh = false;
    private static boolean aZi = true;
    private static String aZn = null;
    static int bai = 0;
    private static int bcN = 100000;
    static String f1473d = "__HIBERNATE__TIME";
    private static int dBA = 1024;
    private static long dBB = 0;
    private static long dBC = 300000;
    public static boolean dBD = true;
    private static volatile String dBE = "http://pingma.qq.com:80/mstat/report";
    private static int dBF = 0;
    private static volatile int dBG = 0;
    private static boolean dBH = false;
    private static int dBI = 4096;
    private static boolean dBJ = false;
    private static boolean dBK = false;
    private static ebm dBL = null;
    private static eaq dBt = ebb.aCr();
    static ebl dBu = new ebl(2);
    static ebl dBv = new ebl(1);
    private static StatReportStrategy dBw = StatReportStrategy.APP_LAUNCH;
    private static int dBx = 30000;
    private static int dBy = 30;
    private static String dBz;
    private static int f1474w = 10;
    private static int f1475x = 100;
    private static int f1476y = 30;
    private static int f1477z = 1;

    static int HF() {
        return f1471M;
    }

    static void HO() {
        f1471M++;
    }

    static boolean m10333K(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    public static void m10334W(Context context, String str) {
        if (context == null) {
            dBt.error("ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > 256) {
            dBt.error("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            if (dBz == null) {
                dBz = m10336Y(context);
            }
            if ((lh(str) | lh(ebb.dE(context))) != 0) {
                m10349k(context, dBz);
            }
        }
    }

    public static void m10335X(Context context, String str) {
        if (str.length() > Allocation.USAGE_SHARED) {
            dBt.error("the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        aZB = str;
        ebg.m10448m(context, aZC, str);
    }

    static String m10336Y(Context context) {
        return ebh.m10451a(ebg.m10447l(context, "_mta_ky_tag_", null));
    }

    static int m10337a() {
        return dBy;
    }

    static synchronized void m10338a(int i) {
        synchronized (dze.class) {
            dBG = i;
        }
    }

    static void m10339a(long j) {
        ebg.m10444b(ebo.aCs(), aWS, j);
        dB(false);
        dBt.warn("MTA is disable for current SDK version");
    }

    static void m10340a(Context context, ebl com_fossil_ebl) {
        if (com_fossil_ebl.f1510a == dBv.f1510a) {
            dBv = com_fossil_ebl;
            m10347f(com_fossil_ebl.dDh);
            if (!dBv.dDh.isNull("iplist")) {
                dzi.dx(context).cg(dBv.dDh.getString("iplist"));
            }
        } else if (com_fossil_ebl.f1510a == dBu.f1510a) {
            dBu = com_fossil_ebl;
        }
    }

    static void m10341a(Context context, ebl com_fossil_ebl, JSONObject jSONObject) {
        Object obj = null;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(str);
                    Object obj2 = com_fossil_ebl.f1511d != i ? 1 : obj;
                    com_fossil_ebl.f1511d = i;
                    obj = obj2;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        com_fossil_ebl.dDh = new JSONObject(str);
                    }
                } else if (str.equalsIgnoreCase("m")) {
                    com_fossil_ebl.aWS = jSONObject.getString("m");
                }
            }
            if (obj == 1) {
                ead dy = ead.dy(ebo.aCs());
                if (dy != null) {
                    dy.m10413b(com_fossil_ebl);
                }
                if (com_fossil_ebl.f1510a == dBv.f1510a) {
                    m10347f(com_fossil_ebl.dDh);
                    m10348g(com_fossil_ebl.dDh);
                }
            }
            m10340a(context, com_fossil_ebl);
        } catch (Throwable e) {
            dBt.m10419g(e);
        } catch (Throwable e2) {
            dBt.m10419g(e2);
        }
    }

    static void m10342a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(dBv.f1510a))) {
                    m10341a(context, dBv, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(dBu.f1510a))) {
                    m10341a(context, dBu, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(str));
                    if (statReportStrategy != null) {
                        dBw = statReportStrategy;
                        if (aBG()) {
                            dBt.db("Change to ReportStrategy:" + statReportStrategy.name());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable e) {
            dBt.m10419g(e);
        }
    }

    public static void m10343a(StatReportStrategy statReportStrategy) {
        dBw = statReportStrategy;
        if (statReportStrategy != StatReportStrategy.PERIOD) {
            dzg.aXw = 0;
        }
        if (aBG()) {
            dBt.db("Change to statSendStrategy: " + statReportStrategy);
        }
    }

    public static StatReportStrategy aBF() {
        return dBw;
    }

    public static boolean aBG() {
        return aZh;
    }

    public static boolean aBH() {
        return aZi;
    }

    public static int aBI() {
        return dBx;
    }

    public static int aBJ() {
        return f1475x;
    }

    public static int aBK() {
        return f1476y;
    }

    public static int aBL() {
        return f1474w;
    }

    public static int aBM() {
        return f1477z;
    }

    public static int aBN() {
        return bcN;
    }

    public static int aBO() {
        return f1469E;
    }

    public static int aBP() {
        return dBA;
    }

    public static boolean aBQ() {
        return dBD;
    }

    public static String aBR() {
        return dBE;
    }

    public static int aBS() {
        return f1470L;
    }

    public static boolean aBT() {
        return dBJ;
    }

    public static ebm aBU() {
        return dBL;
    }

    static void m10344b(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(aWX);
            if (ebb.cn(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.length() != 0) {
                    Object obj;
                    if (!jSONObject2.isNull("sm")) {
                        obj = jSONObject2.get("sm");
                        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                        if (intValue > 0) {
                            if (aBG()) {
                                dBt.cY("match sleepTime:" + intValue + " minutes");
                            }
                            ebg.m10444b(context, f1473d, System.currentTimeMillis() + ((long) ((intValue * 60) * 1000)));
                            dB(false);
                            dBt.warn("MTA is disable for current SDK version");
                        }
                    }
                    if (m10345b(jSONObject2, "sv", "2.0.3")) {
                        dBt.cY("match sdk version:2.0.3");
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (m10345b(jSONObject2, "md", Build.MODEL)) {
                        dBt.cY("match MODEL:" + Build.MODEL);
                        obj = 1;
                    }
                    if (m10345b(jSONObject2, "av", ebb.dI(context))) {
                        dBt.cY("match app version:" + ebb.dI(context));
                        obj = 1;
                    }
                    if (m10345b(jSONObject2, "mf", Build.MANUFACTURER)) {
                        dBt.cY("match MANUFACTURER:" + Build.MANUFACTURER);
                        obj = 1;
                    }
                    if (m10345b(jSONObject2, "osv", VERSION.SDK_INT)) {
                        dBt.cY("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (m10345b(jSONObject2, "ov", VERSION.SDK_INT)) {
                        dBt.cY("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (m10345b(jSONObject2, "ui", ead.dy(context).dz(context).HI())) {
                        dBt.cY("match imei:" + ead.dy(context).dz(context).HI());
                        obj = 1;
                    }
                    if (m10345b(jSONObject2, "mid", dp(context))) {
                        dBt.cY("match mid:" + dp(context));
                        obj = 1;
                    }
                    if (obj != null) {
                        m10339a(ebb.ll("2.0.3"));
                    }
                }
            }
        } catch (Throwable e) {
            dBt.m10419g(e);
        }
    }

    static boolean m10345b(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (ebb.cn(str2) && ebb.cn(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    static String bh(String str, String str2) {
        try {
            String string = dBv.dDh.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            dBt.cZ("can't find custom key:" + str);
            return str2;
        }
    }

    public static void dB(boolean z) {
        aZi = z;
        if (!z) {
            dBt.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static void dC(boolean z) {
        aYx = z;
    }

    public static synchronized String dl(Context context) {
        String str;
        synchronized (dze.class) {
            if (dBz != null) {
                str = dBz;
            } else {
                if (context != null) {
                    if (dBz == null) {
                        dBz = ebb.dE(context);
                    }
                }
                if (dBz == null || dBz.trim().length() == 0) {
                    dBt.error("AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = dBz;
            }
        }
        return str;
    }

    public static synchronized String dm(Context context) {
        String str;
        synchronized (dze.class) {
            if (aZB != null) {
                str = aZB;
            } else {
                str = ebg.m10447l(context, aZC, "");
                aZB = str;
                if (str == null || aZB.trim().length() == 0) {
                    aZB = ebb.dF(context);
                }
                if (aZB == null || aZB.trim().length() == 0) {
                    dBt.cZ("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = aZB;
            }
        }
        return str;
    }

    public static String dn(Context context) {
        return ebg.m10447l(context, "mta.acc.qq", aXl);
    }

    public static String m10346do(Context context) {
        if (context == null) {
            dBt.error("Context for getCustomUid is null.");
            return null;
        }
        if (f1472Q == null) {
            f1472Q = ebg.m10447l(context, "MTA_CUSTOM_UID", "");
        }
        return f1472Q;
    }

    public static String dp(Context context) {
        return context != null ? dxv.dk(context).aBA().Ik() : AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    static void m10347f(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                m10343a(statReportStrategy);
            }
        } catch (JSONException e) {
            if (aBG()) {
                dBt.cY("rs not found.");
            }
        }
    }

    static void m10348g(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                m10344b(ebo.aCs(), jSONObject);
                String string = jSONObject.getString(aWS);
                if (aBG()) {
                    dBt.db("hibernateVer:" + string + ", current version:2.0.3");
                }
                long ll = ebb.ll(string);
                if (ebb.ll("2.0.3") <= ll) {
                    m10339a(ll);
                }
            } catch (JSONException e) {
                dBt.db("__HIBERNATE__ not found.");
            }
        }
    }

    static void hj(int i) {
        if (i >= 0) {
            f1471M = i;
        }
    }

    static void m10349k(Context context, String str) {
        if (str != null) {
            ebg.m10448m(context, "_mta_ky_tag_", ebh.cx(str));
        }
    }

    private static boolean lh(String str) {
        if (str == null) {
            return false;
        }
        if (dBz == null) {
            dBz = str;
            return true;
        } else if (dBz.contains(str)) {
            return false;
        } else {
            dBz += "|" + str;
            return true;
        }
    }

    public static void li(String str) {
        if (str.length() > Allocation.USAGE_SHARED) {
            dBt.error("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            aZB = str;
        }
    }

    public static void lj(String str) {
        if (str == null || str.length() == 0) {
            dBt.error("statReportUrl cannot be null or empty.");
            return;
        }
        dBE = str;
        try {
            aWJ = new URI(dBE).getHost();
        } catch (Exception e) {
            dBt.cZ(e);
        }
        if (aBG()) {
            dBt.cY("url:" + dBE + ", domain:" + aWJ);
        }
    }

    public static void mV(int i) {
        if (m10333K(i, 1, DateTimeConstants.MINUTES_PER_WEEK)) {
            f1469E = i;
        } else {
            dBt.error("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }
}
