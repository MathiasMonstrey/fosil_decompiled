package com.fossil;

import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.model.ShineDevice;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil.BRAND;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import com.portfolio.platform.view.FlexibleTextView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ckk extends C1234a<C2155b> {
    private final tz cow;
    private List<ShineDevice> cpl = new ArrayList();
    private C2154a cpm;

    public interface C2154a {
        void mo2209a(View view, C2155b c2155b, int i);
    }

    public static class C2155b extends C1264v implements OnClickListener {
        private FlexibleTextView cpp;
        private FlexibleTextView cpq;
        private ImageView cpr;
        private C2154a cps;
        private View cpt;

        C2155b(View view, C2154a c2154a) {
            super(view);
            this.cpt = view.findViewById(R.id.scan_device_container);
            this.cpq = (FlexibleTextView) view.findViewById(R.id.ftv_device_name);
            this.cpp = (FlexibleTextView) view.findViewById(R.id.ftv_device_serial);
            this.cpr = (ImageView) view.findViewById(R.id.iv_device_image);
            this.cpt.setOnClickListener(this);
            this.cps = c2154a;
        }

        public void onClick(View view) {
            this.cps.mo2209a(view, this, rl());
        }
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m6975j(viewGroup, i);
    }

    public ckk(tz tzVar) {
        this.cow = tzVar;
    }

    public C2155b m6975j(ViewGroup viewGroup, int i) {
        return new C2155b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_scan_device, viewGroup, false), this.cpm);
    }

    public void m6973a(final C2155b c2155b, int i) {
        ShineDevice shineDevice = (ShineDevice) this.cpl.get(i);
        if (shineDevice != null && c2155b != null) {
            c2155b.cpq.setText(DeviceHelper.gg(shineDevice.getSerial()));
            c2155b.cpp.setText(shineDevice.getSerial());
            if (FossilDeviceSerialPatternUtil.getBrandBySerial(shineDevice.getSerial()) == BRAND.FOSSIL) {
                ari.Jl().ad(PortfolioApp.ZQ()).cG(shineDevice.getSerial()).cH(DeviceHelper.gi(shineDevice.getSerial())).m4283a(DeviceType.TYPE_SMALL).m4280a(c2155b.cpr, DeviceHelper.a(shineDevice.getSerial(), ImageStyle.SMALL)).m4281a(new C1856a(this) {
                    final /* synthetic */ ckk cpo;

                    public void mo1879C(String str, String str2) {
                        this.cpo.cow.l(new File(str2)).c(DiskCacheStrategy.RESULT).c(c2155b.cpr);
                    }
                }).Jm();
            } else {
                c2155b.cpr.setImageResource(R.drawable.silhouette_watch_small);
            }
        }
    }

    public void m6970O(List<ShineDevice> list) {
        this.cpl = list;
    }

    public List<ShineDevice> abu() {
        return this.cpl;
    }

    public void m6972a(C2154a c2154a) {
        this.cpm = c2154a;
    }

    public int getItemCount() {
        return this.cpl.size();
    }
}
