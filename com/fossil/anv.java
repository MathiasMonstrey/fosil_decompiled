package com.fossil;

import com.facebook.internal.AnalyticsEvents;
import com.flurry.sdk.is;
import com.flurry.sdk.it;
import com.flurry.sdk.kw.C1540a;
import com.fossil.anw.C1738a;
import com.fossil.apv.C1725a;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class anv extends apz<anw> {
    private static final String aWX = anv.class.getSimpleName();
    public static long aXm;

    class C17331 implements aqk<List<anw>> {
        final /* synthetic */ anv aYh;

        C17331(anv com_fossil_anv) {
            this.aYh = com_fossil_anv;
        }

        public final aqi<List<anw>> hi(int i) {
            return new aqh(new C1738a());
        }
    }

    static class C1735a {
        private static HashMap<it, String> aYk;

        static {
            HashMap hashMap = new HashMap();
            aYk = hashMap;
            hashMap.put(it.INSTALL, "Install");
            aYk.put(it.SESSION_START, "Session Start");
            aYk.put(it.SESSION_END, "Session End");
            aYk.put(it.APPLICATION_EVENT, "App Event");
        }

        static void m3998a(String str, String str2, it itVar) {
            if (ana.HD().aWE) {
                Map hashMap = new HashMap(3);
                hashMap.put("fl.Partner", str);
                hashMap.put("fl.Event", str2);
                hashMap.put("fl.Trigger", C1735a.m3997a(itVar));
                try {
                    ana.HD().m3955b("Flurry.PulseSuccess", hashMap, false);
                    return;
                } catch (Throwable th) {
                    app.m4175b(anv.aWX, "Failed to log event: Flurry.PulseSuccess", th);
                    return;
                }
            }
            app.m4180g(4, anv.aWX, "Not yahoo app. Don't log event Flurry.PulseSuccess");
        }

        static void m3999b(String str, String str2, it itVar) {
            if (ana.HD().aWE) {
                Map hashMap = new HashMap(3);
                hashMap.put("fl.Partner", str);
                hashMap.put("fl.Event", str2);
                hashMap.put("fl.Trigger", C1735a.m3997a(itVar));
                try {
                    ana.HD().m3955b("Flurry.PulseFail", hashMap, false);
                    return;
                } catch (Throwable th) {
                    app.m4175b(anv.aWX, "Failed to log event: Flurry.PulseFail", th);
                    return;
                }
            }
            app.m4180g(4, anv.aWX, "Not yahoo app. Don't log event Flurry.PulseFail");
        }

        private static String m3997a(it itVar) {
            String str = (String) aYk.get(itVar);
            if (str == null) {
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            return str;
        }
    }

    protected final /* synthetic */ void mo1110a(apy com_fossil_apy) {
        final anw com_fossil_anw = (anw) com_fossil_apy;
        app.m4180g(3, aWX, "Sending next pulse report to " + com_fossil_anw.aYp + " at: " + com_fossil_anw.bbL);
        aon.Il();
        long In = aon.In();
        if (In == 0) {
            In = aXm;
        }
        aon.Il();
        long Iq = aon.Iq();
        if (Iq == 0) {
            Iq = System.currentTimeMillis() - In;
        }
        final anx com_fossil_anx = new anx(com_fossil_anw, In, Iq, com_fossil_anw.bbJ);
        aqy com_fossil_apv = new apv();
        com_fossil_apv.aYv = com_fossil_anw.bbL;
        com_fossil_apv.bcN = 100000;
        if (com_fossil_anw.aXo.equals(is.POST)) {
            com_fossil_apv.baS = new aqe();
            if (com_fossil_anw.aWJ != null) {
                com_fossil_apv.bbo = com_fossil_anw.aWJ.getBytes();
            }
            com_fossil_apv.bbx = C1540a.kPost;
        } else {
            com_fossil_apv.bbx = C1540a.kGet;
        }
        com_fossil_apv.f1345i = com_fossil_anw.f1396i * 1000;
        com_fossil_apv.f1346j = com_fossil_anw.f1397j * 1000;
        com_fossil_apv.aYq = true;
        com_fossil_apv.aZh = true;
        com_fossil_apv.bbE = (com_fossil_anw.f1396i + com_fossil_anw.f1397j) * 1000;
        Map map = com_fossil_anw.aWU;
        if (map != null) {
            for (String str : com_fossil_anw.aWU.keySet()) {
                com_fossil_apv.m2786w(str, (String) map.get(str));
            }
        }
        com_fossil_apv.aXT = false;
        com_fossil_apv.bbn = new C1725a<byte[], String>(this) {
            final /* synthetic */ anv aXa;

            public final /* synthetic */ void mo1108a(apv com_fossil_apv, Object obj) {
                String str = (String) obj;
                String str2 = com_fossil_anw.aYp;
                String str3 = com_fossil_anw.aYn.f1404d;
                it itVar = com_fossil_anw.aYn.f1402b;
                app.m4180g(3, anv.aWX, "Pulse report to " + str2 + " for " + str3 + ", HTTP status code is: " + com_fossil_apv.bbD);
                int i = com_fossil_apv.bbD;
                anx com_fossil_anx = com_fossil_anx;
                int i2 = (int) com_fossil_apv.bbB;
                if (i2 >= 0) {
                    com_fossil_anx.aYy += (long) i2;
                } else if (com_fossil_anx.aYy <= 0) {
                    com_fossil_anx.aYy = 0;
                }
                com_fossil_anx.f1399e = i;
                if (!com_fossil_apv.Ie()) {
                    Exception exception = com_fossil_apv.bbC;
                    Object obj2 = null;
                    if (com_fossil_apv.bbC != null && (com_fossil_apv.bbC instanceof SocketTimeoutException)) {
                        obj2 = 1;
                    }
                    if (com_fossil_apv.bbG || r0 != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        if (com_fossil_apv.m2785c()) {
                            app.m4180g(3, anv.aWX, "Timeout occurred when trying to connect to: " + str2 + ". Exception: " + com_fossil_apv.bbC.getMessage());
                        } else {
                            app.m4180g(3, anv.aWX, "Manually managed http request timeout occurred for: " + str2);
                        }
                        anv.m4010a(this.aXa, com_fossil_anx, com_fossil_anw);
                    } else {
                        app.m4180g(3, anv.aWX, "Error occurred when trying to connect to: " + str2 + ". Exception: " + exception.getMessage());
                        anv.m4012a(this.aXa, com_fossil_anx, com_fossil_anw, str);
                    }
                    C1735a.m3999b(str2, str3, itVar);
                } else if (i >= MFNetworkReturnCode.RESPONSE_OK && i < 300) {
                    anv.m4013b(this.aXa, com_fossil_anx, com_fossil_anw);
                    C1735a.m3998a(str2, str3, itVar);
                } else if (i < 300 || i >= MFNetworkReturnCode.BAD_REQUEST) {
                    app.m4180g(3, anv.aWX, str3 + " report failed sending to : " + str2);
                    anv.m4012a(this.aXa, com_fossil_anx, com_fossil_anw, str);
                    C1735a.m3999b(str2, str3, itVar);
                } else {
                    anv.m4011a(this.aXa, com_fossil_anx, com_fossil_anw, com_fossil_apv);
                }
            }
        };
        apa.IK().m4151b(this, com_fossil_apv);
    }

    public anv() {
        apz.aXv = ShineProfile.LOG_UPLOADING_DELAY;
    }

    protected final api<List<anw>> HU() {
        return new api(apc.IO().baD.getFileStreamPath(".yflurryanpulsecallbackreporter"), ".yflurryanpulsecallbackreporter", 2, new C17331(this));
    }

    protected final synchronized void mo1111a(List<anw> list) {
        any.HZ();
        List<anz> Ic = any.Ic();
        if (Ic != null) {
            if (Ic.size() != 0) {
                app.m4180g(3, aWX, "Restoring " + Ic.size() + " from report queue.");
                for (anz b : Ic) {
                    any.HZ().m4043b(b);
                }
                any.HZ();
                for (anz Id : any.HY()) {
                    for (anw com_fossil_anw : Id.Id()) {
                        if (!com_fossil_anw.aYq) {
                            app.m4180g(3, aWX, "Callback for " + com_fossil_anw.aYn.f1404d + " to " + com_fossil_anw.aYp + " not completed.  Adding to reporter queue.");
                            list.add(com_fossil_anw);
                        }
                    }
                }
            }
        }
    }

    protected final synchronized void mo1112x(List<anw> list) {
        any.HZ().HJ();
    }

    static /* synthetic */ void m4010a(anv com_fossil_anv, anx com_fossil_anx, anw com_fossil_anw) {
        any.HZ().m4045c(com_fossil_anx);
        com_fossil_anv.m4007c((apy) com_fossil_anw);
    }

    static /* synthetic */ void m4012a(anv com_fossil_anv, anx com_fossil_anx, anw com_fossil_anw, String str) {
        boolean b = any.HZ().m4044b(com_fossil_anx, str);
        app.m4180g(3, aWX, "Failed report retrying: " + b);
        if (b) {
            com_fossil_anv.m4008d(com_fossil_anw);
        } else {
            com_fossil_anv.m4007c((apy) com_fossil_anw);
        }
    }

    static /* synthetic */ void m4013b(anv com_fossil_anv, anx com_fossil_anx, anw com_fossil_anw) {
        app.m4180g(3, aWX, com_fossil_anw.aYn.f1404d + " report sent successfully to : " + com_fossil_anw.aYp);
        any.HZ().m4040a(com_fossil_anx);
        com_fossil_anv.m4007c((apy) com_fossil_anw);
    }

    static /* synthetic */ void m4011a(anv com_fossil_anv, anx com_fossil_anx, anw com_fossil_anw, apv com_fossil_apv) {
        String str = null;
        List cm = com_fossil_apv.cm("Location");
        if (cm != null && cm.size() > 0) {
            str = aqz.m4258A((String) cm.get(0), com_fossil_anw.bbK);
        }
        boolean a = any.HZ().m4042a(com_fossil_anx, str);
        if (a) {
            app.m4180g(3, aWX, "Received redirect url. Retrying: " + str);
        } else {
            app.m4180g(3, aWX, "Received redirect url. Retrying: false");
        }
        if (a) {
            com_fossil_anw.bbL = str;
            com_fossil_apv.aYv = str;
            str = "Location";
            if (com_fossil_apv.bbw != null && com_fossil_apv.bbw.aZV.containsKey(str)) {
                com_fossil_apv.bbw.bI(str);
            }
            apa.IK().m4151b(com_fossil_anv, com_fossil_apv);
            return;
        }
        com_fossil_anv.m4007c((apy) com_fossil_anw);
    }
}
