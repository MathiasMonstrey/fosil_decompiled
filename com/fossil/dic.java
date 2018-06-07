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
import android.widget.EditText;
import android.widget.TextView;
import com.fossil.dib.C2803a;
import com.fossil.dib.C2804b;
import com.fossil.drk.C2095b;
import com.fossil.drk.C3126a;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.goaltracking.GoalTrackingSettings;
import java.util.HashMap;

public class dic extends ctm implements TextWatcher, OnClickListener, C2804b, C2095b {
    public static final String TAG = dic.class.getSimpleName();
    private EditText cWb;
    private TextView cWc;
    private C2803a cWd;
    private GoalTrackingSettings cWe;

    public /* synthetic */ void cK(Object obj) {
        m8737a((C2803a) obj);
    }

    public static dic apJ() {
        return new dic();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            this.cWe = (GoalTrackingSettings) bundle.getParcelable("GoalTrackingBundle");
        }
        return layoutInflater.inflate(R.layout.fragment_goal_tracking_edit, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.btn_save);
        View findViewById2 = view.findViewById(R.id.btn_cancel);
        this.cWb = (EditText) view.findViewById(R.id.et_goal_name);
        this.cWc = (TextView) view.findViewById(R.id.tv_frequency);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        if (this.cWb != null) {
            this.cWb.addTextChangedListener(this);
        }
        if (this.cWc != null) {
            this.cWc.setOnClickListener(this);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("GoalTrackingBundle", this.cWe);
        super.onSaveInstanceState(bundle);
    }

    public void m8737a(C2803a c2803a) {
        this.cWd = c2803a;
    }

    public void mo2494b(GoalTrackingSettings goalTrackingSettings) {
        this.cWe = goalTrackingSettings;
        this.cWb.setText(this.cWe.getName());
        this.cWb.setSelection(this.cWe.getName().length());
        this.cWc.setText(String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Goals_Tracking_Label__of_number_times_a_day), new Object[]{Integer.valueOf(this.cWe.getTarget())}));
    }

    public void apI() {
        new C3126a(R.layout.edit_one_picker_dialog_fragment).m9498w(R.id.title, arp.m4318u(PortfolioApp.ZQ(), R.string.frequency)).m9498w(R.id.ftv_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Goals_Tracking_CTA_SAVE)).m9498w(R.id.ftv_cancel, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Goals_Tracking_CTA_CANCEL)).lB(R.id.ftv_ok).lB(R.id.ftv_cancel).m9499y(R.id.number_picker_one, 1, 100, this.cWe.getTarget()).m9495c(getChildFragmentManager(), "USER_EDIT_GOAL_FREQUENCY");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                cY(false);
                return;
            case R.id.btn_save:
                if (!TextUtils.isEmpty(this.cWe.getName())) {
                    this.cWd.mo2496a(this.cWe);
                    return;
                }
                return;
            case R.id.tv_frequency:
                this.cWd.apG();
                return;
            default:
                return;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.cWe.setName(editable.toString().trim());
    }

    public void mo1746a(String str, int i, Intent intent) {
        if ("USER_EDIT_GOAL_FREQUENCY".equals(str) && i == R.id.ftv_ok) {
            this.cWe.setTarget(((Integer) ((HashMap) intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS")).get(Integer.valueOf(R.id.number_picker_one))).intValue());
            this.cWd.apH();
        }
    }

    public void cY(boolean z) {
        if (getActivity() != null) {
            getActivity().setResult(z ? -1 : 0);
            getActivity().finish();
        }
    }
}
