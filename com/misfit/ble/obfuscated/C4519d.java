package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.HashMap;
import java.util.UUID;

public class C4519d implements C4518o {
    private static HashMap<BluetoothGattCharacteristic, C4519d> f1539r = new HashMap();
    private BluetoothGattCharacteristic f1540s;

    public static C4519d m15028a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        C4519d c4519d = (C4519d) f1539r.get(bluetoothGattCharacteristic);
        if (c4519d != null) {
            return c4519d;
        }
        c4519d = new C4519d(bluetoothGattCharacteristic);
        f1539r.put(bluetoothGattCharacteristic, c4519d);
        return c4519d;
    }

    private C4519d(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f1540s = bluetoothGattCharacteristic;
    }

    public Object mo4857g() {
        return this.f1540s;
    }

    public boolean equals(Object obj) {
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        return this.f1540s.equals(((C4519d) obj).f1540s);
    }

    public C4546p mo4856a(String str) {
        BluetoothGattDescriptor descriptor = this.f1540s.getDescriptor(UUID.fromString(str));
        if (descriptor == null) {
            return null;
        }
        return C4547e.m15058a(descriptor);
    }

    public String mo4860h() {
        return this.f1540s.getUuid().toString();
    }

    public boolean setValue(byte[] bArr) {
        return this.f1540s.setValue(bArr);
    }

    public byte[] getValue() {
        return this.f1540s.getValue();
    }

    public String getStringValue(int i) {
        return this.f1540s.getStringValue(i);
    }
}
