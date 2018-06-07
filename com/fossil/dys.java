package com.fossil;

import android.os.Bundle;

public class dys extends dyh {
    public String dBc;
    public String dBd;
    public String dBe;

    public dys(Bundle bundle) {
        mo2782Q(bundle);
    }

    public void mo2782Q(Bundle bundle) {
        super.mo2782Q(bundle);
        this.dBc = bundle.getString("_wxapi_payresp_prepayid");
        this.dBd = bundle.getString("_wxapi_payresp_returnkey");
        this.dBe = bundle.getString("_wxapi_payresp_extdata");
    }

    public int getType() {
        return 5;
    }
}
