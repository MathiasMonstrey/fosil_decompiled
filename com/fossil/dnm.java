package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dnl.C2996a;
import com.fossil.dnl.C2997b;
import com.fossil.drk.C2095b;
import com.fossil.drk.C3126a;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleEditText;

public class dnm extends ctm implements OnClickListener, C2997b, C2095b {
    private FlexibleEditText daZ;
    private FlexibleButton dba;
    private C2996a dbb;

    public /* synthetic */ void cK(Object obj) {
        m9181a((C2996a) obj);
    }

    public static dnm asC() {
        return new dnm();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_forgot_password, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.daZ = (FlexibleEditText) view.findViewById(R.id.fet_email);
        this.dba = (FlexibleButton) view.findViewById(R.id.fb_submit);
        this.dba.setOnClickListener(this);
    }

    public void m9181a(C2996a c2996a) {
        this.dbb = c2996a;
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

    public void asB() {
        if (isActive()) {
            dqw.m9424b(getChildFragmentManager());
        }
    }

    public void dc(boolean z) {
        new C3126a(R.layout.dialog_switch_server).lB(R.id.ok).m9498w(R.id.tv_content, z ? "You're switching to staging server..." : "You're switching to production server...").m9495c(getChildFragmentManager(), "SWITCH_SERVER");
    }

    public void dd(boolean z) {
        if (!z && isActive()) {
            dqw.m9412D(getChildFragmentManager());
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -949144914:
                if (str.equals("SWITCH_SERVER")) {
                    obj = 1;
                    break;
                }
                break;
            case 1693342775:
                if (str.equals("FORGOT_PASSWORD")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                switch (i) {
                    case R.id.fb_ok:
                        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                            getActivity().finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            case 1:
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    getActivity().finish();
                    return;
                }
                return;
            default:
                ((ctj) getActivity()).mo1746a(str, i, intent);
                return;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_submit:
                this.dbb.iU(this.daZ.getText().toString());
                return;
            default:
                return;
        }
    }
}
