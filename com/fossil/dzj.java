package com.fossil;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class dzj extends dzm {
    private long aXV = -1;
    protected dzk dBZ = new dzk();

    public dzj(Context context, int i, String str, dzh com_fossil_dzh) {
        super(context, i, com_fossil_dzh);
        this.dBZ.aWB = str;
    }

    private void HN() {
        if (this.dBZ.aWB != null) {
            Map lk = dzg.lk(this.dBZ.aWB);
            if (lk != null && lk.size() > 0) {
                if (this.dBZ.dCb == null || this.dBZ.dCb.length() == 0) {
                    this.dBZ.dCb = new JSONObject(lk);
                    return;
                }
                for (Entry entry : lk.entrySet()) {
                    try {
                        this.dBZ.dCb.put(entry.getKey().toString(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public dzk aCk() {
        return this.dBZ;
    }

    public f aCl() {
        return f.d;
    }

    public boolean mo2793h(JSONObject jSONObject) {
        jSONObject.put("ei", this.dBZ.aWB);
        if (this.aXV > 0) {
            jSONObject.put("du", this.aXV);
        }
        if (this.dBZ.dCa == null) {
            HN();
            jSONObject.put("kv", this.dBZ.dCb);
        } else {
            jSONObject.put("ar", this.dBZ.dCa);
        }
        return true;
    }
}
