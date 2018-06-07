package com.portfolio.platform.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fossil.cml;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.buddychallenge.BCHeartbeatStep;
import java.util.Calendar;

class MFDeviceService$6 extends BroadcastReceiver {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$6(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            intent.getStringExtra(Constants.SERIAL_NUMBER);
            int intExtra = intent.getIntExtra(Constants.DAILY_STEPS, 0);
            int intExtra2 = intent.getIntExtra(Constants.DAILY_POINTS, 0);
            long longExtra = intent.getLongExtra(Constants.UPDATED_TIME, Calendar.getInstance().getTimeInMillis());
            BCHeartbeatStep bCHeartbeatStep = new BCHeartbeatStep();
            bCHeartbeatStep.setHeartbeatSteps(intExtra);
            bCHeartbeatStep.setLastHeartbeatStamp(longExtra);
            cml.abG().a(bCHeartbeatStep);
            MFLogger.d(MFDeviceService.access$500(), ".saveSyncResult - Update heartbeat step by heartbeat receiver");
            MFLogger.i(MFDeviceService.access$500(), "Heartbeat data received, dailySteps=" + intExtra + ", dailyPoints=" + intExtra2 + ", receivedTime=" + longExtra);
        }
    }
}
