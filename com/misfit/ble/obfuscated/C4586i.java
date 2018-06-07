package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.misfit.ble.util.LogUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C4586i {
    private static C4586i f1561E;
    private static final String TAG = LogUtils.m15475b(C4586i.class);
    private Context f1562D;
    private BluetoothProfile f1563F;
    private ServiceListener f1564G = new C45811(this);
    private BroadcastReceiver f1565H = new C45822(this);
    private int f1566I;
    private HashMap<String, C4584a> f1567J = new HashMap();
    private Handler mHandler;

    class C45811 implements ServiceListener {
        final /* synthetic */ C4586i f1557K;

        C45811(C4586i c4586i) {
            this.f1557K = c4586i;
        }

        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            LogUtils.m15476d(C4586i.TAG, "BluetoothProfile - onServiceConnected - profile: " + i);
            this.f1557K.f1563F = bluetoothProfile;
        }

        public void onServiceDisconnected(int i) {
            LogUtils.m15476d(C4586i.TAG, "BluetoothProfile - onServiceDisconnected - profile: " + i);
            this.f1557K.f1563F = null;
        }
    }

    class C45822 extends BroadcastReceiver {
        final /* synthetic */ C4586i f1558K;

        C45822(C4586i c4586i) {
            this.f1558K = c4586i;
        }

        public void onReceive(Context context, Intent intent) {
            int intExtra;
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
                intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                if (intExtra2 != 10 && intExtra == 10) {
                    for (String str : this.f1558K.f1567J.keySet()) {
                        C4584a c4584a = (C4584a) this.f1558K.f1567J.get(str);
                        if (c4584a != null) {
                            c4584a.mo4900a(null, 0);
                        }
                    }
                }
            } else if (intent.getAction().equals("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED")) {
                intExtra = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
                int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                switch (intExtra3) {
                    case 0:
                        LogUtils.m15478k(C4586i.TAG, "HID Disconnected " + bluetoothDevice.getAddress() + " , prev: " + intExtra);
                        break;
                    case 1:
                        LogUtils.m15478k(C4586i.TAG, "HID Connecting " + bluetoothDevice.getAddress() + ", prev: " + intExtra);
                        break;
                    case 2:
                        LogUtils.m15478k(C4586i.TAG, "HID Connected " + bluetoothDevice.getAddress() + " prev: " + intExtra);
                        break;
                    case 3:
                        LogUtils.m15478k(C4586i.TAG, "HID Disconnecting " + bluetoothDevice.getAddress() + " , prev: " + intExtra);
                        break;
                }
                C4584a c4584a2 = (C4584a) this.f1558K.f1567J.get(bluetoothDevice.getAddress());
                if (c4584a2 != null) {
                    c4584a2.mo4900a(bluetoothDevice, intExtra3);
                }
            }
        }
    }

    public interface C4584a {
        void mo4900a(BluetoothDevice bluetoothDevice, int i);
    }

    public interface C4585b {
        void mo4897a(List<BluetoothDevice> list);
    }

    public static void m15190a(Context context) {
        if (f1561E == null) {
            f1561E = new C4586i(context);
        }
        f1561E.f1562D = context;
    }

    public static C4586i m15193l() {
        return f1561E;
    }

    private C4586i(Context context) {
        this.f1562D = context;
        m15194m();
        m15196o();
    }

    protected void finalize() throws Throwable {
        m15195n();
        m15197p();
        super.finalize();
    }

    private void m15194m() {
        int profileConnectionState = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(4);
        LogUtils.m15476d(TAG, "setUpHIDProxy - profileConnectionState: " + profileConnectionState + ", getProxy: " + BluetoothAdapter.getDefaultAdapter().getProfileProxy(this.f1562D, this.f1564G, 4));
    }

    private void m15195n() {
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(4, this.f1563F);
    }

    private void m15196o() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.f1562D.registerReceiver(this.f1565H, intentFilter);
    }

    private void m15197p() {
        this.f1562D.unregisterReceiver(this.f1565H);
    }

    public void m15201a(C4585b c4585b) {
        this.f1566I = 5;
        if (this.mHandler == null) {
            this.mHandler = hd.m15181do();
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        m15192b(c4585b);
    }

    private void m15192b(final C4585b c4585b) {
        if (this.f1563F != null) {
            c4585b.mo4897a(this.f1563F.getConnectedDevices());
        } else if (this.f1566I > 0) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ C4586i f1559K;

                public void run() {
                    this.f1559K.m15192b(c4585b);
                }
            }, 500);
            this.f1566I--;
        } else {
            c4585b.mo4897a(new ArrayList());
        }
    }

    public void m15200a(BluetoothDevice bluetoothDevice, C4584a c4584a) {
        this.f1567J.put(bluetoothDevice.getAddress(), c4584a);
    }

    public void m15199a(BluetoothDevice bluetoothDevice) {
        this.f1567J.remove(bluetoothDevice.getAddress());
    }

    public boolean m15202b(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            LogUtils.m15479l(TAG, "No device specified. FIND it first!!!");
            return false;
        } else if (this.f1563F == null) {
            LogUtils.m15477e(TAG, "BluetoothHIDProxy is empty. Error in proxy setup?");
            return false;
        } else {
            LogUtils.m15478k(TAG, "CONNECT USING HID PROXY");
            boolean booleanValue;
            try {
                Method method = this.f1563F.getClass().getMethod("connect", new Class[]{BluetoothDevice.class});
                if (method == null) {
                    LogUtils.m15477e(TAG, "localMethod NOT found???");
                    return false;
                }
                booleanValue = ((Boolean) method.invoke(this.f1563F, new Object[]{bluetoothDevice})).booleanValue();
                LogUtils.m15476d(TAG, "HID Proxy Connect - success?: " + booleanValue);
                return booleanValue;
            } catch (Throwable e) {
                LogUtils.m15477e(TAG, "HID Proxy Connect - got exception!");
                C4462b.m14831a(e, "HID Proxy Connect - got exception!");
                booleanValue = false;
            }
        }
    }

    public boolean m15203c(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            LogUtils.m15479l(TAG, "No device specified. FIND it first!!!");
            return false;
        } else if (this.f1563F == null) {
            LogUtils.m15479l(TAG, "BluetoothHIDProxy is empty. Error in proxy setup?");
            return false;
        } else {
            LogUtils.m15476d(TAG, "DISCONNECT USING HID PROXY");
            boolean booleanValue;
            try {
                Method method = this.f1563F.getClass().getMethod("disconnect", new Class[]{BluetoothDevice.class});
                if (method == null) {
                    LogUtils.m15477e(TAG, "localMethod NOT found???");
                    return false;
                }
                booleanValue = ((Boolean) method.invoke(this.f1563F, new Object[]{bluetoothDevice})).booleanValue();
                LogUtils.m15476d(TAG, "HID Proxy Disconnect - success?: " + booleanValue);
                return booleanValue;
            } catch (Throwable e) {
                LogUtils.m15477e(TAG, "HID Proxy Disconnect - got exception!");
                C4462b.m14831a(e, "HID Proxy Disconnect - got exception!");
                booleanValue = false;
            }
        }
    }

    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            LogUtils.m15479l(TAG, "No device specified. FIND it first!!!");
            return -1;
        } else if (this.f1563F != null) {
            return this.f1563F.getConnectionState(bluetoothDevice);
        } else {
            LogUtils.m15479l(TAG, "BluetoothHIDProxy is empty. Error in proxy setup?");
            return -1;
        }
    }
}
