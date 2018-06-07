package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.component.BrowserLauncher;

public class dtj extends dtb {
    private String dqW;
    private String dqh;
    private dsp dqr;
    private C3188a drG;
    private String drH;
    private String drI;
    private String drJ;
    private String drK;
    private String drL;
    private String dre;
    private String drf;
    private String drg;

    public interface C3188a {
        void jV(String str);
    }

    public dtj(Context context) {
        super(context);
        this.drc = BrowserLauncher.WIDGET;
    }

    protected void mo2683L(Bundle bundle) {
        this.dqh = bundle.getString("source");
        this.drf = bundle.getString("packagename");
        this.drg = bundle.getString("key_hash");
        this.dre = bundle.getString("access_token");
        this.drI = bundle.getString("fuid");
        this.drK = bundle.getString("q");
        this.drJ = bundle.getString("content");
        this.drL = bundle.getString("category");
        this.dqW = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(this.dqW)) {
            this.dqr = dtf.cL(this.mContext).jJ(this.dqW);
        }
        this.drH = bundle.getString("key_widget_callback");
        if (!TextUtils.isEmpty(this.drH)) {
            this.drG = dtf.cL(this.mContext).jL(this.drH);
        }
        this.cxk = jH(this.cxk);
    }

    public void mo2684M(Bundle bundle) {
        this.drf = this.mContext.getPackageName();
        if (!TextUtils.isEmpty(this.drf)) {
            this.drg = duk.kn(duq.m9791T(this.mContext, this.drf));
        }
        bundle.putString("access_token", this.dre);
        bundle.putString("source", this.dqh);
        bundle.putString("packagename", this.drf);
        bundle.putString("key_hash", this.drg);
        bundle.putString("fuid", this.drI);
        bundle.putString("q", this.drK);
        bundle.putString("content", this.drJ);
        bundle.putString("category", this.drL);
        dtf cL = dtf.cL(this.mContext);
        if (this.dqr != null) {
            this.dqW = cL.awX();
            cL.m9692a(this.dqW, this.dqr);
            bundle.putString("key_listener", this.dqW);
        }
        if (this.drG != null) {
            this.drH = cL.awX();
            cL.m9693a(this.drH, this.drG);
            bundle.putString("key_widget_callback", this.drH);
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
        Object U = duq.m9792U(this.mContext, this.dqh);
        if (!TextUtils.isEmpty(U)) {
            buildUpon.appendQueryParameter("aid", U);
        }
        if (!TextUtils.isEmpty(this.drf)) {
            buildUpon.appendQueryParameter("packagename", this.drf);
        }
        if (!TextUtils.isEmpty(this.drg)) {
            buildUpon.appendQueryParameter("key_hash", this.drg);
        }
        if (!TextUtils.isEmpty(this.drI)) {
            buildUpon.appendQueryParameter("fuid", this.drI);
        }
        if (!TextUtils.isEmpty(this.drK)) {
            buildUpon.appendQueryParameter("q", this.drK);
        }
        if (!TextUtils.isEmpty(this.drJ)) {
            buildUpon.appendQueryParameter("content", this.drJ);
        }
        if (!TextUtils.isEmpty(this.drL)) {
            buildUpon.appendQueryParameter("category", this.drL);
        }
        return buildUpon.build().toString();
    }

    public void jQ(String str) {
        this.drI = str;
    }

    public void jR(String str) {
        this.drJ = str;
    }

    public void jS(String str) {
        this.drK = str;
    }

    public void jT(String str) {
        this.drL = str;
    }

    public void setToken(String str) {
        this.dre = str;
    }

    public void jU(String str) {
        this.dqh = str;
    }

    public dsp awQ() {
        return this.dqr;
    }

    public String awR() {
        return this.dqW;
    }

    public void m9725c(dsp com_fossil_dsp) {
        this.dqr = com_fossil_dsp;
    }

    public C3188a axj() {
        return this.drG;
    }

    public String axk() {
        return this.drH;
    }

    public void m9724a(C3188a c3188a) {
        this.drG = c3188a;
    }

    public void mo2685d(Activity activity, int i) {
        if (i == 3) {
            dth.m9698a(activity, this.dqW, this.drH);
        }
    }
}
