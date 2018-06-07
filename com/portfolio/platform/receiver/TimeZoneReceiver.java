package com.portfolio.platform.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.fossil.cml;
import java.util.TimeZone;

public class TimeZoneReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Object action = intent.getAction();
        if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.TIMEZONE_CHANGED") && !TextUtils.isEmpty(intent.getStringExtra("time-zone"))) {
            cml.abG().i(-1, (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000) / 60, "");
        }
    }
}
