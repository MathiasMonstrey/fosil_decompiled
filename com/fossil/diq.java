package com.fossil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dip.C2798a;
import com.fossil.dip.C2810b;
import com.fossil.drs.C2811a;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.data.model.Ringtone;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.ArrayList;

public class diq extends ctm implements OnClickListener, C2810b {
    public static final String TAG = diq.class.getSimpleName();
    C2798a cWx;
    private FlexibleTextView cWy;

    class C28121 implements C2811a {
        final /* synthetic */ diq cWz;

        C28121(diq com_fossil_diq) {
            this.cWz = com_fossil_diq;
        }

        public void lh(int i) {
            this.cWz.cWx.le(i);
        }

        public void li(int i) {
            ((dhk) this.cWz.cWx).cR(false);
            this.cWz.cWx.ld(i);
        }

        public void apV() {
            this.cWz.cWx.apr();
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8774a((C2798a) obj);
    }

    public void m8774a(C2798a c2798a) {
        this.cWx = c2798a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_ring_phone_settings, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cWy = (FlexibleTextView) view.findViewById(R.id.ringtone_name_tv);
        view.findViewById(R.id.ringtone_name_layout).setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        this.cWx.apt();
    }

    public void onPause() {
        super.onPause();
        this.cWx.apu();
    }

    public void onStop() {
        super.onStop();
    }

    public static diq apU() {
        return new diq();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ringtone_name_layout:
                this.cWx.apq();
                return;
            default:
                return;
        }
    }

    public void mo2507d(ArrayList<Ringtone> arrayList, int i) {
        if (getFragmentManager().mo3086W("chooseRingtone") == null) {
            drs e = drs.m9538e(arrayList, i);
            e.m9539a(new C28121(this));
            if (isActive()) {
                e.show(getFragmentManager(), "chooseRingtone");
            }
        }
    }

    public void apc() {
        ((dhk) this.cWx).apc();
    }

    public void mo2506c(Ringtone ringtone) {
        if (ringtone != null) {
            this.cWy.setText(ringtone.getName());
        }
    }

    public void iK(String str) {
        this.cWx.iI(str);
    }
}
