package com.fossil;

import android.content.Context;
import android.net.Uri;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.microapp.MFDeleteUserPresetListResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class crx extends MFBaseRequest {
    public static final String TAG = crx.class.getSimpleName();
    private List<String> cCk;

    protected /* synthetic */ Object initJsonData() {
        return aeU();
    }

    public crx(Context context, List<String> list) {
        super(context);
        this.cCk = list;
    }

    protected JSONObject aeU() {
        MFLogger.m12670d(TAG, "initJsonData");
        JSONObject jSONObject = new JSONObject();
        if (this.cCk != null && this.cCk.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.cCk) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", str);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("_items", jSONArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        MFLogger.m12670d(TAG, "initJsonData - json: " + jSONObject.toString());
        return jSONObject;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.DELETE;
    }

    protected MFResponse initResponse() {
        return new MFDeleteUserPresetListResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/user-presets";
    }

    protected void buildRequest() {
        this.configuration = initConfiguration();
        this.jsonData = aeU();
        this.method = initHttpMethod();
        this.apiMethod = initApiMethod();
        this.buttonApiResponse = initResponse();
        Uri parse = Uri.parse(this.configuration.getBaseServerUrl() + this.apiMethod);
        try {
            if (this.method == HTTPMethod.DELETE) {
                this.url = new URL(parse.toString());
                this.httpURLConnection = (HttpURLConnection) this.url.openConnection();
                this.httpURLConnection.setDoInput(true);
                this.httpURLConnection.setRequestMethod("DELETE");
            }
        } catch (Exception e) {
            MFLogger.m12670d(TAG, "Exception when build request " + e);
        }
        buildHeader(this.configuration.getHeader());
    }
}
