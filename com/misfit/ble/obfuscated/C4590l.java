package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build.VERSION;

public class C4590l {
    public static C4568q m15220a(Context context, BluetoothDevice bluetoothDevice) {
        if (BluetoothAdapter.getDefaultAdapter() != null && VERSION.SDK_INT >= 18) {
            return new C4569g(context, bluetoothDevice);
        }
        return null;
    }

    public static C4511m m15221b(Context context) {
        if (BluetoothAdapter.getDefaultAdapter() == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 21) {
            return C4588j.m15208r();
        }
        if (VERSION.SDK_INT >= 18) {
            return C4512c.m14990e();
        }
        return null;
    }
}
