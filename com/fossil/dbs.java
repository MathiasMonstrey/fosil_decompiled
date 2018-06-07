package com.fossil;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.dbr.C2632a;
import com.fossil.dbr.C2633b;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.helper.ImageHelper;
import com.portfolio.platform.helper.ImageHelper.FLIP;
import com.portfolio.platform.view.NotificationConfigurationSummaryView;
import com.portfolio.platform.view.NotificationConfigurationSummaryView.a;
import java.util.List;

public class dbs extends ctm implements OnAttachStateChangeListener, C2633b, a {
    public static final String TAG = dbs.class.getSimpleName();
    private C2632a cOI;
    private NotificationConfigurationSummaryView cOJ;
    private ImageView cOa;

    class C26341 extends aaw<Bitmap> {
        final /* synthetic */ dbs cOK;

        C26341(dbs com_fossil_dbs) {
            this.cOK = com_fossil_dbs;
        }

        public void m8168a(Bitmap bitmap, aal<? super Bitmap> com_fossil_aal__super_android_graphics_Bitmap) {
            if (PortfolioApp.ZQ().getResources().getConfiguration().getLayoutDirection() == 1) {
                bitmap = ImageHelper.a(bitmap, FLIP.HORIZONTAL);
            }
            this.cOK.cOa.setImageBitmap(bitmap);
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8172a((C2632a) obj);
    }

    public static dbs alr() {
        return new dbs();
    }

    public void m8172a(C2632a c2632a) {
        this.cOI = (C2632a) cco.ce(c2632a);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home_notifications, viewGroup, false);
        this.cOJ = (NotificationConfigurationSummaryView) inflate.findViewById(R.id.ncsv_home);
        this.cOa = (ImageView) inflate.findViewById(R.id.iv_background);
        inflate.addOnAttachStateChangeListener(this);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.cOJ.setOnItemClickListener(this);
        super.onViewCreated(view, bundle);
    }

    public void onResume() {
        super.onResume();
        MFLogger.m12670d(TAG, "Inside .onResume");
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cOI.start();
        }
    }

    public void onPause() {
        super.onPause();
        MFLogger.m12670d(TAG, "Inside .onPause");
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cOI.stop();
        }
    }

    public void onViewAttachedToWindow(View view) {
        MFLogger.m12670d(TAG, "onViewAttachedToWindow");
        this.cOI.start();
    }

    public void onViewDetachedFromWindow(View view) {
        MFLogger.m12670d(TAG, "onViewDetachedFromWindow");
        this.cOI.stop();
    }

    public void alq() {
    }

    public void mo2245a(SparseArray<List<BaseFeatureModel>> sparseArray) {
        MFLogger.m12670d(TAG, "Inside .onNotificationsDataChanged allNotifications=" + sparseArray);
        this.cOJ.removeAllViews();
        for (int i = 1; i <= 12; i++) {
            this.cOJ.a(i, (List) sparseArray.get(i), tx.t(this));
        }
    }

    public void mo2247b(LandingPage landingPage) {
        MFLogger.m12670d(TAG, "Inside .onLandingPageReceived landingPageBackgroundUrl=" + landingPage.getBackgroundUrl());
        tx.t(this).ah(landingPage.getBackgroundUrl()).tA().a(DiskCacheStrategy.ALL).a(new C26341(this));
    }

    public void kp(int i) {
        cnp.acc().gu("fossilq://main/view=notifications");
        m7519n("notification", "Source", "Home");
    }

    public String getTAG() {
        return TAG;
    }
}
