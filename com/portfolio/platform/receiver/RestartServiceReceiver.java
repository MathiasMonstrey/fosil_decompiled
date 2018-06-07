package com.portfolio.platform.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.misfit.frameworks.buttonservice.ButtonService;

public class RestartServiceReceiver extends BroadcastReceiver {
    private static final String TAG = RestartServiceReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "Inside ---onReceive RestartServiceReceiver");
        context.startService(new Intent(context.getApplicationContext(), ButtonService.class));
    }
}
