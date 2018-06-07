package com.fossil;

import com.fossil.ats.C1890b;
import com.fossil.ats.C1893g;

public class but {
    public static final bup bGD = new blw();
    public static final buq bGE = new bmd();
    public static final buu bGF = new bmv();
    public static final ats<Object> bfF = new ats("LocationServices.API", bvj, bvi);
    private static final C1893g<bmp> bvi = new C1893g();
    private static final C1890b<bmp, Object> bvj = new bxg();

    public static abstract class C1934a<R extends atz> extends bds<R, bmp> {
        public C1934a(atv com_fossil_atv) {
            super(but.bfF, com_fossil_atv);
        }

        public final /* synthetic */ void aV(Object obj) {
            super.m4406d((atz) obj);
        }
    }

    public static bmp m5695i(atv com_fossil_atv) {
        boolean z = true;
        awa.m4637b(com_fossil_atv != null, "GoogleApiClient parameter is required.");
        bmp com_fossil_bmp = (bmp) com_fossil_atv.mo1329a(bvi);
        if (com_fossil_bmp == null) {
            z = false;
        }
        awa.m4634a(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return com_fossil_bmp;
    }
}
