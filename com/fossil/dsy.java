package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.component.BrowserLauncher;

public class dsy extends dtb {
    private String dqW;
    private dsp dqr;
    private dsn dqv;

    public dsy(Context context) {
        super(context);
        this.drc = BrowserLauncher.AUTH;
    }

    protected void mo2683L(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("key_authinfo");
        if (bundle2 != null) {
            this.dqv = dsn.m9624e(this.mContext, bundle2);
        }
        this.dqW = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(this.dqW)) {
            this.dqr = dtf.cL(this.mContext).jJ(this.dqW);
        }
    }

    public void mo2684M(Bundle bundle) {
        if (this.dqv != null) {
            bundle.putBundle("key_authinfo", this.dqv.awB());
        }
        if (this.dqr != null) {
            dtf cL = dtf.cL(this.mContext);
            this.dqW = cL.awX();
            cL.m9692a(this.dqW, this.dqr);
            bundle.putString("key_listener", this.dqW);
        }
    }

    public void mo2685d(Activity activity, int i) {
        if (i == 3) {
            if (this.dqr != null) {
                this.dqr.onCancel();
            }
            dth.m9698a(activity, this.dqW, null);
        }
    }

    public dsn awE() {
        return this.dqv;
    }

    public void m9670a(dsn com_fossil_dsn) {
        this.dqv = com_fossil_dsn;
    }

    public dsp awQ() {
        return this.dqr;
    }

    public String awR() {
        return this.dqW;
    }

    public void m9671c(dsp com_fossil_dsp) {
        this.dqr = com_fossil_dsp;
    }
}
