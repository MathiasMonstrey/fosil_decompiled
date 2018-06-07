package com.fossil;

import android.content.Context;
import android.content.Intent;
import com.facebook.GraphRequest;
import com.facebook.login.widget.ProfilePictureView;
import com.fossil.dyo.C3302a;
import com.fossil.dyo.C3303b;
import com.misfit.frameworks.common.log.MFLogger;

public class drj implements dyu {
    private static volatile drj dfu;
    private String appId;
    private C2244a dfr;
    private dyt dfs;
    private String dft;

    public interface C2244a {
        void adA();

        void adB();

        void adC();

        void gY(String str);
    }

    public static synchronized drj auQ() {
        drj com_fossil_drj;
        synchronized (drj.class) {
            if (dfu == null) {
                synchronized (drj.class) {
                    if (dfu == null) {
                        dfu = new drj();
                    }
                }
            }
            com_fossil_drj = dfu;
        }
        return com_fossil_drj;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void jv(String str) {
        this.dft = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public String auR() {
        return this.dft;
    }

    private drj() {
    }

    public void initialize(Context context) {
        this.dfs = dyw.m10311h(context, this.appId, false);
        this.dfs.lf(this.appId);
        MFLogger.m12672i(GraphRequest.TAG, "Wechat, initialize");
    }

    public void m9484a(Context context, C2244a c2244a) {
        MFLogger.m12672i(GraphRequest.TAG, "Wechat, login...");
        this.dfr = c2244a;
        if (this.dfs.aBD()) {
            dyg c3302a = new C3302a();
            c3302a.cAX = "snsapi_userinfo";
            c3302a.state = "com.fossil.wearables.fossil.tag_wechat_login";
            if (!this.dfs.mo2790b(c3302a)) {
                this.dfr.adA();
            }
            MFLogger.m12672i(GraphRequest.TAG, "Wechat, start authorize...");
            return;
        }
        this.dfr.adC();
    }

    public void mo1901a(dyg com_fossil_dyg) {
    }

    public void mo1902a(dyh com_fossil_dyh) {
        MFLogger.m12672i(GraphRequest.TAG, "Wechat, onResp...");
        switch (com_fossil_dyh.dAO) {
            case ProfilePictureView.LARGE /*-4*/:
                m9483d(com_fossil_dyh);
                return;
            case -2:
                m9482c(com_fossil_dyh);
                return;
            case 0:
                m9481b(com_fossil_dyh);
                return;
            default:
                if (this.dfr != null) {
                    this.dfr.adB();
                    return;
                }
                return;
        }
    }

    private void m9481b(dyh com_fossil_dyh) {
        switch (com_fossil_dyh.getType()) {
            case 1:
                C3303b c3303b = (C3303b) com_fossil_dyh;
                if (c3303b.state.equals("com.fossil.wearables.fossil.tag_wechat_login")) {
                    MFLogger.m12672i(GraphRequest.TAG, "Wechat authorize succeed, data = " + c3303b.code + ", openid: " + c3303b.openId);
                    if (this.dfr != null) {
                        this.dfr.gY(c3303b.code);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m9482c(dyh com_fossil_dyh) {
        switch (com_fossil_dyh.getType()) {
            case 1:
                MFLogger.m12672i(GraphRequest.TAG, "Wechat authorize canceled!");
                if (this.dfr != null) {
                    this.dfr.adA();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m9483d(dyh com_fossil_dyh) {
        switch (com_fossil_dyh.getType()) {
            case 1:
                MFLogger.m12672i(GraphRequest.TAG, "Wechat authorize denied!");
                if (this.dfr != null) {
                    this.dfr.adB();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void m9485a(Intent intent, dyu com_fossil_dyu) {
        if (this.dfs != null) {
            this.dfs.mo2789b(intent, com_fossil_dyu);
        }
    }
}
