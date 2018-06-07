package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.flurry.sdk.it;
import com.flurry.sdk.ji;
import com.flurry.sdk.jq;
import com.flurry.sdk.kw.C1540a;
import com.fossil.ans.C1721a;
import com.fossil.anz.C1751a;
import com.fossil.apv.C1725a;
import com.fossil.aqq.C1543a;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class anu implements C1543a {
    private static final String aWB = anu.class.getSimpleName();
    private boolean aWH;
    private final apt<anh> aXL = new apt("proton config request", new aoc());
    private final apt<ani> aXM = new apt("proton config response", new aod());
    private final ant aXN = new ant();
    private final apg<String, anl> aXO = new apg();
    private final List<anz> aXP = new ArrayList();
    private api<ans> aXQ;
    private api<List<anz>> aXR;
    private String aXS;
    private boolean aXT = true;
    private boolean aXU;
    private long aXV = 10000;
    private long aXW;
    private ani aXX;
    private boolean aXY;
    private final Runnable aXZ = new C17221(this);
    private final apk<aop> aYa = new C17296(this);
    private final apk<aoq> aYb = new C17307(this);
    private final apk<aot> aYc = new C17318(this);
    private boolean f1391o;

    class C17221 extends aqx {
        final /* synthetic */ anu aWY;

        C17221(anu com_fossil_anu) {
            this.aWY = com_fossil_anu;
        }

        public final void HJ() {
            this.aWY.HK();
        }
    }

    class C17232 extends aqx {
        final /* synthetic */ anu aWY;

        C17232(anu com_fossil_anu) {
            this.aWY = com_fossil_anu;
        }

        public final void HJ() {
            this.aWY.m3992m();
        }
    }

    class C17274 extends aqx {
        final /* synthetic */ anu aWY;

        C17274(anu com_fossil_anu) {
            this.aWY = com_fossil_anu;
        }

        public final void HJ() {
            this.aWY.HR();
        }
    }

    class C17285 extends aqx {
        final /* synthetic */ anu aWY;

        C17285(anu com_fossil_anu) {
            this.aWY = com_fossil_anu;
        }

        public final void HJ() {
            this.aWY.HK();
        }
    }

    class C17296 implements apk<aop> {
        final /* synthetic */ anu aWY;

        C17296(anu com_fossil_anu) {
            this.aWY = com_fossil_anu;
        }

        public final /* bridge */ /* synthetic */ void mo759a(apj com_fossil_apj) {
            this.aWY.HK();
        }
    }

    class C17307 implements apk<aoq> {
        final /* synthetic */ anu aWY;

        C17307(anu com_fossil_anu) {
            this.aWY = com_fossil_anu;
        }

        public final /* bridge */ /* synthetic */ void mo759a(apj com_fossil_apj) {
            this.aWY.HK();
        }
    }

    class C17318 implements apk<aot> {
        final /* synthetic */ anu aWY;

        C17318(anu com_fossil_anu) {
            this.aWY = com_fossil_anu;
        }

        public final /* bridge */ /* synthetic */ void mo759a(apj com_fossil_apj) {
            if (((aot) com_fossil_apj).aXk) {
                this.aWY.HK();
            }
        }
    }

    class C17329 implements aqk<ans> {
        final /* synthetic */ anu aWY;

        C17329(anu com_fossil_anu) {
            this.aWY = com_fossil_anu;
        }

        public final aqi<ans> hi(int i) {
            return new C1721a();
        }
    }

    public anu() {
        aqq Jf = aqp.Jf();
        this.aWH = ((Boolean) Jf.cw("ProtonEnabled")).booleanValue();
        Jf.m4241a("ProtonEnabled", (C1543a) this);
        app.m4180g(4, aWB, "initSettings, protonEnabled = " + this.aWH);
        this.aXS = (String) Jf.cw("ProtonConfigUrl");
        Jf.m4241a("ProtonConfigUrl", (C1543a) this);
        app.m4180g(4, aWB, "initSettings, protonConfigUrl = " + this.aXS);
        this.aXT = ((Boolean) Jf.cw("analyticsEnabled")).booleanValue();
        Jf.m4241a("analyticsEnabled", (C1543a) this);
        app.m4180g(4, aWB, "initSettings, AnalyticsEnabled = " + this.aXT);
        apl.IW().m4169a("com.flurry.android.sdk.IdProviderFinishedEvent", this.aYa);
        apl.IW().m4169a("com.flurry.android.sdk.IdProviderUpdatedAdvertisingId", this.aYb);
        apl.IW().m4169a("com.flurry.android.sdk.NetworkStateEvent", this.aYc);
        Context context = apc.IO().baD;
        this.aXQ = new api(context.getFileStreamPath(".yflurryprotonconfig." + Long.toString(aqv.cC(apc.IO().f1440d), 16)), ".yflurryprotonconfig.", 1, new C17329(this));
        this.aXR = new api(context.getFileStreamPath(".yflurryprotonreport." + Long.toString(aqv.cC(apc.IO().f1440d), 16)), ".yflurryprotonreport.", 1, new aqk<List<anz>>(this) {
            final /* synthetic */ anu aWY;

            {
                this.aWY = r1;
            }

            public final aqi<List<anz>> hi(int i) {
                return new aqh(new C1751a());
            }
        });
        apc.IO().m4160b(new aqx(this) {
            final /* synthetic */ anu aWY;

            {
                this.aWY = r1;
            }

            public final void HJ() {
                this.aWY.HS();
            }
        });
        apc.IO().m4160b(new C17232(this));
    }

    public final void mo761a(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case -1720015653:
                if (str.equals("analyticsEnabled")) {
                    obj2 = 2;
                    break;
                }
                break;
            case 640941243:
                if (str.equals("ProtonEnabled")) {
                    obj2 = null;
                    break;
                }
                break;
            case 1591403975:
                if (str.equals("ProtonConfigUrl")) {
                    obj2 = 1;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                this.aWH = ((Boolean) obj).booleanValue();
                app.m4180g(4, aWB, "onSettingUpdate, protonEnabled = " + this.aWH);
                return;
            case 1:
                this.aXS = (String) obj;
                app.m4180g(4, aWB, "onSettingUpdate, protonConfigUrl = " + this.aXS);
                return;
            case 2:
                this.aXT = ((Boolean) obj).booleanValue();
                app.m4180g(4, aWB, "onSettingUpdate, AnalyticsEnabled = " + this.aXT);
                return;
            default:
                app.m4180g(6, aWB, "onSettingUpdate internal error!");
                return;
        }
    }

    public final synchronized void HJ() {
        if (this.aWH) {
            aqv.HO();
            aon.Il();
            anv.aXm = aon.In();
            this.aXY = false;
            HK();
        }
    }

    private synchronized void HK() {
        if (this.aWH) {
            aqv.HO();
            if (this.aXU && ji.Iu().Ie()) {
                boolean z;
                final long currentTimeMillis = System.currentTimeMillis();
                if (ji.Iu().m2776c()) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.aXX != null) {
                    if (this.f1391o != z) {
                        app.m4180g(3, aWB, "Limit ad tracking value has changed, purging");
                        this.aXX = null;
                    } else if (System.currentTimeMillis() < this.aXW + (this.aXX.aXv * 1000)) {
                        app.m4180g(3, aWB, "Cached Proton config valid, no need to refresh");
                        if (!this.aXY) {
                            this.aXY = true;
                            m3983c("flurry.session_start", null);
                        }
                    } else if (System.currentTimeMillis() >= this.aXW + (this.aXX.aXw * 1000)) {
                        app.m4180g(3, aWB, "Cached Proton config expired, purging");
                        this.aXX = null;
                        this.aXO.HJ();
                    }
                }
                apa.IK().bJ(this);
                app.m4180g(3, aWB, "Requesting proton config");
                Object HL = HL();
                if (HL != null) {
                    String str;
                    aqy com_fossil_apv = new apv();
                    if (TextUtils.isEmpty(this.aXS)) {
                        str = "https://proton.flurry.com/sdk/v1/config";
                    } else {
                        str = this.aXS;
                    }
                    com_fossil_apv.aYv = str;
                    com_fossil_apv.bcN = 5000;
                    com_fossil_apv.bbx = C1540a.kPost;
                    String num = Integer.toString(apt.m4187Y(HL));
                    com_fossil_apv.m2786w("Content-Type", "application/x-flurry;version=2");
                    com_fossil_apv.m2786w("Accept", "application/x-flurry;version=2");
                    com_fossil_apv.m2786w("FM-Checksum", num);
                    com_fossil_apv.baS = new aqe();
                    com_fossil_apv.bbl = new aqe();
                    com_fossil_apv.bbo = HL;
                    com_fossil_apv.bbn = new C1725a<byte[], byte[]>(this) {
                        final /* synthetic */ anu aYd;

                        public final /* synthetic */ void mo1108a(apv com_fossil_apv, Object obj) {
                            ani com_fossil_ani = null;
                            final byte[] bArr = (byte[]) obj;
                            int i = com_fossil_apv.bbD;
                            app.m4180g(3, anu.aWB, "Proton config request: HTTP status code is:" + i);
                            if (i == MFNetworkReturnCode.BAD_REQUEST || i == 406 || i == 412 || i == MFNetworkReturnCode.CONTENT_TYPE_ERROR) {
                                this.aYd.aXV = 10000;
                                return;
                            }
                            if (com_fossil_apv.Ie() && bArr != null) {
                                ani com_fossil_ani2;
                                apc.IO().m4160b(new aqx(this) {
                                    final /* synthetic */ C17263 aYf;

                                    public final void HJ() {
                                        this.aYf.aYd.m3972a(currentTimeMillis, z, bArr);
                                    }
                                });
                                try {
                                    com_fossil_ani2 = (ani) this.aYd.aXM.aa(bArr);
                                } catch (Exception e) {
                                    app.m4180g(5, anu.aWB, "Failed to decode proton config response: " + e);
                                    com_fossil_ani2 = null;
                                }
                                if (anu.m3976a(com_fossil_ani2)) {
                                    com_fossil_ani = com_fossil_ani2;
                                }
                                if (com_fossil_ani != null) {
                                    this.aYd.aXV = 10000;
                                    this.aYd.aXW = currentTimeMillis;
                                    this.aYd.f1391o = z;
                                    this.aYd.aXX = com_fossil_ani;
                                    this.aYd.HM();
                                    if (!this.aYd.aXY) {
                                        this.aYd.aXY = true;
                                        this.aYd.m3983c("flurry.session_start", null);
                                    }
                                    this.aYd.HN();
                                }
                            }
                            if (com_fossil_ani == null) {
                                long parseLong;
                                long i2 = this.aYd.aXV << 1;
                                if (i == MFNetworkReturnCode.RATE_LIMIT_EXEEDED) {
                                    List cm = com_fossil_apv.cm("Retry-After");
                                    if (!cm.isEmpty()) {
                                        String str = (String) cm.get(0);
                                        app.m4180g(3, anu.aWB, "Server returned retry time: " + str);
                                        try {
                                            parseLong = Long.parseLong(str) * 1000;
                                        } catch (NumberFormatException e2) {
                                            app.m4180g(3, anu.aWB, "Server returned nonsensical retry time");
                                        }
                                        this.aYd.aXV = parseLong;
                                        app.m4180g(3, anu.aWB, "Proton config request failed, backing off: " + this.aYd.aXV + "ms");
                                        apc.IO().m4159a(this.aYd.aXZ, this.aYd.aXV);
                                    }
                                }
                                parseLong = i2;
                                this.aYd.aXV = parseLong;
                                app.m4180g(3, anu.aWB, "Proton config request failed, backing off: " + this.aYd.aXV + "ms");
                                apc.IO().m4159a(this.aYd.aXZ, this.aYd.aXV);
                            }
                        }
                    };
                    apa.IK().m4151b(this, com_fossil_apv);
                }
            }
        }
    }

    private synchronized void m3983c(String str, Map<String, String> map) {
        app.m4180g(3, aWB, "Event triggered: " + str);
        if (!this.aXT) {
            app.m4178e(aWB, "Analytics and pulse have been disabled.");
        } else if (this.aXX == null) {
            app.m4180g(3, aWB, "Config response is empty. No events to fire.");
        } else {
            aqv.HO();
            if (!TextUtils.isEmpty(str)) {
                List<anl> bH = this.aXO.bH(str);
                if (bH == null) {
                    app.m4180g(3, aWB, "No events to fire. Returning.");
                } else if (bH.size() == 0) {
                    app.m4180g(3, aWB, "No events to fire. Returning.");
                } else {
                    it itVar;
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z = map != null;
                    Object obj = -1;
                    switch (str.hashCode()) {
                        case 645204782:
                            if (str.equals("flurry.session_end")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 1371447545:
                            if (str.equals("flurry.app_install")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 1579613685:
                            if (str.equals("flurry.session_start")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            itVar = it.SESSION_START;
                            break;
                        case 1:
                            itVar = it.SESSION_END;
                            break;
                        case 2:
                            itVar = it.INSTALL;
                            break;
                        default:
                            itVar = it.APPLICATION_EVENT;
                            break;
                    }
                    Map hashMap = new HashMap();
                    for (anl com_fossil_anl : bH) {
                        Object obj2 = null;
                        if (com_fossil_anl instanceof anm) {
                            app.m4180g(4, aWB, "Event contains triggers.");
                            String[] strArr = ((anm) com_fossil_anl).aXC;
                            if (strArr == null) {
                                app.m4180g(4, aWB, "Template does not contain trigger values. Firing.");
                                obj2 = 1;
                            } else if (strArr.length == 0) {
                                app.m4180g(4, aWB, "Template does not contain trigger values. Firing.");
                                obj2 = 1;
                            } else if (map == null) {
                                app.m4180g(4, aWB, "Publisher has not passed in params list. Not firing.");
                            }
                            String str2 = (String) map.get(((anm) com_fossil_anl).aWS);
                            if (str2 == null) {
                                app.m4180g(4, aWB, "Publisher params has no value associated with proton key. Not firing.");
                            } else {
                                Object obj3;
                                int length = strArr.length;
                                int i = 0;
                                while (i < length) {
                                    if (strArr[i].equals(str2)) {
                                        obj3 = 1;
                                        if (obj3 != null) {
                                            app.m4180g(4, aWB, "Publisher params list does not match proton param values. Not firing.");
                                        } else {
                                            app.m4180g(4, aWB, "Publisher params match proton values. Firing.");
                                        }
                                    } else {
                                        i++;
                                    }
                                }
                                obj3 = obj2;
                                if (obj3 != null) {
                                    app.m4180g(4, aWB, "Publisher params match proton values. Firing.");
                                } else {
                                    app.m4180g(4, aWB, "Publisher params list does not match proton param values. Not firing.");
                                }
                            }
                        }
                        anf com_fossil_anf = com_fossil_anl.aXB;
                        if (com_fossil_anf == null) {
                            app.m4180g(3, aWB, "Template is empty. Not firing current event.");
                        } else {
                            app.m4180g(3, aWB, "Creating callback report for partner: " + com_fossil_anf.aWR);
                            Map hashMap2 = new HashMap();
                            hashMap2.put("event_name", str);
                            hashMap2.put("event_time_millis", String.valueOf(currentTimeMillis));
                            String b = this.aXN.m3964b(com_fossil_anf.aWX, hashMap2);
                            String str3 = null;
                            if (com_fossil_anf.aXl != null) {
                                str3 = this.aXN.m3964b(com_fossil_anf.aXl, hashMap2);
                            }
                            hashMap.put(Long.valueOf(com_fossil_anf.aXm), new anw(com_fossil_anf.aWR, com_fossil_anf.aXm, b, System.currentTimeMillis() + 259200000, this.aXX.aXy.f1383b, com_fossil_anf.f1381g, com_fossil_anf.aXo, com_fossil_anf.aXq, com_fossil_anf.f1382i, com_fossil_anf.aXp, str3));
                        }
                    }
                    if (hashMap.size() != 0) {
                        aon.Il();
                        long In = aon.In();
                        aon.Il();
                        anz com_fossil_anz = new anz(str, z, In, aon.Iq(), itVar, hashMap);
                        if ("flurry.session_end".equals(str)) {
                            app.m4180g(3, aWB, "Storing Pulse callbacks for event: " + str);
                            this.aXP.add(com_fossil_anz);
                        } else {
                            app.m4180g(3, aWB, "Firing Pulse callbacks for event: " + str);
                            any.HZ().m4041a(com_fossil_anz);
                        }
                    }
                }
            }
        }
    }

    private byte[] HL() {
        try {
            anh com_fossil_anh = new anh();
            com_fossil_anh.aWB = apc.IO().f1440d;
            com_fossil_anh.aWR = aqs.m4244Y(apc.IO().baD);
            com_fossil_anh.aWS = aqs.aa(apc.IO().baD);
            com_fossil_anh.f1386d = apd.Iz();
            com_fossil_anh.f1387e = 3;
            aov.IF();
            com_fossil_anh.aXl = aov.HI();
            com_fossil_anh.aWF = !ji.Iu().m2776c();
            com_fossil_anh.aXr = new ank();
            com_fossil_anh.aXr.aXA = new ane();
            com_fossil_anh.aXr.aXA.aWB = Build.MODEL;
            com_fossil_anh.aXr.aXA.aWR = Build.BRAND;
            com_fossil_anh.aXr.aXA.aWS = Build.ID;
            com_fossil_anh.aXr.aXA.f1380d = Build.DEVICE;
            com_fossil_anh.aXr.aXA.aWX = Build.PRODUCT;
            com_fossil_anh.aXr.aXA.aXl = VERSION.RELEASE;
            com_fossil_anh.aXs = new ArrayList();
            for (Entry entry : Collections.unmodifiableMap(ji.Iu().aZV).entrySet()) {
                anj com_fossil_anj = new anj();
                com_fossil_anj.f1388a = ((jq) entry.getKey()).f1321d;
                if (((jq) entry.getKey()).f1322e) {
                    com_fossil_anj.aWR = new String((byte[]) entry.getValue());
                } else {
                    com_fossil_anj.aWR = aqv.ab((byte[]) entry.getValue());
                }
                com_fossil_anh.aXs.add(com_fossil_anj);
            }
            Location IB = aos.Iy().IB();
            if (IB != null) {
                int IA = aos.IA();
                com_fossil_anh.aXt = new ano();
                com_fossil_anh.aXt.aXG = new ann();
                com_fossil_anh.aXt.aXG.aXD = aqv.m4250a(IB.getLatitude(), IA);
                com_fossil_anh.aXt.aXG.aXE = aqv.m4250a(IB.getLongitude(), IA);
                com_fossil_anh.aXt.aXG.aXF = (float) aqv.m4250a((double) IB.getAccuracy(), IA);
            }
            String str = (String) aqp.Jf().cw("UserId");
            if (!str.equals("")) {
                com_fossil_anh.aXu = new anq();
                com_fossil_anh.aXu.aWB = str;
            }
            return this.aXL.bK(com_fossil_anh);
        } catch (Exception e) {
            app.m4180g(5, aWB, "Proton config request failed with exception: " + e);
            return null;
        }
    }

    private synchronized void m3972a(long j, boolean z, byte[] bArr) {
        if (bArr != null) {
            app.m4180g(4, aWB, "Saving proton config response");
            ans com_fossil_ans = new ans();
            com_fossil_ans.aXm = j;
            com_fossil_ans.aXI = z;
            com_fossil_ans.aXJ = bArr;
            this.aXQ.bJ(com_fossil_ans);
        }
    }

    private static boolean m3976a(ani com_fossil_ani) {
        if (com_fossil_ani == null) {
            return false;
        }
        boolean z;
        ang com_fossil_ang = com_fossil_ani.aXy;
        if (!(com_fossil_ang == null || com_fossil_ang.aWP == null)) {
            for (int i = 0; i < com_fossil_ang.aWP.size(); i++) {
                anf com_fossil_anf = (anf) com_fossil_ang.aWP.get(i);
                if (com_fossil_anf != null) {
                    if (!com_fossil_anf.aWR.equals("") && com_fossil_anf.aXm != -1 && !com_fossil_anf.aWX.equals("")) {
                        List<anl> list = com_fossil_anf.aXn;
                        if (list != null) {
                            for (anl com_fossil_anl : list) {
                                if (!com_fossil_anl.aWB.equals("")) {
                                    if ((com_fossil_anl instanceof anm) && ((anm) com_fossil_anl).aWS.equals("")) {
                                        app.m4180g(3, aWB, "An event trigger is missing a param name");
                                        z = false;
                                        break;
                                    }
                                } else {
                                    app.m4180g(3, aWB, "An event is missing a name");
                                    z = false;
                                    break;
                                }
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    }
                    app.m4180g(3, aWB, "A callback template is missing required values");
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z && (com_fossil_ani.aXy == null || com_fossil_ani.aXy.aWX == null || !com_fossil_ani.aXy.aWX.equals(""))) {
            return true;
        }
        app.m4180g(3, aWB, "Config response is missing required values.");
        return false;
    }

    private void HM() {
        if (this.aXX != null) {
            app.m4180g(5, aWB, "Processing config response");
            any.m4037a(this.aXX.aXy.f1384c);
            any.hj(this.aXX.aXy.f1385d * 1000);
            aoa Ig = aoa.Ig();
            String str = this.aXX.aXy.aWX;
            if (!(str == null || str.endsWith(".do"))) {
                app.m4180g(5, aoa.aWB, "overriding analytics agent report URL without an endpoint, are you sure?");
            }
            Ig.aWR = str;
            if (this.aWH) {
                aqp.Jf().m4242a("analyticsEnabled", (Object) Boolean.valueOf(this.aXX.aXz.aXI));
            }
            this.aXO.HJ();
            ang com_fossil_ang = this.aXX.aXy;
            if (com_fossil_ang != null) {
                List<anf> list = com_fossil_ang.aWP;
                if (list != null) {
                    for (anf com_fossil_anf : list) {
                        if (com_fossil_anf != null) {
                            List<anl> list2 = com_fossil_anf.aXn;
                            if (list2 != null) {
                                for (anl com_fossil_anl : list2) {
                                    if (!(com_fossil_anl == null || TextUtils.isEmpty(com_fossil_anl.aWB))) {
                                        com_fossil_anl.aXB = com_fossil_anf;
                                        this.aXO.m4164n(com_fossil_anl.aWB, com_fossil_anl);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private synchronized void HN() {
        if (this.aWH) {
            aqv.HO();
            SharedPreferences sharedPreferences = apc.IO().baD.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
            if (sharedPreferences.getBoolean("com.flurry.android.flurryAppInstall", true)) {
                m3983c("flurry.app_install", null);
                Editor edit = sharedPreferences.edit();
                edit.putBoolean("com.flurry.android.flurryAppInstall", false);
                edit.apply();
            }
        }
    }

    public final synchronized void HO() {
        if (this.aWH) {
            aqv.HO();
            aon.Il();
            m3979b(aon.In());
            HP();
        }
    }

    private synchronized void m3979b(long j) {
        Iterator it = this.aXP.iterator();
        while (it.hasNext()) {
            if (j == ((anz) it.next()).aXm) {
                it.remove();
            }
        }
    }

    private synchronized void HP() {
        if (this.aXT) {
            app.m4180g(4, aWB, "Sending " + this.aXP.size() + " queued reports.");
            for (anz com_fossil_anz : this.aXP) {
                app.m4180g(3, aWB, "Firing Pulse callbacks for event: " + com_fossil_anz.f1404d);
                any.HZ().m4041a(com_fossil_anz);
            }
            HQ();
        } else {
            app.m4178e(aWB, "Analytics disabled, not sending pulse reports.");
        }
    }

    private synchronized void HQ() {
        this.aXP.clear();
        this.aXR.Ie();
    }

    public final synchronized void m3993a(long j) {
        if (this.aWH) {
            aqv.HO();
            m3979b(j);
            m3983c("flurry.session_end", null);
            apc.IO().m4160b(new C17274(this));
        }
    }

    private synchronized void HR() {
        app.m4180g(4, aWB, "Saving queued report data.");
        this.aXR.bJ(this.aXP);
    }

    public final synchronized void HH() {
        if (this.aWH) {
            aqv.HO();
            HP();
        }
    }

    public final synchronized void m3995d(String str, Map<String, String> map) {
        if (this.aWH) {
            aqv.HO();
            m3983c(str, map);
        }
    }

    private synchronized void HS() {
        ans com_fossil_ans = (ans) this.aXQ.IV();
        if (com_fossil_ans != null) {
            ani com_fossil_ani;
            try {
                com_fossil_ani = (ani) this.aXM.aa(com_fossil_ans.aXJ);
            } catch (Exception e) {
                app.m4180g(5, aWB, "Failed to decode saved proton config response: " + e);
                this.aXQ.Ie();
                com_fossil_ani = null;
            }
            if (!m3976a(com_fossil_ani)) {
                com_fossil_ani = null;
            }
            if (com_fossil_ani != null) {
                app.m4180g(4, aWB, "Loaded saved proton config response");
                this.aXV = 10000;
                this.aXW = com_fossil_ans.aXm;
                this.f1391o = com_fossil_ans.aXI;
                this.aXX = com_fossil_ani;
                HM();
            }
        }
        this.aXU = true;
        apc.IO().m4160b(new C17285(this));
    }

    private synchronized void m3992m() {
        app.m4180g(4, aWB, "Loading queued report data.");
        List list = (List) this.aXR.IV();
        if (list != null) {
            this.aXP.addAll(list);
        }
    }
}
