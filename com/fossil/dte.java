package com.fossil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.facebook.appevents.AppEventsConstants;
import com.misfit.frameworks.common.constants.Constants;

class dte extends dti {
    private Activity dqX;
    private dsp dqZ;
    private dtd drm;

    public dte(Activity activity, dtd com_fossil_dtd) {
        this.dqX = activity;
        this.drm = com_fossil_dtd;
        this.dqZ = com_fossil_dtd.awQ();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.drF != null) {
            this.drF.mo2690a(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.drF != null) {
            this.drF.mo2691a(webView, str);
        }
        if (!str.startsWith("sinaweibo://browser/close")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        Bundle ks = duq.ks(str);
        if (!(ks.isEmpty() || this.dqZ == null)) {
            this.dqZ.mo1909G(ks);
        }
        CharSequence string = ks.getString("code");
        String string2 = ks.getString(Constants.MSG);
        if (TextUtils.isEmpty(string)) {
            this.drm.m9685A(this.dqX);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(string)) {
            this.drm.m9686B(this.dqX);
        } else {
            this.drm.m9690b(this.dqX, string2);
        }
        dth.m9698a(this.dqX, this.drm.awR(), null);
        return true;
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.drF != null) {
            this.drF.mo2692b(webView, str);
        }
        super.onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.drF != null) {
            this.drF.mo2688a(webView, i, str, str2);
        }
        this.drm.m9690b(this.dqX, str);
        dth.m9698a(this.dqX, this.drm.awR(), null);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.drF != null) {
            this.drF.mo2689a(webView, sslErrorHandler, sslError);
        }
        sslErrorHandler.cancel();
        this.drm.m9690b(this.dqX, "ReceivedSslError");
        dth.m9698a(this.dqX, this.drm.awR(), null);
    }
}
