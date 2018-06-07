package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;

public class dsq {
    private static final String TAG = dsq.class.getName();
    private dsn dqv;
    private Context mContext;

    public dsq(Context context, dsn com_fossil_dsn) {
        this.mContext = context;
        this.dqv = com_fossil_dsn;
    }

    public dsn awE() {
        return this.dqv;
    }

    public void m9629b(dsp com_fossil_dsp) {
        m9628a(com_fossil_dsp, 1);
    }

    public void m9628a(dsp com_fossil_dsp, int i) {
        m9627b(com_fossil_dsp, i);
    }

    private void m9627b(dsp com_fossil_dsp, int i) {
        if (com_fossil_dsp != null) {
            dtq com_fossil_dtq = new dtq(this.dqv.awy());
            com_fossil_dtq.put("client_id", this.dqv.awy());
            com_fossil_dtq.put(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.dqv.getRedirectUrl());
            com_fossil_dtq.put("scope", this.dqv.awz());
            com_fossil_dtq.put(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code");
            com_fossil_dtq.put("version", "0031405000");
            Object U = duq.m9792U(this.mContext, this.dqv.awy());
            if (!TextUtils.isEmpty(U)) {
                com_fossil_dtq.put("aid", U);
            }
            if (1 == i) {
                com_fossil_dtq.put("packagename", this.dqv.getPackageName());
                com_fossil_dtq.put("key_hash", this.dqv.awA());
            }
            String str = "https://open.weibo.cn/oauth2/authorize?" + com_fossil_dtq.axw();
            if (dul.db(this.mContext)) {
                dsy com_fossil_dsy = new dsy(this.mContext);
                com_fossil_dsy.m9670a(this.dqv);
                com_fossil_dsy.m9671c(com_fossil_dsp);
                com_fossil_dsy.setUrl(str);
                com_fossil_dsy.jG("微博登录");
                Bundle awS = com_fossil_dsy.awS();
                Intent intent = new Intent(this.mContext, dth.class);
                intent.putExtras(awS);
                this.mContext.startActivity(intent);
                return;
            }
            dup.m9790j(this.mContext, "Error", "Application requires permission to access the Internet");
        }
    }
}
