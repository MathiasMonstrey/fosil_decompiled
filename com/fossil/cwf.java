package com.fossil;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.cvs.C2404b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import com.portfolio.platform.ui.device.link.PairDeviceStartActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class cwf extends C1234a<C1264v> {
    Fragment cIM;
    private C2404b cIN;
    private List<DeviceModel> cIO = new ArrayList();
    private final tz cow;

    class C24323 implements OnClickListener {
        final /* synthetic */ cwf cIP;

        C24323(cwf com_fossil_cwf) {
            this.cIP = com_fossil_cwf;
        }

        public void onClick(View view) {
            cmj.bs(PortfolioApp.ZQ()).logEvent("device_add");
            PairDeviceStartActivity.bI(this.cIP.cIM.getContext());
        }
    }

    class C24334 implements OnClickListener {
        final /* synthetic */ cwf cIP;

        C24334(cwf com_fossil_cwf) {
            this.cIP = com_fossil_cwf;
        }

        public void onClick(View view) {
            cmj.bs(PortfolioApp.ZQ()).logEvent("device_not_found");
            dqw.m9447w(this.cIP.cIM.getChildFragmentManager());
        }
    }

    public static class C2436a extends C1264v {
        protected ImageView cIR;
        protected TextView cIS;
        protected TextView cIT;

        public C2436a(View view) {
            super(view);
            this.cIR = (ImageView) view.findViewById(R.id.ivDeviceImage);
            this.cIS = (TextView) view.findViewById(R.id.ftvDeviceName);
            this.cIT = (TextView) view.findViewById(R.id.ftvDeviceSerialNumber);
        }
    }

    public cwf(Fragment fragment, List<DeviceModel> list, tz tzVar) {
        this.cIM = fragment;
        this.cIO.addAll(list);
        this.cow = tzVar;
    }

    public void m7749X(List<DeviceModel> list) {
        if (this.cIO == null) {
            this.cIO = new ArrayList();
        }
        this.cIO.clear();
        this.cIO.addAll(list);
        notifyDataSetChanged();
    }

    public void m7751a(C2404b c2404b) {
        this.cIN = c2404b;
    }

    public C1264v mo1090c(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new C1264v(this, LayoutInflater.from(this.cIM.getContext()).inflate(R.layout.view_add_device_btn, viewGroup, false)) {
                    final /* synthetic */ cwf cIP;
                };
            case 2:
                return new C1264v(this, LayoutInflater.from(this.cIM.getContext()).inflate(R.layout.view_dont_see_my_device, viewGroup, false)) {
                    final /* synthetic */ cwf cIP;
                };
            default:
                return new C2436a(LayoutInflater.from(this.cIM.getContext()).inflate(R.layout.item_list_device, viewGroup, false));
        }
    }

    public void mo1089a(C1264v c1264v, int i) {
        switch (getItemViewType(i)) {
            case 0:
                final C2436a c2436a = (C2436a) c1264v;
                final String deviceId = ((DeviceModel) this.cIO.get(i)).getDeviceId();
                if (deviceId.equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                    c2436a.cIS.setTextColor(PortfolioApp.ZQ().getResources().getColor(R.color.black));
                    c2436a.cIS.setCompoundDrawablesWithIntrinsicBounds(null, null, PortfolioApp.ZQ().getResources().getDrawable(R.drawable.red_checkmark), null);
                    c2436a.cIS.setCompoundDrawablePadding(50);
                } else {
                    c2436a.cIS.setTextColor(PortfolioApp.ZQ().getResources().getColor(R.color.coolGrey));
                    c2436a.cIS.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                }
                c2436a.cIS.setText(DeviceHelper.gg(deviceId));
                c2436a.cIT.setText(deviceId);
                ari.Jl().ad(PortfolioApp.ZQ()).cG(deviceId).cH(DeviceHelper.gi(deviceId)).m4283a(DeviceType.TYPE_MID).m4280a(c2436a.cIR, DeviceHelper.a(deviceId, ImageStyle.NORMAL)).m4281a(new C1856a(this) {
                    final /* synthetic */ cwf cIP;

                    public void mo1879C(String str, String str2) {
                        this.cIP.cow.l(new File(str2)).c(DiskCacheStrategy.RESULT).c(c2436a.cIR);
                    }
                }).Jm();
                c2436a.arT.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ cwf cIP;

                    public void onClick(View view) {
                        if (this.cIP.cIN != null) {
                            this.cIP.cIN.hU(deviceId);
                        }
                    }
                });
                return;
            case 1:
                c1264v.arT.setOnClickListener(new C24323(this));
                return;
            case 2:
                c1264v.arT.setOnClickListener(new C24334(this));
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        if (i == this.cIO.size()) {
            return 1;
        }
        if (i == this.cIO.size() + 1) {
            return 2;
        }
        return 0;
    }

    public int getItemCount() {
        return this.cIO.size() + 2;
    }
}
