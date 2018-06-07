package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.component.BrowserLauncher;

public class dtc extends dtb {
    private String dqW;
    private String dqh;
    private dsp dqr;
    private String dre;

    public dtc(Context context) {
        super(context);
        this.drc = BrowserLauncher.WIDGET;
    }

    protected void mo2683L(Bundle bundle) {
        this.dqh = bundle.getString("source");
        this.dre = bundle.getString("access_token");
        this.dqW = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(this.dqW)) {
            this.dqr = dtf.cL(this.mContext).jJ(this.dqW);
        }
        this.cxk = jH(this.cxk);
    }

    public void mo2684M(Bundle bundle) {
        bundle.putString("access_token", this.dre);
        bundle.putString("source", this.dqh);
        dtf cL = dtf.cL(this.mContext);
        if (this.dqr != null) {
            this.dqW = cL.awX();
            cL.m9692a(this.dqW, this.dqr);
            bundle.putString("key_listener", this.dqW);
        }
    }

    private String jH(String str) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("version", "0031405000");
        if (!TextUtils.isEmpty(this.dqh)) {
            buildUpon.appendQueryParameter("source", this.dqh);
        }
        if (!TextUtils.isEmpty(this.dre)) {
            buildUpon.appendQueryParameter("access_token", this.dre);
        }
        return buildUpon.build().toString();
    }

    public dsp awQ() {
        return this.dqr;
    }

    public String awR() {
        return this.dqW;
    }

    public void mo2685d(Activity activity, int i) {
    }
}
