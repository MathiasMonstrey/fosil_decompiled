package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.component.BrowserLauncher;

public abstract class dtb {
    protected String cxk;
    protected BrowserLauncher drc;
    protected String drd;
    protected Context mContext;

    protected abstract void mo2683L(Bundle bundle);

    protected abstract void mo2684M(Bundle bundle);

    public abstract void mo2685d(Activity activity, int i);

    public dtb(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void m9666N(Bundle bundle) {
        this.cxk = bundle.getString("key_url");
        this.drc = (BrowserLauncher) bundle.getSerializable("key_launcher");
        this.drd = bundle.getString("key_specify_title");
        mo2683L(bundle);
    }

    public Bundle awS() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.cxk)) {
            bundle.putString("key_url", this.cxk);
        }
        if (this.drc != null) {
            bundle.putSerializable("key_launcher", this.drc);
        }
        if (!TextUtils.isEmpty(this.drd)) {
            bundle.putString("key_specify_title", this.drd);
        }
        mo2684M(bundle);
        return bundle;
    }

    public void setUrl(String str) {
        this.cxk = str;
    }

    public String getUrl() {
        return this.cxk;
    }

    public BrowserLauncher awT() {
        return this.drc;
    }

    public void jG(String str) {
        this.drd = str;
    }

    public String awU() {
        return this.drd;
    }
}
