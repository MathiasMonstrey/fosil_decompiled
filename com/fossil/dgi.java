package com.fossil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.dgh.C2739a;
import com.fossil.dgh.C2740b;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.HashMap;
import java.util.Map;

public class dgi extends ctm implements OnClickListener, C2740b, C2095b {
    private ImageView cTA;
    private FlexibleTextView cTB;
    private FlexibleButton cTC;
    private C2739a cTv;
    private ImageView cTw;
    private ImageView cTx;
    private ImageView cTy;
    private ImageView cTz;

    public /* synthetic */ void cK(Object obj) {
        m8502a((C2739a) obj);
    }

    public static dgi anW() {
        return new dgi();
    }

    public void m8502a(C2739a c2739a) {
        this.cTv = (C2739a) cco.ce(c2739a);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile_support, viewGroup, false);
        this.cTw = (ImageView) inflate.findViewById(R.id.repair_center);
        this.cTx = (ImageView) inflate.findViewById(R.id.faq);
        this.cTy = (ImageView) inflate.findViewById(R.id.email_us);
        this.cTz = (ImageView) inflate.findViewById(R.id.live_chat);
        this.cTA = (ImageView) inflate.findViewById(R.id.call_us);
        this.cTB = (FlexibleTextView) inflate.findViewById(R.id.app_version);
        this.cTC = (FlexibleButton) inflate.findViewById(R.id.reset_tutorial);
        this.cTw.setOnClickListener(this);
        this.cTx.setOnClickListener(this);
        this.cTy.setOnClickListener(this);
        this.cTz.setOnClickListener(this);
        this.cTA.setOnClickListener(this);
        this.cTC.setOnClickListener(this);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cTB.setText(arp.m4318u(getContext(), R.string.Profile_Support_Text_App_Version) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + PortfolioApp.ZQ().aaf());
    }

    public void onResume() {
        super.onResume();
        this.cTv.start();
    }

    public void onPause() {
        super.onPause();
        this.cTv.stop();
    }

    public void onClick(View view) {
        Map hashMap;
        switch (view.getId()) {
            case R.id.repair_center:
                hashMap = new HashMap();
                hashMap.put("Item", "Repair_Center");
                cmj.bs(getContext()).m7085e("get_support", hashMap);
                hY(URLHelper.a(StaticPage.REPAIR_CENTER, null));
                return;
            case R.id.faq:
                hashMap = new HashMap();
                hashMap.put("Item", "FAQ");
                cmj.bs(getContext()).m7085e("get_support", hashMap);
                hY(URLHelper.a(StaticPage.SUPPORT, null));
                return;
            case R.id.email_us:
                hashMap = new HashMap();
                hashMap.put("Item", "Email_Us");
                cmj.bs(getContext()).m7085e("get_support", hashMap);
                anX();
                return;
            case R.id.live_chat:
                hashMap = new HashMap();
                hashMap.put("Item", "Live_Chat");
                cmj.bs(getContext()).m7085e("get_support", hashMap);
                hY(URLHelper.a(StaticPage.CHAT, null));
                return;
            case R.id.call_us:
                hashMap = new HashMap();
                hashMap.put("Item", "Call_Us");
                cmj.bs(getContext()).m7085e("get_support", hashMap);
                hY(URLHelper.a(StaticPage.CALL, null));
                return;
            case R.id.reset_tutorial:
                hashMap = new HashMap();
                hashMap.put("Item", "Reset_Tutorial");
                cmj.bs(getContext()).m7085e("get_support", hashMap);
                if (isActive()) {
                    dqw.m9417I(getChildFragmentManager());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void hY(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private void anX() {
        startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:fossilq@fossil.com")));
    }

    public void mo1746a(String str, int i, Intent intent) {
        if (!TextUtils.isEmpty(str)) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -1482034195:
                    if (str.equals("CONFIRM_RESET_TUTORIAL")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    switch (i) {
                        case R.id.fb_ok:
                            this.cTv.anV();
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }
}
