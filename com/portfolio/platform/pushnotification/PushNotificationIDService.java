package com.portfolio.platform.pushnotification;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

public class PushNotificationIDService extends FirebaseInstanceIdService {
    private static final String TAG = PushNotificationIDService.class.getSimpleName();

    public void MD() {
        super.MD();
        String token = FirebaseInstanceId.VW().getToken();
        MFLogger.d(TAG, "Refreshed token: " + token);
        PortfolioApp.ZQ().fQ(token);
        PortfolioApp.ZQ().aae();
    }
}
