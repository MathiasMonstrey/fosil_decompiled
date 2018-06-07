package com.fossil;

import android.content.Context;
import android.text.TextUtils;

public abstract class dtr {
    private static final String TAG = dtr.class.getName();
    protected String dqh;
    protected dso dsz;
    protected Context mContext;

    public dtr(Context context, String str, dso com_fossil_dso) {
        this.mContext = context;
        this.dqh = str;
        this.dsz = com_fossil_dso;
    }

    protected void m9734a(String str, dtq com_fossil_dtq, String str2, dto com_fossil_dto) {
        if (this.dsz == null || TextUtils.isEmpty(str) || com_fossil_dtq == null || TextUtils.isEmpty(str2) || com_fossil_dto == null) {
            duj.m9770e(TAG, "Argument error!");
            return;
        }
        com_fossil_dtq.put("access_token", this.dsz.getToken());
        new dtl(this.mContext).m9729a(str, com_fossil_dtq, str2, com_fossil_dto);
    }
}
