package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.ckk.C2154a;
import com.fossil.ckk.C2155b;
import com.fossil.czj.C2569a;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.model.ShineDevice;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.view.UnderlinedTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class czk extends ctm implements OnClickListener, C2154a, C2095b {
    private List<ShineDevice> cIO;
    private C2569a cMd;
    private RecyclerView cMk;
    private ckk cMl;
    private UnderlinedTextView cMm;

    class C25701 implements Comparator<ShineDevice> {
        final /* synthetic */ czk cMn;

        C25701(czk com_fossil_czk) {
            this.cMn = com_fossil_czk;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7980a((ShineDevice) obj, (ShineDevice) obj2);
        }

        public int m7980a(ShineDevice shineDevice, ShineDevice shineDevice2) {
            if (shineDevice != null && shineDevice2 != null) {
                return -(shineDevice.getRssi() - shineDevice2.getRssi());
            }
            if (shineDevice == null && shineDevice2 == null) {
                return 0;
            }
            if (shineDevice == null) {
                return 1;
            }
            return -1;
        }
    }

    public static czk ab(List<ShineDevice> list) {
        czk com_fossil_czk = new czk();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Constants.DEVICES, new ArrayList(list));
        com_fossil_czk.setArguments(bundle);
        return com_fossil_czk;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.cIO = getArguments().getParcelableArrayList(Constants.DEVICES);
        } else {
            this.cIO = new ArrayList();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_scan_device, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cMk = (RecyclerView) view.findViewById(R.id.rv_list_device);
        this.cMm = (UnderlinedTextView) view.findViewById(R.id.ftv_device_not_support);
        this.cMl = new ckk(tx.t(this));
        this.cMl.m6970O(this.cIO);
        this.cMk.setLayoutManager(new LinearLayoutManager(PortfolioApp.ZQ().getApplicationContext()));
        this.cMk.setAdapter(this.cMl);
        this.cMl.m6972a((C2154a) this);
        this.cMm.setOnClickListener(this);
    }

    public void m7983a(C2569a c2569a) {
        this.cMd = c2569a;
    }

    public void m7981Z(List<ShineDevice> list) {
        if (this.cMl != null) {
            Collections.sort(list, new C25701(this));
            this.cMl.m6970O(list);
            this.cMl.notifyDataSetChanged();
        }
    }

    public void mo2209a(View view, C2155b c2155b, int i) {
        this.cMd.mo2218b((ShineDevice) this.cMl.abu().get(i));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ftv_device_not_support:
                if (isActive()) {
                    dqw.m9447w(getChildFragmentManager());
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean lM() {
        this.cMd.akx();
        return true;
    }

    public void mo1746a(String str, int i, Intent intent) {
        if (getActivity() != null && (getActivity() instanceof ctj)) {
            ((ctj) getActivity()).mo1746a(str, i, intent);
        }
    }
}
