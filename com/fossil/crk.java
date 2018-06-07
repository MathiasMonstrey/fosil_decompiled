package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.configuration.MFHeader;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.response.device.MFGetWatchResponse;
import java.util.Iterator;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;

public class crk extends MFBaseRequest {
    private static final String TAG = crk.class.getSimpleName();
    private DeviceModel cCd;

    public crk(Context context, DeviceModel deviceModel) {
        super(context);
        this.cCd = deviceModel;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject(new cfj().toJson(this.cCd));
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                if (TextUtils.isEmpty(String.valueOf(jSONObject.get((String) keys.next())))) {
                    keys.remove();
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFGetWatchResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/function/forceLinkDevice";
    }

    protected void buildHeader(MFHeader mFHeader) {
        String a = cmq.m7107a(DateTime.now());
        mFHeader.addHeader("X-Date", a);
        try {
            mFHeader.addHeader("X-HMAC", "hmac username=\"android\", algorithm=\"hmac-sha1\", headers=\"request-line x-date\", signature=\"" + cmv.as("POST /v1/function/forceLinkDevice HTTP/1.1\nx-date: " + a, dqp.lx(3)) + "\"");
        } catch (Exception e) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ", buildHeader method, cannot generate X-HMAC, e = " + e);
        }
        super.buildHeader(mFHeader);
    }
}
