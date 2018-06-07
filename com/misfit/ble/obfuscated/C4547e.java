package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.HashMap;

public class C4547e implements C4546p {
    private static HashMap<BluetoothGattDescriptor, C4547e> f1541r = new HashMap();
    private BluetoothGattDescriptor f1542t;

    public static C4547e m15058a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        C4547e c4547e = (C4547e) f1541r.get(bluetoothGattDescriptor);
        if (c4547e != null) {
            return c4547e;
        }
        c4547e = new C4547e(bluetoothGattDescriptor);
        f1541r.put(bluetoothGattDescriptor, c4547e);
        return c4547e;
    }

    private C4547e(BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.f1542t = bluetoothGattDescriptor;
    }

    public Object mo4867g() {
        return this.f1542t;
    }

    public boolean equals(Object obj) {
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        return this.f1542t.equals(((C4547e) obj).f1542t);
    }

    public C4518o mo4869i() {
        BluetoothGattCharacteristic characteristic = this.f1542t.getCharacteristic();
        if (characteristic == null) {
            return null;
        }
        return C4519d.m15028a(characteristic);
    }

    public String mo4868h() {
        return this.f1542t.getUuid().toString();
    }

    public boolean setValue(byte[] bArr) {
        return this.f1542t.setValue(bArr);
    }
}
