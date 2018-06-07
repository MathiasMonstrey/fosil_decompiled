package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.alarm.MFAlarmResponse;

public class cpx extends MFBaseRequest {
    private static final String TAG = cpx.class.getSimpleName();
    private String id;

    public cpx(Context context, String str) {
        super(context);
        this.id = str;
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.DELETE;
    }

    protected MFResponse initResponse() {
        return new MFAlarmResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        String str;
        if (this.id == null || this.id.isEmpty()) {
            str = "/device/alarms";
        } else {
            str = String.format("/device/alarms/%s", new Object[]{this.id});
        }
        MFLogger.m12670d(TAG, "initApiMethod - request: " + str);
        return str;
    }
}
