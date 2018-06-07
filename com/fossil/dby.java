package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.DeletedContacts;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C1077a;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.C1175b;
import android.support.v4.widget.SwipeRefreshLayout.C1191a;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.fossil.dbv.C2637a;
import com.fossil.dbx.C2638a;
import com.fossil.dbx.C2639b;
import com.fossil.dse.C3168a;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.notifications.contactandapp.NotificationContactAndAppActivity;
import com.portfolio.platform.view.ClockView.b;
import java.util.List;

public class dby extends ctm implements OnAttachStateChangeListener, OnClickListener, C2637a, C2639b, b {
    public static final String TAG = dby.class.getSimpleName();
    private C2638a cOS;
    private dbv cOT;
    private clc cOU;
    private int cOV = -1;
    private boolean cOW;
    dqs cmT;
    cnr mSharedPreferencesManager;

    class C26401 implements C1077a {
        final /* synthetic */ dby cOX;

        C26401(dby com_fossil_dby) {
            this.cOX = com_fossil_dby;
        }

        public void mo52a(AppBarLayout appBarLayout, int i) {
            this.cOX.cOW = i != 0;
        }
    }

    class C26412 implements C1175b {
        final /* synthetic */ dby cOX;

        C26412(dby com_fossil_dby) {
            this.cOX = com_fossil_dby;
        }

        public void kA() {
            int fS = PortfolioApp.ZQ().fS(PortfolioApp.ZQ().aaa());
            MFLogger.m12670d(dby.TAG, "Inside .onRefresh currentDeviceSession=" + fS);
            if (fS == CommunicateMode.OTA.getValue()) {
                gy.m11536p(PortfolioApp.ZQ()).m11538b(new Intent("BROADCAST_DEVICE_BUSY_OTAING"));
                this.cOX.cOU.ctp.setRefreshing(false);
                return;
            }
            this.cOX.cOS.sync();
        }
    }

    class C26423 implements C1191a {
        final /* synthetic */ dby cOX;

        C26423(dby com_fossil_dby) {
            this.cOX = com_fossil_dby;
        }

        public boolean mo2248a(SwipeRefreshLayout swipeRefreshLayout, View view) {
            return li.m12271m(this.cOX.cOU.cto, -1) || this.cOX.cOW;
        }
    }

    class C26434 implements OnClickListener {
        final /* synthetic */ dby cOX;

        C26434(dby com_fossil_dby) {
            this.cOX = com_fossil_dby;
        }

        public void onClick(View view) {
            this.cOX.cOS.alt();
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8193a((C2638a) obj);
    }

    public static dby alv() {
        return new dby();
    }

    public void m8193a(C2638a c2638a) {
        this.cOS = (C2638a) cco.ce(c2638a);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cOU = (clc) C3311e.m10386a(layoutInflater, R.layout.fragment_notifications, viewGroup, false, this.cEN);
        View dz = this.cOU.dz();
        this.cOU.csL.setOnClickListener(this);
        this.cOU.csP.setOnClickListener(this);
        this.cOU.csQ.setOnClickListener(this);
        this.cOU.csR.setOnClickListener(this);
        this.cOU.csS.setOnClickListener(this);
        this.cOU.csT.setOnClickListener(this);
        this.cOU.csU.setOnClickListener(this);
        this.cOU.csV.setOnClickListener(this);
        this.cOU.csW.setOnClickListener(this);
        this.cOU.csM.setOnClickListener(this);
        this.cOU.csN.setOnClickListener(this);
        this.cOU.csO.setOnClickListener(this);
        this.cOU.csY.setOnClickListener(this);
        this.cOU.csK.m1755a(new C26401(this));
        this.cOU.ctp.setOnRefreshListener(new C26412(this));
        this.cOU.ctp.setOnChildScrollUpCallback(new C26423(this));
        PortfolioApp.ZQ().aam().mo1837a(this);
        dz.addOnAttachStateChangeListener(this);
        return dz;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Fragment W = getChildFragmentManager().mo3086W("HAND_PICKER_TAG");
        if (W == null) {
            this.cOT = new dbv();
        } else {
            this.cOT = (dbv) W;
        }
        this.cOT.ip(dby.class.getSimpleName());
        this.cOT.m8183a((C2637a) this);
        PortfolioApp.ZQ().aam().mo1807a(new dca(this)).mo1787a(this);
        if (!dre.dff.m9462a(getActivity(), "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE", "android.permission.READ_SMS")) {
            dre.dff.m9461a((Fragment) this, 2, "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE", "android.permission.READ_SMS");
        } else if (!this.mSharedPreferencesManager.ado()) {
            PortfolioApp.ZQ().getContentResolver().registerContentObserver(DeletedContacts.CONTENT_URI, false, this.cmT);
            MFLogger.m12670d(TAG, ".Inside onViewCreated, registerContentObserver ContactsContract.DeletedContacts.CONTENT_URI");
            this.mSharedPreferencesManager.ch(true);
        }
    }

    public void onResume() {
        super.onResume();
        MFLogger.m12670d(TAG, ".Inside onResume");
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cOS.start();
        }
    }

    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cOS.stop();
        }
    }

    public void onViewAttachedToWindow(View view) {
        Log.d(TAG, "onViewAttachedToWindow");
        this.cOS.start();
    }

    public void onViewDetachedFromWindow(View view) {
        Log.d(TAG, "onViewDetachedFromWindow");
        this.cOS.stop();
        this.cOV = -1;
    }

    public void mo2250b(SparseArray<List<BaseFeatureModel>> sparseArray) {
        tt c = tx.t(this).a(Integer.valueOf(R.drawable.img_avatar_branded)).tv().c(new up[]{new cmc(getContext(), getResources().getDimensionPixelSize(R.dimen.dp2), gn.m10634e(getContext(), R.color.hexEEEEEE))});
        AppCompatImageView[] appCompatImageViewArr = new AppCompatImageView[]{this.cOU.csL, this.cOU.csP, this.cOU.csQ, this.cOU.csR, this.cOU.csS, this.cOU.csT, this.cOU.csU, this.cOU.csV, this.cOU.csW, this.cOU.csM, this.cOU.csN, this.cOU.csO};
        for (int i = 0; i < appCompatImageViewArr.length; i++) {
            tx.t(this).a(new cmh()).bc(new cme((List) sparseArray.get(i + 1))).a(c).c(new up[]{new cmc(getContext())}).c(appCompatImageViewArr[i]);
        }
        switch (this.cOV) {
            case 1:
                this.cOU.csL.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 2:
                this.cOU.csP.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 3:
                this.cOU.csQ.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 4:
                this.cOU.csR.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 5:
                this.cOU.csS.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 6:
                this.cOU.csT.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 7:
                this.cOU.csU.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 8:
                this.cOU.csV.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 9:
                this.cOU.csW.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 10:
                this.cOU.csM.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 11:
                this.cOU.csN.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            case 12:
                this.cOU.csO.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation));
                return;
            default:
                return;
        }
    }

    public void alu() {
        Log.d(TAG, "showTooltip");
        if (!this.cOW) {
            new C3168a(this.cOU.csL).mm(40).mi(R.string.Notifications_Onboarding_Assign_Text_Tap_to_assign_a_contact).m9610a(R.string.Stats_Activity_Onboarding_Edit_CTA_OK, new C26434(this)).mj(8388611).mk(48).ml(2).show();
        }
    }

    public void mo1747b(int i, List<String> list) {
        super.mo1747b(i, list);
        for (String str : list) {
            Log.d(TAG, "Denied permission: " + str);
        }
        if (evb.m11255a(this, list) && getActivity() != null && isActive()) {
            dqw.m9429e(getChildFragmentManager());
        }
    }

    public void mo1745a(int i, List<String> list) {
        MFLogger.m12670d(TAG, ".Inside onPermissionsGranted");
        if (getActivity() != null && !this.mSharedPreferencesManager.ado()) {
            if (evb.m11256b(getActivity(), "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE")) {
                PortfolioApp.ZQ().getContentResolver().registerContentObserver(DeletedContacts.CONTENT_URI, false, this.cmT);
                MFLogger.m12670d(TAG, ".Inside onPermissionsGranted, registerContentObserver ContactsContract.DeletedContacts.CONTENT_URI");
                this.mSharedPreferencesManager.ch(true);
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.contact_apps_button:
                cT(view);
                cmj.bs(PortfolioApp.ZQ()).logEvent("notifications_assign_cta");
                return;
            case R.id.aciv_1:
                ks(1);
                return;
            case R.id.aciv_2:
                ks(2);
                return;
            case R.id.aciv_3:
                ks(3);
                return;
            case R.id.aciv_4:
                ks(4);
                return;
            case R.id.aciv_5:
                ks(5);
                return;
            case R.id.aciv_6:
                ks(6);
                return;
            case R.id.aciv_7:
                ks(7);
                return;
            case R.id.aciv_8:
                ks(8);
                return;
            case R.id.aciv_9:
                ks(9);
                return;
            case R.id.aciv_10:
                ks(10);
                return;
            case R.id.aciv_11:
                ks(11);
                return;
            case R.id.aciv_12:
                ks(12);
                return;
            default:
                return;
        }
    }

    public void kq(int i) {
        Log.d(TAG, "currentHour = " + i);
    }

    public String getTAG() {
        return TAG;
    }

    public void kr(int i) {
        NotificationContactAndAppActivity.a(this, i, true);
        alx();
        cmj.bs(PortfolioApp.ZQ()).m7086l("notifications_number_next", "Source", String.valueOf(i));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9876) {
            switch (i2) {
                case -1:
                    this.cOV = intent.getIntExtra("EXTRA_HAND_NUMBER", -1);
                    MFLogger.m12670d(TAG, "Inside. onActivityResult, handNumber = " + this.cOV);
                    return;
                case 0:
                    this.cOV = -1;
                    return;
                default:
                    return;
            }
        }
    }

    public void cD(boolean z) {
        if (isActive()) {
            this.cOU.ctp.setRefreshing(z);
        }
    }

    private void ks(int i) {
        Log.d(TAG, "hand_number_" + i);
        NotificationContactAndAppActivity.a(this, i, false);
        cmj.bs(PortfolioApp.ZQ()).m7086l("notitications_preview", "Source", String.valueOf(i));
    }

    private void alw() {
        this.cOT.setCurrentHour(-1);
        this.cOT.show(getChildFragmentManager(), "HAND_PICKER_TAG");
    }

    private void alx() {
        this.cOT.hide();
    }

    private void cT(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.bouncing_animation);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ dby cOX;

            public void onAnimationStart(Animation animation) {
                view.setEnabled(false);
            }

            public void onAnimationEnd(Animation animation) {
                this.cOX.alw();
                view.setEnabled(true);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.clearAnimation();
        view.startAnimation(loadAnimation);
    }
}
