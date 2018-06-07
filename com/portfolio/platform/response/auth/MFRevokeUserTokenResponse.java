package com.portfolio.platform.response.auth;

import android.text.TextUtils;
import android.util.Log;
import com.misfit.frameworks.network.responses.MFResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class MFRevokeUserTokenResponse extends MFResponse {
    private static final String TAG = MFRevokeUserTokenResponse.class.getName();

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            try {
                Object string = jSONObject.getString("message");
                if (!TextUtils.isEmpty(string)) {
                    Log.d(TAG, "Inside - " + TAG + " result = " + string);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
