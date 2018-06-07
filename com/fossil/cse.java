package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.microapp.MFGetVariantsResponse;
import org.json.JSONObject;

public class cse extends MFBaseRequest {
    private String deviceId;
    private int limit;
    private int major;
    private String microAppId;
    private int minor;
    private int offset;

    protected /* synthetic */ Object initJsonData() {
        return aeU();
    }

    public cse(Context context, String str, String str2, int i, int i2, int i3, int i4) {
        super(context);
        this.deviceId = str;
        this.microAppId = str2;
        this.major = i;
        this.minor = i2;
        this.offset = i3;
        this.limit = i4;
    }

    protected JSONObject aeU() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFGetVariantsResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        if (this.microAppId.isEmpty()) {
            return String.format("/micro-app-variants?serialNumber=%s&majorNumber=%s&minorNumber=%s&offset=%s&limit=%s", new Object[]{this.deviceId, Integer.valueOf(this.major), Integer.valueOf(this.minor), Integer.valueOf(this.offset), Integer.valueOf(this.limit)});
        }
        return String.format("/micro-app-variants?serialNumber=%s&majorNumber=%s&minorNumber=%s&offset=%s&limit=%s&appId=%s", new Object[]{this.deviceId, Integer.valueOf(this.major), Integer.valueOf(this.minor), Integer.valueOf(this.offset), Integer.valueOf(this.limit), this.microAppId});
    }
}
