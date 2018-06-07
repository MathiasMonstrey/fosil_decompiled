package com.portfolio.platform.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.ExploreRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.WidgetRepository;

public class LocaleChangedReceiver extends BroadcastReceiver {
    private static final String TAG = LocaleChangedReceiver.class.getSimpleName();
    public ExploreRepository mExplorationRepository;
    public MicroAppSettingRepository mMicroAppSettingRepository;
    public WidgetRepository mWidgetRepository;

    public LocaleChangedReceiver() {
        PortfolioApp.ZQ().aam().a(this);
    }

    public void onReceive(Context context, Intent intent) {
        MFLogger.d(TAG, "Inside .onLocaledChangedReceiver, startReloadData");
        MFNetwork.getInstance(PortfolioApp.ZQ()).setLocale(PortfolioApp.ZQ().getLocale());
        this.mWidgetRepository.refreshWidget();
        this.mExplorationRepository.refreshExplore();
        if (!TextUtils.isEmpty(PortfolioApp.ZQ().aaa())) {
            this.mMicroAppSettingRepository.downloadMicroAppGallery(PortfolioApp.ZQ().aaa(), null);
        }
    }
}
