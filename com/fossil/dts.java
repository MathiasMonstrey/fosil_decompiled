package com.fossil;

import android.content.Context;

public class dts extends dtr {
    public dts(Context context, String str, dso com_fossil_dso) {
        super(context, str, com_fossil_dso);
    }

    public void m9735a(dto com_fossil_dto) {
        m9734a("https://api.weibo.com/oauth2/revokeoauth2", new dtq(this.dqh), "POST", com_fossil_dto);
    }
}
