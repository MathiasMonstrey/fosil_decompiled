package com.misfit.frameworks.buttonservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.misfit.frameworks.buttonservice.communite.CommunicateManager;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.log.MFLogger;

class ButtonService$2 extends BroadcastReceiver {
    final /* synthetic */ ButtonService this$0;

    class C46681 implements Runnable {
        C46681() {
        }

        public void run() {
            ButtonService$2.this.this$0.connectAllButton();
        }
    }

    ButtonService$2(ButtonService buttonService) {
        this.this$0 = buttonService;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            ButtonService.access$202(this.this$0, intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE));
            switch (ButtonService.access$200(this.this$0)) {
                case 10:
                    MFLogger.v(ButtonService.access$000(), "Bluetooth off");
                    for (String str : DevicePreferenceUtils.getAllActiveButtonSerial(this.this$0)) {
                        MFLogger.d(ButtonService.access$000(), "Bluetooth is off. Terminate all running sessions!!");
                        ButtonService.access$300(this.this$0, str, "Bluetooth is off. Terminate all running sessions!!");
                        CommunicateManager.getInstance(context).clearCommunicatorSessionQueue(str);
                    }
                    ButtonService.access$400(this.this$0).clear();
                    return;
                case 11:
                    MFLogger.v(ButtonService.access$000(), "Turning Bluetooth on...");
                    return;
                case 12:
                    MFLogger.v(ButtonService.access$000(), "Bluetooth on - Wait 20 seconds before connecting all devices");
                    ButtonService.access$502(this.this$0, System.currentTimeMillis());
                    new Handler(this.this$0.getMainLooper()).postDelayed(new C46681(), 20000);
                    return;
                case 13:
                    MFLogger.v(ButtonService.access$000(), "Turning Bluetooth off...");
                    return;
                default:
                    return;
            }
        }
    }
}
