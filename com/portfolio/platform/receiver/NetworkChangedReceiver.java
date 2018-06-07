package com.portfolio.platform.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.fossil.ckc;
import com.fossil.cnm;
import com.fossil.ctf;
import com.fossil.ctf.C2295a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserRepository;

public class NetworkChangedReceiver extends BroadcastReceiver {
    private static final String TAG = NetworkChangedReceiver.class.getSimpleName();
    private boolean art = false;
    public ctf cBE;
    public ckc mUseCaseHandler;
    public UserRepository mUserRepository;

    public void onReceive(Context context, Intent intent) {
        PortfolioApp.ZQ().aam().mo1851a(this);
        boolean bB = bB(context);
        if (this.mUserRepository.getCurrentUser() != null && bB && !this.art) {
            this.art = true;
            aeS();
            cnm.abX().abY();
        }
    }

    private void aeS() {
        MFLogger.m12670d(TAG, "pushPendingData");
        this.mUseCaseHandler.m6886a(this.cBE, new C2295a(), new 1(this));
    }

    public boolean bB(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
