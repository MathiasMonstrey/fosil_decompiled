package com.fossil;

public class ard {
    private static final String aWB = ard.class.getSimpleName();
    private static boolean aXI;

    public static synchronized void HJ() {
        synchronized (ard.class) {
            if (!aXI) {
                apr.m4184I(aon.class);
                try {
                    apr.m4184I(ana.class);
                } catch (NoClassDefFoundError e) {
                    app.m4180g(3, aWB, "Analytics module not available");
                }
                try {
                    apr.m4184I(arb.class);
                } catch (NoClassDefFoundError e2) {
                    app.m4180g(3, aWB, "Crash module not available");
                }
                try {
                    apr.m4184I(Class.forName("com.flurry.sdk.am"));
                } catch (NoClassDefFoundError e3) {
                    app.m4180g(3, aWB, "Ads module not available");
                    apr.m4184I(Class.forName("com.flurry.android.ymadlite.ad.impl.YahooAdsModule"));
                    aXI = true;
                } catch (ClassNotFoundException e4) {
                    app.m4180g(3, aWB, "Ads module not available");
                    apr.m4184I(Class.forName("com.flurry.android.ymadlite.ad.impl.YahooAdsModule"));
                    aXI = true;
                }
                try {
                    apr.m4184I(Class.forName("com.flurry.android.ymadlite.ad.impl.YahooAdsModule"));
                } catch (NoClassDefFoundError e5) {
                    app.m4180g(3, aWB, "Yahoo Ads module not available");
                    aXI = true;
                } catch (ClassNotFoundException e6) {
                    app.m4180g(3, aWB, "Yahoo Ads module not available");
                    aXI = true;
                }
                aXI = true;
            }
        }
    }
}
