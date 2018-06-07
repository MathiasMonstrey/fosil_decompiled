package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import com.misfit.ble.shine.ShineAdapter.ScanFailedErrorCode;
import java.util.List;

public interface C4511m {

    public interface C4591a {
        void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr);

        void onScanFailed(ScanFailedErrorCode scanFailedErrorCode);
    }

    void mo4840a(C4591a c4591a);

    void mo4841a(List<ScanFilter> list, ScanSettings scanSettings, C4591a c4591a);

    void mo4842b(C4591a c4591a);

    List<BluetoothDevice> mo4843f();
}
