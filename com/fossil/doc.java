package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dnf.C2985a;
import com.fossil.dnf.C2986b;
import com.fossil.drk.C2095b;
import com.fossil.drk.C2333c;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.MainActivity;
import com.portfolio.platform.ui.device.link.PairDeviceStartActivity;
import com.portfolio.platform.ui.user.LoginEmailActivity;
import com.portfolio.platform.ui.user.SignUpActivity;
import com.portfolio.platform.ui.user.SignUpEmailActivity;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.ImageButton;
import java.util.Locale;

public class doc extends ctm implements OnClickListener, C2986b, C2095b, C2333c {
    private static final String TAG = doc.class.getSimpleName();
    private C2985a dbA;
    private ImageButton dbB;
    private ImageButton dbC;
    private ImageButton dbD;
    private ImageButton dbE;
    private ImageButton dbF;
    private FlexibleTextView dbG;
    private FlexibleTextView dbH;

    class C30101 extends ClickableSpan {
        final /* synthetic */ doc dbI;

        C30101(doc com_fossil_doc) {
            this.dbI = com_fossil_doc;
        }

        public void onClick(View view) {
            if (this.dbI.getActivity() != null && !this.dbI.getActivity().isFinishing() && !this.dbI.getActivity().isDestroyed()) {
                cmj.bs(PortfolioApp.ZQ()).logEvent("signup");
                SignUpActivity.bF(this.dbI.getActivity());
                if (this.dbI.getActivity() != null) {
                    this.dbI.getActivity().finish();
                }
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    class C30112 extends ClickableSpan {
        final /* synthetic */ doc dbI;

        C30112(doc com_fossil_doc) {
            this.dbI = com_fossil_doc;
        }

        public void onClick(View view) {
        }

        public void updateDrawState(TextPaint textPaint) {
            try {
                TextPaint.class.getMethod("setUnderlineText", new Class[]{Integer.TYPE, Float.TYPE}).invoke(textPaint, new Object[]{Integer.valueOf(gn.m10634e(this.dbI.getContext(), R.color.fossilCharcoal)), Float.valueOf(PortfolioApp.ZQ().getResources().getDimension(R.dimen.dp1))});
            } catch (Exception e) {
                textPaint.setUnderlineText(true);
            }
            textPaint.baselineShift = this.dbI.getResources().getDimensionPixelSize(R.dimen.dp4);
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m9217a((C2985a) obj);
    }

    public static doc asR() {
        return new doc();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_login, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dbB = (ImageButton) view.findViewById(R.id.fb_log_in_facebook);
        this.dbC = (ImageButton) view.findViewById(R.id.fb_login_google);
        this.dbF = (ImageButton) view.findViewById(R.id.fb_login_email);
        this.dbD = (ImageButton) view.findViewById(R.id.fb_log_in_weibo);
        this.dbE = (ImageButton) view.findViewById(R.id.fb_login_wechat);
        this.dbG = (FlexibleTextView) view.findViewById(R.id.ftv_sign_up);
        this.dbH = (FlexibleTextView) view.findViewById(R.id.ftv_cheat);
        String u = arp.m4318u(getContext(), R.string.Onboarding_Account_Login_CTA_Dont_have_an_account_Sign);
        int indexOf = u.indexOf("<a href=\"signup\">");
        u = u.replace("<a href=\"signup\">", "");
        int indexOf2 = u.indexOf("</a>");
        u = u.replace("</a>", "");
        CharSequence spannableString = new SpannableString(u);
        C30101 c30101 = new C30101(this);
        if (indexOf >= 0 && indexOf2 <= u.length()) {
            spannableString.setSpan(c30101, indexOf, indexOf2, 33);
        }
        this.dbG.setText(spannableString);
        this.dbG.setMovementMethod(LinkMovementMethod.getInstance());
        this.dbG.setHighlightColor(0);
        C30112 c30112 = new C30112(this);
        if (indexOf >= 0 && indexOf2 <= u.length()) {
            spannableString.setSpan(c30112, indexOf, indexOf2, 33);
        }
        this.dbH.setText(spannableString);
        this.dbH.setHighlightColor(0);
        this.dbE.ci((int) dri.at(60.0f), (int) dri.at(20.0f));
        this.dbB.setOnClickListener(this);
        this.dbC.setOnClickListener(this);
        this.dbD.setOnClickListener(this);
        this.dbE.setOnClickListener(this);
        this.dbF.setOnClickListener(this);
        u = Locale.getDefault().toString();
        if (u == null) {
            return;
        }
        if (u.contains("zh_CN") || u.contains("zh_TW") || u.contains("zh_SG")) {
            this.dbB.setVisibility(4);
            this.dbC.setVisibility(4);
            this.dbD.setVisibility(0);
            this.dbE.setVisibility(0);
            return;
        }
        this.dbB.setVisibility(0);
        this.dbC.setVisibility(0);
        this.dbD.setVisibility(4);
        this.dbE.setVisibility(4);
    }

    public void onResume() {
        super.onResume();
        this.dbA.start();
    }

    public void onPause() {
        super.onPause();
        this.dbA.stop();
    }

    public void m9217a(C2985a c2985a) {
        this.dbA = c2985a;
    }

    public void afL() {
        afT();
    }

    public void afM() {
        afU();
    }

    public void jV(int i) {
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void iS(String str) {
        if (isActive()) {
            PortfolioApp.ZQ().aao();
            PortfolioApp.ZQ().aae();
            dqw.m9425b(getChildFragmentManager(), str);
        }
    }

    public void asv() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("AUTHENTICATED_BY_EMAIL", false);
            SignUpEmailActivity.d(getActivity(), bundle);
        }
    }

    public void db(boolean z) {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("AUTHENTICATED_BY_EMAIL", !z);
            SignUpEmailActivity.d(getActivity(), bundle);
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -825762695:
                if (str.equals("AUTHENTICATE_SUCCESS")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                switch (i) {
                    case R.id.fb_ok:
                        if (TextUtils.isEmpty(PortfolioApp.ZQ().aaa())) {
                            PairDeviceStartActivity.bH(getActivity());
                            return;
                        } else {
                            MainActivity.bF(getActivity());
                            return;
                        }
                    default:
                        return;
                }
            default:
                ((ctj) getActivity()).mo1746a(str, i, intent);
                return;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_log_in_facebook:
                cmj.bs(PortfolioApp.ZQ()).m7086l("login", "Auth", "Facebook");
                this.dbA.asq();
                return;
            case R.id.fb_login_google:
                cmj.bs(PortfolioApp.ZQ()).m7086l("login", "Auth", "Google");
                this.dbA.asr();
                return;
            case R.id.fb_login_email:
                cmj.bs(PortfolioApp.ZQ()).m7086l("login", "Auth", "Email");
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    LoginEmailActivity.bF(getActivity());
                    return;
                }
                return;
            case R.id.fb_log_in_weibo:
                cmj.bs(PortfolioApp.ZQ()).m7086l("login", "Auth", "Weibo");
                this.dbA.ass();
                return;
            case R.id.fb_login_wechat:
                cmj.bs(PortfolioApp.ZQ()).m7086l("login", "Auth", "Wechat");
                this.dbA.ast();
                return;
            default:
                return;
        }
    }

    public void hJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -825762695:
                    if (str.equals("AUTHENTICATE_SUCCESS")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.dbA.asu();
                    return;
                default:
                    return;
            }
        }
    }

    public void asx() {
        MainActivity.bF(getActivity());
    }

    public void asw() {
        PairDeviceStartActivity.bH(getActivity());
    }
}
