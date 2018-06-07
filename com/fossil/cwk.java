package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C1243g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.cwh.C2438a;
import com.fossil.cwj.C2441a;
import com.fossil.cwj.C2442b;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.ui.device.alarm.set.AlarmSetActivity;
import com.portfolio.platform.view.SpaceItemDecoration;
import java.util.ArrayList;
import java.util.List;

public final class cwk extends ctn implements C2438a, C2442b, C2095b {
    private static final String TAG;
    private static final int cJr = 0;
    private static final int cJs = 1;
    public static final C2443a cJt = new C2443a();
    private dqo<ckr> cEY;
    private List<Alarm> cIW = new ArrayList();
    private C2441a cJp;
    private cwh cJq;
    private String mDeviceId;

    public static final class C2443a {
        private C2443a() {
        }

        public final String getTAG() {
            return cwk.TAG;
        }

        public final int aiT() {
            return cwk.cJr;
        }

        public final int aiU() {
            return cwk.cJs;
        }

        public final cwk aiV() {
            return new cwk();
        }
    }

    static final class C2444b implements OnClickListener {
        final /* synthetic */ cwk cJu;

        C2444b(cwk com_fossil_cwk) {
            this.cJu = com_fossil_cwk;
        }

        public final void onClick(View view) {
            this.cJu.getActivity().finish();
        }
    }

    static final class C2445c implements OnClickListener {
        final /* synthetic */ cwk cJu;

        C2445c(cwk com_fossil_cwk) {
            this.cJu = com_fossil_cwk;
        }

        public final void onClick(View view) {
            this.cJu.hB("alarm_add");
            AlarmSetActivity.a(this.cJu, cwk.cJt.aiT(), cwk.m7777a(this.cJu), this.cJu.cIW, null);
        }
    }

    public void mo2151a(java.util.List<com.misfit.frameworks.buttonservice.model.Alarm> r1, int r2, boolean r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.cwk.a(java.util.List, int, boolean):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 5 more
*/
        /*
        r0 = this;
        r4 = 0;
        r3 = -1;
        r0 = "alarms";
        com.fossil.esl.m11128j(r6, r0);
        r0 = cJt;
        r0 = r0.getTAG();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "showAlarms - alarms.size: ";
        r1 = r1.append(r2);
        r2 = r6.size();
        r1 = r1.append(r2);
        r2 = " - scrollPosition: ";
        r1 = r1.append(r2);
        r1 = r1.append(r7);
        r2 = " - animate: ";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r1);
        r0 = r5.cEY;
        if (r0 != 0) goto L_0x0044;
    L_0x003f:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0044:
        r0 = r0.get();
        r0 = (com.fossil.ckr) r0;
        if (r0 == 0) goto L_0x00b6;
    L_0x004c:
        r1 = r0.cqg;
        r1.setVisibility(r4);
        r1 = r5.cIW;
        r1.clear();
        r2 = r5.cIW;
        r1 = r6;
        r1 = (java.util.Collection) r1;
        r2.addAll(r1);
        r1 = r5.cJq;
        if (r1 != 0) goto L_0x0067;
    L_0x0062:
        r2 = "mAdapter";
        com.fossil.esl.mF(r2);
    L_0x0067:
        r1.notifyDataSetChanged();
        r1 = r0.cqg;
        r1 = r1.getLayoutManager();
        if (r1 != 0) goto L_0x007a;
    L_0x0072:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager";
        r0.<init>(r1);
        throw r0;
    L_0x007a:
        r1 = (android.support.v7.widget.LinearLayoutManager) r1;
        r2 = r1.po();
        r1 = r1.pq();
        if (r2 == r3) goto L_0x008c;
    L_0x0086:
        if (r1 == r3) goto L_0x008c;
    L_0x0088:
        if (r2 >= r7) goto L_0x008c;
    L_0x008a:
        if (r7 < r1) goto L_0x0097;
    L_0x008c:
        if (r8 == 0) goto L_0x00b7;
    L_0x008e:
        if (r2 == r3) goto L_0x00b7;
    L_0x0090:
        if (r1 == r3) goto L_0x00b7;
    L_0x0092:
        r1 = r0.cqg;
        r1.smoothScrollToPosition(r7);
    L_0x0097:
        r1 = r6.size();
        r2 = 32;
        if (r1 < r2) goto L_0x00bd;
    L_0x009f:
        r1 = r0.cqe;
        r1.setEnabled(r4);
        r0 = r0.cqe;
        r1 = r5.getContext();
        r2 = 2131624038; // 0x7f0e0066 float:1.8875244E38 double:1.053162207E-314;
        r1 = com.fossil.gn.m10634e(r1, r2);
        r0.setTextColor(r1);
    L_0x00b6:
        return;
    L_0x00b7:
        r1 = r0.cqg;
        r1.dg(r7);
        goto L_0x0097;
    L_0x00bd:
        r1 = r0.cqe;
        r2 = 1;
        r1.setEnabled(r2);
        r0 = r0.cqe;
        r1 = r5.getContext();
        r2 = 2131624037; // 0x7f0e0065 float:1.8875242E38 double:1.0531622065E-314;
        r1 = com.fossil.gn.m10634e(r1, r2);
        r0.setTextColor(r1);
        goto L_0x00b4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cwk.a(java.util.List, int, boolean):void");
    }

    public static final /* synthetic */ String m7777a(cwk com_fossil_cwk) {
        String str = com_fossil_cwk.mDeviceId;
        if (str == null) {
            esl.mF("mDeviceId");
        }
        return str;
    }

    public /* synthetic */ void cK(Object obj) {
        m7780a((C2441a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        esl.m11128j(layoutInflater, "inflater");
        ckr com_fossil_ckr = (ckr) C3311e.m10386a(layoutInflater, R.layout.alarm_main_fragment, viewGroup, false, this.cEN);
        cwh a = cwh.m7768a(getContext(), this.cIW, this);
        esl.m11127i(a, "AlarmMainAdapter.newInst…e(context, mAlarms, this)");
        this.cJq = a;
        com_fossil_ckr.cqg.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView = com_fossil_ckr.cqg;
        a = this.cJq;
        if (a == null) {
            esl.mF("mAdapter");
        }
        recyclerView.setAdapter(a);
        com_fossil_ckr.cqg.m1710a((C1243g) new SpaceItemDecoration(getContext(), R.dimen.dp16, true, true));
        com_fossil_ckr.cqc.setOnClickListener(new C2444b(this));
        com_fossil_ckr.cqe.setOnClickListener(new C2445c(this));
        this.cEY = new dqo(this, com_fossil_ckr);
        return com_fossil_ckr.dz();
    }

    public void onResume() {
        super.onResume();
        C2441a c2441a = this.cJp;
        if (c2441a == null) {
            esl.mF("mPresenter");
        }
        c2441a.start();
    }

    public void onPause() {
        super.onPause();
        C2441a c2441a = this.cJp;
        if (c2441a == null) {
            esl.mF("mPresenter");
        }
        c2441a.stop();
    }

    public void m7780a(C2441a c2441a) {
        esl.m11128j(c2441a, "presenter");
        this.cJp = c2441a;
    }

    public void setDeviceId(String str) {
        esl.m11128j(str, "deviceId");
        MFLogger.m12670d(cJt.getTAG(), "setDeviceId - deviceId: " + str);
        this.mDeviceId = str;
    }

    public void aiP() {
        MFLogger.m12670d(cJt.getTAG(), "showNoAlarms");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckr com_fossil_ckr = (ckr) com_fossil_dqo.get();
        if (com_fossil_ckr != null) {
            this.cIW.clear();
            cwh com_fossil_cwh = this.cJq;
            if (com_fossil_cwh == null) {
                esl.mF("mAdapter");
            }
            com_fossil_cwh.notifyDataSetChanged();
            com_fossil_ckr.cqg.setVisibility(8);
        }
    }

    public void aiQ() {
        if (isActive()) {
            dqw.m9445u(getChildFragmentManager());
        }
    }

    public void kh(int i) {
        MFLogger.m12670d(cJt.getTAG(), "onItemClick - position: " + i);
        Fragment fragment = this;
        int aiU = cJt.aiU();
        String str = this.mDeviceId;
        if (str == null) {
            esl.mF("mDeviceId");
        }
        AlarmSetActivity.a(fragment, aiU, str, this.cIW, (Alarm) this.cIW.get(i));
    }

    public void ki(int i) {
        MFLogger.m12670d(cJt.getTAG(), "onRemoveClick - position: " + i);
        C2441a c2441a = this.cJp;
        if (c2441a == null) {
            esl.mF("mPresenter");
        }
        c2441a.kj(i);
    }

    public void mo2157x(int i, boolean z) {
        MFLogger.m12670d(cJt.getTAG(), "onEnableChange - position: " + i + " - enable: " + z);
        m7519n("alarm_edit", "Action", z ? "Switch_On" : "Switch_Off");
        C2441a c2441a = this.cJp;
        if (c2441a == null) {
            esl.mF("mPresenter");
        }
        c2441a.mo2159b((Alarm) this.cIW.get(i), z);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == cJt.aiT()) {
            MFLogger.m12670d(cJt.getTAG(), "onActivityResult REQUEST_ADD_ALARM - data: " + intent);
            if (intent != null) {
                C2441a c2441a = this.cJp;
                if (c2441a == null) {
                    esl.mF("mPresenter");
                }
                c2441a.mo2160e((Alarm) intent.getParcelableExtra("RESULT_ALARM"));
                if (i2 != -1) {
                    aiQ();
                }
            }
        } else if (i == cJt.aiU()) {
            MFLogger.m12670d(cJt.getTAG(), "onActivityResult REQUEST_EDIT_ALARM - data: " + intent);
            if (intent != null) {
                C2441a c2441a2 = this.cJp;
                if (c2441a2 == null) {
                    esl.mF("mPresenter");
                }
                c2441a2.mo2158a((Alarm) intent.getParcelableExtra("RESULT_ALARM"), i2 == -1);
            }
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        switch (str.hashCode()) {
            case 1396757004:
                if (str.equals("DEVICE_SET_DATA_FAILED") && i == R.id.fb_help && isActive()) {
                    dqw.bS(getContext());
                    break;
                }
        }
        super.mo1746a(str, i, intent);
    }

    public void age() {
    }

    public void agf() {
    }

    public void agg() {
    }

    public void agh() {
    }

    public void agi() {
    }

    static {
        String simpleName = cwk.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
