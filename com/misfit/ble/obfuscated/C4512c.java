package com.misfit.ble.obfuscated;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import com.misfit.ble.obfuscated.C4511m.C4591a;
import com.misfit.ble.shine.ShineAdapter.ScanFailedErrorCode;
import com.misfit.ble.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@TargetApi(18)
public class C4512c implements C4511m {
    private static final String TAG = LogUtils.m15475b(C4512c.class);
    private static C4512c f1534m = null;
    private BluetoothAdapter f1535n;
    private volatile boolean f1536o = false;

    static class C4510a implements LeScanCallback {
        private static HashMap<C4591a, C4510a> f1532p = new HashMap();
        private C4591a f1533q;

        private C4510a() {
        }

        private static C4510a m14982c(C4591a c4591a) {
            C4510a c4510a = (C4510a) f1532p.get(c4591a);
            if (c4510a != null) {
                return c4510a;
            }
            c4510a = new C4510a();
            c4510a.f1533q = c4591a;
            f1532p.put(c4591a, c4510a);
            return c4510a;
        }

        private static void m14983d(C4591a c4591a) {
            f1532p.remove(c4591a);
        }

        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            this.f1533q.onLeScan(bluetoothDevice, i, bArr);
        }
    }

    public static C4512c m14990e() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return null;
        }
        if (f1534m == null) {
            f1534m = new C4512c(defaultAdapter);
        }
        return f1534m;
    }

    private C4512c(BluetoothAdapter bluetoothAdapter) {
        this.f1535n = bluetoothAdapter;
    }

    public void mo4840a(C4591a c4591a) {
        if (this.f1536o) {
            c4591a.onScanFailed(ScanFailedErrorCode.ALREADY_STARTED);
            return;
        }
        this.f1536o = true;
        if (!this.f1535n.startLeScan(C4510a.m14982c(c4591a))) {
            c4591a.onScanFailed(ScanFailedErrorCode.INTERNAL_ERROR);
        }
    }

    public void mo4841a(List<ScanFilter> list, ScanSettings scanSettings, C4591a c4591a) {
        mo4840a(c4591a);
    }

    public void mo4842b(C4591a c4591a) {
        if (this.f1535n.isEnabled()) {
            this.f1536o = false;
            try {
                this.f1535n.stopLeScan(C4510a.m14982c(c4591a));
            } catch (Throwable e) {
                LogUtils.m15477e(TAG, "Known issue on Samsung Galaxy S5, Android 5.0.x");
                C4462b.m14831a(e, "Known issue on Samsung Galaxy S5, Android 5.0.x");
            }
        }
        C4510a.m14983d(c4591a);
    }

    public List<BluetoothDevice> mo4843f() {
        return new ArrayList(this.f1535n.getBondedDevices());
    }
}
