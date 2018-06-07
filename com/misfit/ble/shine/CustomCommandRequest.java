package com.misfit.ble.shine;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.hb;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class CustomCommandRequest extends CustomRequest {
    private Response eq;
    private String er;
    private int es;
    private boolean et;

    public class CharacteristicResponse {
        private String er;
        private byte[] eu;
        final /* synthetic */ CustomCommandRequest ev;

        public CharacteristicResponse(CustomCommandRequest customCommandRequest, String str, byte[] bArr) {
            this.ev = customCommandRequest;
            this.er = str;
            this.eu = bArr;
        }

        public String getCharacteristicUUID() {
            return this.er;
        }

        public byte[] getResponseData() {
            return this.eu;
        }

        public String toString() {
            return new StringBuffer(this.er.substring(0, 8)).append(" -> ").append(hb.m15159E(this.eu)).toString();
        }
    }

    public static class Response extends CustomResponse {
        public List<CharacteristicResponse> data = new ArrayList();
    }

    public CustomResponse getResponse() {
        return this.eq;
    }

    public CustomCommandRequest(byte[] bArr, String str, int i, boolean z) {
        this.es = 1000;
        this.et = false;
        this.isForced = false;
        this.er = str;
        this.es = i;
        this.mRequestData = bArr;
        this.et = z;
        this.eq = new Response();
    }

    public String getRequestName() {
        return "customCommand";
    }

    public String getCharacteristicUUID() {
        return this.er;
    }

    public byte[] getRequestData() {
        return this.mRequestData;
    }

    public void handleResponse(String str, byte[] bArr) {
        this.eq.data.add(new CharacteristicResponse(this, str, bArr));
    }

    public int getTimeOut() {
        return this.es;
    }

    public void onRequestSent(int i) {
        if (!this.et) {
            this.mIsCompleted = true;
        }
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.er);
            jSONObject.put("timeout", this.es);
            jSONObject.put("hasResponse", this.et);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", this.eq.data);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
