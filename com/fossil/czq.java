package com.fossil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.czj.C2569a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.model.ShineDevice;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.UnderlinedTextView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.parceler.Parcels;

public class czq extends ctm implements OnClickListener {
    private static final String TAG = czq.class.getSimpleName();
    private C2569a cML;
    private FlexibleButton cMM;
    private UnderlinedTextView cMN;
    private ShineDevice cMs;
    private FlexibleTextView cpp;
    private FlexibleTextView cpq;
    private ImageView cuC;

    class C25811 implements C1856a {
        final /* synthetic */ czq cMO;

        C25811(czq com_fossil_czq) {
            this.cMO = com_fossil_czq;
        }

        public void mo1879C(String str, String str2) {
            if (this.cMO.isActive()) {
                tx.t(this.cMO).l(new File(str2)).c(DiskCacheStrategy.RESULT).c(this.cMO.cuC);
            }
        }
    }

    class C25822 implements C1856a {
        final /* synthetic */ czq cMO;

        C25822(czq com_fossil_czq) {
            this.cMO = com_fossil_czq;
        }

        public void mo1879C(String str, String str2) {
            if (this.cMO.isActive()) {
                tx.t(this.cMO).l(new File(str2)).c(DiskCacheStrategy.RESULT).c(this.cMO.cuC);
            }
        }
    }

    public static czq m8034d(ShineDevice shineDevice) {
        czq com_fossil_czq = new czq();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.DEVICE, Parcels.wrap(shineDevice));
        com_fossil_czq.setArguments(bundle);
        return com_fossil_czq;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.cMs = (ShineDevice) Parcels.unwrap(getArguments().getParcelable(Constants.DEVICE));
        }
        setRetainInstance(true);
    }

    protected boolean lM() {
        this.cML.akA();
        getActivity().finish();
        return super.lM();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_closest_device, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cMM = (FlexibleButton) view.findViewById(R.id.fb_start_pairing);
        this.cpq = (FlexibleTextView) view.findViewById(R.id.ftv_device_name);
        this.cpp = (FlexibleTextView) view.findViewById(R.id.ftv_device_serial);
        this.cMN = (UnderlinedTextView) view.findViewById(R.id.ftv_dont_see_device);
        this.cuC = (ImageView) view.findViewById(R.id.iv_device_image);
        ari.Jl().ad(getContext()).cG(this.cMs.getSerial()).cH(DeviceHelper.gi(this.cMs.getSerial())).m4283a(DeviceType.TYPE_LARGE).m4280a(this.cuC, DeviceHelper.a(this.cMs.getSerial(), ImageStyle.LARGE)).m4281a(new C25811(this)).Jm();
        this.cMM.setOnClickListener(this);
        this.cMN.setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        akF();
    }

    public void m8035a(C2569a c2569a) {
        this.cML = c2569a;
    }

    private void akF() {
        if (this.cMs != null) {
            hB("device_found");
            this.cpq.setText(DeviceHelper.gg(this.cMs.getSerial()));
            this.cpp.setText(this.cMs.getSerial());
            ari.Jl().ad(PortfolioApp.ZQ()).cG(this.cMs.getSerial()).cH(DeviceHelper.gi(this.cMs.getSerial())).m4283a(DeviceType.TYPE_LARGE).m4280a(this.cuC, DeviceHelper.a(this.cMs.getSerial(), ImageStyle.LARGE)).m4281a(new C25822(this)).Jm();
            return;
        }
        MFLogger.m12671e(TAG, "Inside .onClosestDeviceFound null device!!!!");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ftv_dont_see_device:
                hB("device_not_displayed");
                this.cML.akw();
                return;
            case R.id.fb_start_pairing:
                if (this.cMs != null) {
                    String serial = this.cMs.getSerial();
                    SKUModel hl = cnq.acd().acp().hl(DeviceHelper.gi(serial));
                    if (hl != null) {
                        Map hashMap = new HashMap();
                        hashMap.put("Serial_Number", serial);
                        hashMap.put("Device_Name", hl.getDeviceName());
                        m7518f("pair_start", hashMap);
                    }
                }
                this.cML.akv();
                return;
            default:
                return;
        }
    }

    public ShineDevice aky() {
        return this.cMs;
    }
}
