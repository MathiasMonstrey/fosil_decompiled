package com.fossil;

import android.os.Bundle;

public abstract class dyg {
    public String dqb;
    public String openId;

    public void mo2784Q(Bundle bundle) {
        this.dqb = dyb.m10276i(bundle, "_wxapi_basereq_transaction");
        this.openId = dyb.m10276i(bundle, "_wxapi_basereq_openid");
    }

    public abstract boolean checkArgs();

    public abstract int getType();

    public void mo2787o(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", this.dqb);
        bundle.putString("_wxapi_basereq_openid", this.openId);
    }
}
