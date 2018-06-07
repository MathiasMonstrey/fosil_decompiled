package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothDevice;
import java.util.List;

public interface C4568q {
    boolean mo4875a(C4518o c4518o);

    boolean mo4876a(C4518o c4518o, boolean z);

    boolean mo4877a(boolean z, C4447n c4447n);

    boolean mo4878b(C4518o c4518o);

    C4563r mo4879c(String str);

    void close();

    boolean connect();

    void disconnect();

    boolean discoverServices();

    BluetoothDevice getDevice();

    List<C4563r> getServices();

    boolean readRemoteRssi();

    boolean refreshDeviceCache();

    boolean requestConnectionPriority(int i);
}
