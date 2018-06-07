package com.misfit.ble.shine;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.C4580h;
import com.misfit.ble.obfuscated.C4586i;
import com.misfit.ble.obfuscated.C4586i.C4584a;
import com.misfit.ble.obfuscated.C4592s;
import com.misfit.ble.obfuscated.an;
import com.misfit.ble.obfuscated.hd;
import com.misfit.ble.setting.SDKSetting;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectionCallback;
import com.misfit.ble.shine.ShineProfile.ConnectionResult;
import com.misfit.ble.shine.ShineProfile.State;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.shine.error.ShineError.Reason;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ShineDevice implements Parcelable {
    public static final Creator<ShineDevice> CREATOR = new C46111();
    private static final String TAG = ShineDevice.class.getName();
    private String eK;
    private WeakReference<ShineProfile> eL;
    private boolean eM;
    private Set<String> eN;
    private BroadcastReceiver eO = new C46132(this);
    private ShineHIDConnectionCallback eP;
    private Handler mHandler;
    public BluetoothDevice f1601y;

    static class C46111 implements Creator<ShineDevice> {
        C46111() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m15274b(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m15275d(i);
        }

        public ShineDevice m15274b(Parcel parcel) {
            ShineDevice shineDevice = null;
            LogUtils.m15476d("SHINE_PARCEL", "createFromParcel: " + parcel.toString());
            Bundle readBundle = parcel.readBundle();
            if (readBundle != null) {
                String string = readBundle.getString("mac_address");
                shineDevice = an.m14700h(string);
                LogUtils.m15476d("SHINE_PARCEL", "createFromParcel - macAddress: " + string);
                if (shineDevice == null) {
                    String string2 = readBundle.getString(Constants.SERIAL_NUMBER);
                    LogUtils.m15476d("SHINE_PARCEL", "createFromParcel - serialNumber: " + string2);
                    shineDevice = an.m14698b(string, string2);
                }
            }
            LogUtils.m15476d("SHINE_PARCEL", "device: " + shineDevice);
            return shineDevice;
        }

        public ShineDevice[] m15275d(int i) {
            return null;
        }
    }

    class C46132 extends BroadcastReceiver {
        final /* synthetic */ ShineDevice eQ;

        class C46121 implements Runnable {
            final /* synthetic */ C46132 eR;

            C46121(C46132 c46132) {
                this.eR = c46132;
            }

            public void run() {
                this.eR.eQ.hidConnect();
            }
        }

        C46132(ShineDevice shineDevice) {
            this.eQ = shineDevice;
        }

        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
            LogUtils.m15478k(ShineDevice.TAG, "[Broadcast] Action received, bond state changed to: " + hd.m15185m(intExtra));
            if (bluetoothDevice == null || !bluetoothDevice.getAddress().equals(this.eQ.getAddress())) {
                LogUtils.m15478k(ShineDevice.TAG, "Skip other devices");
                return;
            }
            switch (intExtra) {
                case 10:
                    C4592s.getApplicationContext().unregisterReceiver(this.eQ.eO);
                    return;
                case 12:
                    C4592s.getApplicationContext().unregisterReceiver(this.eQ.eO);
                    this.eQ.mHandler.postDelayed(new C46121(this), 500);
                    return;
                default:
                    return;
            }
        }
    }

    class C46143 implements C4584a {
        final /* synthetic */ ShineDevice eQ;

        C46143(ShineDevice shineDevice) {
            this.eQ = shineDevice;
        }

        public void mo4900a(BluetoothDevice bluetoothDevice, int i) {
            if (this.eQ.eP != null) {
                this.eQ.eP.onHIDConnectionStateChanged(this.eQ, i);
            }
        }
    }

    public interface ShineHIDConnectionCallback {
        void onHIDConnectionStateChanged(ShineDevice shineDevice, int i);
    }

    public ShineDevice(BluetoothDevice bluetoothDevice, String str) {
        this.f1601y = bluetoothDevice;
        this.eK = str;
        m15277P();
    }

    public ShineDevice(BluetoothDevice bluetoothDevice) {
        this.f1601y = bluetoothDevice;
        this.eK = null;
        m15277P();
    }

    private void m15277P() {
        this.eM = false;
        this.eN = new HashSet();
        this.mHandler = hd.m15181do();
    }

    public void addDataCollectionTag(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Data collection tag can not be empty!");
        }
        this.eN.add(str);
    }

    Set<String> m15282Q() {
        return this.eN;
    }

    void m15283R() {
        this.eN.clear();
    }

    public String getSerialNumber() {
        return this.eK;
    }

    void m15289g(String str) {
        this.eK = str;
    }

    public ShineProfile getShineProfile() {
        if (this.eL == null) {
            return null;
        }
        ShineProfile shineProfile = (ShineProfile) this.eL.get();
        if (shineProfile == null || shineProfile.aj() == State.CLOSED) {
            return null;
        }
        return shineProfile;
    }

    void m15288a(ShineProfile shineProfile) {
        this.eL = new WeakReference(shineProfile);
    }

    public boolean isInvalid() {
        return this.eM;
    }

    void invalidate() {
        this.eM = true;
    }

    void m15284S() {
        this.eM = false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("mac_address", getAddress());
        if (getSerialNumber() != null) {
            bundle.putString(Constants.SERIAL_NUMBER, getSerialNumber());
        }
        parcel.writeBundle(bundle);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ShineDevice) {
            ShineDevice shineDevice = (ShineDevice) obj;
            if (!TextUtils.isEmpty(this.eK) && this.eK.equals(shineDevice.eK) && this.eM == shineDevice.eM) {
                return super.equals(shineDevice);
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        if (TextUtils.isEmpty(this.eK)) {
            return hashCode;
        }
        return hashCode + (this.eK.hashCode() * 10);
    }

    public void connectProfile(long j, ConnectionCallback connectionCallback) throws IllegalStateException {
        SDKSetting.validateSettings();
        if (connectionCallback == null) {
            throw new IllegalStateException("ConnectionCallback is null");
        }
        Context applicationContext = C4592s.getApplicationContext();
        if (!ShineAdapter.getDefaultAdapter(applicationContext).isEnabled() || isInvalid()) {
            connectionCallback.onConnectionStateChanged(null, State.CLOSED, new ConnectActionResult(1, ConnectionResult.FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.UNKNOWN, Event.UNKNOWN, Reason.UNKNOWN)));
            return;
        }
        ShineProfile shineProfile = getShineProfile();
        if (shineProfile == null) {
            shineProfile = new ShineProfile(applicationContext, this);
            if (shineProfile.m15421a(this, false, j, connectionCallback)) {
                m15288a(shineProfile);
                return;
            } else {
                connectionCallback.onConnectionStateChanged(null, State.CLOSED, new ConnectActionResult(1, ConnectionResult.FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.UNKNOWN, Event.UNKNOWN, Reason.UNKNOWN)));
                return;
            }
        }
        State aj = shineProfile.aj();
        switch (aj) {
            case CONNECTING:
                shineProfile.m15420a(connectionCallback, j);
                return;
            case PREPARING:
            case DISCONNECTING:
                shineProfile.m15419a(connectionCallback);
                return;
            case CONNECTED:
            case READY:
            case OTA:
                shineProfile.m15419a(connectionCallback);
                connectionCallback.onConnectionStateChanged(shineProfile, aj, new ConnectActionResult(0, ConnectionResult.SUCCEEDED, null));
                return;
            default:
                return;
        }
    }

    public void closeProfile() {
        ShineProfile shineProfile = getShineProfile();
        if (shineProfile != null) {
            shineProfile.close();
        }
    }

    public String getName() {
        return this.f1601y.getName();
    }

    public String getAddress() {
        return this.f1601y.getAddress();
    }

    public int getBondState() {
        return this.f1601y.getBondState();
    }

    public State getShineProfileState() {
        State state = State.IDLE;
        ShineProfile shineProfile = getShineProfile();
        if (shineProfile != null) {
            return shineProfile.aj();
        }
        return state;
    }

    boolean createBond() {
        boolean z = false;
        Log.d(TAG, "CREATE BOND with " + getAddress() + " - bondState: " + getBondState());
        if (getBondState() == 10) {
            C4592s.getApplicationContext().registerReceiver(this.eO, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
            z = this.f1601y.createBond();
        }
        Log.d(TAG, "CREATE BOND - success?: " + z);
        return z;
    }

    boolean m15285T() {
        Log.d(TAG, "REMOVE BOND with " + getAddress() + " - bondState: " + getBondState());
        if (!m15286U()) {
            return false;
        }
        boolean booleanValue;
        try {
            Method method = this.f1601y.getClass().getMethod("removeBond", new Class[0]);
            if (method == null) {
                Log.e(TAG, "REMOVE BOND - localMethod NOT found???");
                return false;
            }
            booleanValue = ((Boolean) method.invoke(this.f1601y, new Object[0])).booleanValue();
            Log.d(TAG, "REMOVE BOND - success?: " + booleanValue);
            return booleanValue;
        } catch (Throwable e) {
            Log.e(TAG, "REMOVE BOND - got exception!");
            C4462b.m14831a(e, "REMOVE BOND - got exception!");
            booleanValue = false;
        }
    }

    boolean m15286U() {
        return getBondState() == 12;
    }

    public void registerHIDConnectionCallback(ShineHIDConnectionCallback shineHIDConnectionCallback) {
        this.eP = shineHIDConnectionCallback;
        C4586i.m15193l().m15200a(this.f1601y, new C46143(this));
    }

    public void unregisterHIDConnectionCallback() {
        C4586i.m15193l().m15199a(this.f1601y);
    }

    public boolean hidConnect() {
        boolean z = false;
        int bondState = getBondState();
        int hIDConnectionState = getHIDConnectionState();
        Log.d(TAG, "HID CONNECT with " + getAddress() + " - bondState: " + bondState + " - hidState: " + hIDConnectionState);
        if (bondState != 11 && hIDConnectionState == 0) {
            z = C4586i.m15193l().m15202b(this.f1601y);
        }
        Log.d(TAG, "HID CONNECT - success?: " + z);
        return z;
    }

    public boolean hidDisconnect() {
        boolean z = false;
        int hIDConnectionState = getHIDConnectionState();
        Log.d(TAG, "HID DISCONNECT with " + getAddress() + " - hidState: " + hIDConnectionState);
        if (hIDConnectionState == 1 || hIDConnectionState == 2) {
            z = C4586i.m15193l().m15203c(this.f1601y);
        }
        Log.d(TAG, "HID DISCONNECT - success?: " + z);
        return z;
    }

    int m15287V() {
        return C4580h.m15156j().getConnectionState(this.f1601y);
    }

    public int getHIDConnectionState() {
        return C4586i.m15193l().getConnectionState(this.f1601y);
    }
}
