package com.fossil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior.C1074a;
import android.support.design.widget.AppBarLayout.C1077a;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.C1092c;
import android.support.v4.app.Fragment;
import android.support.v4.widget.FossilSwipeRefreshLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.C1175b;
import android.support.v4.widget.SwipeRefreshLayout.C1191a;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C1234a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.ckg.C2146b;
import com.fossil.ckh.C2149b;
import com.fossil.dgz.C2759a;
import com.fossil.dha.C2763a;
import com.fossil.dha.C2764b;
import com.fossil.dhh.C2784a;
import com.fossil.drk.C2095b;
import com.fossil.dse.C3168a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset.MappingSetType;
import com.portfolio.platform.ui.widget.FossilTopHeaderLayout;
import com.portfolio.platform.ui.widget.PresetGroupLayout;
import com.portfolio.platform.ui.widget.PresetGroupLayout.a;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dhb extends ctn implements C1077a, OnAttachStateChangeListener, OnClickListener, C2146b, C2149b, C2764b, C2095b, a {
    public static final String TAG = dhb.class.getSimpleName();
    private RecyclerView aqI;
    private boolean cOW;
    private C2763a cTW;
    private TextView cTX;
    private TextView cTY;
    private PresetGroupLayout cTZ;
    private String cUa;
    private String cUb;
    private String cUc;
    private FossilTopHeaderLayout cUd;
    private AppBarLayout cUe;
    private int cUf;
    private boolean cUg;
    private View cUh;
    private View cUi;
    private View cUj;
    private NestedScrollView cUk;
    private GridLayoutManager cUl;
    private LinearLayoutManager cUm;
    private C3168a cUn;
    dhk cUo;
    private dhi cUp;
    private ckg cUq;
    private ckh cUr;
    private FossilSwipeRefreshLayout cUs;

    class C27661 implements cyb {
        final /* synthetic */ dhb cUt;

        C27661(dhb com_fossil_dhb) {
            this.cUt = com_fossil_dhb;
        }

        public void close() {
            this.cUt.cF(false);
            if (this.cUt.cUg) {
                this.cUt.aoy();
            }
            this.cUt.cUp.dismiss();
            this.cUt.cTW.aoh();
            this.cUt.cUg = false;
            this.cUt.cUo.aoI();
            this.cUt.cUo.aoJ();
            this.cUt.cTW.aoj();
        }
    }

    class C27672 implements OnClickListener {
        final /* synthetic */ dhb cUt;

        C27672(dhb com_fossil_dhb) {
            this.cUt = com_fossil_dhb;
        }

        public void onClick(View view) {
            this.cUt.aoE();
            this.cUt.m7519n("tooltip_dismiss", "Subject", "3rd_Device_Tooltip");
        }
    }

    class C27683 implements OnClickListener {
        final /* synthetic */ dhb cUt;

        C27683(dhb com_fossil_dhb) {
            this.cUt = com_fossil_dhb;
        }

        public void onClick(View view) {
            this.cUt.aoF();
            this.cUt.m7519n("tooltip_dismiss", "Subject", "4th_Device_Tooltip");
        }
    }

    class C27694 implements OnClickListener {
        final /* synthetic */ dhb cUt;

        C27694(dhb com_fossil_dhb) {
            this.cUt = com_fossil_dhb;
        }

        public void onClick(View view) {
        }
    }

    class C27705 implements C1175b {
        final /* synthetic */ dhb cUt;

        C27705(dhb com_fossil_dhb) {
            this.cUt = com_fossil_dhb;
        }

        public void kA() {
            int fS = PortfolioApp.ZQ().fS(PortfolioApp.ZQ().aaa());
            MFLogger.m12670d(dhb.TAG, "Inside .onRefresh currentDeviceSession=" + fS);
            if (fS == CommunicateMode.OTA.getValue()) {
                gy.m11536p(PortfolioApp.ZQ()).m11538b(new Intent("BROADCAST_DEVICE_BUSY_OTAING"));
                this.cUt.cUs.setRefreshing(false);
                return;
            }
            this.cUt.cTW.sync();
        }
    }

    class C27716 implements C1191a {
        final /* synthetic */ dhb cUt;

        C27716(dhb com_fossil_dhb) {
            this.cUt = com_fossil_dhb;
        }

        public boolean mo2248a(SwipeRefreshLayout swipeRefreshLayout, View view) {
            return li.m12271m(this.cUt.cUk, -1) || this.cUt.cOW;
        }
    }

    class C27727 implements C2759a {
        final /* synthetic */ dhb cUt;

        C27727(dhb com_fossil_dhb) {
            this.cUt = com_fossil_dhb;
        }

        public void iy(String str) {
            MFLogger.m12670d(dhb.TAG, "onSaveClick presetName=" + str);
            Map hashMap = new HashMap();
            hashMap.put("Preset_1", this.cUt.cUa);
            hashMap.put("Preset_2", this.cUt.cUb);
            hashMap.put("Preset_3", this.cUt.cUc);
            MFLogger.m12670d("Preset", hashMap.toString());
            this.cUt.m7518f("preset_save", hashMap);
            this.cUt.cTW.iz(str);
        }

        public void onCancel() {
            MFLogger.m12670d(dhb.TAG, "onCancel");
        }
    }

    class C27738 implements OnGlobalLayoutListener {
        final /* synthetic */ dhb cUt;

        C27738(dhb com_fossil_dhb) {
            this.cUt = com_fossil_dhb;
        }

        public void onGlobalLayout() {
            this.cUt.getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int[] iArr = new int[2];
            this.cUt.getView().getLocationOnScreen(iArr);
            this.cUt.cUp.lc((dqu.bR(this.cUt.getContext()) - iArr[1]) - this.cUt.getResources().getDimensionPixelSize(R.dimen.dp200));
            MFLogger.m12670d(dhb.TAG, "showMicroAppDetails - appbar height=" + this.cUt.cUe.getHeight() + " top=" + this.cUt.cUe.getX());
            if (!this.cUt.cOW) {
                this.cUt.cUg = true;
                this.cUt.aox();
            }
            dhi com_fossil_dhi = (dhi) this.cUt.getChildFragmentManager().mo3086W(dhi.TAG);
            if (com_fossil_dhi == null || !com_fossil_dhi.isShowing()) {
                this.cUt.cUp.show(this.cUt.getChildFragmentManager(), dhi.TAG);
            } else {
                this.cUt.cUo.aoM();
            }
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8587a((C2763a) obj);
    }

    public static dhb aov() {
        return new dhb();
    }

    public void m8587a(C2763a c2763a) {
        this.cTW = (C2763a) cco.ce(c2763a);
    }

    public void onCreate(Bundle bundle) {
        MFLogger.m12670d(TAG, "onCreate");
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_device, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Fragment W = getChildFragmentManager().mo3086W(dhi.TAG);
        if (W == null) {
            this.cUp = dhi.aoY();
        } else {
            this.cUp = (dhi) W;
        }
        this.cUp.m8670a(new C27661(this));
        MFLogger.m12670d(TAG, "inject");
        PortfolioApp.ZQ().aam().mo1818a(new dhl(this.cUp, new MicroApp(), getActivity().getSupportLoaderManager())).mo1761a(this);
        this.cTW.mo2407a(this.cUo);
        this.cUp.m8671a((C2784a) this.cTW);
        if (this.cUp.isShowing()) {
            this.cUp.dismiss();
        }
        MFLogger.m12670d(TAG, "end onCreate");
        this.cTX = (TextView) view.findViewById(R.id.library_tv);
        this.cTY = (TextView) view.findViewById(R.id.presets_tv);
        this.cUh = view.findViewById(R.id.select_button_tv);
        this.cUh.setOnClickListener(this);
        this.cUi = view.findViewById(R.id.saved_layout);
        this.cUd = (FossilTopHeaderLayout) view.findViewById(R.id.collapsing_toolbar);
        this.cUi.findViewById(R.id.close_iv).setOnClickListener(this);
        this.cTX.setOnClickListener(this);
        this.cTY.setOnClickListener(this);
        this.cTZ = (PresetGroupLayout) view.findViewById(R.id.presets_group);
        this.cTZ.setListener(this);
        this.cUj = view.findViewById(R.id.save_btn);
        this.cUj.setOnClickListener(this);
        this.cUe = (AppBarLayout) view.findViewById(R.id.appbar);
        this.cUe.m1755a((C1077a) this);
        cF(false);
        this.cTX.setSelected(true);
        this.cTW.setCurrentTab(0);
        this.cUk = (NestedScrollView) view.findViewById(R.id.rlBottomView);
        this.cUl = new GridLayoutManager(getContext(), 3);
        this.cUm = new LinearLayoutManager(getContext());
        this.aqI = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.aqI.setNestedScrollingEnabled(false);
        view.addOnAttachStateChangeListener(this);
        this.cUs = (FossilSwipeRefreshLayout) view.findViewById(R.id.srlPullToSync);
        this.cUs.setOnRefreshListener(new C27705(this));
        this.cUs.setOnChildScrollUpCallback(new C27716(this));
    }

    private void m8563b(String str, Pusher pusher) {
        if (m8568c(pusher)) {
            Map hashMap = new HashMap();
            hashMap.put("App", str);
            hashMap.put("Pusher", String.valueOf(pusher.ordinal() + 1));
            m7518f("microapp_drop", hashMap);
        }
    }

    private void aj(List<Pusher> list) {
        Map hashMap = new HashMap();
        for (Pusher pusher : list) {
            hashMap.clear();
            if (m8568c(pusher)) {
                int ordinal = pusher.ordinal() + 1;
                int indexOf = list.indexOf(pusher) + 1;
                if (ordinal != indexOf && ordinal > 0) {
                    hashMap.put("Original", String.valueOf(ordinal));
                    hashMap.put("Dest", String.valueOf(indexOf));
                    m7518f("pusher_reorder", hashMap);
                }
            }
        }
    }

    private boolean m8568c(Pusher pusher) {
        return pusher == Pusher.TOP_PUSHER || pusher == Pusher.MID_PUSHER || pusher == Pusher.BOTTOM_PUSHER;
    }

    public void onResume() {
        MFLogger.m12670d(TAG, "onResume");
        super.onResume();
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cTW.aoj();
        }
    }

    public void onPause() {
        super.onPause();
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cTW.stop();
            this.cTW.aol();
        }
    }

    public void onViewAttachedToWindow(View view) {
        MFLogger.m12670d(TAG, "onViewAttachedToWindow");
        this.cTW.aoj();
    }

    public void onViewDetachedFromWindow(View view) {
        MFLogger.m12670d(TAG, "onViewDetachedFromWindow");
        this.cTW.stop();
    }

    public void onClick(View view) {
        MFLogger.m12670d(TAG, "onClick");
        switch (view.getId()) {
            case R.id.close_iv:
                aoz();
                return;
            case R.id.library_tv:
                MFLogger.m12670d(TAG, "onClick library_tv");
                this.cTY.setSelected(false);
                this.cTX.setSelected(true);
                this.cTW.setCurrentTab(0);
                MFLogger.m12670d(TAG, "onClick getMicroAppGallery");
                this.cTW.cP(false);
                m7519n("shortcuts", "Source", "Onboarding");
                return;
            case R.id.presets_tv:
                MFLogger.m12670d(TAG, "onClick presets_tv");
                this.cTY.setSelected(true);
                this.cTW.setCurrentTab(1);
                this.cTX.setSelected(false);
                this.cTW.aoi();
                m7519n("presets", "Source", "Onboarding");
                return;
            case R.id.save_btn:
                MFLogger.m12670d(TAG, "onClick save_btn");
                if (getChildFragmentManager().mo3086W("NAME_YOUR_PRESET") == null) {
                    dgz a = dgz.m8541a(new C27727(this));
                    if (isActive()) {
                        a.show(getChildFragmentManager(), "NAME_YOUR_PRESET");
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void mo52a(AppBarLayout appBarLayout, int i) {
        boolean z = true;
        MFLogger.m12670d(TAG, "onOffsetChanged + verticalOffset=" + i);
        if (this.cUf == 0) {
            this.cUf = appBarLayout.getTotalScrollRange();
        }
        this.cOW = i != 0;
        if (i == 0) {
            this.cUk.smoothScrollTo(0, 0);
        } else {
            dse.hide();
        }
        PresetGroupLayout presetGroupLayout = this.cTZ;
        if (this.cOW) {
            z = false;
        }
        presetGroupLayout.dn(z);
        MFLogger.m12670d(TAG, "onOffsetChanged + maxScroll=" + this.cUf);
    }

    public void m8598d(Pusher pusher) {
        MFLogger.m12670d(TAG, "Preset onClick " + pusher.toString());
        this.cTW.mo2429b(pusher);
    }

    public boolean m8597c(String str, Pusher pusher) {
        m8563b(str, pusher);
        aoA();
        return this.cTW.mo2409a(str, pusher);
    }

    public void ak(List<Pusher> list) {
        MFLogger.m12670d(TAG, "onSwapPreset pushers[0]=" + ((Pusher) list.get(0)).getValue() + " pushers[1]=" + ((Pusher) list.get(1)).getValue() + " pushers[2]=" + ((Pusher) list.get(2)).getValue());
        aj(list);
        this.cTW.ai(list);
    }

    public void aow() {
        aoA();
    }

    public void mo2387a(MicroApp microApp, boolean z) {
        if (microApp != null && isActive()) {
            MFLogger.m12670d(TAG, "updateTopButton microAppId=" + microApp.getAppId());
            this.cTZ.getTopPreset().a(microApp.getIconUrl(), microApp.getDefaultIconId(), tx.t(this));
            this.cTZ.getTopPreset().setPresetName(microApp.getName());
            this.cUa = microApp.getAppId();
            if (z) {
                this.cTZ.getTopPreset().aug();
            }
        }
    }

    public void mo2400b(MicroApp microApp, boolean z) {
        if (microApp != null && isActive()) {
            MFLogger.m12670d(TAG, "updateMidButton microAppId=" + microApp.getAppId());
            this.cTZ.getMidPreset().a(microApp.getIconUrl(), microApp.getDefaultIconId(), tx.t(this));
            this.cTZ.getMidPreset().setPresetName(microApp.getName());
            this.cUb = microApp.getAppId();
            if (z) {
                this.cTZ.getMidPreset().aug();
            }
        }
    }

    public void mo2401c(MicroApp microApp, boolean z) {
        if (microApp != null && isActive()) {
            MFLogger.m12670d(TAG, "updateBottomButton microAppId=" + microApp.getAppId());
            this.cTZ.getBotPreset().a(microApp.getIconUrl(), microApp.getDefaultIconId(), tx.t(this));
            this.cTZ.getBotPreset().setPresetName(microApp.getName());
            this.cUc = microApp.getAppId();
            if (z) {
                this.cTZ.getBotPreset().aug();
            }
        }
    }

    public void mo2386a(MicroApp microApp, Pusher pusher) {
        MFLogger.m12670d(TAG, "showMicroAppDetails microAppId=" + microApp.getAppId());
        if (pusher != null) {
            Object obj = "";
            if (pusher.getValue().equals(Pusher.TOP_PUSHER.getValue())) {
                obj = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            } else if (pusher.getValue().equals(Pusher.MID_PUSHER.getValue())) {
                obj = "2";
            } else if (pusher.getValue().equals(Pusher.BOTTOM_PUSHER.getValue())) {
                obj = "3";
            }
            Map hashMap = new HashMap();
            hashMap.put("App", microApp.getAppId());
            hashMap.put("Pusher_Position", obj);
            hashMap.put("Source", "Shortcuts");
            m7518f("microapp", hashMap);
        }
        cF(true);
        this.cUo.m8716c(microApp);
        this.cUo.mo2435e(pusher);
        this.cUp.apa();
        this.cUp.dq(true);
        this.cUp.setCancelable(false);
        this.cUp.setDimAmount(0.0f);
        View view = getView();
        if (view == null) {
            return;
        }
        if (view.isAttachedToWindow()) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.cUp.lc((dqu.bR(getContext()) - iArr[1]) - getResources().getDimensionPixelSize(R.dimen.dp200));
            MFLogger.m12670d(TAG, "showMicroAppDetails - appbar height=" + this.cUe.getHeight() + " top=" + this.cUe.getX());
            if (!this.cOW) {
                this.cUg = true;
                aox();
            }
            dhi com_fossil_dhi = (dhi) getChildFragmentManager().mo3086W(dhi.TAG);
            if (com_fossil_dhi == null || !com_fossil_dhi.isShowing()) {
                this.cUp.show(getChildFragmentManager(), dhi.TAG);
                return;
            } else {
                this.cUo.aoM();
                return;
            }
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new C27738(this));
    }

    private void aox() {
        this.cUe.m1756a(false, true);
    }

    private void aoy() {
        this.cUe.m1756a(true, false);
    }

    private void cF(final boolean z) {
        C1092c c1092c = (C1092c) this.cUe.getLayoutParams();
        Behavior behavior = (AppBarLayout.Behavior) c1092c.fW();
        if (behavior == null) {
            behavior = new AppBarLayout.Behavior();
        }
        behavior.setDragCallback(new C1074a(this) {
            final /* synthetic */ dhb cUt;

            public boolean mo2255a(AppBarLayout appBarLayout) {
                return !z;
            }
        });
        c1092c.m1810a(behavior);
    }

    public void mo2385a(MicroApp microApp) {
        MFLogger.m12670d(TAG, "onMicroAppItemClick microAppId=" + microApp.getAppId());
        mo2386a(microApp, null);
    }

    public void mo2404d(List<MicroApp> list, List<MicroAppSetting> list2) {
        MFLogger.m12670d(TAG, "showLibrary microAppListSize=" + list.size() + ", isActive=" + isActive());
        if (isActive()) {
            if (this.cUq == null) {
                this.cUq = new ckg(list, list2, this, tx.t(this));
            } else {
                this.cUq.m6909a((List) list, (List) list2);
            }
            this.aqI.setLayoutManager(this.cUl);
            this.aqI.setAdapter(this.cUq);
        }
    }

    public void mo2390a(List<MicroApp> list, List<RecommendedPreset> list2, List<SavedPreset> list3) {
        MFLogger.m12670d(TAG, "showPresets, isActive=" + isActive());
        if (isActive()) {
            if (this.cUr == null) {
                this.cUr = new ckh(list, this, tx.t(this));
            } else {
                this.cUr.m6949M(list);
            }
            this.cUr.m6947K(list3);
            this.cUr.m6948L(list2);
            this.aqI.setLayoutManager(this.cUm);
            this.aqI.setAdapter(this.cUr);
        }
    }

    public void aom() {
        MFLogger.m12670d(TAG, "hideSelectButtonLayout");
        if (this.cUh != null) {
            this.cUh.setVisibility(8);
            this.cUh.getRootView().invalidate();
            this.cUh.getRootView().findViewById(R.id.main_content).invalidate();
        }
    }

    public void aon() {
        MFLogger.m12670d(TAG, "showSelectButtonLayout");
        this.cUh.setVisibility(0);
        this.cUh.getRootView().findViewById(R.id.main_content).invalidate();
        this.cUh.bringToFront();
    }

    public void aoo() {
        this.cTZ.aoT();
    }

    public void aop() {
        this.cTZ.aue();
    }

    public void aoq() {
        if (this.cUi != null) {
            this.cUi.setVisibility(0);
            this.cUi.bringToFront();
            new Handler().postDelayed(new Runnable(this) {
                final /* synthetic */ dhb cUt;

                {
                    this.cUt = r1;
                }

                public void run() {
                    this.cUt.aoz();
                }
            }, 2000);
        }
    }

    public void aoz() {
        if (this.cUi != null) {
            this.cUi.setVisibility(8);
        }
    }

    public void aor() {
        MFLogger.m12670d(TAG, "showToggleModeSetSuccess");
        if (isActive()) {
            dqw.m9448x(getChildFragmentManager());
        }
    }

    public void fU(String str) {
        MFLogger.m12670d(TAG, "onPresetsClick presetId=" + str);
    }

    public void mo2388a(MappingSetType mappingSetType, String str) {
        MFLogger.m12670d(TAG, "onDeletedClick mappingSetType=" + mappingSetType + "mappingSetId=" + str);
        this.cTW.mo2430b(mappingSetType, str);
    }

    public void mo2389a(String str, MappingSetType mappingSetType) {
        MFLogger.m12670d(TAG, "onSetToWatchClick");
        this.cTW.mo2431b(str, mappingSetType);
    }

    private void aoA() {
        MFLogger.m12670d(TAG, "playDraggedViewAnimation");
        C1234a adapter = this.aqI.getAdapter();
        if (adapter instanceof ckg) {
            this.cUq.abt();
        } else if (adapter instanceof ckh) {
            this.cUr.abt();
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        MFLogger.m12670d(TAG, "onDialogFragmentResult tag" + str);
        super.mo1746a(str, i, intent);
        Object obj = -1;
        switch (str.hashCode()) {
            case 1008390942:
                if (str.equals("NO_INTERNET_CONNECTION")) {
                    obj = 1;
                    break;
                }
                break;
            case 1396757004:
                if (str.equals("DEVICE_SET_DATA_FAILED")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (i == R.id.fb_help) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
                    return;
                }
                return;
            case 1:
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

    public String getTAG() {
        return TAG;
    }

    public void aos() {
        if (isActive()) {
            this.cUd.h(tx.t(this));
        }
    }

    public void aot() {
        MFLogger.m12670d(TAG, "showOnboardingConfigure");
        if (!this.cUp.isActive()) {
            aoy();
            if ((this.cUn == null || !this.cUn.isShowing()) && !this.cOW) {
                aoB();
            }
        }
    }

    private void aoB() {
        MFLogger.m12670d(TAG, "Tooltip showOnboardingConfigureOnRunnable");
        if (getView() != null && this.cTZ != null && this.cTZ.getTopPreset() != null && this.cTZ.getTopPreset().cUW != null) {
            getView().post(new Runnable(this) {
                final /* synthetic */ dhb cUt;

                class C27651 implements OnClickListener {
                    final /* synthetic */ AnonymousClass11 cUu;

                    C27651(AnonymousClass11 anonymousClass11) {
                        this.cUu = anonymousClass11;
                    }

                    public void onClick(View view) {
                        this.cUu.cUt.aoC();
                        this.cUu.cUt.m7519n("tooltip_dismiss", "Subject", "1st_Device_Tooltip");
                        this.cUu.cUt.cTW.aok();
                    }
                }

                {
                    this.cUt = r1;
                }

                public void run() {
                    this.cUt.cUn = new C3168a(this.cUt.cTZ.getTopPreset().cUW).mm(40).mi(R.string.Shortcuts_Onboarding_Configure_Text_Tap_to_edit_your_current).m9610a(R.string.Shortcuts_Onboarding_Configure_CTA_OK, new C27651(this));
                    this.cUt.cUn.show();
                }
            });
        }
    }

    private void aoC() {
        MFLogger.m12670d(TAG, "Tooltip showOnboardingReorder");
        if (this.cTZ != null && this.cTZ.getMidPreset() != null && this.cTZ.getMidPreset().cUW != null) {
            new C3168a(this.cTZ.getMidPreset().cUW).mm(40).mi(R.string.Shortcuts_Onboarding_Reorder_Text_Press_and_hold_the_button).m9610a(R.string.Shortcuts_Onboarding_Reorder_CTA_OK, new OnClickListener(this) {
                final /* synthetic */ dhb cUt;

                {
                    this.cUt = r1;
                }

                public void onClick(View view) {
                    this.cUt.aoD();
                    this.cUt.m7519n("tooltip_dismiss", "Subject", "2nd_Device_Tooltip");
                }
            }).show();
        }
    }

    private void aoD() {
        MFLogger.m12670d(TAG, "Tooltip showOnboardingDrag");
        if (this.aqI == null || this.aqI.getChildAt(0) == null || this.aqI.getChildAt(0).findViewById(R.id.feature_icon) == null) {
            aoE();
        } else {
            new C3168a(this.aqI.getChildAt(0).findViewById(R.id.feature_icon)).mm(20).mi(R.string.Shortcuts_Onboarding_Drag_Text_Tip_You_can_drag_and).mk(48).mj(8388611).ml(2).m9610a(R.string.Shortcuts_Onboarding_Drag_CTA_OK, new C27672(this)).show();
        }
    }

    private void aoE() {
        MFLogger.m12670d(TAG, "Tooltip showOnboardingSave");
        if (this.cUj != null) {
            new C3168a(this.cUj).mm(20).mi(R.string.Shortcuts_Onboarding_Save_Text_Create_custom_presets_to_cater).mk(80).mj(8388613).m9610a(R.string.Shortcuts_Onboarding_Save_CTA_OK, new C27683(this)).show();
        }
    }

    private void aoF() {
        MFLogger.m12670d(TAG, "Tooltip showOnboardingPresets");
        String format = String.format(getContext().getString(R.string.Shortcuts_Onboarding_Presets_Text_Find_Shortcut_Presets_curated_by), new Object[]{getContext().getString(R.string.brand_name)});
        if (this.cTY != null) {
            new C3168a(this.cTY).mm(-30).jy(format).mk(48).mj(8388613).ml(2).m9610a(R.string.Shortcuts_Onboarding_Presets_CTA_OK, new C27694(this)).show();
        }
    }

    public void aou() {
        MFLogger.m12670d(TAG, "showErrorSetDeviceData");
        if (isActive()) {
            dqw.m9445u(getChildFragmentManager());
        }
    }

    public void kZ(int i) {
        MFLogger.m12670d(TAG, "showErrorDialog error=" + i);
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void clearAnimation() {
        this.cTZ.clearAnimation();
    }

    public void cD(boolean z) {
        if (isActive()) {
            this.cUs.setRefreshing(z);
        }
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
