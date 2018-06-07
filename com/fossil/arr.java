package com.fossil;

import android.content.Context;
import com.fossil.localization.LocalizationResponse;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.profile.utils.MFProfileConfigurationUtils;
import com.portfolio.platform.data.model.microapp.MicroApp;
import org.json.JSONException;
import org.json.JSONObject;

public class arr extends MFBaseRequest {
    private String appVersion;
    private boolean bdI;
    private int offset;
    private int size;

    public arr(Context context, String str, int i, int i2, boolean z) {
        super(context);
        this.appVersion = str;
        this.size = i;
        this.offset = i2;
        this.bdI = z;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MicroApp.COLUMN_PLATFORM, "android");
            jSONObject.put("appVersion", this.appVersion);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new LocalizationResponse();
    }

    protected MFConfiguration initConfiguration() {
        return MFProfileConfigurationUtils.getBearerFossilConfiguration(this.context);
    }

    protected String initApiMethod() {
        return "/resources/localizations";
    }
}
