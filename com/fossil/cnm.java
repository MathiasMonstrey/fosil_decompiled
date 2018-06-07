package com.fossil;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.service.UploadLogServiceIntentService;

public class cnm {
    private static final String TAG = cnm.class.getSimpleName();
    private static cnm czl;

    private cnm() {
    }

    public static synchronized cnm abX() {
        cnm com_fossil_cnm;
        synchronized (cnm.class) {
            if (czl == null) {
                czl = new cnm();
            }
            com_fossil_cnm = czl;
        }
        return com_fossil_cnm;
    }

    public void abY() {
        UploadLogServiceIntentService.bE(PortfolioApp.ZQ());
    }

    public void m7220a(String str, int i, CommunicateMode communicateMode) {
        MFLogger.m12670d(TAG, "endLogFinishedAndPushLogToServer - serial=" + str + ", resultCode=" + i + ", communicateMode=" + communicateMode);
        UploadLogServiceIntentService.a(PortfolioApp.ZQ(), PortfolioApp.ZQ().m12686a(communicateMode, str), str, i, communicateMode);
    }

    public void m7221a(String str, int i, CommunicateMode communicateMode, int i2) {
        MFLogger.m12670d(TAG, "endLogFinishedAndPushLogToServerByLogId - serial=" + str + ", resultCode=" + i + ", communicateMode=" + communicateMode + ", logId=" + i2);
        if (i2 <= 0) {
            MFLogger.m12671e(TAG, "endLogFinishedAndPushLogToServerByLogId - WRONG LOG ID !!!");
        } else {
            UploadLogServiceIntentService.a(PortfolioApp.ZQ(), i2, str, i, communicateMode);
        }
    }
}
