package com.portfolio.platform.ui.profile.connectedapps.underamourrecord;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fossil.cju;
import com.fossil.ecp;
import com.fossil.ecq;
import com.fossil.esl;
import com.fossil.esw;
import com.misfit.frameworks.common.constants.Constants;

public final class UnderAmourRecordActivity extends cju {
    private static final int cRH = cRH;
    private static final String cRI = cRI;
    public static final C4948a cRJ = new C4948a();

    public static final class C4948a {
        private C4948a() {
        }

        public final int anr() {
            return UnderAmourRecordActivity.cRH;
        }

        private final String ans() {
            return UnderAmourRecordActivity.cRI;
        }

        public final void m15738a(Activity activity, ecp com_fossil_ecp) {
            esl.j(activity, Constants.ACTIVITY);
            esl.j(com_fossil_ecp, "ua");
            Intent intent = new Intent(activity, UnderAmourRecordActivity.class);
            intent.putExtra(cju.ceK.ZL(), com_fossil_ecp.lo(ans()));
            activity.startActivityForResult(intent, anr());
        }
    }

    public static final class C4949b extends WebViewClient {
        final /* synthetic */ UnderAmourRecordActivity cRK;

        C4949b(UnderAmourRecordActivity underAmourRecordActivity) {
            this.cRK = underAmourRecordActivity;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            esl.j(webView, "view");
            esl.j(str, "url");
            if (esw.a(str, "www.mapmyfitness.com/my_home", false, 2, null)) {
                webView.loadUrl(this.cRK.ZD());
                return super.shouldOverrideUrlLoading(webView, str);
            } else if (!esw.a(str, "uasdk", false, 2, null)) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                ecq.debug("Got url: %s", str);
                String queryParameter = Uri.parse(str).getQueryParameter("code");
                if (queryParameter != null) {
                    Intent intent = this.cRK.getIntent();
                    if (intent == null) {
                        intent = new Intent();
                    }
                    intent.putExtra("code", queryParameter);
                    this.cRK.setResult(-1, intent);
                    this.cRK.finish();
                } else {
                    this.cRK.setResult(0);
                    this.cRK.finish();
                }
                return true;
            }
        }
    }

    public WebViewClient ZG() {
        return new C4949b(this);
    }
}
