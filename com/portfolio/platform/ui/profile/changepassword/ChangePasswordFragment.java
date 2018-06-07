package com.portfolio.platform.ui.profile.changepassword;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fossil.cco;
import com.fossil.ctm;
import com.fossil.ddu.a;
import com.fossil.ddu.b;
import com.fossil.dqw;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.view.FlexibleEditText;

public class ChangePasswordFragment extends ctm implements OnClickListener, b {
    private static final String TAG = ChangePasswordFragment.class.getSimpleName();
    private a cRf;
    private TextView cRg;
    private TextView cRh;
    private FlexibleEditText cRi;
    private FlexibleEditText cRj;
    private FlexibleEditText cRk;

    class C49441 implements TextWatcher {
        final /* synthetic */ ChangePasswordFragment cRl;

        C49441(ChangePasswordFragment changePasswordFragment) {
            this.cRl = changePasswordFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.cRl.cI(this.cRl.amX());
        }
    }

    class C49452 implements TextWatcher {
        final /* synthetic */ ChangePasswordFragment cRl;

        C49452(ChangePasswordFragment changePasswordFragment) {
            this.cRl = changePasswordFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.cRl.cI(this.cRl.amX());
        }
    }

    class C49463 implements TextWatcher {
        final /* synthetic */ ChangePasswordFragment cRl;

        C49463(ChangePasswordFragment changePasswordFragment) {
            this.cRl = changePasswordFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.cRl.cI(this.cRl.amX());
        }
    }

    enum ChangePassword {
        NEW_PASS_NOT_MATCH,
        NOT_ENOUGH_INFO,
        OK,
        AT_LEST_7_CHARS
    }

    public /* synthetic */ void cK(Object obj) {
        m15737a((a) obj);
    }

    public static ChangePasswordFragment amV() {
        return new ChangePasswordFragment();
    }

    public void m15737a(a aVar) {
        this.cRf = (a) cco.ce(aVar);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_change_pass, viewGroup, false);
        this.cRg = (TextView) inflate.findViewById(R.id.save);
        this.cRh = (TextView) inflate.findViewById(R.id.cancel);
        this.cRj = (FlexibleEditText) inflate.findViewById(R.id.old_pass);
        this.cRi = (FlexibleEditText) inflate.findViewById(R.id.new_pass);
        this.cRk = (FlexibleEditText) inflate.findViewById(R.id.confirm_pass);
        this.cRg.setOnClickListener(this);
        this.cRh.setOnClickListener(this);
        this.cRg.setAlpha(0.4f);
        this.cRg.setEnabled(false);
        this.cRj.addTextChangedListener(new C49441(this));
        this.cRi.addTextChangedListener(new C49452(this));
        this.cRk.addTextChangedListener(new C49463(this));
        return inflate;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    getActivity().finish();
                    return;
                }
                return;
            case R.id.save:
                switch (amW()) {
                    case NEW_PASS_NOT_MATCH:
                        MFLogger.d(TAG, "NEW_PASS_NOT_MATCH");
                        if (isActive()) {
                            dqw.k(getChildFragmentManager());
                            return;
                        }
                        return;
                    case NOT_ENOUGH_INFO:
                        MFLogger.d(TAG, "NOT_ENOUGH_INFO");
                        return;
                    case AT_LEST_7_CHARS:
                        MFLogger.d(TAG, "AT_LEST_7_CHARS");
                        if (isActive()) {
                            dqw.C(getChildFragmentManager());
                            return;
                        }
                        return;
                    case OK:
                        this.cRf.aD(this.cRj.getEditableText().toString(), this.cRi.getEditableText().toString());
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    public void onResume() {
        super.onResume();
        this.cRf.start();
    }

    public void onPause() {
        super.onPause();
        this.cRf.stop();
    }

    public void alF() {
        afT();
    }

    public void alG() {
        afU();
    }

    public void amR() {
        if (isActive()) {
            dqw.i(getChildFragmentManager());
        }
    }

    public void kV(int i) {
        if (isActive()) {
            dqw.a(i, getChildFragmentManager());
        }
    }

    public void amS() {
        if (isActive()) {
            dqw.m(getChildFragmentManager());
        }
    }

    public void amT() {
        if (isActive()) {
            dqw.l(getChildFragmentManager());
        }
    }

    public void amU() {
        if (isActive()) {
            dqw.C(getChildFragmentManager());
        }
    }

    private ChangePassword amW() {
        if (this.cRj.getEditableText().toString().length() == 0 || this.cRi.getEditableText().toString().length() == 0 || this.cRk.getEditableText().toString().length() == 0) {
            return ChangePassword.NOT_ENOUGH_INFO;
        }
        if (this.cRj.getEditableText().toString().length() < 7 || this.cRi.getEditableText().toString().length() < 7 || this.cRk.getEditableText().toString().length() < 7) {
            return ChangePassword.AT_LEST_7_CHARS;
        }
        if (this.cRi.getEditableText().toString().equalsIgnoreCase(this.cRk.getEditableText().toString())) {
            return ChangePassword.OK;
        }
        return ChangePassword.NEW_PASS_NOT_MATCH;
    }

    private boolean amX() {
        if (this.cRj.getEditableText().toString().length() < 1 || this.cRi.getEditableText().toString().length() < 1 || this.cRk.getEditableText().toString().length() < 1) {
            return false;
        }
        return true;
    }

    private void cI(boolean z) {
        if (z) {
            this.cRg.setAlpha(1.0f);
            this.cRg.setEnabled(true);
            return;
        }
        this.cRg.setAlpha(0.4f);
        this.cRg.setEnabled(false);
    }
}
