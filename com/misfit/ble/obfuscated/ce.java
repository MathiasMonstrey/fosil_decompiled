package com.misfit.ble.obfuscated;

import android.text.TextUtils;
import com.misfit.ble.obfuscated.bz.C4507b;
import com.misfit.ble.obfuscated.bz.C4508c;
import com.misfit.ble.setting.SDKSetting;
import com.misfit.ble.shine.ShineAdapter.ShineScanCallback;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.model.microapp.MicroApp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ce {
    private Set<String> eN = new HashSet();
    private long kk;
    private long kl;
    private ArrayList<ca> kx = new ArrayList();

    public String getName() {
        return String.format(Locale.US, "scan%s%d%s%d", new Object[]{"_", Long.valueOf(this.kk), "_", Integer.valueOf(System.identityHashCode(this))});
    }

    public void m15009g(ShineScanCallback shineScanCallback) {
        this.kk = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.CALLBACK, hb.m15161a(shineScanCallback));
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        bz bzVar = new bz("startScanning");
        bzVar.jU = new C4507b(null, jSONObject);
        synchronized (this.kx) {
            this.kx.add(bzVar);
        }
    }

    public void m15010h(ShineScanCallback shineScanCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.CALLBACK, hb.m15161a(shineScanCallback));
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        bz bzVar = new bz("stopScanning");
        bzVar.jU = new C4507b(null, jSONObject);
        synchronized (this.kx) {
            this.kx.add(bzVar);
        }
        this.kl = System.currentTimeMillis();
    }

    public void m15008a(String str, String str2, String str3, int i, byte[] bArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SKUModel.COLUMN_DEVICE_NAME, str);
            jSONObject.put("address", str2);
            jSONObject.put("serialNumber", str3);
            jSONObject.put(Constants.RSSI, i);
            jSONObject.put("data", hb.m15159E(bArr));
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        synchronized (this.kx) {
            if (this.kx.size() >= 40) {
                this.kx.remove(10);
            }
            bz bzVar = new bz("scanResult");
            bzVar.jX = new C4508c(Integer.valueOf(0), jSONObject);
            this.kx.add(bzVar);
        }
    }

    public void addDataCollectionTag(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eN.add(str);
        }
    }

    public void m15007R() {
        this.eN.clear();
    }

    public String toString() {
        String str = null;
        try {
            str = toJSON().toString(4);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return str;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object userId = SDKSetting.getUserId();
            String str = "user_id";
            if (userId == null) {
                userId = "";
            }
            jSONObject.put(str, userId);
            jSONObject.put("start_at", this.kk / 1000);
            jSONObject.put("end_at", this.kl / 1000);
            jSONObject.put("sdk_version", C4592s.m15225u() != null ? C4592s.m15225u() : "");
            jSONObject.put("system_version", C4592s.m15227w());
            jSONObject.put(MicroApp.COLUMN_PLATFORM, "Android");
            jSONObject.put(Constants.DEVICE_MODEL, C4592s.getDeviceName() != null ? C4592s.getDeviceName() : "");
            jSONObject.put("tags", new JSONArray(this.eN));
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((ArrayList) this.kx.clone()).iterator();
            while (it.hasNext()) {
                ca caVar = (ca) it.next();
                if (caVar != null) {
                    JSONObject toJSONObject = caVar.toJSONObject();
                    if (toJSONObject != null) {
                        jSONArray.put(toJSONObject);
                    }
                }
            }
            jSONObject.put("events", jSONArray);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
