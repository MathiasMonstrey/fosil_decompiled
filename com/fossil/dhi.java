package com.fossil;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.dhh.C2784a;
import com.fossil.dhh.C2785b;
import com.fossil.drk.C2095b;
import com.fossil.drk.C3126a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.ui.view.LeftDrawableButton;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.HashMap;
import java.util.Map;

public class dhi extends drm implements OnClickListener, C2785b, C2095b {
    public static final String TAG = dhi.class.getSimpleName();
    private C2784a cUT;
    private FlexibleTextView cUU;
    private TextView cUV;
    private ImageView cUW;
    private View cUX;
    private ScrollView cUY;
    private View cUZ;
    private cyb cVa;
    private LeftDrawableButton cVb;
    private LeftDrawableButton cVc;
    private View cVd;
    dik cVe;
    dhu cVf;
    dir cVg;
    djb cVh;
    private dij cVi;
    private dht cVj;
    private diq cVk;
    private dja cVl;
    private String mMicroAppId;

    class C27861 implements AnimationListener {
        final /* synthetic */ dhi cVm;

        C27861(dhi com_fossil_dhi) {
            this.cVm = com_fossil_dhi;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (this.cVm.auV()) {
                this.cVm.cUT.aoN();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8671a((C2784a) obj);
    }

    public static dhi aoY() {
        return new dhi();
    }

    public void onCreate(Bundle bundle) {
        MFLogger.m12670d(TAG, "onCreate");
        super.onCreate(bundle);
        setShowsDialog(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_micro_app_details, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        aoZ();
        PortfolioApp.ZQ().aam().mo1819a(new dil(this.cVi, getLoaderManager()), new dhv(this.cVj), new dis(this.cVk), new dix(this.cVl)).mo1785a(this);
        this.cUT.mo2408a(this.cVe, this.cVf, this.cVg, this.cVh);
        this.cVi.m8756a(this.cUT.aoQ());
        this.cVj.m8727a(this.cUT.aoQ());
        this.cVk.m8774a(this.cUT.aoQ());
        this.cVl.m8796a(this.cUT.aoQ());
        this.cUX = view.findViewById(R.id.root_view);
        this.cUV = (TextView) view.findViewById(R.id.feature_description_tv);
        this.cUU = (FlexibleTextView) view.findViewById(R.id.micro_app_name_tv);
        this.cUW = (ImageView) view.findViewById(R.id.feature_icon);
        this.cVb = (LeftDrawableButton) view.findViewById(R.id.like_btn);
        this.cUZ = view.findViewById(R.id.overlay);
        this.cVc = (LeftDrawableButton) view.findViewById(R.id.set_to_watch_btn);
        this.cVc.setOnClickListener(this);
        view.findViewById(R.id.close_iv).setOnClickListener(this);
        this.cUY = (ScrollView) view.findViewById(R.id.scroll_view);
        this.cUY.getLayoutParams().height = aid();
        this.cUY.setSmoothScrollingEnabled(true);
        this.cVd = view.findViewById(R.id.settings_layout);
        this.cVb.setOnClickListener(this);
        this.cUZ.setOnClickListener(this);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog com_fossil_dro = new dro(getContext(), getTheme());
        com_fossil_dro.lE(aid());
        return com_fossil_dro;
    }

    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(-1, aid());
    }

    public void onResume() {
        MFLogger.m12670d(TAG, "onResume");
        super.onResume();
        this.cUT.aoM();
    }

    public void cU(boolean z) {
        boolean z2;
        boolean z3 = true;
        MFLogger.m12670d(TAG, "disableSetToWatchBtn isDisable=" + z);
        LeftDrawableButton leftDrawableButton = this.cVc;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        leftDrawableButton.setClickable(z2);
        this.cVc.setSelected(z);
        LeftDrawableButton leftDrawableButton2 = this.cVc;
        if (z) {
            z3 = false;
        }
        leftDrawableButton2.setEnabled(z3);
        this.cUT.cQ(z);
    }

    public void aoq() {
        MFLogger.m12670d(TAG, "showSavedLayout");
        this.cUT.aoq();
    }

    public void aou() {
        MFLogger.m12670d(TAG, "showErrorSetDeviceData");
        if (isActive()) {
            dqw.m9445u(getChildFragmentManager());
        }
    }

    public void lb(int i) {
        MFLogger.m12670d(TAG, "showErrorDialog");
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void onPause() {
        MFLogger.m12670d(TAG, "onPause");
        super.onPause();
        this.cUT.aoI();
    }

    public void onStop() {
        MFLogger.m12670d(TAG, "onStop");
        super.onStop();
    }

    public void m8671a(C2784a c2784a) {
        MFLogger.m12670d(TAG, "setPresenter");
        this.cUT = c2784a;
    }

    public void iC(String str) {
        MFLogger.m12670d(TAG, "showDescription description=" + str);
        this.cUV.setText(str);
    }

    public void onClick(View view) {
        MFLogger.m12670d(TAG, "onClick");
        switch (view.getId()) {
            case R.id.close_iv:
                this.cUT.aoP();
                return;
            case R.id.overlay:
                this.cUT.cR(false);
                cS(false);
                return;
            case R.id.like_btn:
                this.cUT.aoO();
                return;
            case R.id.set_to_watch_btn:
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.bouncing_animation);
                loadAnimation.setAnimationListener(new C27861(this));
                view.clearAnimation();
                view.setAnimation(loadAnimation);
                view.startAnimation(loadAnimation);
                return;
            default:
                return;
        }
    }

    private void aoZ() {
        MFLogger.m12670d(TAG, "initFragment");
        fa childFragmentManager = getChildFragmentManager();
        Fragment aF = childFragmentManager.aF(R.id.settings_layout);
        if (aF == null) {
            this.cVi = dij.apP();
            this.cVk = diq.apU();
            this.cVj = dht.apB();
            this.cVl = dja.aqf();
        } else if (aF instanceof dij) {
            this.cVi = (dij) aF;
            this.cVk = (diq) childFragmentManager.mo3086W(diq.TAG);
            this.cVj = (dht) childFragmentManager.mo3086W(dht.TAG);
            this.cVl = (dja) childFragmentManager.mo3086W(dja.TAG);
        } else if (aF instanceof diq) {
            this.cVk = (diq) aF;
            this.cVi = (dij) childFragmentManager.mo3086W(dij.TAG);
            this.cVj = (dht) childFragmentManager.mo3086W(dht.TAG);
            this.cVl = (dja) childFragmentManager.mo3086W(dja.TAG);
        } else if (aF instanceof dja) {
            this.cVl = (dja) aF;
            this.cVi = (dij) childFragmentManager.mo3086W(dij.TAG);
            this.cVj = (dht) childFragmentManager.mo3086W(dht.TAG);
            this.cVk = (diq) childFragmentManager.mo3086W(diq.TAG);
        } else {
            this.cVj = (dht) aF;
            this.cVi = (dij) childFragmentManager.mo3086W(dij.TAG);
            this.cVk = (diq) childFragmentManager.mo3086W(diq.TAG);
            this.cVl = (dja) childFragmentManager.mo3086W(dja.TAG);
        }
        if (this.cVi == null) {
            this.cVi = dij.apP();
        }
        if (this.cVj == null) {
            this.cVj = dht.apB();
        }
        if (this.cVk == null) {
            this.cVk = diq.apU();
        }
        if (this.cVl == null) {
            this.cVl = dja.aqf();
        }
    }

    public void iD(String str) {
        MFLogger.m12670d(TAG, "showCommuteSettings settings=" + str);
        this.cVd.setVisibility(0);
        boolean z = getChildFragmentManager().aF(R.id.settings_layout) instanceof dht;
        this.cVj.iK(str);
        this.cVj.setMicroAppId(this.mMicroAppId);
        if (z) {
            this.cVf.apk();
        } else {
            m7626c(this.cVj, dht.TAG, R.id.settings_layout);
        }
    }

    public void iE(String str) {
        MFLogger.m12670d(TAG, "showRingPhone ringToneName=" + str);
        this.cVd.setVisibility(0);
        boolean z = getChildFragmentManager().aF(R.id.settings_layout) instanceof diq;
        this.cVk.iK(str);
        if (z) {
            this.cVg.apt();
        } else {
            m7626c(this.cVk, diq.TAG, R.id.settings_layout);
        }
    }

    public void iF(String str) {
        MFLogger.m12670d(TAG, "showSecondTimezone timezone=" + str);
        this.cVd.setVisibility(0);
        boolean z = getChildFragmentManager().aF(R.id.settings_layout) instanceof dja;
        this.cVl.iK(str);
        if (z) {
            this.cVh.apm();
        } else {
            m7626c(this.cVl, dja.TAG, R.id.settings_layout);
        }
    }

    public void aoP() {
        MFLogger.m12670d(TAG, "closeDetailsFragment");
        if (this.cVa != null) {
            this.cVa.close();
        }
        this.cUT.aop();
        this.cUT.aom();
        this.cUT.mo2435e(null);
        this.cUT.cR(false);
    }

    public boolean aoV() {
        MFLogger.m12670d(TAG, "isDisableSetToWatch");
        return !this.cVc.isClickable();
    }

    public void mo2454d(MicroAppSetting microAppSetting) {
        MFLogger.m12670d(TAG, "showGoalTrackingRingChart timezone=" + microAppSetting);
        this.cVd.setVisibility(0);
        boolean z = getChildFragmentManager().aF(R.id.settings_layout) instanceof dij;
        this.cVi.m8758h(microAppSetting);
        this.cVe.cZ(aoV());
        if (z) {
            this.cVe.apg();
        } else {
            m7626c(this.cVi, dij.TAG, R.id.settings_layout);
        }
    }

    public void aoS() {
        MFLogger.m12670d(TAG, "hideSettings");
        this.cVd.setVisibility(8);
    }

    public void mo2453d(MicroApp microApp) {
        MFLogger.m12670d(TAG, "showMicroAppIcon microAppId=" + microApp.getAppId());
        if (this.cUU != null) {
            this.cUU.setText(microApp.getName());
        }
        if (this.cUW != null) {
            tx.t(this).ah(microApp.getIconUrl()).ew(microApp.getDefaultIconId()).c(this.cUW);
        }
        this.mMicroAppId = microApp.getAppId();
    }

    public void cS(boolean z) {
        MFLogger.m12670d(TAG, "hideOverlayLayout isSuccess=" + z);
        this.cUT.aom();
        this.cUT.aop();
        if (this.cUZ != null && this.cUZ.getVisibility() == 0) {
            this.cUZ.setVisibility(8);
            if (z) {
                this.cUT.aoq();
            } else {
                this.cUT.mo2435e(null);
            }
        }
    }

    public void aoT() {
        MFLogger.m12670d(TAG, "showOverlayLayout");
        this.cUT.aon();
        this.cUZ.setVisibility(0);
        this.cUZ.bringToFront();
        this.cUT.cR(true);
        this.cUT.aop();
    }

    public boolean aoX() {
        return this.cUZ != null && this.cUZ.getVisibility() == 0;
    }

    public void aoU() {
        MFLogger.m12670d(TAG, "showGeneralError");
        new C3126a(R.layout.dialog_one_more_thing).m9498w(R.id.one_more_thing_tv, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Drag_Drop_Warning_Title_ONE_MORE_THING)).m9498w(R.id.description_tv, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Drag_Drop_Warning_Text_Configure_the_settings_for_the)).m9498w(R.id.ok_btn, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).lB(R.id.ok_btn).m9496d(getChildFragmentManager(), "ONE_MORE_THING_TAG");
    }

    public void la(int i) {
        MFLogger.m12670d(TAG, "showLike like=" + i);
        this.cVb.setText(String.valueOf(i));
    }

    public void cT(boolean z) {
        MFLogger.m12670d(TAG, "updateLikeBtn like=" + z);
        this.cVb.setIconSelected(z);
    }

    public void m8670a(cyb com_fossil_cyb) {
        this.cVa = com_fossil_cyb;
    }

    public void apa() {
        MFLogger.m12670d(TAG, "resetDialog");
        if (this.cUY != null) {
            this.cUY.smoothScrollTo(0, 0);
        }
        this.cUT.aoJ();
    }

    public void mo1746a(String str, int i, Intent intent) {
        MFLogger.m12670d(TAG, "onDialogFragmentResult");
        super.mo1746a(str, i, intent);
        boolean z = true;
        switch (str.hashCode()) {
            case -1475127496:
                if (str.equals("ONE_MORE_THING_TAG")) {
                    z = false;
                    break;
                }
                break;
            case 305621714:
                if (str.equals("UNSAVED_CHANGES")) {
                    z = true;
                    break;
                }
                break;
            case 1008390942:
                if (str.equals("NO_INTERNET_CONNECTION")) {
                    z = true;
                    break;
                }
                break;
            case 1396757004:
                if (str.equals("DEVICE_SET_DATA_FAILED")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                switch (i) {
                    case R.id.ok_btn:
                        if (!TextUtils.isEmpty(this.mMicroAppId)) {
                            Map hashMap = new HashMap();
                            hashMap.put("Step", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                            hashMap.put("App", this.mMicroAppId);
                            m7627f("microapp_configure", hashMap);
                            break;
                        }
                        break;
                }
                cU(true);
                this.cUT.aoo();
                apb();
                return;
            case true:
                switch (i) {
                    case R.id.ok_btn:
                        aoP();
                        this.cUT.aop();
                        return;
                    default:
                        return;
                }
            case true:
                if (i == R.id.fb_help) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
                    return;
                }
                return;
            case true:
                if (i == R.id.ftv_go_to_setting) {
                    startActivity(new Intent("android.settings.SETTINGS"));
                    return;
                }
                return;
            default:
                if (isActive() && getActivity() != null) {
                    ((ctj) getActivity()).mo1746a(str, i, intent);
                    return;
                }
                return;
        }
    }

    private void apb() {
        MFLogger.m12670d(TAG, "autoFocus");
        if (this.cVd.getVisibility() == 0) {
            Fragment aF = getChildFragmentManager().aF(R.id.settings_layout);
            if (aF != null && aF.getView() != null) {
                this.cUY.smoothScrollTo(0, aF.getView().getRight());
            }
        }
    }

    public boolean lM() {
        MFLogger.m12670d(TAG, "onBackPressed");
        this.cUT.aoP();
        this.cUT.aop();
        this.cUT.aom();
        cS(false);
        return true;
    }

    public void cV(boolean z) {
        this.cVb.setClickable(z);
    }

    public void aoW() {
        MFLogger.m12670d(TAG, "reloadSettings, isFragmentActive=" + isActive() + ", isFragmentDetach=" + isDetached());
        if (isActive() && isAlive()) {
            Fragment aF = getChildFragmentManager().aF(R.id.settings_layout);
            if (aF == null) {
                return;
            }
            if (aF instanceof dht) {
                this.cVf.apk();
            } else if (aF instanceof diq) {
                this.cVg.aoW();
            } else if (aF instanceof dja) {
                this.cVh.aoW();
            } else if (aF instanceof dij) {
                this.cVe.apg();
            }
        }
    }

    public boolean isAlive() {
        boolean isDestroyed;
        String str = TAG;
        StringBuilder append = new StringBuilder().append("Inside .isAlive, isFragmentDetach=").append(isDetached()).append(", activity=").append(getActivity()).append(", isFinishing=").append(getActivity() != null ? getActivity().isFinishing() : true).append(", isDestroyed=");
        if (getActivity() != null) {
            isDestroyed = getActivity().isDestroyed();
        } else {
            isDestroyed = true;
        }
        MFLogger.m12670d(str, append.append(isDestroyed).toString());
        if (isDetached() || getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed()) {
            isDestroyed = true;
        } else {
            isDestroyed = false;
        }
        if (isDestroyed) {
            return false;
        }
        return true;
    }

    public void lc(int i) {
        super.lc(i);
        if (this.cUX != null) {
            this.cUX.getLayoutParams().height = i;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        MFLogger.m12670d(TAG, "onSaveInstanceState");
        bundle.putBoolean("IS_SELECTED_BUTTON", this.cUT.aoK());
        super.onSaveInstanceState(bundle);
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
}
