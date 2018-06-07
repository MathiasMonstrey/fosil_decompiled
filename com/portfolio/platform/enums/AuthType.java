package com.portfolio.platform.enums;

import android.text.TextUtils;
import com.misfit.frameworks.common.constants.Constants;

public enum AuthType {
    EMAIL(Constants.EMAIL, false),
    FACEBOOK(Constants.FACEBOOK, true),
    GOOGLE("google", true),
    WECHAT("wechat", true),
    WEIBO("weibo", true);
    
    private boolean isSSO;
    private final String value;

    public String getValue() {
        return this.value;
    }

    private AuthType(String str, boolean z) {
        this.value = str;
        this.isSSO = z;
    }

    public boolean isSSO() {
        return this.isSSO;
    }

    public static AuthType fromString(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (AuthType authType : values()) {
                if (str.equalsIgnoreCase(authType.value)) {
                    return authType;
                }
            }
        }
        return null;
    }
}
