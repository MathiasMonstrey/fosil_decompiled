package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dnv.C2999a;
import com.fossil.dnv.C3000b;
import com.fossil.drk.C2095b;
import com.fossil.drk.C2333c;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.MainActivity;
import com.portfolio.platform.ui.device.link.PairDeviceStartActivity;
import com.portfolio.platform.ui.user.ForgotPasswordActivity;
import com.portfolio.platform.ui.user.SignUpEmailActivity;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleEditText;
import com.portfolio.platform.view.FlexibleTextView;

public class dnw extends ctm implements OnClickListener, C3000b, C2095b, C2333c {
    private static final String TAG = dnw.class.getSimpleName();
    private FlexibleEditText daZ;
    private C2999a dbl;
    private FlexibleEditText dbm;
    private FlexibleTextView dbn;
    private FlexibleButton dbo;
    private FlexibleTextView dbp;

    class C30011 implements TextWatcher {
        final /* synthetic */ dnw dbq;

        C30011(dnw com_fossil_dnw) {
            this.dbq = com_fossil_dnw;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.dbq.dbl.iW(editable.toString());
        }
    }

    class C30022 implements TextWatcher {
        final /* synthetic */ dnw dbq;

        C30022(dnw com_fossil_dnw) {
            this.dbq = com_fossil_dnw;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.dbq.dbl.iX(editable.toString());
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m9192a((C2999a) obj);
    }

    public static dnw asN() {
        return new dnw();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_login_email, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.daZ = (FlexibleEditText) view.findViewById(R.id.fet_email);
        this.dbm = (FlexibleEditText) view.findViewById(R.id.fet_password);
        this.dbn = (FlexibleTextView) view.findViewById(R.id.ftv_error);
        this.dbo = (FlexibleButton) view.findViewById(R.id.fb_login);
        this.dbp = (FlexibleTextView) view.findViewById(R.id.ftv_forgot_password);
        this.dbo.setOnClickListener(this);
        this.dbp.setOnClickListener(this);
        this.daZ.addTextChangedListener(new C30011(this));
        this.dbm.addTextChangedListener(new C30022(this));
    }

    public void onResume() {
        super.onResume();
        this.dbl.start();
    }

    public void onPause() {
        super.onPause();
        this.dbl.stop();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ftv_forgot_password:
                ForgotPasswordActivity.bF(getActivity());
                return;
            case R.id.fb_login:
                this.dbl.aH(this.daZ.getText().toString(), this.dbm.getText().toString());
                return;
            default:
                return;
        }
    }

    public void m9192a(C2999a c2999a) {
        this.dbl = c2999a;
    }

    public void afL() {
        afT();
    }

    public void afM() {
        afU();
    }

    public void de(boolean z) {
    }

    public void df(boolean z) {
    }

    public void asH() {
        this.dbo.setEnabled(true);
        this.dbo.setAlpha(1.0f);
    }

    public void asI() {
        this.dbo.setEnabled(true);
        this.dbo.setAlpha(1.0f);
    }

    public void iS(String str) {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            PortfolioApp.ZQ().aao();
            PortfolioApp.ZQ().aae();
            afM();
            dqw.m9425b(getChildFragmentManager(), str);
        }
    }

    public void iY(String str) {
        this.dbn.setText(str);
    }

    public void jV(int i) {
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void asJ() {
        this.dbn.setText("");
    }

    public void asK() {
        if (getActivity() != null && !getActivity().isDestroyed() && !getActivity().isFinishing()) {
            MainActivity.bF(getActivity());
            getActivity().finish();
        }
    }

    public void asL() {
        if (getActivity() != null && !getActivity().isDestroyed() && !getActivity().isFinishing()) {
            SignUpEmailActivity.bF(getActivity());
            getActivity().finish();
        }
    }

    public void asM() {
        if (getActivity() != null && !getActivity().isDestroyed() && !getActivity().isFinishing()) {
            PairDeviceStartActivity.bH(getActivity());
            getActivity().finish();
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
                        this.dbl.asG();
                        return;
                    default:
                        return;
                }
            default:
                ((ctj) getActivity()).mo1746a(str, i, intent);
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
                    this.dbl.asG();
                    return;
                default:
                    return;
            }
        }
    }
}
