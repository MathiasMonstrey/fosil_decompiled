package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.shine.ShineDevice.ShineHIDConnectionCallback;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ConnectionCallback;
import com.misfit.ble.shine.ShineProfile.DataTransferCallback;
import com.misfit.ble.shine.ShineProfile.PreparationCallback;
import com.misfit.ble.shine.ShineProfile.RetrieveHardwareLogCallback;
import com.misfit.ble.shine.ShineProfile.StreamingCallback;
import com.misfit.ble.shine.ShineProfile.SyncCallback;
import com.misfit.frameworks.buttonservice.ble.ScanService.Callback;

public interface SdkCallback extends ShineHIDConnectionCallback, ConfigurationCallback, ConnectionCallback, DataTransferCallback, PreparationCallback, RetrieveHardwareLogCallback, StreamingCallback, SyncCallback, Callback {
}
