package com.fossil;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeConstants;
import org.json.JSONObject;

public class dzg {
    static volatile int f1478a = 0;
    private static String aWJ = "";
    private static volatile Map<dzk, Long> aWU = new ConcurrentHashMap();
    private static volatile Map<String, Properties> aWV = new ConcurrentHashMap();
    static volatile long aXv = 0;
    static volatile long aXw = 0;
    private static volatile Map<Integer, Integer> aYF = new ConcurrentHashMap(10);
    private static volatile long aYo = 0;
    private static volatile String aYt = "";
    private static volatile long aYw = 0;
    private static volatile int aZc = 0;
    private static volatile boolean aZi = true;
    private static eav dBN;
    private static volatile String dBO = "";
    private static Map<String, Long> dBP = new ConcurrentHashMap();
    private static Map<String, Long> dBQ = new ConcurrentHashMap();
    private static eaq dBR = ebb.aCr();
    private static UncaughtExceptionHandler dBS = null;
    private static Context dBT = null;
    private static volatile long f1479j = 0;

    static void HH() {
        f1478a = 0;
        aXv = 0;
    }

    public static void m10352J(Context context, int i) {
        if (dze.aBH()) {
            if (dze.aBG()) {
                dBR.cY("commitEvents, maxNumber=" + i);
            }
            Context ds = ds(context);
            if (ds == null) {
                dBR.error("The Context of StatService.commitEvents() can not be null!");
            } else if (i < -1 || i == 0) {
                dBR.error("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            } else if (dzi.dx(dBT).aCj() && du(ds) != null) {
                dBN.m10423a(new dzr(ds, i));
            }
        }
    }

    static boolean Ja() {
        if (f1478a < 2) {
            return false;
        }
        aXv = System.currentTimeMillis();
        return true;
    }

    static void m10353X(Context context) {
        aXw = System.currentTimeMillis() + ((long) (DateTimeConstants.MILLIS_PER_MINUTE * dze.aBO()));
        ebg.m10444b(context, "last_period_ts", aXw);
        m10352J(context, -1);
    }

    static int m10354a(Context context, boolean z, dzh com_fossil_dzh) {
        int i = 1;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z || currentTimeMillis - aYw < ((long) dze.aBI())) {
            boolean z2 = false;
        } else {
            int i2 = 1;
        }
        aYw = currentTimeMillis;
        if (f1479j == 0) {
            f1479j = ebb.IL();
        }
        if (currentTimeMillis >= f1479j) {
            f1479j = ebb.IL();
            if (ead.dy(context).dz(context).IA() != 1) {
                ead.dy(context).dz(context).m10420a(1);
            }
            dze.hj(0);
            f1478a = 0;
            aWJ = ebb.mW(0);
            i2 = 1;
        }
        Object obj = aWJ;
        if (ebb.m10439a(com_fossil_dzh)) {
            obj = com_fossil_dzh.awy() + aWJ;
        }
        if (dBQ.containsKey(obj)) {
            i = i2;
        }
        if (i != 0) {
            if (ebb.m10439a(com_fossil_dzh)) {
                m10357a(context, com_fossil_dzh);
            } else if (dze.HF() < dze.aBS()) {
                ebb.dX(context);
                m10357a(context, null);
            } else {
                dBR.da("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            dBQ.put(obj, Long.valueOf(1));
        }
        if (aZi) {
            dv(context);
            aZi = false;
        }
        return aZc;
    }

    static synchronized void m10356a(Context context) {
        synchronized (dzg.class) {
            if (context != null) {
                if (dBN == null && dt(context)) {
                    Context applicationContext = context.getApplicationContext();
                    dBT = applicationContext;
                    dBN = new eav();
                    aWJ = ebb.mW(0);
                    aYo = System.currentTimeMillis() + dze.aYw;
                    dBN.m10423a(new ebr(applicationContext));
                }
            }
        }
    }

    static void m10357a(Context context, dzh com_fossil_dzh) {
        if (du(context) != null) {
            if (dze.aBG()) {
                dBR.db("start new session.");
            }
            if (com_fossil_dzh == null || aZc == 0) {
                aZc = ebb.m10436a();
            }
            dze.m10338a(0);
            dze.HO();
            new dzz(new dzq(context, aZc, aBV(), com_fossil_dzh)).HJ();
        }
    }

    public static void m10358a(Context context, String str, dzh com_fossil_dzh) {
        if (dze.aBH()) {
            Context ds = ds(context);
            if (ds == null || str == null || str.length() == 0) {
                dBR.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (du(ds) != null) {
                dBN.m10423a(new ebw(str2, ds, com_fossil_dzh));
            }
        }
    }

    public static void m10359a(Context context, String str, Properties properties, dzh com_fossil_dzh) {
        if (dze.aBH()) {
            Context ds = ds(context);
            if (ds == null) {
                dBR.error("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (lh(str)) {
                dBR.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                dzk com_fossil_dzk = new dzk(str, null, properties);
                if (du(ds) != null) {
                    dBN.m10423a(new ebv(ds, com_fossil_dzh, com_fossil_dzk));
                }
            }
        }
    }

    static void m10360a(Context context, Throwable th) {
        if (dze.aBH()) {
            Context ds = ds(context);
            if (ds == null) {
                dBR.error("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (du(ds) != null) {
                dBN.m10423a(new ebt(ds, th));
            }
        }
    }

    public static boolean m10361a(Context context, String str, String str2, dzh com_fossil_dzh) {
        try {
            if (dze.aBH()) {
                String str3 = "2.0.3";
                if (dze.aBG()) {
                    dBR.db("MTA SDK version, current: " + str3 + " ,required: " + str2);
                }
                if (context == null || str2 == null) {
                    dBR.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
                    dze.dB(false);
                    return false;
                } else if (ebb.ll(str3) < ebb.ll(str2)) {
                    dBR.error(("MTA SDK version conflicted, current: " + str3 + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                    dze.dB(false);
                    return false;
                } else {
                    str3 = dze.dm(context);
                    if (str3 == null || str3.length() == 0) {
                        dze.li("-");
                    }
                    if (str != null) {
                        dze.m10334W(context, str);
                    }
                    if (du(context) != null) {
                        dBN.m10423a(new dzw(context, com_fossil_dzh));
                    }
                    return true;
                }
            }
            dBR.error("MTA StatService is disable.");
            return false;
        } catch (Throwable th) {
            dBR.m10419g(th);
            return false;
        }
    }

    static JSONObject aBV() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (dze.dBv.f1511d != 0) {
                jSONObject2.put("v", dze.dBv.f1511d);
            }
            jSONObject.put(Integer.toString(dze.dBv.f1510a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (dze.dBu.f1511d != 0) {
                jSONObject2.put("v", dze.dBu.f1511d);
            }
            jSONObject.put(Integer.toString(dze.dBu.f1510a), jSONObject2);
        } catch (Throwable e) {
            dBR.m10419g(e);
        }
        return jSONObject;
    }

    public static void m10362b(Context context, dzh com_fossil_dzh) {
        if (dze.aBH() && du(context) != null) {
            dBN.m10423a(new dzv(context, com_fossil_dzh));
        }
    }

    public static void m10363b(Context context, String str, dzh com_fossil_dzh) {
        if (dze.aBH()) {
            Context ds = ds(context);
            if (ds == null || str == null || str.length() == 0) {
                dBR.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (du(ds) != null) {
                dBN.m10423a(new dzu(ds, str2, com_fossil_dzh));
            }
        }
    }

    public static void m10364c(Context context, dzh com_fossil_dzh) {
        if (dze.aBH() && du(context) != null) {
            dBN.m10423a(new ebs(context, com_fossil_dzh));
        }
    }

    static void m10365d() {
        f1478a++;
        aXv = System.currentTimeMillis();
        dw(dBT);
    }

    static void m10366d(Context context) {
        if (dze.aBH()) {
            Context ds = ds(context);
            if (ds == null) {
                dBR.error("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                ebo.ei(ds).m10459a(new dzn(ds), new ebu());
            } catch (Throwable th) {
                dBR.m10419g(th);
            }
        }
    }

    public static Context ds(Context context) {
        return context != null ? context : dBT;
    }

    static boolean dt(Context context) {
        boolean z = false;
        long a = ebg.m10443a(context, dze.aWS, 0);
        long ll = ebb.ll("2.0.3");
        boolean z2 = true;
        if (ll <= a) {
            dBR.error("MTA is disable for current version:" + ll + ",wakeup version:" + a);
            z2 = false;
        }
        a = ebg.m10443a(context, dze.f1473d, 0);
        if (a > System.currentTimeMillis()) {
            dBR.error("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + a);
        } else {
            z = z2;
        }
        dze.dB(z);
        return z;
    }

    static eav du(Context context) {
        if (dBN == null) {
            synchronized (dzg.class) {
                if (dBN == null) {
                    try {
                        m10356a(context);
                    } catch (Throwable th) {
                        dBR.m10418f(th);
                        dze.dB(false);
                    }
                }
            }
        }
        return dBN;
    }

    public static void dv(Context context) {
        if (dze.aBH()) {
            Context ds = ds(context);
            if (ds == null) {
                dBR.error("The Context of StatService.testSpeed() can not be null!");
            } else if (du(ds) != null) {
                dBN.m10423a(new dzs(ds));
            }
        }
    }

    public static void dw(Context context) {
        if (dze.aBH() && dze.bai > 0) {
            Context ds = ds(context);
            if (ds == null) {
                dBR.error("The Context of StatService.testSpeed() can not be null!");
            } else {
                ead.dy(ds).HH();
            }
        }
    }

    static boolean lh(String str) {
        return str == null || str.length() == 0;
    }

    public static Properties lk(String str) {
        return (Properties) aWV.get(str);
    }
}
