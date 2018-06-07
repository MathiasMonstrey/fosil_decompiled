package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.misfit.ble.util.LogUtils;
import java.util.ArrayList;

public class C4580h {
    private static C4580h f1555C;
    private static final String TAG = LogUtils.m15475b(C4580h.class);
    private Context f1556D;

    public static void m15155a(Context context) {
        if (f1555C == null) {
            f1555C = new C4580h(context);
        }
        f1555C.f1556D = context;
    }

    public static C4580h m15156j() {
        return f1555C;
    }

    private C4580h(Context context) {
        this.f1556D = context;
    }

    public ArrayList<BluetoothDevice> m15157k() {
        ArrayList<BluetoothDevice> arrayList = new ArrayList();
        if (VERSION.SDK_INT < 18) {
            return arrayList;
        }
        for (BluetoothDevice bluetoothDevice : ((BluetoothManager) this.f1556D.getSystemService("bluetooth")).getConnectedDevices(7)) {
            if (bluetoothDevice.getType() == 2) {
                arrayList.add(bluetoothDevice);
            }
        }
        return arrayList;
    }

    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        if (VERSION.SDK_INT < 18) {
            return -1;
        }
        return ((BluetoothManager) this.f1556D.getSystemService("bluetooth")).getConnectionState(bluetoothDevice, 7);
    }
}
