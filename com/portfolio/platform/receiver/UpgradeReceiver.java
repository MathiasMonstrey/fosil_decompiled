package com.portfolio.platform.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fossil.ckc;
import com.fossil.cnn;
import com.fossil.cnr;
import com.fossil.ctd;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UserRepository;

public class UpgradeReceiver extends BroadcastReceiver {
    private static final String TAG = UpgradeReceiver.class.getSimpleName();
    public cnr czn;
    public ckc czo;
    public NotificationsRepository czp;
    public ctd czq;
    public LandingPageRepository mLandingPageRepository;
    public MicroAppSettingRepository mMicroAppSettingRepository;
    public PresetRepository mPresetRepository;
    public UserRepository mUserRepository;

    public UpgradeReceiver() {
        PortfolioApp.ZQ().aam().a(this);
    }

    public void onReceive(Context context, Intent intent) {
        String aaf = PortfolioApp.ZQ().aaf();
        boolean gT = this.czn.gT(aaf);
        MFLogger.d(TAG, "Inside .onReceive isMigrationInProgress=" + this.czn.gT(aaf) + " for app version=" + aaf);
        if (!gT) {
            this.czn.b(true, aaf);
            cnn.abZ().aca();
        }
    }
}
