package com.misfit.frameworks.buttonservice.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BluetoothUtils {
    public static boolean isBluetoothEnable() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static List<BluetoothDevice> getBondedDevices() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return new ArrayList();
        }
        Collection bondedDevices = defaultAdapter.getBondedDevices();
        if (bondedDevices != null) {
            return new ArrayList(bondedDevices);
        }
        return new ArrayList();
    }
}
