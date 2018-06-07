package io.fabric.sdk.android.services.common;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.fossil.emm;
import com.fossil.emr;
import com.fossil.enb;
import com.fossil.enc;
import com.fossil.enk;
import com.fossil.enm;
import com.misfit.frameworks.common.constants.Constants;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import org.json.JSONObject;

public class IdManager {
    private static final Pattern dNU = Pattern.compile("[^\\p{Alnum}]");
    private static final String dNV = Pattern.quote("/");
    private final Collection<emr> aHk;
    private final Context appContext;
    private final ReentrantLock dNW = new ReentrantLock();
    private final enm dNX;
    private final boolean dNY;
    private final boolean dNZ;
    private final String dNf;
    private final String dNg;

    public enum DeviceIdentifierType {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        public final int protobufIndex;

        private DeviceIdentifierType(int i) {
            this.protobufIndex = i;
        }
    }

    public IdManager(Context context, String str, String str2, Collection<emr> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.appContext = context;
            this.dNg = str;
            this.dNf = str2;
            this.aHk = collection;
            this.dNX = new enm();
            this.dNY = CommonUtils.m16278j(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.dNY) {
                emm.aEU().d("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.dNZ = CommonUtils.m16278j(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.dNZ) {
                emm.aEU().d("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        }
    }

    public String bl(String str, String str2) {
        try {
            Cipher z = CommonUtils.m16283z(1, CommonUtils.mi(str + str2.replaceAll("\\.", new StringBuilder(new String(new char[]{'s', 'l', 'c'})).reverse().toString())));
            JSONObject jSONObject = new JSONObject();
            m16286j(jSONObject);
            m16287k(jSONObject);
            m16288l(jSONObject);
            m16289m(jSONObject);
            String str3 = "";
            if (jSONObject.length() <= 0) {
                return str3;
            }
            try {
                return CommonUtils.au(z.doFinal(jSONObject.toString().getBytes()));
            } catch (Throwable e) {
                emm.aEU().g("Fabric", "Could not encrypt IDs", e);
                return str3;
            }
        } catch (Throwable e2) {
            emm.aEU().g("Fabric", "Could not create cipher to encrypt headers.", e2);
            return "";
        }
    }

    private void m16286j(JSONObject jSONObject) {
        try {
            jSONObject.put("APPLICATION_INSTALLATION_UUID".toLowerCase(Locale.US), aFt());
        } catch (Throwable e) {
            emm.aEU().g("Fabric", "Could not write application id to JSON", e);
        }
    }

    private void m16287k(JSONObject jSONObject) {
        for (Entry entry : xy().entrySet()) {
            try {
                jSONObject.put(((DeviceIdentifierType) entry.getKey()).name().toLowerCase(Locale.US), entry.getValue());
            } catch (Throwable e) {
                emm.aEU().g("Fabric", "Could not write value to JSON: " + ((DeviceIdentifierType) entry.getKey()).name(), e);
            }
        }
    }

    private void m16288l(JSONObject jSONObject) {
        try {
            jSONObject.put(Constants.OS_VERSION, aFv());
        } catch (Throwable e) {
            emm.aEU().g("Fabric", "Could not write OS version to JSON", e);
        }
    }

    private void m16289m(JSONObject jSONObject) {
        try {
            jSONObject.put("model", aFw());
        } catch (Throwable e) {
            emm.aEU().g("Fabric", "Could not write model to JSON", e);
        }
    }

    public boolean aFs() {
        return this.dNZ;
    }

    private boolean mn(String str) {
        return this.appContext.checkCallingPermission(str) == 0;
    }

    private String mo(String str) {
        return str == null ? null : dNU.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String aFt() {
        String str = this.dNf;
        if (str != null) {
            return str;
        }
        SharedPreferences ev = CommonUtils.ev(this.appContext);
        str = ev.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m16284a(ev);
        }
        return str;
    }

    public String aFu() {
        return this.dNg;
    }

    public String aFv() {
        return String.format(Locale.US, "%s/%s", new Object[]{mp(VERSION.RELEASE), mp(VERSION.INCREMENTAL)});
    }

    public String aFw() {
        return String.format(Locale.US, "%s/%s", new Object[]{mp(Build.MANUFACTURER), mp(Build.MODEL)});
    }

    private String mp(String str) {
        return str.replaceAll(dNV, "");
    }

    public String aFx() {
        String str = "";
        if (!this.dNY) {
            return str;
        }
        str = aFy();
        if (str != null) {
            return str;
        }
        SharedPreferences ev = CommonUtils.ev(this.appContext);
        str = ev.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m16284a(ev);
        }
        return str;
    }

    private String m16284a(SharedPreferences sharedPreferences) {
        this.dNW.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = mo(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.dNW.unlock();
            return string;
        } catch (Throwable th) {
            this.dNW.unlock();
        }
    }

    public Map<DeviceIdentifierType, String> xy() {
        Map hashMap = new HashMap();
        for (emr com_fossil_emr : this.aHk) {
            if (com_fossil_emr instanceof enk) {
                for (Entry entry : ((enk) com_fossil_emr).xy().entrySet()) {
                    m16285a(hashMap, (DeviceIdentifierType) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m16285a(hashMap, DeviceIdentifierType.ANDROID_ID, aFy());
        m16285a(hashMap, DeviceIdentifierType.ANDROID_DEVICE_ID, aFz());
        m16285a(hashMap, DeviceIdentifierType.ANDROID_SERIAL, getSerialNumber());
        m16285a(hashMap, DeviceIdentifierType.WIFI_MAC_ADDRESS, aFA());
        m16285a(hashMap, DeviceIdentifierType.BLUETOOTH_MAC_ADDRESS, aFB());
        m16285a(hashMap, DeviceIdentifierType.ANDROID_ADVERTISING_ID, aFl());
        return Collections.unmodifiableMap(hashMap);
    }

    public String getInstallerPackageName() {
        return this.dNX.getInstallerPackageName(this.appContext);
    }

    public String aFl() {
        if (!this.dNY) {
            return null;
        }
        enb aFg = new enc(this.appContext).aFg();
        if (aFg != null) {
            return aFg.aHT;
        }
        return null;
    }

    private void m16285a(Map<DeviceIdentifierType, String> map, DeviceIdentifierType deviceIdentifierType, String str) {
        if (str != null) {
            map.put(deviceIdentifierType, str);
        }
    }

    public String aFy() {
        if (!this.dNY) {
            return null;
        }
        String string = Secure.getString(this.appContext.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return mo(string);
    }

    public String aFz() {
        if (this.dNY && mn("android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) this.appContext.getSystemService("phone");
            if (telephonyManager != null) {
                return mo(telephonyManager.getDeviceId());
            }
        }
        return null;
    }

    public String aFA() {
        if (this.dNY && mn("android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) this.appContext.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    return mo(connectionInfo.getMacAddress());
                }
            }
        }
        return null;
    }

    public String aFB() {
        if (this.dNY && mn("android.permission.BLUETOOTH")) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    mo(defaultAdapter.getAddress());
                }
            } catch (Throwable e) {
                emm.aEU().g("Fabric", "Utils#getBluetoothMacAddress failed, returning null. Requires prior call to BluetoothAdatpter.getDefaultAdapter() on thread that has called Looper.prepare()", e);
            }
        }
        return null;
    }

    public String getSerialNumber() {
        if (this.dNY && VERSION.SDK_INT >= 9) {
            try {
                return mo((String) Build.class.getField("SERIAL").get(null));
            } catch (Throwable e) {
                emm.aEU().g("Fabric", "Could not retrieve android.os.Build.SERIAL value", e);
            }
        }
        return null;
    }
}
