package com.portfolio.platform.ui;

import android.os.Bundle;
import android.os.Handler;
import com.fossil.cnn;
import com.fossil.cnq;
import com.fossil.cnr;
import com.fossil.ctj;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.WidgetRepository;
import com.portfolio.platform.ui.user.SignUpEmailActivity;
import com.portfolio.platform.ui.user.WelcomeActivity;
import java.util.List;

public class SplashScreenActivity extends ctj {
    private static final String TAG = SplashScreenActivity.class.getSimpleName();
    protected final int cGe = 3000;
    protected final int cGf = 2000;
    public cnr czn;
    protected Handler handler = new Handler();
    public DeviceRepository mDeviceRepository;
    public LandingPageRepository mLandingPageRepository;
    public WidgetRepository mWidgetRepository;
    protected Runnable runnable = new 1(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash_screen);
        PortfolioApp.ZQ().bN(false);
        PortfolioApp.ZQ().aam().mo1857a(this);
        if (!this.cEF.gS(PortfolioApp.ZQ().aaf()) && !this.cEF.gT(PortfolioApp.ZQ().aaf())) {
            this.cEF.m7243b(true, PortfolioApp.ZQ().aaf());
            MFLogger.m12670d(TAG, "Inside start migration in splash screen");
            cnn.abZ().aca();
        }
    }

    protected void onResume() {
        super.onResume();
        aI(3000);
    }

    protected void aI(long j) {
        this.handler.postDelayed(this.runnable, j);
    }

    protected void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.runnable);
    }

    protected void ahj() {
        if (this.cEF.gS(PortfolioApp.ZQ().aaf())) {
            MFUser currentUser = cnq.acd().ace().getCurrentUser();
            this.mLandingPageRepository.preloadLandingPage();
            this.mWidgetRepository.preloadWidget();
            if (currentUser == null) {
                WelcomeActivity.bF(this);
            } else if (currentUser.isOnboardingComplete() || currentUser.isRegistrationComplete()) {
                List supportedSkus = this.mDeviceRepository.getSupportedSkus();
                if (supportedSkus == null || supportedSkus.isEmpty()) {
                    this.mDeviceRepository.fetchSupportedSkus();
                }
                MainActivity.bF(this);
            } else {
                SignUpEmailActivity.bF(this);
            }
            this.czn.gR(PortfolioApp.ZQ().aaf());
            finish();
            return;
        }
        MFLogger.m12670d(TAG, "Migration is not complete for appVersion=" + PortfolioApp.ZQ().aaf());
        this.handler.postDelayed(this.runnable, 2000);
        this.cEF.m7242a(true, PortfolioApp.ZQ().aaf());
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
