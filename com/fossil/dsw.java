package com.fossil;

import com.facebook.internal.NativeProtocol;
import com.fossil.wearables.fsl.goaltracking.GoalTracking;
import com.sina.weibo.sdk.exception.WeiboException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class dsw {
    private static final String TAG = dsv.class.getName();
    private List<dsr> dqN;
    private List<dst> dqO;
    private int frequency;

    public dsw(String str) throws WeiboException {
        jE(str);
    }

    private void jE(String str) throws WeiboException {
        int i = 0;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("error") || jSONObject.has(NativeProtocol.BRIDGE_ARG_ERROR_CODE)) {
                    duj.aS(TAG, "load cmd api has error !!!");
                    throw new WeiboException("load cmd api has error !!!");
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("cmd");
                if (optJSONObject != null) {
                    this.frequency = optJSONObject.optInt(GoalTracking.COLUMN_FREQUENCY);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("app_install");
                    if (optJSONArray != null) {
                        this.dqN = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            this.dqN.add(new dsr(optJSONArray.getJSONObject(i2)));
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("app_invoke");
                    if (optJSONArray2 != null) {
                        this.dqO = new ArrayList();
                        while (i < optJSONArray2.length()) {
                            this.dqO.add(new dst(optJSONArray2.getJSONObject(i)));
                            i++;
                        }
                    }
                }
            } catch (JSONException e) {
                duj.m9769d(TAG, "parse NotificationInfo error: " + e.getMessage());
            }
        }
    }

    public List<dsr> awM() {
        return this.dqN;
    }

    public List<dst> awN() {
        return this.dqO;
    }

    public int getFrequency() {
        return this.frequency;
    }
}
