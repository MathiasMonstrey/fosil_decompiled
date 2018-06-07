package com.misfit.ble.shine;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import com.misfit.ble.obfuscated.C4511m;
import com.misfit.ble.obfuscated.C4511m.C4591a;
import com.misfit.ble.obfuscated.C4580h;
import com.misfit.ble.obfuscated.C4586i;
import com.misfit.ble.obfuscated.C4586i.C4585b;
import com.misfit.ble.obfuscated.C4590l;
import com.misfit.ble.obfuscated.C4592s;
import com.misfit.ble.obfuscated.an;
import com.misfit.ble.obfuscated.bu;
import com.misfit.ble.obfuscated.cd;
import com.misfit.ble.obfuscated.ce;
import com.misfit.ble.obfuscated.hb;
import com.misfit.ble.obfuscated.hf;
import com.misfit.ble.setting.SDKSetting;
import com.misfit.ble.setting.eventmapping.GoalTrackingEventMapping;
import com.misfit.ble.shine.log.LogManager;
import com.misfit.ble.util.LogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ShineAdapter {
    private static final String TAG = LogUtils.m15475b(ShineAdapter.class);
    private static ShineAdapter ex;
    private volatile boolean eA = false;
    private C4511m ey;
    private volatile boolean ez = false;

    public interface ShineRetrieveCallback {
        void onConnectedShinesRetrieved(List<ShineDevice> list);
    }

    public enum ScanFailedErrorCode {
        ALREADY_STARTED(1),
        REGISTRATION_FAILED(2),
        INTERNAL_ERROR(3),
        UNSUPPORTED(4);
        
        private static final Map<Integer, ScanFailedErrorCode> aD = null;
        private int eo;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(ScanFailedErrorCode.class).iterator();
            while (it.hasNext()) {
                ScanFailedErrorCode scanFailedErrorCode = (ScanFailedErrorCode) it.next();
                aD.put(Integer.valueOf(scanFailedErrorCode.eo), scanFailedErrorCode);
            }
        }

        private ScanFailedErrorCode(int i) {
            this.eo = i;
        }

        public static ScanFailedErrorCode get(int i) {
            return (ScanFailedErrorCode) aD.get(Integer.valueOf(i));
        }
    }

    public interface ShineScanCallback {
        void onScanFailed(ScanFailedErrorCode scanFailedErrorCode);

        void onScanResult(ShineDevice shineDevice, int i);
    }

    static class C4610a implements C4591a {
        private static HashMap<ShineScanCallback, C4610a> f1600p = new HashMap();
        private ShineScanCallback eF;
        private ce eG;

        private C4610a() {
        }

        private static C4610a m15257a(ShineScanCallback shineScanCallback) {
            C4610a c4610a = (C4610a) f1600p.get(shineScanCallback);
            if (c4610a != null) {
                return c4610a;
            }
            c4610a = new C4610a();
            c4610a.eF = shineScanCallback;
            f1600p.put(shineScanCallback, c4610a);
            return c4610a;
        }

        private static C4610a m15258b(ShineScanCallback shineScanCallback) {
            return (C4610a) f1600p.get(shineScanCallback);
        }

        private static void m15259c(ShineScanCallback shineScanCallback) {
            f1600p.remove(shineScanCallback);
        }

        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            String name = bluetoothDevice.getName();
            String str = null;
            if (C4610a.m15263f(bArr)) {
                str = ShineAdapter.m15264a(bArr);
                if (str != null) {
                    ShineDevice a = an.m14697a(bluetoothDevice, str);
                    if (a != null) {
                        a.m15284S();
                        a.m15289g(str);
                        this.eF.onScanResult(a, i);
                    }
                }
            }
            if (this.eG != null) {
                this.eG.m15008a(name, bluetoothDevice.getAddress(), str, i, bArr);
            }
        }

        public void onScanFailed(ScanFailedErrorCode scanFailedErrorCode) {
            this.eF.onScanFailed(scanFailedErrorCode);
        }

        private static boolean m15263f(byte[] bArr) {
            return ShineAdapter.m15269c(bArr).contains(bu.iS);
        }
    }

    public static ShineAdapter getDefaultAdapter(Context context) {
        if (context == null) {
            return null;
        }
        if (ex == null) {
            C4511m b = C4590l.m15221b(context);
            if (b != null) {
                ex = new ShineAdapter(b);
            }
        }
        return ex;
    }

    private ShineAdapter(C4511m c4511m) {
        this.ey = c4511m;
    }

    public boolean isEnabled() {
        return BluetoothAdapter.getDefaultAdapter().isEnabled();
    }

    public void startScanning(ShineScanCallback shineScanCallback, String str) throws IllegalStateException, IllegalArgumentException {
        SDKSetting.validateSettings();
        if (!hf.dp()) {
            throw new IllegalStateException("Bluetooth permission is not supported!");
        } else if (hf.dq()) {
            if (!hf.dr()) {
                LogUtils.m15479l(TAG, "Location Service was disabled. Bluetooth low energy scanning might not work on several Android 6.0 devices.");
            } else if (!isEnabled()) {
                throw new IllegalStateException("Bluetooth is not enabled!");
            } else if (shineScanCallback == null) {
                throw new IllegalArgumentException("Callback must not be null!");
            }
            C4610a d = C4610a.m15257a(shineScanCallback);
            if (d.eG == null) {
                d.eG = new ce();
                d.eG.m15009g(shineScanCallback);
                d.eG.addDataCollectionTag("scan");
                d.eG.addDataCollectionTag(str);
                d.eG.addDataCollectionTag(C4592s.m15223B());
            }
            this.ey.mo4840a(d);
        } else {
            throw new IllegalStateException("Location permission is not supported!");
        }
    }

    public void startScanning(ScanSettings scanSettings, ShineScanCallback shineScanCallback, String str) throws IllegalStateException, IllegalArgumentException {
        SDKSetting.validateSettings();
        if (!hf.dp()) {
            throw new IllegalStateException("Bluetooth permission is not supported!");
        } else if (hf.dq()) {
            if (!hf.dr()) {
                LogUtils.m15479l(TAG, "Location Service was disabled. Bluetooth low energy scanning might not work on several Android 6.0 devices.");
            } else if (!isEnabled()) {
                throw new IllegalStateException("Bluetooth is not enabled!");
            } else if (shineScanCallback == null) {
                throw new IllegalArgumentException("Callback must not be null!");
            }
            C4610a d = C4610a.m15257a(shineScanCallback);
            if (d.eG == null) {
                d.eG = new ce();
                d.eG.m15009g(shineScanCallback);
                d.eG.addDataCollectionTag("scan");
                d.eG.addDataCollectionTag(str);
                d.eG.addDataCollectionTag(C4592s.m15223B());
            }
            this.ey.mo4841a(new ArrayList(), scanSettings, d);
        } else {
            throw new IllegalStateException("Location permission is not supported!");
        }
    }

    public void stopScanning(ShineScanCallback shineScanCallback) throws IllegalArgumentException {
        if (shineScanCallback == null) {
            throw new IllegalArgumentException("Callback must not be null!");
        }
        C4610a e = C4610a.m15258b(shineScanCallback);
        if (e != null && e.eG != null) {
            this.ey.mo4842b(e);
            C4610a.m15259c(shineScanCallback);
            e.eG.m15010h(shineScanCallback);
            LogManager.bA().m15448a(e.eG);
            e.eG.m15007R();
            an.m14695W();
        }
    }

    public void getConnectedShines(final ShineRetrieveCallback shineRetrieveCallback, String str) throws IllegalArgumentException {
        SDKSetting.validateSettings();
        if (shineRetrieveCallback == null) {
            throw new IllegalArgumentException("Callback must not be null.");
        } else if (!this.ez) {
            this.ez = true;
            final Set hashSet = new HashSet();
            Collection gattConnectedShines = getGattConnectedShines(str);
            if (gattConnectedShines != null) {
                hashSet.addAll(gattConnectedShines);
            }
            gattConnectedShines = getBondedShines(str);
            if (gattConnectedShines != null) {
                hashSet.addAll(gattConnectedShines);
            }
            getHIDConnectedShines(new ShineRetrieveCallback(this) {
                final /* synthetic */ ShineAdapter eD;

                public void onConnectedShinesRetrieved(List<ShineDevice> list) {
                    if (list != null) {
                        hashSet.addAll(list);
                    }
                    this.eD.ez = false;
                    shineRetrieveCallback.onConnectedShinesRetrieved(new ArrayList(hashSet));
                }
            }, str);
        }
    }

    public void getHIDConnectedShines(final ShineRetrieveCallback shineRetrieveCallback, String str) throws IllegalArgumentException {
        SDKSetting.validateSettings();
        if (shineRetrieveCallback == null) {
            throw new IllegalArgumentException("Callback must not be null.");
        } else if (!this.eA) {
            this.eA = true;
            final cd cdVar = new cd();
            cdVar.m15005a(shineRetrieveCallback, C4592s.m15230z(), "startRetrievingHIDConnectedShines");
            cdVar.addDataCollectionTag("retrieveHID");
            cdVar.addDataCollectionTag(str);
            cdVar.addDataCollectionTag(C4592s.m15223B());
            C4586i.m15193l().m15201a(new C4585b(this) {
                final /* synthetic */ ShineAdapter eD;

                public void mo4897a(List<BluetoothDevice> list) {
                    for (BluetoothDevice d : list) {
                        ShineDevice d2 = an.m14699d(d);
                        if (d2 != null) {
                            cdVar.m15006a(d2.getName(), d2.getAddress(), d2.getSerialNumber(), d2.m15287V(), d2.getHIDConnectionState(), d2.getBondState(), "retrieveHIDConnectedShineResult");
                        }
                    }
                    cdVar.m15004a(shineRetrieveCallback, "stopRetrievingHIDConnectedShines");
                    LogManager.bA().m15447a(cdVar);
                    cdVar.m15003R();
                    this.eD.eA = false;
                    shineRetrieveCallback.onConnectedShinesRetrieved(this.eD.m15271e((List) list));
                }
            });
        }
    }

    public List<ShineDevice> getGattConnectedShines(String str) {
        SDKSetting.validateSettings();
        List<BluetoothDevice> k = C4580h.m15156j().m15157k();
        cd cdVar = new cd();
        cdVar.m15005a(null, C4592s.m15230z(), "startRetrievingGattConnectedShines");
        cdVar.addDataCollectionTag("retrieveGatt");
        cdVar.addDataCollectionTag(str);
        cdVar.addDataCollectionTag(C4592s.m15223B());
        for (BluetoothDevice d : k) {
            ShineDevice d2 = an.m14699d(d);
            if (d2 != null) {
                cdVar.m15006a(d2.getName(), d2.getAddress(), d2.getSerialNumber(), d2.m15287V(), d2.getHIDConnectionState(), d2.getBondState(), "retrieveGattConnectedShineResult");
            }
        }
        cdVar.m15004a(null, "stopRetrievingGattConnectedShines");
        LogManager.bA().m15447a(cdVar);
        cdVar.m15003R();
        return m15271e((List) k);
    }

    public ShineDevice buildShineDevice(String str) {
        SDKSetting.validateSettings();
        return an.m14698b(str, null);
    }

    public List<ShineDevice> getBondedShines(String str) {
        SDKSetting.validateSettings();
        List<BluetoothDevice> f = this.ey.mo4843f();
        cd cdVar = new cd();
        cdVar.m15005a(null, C4592s.m15230z(), "startRetrievingBondedShines");
        cdVar.addDataCollectionTag("retrieveBonded");
        cdVar.addDataCollectionTag(str);
        cdVar.addDataCollectionTag(C4592s.m15223B());
        for (BluetoothDevice d : f) {
            ShineDevice d2 = an.m14699d(d);
            if (d2 != null) {
                cdVar.m15006a(d2.getName(), d2.getAddress(), d2.getSerialNumber(), d2.m15287V(), d2.getHIDConnectionState(), d2.getBondState(), "retrieveBondedShineResult");
            }
        }
        cdVar.m15004a(null, "stopRetrievingBondedShines");
        LogManager.bA().m15447a(cdVar);
        cdVar.m15003R();
        return m15271e((List) f);
    }

    private List<ShineDevice> m15271e(List<BluetoothDevice> list) {
        List arrayList = new ArrayList();
        for (BluetoothDevice bluetoothDevice : list) {
            String name = bluetoothDevice.getName();
            if (name != null && (m15273f(name) || name.length() == 8)) {
                ShineDevice d = an.m14699d(bluetoothDevice);
                if (d != null) {
                    d.m15284S();
                    arrayList.add(d);
                }
            }
        }
        return arrayList;
    }

    private boolean m15273f(String str) {
        List<String> z = C4592s.m15230z();
        if (z == null || z.isEmpty()) {
            return true;
        }
        for (String toLowerCase : z) {
            if (str.toLowerCase().contains(toLowerCase.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private static String m15264a(byte[] bArr) {
        byte[] b = m15268b(bArr);
        if (b != null) {
            return new String(b);
        }
        return null;
    }

    private static byte[] m15268b(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            byte b = bArr[i];
            if (b != (byte) 0) {
                short c = hb.m15163c(bArr[i2]);
                if (c == (short) 0) {
                    break;
                } else if (c == GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER && b >= (byte) 13) {
                    return Arrays.copyOfRange(bArr, (i2 + 1) + 2, ((i2 + 1) + 2) + 10);
                } else {
                    i = b + i2;
                }
            } else {
                break;
            }
        }
        return null;
    }

    private static List<String> m15269c(byte[] bArr) {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            i = bArr[i] & 255;
            if (i == 0) {
                break;
            }
            short c = hb.m15163c(bArr[i2]);
            if ((short) 2 <= c && c <= (short) 7) {
                arrayList.add(hb.m15160F(Arrays.copyOfRange(bArr, i2 + 1, i2 + i)));
            }
            i += i2;
        }
        return arrayList;
    }
}
