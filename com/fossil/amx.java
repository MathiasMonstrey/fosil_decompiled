package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.j256.ormlite.stmt.query.SimpleComparison;

public final class amx extends BroadcastReceiver {
    private static final String aWB = amx.class.getSimpleName();

    public final void onReceive(Context context, Intent intent) {
        app.m4180g(4, aWB, "Received an Install notification of " + intent.getAction());
        String string = intent.getExtras().getString("referrer");
        app.m4180g(4, aWB, "Received an Install referrer of " + string);
        if (string == null || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            app.m4180g(5, aWB, "referrer is null");
            return;
        }
        if (!string.contains(SimpleComparison.EQUAL_TO_OPERATION)) {
            app.m4180g(4, aWB, "referrer is before decoding: " + string);
            string = aqv.cB(string);
            app.m4180g(4, aWB, "referrer is: " + string);
        }
        new anb(context).cg(string);
    }
}
