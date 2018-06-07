package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.frameworks.common.constants.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class bx {
    private static final String TAG = bx.class.getSimpleName();
    private static HashMap<String, C4505a> jy = new HashMap();

    public static class C4505a {
        public UAppSystemVersion jA;
        public String jz;

        public C4505a(String str, UAppSystemVersion uAppSystemVersion) {
            this.jz = str;
            this.jA = uAppSystemVersion;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.FIRMWARE_VERSION, this.jz);
                jSONObject.put("firmware_uapp_system_version", this.jA.toJSONObject());
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            return jSONObject;
        }

        public static C4505a m14979c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                C4505a c4505a;
                String string = jSONObject.getString(Constants.FIRMWARE_VERSION);
                UAppSystemVersion readFromJsonObject = UAppSystemVersion.readFromJsonObject(jSONObject.getJSONObject("firmware_uapp_system_version"));
                if (string == null || string.isEmpty() || readFromJsonObject == null) {
                    c4505a = null;
                } else {
                    c4505a = new C4505a(string, readFromJsonObject);
                }
                return c4505a;
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
                return null;
            }
        }

        public boolean isValid() {
            return (this.jz == null || this.jz.isEmpty() || this.jA == null) ? false : true;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C4505a)) {
                return false;
            }
            if (this.jz.compareToIgnoreCase(((C4505a) obj).jz) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.jz.hashCode();
        }

        public String toString() {
            return toJSONObject().toString();
        }
    }

    static {
        bx();
    }

    private static void bx() {
        String H = gz.m15149H("com.misfit.ble.firmwares");
        if (H != null) {
            H = C4589k.m15217e(H);
            if (H != null) {
                try {
                    JSONArray jSONArray = new JSONArray(H);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            m14980a(C4505a.m14979c(jSONArray.getJSONObject(i)));
                        } catch (Throwable e) {
                            C4462b.m14831a(e, "");
                        }
                    }
                } catch (Throwable e2) {
                    C4462b.m14831a(e2, "");
                }
            }
        }
    }

    public static void by() {
        JSONArray jSONArray = new JSONArray();
        for (C4505a toJSONObject : jy.values()) {
            jSONArray.put(toJSONObject.toJSONObject());
        }
        gz.m15154j(C4589k.m15216d(jSONArray.toString()), "com.misfit.ble.firmwares");
    }

    public static C4505a m14981v(String str) {
        return (C4505a) jy.get(str);
    }

    public static void m14980a(C4505a c4505a) {
        if (c4505a != null && c4505a.isValid()) {
            jy.put(c4505a.jz, c4505a);
        }
    }
}
