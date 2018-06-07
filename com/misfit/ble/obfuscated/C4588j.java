package com.misfit.ble.obfuscated;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.ParcelUuid;
import com.misfit.ble.obfuscated.C4511m.C4591a;
import com.misfit.ble.shine.ShineAdapter.ScanFailedErrorCode;
import com.misfit.ble.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(21)
public class C4588j implements C4511m {
    private static C4588j f1570M = null;
    private static final String TAG = LogUtils.m15475b(C4588j.class);
    private BluetoothAdapter f1571n;

    static class C4587a extends ScanCallback {
        private static HashMap<C4591a, C4587a> f1568p = new HashMap();
        private C4591a f1569q;

        private C4587a() {
        }

        private static C4587a m15206g(C4591a c4591a) {
            C4587a c4587a = (C4587a) f1568p.get(c4591a);
            if (c4587a != null) {
                return c4587a;
            }
            c4587a = new C4587a();
            c4587a.f1569q = c4591a;
            f1568p.put(c4591a, c4587a);
            return c4587a;
        }

        private static void m15204d(C4591a c4591a) {
            f1568p.remove(c4591a);
        }

        public void onScanResult(int i, ScanResult scanResult) {
            this.f1569q.onLeScan(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
        }

        public void onBatchScanResults(List<ScanResult> list) {
        }

        public void onScanFailed(int i) {
            this.f1569q.onScanFailed(ScanFailedErrorCode.get(i));
        }
    }

    public static C4588j m15208r() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return null;
        }
        if (f1570M == null) {
            f1570M = new C4588j(defaultAdapter);
        }
        return f1570M;
    }

    private C4588j(BluetoothAdapter bluetoothAdapter) {
        this.f1571n = bluetoothAdapter;
    }

    public void mo4840a(C4591a c4591a) {
        m15211a(null, c4591a);
    }

    public void m15211a(UUID[] uuidArr, C4591a c4591a) {
        List arrayList = new ArrayList();
        if (uuidArr != null && uuidArr.length > 0) {
            arrayList.add(new Builder().setServiceUuid(new ParcelUuid(uuidArr[0])).build());
        }
        this.f1571n.getBluetoothLeScanner().startScan(arrayList, new ScanSettings.Builder().setScanMode(2).build(), C4587a.m15206g(c4591a));
    }

    public void mo4841a(List<ScanFilter> list, ScanSettings scanSettings, C4591a c4591a) {
        this.f1571n.getBluetoothLeScanner().startScan(list, scanSettings, C4587a.m15206g(c4591a));
    }

    public void mo4842b(C4591a c4591a) {
        BluetoothLeScanner bluetoothLeScanner = this.f1571n.getBluetoothLeScanner();
        if (bluetoothLeScanner != null) {
            try {
                bluetoothLeScanner.stopScan(C4587a.m15206g(c4591a));
            } catch (Throwable e) {
                LogUtils.m15477e(TAG, "Known issue on Samsung Galaxy S5, Android 5.0.x");
                C4462b.m14831a(e, "Known issue on Samsung Galaxy S5, Android 5.0.x");
            }
        }
        C4587a.m15204d(c4591a);
    }

    public List<BluetoothDevice> mo4843f() {
        return new ArrayList(this.f1571n.getBondedDevices());
    }
}
