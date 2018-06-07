package com.fossil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.facebook.internal.NativeProtocol;
import com.sina.weibo.sdk.exception.WeiboAuthException;

class dsz extends dti {
    private Activity dqX;
    private dsy dqY;
    private dsp dqZ;
    private boolean dra = false;

    public dsz(Activity activity, dsy com_fossil_dsy) {
        this.dqX = activity;
        this.dqY = com_fossil_dsy;
        this.dqZ = this.dqY.awQ();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.drF != null) {
            this.drF.mo2690a(webView, str, bitmap);
        }
        if (!str.startsWith(this.dqY.awE().getRedirectUrl()) || this.dra) {
            super.onPageStarted(webView, str, bitmap);
            return;
        }
        this.dra = true;
        jF(str);
        webView.stopLoading();
        dth.m9698a(this.dqX, this.dqY.awR(), null);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.drF != null) {
            this.drF.mo2691a(webView, str);
        }
        if (str.startsWith("sms:")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", str.replace("sms:", ""));
            intent.setType("vnd.android-dir/mms-sms");
            this.dqX.startActivity(intent);
            return true;
        } else if (!str.startsWith("sinaweibo://browser/close")) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            if (this.dqZ != null) {
                this.dqZ.onCancel();
            }
            dth.m9698a(this.dqX, this.dqY.awR(), null);
            return true;
        }
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

    private void jF(String str) {
        Bundle kr = duq.kr(str);
        String string = kr.getString("error");
        String string2 = kr.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
        String string3 = kr.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
        if (string == null && string2 == null) {
            if (this.dqZ != null) {
                this.dqZ.mo1909G(kr);
            }
        } else if (this.dqZ != null) {
            this.dqZ.mo1910a(new WeiboAuthException(string2, string, string3));
        }
    }
}
