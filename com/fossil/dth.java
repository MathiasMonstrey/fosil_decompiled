package com.fossil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v8.renderscript.ScriptIntrinsicBLAS;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fossil.dtd.C3183a;
import com.sina.weibo.sdk.component.BrowserLauncher;
import com.sina.weibo.sdk.component.view.LoadingBar;
import com.sina.weibo.sdk.exception.WeiboException;

public class dth extends Activity implements dta {
    private static final String TAG = dth.class.getName();
    private String cxk;
    private Boolean drA = Boolean.valueOf(false);
    private dtb drB;
    private dti drC;
    private String drd;
    private String drr;
    private boolean drs;
    private boolean drt;
    private TextView dru;
    private TextView drv;
    private WebView drw;
    private LoadingBar drx;
    private LinearLayout dry;
    private Button drz;

    class C31852 implements OnClickListener {
        final /* synthetic */ dth drD;

        C31852(dth com_fossil_dth) {
            this.drD = com_fossil_dth;
        }

        public void onClick(View view) {
            if (this.drD.drB != null) {
                this.drD.drB.mo2685d(this.drD, 3);
            }
            this.drD.finish();
        }
    }

    class C31863 implements OnClickListener {
        final /* synthetic */ dth drD;

        C31863(dth com_fossil_dth) {
            this.drD = com_fossil_dth;
        }

        public void onClick(View view) {
            this.drD.jN(this.drD.cxk);
            this.drD.drt = false;
        }
    }

    class C3187a extends WebChromeClient {
        final /* synthetic */ dth drD;

        private C3187a(dth com_fossil_dth) {
            this.drD = com_fossil_dth;
        }

        public void onProgressChanged(WebView webView, int i) {
            this.drD.drx.mu(i);
            if (i == 100) {
                this.drD.drs = false;
                this.drD.axd();
            } else if (!this.drD.drs) {
                this.drD.drs = true;
                this.drD.axd();
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (!this.drD.jO(this.drD.cxk) && !this.drD.drA.booleanValue()) {
                this.drD.drr = str;
                this.drD.axa();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (m9715r(getIntent())) {
            axb();
            awY();
            if (m9704a(this.drB)) {
                startShare();
                return;
            } else {
                jN(this.cxk);
                return;
            }
        }
        finish();
    }

    private boolean m9715r(Intent intent) {
        Bundle extras = intent.getExtras();
        this.drB = m9696P(extras);
        if (this.drB != null) {
            this.cxk = this.drB.getUrl();
            this.drd = this.drB.awU();
        } else {
            String string = extras.getString("key_url");
            String string2 = extras.getString("key_specify_title");
            if (!TextUtils.isEmpty(string) && string.startsWith("http")) {
                this.cxk = string;
                this.drd = string2;
            }
        }
        if (TextUtils.isEmpty(this.cxk)) {
            return false;
        }
        duj.m9769d(TAG, "LOAD URL : " + this.cxk);
        return true;
    }

    private void jN(String str) {
        this.drw.loadUrl(str);
    }

    private void startShare() {
        duj.m9769d(TAG, "Enter startShare()............");
        final dtd com_fossil_dtd = (dtd) this.drB;
        if (com_fossil_dtd.awV()) {
            duj.m9769d(TAG, "loadUrl hasImage............");
            new dtl(this).m9729a("http://service.weibo.com/share/mobilesdk_uppic.php", com_fossil_dtd.m9689a(new dtq(com_fossil_dtd.awy())), "POST", new dto(this) {
                final /* synthetic */ dth drD;

                public void mo2686a(WeiboException weiboException) {
                    duj.m9769d(dth.TAG, "post onWeiboException " + weiboException.getMessage());
                    com_fossil_dtd.m9690b(this.drD, weiboException.getMessage());
                    this.drD.finish();
                }

                public void jP(String str) {
                    duj.m9769d(dth.TAG, "post onComplete : " + str);
                    C3183a jI = C3183a.jI(str);
                    if (jI == null || jI.getCode() != 1 || TextUtils.isEmpty(jI.awW())) {
                        com_fossil_dtd.m9690b(this.drD, "upload pic faild");
                        this.drD.finish();
                        return;
                    }
                    this.drD.jN(com_fossil_dtd.jH(jI.awW()));
                }
            });
            return;
        }
        jN(this.cxk);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void awY() {
        this.drw.getSettings().setJavaScriptEnabled(true);
        if (m9704a(this.drB)) {
            this.drw.getSettings().setUserAgentString(duq.df(this));
        }
        this.drw.getSettings().setSavePassword(false);
        this.drw.setWebViewClient(this.drC);
        this.drw.setWebChromeClient(new C3187a());
        this.drw.requestFocus();
        this.drw.setScrollBarStyle(0);
        if (VERSION.SDK_INT >= 11) {
            this.drw.removeJavascriptInterface("searchBoxJavaBridge_");
        } else {
            m9716a(this.drw);
        }
    }

    private void awZ() {
        this.drv.setText(this.drd);
        this.dru.setOnClickListener(new C31852(this));
    }

    private void axa() {
        CharSequence charSequence = "";
        if (!TextUtils.isEmpty(this.drr)) {
            charSequence = this.drr;
        } else if (!TextUtils.isEmpty(this.drd)) {
            charSequence = this.drd;
        }
        this.drv.setText(charSequence);
    }

    private void axb() {
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(-1);
        View linearLayout = new LinearLayout(this);
        linearLayout.setId(1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2));
        View axc = axc();
        View textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, dum.m9773I(this, 2)));
        textView.setBackgroundDrawable(dum.m9775P(this, "weibosdk_common_shadow_top.9.png"));
        this.drx = new LoadingBar(this);
        this.drx.setBackgroundColor(0);
        this.drx.mu(0);
        this.drx.setLayoutParams(new LinearLayout.LayoutParams(-1, dum.m9773I(this, 3)));
        linearLayout.addView(axc);
        linearLayout.addView(textView);
        linearLayout.addView(this.drx);
        this.drw = new WebView(this);
        this.drw.setBackgroundColor(-1);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 1);
        this.drw.setLayoutParams(layoutParams);
        this.dry = new LinearLayout(this);
        this.dry.setVisibility(8);
        this.dry.setOrientation(1);
        this.dry.setGravity(17);
        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 1);
        this.dry.setLayoutParams(layoutParams);
        axc = new ImageView(this);
        axc.setImageDrawable(dum.m9774O(this, "weibosdk_empty_failed.png"));
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        int I = dum.m9773I(this, 8);
        layoutParams2.bottomMargin = I;
        layoutParams2.rightMargin = I;
        layoutParams2.topMargin = I;
        layoutParams2.leftMargin = I;
        axc.setLayoutParams(layoutParams2);
        this.dry.addView(axc);
        axc = new TextView(this);
        axc.setGravity(1);
        axc.setTextColor(-4342339);
        axc.setTextSize(2, 14.0f);
        axc.setText(dum.m9779c(this, "A network error occurs, please tap the button to reload", "网络出错啦，请点击按钮重新加载", "網路出錯啦，請點擊按鈕重新載入"));
        axc.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dry.addView(axc);
        this.drz = new Button(this);
        this.drz.setGravity(17);
        this.drz.setTextColor(-8882056);
        this.drz.setTextSize(2, 16.0f);
        this.drz.setText(dum.m9779c(this, "channel_data_error", "重新加载", "重新載入"));
        this.drz.setBackgroundDrawable(dum.m9782g((Context) this, "weibosdk_common_button_alpha.9.png", "weibosdk_common_button_alpha_highlighted.9.png"));
        layoutParams = new LinearLayout.LayoutParams(dum.m9773I(this, ScriptIntrinsicBLAS.RIGHT), dum.m9773I(this, 46));
        layoutParams.topMargin = dum.m9773I(this, 10);
        this.drz.setLayoutParams(layoutParams);
        this.drz.setOnClickListener(new C31863(this));
        this.dry.addView(this.drz);
        relativeLayout.addView(linearLayout);
        relativeLayout.addView(this.drw);
        relativeLayout.addView(this.dry);
        setContentView(relativeLayout);
        awZ();
    }

    private View axc() {
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LayoutParams(-1, dum.m9773I(this, 45)));
        relativeLayout.setBackgroundDrawable(dum.m9775P(this, "weibosdk_navigationbar_background.9.png"));
        this.dru = new TextView(this);
        this.dru.setClickable(true);
        this.dru.setTextSize(2, 17.0f);
        this.dru.setTextColor(dum.m9783n(-32256, 1728020992));
        this.dru.setText(dum.m9779c(this, "Close", "关闭", "关闭"));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5);
        layoutParams.addRule(15);
        layoutParams.leftMargin = dum.m9773I(this, 10);
        layoutParams.rightMargin = dum.m9773I(this, 10);
        this.dru.setLayoutParams(layoutParams);
        relativeLayout.addView(this.dru);
        this.drv = new TextView(this);
        this.drv.setTextSize(2, 18.0f);
        this.drv.setTextColor(-11382190);
        this.drv.setEllipsize(TruncateAt.END);
        this.drv.setSingleLine(true);
        this.drv.setGravity(17);
        this.drv.setMaxWidth(dum.m9773I(this, 160));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.drv.setLayoutParams(layoutParams);
        relativeLayout.addView(this.drv);
        return relativeLayout;
    }

    protected void axd() {
        if (this.drs) {
            axf();
        } else {
            axe();
        }
    }

    private void axe() {
        axa();
        this.drx.setVisibility(8);
    }

    private void axf() {
        this.drv.setText(dum.m9779c(this, "Loading....", "加载中....", "載入中...."));
        this.drx.setVisibility(0);
    }

    private void m9706b(WebView webView, int i, String str, String str2) {
        if (!str2.startsWith("sinaweibo")) {
            this.drt = true;
            axg();
        }
    }

    private void axg() {
        this.dry.setVisibility(0);
        this.drw.setVisibility(8);
    }

    private void axh() {
        this.dry.setVisibility(8);
        this.drw.setVisibility(0);
    }

    private boolean jO(String str) {
        if (!TextUtils.isEmpty(str) && "sinaweibo".equalsIgnoreCase(Uri.parse(str).getAuthority())) {
            return true;
        }
        return false;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        dul.de(this);
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.drB != null) {
            this.drB.mo2685d(this, 3);
        }
        finish();
        return true;
    }

    private dtb m9696P(Bundle bundle) {
        this.drA = Boolean.valueOf(false);
        BrowserLauncher browserLauncher = (BrowserLauncher) bundle.getSerializable("key_launcher");
        if (browserLauncher == BrowserLauncher.AUTH) {
            dsy com_fossil_dsy = new dsy(this);
            com_fossil_dsy.m9666N(bundle);
            m9699a(com_fossil_dsy);
            return com_fossil_dsy;
        } else if (browserLauncher == BrowserLauncher.SHARE) {
            dtd com_fossil_dtd = new dtd(this);
            com_fossil_dtd.m9666N(bundle);
            m9701a(com_fossil_dtd);
            return com_fossil_dtd;
        } else if (browserLauncher == BrowserLauncher.WIDGET) {
            dtj com_fossil_dtj = new dtj(this);
            com_fossil_dtj.m9666N(bundle);
            m9703a(com_fossil_dtj);
            return com_fossil_dtj;
        } else if (browserLauncher != BrowserLauncher.GAME) {
            return null;
        } else {
            this.drA = Boolean.valueOf(true);
            dtc com_fossil_dtc = new dtc(this);
            com_fossil_dtc.m9666N(bundle);
            m9700a(com_fossil_dtc);
            return com_fossil_dtc;
        }
    }

    private boolean m9704a(dtb com_fossil_dtb) {
        return com_fossil_dtb != null && com_fossil_dtb.awT() == BrowserLauncher.SHARE;
    }

    private void m9699a(dsy com_fossil_dsy) {
        this.drC = new dsz(this, com_fossil_dsy);
        this.drC.m9673a(this);
    }

    private void m9701a(dtd com_fossil_dtd) {
        dti com_fossil_dte = new dte(this, com_fossil_dtd);
        com_fossil_dte.m9673a(this);
        this.drC = com_fossil_dte;
    }

    private void m9703a(dtj com_fossil_dtj) {
        dti com_fossil_dtk = new dtk(this, com_fossil_dtj);
        com_fossil_dtk.m9673a(this);
        this.drC = com_fossil_dtk;
    }

    private void m9700a(dtc com_fossil_dtc) {
        dti com_fossil_dtg = new dtg(this, com_fossil_dtc);
        com_fossil_dtg.m9673a(this);
        this.drC = com_fossil_dtg;
    }

    public void mo2690a(WebView webView, String str, Bitmap bitmap) {
        duj.m9769d(TAG, "onPageStarted URL: " + str);
        this.cxk = str;
        if (!jO(str)) {
            this.drr = "";
        }
    }

    public boolean mo2691a(WebView webView, String str) {
        duj.m9771i(TAG, "shouldOverrideUrlLoading URL: " + str);
        return false;
    }

    public void mo2692b(WebView webView, String str) {
        duj.m9769d(TAG, "onPageFinished URL: " + str);
        if (this.drt) {
            axg();
            return;
        }
        this.drt = false;
        axh();
    }

    public void mo2688a(WebView webView, int i, String str, String str2) {
        duj.m9769d(TAG, "onReceivedError: errorCode = " + i + ", description = " + str + ", failingUrl = " + str2);
        m9706b(webView, i, str, str2);
    }

    public void mo2689a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        duj.m9769d(TAG, "onReceivedSslErrorCallBack.........");
    }

    public static void m9698a(Activity activity, String str, String str2) {
        dtf cL = dtf.cL(activity.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
            cL.jK(str);
            activity.finish();
        }
        if (!TextUtils.isEmpty(str2)) {
            cL.jM(str2);
            activity.finish();
        }
    }

    public void m9716a(WebView webView) {
        if (VERSION.SDK_INT < 11) {
            try {
                webView.getClass().getDeclaredMethod("removeJavascriptInterface", new Class[0]).invoke("searchBoxJavaBridge_", new Object[0]);
            } catch (Exception e) {
                duj.m9770e(TAG, e.toString());
            }
        }
    }
}
