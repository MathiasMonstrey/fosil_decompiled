package com.fossil;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.dbn.C2623a;
import com.fossil.dbn.C2624b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.helper.ImageHelper;
import com.portfolio.platform.helper.ImageHelper.FLIP;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.HashMap;
import java.util.Map;

public class dbo extends ctm implements OnAttachStateChangeListener, C2624b {
    public static final String TAG = dbo.class.getSimpleName();
    private ImageView cOA;
    private C2623a cOo;
    private View cOp;
    private View cOq;
    private View cOr;
    private FlexibleTextView cOs;
    private FlexibleTextView cOt;
    private FlexibleTextView cOu;
    private FlexibleTextView cOv;
    private FlexibleTextView cOw;
    private FlexibleTextView cOx;
    private ImageView cOy;
    private ImageView cOz;
    private ImageView cpJ;

    class C26251 implements OnClickListener {
        final /* synthetic */ dbo cOB;

        C26251(dbo com_fossil_dbo) {
            this.cOB = com_fossil_dbo;
        }

        public void onClick(View view) {
            this.cOB.cOo.mo2243a(Pusher.TOP_PUSHER);
        }
    }

    class C26262 implements OnClickListener {
        final /* synthetic */ dbo cOB;

        C26262(dbo com_fossil_dbo) {
            this.cOB = com_fossil_dbo;
        }

        public void onClick(View view) {
            this.cOB.cOo.mo2243a(Pusher.MID_PUSHER);
        }
    }

    class C26273 implements OnClickListener {
        final /* synthetic */ dbo cOB;

        C26273(dbo com_fossil_dbo) {
            this.cOB = com_fossil_dbo;
        }

        public void onClick(View view) {
            this.cOB.cOo.mo2243a(Pusher.BOTTOM_PUSHER);
        }
    }

    class C26284 extends aaw<Bitmap> {
        final /* synthetic */ dbo cOB;

        C26284(dbo com_fossil_dbo) {
            this.cOB = com_fossil_dbo;
        }

        public void m8148a(Bitmap bitmap, aal<? super Bitmap> com_fossil_aal__super_android_graphics_Bitmap) {
            if (PortfolioApp.ZQ().getResources().getConfiguration().getLayoutDirection() == 1) {
                bitmap = ImageHelper.a(bitmap, FLIP.HORIZONTAL);
            }
            this.cOB.cpJ.setImageBitmap(bitmap);
        }
    }

    static /* synthetic */ class C26295 {
        static final /* synthetic */ int[] f1458x96782840 = new int[Pusher.values().length];

        static {
            try {
                f1458x96782840[Pusher.TOP_PUSHER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1458x96782840[Pusher.MID_PUSHER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1458x96782840[Pusher.BOTTOM_PUSHER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8153a((C2623a) obj);
    }

    public static dbo alo() {
        return new dbo();
    }

    public void m8153a(C2623a c2623a) {
        this.cOo = (C2623a) cco.ce(c2623a);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home_customized, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.addOnAttachStateChangeListener(this);
        this.cOp = view.findViewById(R.id.view_top_button);
        this.cOq = view.findViewById(R.id.view_middle_button);
        this.cOr = view.findViewById(R.id.view_bottom_button);
        this.cOs = (FlexibleTextView) this.cOp.findViewById(R.id.tv_button);
        this.cOt = (FlexibleTextView) this.cOq.findViewById(R.id.tv_button);
        this.cOu = (FlexibleTextView) this.cOr.findViewById(R.id.tv_button);
        this.cOv = (FlexibleTextView) this.cOp.findViewById(R.id.tv_feature);
        this.cOw = (FlexibleTextView) this.cOq.findViewById(R.id.tv_feature);
        this.cOx = (FlexibleTextView) this.cOr.findViewById(R.id.tv_feature);
        this.cpJ = (ImageView) view.findViewById(R.id.iv_background);
        this.cOy = (ImageView) this.cOp.findViewById(R.id.view_icon);
        this.cOz = (ImageView) this.cOq.findViewById(R.id.view_icon);
        this.cOA = (ImageView) this.cOr.findViewById(R.id.view_icon);
        this.cOs.setText(getString(R.string.Shortcuts_Landing_Label__Top_Button));
        this.cOt.setText(getString(R.string.Shortcuts_Landing_Label_Middle_Button));
        this.cOu.setText(getString(R.string.Shortcuts_Landing_Label_Bottom_Button));
        this.cOy.setOnClickListener(new C26251(this));
        this.cOz.setOnClickListener(new C26262(this));
        this.cOA.setOnClickListener(new C26273(this));
    }

    public void mo2240G(String str, int i) {
        if (i < 1 || i > 3) {
            MFLogger.m12670d(TAG, "Invalid pusher number");
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("App", str);
        hashMap.put("Pusher_Position", String.valueOf(i));
        hashMap.put("Source", "Home");
        m7518f("microapp", hashMap);
    }

    public void onResume() {
        super.onResume();
        MFLogger.m12670d(TAG, "Inside .onResume");
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cOo.start();
        }
    }

    public void onPause() {
        super.onPause();
        MFLogger.m12670d(TAG, "Inside .onPause");
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cOo.stop();
        }
    }

    public void onViewAttachedToWindow(View view) {
        MFLogger.m12670d(TAG, "onViewAttachedToWindow");
        this.cOo.start();
    }

    public void onViewDetachedFromWindow(View view) {
        MFLogger.m12670d(TAG, "onViewDetachedFromWindow");
        this.cOo.stop();
    }

    public void mo2242c(ActivePreset activePreset) {
        MFLogger.m12670d(TAG, "Inside .onActiveMappingSetChanged");
        for (ButtonMapping buttonMapping : activePreset.getButtonMappingList()) {
            Pusher pusherFromValue = Pusher.getPusherFromValue(buttonMapping.getButton());
            MicroApp fT = this.cOo.fT(buttonMapping.getMicroAppId());
            if (fT != null) {
                switch (C26295.f1458x96782840[pusherFromValue.ordinal()]) {
                    case 1:
                        this.cOv.setText(fT.getName());
                        tx.t(this).ah(fT.getIconUrl()).ew(fT.getDefaultIconId()).c(this.cOy);
                        break;
                    case 2:
                        this.cOw.setText(fT.getName());
                        tx.t(this).ah(fT.getIconUrl()).ew(fT.getDefaultIconId()).c(this.cOz);
                        break;
                    case 3:
                        this.cOx.setText(fT.getName());
                        tx.t(this).ah(fT.getIconUrl()).ew(fT.getDefaultIconId()).c(this.cOA);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void mo2241b(LandingPage landingPage) {
        MFLogger.m12670d(TAG, "Inside .onLandingPageReceived landingPageBackgroundUrl=" + landingPage.getBackgroundUrl());
        tx.t(this).ah(landingPage.getBackgroundUrl()).tA().a(DiskCacheStrategy.ALL).a(new C26284(this));
    }

    public String getTAG() {
        return TAG;
    }
}
