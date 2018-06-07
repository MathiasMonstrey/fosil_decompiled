package com.misfit.frameworks.buttonservice.communite.ble;

import android.os.Bundle;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;

public interface BleCommunicator$CommunicationResultCallback {
    void onCommunicatorResult(CommunicateMode communicateMode, String str, int i, Bundle bundle);

    void onGattConnectionStateChanged(String str, int i);

    void onHeartBeatDataReceived(int i, int i2, String str);

    void onHidConnectionStateChanged(String str, int i);

    void onMicroAppCancelEvent(int i, int i2, int i3, String str);

    void onMicroAppEvent(int i, int i2, int i3, String str);

    void onOtaProgressUpdated(String str, float f);

    void onPreparationCompleted(boolean z, String str);

    void onReceivedSyncData(String str, Bundle bundle);

    void onStreamingButtonEvent(int i, String str);

    void onTriggerConnectWithoutTimeout(String str);
}
