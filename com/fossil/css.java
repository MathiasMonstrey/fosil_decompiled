package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.UserSettings;
import com.portfolio.platform.response.user.MFGetCurrentUserSettingResponse;
import org.json.JSONObject;

public final class css extends MFBaseRequest {
    private static final String TAG;
    public static final C2282a cCu = new C2282a();
    private UserSettings userSettings;

    public static final class C2282a {
        private C2282a() {
        }
    }

    public css(Context context) {
        esl.m11128j(context, "context");
        super(context);
    }

    public css(Context context, UserSettings userSettings) {
        esl.m11128j(context, "context");
        esl.m11128j(userSettings, "userSettings");
        this(context);
        this.userSettings = userSettings;
    }

    protected MFResponse initResponse() {
        return new MFGetCurrentUserSettingResponse();
    }

    protected MFConfiguration initConfiguration() {
        MFConfiguration bK = dqn.bK(this.context);
        esl.m11127i(bK, "AuthConfigurationUtils.g…silConfiguration(context)");
        return bK;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = "privacies";
            UserSettings userSettings = this.userSettings;
            if (userSettings == null) {
                esl.mF("userSettings");
            }
            jSONObject.put(str, userSettings.getPrivacies());
            str = "termsOfService";
            userSettings = this.userSettings;
            if (userSettings == null) {
                esl.mF("userSettings");
            }
            jSONObject.put(str, userSettings.getTermsOfService());
            str = "isEnableNotification";
            userSettings = this.userSettings;
            if (userSettings == null) {
                esl.mF("userSettings");
            }
            jSONObject.put(str, userSettings.isEnableNotification());
            return jSONObject;
        } catch (Exception e) {
            return new Object();
        }
    }

    protected String initApiMethod() {
        return "/user/settings";
    }

    static {
        String simpleName = css.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
