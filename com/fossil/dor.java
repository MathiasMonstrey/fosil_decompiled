package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dnf.C2985a;
import com.fossil.dnf.C2986b;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.MainActivity;
import com.portfolio.platform.ui.device.link.PairDeviceStartActivity;
import com.portfolio.platform.ui.user.LoginActivity;
import com.portfolio.platform.ui.user.SignUpEmailActivity;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.ImageButton;
import java.util.Locale;

public class dor extends ctm implements OnClickListener, C2986b, C2095b {
    private static final String TAG = dor.class.getSimpleName();
    private C2985a dbA;
    private FlexibleTextView dbH;
    private ImageButton dcr;
    private ImageButton dcs;
    private ImageButton dct;
    private ImageButton dcu;
    private ImageButton dcv;
    private FlexibleTextView dcw;

    class C30221 extends ClickableSpan {
        final /* synthetic */ dor dcx;

        C30221(dor com_fossil_dor) {
            this.dcx = com_fossil_dor;
        }

        public void onClick(View view) {
            cmj.bs(PortfolioApp.ZQ()).logEvent("login");
            LoginActivity.bF(this.dcx.getActivity());
            if (this.dcx.getActivity() != null) {
                this.dcx.getActivity().finish();
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    class C30232 extends ClickableSpan {
        final /* synthetic */ dor dcx;

        C30232(dor com_fossil_dor) {
            this.dcx = com_fossil_dor;
        }

        public void onClick(View view) {
        }

        public void updateDrawState(TextPaint textPaint) {
            try {
                TextPaint.class.getMethod("setUnderlineText", new Class[]{Integer.TYPE, Float.TYPE}).invoke(textPaint, new Object[]{Integer.valueOf(gn.m10634e(this.dcx.getContext(), R.color.fossilCharcoal)), Float.valueOf(this.dcx.getResources().getDimension(R.dimen.dp1))});
            } catch (Exception e) {
                textPaint.setUnderlineText(true);
            }
            textPaint.baselineShift = this.dcx.getResources().getDimensionPixelSize(R.dimen.dp4);
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m9256a((C2985a) obj);
    }

    public static dor ato() {
        return new dor();
    }

    public void onCreate(Bundle bundle) {
        MFLogger.m12670d(TAG, "Oncreate");
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_sign_up, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dcv = (ImageButton) view.findViewById(R.id.fb_sign_up_email);
        this.dcs = (ImageButton) view.findViewById(R.id.fb_sign_up_google);
        this.dcr = (ImageButton) view.findViewById(R.id.fb_sign_up_facebook);
        this.dct = (ImageButton) view.findViewById(R.id.fb_sign_up_weibo);
        this.dcu = (ImageButton) view.findViewById(R.id.fb_sign_up_wechat);
        this.dcw = (FlexibleTextView) view.findViewById(R.id.ftv_login);
        this.dbH = (FlexibleTextView) view.findViewById(R.id.ftv_cheat);
        String u = arp.m4318u(getContext(), R.string.Onboarding_Account_Signup_CTA_Already_have_an_account_Log);
        int indexOf = u.indexOf("<a href=\"login\">");
        u = u.replace("<a href=\"login\">", "");
        int indexOf2 = u.indexOf("</a>");
        u = u.replace("</a>", "");
        CharSequence spannableString = new SpannableString(u);
        C30221 c30221 = new C30221(this);
        if (indexOf >= 0 && indexOf2 <= u.length()) {
            spannableString.setSpan(c30221, indexOf, indexOf2, 33);
        }
        this.dcw.setText(spannableString);
        this.dcw.setMovementMethod(LinkMovementMethod.getInstance());
        this.dcw.setHighlightColor(0);
        C30232 c30232 = new C30232(this);
        if (indexOf >= 0 && indexOf2 <= u.length()) {
            spannableString.setSpan(c30232, indexOf, indexOf2, 33);
        }
        this.dbH.setText(spannableString);
        this.dbH.setHighlightColor(0);
        this.dcu.ci((int) dri.at(60.0f), (int) dri.at(20.0f));
        this.dcv.setOnClickListener(this);
        this.dcs.setOnClickListener(this);
        this.dcr.setOnClickListener(this);
        this.dct.setOnClickListener(this);
        this.dcu.setOnClickListener(this);
        u = Locale.getDefault().toString();
        if (u == null) {
            return;
        }
        if (u.contains("zh_CN") || u.contains("zh_TW") || u.contains("zh_SG")) {
            this.dcr.setVisibility(4);
            this.dcs.setVisibility(4);
            this.dct.setVisibility(0);
            this.dcu.setVisibility(0);
            return;
        }
        this.dcr.setVisibility(0);
        this.dcs.setVisibility(0);
        this.dct.setVisibility(4);
        this.dcu.setVisibility(4);
    }

    public void onResume() {
        super.onResume();
        this.dbA.start();
    }

    public void onPause() {
        super.onPause();
        this.dbA.stop();
    }

    public void m9256a(C2985a c2985a) {
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
                        this.dbA.asu();
                        return;
                    default:
                        return;
                }
            default:
                ((ctj) getActivity()).mo1746a(str, i, intent);
                return;
        }
    }

    public void asw() {
        PairDeviceStartActivity.bH(getActivity());
    }

    public void asx() {
        MainActivity.bF(getActivity());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_sign_up_facebook:
                cmj.bs(PortfolioApp.ZQ()).m7086l("signup", "Auth", "Facebook");
                this.dbA.asq();
                return;
            case R.id.fb_sign_up_google:
                cmj.bs(PortfolioApp.ZQ()).m7086l("signup", "Auth", "Google");
                this.dbA.asr();
                return;
            case R.id.fb_sign_up_email:
                cmj.bs(PortfolioApp.ZQ()).m7086l("signup", "Auth", "Email");
                SignUpEmailActivity.bF(getActivity());
                return;
            case R.id.fb_sign_up_weibo:
                cmj.bs(PortfolioApp.ZQ()).m7086l("signup", "Auth", "Weibo");
                this.dbA.ass();
                return;
            case R.id.fb_sign_up_wechat:
                cmj.bs(PortfolioApp.ZQ()).m7086l("signup", "Auth", "Wechat");
                this.dbA.ast();
                return;
            default:
                return;
        }
    }
}
