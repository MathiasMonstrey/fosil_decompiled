package com.fossil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

class dtg extends dti {
    private Activity dqX;
    private dsp dqZ = this.drq.awQ();
    private dtc drq;

    public dtg(Activity activity, dtc com_fossil_dtc) {
        this.dqX = activity;
        this.drq = com_fossil_dtc;
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
        dth.m9698a(this.dqX, this.drq.awR(), null);
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
        super.onReceivedError(webView, i, str, str2);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.drF != null) {
            this.drF.mo2689a(webView, sslErrorHandler, sslError);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }
}
