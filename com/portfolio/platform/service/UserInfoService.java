package com.portfolio.platform.service;

import android.app.IntentService;
import android.content.Intent;
import com.fossil.cnq;
import java.util.List;

public class UserInfoService extends IntentService {
    private static final String TAG = UserInfoService.class.getSimpleName();

    public UserInfoService() {
        super(TAG);
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!"com.portfolio.service.action.policy.Acceptation".equals(action)) {
                if ("com.portfolio.service.action.userInfo.Upload".equals(action) || "com.portfolio.service.action.userInfo.Upload.Pin".equals(action)) {
                    ci(intent.getBooleanExtra("com.portfolio.service.extra.userinfo.flag.pin", false));
                }
            }
        }
    }

    private void ci(boolean z) {
        List hu = cnq.acd().acq().hu("com.portfolio.service.extra.userinfo.update");
        if (hu != null && hu.size() <= 0) {
        }
    }
}
