package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fossil.dii.C2797a;
import com.fossil.dii.C2807b;
import com.fossil.drk.C3126a;
import com.fossil.wearables.fossil.R;
import com.misfit.chart.lib.ProcessCircle;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.goaltracking.GoalTrackingSettings;
import com.portfolio.platform.ui.shortcuts.details.goaltracking.GoalTrackingEditActivity;

public class dij extends ctm implements OnClickListener, C2807b {
    public static final String TAG = dij.class.getSimpleName();
    private C2797a cWl;
    private TextView cWm;
    private ProcessCircle cWn;
    private TextView cWo;
    private TextView cWp;
    private View cWq;
    private View cWr;

    public /* synthetic */ void cK(Object obj) {
        m8756a((C2797a) obj);
    }

    public static dij apP() {
        return new dij();
    }

    public void m8756a(C2797a c2797a) {
        this.cWl = c2797a;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_goal_tracking_ring_chart, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cWm = (TextView) view.findViewById(R.id.tv_goal_title);
        this.cWn = (ProcessCircle) view.findViewById(R.id.progress);
        this.cWo = (TextView) view.findViewById(R.id.tv_goal_count);
        this.cWp = (TextView) view.findViewById(R.id.tv_goal_description);
        this.cWq = view.findViewById(R.id.btn_plus);
        this.cWr = view.findViewById(R.id.btn_minus);
        if (this.cWm != null) {
            this.cWm.setOnClickListener(this);
        }
        if (this.cWq != null) {
            this.cWq.setOnClickListener(this);
        }
        if (this.cWr != null) {
            this.cWr.setOnClickListener(this);
        }
    }

    public void onResume() {
        super.onResume();
        this.cWl.apf();
        this.cWl.apg();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_goal_title:
                this.cWl.apv();
                return;
            case R.id.btn_minus:
                this.cWl.api();
                return;
            case R.id.btn_plus:
                this.cWl.aph();
                return;
            default:
                return;
        }
    }

    public void iM(String str) {
        GoalTrackingEditActivity.d(this, str, 2000);
    }

    public void mo2499a(boolean z, GoalTrackingSettings goalTrackingSettings) {
        this.cWm.setText(goalTrackingSettings.getName());
        this.cWo.setText(String.valueOf(goalTrackingSettings.getValue()));
        this.cWn.setPercentDecimal((((float) goalTrackingSettings.getValue()) / ((float) goalTrackingSettings.getTarget())) * 100.0f);
        this.cWn.invalidate();
        this.cWp.setText(String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Goals_Tracking_Label__of_number_times_a_day), new Object[]{Integer.valueOf(goalTrackingSettings.getTarget())}));
        this.cWq.setEnabled(true);
        this.cWr.setEnabled(true);
    }

    public void m8758h(MicroAppSetting microAppSetting) {
        this.cWl.mo2481e(microAppSetting);
    }

    public void apO() {
        MFLogger.m12670d(TAG, "show goal tracking celebration");
        if (isActive()) {
            new C3126a(R.layout.fragment_goal_reached).lB(R.id.tv_goal_reached_cta).m9495c(getChildFragmentManager(), "GOAL_CELEBRATION_TAG");
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2000 && i2 == -1) {
            this.cWl.apj();
        }
    }
}
