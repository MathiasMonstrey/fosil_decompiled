package com.misfit.frameworks.common.entities;

import android.graphics.Color;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.Gesture;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ButtonGallery implements Serializable {
    private String androidStoreUrl;
    private int appId;
    private String appName;
    private String comName;
    private String desc;
    private String descPicUrl;
    private Map<Gesture, String> gestureDescMap = new HashMap();
    private String id;
    private String jsonString;
    private String logoUrl;
    private String packageName;
    private int themeColor;
    private int themeColorSecondary;
    private int versionCode;

    public String getDescPicUrl() {
        return this.descPicUrl;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getAndroidStoreUrl() {
        return this.androidStoreUrl;
    }

    public int getThemeColorSecondary() {
        return this.themeColorSecondary;
    }

    public int getThemeColor() {
        return this.themeColor;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public String getComName() {
        return this.comName;
    }

    public int getAppId() {
        return this.appId;
    }

    public void setAppId(int i) {
        this.appId = i;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getJsonString() {
        return this.jsonString;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public Map<Gesture, String> getGestureDescMap() {
        return this.gestureDescMap;
    }

    public static ButtonGallery objectFromJson(JSONObject jSONObject) {
        ButtonGallery buttonGallery = new ButtonGallery();
        try {
            int parseInt;
            String string = jSONObject.getString("id");
            try {
                parseInt = Integer.parseInt(jSONObject.getString("appId"));
            } catch (Exception e) {
                parseInt = jSONObject.getInt("appId");
            }
            if (string != null) {
                if (!(string.isEmpty() || parseInt == 0)) {
                    buttonGallery.id = string;
                    buttonGallery.appId = parseInt;
                    buttonGallery.appName = jSONObject.getString("appName");
                    buttonGallery.desc = jSONObject.getString(Constants.DESC);
                    buttonGallery.comName = jSONObject.getString("comName");
                    buttonGallery.logoUrl = jSONObject.getString("logoUrl");
                    buttonGallery.themeColor = Color.parseColor(jSONObject.getString("themeColor"));
                    buttonGallery.themeColorSecondary = Color.parseColor(jSONObject.getString("themeColorSecondary"));
                    buttonGallery.androidStoreUrl = jSONObject.getString("androidStoreUrl");
                    buttonGallery.packageName = jSONObject.getString("androidPackageName");
                    try {
                        buttonGallery.versionCode = Integer.parseInt(jSONObject.getString("lowestAndroidAppVersion"));
                    } catch (Exception e2) {
                    }
                    buttonGallery.descPicUrl = jSONObject.getString("descPicUrl");
                    JSONArray jSONArray = jSONObject.getJSONObject(Constants.COMMANDS).getJSONArray("data");
                    Map hashMap = new HashMap();
                    for (parseInt = 0; parseInt < jSONArray.length(); parseInt++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(parseInt);
                        String string2 = jSONObject2.getString("name");
                        String string3 = jSONObject2.getString(Constants.DESC);
                        if (!(string2.isEmpty() || string3.isEmpty())) {
                            hashMap.put(string2, string3);
                        }
                    }
                    jSONArray = jSONObject.getJSONObject(Constants.MAPPINGS).getJSONArray(Constants.DEFAULTS);
                    for (parseInt = 0; parseInt < jSONArray.length(); parseInt++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(parseInt);
                        buttonGallery.gestureDescMap.put(Gesture.values()[jSONObject3.getInt("gesture")], (String) hashMap.get(jSONObject3.getString("action")));
                    }
                    buttonGallery.jsonString = jSONObject.toString();
                    return buttonGallery;
                }
            }
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public String getMappingsString() {
        try {
            return new JSONObject(this.jsonString).getJSONObject(Constants.MAPPINGS).getJSONArray(Constants.DEFAULTS).toString();
        } catch (Exception e) {
            return null;
        }
    }
}
