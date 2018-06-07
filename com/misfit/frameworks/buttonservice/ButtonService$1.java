package com.misfit.frameworks.buttonservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.Calendar;
import java.util.TimeZone;

class ButtonService$1 extends BroadcastReceiver {
    final /* synthetic */ ButtonService this$0;

    ButtonService$1(ButtonService buttonService) {
        this.this$0 = buttonService;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.TIME_SET".equals(action) || "android.intent.action.TIMEZONE_CHANGED".equals(action)) {
            MFLogger.d(ButtonService.access$000(), "Inside .timeZoneChangeReceiver");
            for (String action2 : DevicePreferenceUtils.getAllActiveButtonSerial(this.this$0)) {
                ButtonService.access$100(this.this$0, action2);
            }
        } else if ("android.intent.action.TIME_TICK".equals(action2)) {
            TimeZone timeZone = TimeZone.getDefault();
            try {
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(Calendar.getInstance().getTimeInMillis() - 60000);
                if (timeZone.getOffset(Calendar.getInstance().getTimeInMillis()) != timeZone.getOffset(instance.getTimeInMillis())) {
                    MFLogger.d(ButtonService.access$000(), "Inside .timeZoneChangeReceiver - DST change");
                    for (String action22 : DevicePreferenceUtils.getAllActiveButtonSerial(this.this$0)) {
                        ButtonService.access$100(this.this$0, action22);
                    }
                }
            } catch (Exception e) {
                MFLogger.e(ButtonService.access$000(), ".timeZoneChangeReceiver - ex=" + e.toString());
            }
        }
    }
}
