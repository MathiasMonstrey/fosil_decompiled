package com.fossil;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fossil.gf.C3618a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;

public class cju extends ctj {
    private static final String ceH = cju.class.getSimpleName();
    private static final String ceI = ceI;
    private static final String ceJ = "title";
    public static final C2092a ceK = new C2092a();
    public ckp ceF;
    public String ceG;

    public static final class C2092a {
        private C2092a() {
        }

        public final String ZK() {
            return cju.ceH;
        }

        public final String ZL() {
            return cju.ceI;
        }

        public final String ZM() {
            return cju.ceJ;
        }
    }

    public static final class C2093b extends WebViewClient {
        final /* synthetic */ cju ceL;

        C2093b(cju com_fossil_cju) {
            this.ceL = com_fossil_cju;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            esl.m11128j(webView, "view");
            esl.m11128j(str, "url");
            MFLogger.m12670d(cju.ceK.ZK(), "Should override " + str);
            if (!etc.m11133a(str, "mailto", false, 2, null)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            MFLogger.m12670d(cju.ceK.ZK(), "We are overriding the mailto urlToLoad");
            String substring = str.substring(7);
            esl.m11127i(substring, "(this as java.lang.String).substring(startIndex)");
            C3618a j = C3618a.m11507j(this.ceL);
            j.m11508Y("message/rfc822");
            j.m11509Z(substring);
            j.iJ();
            return true;
        }
    }

    public static final class C2094c extends WebChromeClient {
        final /* synthetic */ cju ceL;

        C2094c(cju com_fossil_cju) {
            this.ceL = com_fossil_cju;
        }

        public void onProgressChanged(WebView webView, int i) {
            esl.m11128j(webView, "view");
            if (i == 100) {
                this.ceL.afM();
            }
        }
    }

    public ckp ZC() {
        ckp com_fossil_ckp = this.ceF;
        if (com_fossil_ckp == null) {
            esl.mF("binding");
        }
        return com_fossil_ckp;
    }

    public void m6649a(ckp com_fossil_ckp) {
        esl.m11128j(com_fossil_ckp, "<set-?>");
        this.ceF = com_fossil_ckp;
    }

    public String ZD() {
        String str = this.ceG;
        if (str == null) {
            esl.mF(ceI);
        }
        return str;
    }

    public void fN(String str) {
        esl.m11128j(str, "<set-?>");
        this.ceG = str;
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (getIntent().getStringExtra(ceK.ZL()) == null) {
            str = "";
        } else {
            str = getIntent().getStringExtra(ceK.ZL());
            esl.m11127i(str, "intent.getStringExtra(KEY_URL)");
        }
        fN(str);
        C2161i a = C3311e.m10383a(this, R.layout.activity_webview);
        esl.m11127i(a, "DataBindingUtil.setConte….layout.activity_webview)");
        m6649a((ckp) a);
        ZC().cpC.setText(getIntent().getStringExtra(ceK.ZM()));
        cj(true);
        ZE();
        ZF();
    }

    private final void ZE() {
        if (VERSION.SDK_INT >= 22) {
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager createInstance = CookieSyncManager.createInstance(getBaseContext());
        createInstance.startSync();
        CookieManager instance = CookieManager.getInstance();
        instance.removeAllCookie();
        instance.removeSessionCookie();
        createInstance.stopSync();
        createInstance.sync();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void ZF() {
        WebSettings settings = ZC().webView.getSettings();
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        ZC().webView.clearCache(true);
        ZC().webView.setWebViewClient(ZG());
        settings = ZC().webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        ZC().webView.setWebChromeClient(new C2094c(this));
        ZC().webView.loadUrl(ZD());
    }

    public WebViewClient ZG() {
        MFLogger.m12670d(ceK.ZK(), "Building default web client");
        return new C2093b(this);
    }
}
