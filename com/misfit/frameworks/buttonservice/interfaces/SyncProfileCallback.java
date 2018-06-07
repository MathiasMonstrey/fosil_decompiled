package com.misfit.frameworks.buttonservice.interfaces;

import android.os.Bundle;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.DeviceErrorState;
import com.misfit.frameworks.buttonservice.model.DeviceTask;

public interface SyncProfileCallback {
    void onFail(CommunicateMode communicateMode, int i, String str, DeviceTask deviceTask, DeviceErrorState deviceErrorState);

    void onGattConnectionStateChanged(String str, int i);

    void onSuccess(CommunicateMode communicateMode, int i, String str, Bundle bundle);
}
