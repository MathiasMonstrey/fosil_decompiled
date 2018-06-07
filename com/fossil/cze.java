package com.fossil;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.constraint.Guideline;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.cvs.C2404b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import com.portfolio.platform.view.FlexibleTextView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class cze extends ctm implements OnClickListener {
    private List<DeviceModel> cIO = new ArrayList();
    private cyb cLQ;
    private cwf cLR;
    private Guideline cLS;
    private FlexibleTextView cLT;
    private String cLU;
    private ImageView cLV;
    private C2404b cLW;

    class C25651 implements C1856a {
        final /* synthetic */ cze cLX;

        C25651(cze com_fossil_cze) {
            this.cLX = com_fossil_cze;
        }

        public void mo1879C(String str, String str2) {
            if (this.cLX.isActive()) {
                tx.t(this.cLX).l(new File(str2)).c(DiskCacheStrategy.RESULT).c(this.cLX.cLV);
            }
        }
    }

    public static cze aki() {
        return new cze();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_device_list, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cS(view);
    }

    private void cS(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list_device);
        this.cLR = new cwf(this, this.cIO, tx.t(this));
        this.cLR.m7751a(this.cLW);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.cLR);
        this.cLS = (Guideline) view.findViewById(R.id.guideline2);
        this.cLT = (FlexibleTextView) view.findViewById(R.id.ftv_device_name);
        this.cLV = (ImageView) view.findViewById(R.id.deviceButton).findViewById(R.id.iv_device_avatar);
        view.findViewById(R.id.deviceButton).setOnClickListener(this);
        view.findViewById(R.id.maskView).setOnClickListener(this);
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            LayoutParams layoutParams = (LayoutParams) this.cLS.getLayoutParams();
            layoutParams.oT = 0.63199997f;
            this.cLS.setLayoutParams(layoutParams);
        }
        ais();
    }

    public void m7966a(C2404b c2404b) {
        this.cLW = c2404b;
    }

    public void m7967a(cyb com_fossil_cyb) {
        this.cLQ = com_fossil_cyb;
    }

    public void ig(String str) {
        this.cLU = str;
        ais();
    }

    public void onStart() {
        super.onStart();
    }

    public void ais() {
        if (!(this.cLT == null || TextUtils.isEmpty(this.cLU))) {
            this.cLT.setText(DeviceHelper.gg(this.cLU));
        }
        if (this.cLR != null) {
            this.cLR.m7749X(cnq.acd().acp().adS());
        }
        if (this.cLV != null) {
            String aaa = PortfolioApp.ZQ().aaa();
            ari.Jl().ad(PortfolioApp.ZQ()).cG(aaa).cH(DeviceHelper.gi(aaa)).m4283a(DeviceType.TYPE_SMALL).m4280a(this.cLV, DeviceHelper.a(aaa, ImageStyle.SMALL)).m4281a(new C25651(this)).Jm();
        }
    }

    public void onResume() {
        super.onResume();
        ais();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.maskView:
            case R.id.deviceButton:
                if (this.cLQ != null) {
                    this.cLQ.close();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
