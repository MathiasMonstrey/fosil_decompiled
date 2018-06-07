package com.portfolio.platform.ui.profile.connectedapps.upbyjawbone;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fossil.cju;
import com.fossil.cmx;
import com.fossil.esl;
import com.fossil.esw;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import kotlin.TypeCastException;

public final class UpByJawBoneActivity extends cju {
    public static final C4950a cRN = new C4950a();
    private static final String ceH = UpByJawBoneActivity.class.getSimpleName();
    private String cRL;
    private Uri cRM;

    public static final class C4950a {
        private C4950a() {
        }

        public final String ZK() {
            return UpByJawBoneActivity.ceH;
        }

        public final void m15739z(Activity activity) {
            esl.j(activity, Constants.ACTIVITY);
            activity.startActivityForResult(cmx.by(activity), 101);
        }
    }

    public static final class C4951b extends WebViewClient {
        final /* synthetic */ UpByJawBoneActivity cRO;

        C4951b(UpByJawBoneActivity upByJawBoneActivity) {
            this.cRO = upByJawBoneActivity;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            String str2 = "code=";
            MFLogger.e(UpByJawBoneActivity.cRN.ZK(), "oauth response from server: " + str);
            Integer valueOf = str != null ? Integer.valueOf(esw.a(str, str2, 0, false, 6, null)) : null;
            if (valueOf == null) {
                esl.aGW();
            }
            if (valueOf.intValue() > -1) {
                MFLogger.d(UpByJawBoneActivity.cRN.ZK(), "user accepted, url is :" + str);
                UpByJawBoneActivity upByJawBoneActivity = this.cRO;
                int intValue = valueOf.intValue() + str2.length();
                int length = str.length();
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = str.substring(intValue, length);
                esl.i(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                upByJawBoneActivity.cRL = substring;
                substring = UpByJawBoneActivity.cRN.ZK();
                StringBuilder append = new StringBuilder().append("user accepted, code is :");
                String a = this.cRO.cRL;
                if (a == null) {
                    esl.aGW();
                }
                MFLogger.d(substring, append.append(a).toString());
                if (webView != null) {
                    webView.clearCache(true);
                }
                Intent intent = this.cRO.getIntent();
                intent.putExtra("code", this.cRO.cRL);
                this.cRO.setResult(-1, intent);
                this.cRO.finish();
            } else if (esw.a(str, "error=access_denied", false, 2, null)) {
                this.cRO.setResult(0);
                this.cRO.finish();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        this.cRM = (Uri) getIntent().getParcelableExtra(UpPlatformSdkConstants.AUTH_URI);
        super.onCreate(bundle);
    }

    public void ZF() {
        fN(String.valueOf(this.cRM));
        super.ZF();
    }

    public WebViewClient ZG() {
        return new C4951b(this);
    }
}
