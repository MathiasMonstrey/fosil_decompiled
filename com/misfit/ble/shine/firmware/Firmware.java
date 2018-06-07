package com.misfit.ble.shine.firmware;

import android.text.TextUtils;
import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.bw;
import com.misfit.ble.obfuscated.gz;
import com.misfit.ble.obfuscated.hd;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Firmware implements Serializable {
    private static final String TAG = LogUtils.m15475b(Firmware.class);
    public static String iY = "com.misfit.firmware";
    public static String iZ = "bin";
    private static String ja = Constants.VERSION_NUM;
    private static String jb = Constants.DEVICE_MODEL;
    private static String jc = Constants.DOWNLOAD_URL;
    private static String jd = "checksum";
    private static String je = "min_sdk_version";
    private static String jf = "max_sdk_version";
    private static String jg = "characteristics";
    private static String jh = "uuid";
    private static String ji = Constants.COMMANDS;
    private static String jj = "sequence";
    public String fa;
    public String jk;
    public String jl;
    public String jm;
    public String jn;
    public String jo;
    transient byte[] jp;
    public Map<String, Set<String>> supportedCommands;

    Firmware() {
    }

    public Firmware(JSONObject jSONObject) {
        this.fa = jSONObject.optString(ja);
        this.jk = jSONObject.optString(jb);
        this.jn = jSONObject.optString(jc);
        this.jo = jSONObject.optString(jd);
        this.supportedCommands = m15423a(jSONObject);
        this.jl = jSONObject.optString(je);
        this.jm = jSONObject.optString(jf);
    }

    private Map<String, Set<String>> m15423a(JSONObject jSONObject) {
        Map<String, Set<String>> hashMap = new HashMap();
        JSONArray optJSONArray = jSONObject.optJSONArray(jg);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(jh);
                    if (optString != null) {
                        Set hashSet = new HashSet();
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(ji);
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    Object optString2 = optJSONObject2.optString(jj);
                                    if (!(optString2 == null || TextUtils.isEmpty(optString2))) {
                                        hashSet.add(optString2.toUpperCase());
                                    }
                                }
                            }
                        }
                        hashMap.put(optString, hashSet);
                    }
                }
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Firmware)) {
            return false;
        }
        Firmware firmware = (Firmware) obj;
        if (!TextUtils.equals(this.fa, firmware.fa)) {
            return false;
        }
        if (!TextUtils.equals(this.jk, firmware.jk)) {
            return false;
        }
        if (!TextUtils.equals(this.jn, firmware.jn)) {
            return false;
        }
        if (!TextUtils.equals(this.jo, firmware.jo)) {
            return false;
        }
        if (!TextUtils.equals(this.jl, firmware.jl)) {
            return false;
        }
        if (!TextUtils.equals(this.jm, firmware.jm)) {
            return false;
        }
        if (bw.m14974a(this.supportedCommands, firmware.supportedCommands)) {
            return true;
        }
        return false;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ja, this.fa);
            jSONObject.put(jb, this.jk);
            jSONObject.put(je, this.jl);
            jSONObject.put(jf, this.jm);
            return jSONObject.toString(4);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
            return null;
        }
    }

    public String getDeviceModel() {
        return this.jk;
    }

    public String getMinSDKVersion() {
        return this.jl;
    }

    public String getMaxSDKVersion() {
        return this.jm;
    }

    public String getFirmwareVersion() {
        return this.fa;
    }

    public byte[] getFirmwareData() {
        if (this.jp == null) {
            byte[] h = gz.m15152h(iY, bw.m14978u(this.fa));
            if (hd.m15180d(this.jo, h)) {
                this.jp = h;
            } else {
                LogUtils.m15479l(TAG, "Wrong checksum");
            }
        }
        return this.jp;
    }

    boolean m15424h(byte[] bArr) {
        if (this.jp == bArr) {
            return true;
        }
        if (!hd.m15180d(this.jo, bArr)) {
            return false;
        }
        if (!gz.m15151a(bArr, iY, bw.m14978u(this.fa))) {
            return false;
        }
        this.jp = bArr;
        return true;
    }
}
