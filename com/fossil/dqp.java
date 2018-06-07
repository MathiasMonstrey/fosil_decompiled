package com.fossil;

import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.enums.FossilBrand;

public class dqp {
    private static final String TAG = dqp.class.getSimpleName();

    public static int ji(String str) {
        PortfolioApp ZQ = PortfolioApp.ZQ();
        String packageName = ZQ.getPackageName();
        String str2 = ".debug";
        str2 = ".staging";
        FossilBrand aag = ZQ.aag();
        if (packageName.contains(".debug")) {
            packageName = packageName.replace(".debug", "");
            if (aag == FossilBrand.FOSSIL) {
                packageName = packageName + ".debug";
            }
        } else if (packageName.contains(".staging")) {
            packageName = packageName.replace(".staging", "");
            if (aag == FossilBrand.FOSSIL) {
                packageName = packageName + ".debug";
            }
        }
        MFLogger.m12670d(TAG, "supportEmailMagic - packageName=" + packageName);
        packageName = dqy.jt(packageName + str);
        if (packageName.equals(cjy.cnN.abf()) || packageName.equals(cjy.cnN.abh())) {
            return 1;
        }
        if (packageName.equals(cjy.cnN.abg()) || packageName.equals(cjy.cnN.abi())) {
            return 2;
        }
        return 0;
    }

    public static String lx(int i) {
        return m9392a(PortfolioApp.ZQ(), i);
    }

    public static String m9392a(PortfolioApp portfolioApp, int i) {
        boolean z = true;
        int adm = portfolioApp.YV().adm();
        if (adm != 0) {
            if (adm != 1) {
                z = false;
            }
        } else if ("release".equalsIgnoreCase("release")) {
            z = false;
        }
        MFLogger.m12670d(TAG, "getBackendUrl - type=" + i + ", isUsingStagingUrl= " + z);
        switch (i) {
            case 0:
                if (z) {
                    return cjy.cnN.abb();
                }
                return cjy.cnN.abd();
            case 1:
                if (z) {
                    return cjy.cnN.abc();
                }
                return cjy.cnN.abe();
            case 2:
                return cjy.cnN.abj();
            case 3:
                return cjy.cnN.abk();
            default:
                return "";
        }
    }

    public static String aui() {
        boolean z = true;
        int adm = PortfolioApp.ZQ().YV().adm();
        if (adm != 0) {
            if (adm != 1) {
                z = false;
            }
        } else if ("release".equalsIgnoreCase("release")) {
            z = false;
        }
        MFLogger.m12670d(TAG, "getGuestToken - isStagingBuild= " + z);
        if (z) {
            return cjy.cnN.abl();
        }
        return cjy.cnN.abm();
    }
}
