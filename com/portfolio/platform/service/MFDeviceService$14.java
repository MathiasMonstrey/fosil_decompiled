package com.portfolio.platform.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.DeviceErrorState;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.ArrayList;
import java.util.Calendar;

class MFDeviceService$14 extends BroadcastReceiver {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$14(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void onReceive(Context context, Intent intent) {
        CommunicateMode communicateMode = CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())];
        String stringExtra = intent.getStringExtra(Constants.SERIAL_NUMBER);
        int intExtra = intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1);
        int intExtra2 = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, DeviceErrorState.UNKNOWN_ERROR.getValue());
        ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra(ButtonService.LIST_ERROR_STATE);
        if (integerArrayListExtra == null) {
            integerArrayListExtra = new ArrayList();
        }
        Bundle extras = intent.getExtras();
        MFDeviceService$a mFDeviceService$a = new MFDeviceService$a(communicateMode, stringExtra, intExtra, intExtra2, integerArrayListExtra, extras, Calendar.getInstance().getTimeInMillis(), intent);
        MFDeviceService.g(this.cDk).put(communicateMode, mFDeviceService$a);
        MFLogger.d(MFDeviceService.access$500(), "Inside .bleActionServiceReceiver phase " + communicateMode + " result " + intExtra + " extra info " + extras);
        MFDeviceService.a(this.cDk, context, mFDeviceService$a);
    }
}
