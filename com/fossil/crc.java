package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import com.misfit.frameworks.buttonservice.ble.ScanService;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.buddychallenge.MFUpdateBCAccountInfoResponse;
import org.json.JSONObject;

public class crc extends MFBaseRequest {
    private int cBT;
    private int cBW;
    private String cBX;

    public crc(Context context, int i, int i2, String str) {
        super(context);
        this.cBT = i;
        this.cBW = i2;
        this.cBX = str;
    }

    protected Object initJsonData() {
        try {
            Object jSONObject = new JSONObject();
            if (this.cBT > 0) {
                jSONObject.put("goal", this.cBT);
            }
            if (!(this.cBW == -1 || this.cBW == ScanService.RETRIEVE_DEVICE_BOND_RSSI_MARK)) {
                jSONObject.put("timezoneOffset", this.cBW);
            }
            if (TextUtils.isEmpty(this.cBX)) {
                return jSONObject;
            }
            jSONObject.put(Constants.PROFILE_KEY_PROFILE_PIC, this.cBX);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.PATCH;
    }

    protected MFResponse initResponse() {
        return new MFUpdateBCAccountInfoResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/buddy-challenge/players/me";
    }
}
