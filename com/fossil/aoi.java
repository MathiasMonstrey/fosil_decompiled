package com.fossil;

import android.widget.Toast;
import com.flurry.sdk.kw.C1540a;
import com.fossil.apv.C1725a;
import com.fossil.aqq.C1543a;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.Arrays;

public class aoi extends aqa implements C1543a {
    private static final String aWB = aoi.class.getSimpleName();
    private boolean aWF;
    private String aXl;

    public aoi() {
        this((byte) 0);
    }

    private aoi(byte b) {
        super("Analytics", aoi.class.getSimpleName());
        this.aWS = "AnalyticsData_";
        aqq Jf = aqp.Jf();
        this.aWF = ((Boolean) Jf.cw("UseHttps")).booleanValue();
        Jf.m4241a("UseHttps", (C1543a) this);
        app.m4180g(4, aWB, "initSettings, UseHttps = " + this.aWF);
        String str = (String) Jf.cw("ReportUrl");
        Jf.m4241a("ReportUrl", (C1543a) this);
        cf(str);
        app.m4180g(4, aWB, "initSettings, ReportUrl = " + str);
        HO();
    }

    private void cf(String str) {
        if (!(str == null || str.endsWith(".do"))) {
            app.m4180g(5, aWB, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        this.aXl = str;
    }

    public final void mo761a(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case -239660092:
                if (str.equals("UseHttps")) {
                    obj2 = null;
                    break;
                }
                break;
            case 1650629499:
                if (str.equals("ReportUrl")) {
                    obj2 = 1;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                this.aWF = ((Boolean) obj).booleanValue();
                app.m4180g(4, aWB, "onSettingUpdate, UseHttps = " + this.aWF);
                return;
            case 1:
                String str2 = (String) obj;
                cf(str2);
                app.m4180g(4, aWB, "onSettingUpdate, ReportUrl = " + str2);
                return;
            default:
                app.m4180g(6, aWB, "onSettingUpdate internal error!");
                return;
        }
    }

    protected final void mo1114a(String str, String str2, final int i) {
        apc.IO().m4160b(new aqx(this) {
            final /* synthetic */ aoi aWZ;

            public final void HJ() {
                if (i == MFNetworkReturnCode.RESPONSE_OK) {
                    ana.HD();
                    aol HE = ana.HE();
                    if (HE != null) {
                        HE.aYx = true;
                    }
                }
            }
        });
        super.mo1114a(str, str2, i);
    }

    protected final void mo1115b(byte[] bArr, final String str, final String str2) {
        String str3;
        if (this.aXl != null) {
            str3 = this.aXl;
        } else if (this.aWF) {
            str3 = "https://data.flurry.com/aap.do";
        } else {
            str3 = "http://data.flurry.com/aap.do";
        }
        app.m4180g(4, aWB, "FlurryDataSender: start upload data " + Arrays.toString(bArr) + " with id = " + str + " to " + str3);
        aqy com_fossil_apv = new apv();
        com_fossil_apv.aYv = str3;
        com_fossil_apv.bcN = 100000;
        com_fossil_apv.bbx = C1540a.kPost;
        com_fossil_apv.m2786w("Content-Type", "application/octet-stream");
        com_fossil_apv.baS = new aqe();
        com_fossil_apv.bbo = bArr;
        com_fossil_apv.bbn = new C1725a<byte[], Void>(this) {
            final /* synthetic */ aoi aYY;

            public final /* synthetic */ void mo1108a(apv com_fossil_apv, Object obj) {
                final int i = com_fossil_apv.bbD;
                if (i > 0) {
                    app.m4178e(aoi.aWB, "Analytics report sent.");
                    app.m4180g(3, aoi.aWB, "FlurryDataSender: report " + str + " sent. HTTP response: " + i);
                    if (app.HF() <= 3 && app.IY()) {
                        apc.IO().m4158a(new Runnable(this) {
                            final /* synthetic */ C17601 aYZ;

                            public final void run() {
                                Toast.makeText(apc.IO().baD, "SD HTTP Response Code: " + i, 0).show();
                            }
                        });
                    }
                    this.aYY.mo1114a(str, str2, i);
                    this.aYY.HO();
                    return;
                }
                this.aYY.cg(str);
            }
        };
        apa.IK().m4151b(this, com_fossil_apv);
    }
}
