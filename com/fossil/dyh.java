package com.fossil;

import android.os.Bundle;

public abstract class dyh {
    public int dAO;
    public String dAP;
    public String dqb;
    public String openId;

    public void mo2782Q(Bundle bundle) {
        this.dAO = bundle.getInt("_wxapi_baseresp_errcode");
        this.dAP = bundle.getString("_wxapi_baseresp_errstr");
        this.dqb = bundle.getString("_wxapi_baseresp_transaction");
        this.openId = bundle.getString("_wxapi_baseresp_openId");
    }

    public abstract int getType();
}
