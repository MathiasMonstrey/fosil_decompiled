package com.fossil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.internal.NativeProtocol;
import com.misfit.frameworks.common.constants.Constants;
import com.sina.weibo.sdk.component.view.ResizeableLayout;
import com.sina.weibo.sdk.component.view.ResizeableLayout.a;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.register.mobile.Country;
import java.util.Locale;
import org.json.JSONObject;

public class dtt extends Activity implements OnClickListener, OnFocusChangeListener, a {
    private static final String TAG = dtt.class.getName();
    private String bhE;
    private CountDownTimer cKz;
    private String dqQ;
    private String dqk;
    private String drd;
    private ProgressDialog dsI;
    private TitleBar dsJ;
    private ScrollView dsK;
    private LinearLayout dsL;
    private TextView dsM;
    private RelativeLayout dsN;
    private TextView dsO;
    private TextView dsP;
    private EditText dsQ;
    private ImageView dsR;
    private EditText dsS;
    private Button dsT;
    private TextView dsU;
    private Button dsV;
    private String dsW;
    private String dsX;
    private String dsY;
    private C3197b dsZ = new C3197b();
    private int oN = 0;

    class C31932 implements TitleBar.a {
        final /* synthetic */ dtt dta;

        C31932(dtt com_fossil_dtt) {
            this.dta = com_fossil_dtt;
        }

        public void axp() {
            this.dta.setResult(0);
            this.dta.finish();
        }
    }

    class C31943 implements dto {
        final /* synthetic */ dtt dta;

        C31943(dtt com_fossil_dtt) {
            this.dta = com_fossil_dtt;
        }

        public void mo2686a(WeiboException weiboException) {
            duj.m9769d(dtt.TAG, "get onWeiboException " + weiboException.getMessage());
            CharSequence c = dum.m9779c(this.dta.getApplicationContext(), "the server is busy, please  wait", "服务器忙,请稍后再试", "服務器忙,請稍後再試");
            try {
                JSONObject jSONObject = new JSONObject(weiboException.getMessage());
                if (!TextUtils.isEmpty(jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION))) {
                    c = jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            dup.m9789a(this.dta.getApplicationContext(), c, 1);
        }

        public void jP(String str) {
            duj.m9769d(dtt.TAG, "get onComplete : " + str);
            if (str != null) {
                try {
                    this.dta.dsY = (String) new JSONObject(str).get("cfrom");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class C3196a implements TextWatcher {
        final /* synthetic */ dtt dta;

        private C3196a(dtt com_fossil_dtt) {
            this.dta = com_fossil_dtt;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(this.dta.dsQ.getText().toString()) || TextUtils.isEmpty(this.dta.dsS.getText().toString())) {
                this.dta.axD();
            } else {
                this.dta.axE();
            }
        }
    }

    class C3197b extends Handler {
        final /* synthetic */ dtt dta;

        private C3197b(dtt com_fossil_dtt) {
            this.dta = com_fossil_dtt;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.dta.dsM.setVisibility(0);
                    this.dta.dsN.setVisibility(0);
                    return;
                case 1:
                    this.dta.dsM.setVisibility(8);
                    this.dta.dsN.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    class C3198c implements TextWatcher {
        final /* synthetic */ dtt dta;

        private C3198c(dtt com_fossil_dtt) {
            this.dta = com_fossil_dtt;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (TextUtils.isEmpty(this.dta.dsQ.getText().toString())) {
                this.dta.dsR.setVisibility(4);
            } else {
                this.dta.dsR.setVisibility(0);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(this.dta.dsQ.getText().toString()) || TextUtils.isEmpty(this.dta.dsS.getText().toString())) {
                this.dta.axD();
            } else {
                this.dta.axE();
            }
        }
    }

    class C3199d extends ClickableSpan {
        private Context context;
        final /* synthetic */ dtt dta;
        private String url;

        public C3199d(dtt com_fossil_dtt, Context context, String str) {
            this.dta = com_fossil_dtt;
            this.context = context;
            this.url = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.context, dth.class);
            Bundle bundle = new Bundle();
            bundle.putString("key_url", this.url);
            intent.putExtras(bundle);
            this.dta.startActivity(intent);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(-11502161);
            textPaint.setUnderlineText(false);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            dup.m9789a(getApplicationContext(), "Pass wrong params!!", 0);
            finish();
        }
        this.dqQ = extras.getString("appKey");
        this.bhE = extras.getString("packagename");
        this.dqk = extras.getString("key_hash");
        if (TextUtils.isEmpty(this.dqQ)) {
            dup.m9789a(getApplicationContext(), dum.m9779c(this, "your appkey not set", "您的app_key没有设置", "您的app_key沒有設置"), 0);
            finish();
        }
        String string = extras.getString("register_title");
        if (TextUtils.isEmpty(string)) {
            string = dum.m9779c(this, "Login", "验证码登录", "驗證碼登錄");
        }
        this.drd = string;
        this.dsW = Country.CHINA_CODE;
        this.dsX = dum.m9779c(this, "China", "中国", "中國");
        avf();
        this.cKz = new CountDownTimer(this, 60000, 1000) {
            final /* synthetic */ dtt dta;

            public void onTick(long j) {
                this.dta.dsT.setText(new StringBuilder(String.valueOf(dum.m9779c(this.dta.getApplicationContext(), "Get code", "获取验证码", "獲取驗證碼"))).append("(").append(j / 1000).append("s)").toString());
            }

            public void onFinish() {
                this.dta.dsT.setText(dum.m9779c(this.dta.getApplicationContext(), "Get code", "获取验证码", "獲取驗證碼"));
                this.dta.axC();
            }
        };
    }

    private void avf() {
        View resizeableLayout = new ResizeableLayout(this);
        resizeableLayout.setLayoutParams(new LayoutParams(-1, -1));
        resizeableLayout.setBackgroundColor(-855310);
        this.dsJ = new TitleBar(this);
        this.dsJ.setId(1);
        this.dsJ.setLeftBtnText(dum.m9779c(this, "Cancel", "取消", "取消"));
        this.dsJ.setTitleBarText(this.drd);
        this.dsJ.setTitleBarClickListener(new C31932(this));
        resizeableLayout.addView(this.dsJ);
        View view = new View(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dum.m9773I(this, 2));
        view.setBackgroundDrawable(dum.m9775P(this, "weibosdk_common_shadow_top.9.png"));
        layoutParams.addRule(3, 1);
        view.setLayoutParams(layoutParams);
        resizeableLayout.addView(view);
        this.dsK = new ScrollView(this);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = dum.m9773I(this, 47);
        this.dsK.setBackgroundColor(-855310);
        this.dsK.setLayoutParams(layoutParams2);
        this.dsL = new LinearLayout(this);
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.dsL.setOrientation(1);
        this.dsL.setLayoutParams(layoutParams2);
        this.dsM = new TextView(this);
        this.dsM.setTextSize(2, 13.0f);
        this.dsM.setHeight(dum.m9773I(this, 44));
        this.dsM.setGravity(17);
        this.dsM.setTextColor(-8224126);
        this.dsM.setText(dum.m9779c(this, "Confirm your country/region and enter your mobile number", "请确认国家和地区并填写手机号码", "請確認國家和地區并填寫手機號"));
        this.dsM.setFocusable(true);
        this.dsM.setFocusableInTouchMode(true);
        this.dsL.addView(this.dsM);
        this.dsN = new RelativeLayout(this);
        layoutParams2 = new RelativeLayout.LayoutParams(-1, dum.m9773I(this, 48));
        this.dsN.setBackgroundDrawable(dum.m9782g((Context) this, "login_country_background.9.png", "login_country_background_highlighted.9.png"));
        this.dsN.setLayoutParams(layoutParams2);
        this.dsO = new TextView(this);
        this.dsO.setTextSize(2, 17.0f);
        this.dsO.setText(Country.CHINA_CODE);
        this.dsO.setTextColor(-11382190);
        this.dsO.setGravity(3);
        this.dsO.setGravity(16);
        layoutParams2 = new RelativeLayout.LayoutParams(-2, dum.m9773I(this, 48));
        layoutParams2.leftMargin = dum.m9773I(this, 15);
        layoutParams2.addRule(9);
        this.dsO.setLayoutParams(layoutParams2);
        view = new ImageView(this);
        view.setId(2);
        view.setImageDrawable(dum.m9774O(this, "triangle.png"));
        layoutParams = new RelativeLayout.LayoutParams(dum.m9773I(this, 13), dum.m9773I(this, 13));
        layoutParams.rightMargin = dum.m9773I(this, 15);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        view.setLayoutParams(layoutParams);
        this.dsP = new TextView(this);
        this.dsP.setTextSize(2, 17.0f);
        this.dsP.setTextColor(-11382190);
        this.dsP.setText(this.dsX);
        this.dsP.setGravity(16);
        layoutParams = new RelativeLayout.LayoutParams(-2, dum.m9773I(this, 48));
        layoutParams.rightMargin = dum.m9773I(this, 118);
        layoutParams.addRule(0, 2);
        layoutParams.addRule(15);
        this.dsP.setLayoutParams(layoutParams);
        this.dsN.addView(this.dsO);
        this.dsN.addView(this.dsP);
        this.dsN.addView(view);
        this.dsL.addView(this.dsN);
        view = new LinearLayout(this);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dum.m9773I(this, 10);
        view.setLayoutParams(layoutParams);
        view.setOrientation(1);
        View relativeLayout = new RelativeLayout(this);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, dum.m9773I(this, 50));
        layoutParams3.gravity = 16;
        relativeLayout.setBackgroundDrawable(dum.m9775P(this, "login_top_background.9.png"));
        relativeLayout.setLayoutParams(layoutParams3);
        this.dsR = new ImageView(this);
        this.dsR.setId(4);
        this.dsR.setImageDrawable(dum.m9782g((Context) this, "search_clear_btn_normal.png", "search_clear_btn_down.png"));
        layoutParams3 = new RelativeLayout.LayoutParams(dum.m9773I(this, 22), dum.m9773I(this, 22));
        layoutParams3.rightMargin = dum.m9773I(this, 15);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        this.dsR.setVisibility(4);
        this.dsR.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.dsR);
        this.dsQ = new EditText(this);
        this.dsQ.setTextSize(2, 16.0f);
        this.dsQ.setTextColor(-16777216);
        this.dsQ.setHint(dum.m9779c(this, "Your mobile number", "请输入手机号码", "請輸入手機號"));
        this.dsQ.setHintTextColor(-4342339);
        this.dsQ.setBackgroundDrawable(null);
        this.dsQ.setSelected(false);
        layoutParams3 = new RelativeLayout.LayoutParams(-1, dum.m9773I(this, 50));
        layoutParams3.topMargin = dum.m9773I(this, 0);
        layoutParams3.bottomMargin = dum.m9773I(this, 0);
        layoutParams3.leftMargin = dum.m9773I(this, 0);
        layoutParams3.rightMargin = dum.m9773I(this, 0);
        layoutParams3.addRule(0, 4);
        this.dsQ.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.dsQ);
        View relativeLayout2 = new RelativeLayout(this);
        LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, dum.m9773I(this, 50));
        relativeLayout2.setBackgroundDrawable(dum.m9775P(this, "login_bottom_background.9.png"));
        relativeLayout2.setLayoutParams(layoutParams4);
        this.dsT = new Button(this);
        this.dsT.setId(3);
        this.dsT.setBackgroundDrawable(dum.m9782g((Context) this, "get_code_button.9.png", "get_code_button_highlighted.9.png"));
        layoutParams4 = new RelativeLayout.LayoutParams(-2, dum.m9773I(this, 29));
        layoutParams4.rightMargin = dum.m9773I(this, 12);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        this.dsT.setPadding(18, 0, 18, 0);
        this.dsT.setLayoutParams(layoutParams4);
        this.dsT.setText(dum.m9779c(this, "Get code", "获取验证码", "獲取驗證碼"));
        this.dsT.setTextSize(15.0f);
        axC();
        relativeLayout2.addView(this.dsT);
        this.dsS = new EditText(this);
        this.dsS.setTextSize(2, 16.0f);
        this.dsS.setTextColor(-16777216);
        this.dsS.setHintTextColor(-4342339);
        this.dsS.setHint(dum.m9779c(this, "Verification code", "请输入验证码", "請輸入驗證碼"));
        this.dsS.setBackgroundDrawable(null);
        layoutParams4 = new RelativeLayout.LayoutParams(-1, dum.m9773I(this, 48));
        layoutParams4.addRule(0, 3);
        this.dsS.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.dsS);
        view.addView(relativeLayout);
        view.addView(relativeLayout2);
        this.dsL.addView(view);
        this.dsT.setOnClickListener(this);
        this.dsU = new TextView(this);
        this.dsU.setTextSize(2, 13.0f);
        this.dsU.setTextColor(-2014941);
        this.dsU.setText("");
        this.dsU.setVisibility(4);
        layoutParams2 = new LinearLayout.LayoutParams(-1, dum.m9773I(this, 36));
        layoutParams2.leftMargin = dum.m9773I(this, 12);
        this.dsU.setGravity(16);
        this.dsU.setLayoutParams(layoutParams2);
        this.dsL.addView(this.dsU);
        this.dsV = axy();
        axD();
        this.dsL.addView(this.dsV);
        view = axz();
        relativeLayout = axA();
        this.dsL.addView(view);
        this.dsL.addView(relativeLayout);
        this.dsK.addView(this.dsL);
        resizeableLayout.addView(this.dsK);
        axG();
        this.dsQ.setInputType(2);
        this.dsQ.addTextChangedListener(new C3198c());
        this.dsS.setInputType(2);
        this.dsS.addTextChangedListener(new C3196a());
        this.dsR.setOnClickListener(this);
        this.dsQ.setOnFocusChangeListener(this);
        this.dsV.setOnClickListener(this);
        this.dsN.setOnClickListener(this);
        resizeableLayout.setSizeChangeListener(this);
        setContentView(resizeableLayout);
    }

    private Button axy() {
        Button button = new Button(this);
        button.setBackgroundDrawable(dum.m9780d(this, "common_button_big_blue.9.png", "common_button_big_blue_highlighted.9.png", "common_button_big_blue_disable.9.png"));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dum.m9773I(this, 46));
        int I = dum.m9773I(this, 12);
        layoutParams.rightMargin = I;
        layoutParams.leftMargin = I;
        button.setText(dum.m9779c(this, "OK", "确定", "確定"));
        button.setTextSize(17.0f);
        button.setLayoutParams(layoutParams);
        return button;
    }

    private TextView axz() {
        TextView textView = new TextView(this);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dum.m9773I(this, 12);
        layoutParams.leftMargin = dum.m9773I(this, 12);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(13.0f);
        textView.setGravity(3);
        textView.setTextColor(-8224126);
        textView.setText(dum.m9779c(this, "Service By Sina WeiBo", "此服务由微博提供", "此服務由微博提供"));
        return textView;
    }

    private TextView axA() {
        CharSequence charSequence;
        int indexOf;
        int length;
        int indexOf2;
        int length2;
        TextView textView = new TextView(this);
        textView.setTextSize(2, 13.0f);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dum.m9773I(this, 8);
        layoutParams.leftMargin = dum.m9773I(this, 12);
        layoutParams.rightMargin = dum.m9773I(this, 12);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(13.0f);
        textView.setGravity(3);
        textView.setTextColor(-8224126);
        Locale language = dum.getLanguage();
        String str = "点击“确定”表示你同意服务使用协议和隐私条款。";
        str = "zh_CN";
        String str2;
        String str3;
        if (Locale.SIMPLIFIED_CHINESE.equals(language)) {
            charSequence = "点击“确定”表示你同意服务使用协议和隐私条款。";
            str2 = "服务使用协议";
            str3 = "隐私条款";
            indexOf = "点击“确定”表示你同意服务使用协议和隐私条款。".indexOf(str2);
            length = indexOf + str2.length();
            indexOf2 = "点击“确定”表示你同意服务使用协议和隐私条款。".indexOf(str3);
            length2 = str3.length() + indexOf2;
        } else if (Locale.TRADITIONAL_CHINESE.equals(language)) {
            charSequence = "點擊“確定”標示你同意服務使用協議和隱私條款。";
            str = "zh_HK";
            str2 = "服務使用協議";
            str3 = "隱私條款";
            indexOf = "點擊“確定”標示你同意服務使用協議和隱私條款。".indexOf(str2);
            length = indexOf + str2.length();
            indexOf2 = "點擊“確定”標示你同意服務使用協議和隱私條款。".indexOf(str3);
            length2 = str3.length() + indexOf2;
        } else {
            charSequence = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy";
            str = "en_US";
            str2 = "Service Agreement";
            str3 = "Privacy Policy";
            indexOf = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy".indexOf(str2);
            length = indexOf + str2.length();
            indexOf2 = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy".indexOf(str3);
            length2 = str3.length() + indexOf2;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (!(indexOf == -1 || length == -1)) {
            spannableStringBuilder.setSpan(new C3199d(this, this, "http://weibo.cn/dpool/ttt/h5/regagreement.php?from=h5&lang=" + str), indexOf, length, 33);
        }
        if (!(indexOf2 == -1 || length2 == -1)) {
            spannableStringBuilder.setSpan(new C3199d(this, this, "http://m.weibo.cn/reg/privacyagreement?from=h5&wm=3349&lang=" + str), indexOf2, length2, 33);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        return textView;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (intent != null) {
                    this.dsW = intent.getStringExtra("code");
                    this.dsX = intent.getStringExtra("name");
                    this.dsO.setText(this.dsW);
                    this.dsP.setText(this.dsX);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (view == this.dsQ && !z) {
            if (jY(this.dsQ.getText().toString())) {
                this.dsU.setVisibility(4);
                return;
            }
            this.dsU.setText(dum.m9779c(this, "Your phone number isn’t 11-digit long", "您的手机号不是11位数", "您的手機號不是11位數"));
            this.dsU.setVisibility(0);
        }
    }

    private boolean jX(String str) {
        if (!dul.isNetworkAvailable(this)) {
            axF();
            return false;
        } else if (jY(str)) {
            this.dsU.setVisibility(4);
            return true;
        } else {
            this.dsU.setVisibility(0);
            this.dsU.setText(dum.m9779c(getApplicationContext(), "Your phone number isn’t 11-digit long", "您的手机号不是11位数", "您的手機號不是11位數"));
            return false;
        }
    }

    private boolean jY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!Country.CHINA_CODE.equals(this.dsW)) {
            return true;
        }
        if (str.trim().length() == 11) {
            return true;
        }
        return false;
    }

    private boolean jZ(String str) {
        if (!dul.isNetworkAvailable(this)) {
            axF();
            return false;
        } else if (ka(str)) {
            this.dsU.setVisibility(4);
            return true;
        } else {
            this.dsU.setVisibility(0);
            this.dsU.setText(dum.m9779c(getApplicationContext(), "Your code isn’t 6-digit long", "你的验证码不是6位数", "你的驗證碼不是6位數"));
            dup.m9789a(getApplicationContext(), dum.m9779c(getApplicationContext(), "Your code isn’t 6-digit long", "你的验证码不是6位数", "你的驗證碼不是6位數"), 0);
            return false;
        }
    }

    private boolean ka(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 6) {
            return false;
        }
        return true;
    }

    private void axB() {
        this.dsT.setEnabled(false);
        this.dsT.setTextColor(-4342339);
    }

    private void axC() {
        this.dsT.setEnabled(true);
        this.dsT.setTextColor(-11502161);
    }

    private void axD() {
        this.dsV.setTextColor(1308622847);
        this.dsV.setEnabled(false);
    }

    private void axE() {
        this.dsV.setEnabled(true);
        this.dsV.setTextColor(-1);
    }

    private void axF() {
        dup.m9789a(getApplicationContext(), dum.m9779c(getApplicationContext(), "your network is  disabled  try again later", "您的网络不可用，请稍后", "您的網絡不可用，請稍後"), 0);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }

    public void dismiss() {
        if (this.dsI != null && this.dsI.isShowing()) {
            this.dsI.dismiss();
        }
    }

    private void axG() {
        this.dsI = new ProgressDialog(this);
        this.dsI.setCanceledOnTouchOutside(false);
        this.dsI.requestWindowFeature(1);
        this.dsI.setMessage(dum.m9779c(this, "please wait .... ", "正在处理中.....", "正在處理中....."));
    }

    public void aM(String str, String str2) {
        dtq com_fossil_dtq = new dtq(this.dqQ);
        com_fossil_dtq.put("appkey", this.dqQ);
        com_fossil_dtq.put("packagename", this.bhE);
        com_fossil_dtq.put("key_hash", this.dqk);
        String str3 = "phone";
        if (!Country.CHINA_CODE.equals(str2)) {
            str = new StringBuilder(String.valueOf(str2)).append(str).toString();
        }
        com_fossil_dtq.put(str3, str);
        com_fossil_dtq.put("version", "0031405000");
        dtn.m9730a(this, "http://api.weibo.com/oauth2/sms_authorize/send", com_fossil_dtq, "GET", new C31943(this));
    }

    public void aN(final String str, String str2) {
        dtq com_fossil_dtq = new dtq(this.dqQ);
        com_fossil_dtq.put("appkey", this.dqQ);
        com_fossil_dtq.put("packagename", this.bhE);
        com_fossil_dtq.put("key_hash", this.dqk);
        com_fossil_dtq.put("phone", str);
        com_fossil_dtq.put("version", "0031405000");
        com_fossil_dtq.put("code", str2);
        com_fossil_dtq.put("cfrom", this.dsY);
        this.dsI.show();
        dtn.m9730a(this, "http://api.weibo.com/oauth2/sms_authorize/submit", com_fossil_dtq, "GET", new dto(this) {
            final /* synthetic */ dtt dta;

            public void mo2686a(WeiboException weiboException) {
                duj.m9769d(dtt.TAG, "get onWeiboException " + weiboException.getMessage());
                CharSequence c = dum.m9779c(this.dta.getApplicationContext(), "the server is busy, please  wait", "服务器忙,请稍后再试", "服務器忙,請稍後再試");
                try {
                    JSONObject jSONObject = new JSONObject(weiboException.getMessage());
                    if (!TextUtils.isEmpty(jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION))) {
                        c = jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.dta.dsU.setVisibility(0);
                this.dta.dsU.setText(c);
                this.dta.dismiss();
            }

            public void jP(String str) {
                this.dta.dismiss();
                duj.m9769d(dtt.TAG, "get onComplete : " + str);
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString(Constants.PROFILE_KEY_UID, jSONObject.optString(Constants.PROFILE_KEY_UID));
                        bundle.putString("phone_num", str);
                        bundle.putString("access_token", jSONObject.optString("oauth_token"));
                        bundle.putString(AccessToken.EXPIRES_IN_KEY, jSONObject.optString("expires"));
                        intent.putExtras(bundle);
                        this.dta.setResult(-1, intent);
                        this.dta.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void onClick(View view) {
        String editable;
        String charSequence;
        if (view == this.dsT) {
            editable = this.dsQ.getText().toString();
            charSequence = this.dsO.getText().toString();
            if (jX(editable)) {
                this.cKz.start();
                axB();
                aM(editable, charSequence);
            }
        } else if (view == this.dsR) {
            this.dsQ.setText("");
        } else if (view == this.dsV) {
            editable = this.dsQ.getText().toString();
            charSequence = this.dsS.getText().toString();
            if (jZ(charSequence)) {
                aN(editable, charSequence);
            }
        } else if (view == this.dsN) {
            this.dsU.setVisibility(4);
            Intent intent = new Intent();
            intent.setClass(this, dtv.class);
            startActivityForResult(intent, 0);
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.widthPixels <= displayMetrics.heightPixels) {
            this.oN = this.oN < i2 ? i2 : this.oN;
            int i5 = 0;
            if (i2 < i4) {
                i5 = 1;
            } else if (i2 > i4 && i2 < this.oN) {
                i5 = 1;
            } else if (i2 == i4 && i2 != this.oN) {
                i5 = 1;
            }
            this.dsZ.sendEmptyMessage(i5);
        }
    }
}
