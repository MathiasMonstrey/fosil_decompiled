package com.fossil;

import org.json.JSONException;
import org.json.JSONObject;

public class dzd {
    private String aWS = "";
    private String aWX = "";
    private long aXm = 0;
    private int f1467b = 0;
    private int f1468d = 0;

    public void aP(long j) {
        this.aXm = j;
    }

    public void lg(String str) {
        this.aWX = str;
    }

    public void setDomain(String str) {
        this.aWS = str;
    }

    public void setPort(int i) {
        this.f1468d = i;
    }

    public void setStatusCode(int i) {
        this.f1467b = i;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.aXm);
            jSONObject.put("st", this.f1467b);
            if (this.aWS != null) {
                jSONObject.put("dm", this.aWS);
            }
            jSONObject.put("pt", this.f1468d);
            if (this.aWX != null) {
                jSONObject.put("rip", this.aWX);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
