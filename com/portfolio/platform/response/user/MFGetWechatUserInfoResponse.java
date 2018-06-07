package com.portfolio.platform.response.user;

import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.enums.Gender;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MFGetWechatUserInfoResponse extends MFResponse {
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    public static final String HEAD_IMAGE_URL = "headimgurl";
    public static final String NICK_NAME = "nickname";
    public static final String OPEN_ID = "openid";
    public static final String PRIVILEGE = "privilege";
    public static final String PROVINCE = "province";
    public static final String SEX = "sex";
    private static final String TAG = MFGetWechatUserInfoResponse.class.getSimpleName();
    public static final String UNION_ID = "unionid";
    private String city;
    private String country;
    private String nickName;
    private String openId;
    private ArrayList<String> privilege;
    private String profilePicture;
    private String province;
    private int sex;
    private String unionId;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            MFLogger.d(TAG, "Response: " + jSONObject.toString());
            if (jSONObject.has(OPEN_ID)) {
                this.openId = jSONObject.getString(OPEN_ID);
            }
            if (jSONObject.has(NICK_NAME)) {
                this.nickName = jSONObject.getString(NICK_NAME);
            }
            if (jSONObject.has(SEX)) {
                this.sex = jSONObject.getInt(SEX);
            }
            if (jSONObject.has(CITY)) {
                this.city = jSONObject.getString(CITY);
            }
            if (jSONObject.has(PROVINCE)) {
                this.province = jSONObject.getString(PROVINCE);
            }
            if (jSONObject.has(COUNTRY)) {
                this.country = jSONObject.getString(COUNTRY);
            }
            if (jSONObject.has(HEAD_IMAGE_URL)) {
                this.profilePicture = hw(jSONObject.getString(HEAD_IMAGE_URL));
            }
            if (jSONObject.has(UNION_ID)) {
                this.unionId = jSONObject.getString(UNION_ID);
            }
            if (jSONObject.has(PRIVILEGE)) {
                JSONArray jSONArray = jSONObject.getJSONArray(PRIVILEGE);
                if (jSONArray != null && jSONArray.length() > 0) {
                    this.privilege = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.privilege.add(jSONArray.getString(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getSex() {
        return this.sex;
    }

    public String getSexString() {
        switch (this.sex) {
            case 1:
                return Gender.MALE.toString();
            case 2:
                return Gender.FEMALE.toString();
            default:
                return Gender.OTHER.toString();
        }
    }

    public String getCity() {
        return this.city;
    }

    public String getProvince() {
        return this.province;
    }

    public String getCountry() {
        return this.country;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public ArrayList<String> getPrivilege() {
        return this.privilege;
    }

    public String getUnionId() {
        return this.unionId;
    }

    private String hw(String str) {
        return str != null ? str.replace("\\", "/") : "";
    }
}
