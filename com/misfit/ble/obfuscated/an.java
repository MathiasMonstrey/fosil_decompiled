package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class an {
    private static final String TAG = an.class.getSimpleName();
    private static HashMap<String, ShineDevice> eT = new HashMap();

    static {
        m14696X();
    }

    public static ShineDevice m14697a(BluetoothDevice bluetoothDevice, String str) {
        if (bluetoothDevice == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ShineDevice h = m14700h(bluetoothDevice.getAddress());
        if (h != null) {
            return h;
        }
        h = new ShineDevice(bluetoothDevice, str);
        eT.put(bluetoothDevice.getAddress(), h);
        return h;
    }

    public static ShineDevice m14699d(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        ShineDevice h = m14700h(bluetoothDevice.getAddress());
        if (h != null) {
            return h;
        }
        h = new ShineDevice(bluetoothDevice);
        eT.put(bluetoothDevice.getAddress(), h);
        return h;
    }

    public static ShineDevice m14698b(String str, String str2) {
        if (str == null) {
            return null;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            LogUtils.m15477e(TAG, "BluetoothAdapter.getDefaultAdapter is null");
            return null;
        }
        BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(str);
        if (str2 == null) {
            return m14699d(remoteDevice);
        }
        return m14697a(remoteDevice, str2);
    }

    public static ShineDevice m14700h(String str) {
        return (ShineDevice) eT.get(str);
    }

    public static void m14695W() {
        JSONArray jSONArray = new JSONArray();
        for (String str : eT.keySet()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mac_address", str);
                jSONObject.put(Constants.SERIAL_NUMBER, ((ShineDevice) eT.get(str)).getSerialNumber());
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            jSONArray.put(jSONObject);
        }
        gz.m15154j(C4589k.m15216d(jSONArray.toString()), "com.misfit.ble.devices");
    }

    private static void m14696X() {
        String H = gz.m15149H("com.misfit.ble.devices");
        if (H != null) {
            H = C4589k.m15217e(H);
            if (H != null) {
                try {
                    JSONArray jSONArray = new JSONArray(H);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        m14698b(jSONObject.getString("mac_address"), jSONObject.getString(Constants.SERIAL_NUMBER));
                    }
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
            }
        }
    }
}
