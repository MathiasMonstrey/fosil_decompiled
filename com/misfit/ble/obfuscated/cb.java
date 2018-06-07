package com.misfit.ble.obfuscated;

import android.text.TextUtils;
import com.misfit.ble.obfuscated.C4435a.C4434a;
import com.misfit.ble.setting.SDKSetting;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.portfolio.platform.data.model.microapp.MicroApp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class cb {
    private String ac;
    private String eK;
    private Set<String> eN;
    private String fa;
    private String fb;
    private final int kj = MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
    private long kk;
    private long kl;
    private ArrayList<ArrayList<ca>> km;
    private ArrayList<ca> kn;

    public cb(String str) {
        this.eK = str;
        this.ac = SDKSetting.getUserId();
        this.eN = new HashSet();
        m14995P();
    }

    public String getName() {
        return String.format(Locale.US, "sync%s%d%s%d", new Object[]{"_", Long.valueOf(this.kk), "_", Integer.valueOf(System.identityHashCode(this))});
    }

    public void start() {
        this.kk = System.currentTimeMillis();
    }

    public void stop() {
        this.kl = System.currentTimeMillis();
    }

    public String getSerialNumber() {
        return this.eK;
    }

    public void m14999g(String str) {
        this.eK = str;
    }

    public String getFirmwareVersion() {
        return this.fa;
    }

    public void m15000j(String str) {
        this.fa = str;
    }

    public String getModelNumber() {
        return this.fb;
    }

    public void m15001k(String str) {
        this.fb = str;
    }

    public void addDataCollectionTag(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eN.add(str);
        }
    }

    public void m14998d(Set<String> set) {
        this.eN.addAll(set);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Iterator it = bI().iterator();
            while (it.hasNext()) {
                stringBuffer.append(((JSONObject) it.next()).toString(4));
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return stringBuffer.toString();
    }

    private void m14995P() {
        this.km = new ArrayList();
        this.kn = new ArrayList();
        this.km.add(this.kn);
    }

    public void bH() {
        this.km.clear();
        m14995P();
    }

    public void m14997a(ca caVar) {
        if (!this.kn.contains(caVar)) {
            if (this.kn.size() >= MFNetworkReturnCode.INTERNAL_SERVER_ERROR) {
                this.kn = new ArrayList();
                this.km.add(this.kn);
            }
            this.kn.add(caVar);
        }
    }

    public ArrayList<JSONObject> bI() {
        ArrayList<JSONObject> arrayList = new ArrayList();
        Iterator it = this.km.iterator();
        while (it.hasNext()) {
            ArrayList arrayList2 = (ArrayList) it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("user_id", this.ac != null ? this.ac : "");
                jSONObject.put("start_at", this.kk / 1000);
                jSONObject.put("end_at", this.kl / 1000);
                jSONObject.put("sdk_version", C4592s.m15225u() != null ? C4592s.m15225u() : "");
                jSONObject.put("system_version", C4592s.m15227w());
                jSONObject.put(MicroApp.COLUMN_PLATFORM, "Android");
                jSONObject.put(Constants.DEVICE_MODEL, C4592s.getDeviceName() != null ? C4592s.getDeviceName() : "");
                jSONObject.put(Constants.SERIAL_NUMBER, this.eK != null ? this.eK : "");
                jSONObject.put(Constants.FIRMWARE_VERSION, this.fa != null ? this.fa : "");
                jSONObject.put("tags", new JSONArray(this.eN));
                JSONArray jSONArray = new JSONArray();
                Iterator it2 = ((ArrayList) arrayList2.clone()).iterator();
                while (it2.hasNext()) {
                    ca caVar = (ca) it2.next();
                    if (caVar != null) {
                        JSONObject toJSONObject = caVar.toJSONObject();
                        if (toJSONObject != null) {
                            jSONArray.put(toJSONObject);
                        }
                    }
                }
                jSONObject.put("events", jSONArray);
                arrayList.add(jSONObject);
            } catch (Throwable e) {
                m14996a(arrayList2, e);
                C4462b.m14831a(e, "");
            } catch (Exception e2) {
                m14996a(arrayList2, e2);
                throw e2;
            }
        }
        return arrayList;
    }

    private void m14996a(ArrayList<ca> arrayList, Exception exception) {
        C4462b.m14830a(new C4435a(C4434a.LOG_SESSION_TO_JSON_EXCEPTION).m14672a("exception", exception.getClass().getSimpleName()).m14672a("userId", this.ac != null ? this.ac : "").m14672a("startAt", String.valueOf(this.kk)).m14672a("endAt", String.valueOf(this.kl)).m14672a("serialNumber", this.eK != null ? this.eK : "").m14672a("eventCount", String.valueOf(arrayList.size())));
    }
}
