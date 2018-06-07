package com.fossil;

import com.portfolio.platform.PortfolioApp;
import java.util.Properties;

public final class cjy {
    private static final String cnA = cnN.aaP().getProperty("MISFIT_API_BASE_URL_STAGING");
    private static final String cnB = cnN.aaP().getProperty("MISFIT_WEB_BASE_URL_STAGING");
    private static final String cnC = cnN.aaP().getProperty("MISFIT_API_BASE_URL_PRODUCTION");
    private static final String cnD = cnN.aaP().getProperty("MISFIT_WEB_BASE_URL_PRODUCTION");
    private static final String cnE = cnN.aaP().getProperty("EMAIL_MAGIC_STAGING_STAGING");
    private static final String cnF = cnN.aaP().getProperty("EMAIL_MAGIC_STAGING_PRODUCTION");
    private static final String cnG = cnN.aaP().getProperty("EMAIL_MAGIC_PRODUCTION_STAGING");
    private static final String cnH = cnN.aaP().getProperty("EMAIL_MAGIC_PRODUCTION_PRODUCTION");
    private static final String cnI = cnN.aaP().getProperty("SDK_ENDPOINT");
    private static final String cnJ = cnN.aaP().getProperty("STEAL_DEVICE_KEY");
    private static final String cnK = cnN.aaP().getProperty("GUEST_TOKEN_STAGING");
    private static final String cnL = cnN.aaP().getProperty("GUEST_TOKEN_PRODUCTION");
    private static final String cnM = cnN.aaP().getProperty("LIST_MICRO_APP_NOT_SUPPORTED");
    public static final C2124a cnN = new C2124a();
    private static final Properties cni;
    private static final String cnj = cnN.aaP().getProperty("APP_CODE");
    private static final String cnk = cnN.aaP().getProperty("BRAND_ID");
    private static final String cnl = cnN.aaP().getProperty("GOOGLE_CLIENT_KEY");
    private static final String cnm = cnN.aaP().getProperty("UA_CLIENT_KEY");
    private static final String cnn = cnN.aaP().getProperty("UA_CLIENT_SECRET");
    private static final String cno = cnN.aaP().getProperty("UA_REDIRECT");
    private static final String cnp = cnN.aaP().getProperty("UP_CLIENT_SECRET");
    private static final String cnq = cnN.aaP().getProperty("UP_CLIENT_KEY");
    private static final String cnr = cnN.aaP().getProperty("UP_REDIRECT");
    private static final String cns = cnN.aaP().getProperty("WECHAT_APPID");
    private static final String cnt = cnN.aaP().getProperty("WECHAT_SECRET");
    private static final String cnu = cnN.aaP().getProperty("WEIBO_API_KEY");
    private static final String cnv = cnN.aaP().getProperty("WEIBO_REDIRECT_URL");
    private static final String cnw = cnN.aaP().getProperty("WEIBO_SCOPE");
    private static final String cnx = cnN.aaP().getProperty("SDK_ACCESS_KEY");
    private static final String cny = cnN.aaP().getProperty("FACEBOOK_APP_ID");
    private static final String cnz = cnN.aaP().getProperty("EMAIL_US");

    public static final class C2124a {
        public final java.util.Properties bo(android.content.Context r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.cjy.a.bo(android.content.Context):java.util.Properties
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 8 more
*/
            /*
            r0 = this;
            r1 = "context";
            com.fossil.esl.m11128j(r7, r1);
            r4 = new java.util.Properties;
            r4.<init>();
            r1 = "release";
            r2 = r1.hashCode();
            switch(r2) {
                case 1090594823: goto L_0x0038;
                default: goto L_0x0013;
            };
        L_0x0013:
            r1 = "debug.properties";
            r3 = r1;
            r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0044 }
            r1 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0044 }
            r5 = r7.getAssets();	 Catch:{ Exception -> 0x0044 }
            r3 = r5.open(r3);	 Catch:{ Exception -> 0x0044 }
            r5 = "UTF-8";	 Catch:{ Exception -> 0x0044 }
            r1.<init>(r3, r5);	 Catch:{ Exception -> 0x0044 }
            r1 = (java.io.Reader) r1;	 Catch:{ Exception -> 0x0044 }
            r2.<init>(r1);	 Catch:{ Exception -> 0x0044 }
            r0 = r2;	 Catch:{ Exception -> 0x0044 }
            r0 = (java.io.Reader) r0;	 Catch:{ Exception -> 0x0044 }
            r1 = r0;	 Catch:{ Exception -> 0x0044 }
            r4.load(r1);	 Catch:{ Exception -> 0x0044 }
            r2.close();	 Catch:{ Exception -> 0x0044 }
            return r4;
        L_0x0038:
            r2 = "release";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0013;
        L_0x0040:
            r1 = "production.properties";
            r3 = r1;
            goto L_0x0016;
        L_0x0044:
            r1 = move-exception;
            r2 = "XXX";
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r5 = "Exception when load properties=";
            r3 = r3.append(r5);
            r1 = r3.append(r1);
            r1 = r1.toString();
            com.misfit.frameworks.common.log.MFLogger.m12671e(r2, r1);
            goto L_0x0037;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fossil.cjy.a.bo(android.content.Context):java.util.Properties");
        }

        private C2124a() {
        }

        public final Properties aaP() {
            return cjy.cni;
        }

        public final String aaQ() {
            return cjy.cnj;
        }

        public final String aaR() {
            return cjy.cnk;
        }

        public final String aaS() {
            return cjy.cnl;
        }

        public final String aaT() {
            return cjy.cnm;
        }

        public final String aaU() {
            return cjy.cnn;
        }

        public final String aaV() {
            return cjy.cns;
        }

        public final String aaW() {
            return cjy.cnt;
        }

        public final String aaX() {
            return cjy.cnu;
        }

        public final String aaY() {
            return cjy.cnv;
        }

        public final String aaZ() {
            return cjy.cnw;
        }

        public final String aba() {
            return cjy.cnx;
        }

        public final String abb() {
            return cjy.cnA;
        }

        public final String abc() {
            return cjy.cnB;
        }

        public final String abd() {
            return cjy.cnC;
        }

        public final String abe() {
            return cjy.cnD;
        }

        public final String abf() {
            return cjy.cnE;
        }

        public final String abg() {
            return cjy.cnF;
        }

        public final String abh() {
            return cjy.cnG;
        }

        public final String abi() {
            return cjy.cnH;
        }

        public final String abj() {
            return cjy.cnI;
        }

        public final String abk() {
            return cjy.cnJ;
        }

        public final String abl() {
            return cjy.cnK;
        }

        public final String abm() {
            return cjy.cnL;
        }

        public final String abn() {
            return cjy.cnM;
        }
    }

    static {
        C2124a c2124a = cnN;
        PortfolioApp ZQ = PortfolioApp.ZQ();
        esl.m11127i(ZQ, "PortfolioApp.getInstance()");
        cni = c2124a.bo(ZQ);
    }
}
