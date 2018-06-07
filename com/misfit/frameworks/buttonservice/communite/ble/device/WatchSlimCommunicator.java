package com.misfit.frameworks.buttonservice.communite.ble.device;

import android.content.Context;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.CommunicationResultCallback;
import com.misfit.frameworks.buttonservice.model.Device;
import com.misfit.frameworks.buttonservice.model.SlimDevice;

public class WatchSlimCommunicator extends WatchCommunicator {
    public WatchSlimCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        super(context, str, str2, communicationResultCallback);
    }

    protected Device getDeviceType() {
        return new SlimDevice();
    }
}
