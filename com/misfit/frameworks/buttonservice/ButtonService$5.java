package com.misfit.frameworks.buttonservice;

import android.os.Bundle;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.common.log.MFLogger;

class ButtonService$5 implements Runnable {
    final /* synthetic */ ButtonService this$0;
    final /* synthetic */ BleCommunicator val$communicator;
    final /* synthetic */ UserProfile val$profile;
    final /* synthetic */ String val$serial;

    ButtonService$5(ButtonService buttonService, String str, BleCommunicator bleCommunicator, UserProfile userProfile) {
        this.this$0 = buttonService;
        this.val$serial = str;
        this.val$communicator = bleCommunicator;
        this.val$profile = userProfile;
    }

    public void run() {
        MFLogger.d(ButtonService.access$000(), "Inside " + ButtonService.access$000() + ".deviceStartSync, send broadcast start sync for " + this.val$serial);
        this.this$0.broadcastServiceBlePhaseEvent(this.val$serial, CommunicateMode.SYNC, ServiceActionResult.PROCESSING, null);
        if (!this.val$communicator.startSyncingSession(this.val$profile)) {
            MFLogger.d(ButtonService.access$000(), "Sync session can't executed.");
            this.this$0.broadcastServiceBlePhaseEvent(this.val$serial, CommunicateMode.SYNC, ServiceActionResult.UNALLOWED_ACTION, new Bundle());
        }
    }
}
