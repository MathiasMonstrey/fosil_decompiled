package com.portfolio.platform.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fossil.cmi;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = BootReceiver.class.getSimpleName();
    public cmi cmS;

    public BootReceiver() {
        PortfolioApp.ZQ().aam().a(this);
    }

    public void onReceive(Context context, Intent intent) {
        MFLogger.d(TAG, "Inside " + TAG + ".BootReceiver, start hwlog sync scheduler");
        if (this.cmS != null) {
            this.cmS.abC();
        }
    }
}
