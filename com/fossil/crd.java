package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.buddychallenge.MFUpdateChallengeResponse;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class crd extends MFBaseRequest {
    private String cBR;
    private List<Integer> cBY;
    private List<Integer> cBZ;
    private final String cCa;

    public crd(Context context, String str, List<Integer> list, List<Integer> list2, String str2) {
        super(context);
        this.cBR = str;
        this.cBY = list;
        this.cBZ = list2;
        this.cCa = str2;
    }

    protected Object initJsonData() {
        try {
            Object jSONObject = new JSONObject();
            if (this.cBY != null) {
                jSONObject.put("senderStepsDays", new JSONArray(this.cBY));
            } else if (this.cBZ != null) {
                jSONObject.put("receiverStepsDays", new JSONArray(this.cBZ));
            }
            if (TextUtils.isEmpty(this.cCa)) {
                return jSONObject;
            }
            jSONObject.put("stepAt", this.cCa);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e("MFUpdateChallengeRequest", "initJsonData - ex=" + e.toString());
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.PATCH;
    }

    protected MFResponse initResponse() {
        return new MFUpdateChallengeResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/buddy-challenge/challenges/" + this.cBR;
    }
}
