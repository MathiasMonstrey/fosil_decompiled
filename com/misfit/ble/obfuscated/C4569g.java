package com.misfit.ble.obfuscated;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.misfit.ble.util.LogUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class C4569g implements C4568q {
    private static final String TAG = LogUtils.m15475b(C4569g.class);
    private final BluetoothGattCallback f1547A = new C45671(this);
    private Context mContext;
    private boolean f1548v = false;
    private boolean f1549w = false;
    private C4447n f1550x;
    private BluetoothDevice f1551y;
    private BluetoothGatt f1552z;

    class C45671 extends BluetoothGattCallback {
        final /* synthetic */ C4569g f1546B;

        C45671(C4569g c4569g) {
            this.f1546B = c4569g;
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (bluetoothGatt != null && bluetoothGatt.equals(this.f1546B.f1552z)) {
                this.f1546B.f1550x.onConnectionStateChange(bluetoothGatt.getDevice(), i, i2);
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (bluetoothGatt != null && bluetoothGatt.equals(this.f1546B.f1552z)) {
                this.f1546B.f1550x.mo4811a(i);
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGatt != null && bluetoothGatt.equals(this.f1546B.f1552z)) {
                this.f1546B.f1550x.mo4818c(C4519d.m15028a(bluetoothGattCharacteristic));
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (bluetoothGatt != null && bluetoothGatt.equals(this.f1546B.f1552z)) {
                this.f1546B.f1550x.mo4813a(C4519d.m15028a(bluetoothGattCharacteristic), i);
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (bluetoothGatt != null && bluetoothGatt.equals(this.f1546B.f1552z)) {
                this.f1546B.f1550x.mo4815b(C4519d.m15028a(bluetoothGattCharacteristic), i);
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (bluetoothGatt != null && bluetoothGatt.equals(this.f1546B.f1552z)) {
                this.f1546B.f1550x.mo4817b(C4547e.m15058a(bluetoothGattDescriptor), i);
            }
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (bluetoothGatt != null && bluetoothGatt.equals(this.f1546B.f1552z)) {
                C4546p a = C4547e.m15058a(bluetoothGattDescriptor);
                if ((this.f1546B.f1548v || this.f1546B.f1549w) && a.mo4868h().equals("00002902-0000-1000-8000-00805f9b34fb")) {
                    this.f1546B.m15118a(a, this.f1546B.f1548v);
                } else {
                    this.f1546B.f1550x.mo4814a(C4547e.m15058a(bluetoothGattDescriptor), i);
                }
            }
        }

        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (bluetoothGatt != null && bluetoothGatt.equals(this.f1546B.f1552z)) {
                this.f1546B.f1550x.mo4812a(i, i2);
            }
        }

        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            if (bluetoothGatt != null && bluetoothGatt.equals(this.f1546B.f1552z)) {
            }
        }
    }

    public C4569g(Context context, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.f1551y = bluetoothDevice;
    }

    public boolean mo4876a(C4518o c4518o, boolean z) {
        this.f1548v = z;
        this.f1549w = !z;
        if (this.f1552z == null || !this.f1552z.setCharacteristicNotification((BluetoothGattCharacteristic) c4518o.mo4857g(), z)) {
            return false;
        }
        C4546p a = c4518o.mo4856a("00002902-0000-1000-8000-00805f9b34fb");
        if (a == null) {
            return false;
        }
        if (a.setValue(z ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
            return m15124a(a);
        }
        return false;
    }

    private void m15118a(C4546p c4546p, boolean z) {
        this.f1548v = false;
        this.f1549w = false;
        this.f1550x.mo4816b(c4546p.mo4869i(), z);
    }

    public void close() {
        if (this.f1552z != null) {
            try {
                this.f1552z.close();
                this.f1552z = null;
            } catch (Throwable e) {
                LogUtils.m15477e(TAG, "Crash in core bluetooth on " + Build.MANUFACTURER + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + Build.MODEL + ", Android: " + VERSION.RELEASE);
                C4462b.m14831a(e, "SDS-1317: Crash in core bluetooth.");
            }
        }
    }

    public void disconnect() {
        if (this.f1552z != null) {
            this.f1552z.disconnect();
        }
    }

    public boolean mo4877a(boolean z, C4447n c4447n) {
        this.f1550x = c4447n;
        if (VERSION.SDK_INT >= 23) {
            this.f1552z = this.f1551y.connectGatt(this.mContext, z, this.f1547A, 2);
        } else if (VERSION.SDK_INT >= 21) {
            this.f1552z = m15115a(this.f1551y, this.mContext, z, this.f1547A, 2);
        } else {
            this.f1552z = this.f1551y.connectGatt(this.mContext, z, this.f1547A);
        }
        if (this.f1552z != null) {
            return true;
        }
        return false;
    }

    public boolean connect() {
        if (this.f1552z != null) {
            return this.f1552z.connect();
        }
        return false;
    }

    public boolean refreshDeviceCache() {
        if (this.f1552z == null) {
            return false;
        }
        try {
            BluetoothGatt bluetoothGatt = this.f1552z;
            Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
            }
        } catch (Throwable e) {
            LogUtils.m15479l(TAG, "An exception occurred while refreshing device");
            C4462b.m14831a(e, "An exception occurred while refreshing device");
        }
        return false;
    }

    public BluetoothDevice getDevice() {
        if (this.f1552z == null || this.f1551y == null || !this.f1551y.equals(this.f1552z.getDevice())) {
            return null;
        }
        return this.f1551y;
    }

    public boolean discoverServices() {
        if (this.f1552z == null) {
            return false;
        }
        return this.f1552z.discoverServices();
    }

    public List<C4563r> getServices() {
        if (this.f1552z == null) {
            return null;
        }
        List<BluetoothGattService> services = this.f1552z.getServices();
        List<C4563r> arrayList = new ArrayList();
        for (BluetoothGattService a : services) {
            arrayList.add(C4564f.m15083a(a));
        }
        return arrayList;
    }

    public C4563r mo4879c(String str) {
        if (this.f1552z == null) {
            return null;
        }
        BluetoothGattService service = this.f1552z.getService(UUID.fromString(str));
        if (service != null) {
            return C4564f.m15083a(service);
        }
        return null;
    }

    public boolean mo4875a(C4518o c4518o) {
        if (this.f1552z == null) {
            return false;
        }
        return this.f1552z.readCharacteristic((BluetoothGattCharacteristic) c4518o.mo4857g());
    }

    public boolean mo4878b(C4518o c4518o) {
        if (this.f1552z == null) {
            return false;
        }
        return this.f1552z.writeCharacteristic((BluetoothGattCharacteristic) c4518o.mo4857g());
    }

    public boolean m15124a(C4546p c4546p) {
        if (this.f1552z == null) {
            return false;
        }
        return this.f1552z.writeDescriptor((BluetoothGattDescriptor) c4546p.mo4867g());
    }

    public boolean readRemoteRssi() {
        if (this.f1552z == null) {
            return false;
        }
        return this.f1552z.readRemoteRssi();
    }

    @TargetApi(21)
    public boolean requestConnectionPriority(int i) {
        if (this.f1552z == null) {
            return false;
        }
        return this.f1552z.requestConnectionPriority(i);
    }

    private BluetoothGatt m15115a(BluetoothDevice bluetoothDevice, Context context, boolean z, BluetoothGattCallback bluetoothGattCallback, int i) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("connectGatt", new Class[]{Context.class, Boolean.TYPE, BluetoothGattCallback.class, Integer.TYPE});
            if (method == null) {
                return null;
            }
            return (BluetoothGatt) method.invoke(bluetoothDevice, new Object[]{context, Boolean.valueOf(z), bluetoothGattCallback, Integer.valueOf(i)});
        } catch (Exception e) {
            LogUtils.m15479l(TAG, "An exception occurred while connecting GATT");
            return null;
        }
    }
}
