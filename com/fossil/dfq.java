package com.fossil;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dfp.C2726a;
import com.fossil.dfp.C2727b;
import com.fossil.wearables.fossil.R;
import java.util.HashMap;

public final class dfq extends ctm implements C2727b {
    private static final String TAG;
    public static final C2728a cTd = new C2728a();
    private dqo<cld> cEY;
    private C2726a cTc;

    public static final class C2728a {
        private C2728a() {
        }

        public final dfq anN() {
            return new dfq();
        }
    }

    static final class C2729b implements OnClickListener {
        final /* synthetic */ dfq cTe;

        C2729b(dfq com_fossil_dfq) {
            this.cTe = com_fossil_dfq;
        }

        public final void onClick(View view) {
            this.cTe.finish();
        }
    }

    static final class C2730c implements OnClickListener {
        final /* synthetic */ dfq cTe;
        final /* synthetic */ cld cTf;

        C2730c(dfq com_fossil_dfq, cld com_fossil_cld) {
            this.cTe = com_fossil_dfq;
            this.cTf = com_fossil_cld;
        }

        public final void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("Item", "Push_Notification");
            cmj.bs(this.cTe.getContext()).m7085e("profile_optin", hashMap);
            hashMap = new HashMap();
            hashMap.put("Optin", this.cTf.ctv.isChecked() ? "Yes" : "No");
            cmj.bs(this.cTe.getContext()).m7085e("profile_optin", hashMap);
            cmj.bs(this.cTe.getContext()).ap("Optin_PushNotifications", this.cTf.ctv.isChecked() ? "Yes" : "No");
            dfq.m8482a(this.cTe).cM(this.cTf.ctv.isChecked());
        }
    }

    static final class C2731d implements OnClickListener {
        final /* synthetic */ dfq cTe;
        final /* synthetic */ cld cTf;

        C2731d(dfq com_fossil_dfq, cld com_fossil_cld) {
            this.cTe = com_fossil_dfq;
            this.cTf = com_fossil_cld;
        }

        public final void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("Item", "Emails");
            cmj.bs(this.cTe.getContext()).m7085e("profile_optin", hashMap);
            hashMap = new HashMap();
            hashMap.put("Optin", this.cTf.ctr.isChecked() ? "Yes" : "No");
            cmj.bs(this.cTe.getContext()).m7085e("profile_optin", hashMap);
            cmj.bs(this.cTe.getContext()).ap("Optin_Emails", this.cTf.ctr.isChecked() ? "Yes" : "No");
            dfq.m8482a(this.cTe).cN(this.cTf.ctr.isChecked());
        }
    }

    static final class C2732e implements OnClickListener {
        final /* synthetic */ dfq cTe;
        final /* synthetic */ cld cTf;

        C2732e(dfq com_fossil_dfq, cld com_fossil_cld) {
            this.cTe = com_fossil_dfq;
            this.cTf = com_fossil_cld;
        }

        public final void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("Item", "Usage_Data");
            cmj.bs(this.cTe.getContext()).m7085e("profile_optin", hashMap);
            hashMap = new HashMap();
            hashMap.put("Optin", this.cTf.ctq.isChecked() ? "Yes" : "No");
            cmj.bs(this.cTe.getContext()).m7085e("profile_optin", hashMap);
            cmj.bs(this.cTe.getContext()).ap("Optin_Usage", this.cTf.ctq.isChecked() ? "Yes" : "No");
            dfq.m8482a(this.cTe).cO(this.cTf.ctq.isChecked());
        }
    }

    public static final /* synthetic */ C2726a m8482a(dfq com_fossil_dfq) {
        C2726a c2726a = com_fossil_dfq.cTc;
        if (c2726a == null) {
            esl.mF("mPresenter");
        }
        return c2726a;
    }

    public /* synthetic */ void cK(Object obj) {
        m8483a((C2726a) obj);
    }

    public void m8483a(C2726a c2726a) {
        esl.m11128j(c2726a, "presenter");
        Object ce = cco.ce(c2726a);
        esl.m11127i(ce, "checkNotNull(presenter)");
        this.cTc = (C2726a) ce;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        cld com_fossil_cld = (cld) C3311e.m10385a(LayoutInflater.from(getContext()), (int) R.layout.fragment_opt_in, null, false);
        com_fossil_cld.cqc.setOnClickListener(new C2729b(this));
        com_fossil_cld.ctv.setOnClickListener(new C2730c(this, com_fossil_cld));
        com_fossil_cld.ctr.setOnClickListener(new C2731d(this, com_fossil_cld));
        com_fossil_cld.ctq.setOnClickListener(new C2732e(this, com_fossil_cld));
        this.cEY = new dqo(this, com_fossil_cld);
        return com_fossil_cld.dz();
    }

    public void onResume() {
        super.onResume();
        C2726a c2726a = this.cTc;
        if (c2726a == null) {
            esl.mF("mPresenter");
        }
        c2726a.start();
    }

    public void onPause() {
        super.onPause();
        C2726a c2726a = this.cTc;
        if (c2726a == null) {
            esl.mF("mPresenter");
        }
        c2726a.stop();
    }

    public void cM(boolean z) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cld com_fossil_cld = (cld) com_fossil_dqo.get();
        if (com_fossil_cld != null) {
            SwitchCompat switchCompat = com_fossil_cld.ctv;
            if (switchCompat != null) {
                switchCompat.setChecked(z);
            }
        }
    }

    public void cN(boolean z) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cld com_fossil_cld = (cld) com_fossil_dqo.get();
        if (com_fossil_cld != null) {
            SwitchCompat switchCompat = com_fossil_cld.ctr;
            if (switchCompat != null) {
                switchCompat.setChecked(z);
            }
        }
    }

    public void cO(boolean z) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cld com_fossil_cld = (cld) com_fossil_dqo.get();
        if (com_fossil_cld != null) {
            SwitchCompat switchCompat = com_fossil_cld.ctq;
            if (switchCompat != null) {
                switchCompat.setChecked(z);
            }
        }
    }

    public void finish() {
        getActivity().finish();
    }

    static {
        String simpleName = dfq.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
