package com.portfolio.platform.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fossil.clx.e;
import com.fossil.clx.f;
import com.portfolio.platform.PortfolioApp;

public class BluetoothReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1)) {
                case 10:
                    PortfolioApp.cL(new e());
                    return;
                case 12:
                    PortfolioApp.cL(new f());
                    return;
                default:
                    return;
            }
        }
    }
}
