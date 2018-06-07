package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class C4564f implements C4563r {
    private static HashMap<BluetoothGattService, C4564f> f1544r = new HashMap();
    private BluetoothGattService f1545u;

    public static C4564f m15083a(BluetoothGattService bluetoothGattService) {
        C4564f c4564f = (C4564f) f1544r.get(bluetoothGattService);
        if (c4564f != null) {
            return c4564f;
        }
        c4564f = new C4564f(bluetoothGattService);
        f1544r.put(bluetoothGattService, c4564f);
        return c4564f;
    }

    private C4564f(BluetoothGattService bluetoothGattService) {
        this.f1545u = bluetoothGattService;
    }

    public boolean equals(Object obj) {
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        return this.f1545u.equals(((C4564f) obj).f1545u);
    }

    public String mo4874h() {
        return this.f1545u.getUuid().toString();
    }

    public List<C4518o> getCharacteristics() {
        List<BluetoothGattCharacteristic> characteristics = this.f1545u.getCharacteristics();
        List<C4518o> arrayList = new ArrayList();
        for (BluetoothGattCharacteristic a : characteristics) {
            arrayList.add(C4519d.m15028a(a));
        }
        return arrayList;
    }

    public C4518o mo4872b(String str) {
        BluetoothGattCharacteristic characteristic = this.f1545u.getCharacteristic(UUID.fromString(str));
        if (characteristic == null) {
            return null;
        }
        return C4519d.m15028a(characteristic);
    }
}
